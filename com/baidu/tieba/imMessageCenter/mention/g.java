package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager azQ;
    private NoNetworkView bvz;
    private TbTabLayout dHa;
    private NavigationBar dPR;
    private MessageCenterFragment eHm;
    private MessageFragmentPagerAdapter eHv;
    private List<MessageFragmentPagerAdapter.a> eHw;
    private ImageView eHx;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eHm = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            t(bundle);
            u(bundle);
            v(bundle);
            this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.bvz.a(this);
        }
    }

    private void t(Bundle bundle) {
        this.azQ = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eHm.getResources().getString(d.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eHm.getResources().getString(d.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eHm.getResources().getString(d.j.message_center_notification_tab);
        this.eHw = new ArrayList();
        this.eHw.add(aVar);
        this.eHw.add(aVar2);
        this.eHw.add(aVar3);
        this.eHv = new MessageFragmentPagerAdapter(this.eHm.getActivity().getSupportFragmentManager(), this.eHw);
        this.azQ.setAdapter(this.eHv);
        this.azQ.setOffscreenPageLimit(this.eHw.size());
        this.eHv.notifyDataSetChanged();
    }

    private void u(Bundle bundle) {
        this.dHa = (TbTabLayout) LayoutInflater.from(this.eHm.getContext()).inflate(d.h.message_center_tab_layout, (ViewGroup) null);
        this.dHa.setupWithViewPager(this.azQ);
        int tabCount = this.dHa.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aR = this.dHa.aR(i);
                if (aR != null && !TextUtils.isEmpty(aR.getText())) {
                    if (aR.getText().equals(this.eHm.getResources().getString(d.j.message_center_message_tab))) {
                        aR.aT(1);
                    } else if (aR.getText().equals(this.eHm.getResources().getString(d.j.message_center_chat_tab))) {
                        aR.aT(2);
                    } else if (aR.getText().equals(this.eHm.getResources().getString(d.j.message_center_notification_tab))) {
                        aR.aT(3);
                    }
                }
            }
        }
    }

    private void v(Bundle bundle) {
        this.dPR = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.dPR.showBottomLine();
        View addSystemImageButton = this.dPR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eHm != null) {
                    g.this.eHm.aOU();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eHm.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eHx = new ImageView(this.eHm.getContext());
        this.eHx.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.f(this.eHm.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.f(this.eHm.getContext(), d.e.ds88)));
        this.eHx.setScaleType(ImageView.ScaleType.CENTER);
        this.dPR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eHx, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eHm != null) {
                    g.this.eHm.aOV();
                }
            }
        });
        if (this.eHx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eHx.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.f(this.eHm.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.eHx.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hv().ax("android_message_can_friend_chat") == 1) {
            this.eHx.setVisibility(0);
        } else {
            this.eHx.setVisibility(4);
        }
        if (this.dHa != null) {
            this.dPR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dHa, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dHa.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dHa.setPadding(this.dHa.getPaddingLeft(), this.dHa.getPaddingTop(), this.dHa.getPaddingRight(), this.dHa.getBottom() + com.baidu.adp.lib.util.l.f(this.eHm.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dHa != null && bVar != null) {
            this.dHa.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dHa != null && bVar != null) {
            this.dHa.b(bVar);
        }
    }

    public TbTabLayout aOX() {
        return this.dHa;
    }

    public void oM(int i) {
        TbTabLayout.e oN = oN(i);
        if (oN != null) {
            oN.select();
        }
    }

    public TbTabLayout.e aOY() {
        if (this.dHa == null || this.dHa.getTabCount() <= 0) {
            return null;
        }
        return this.dHa.aR(this.dHa.getSelectedTabPosition());
    }

    public TbTabLayout.e oN(int i) {
        int tabCount;
        if (this.dHa != null && (tabCount = this.dHa.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aR = this.dHa.aR(i2);
                if (aR != null && aR.getId() != -1 && aR.getId() == i) {
                    return aR;
                }
            }
            return null;
        }
        return null;
    }

    public boolean oO(int i) {
        int selectedTabPosition;
        TbTabLayout.e aR;
        return this.dHa != null && (selectedTabPosition = this.dHa.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dHa.getTabCount() + (-1) && (aR = this.dHa.aR(selectedTabPosition)) != null && aR.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e oN = oN(i);
        if (oN != null) {
            oN.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dPR != null) {
            this.dPR.onChangeSkinType(getPageContext(), i);
            this.dPR.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)).mutate());
        }
        if (this.bvz != null) {
            this.bvz.onChangeSkinType(getPageContext(), i);
        }
        if (this.eHw != null && this.eHw.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eHw.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eHw.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eHx != null) {
            am.c(this.eHx, d.f.selector_topbar_chat_black);
        }
        if (this.dHa != null) {
            this.dHa.setSelectedTabIndicatorColor(am.getColor(d.C0140d.cp_cont_f));
            this.dHa.setTabTextColors(am.getColor(d.C0140d.cp_cont_j), am.getColor(d.C0140d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eHw != null && this.eHw.size() > 0 && this.azQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.eHw.get(this.azQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aOZ() {
        if (this.eHm != null && this.eHw != null && this.azQ != null && this.eHv != null) {
            FragmentManager supportFragmentManager = this.eHm.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eHw.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.azQ.getId(), this.eHv.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bvz != null) {
            this.bvz.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eHv != null) {
            this.eHv.setPrimary(z);
        }
        if (this.eHw != null && this.eHw.size() > 0 && this.azQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.eHw.get(this.azQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
        if (this.eHw != null && this.eHw.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eHw.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eHw.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).aQ(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
