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
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager azN;
    private NoNetworkView bvB;
    private TbTabLayout dGW;
    private NavigationBar dPN;
    private MessageCenterFragment eHh;
    private MessageFragmentPagerAdapter eHq;
    private List<MessageFragmentPagerAdapter.a> eHr;
    private ImageView eHs;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eHh = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            t(bundle);
            u(bundle);
            v(bundle);
            this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.view_no_network);
            this.bvB.a(this);
        }
    }

    private void t(Bundle bundle) {
        this.azN = (BdBaseViewPager) this.mRootView.findViewById(f.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eHh.getResources().getString(f.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eHh.getResources().getString(f.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eHh.getResources().getString(f.j.message_center_notification_tab);
        this.eHr = new ArrayList();
        this.eHr.add(aVar);
        this.eHr.add(aVar2);
        this.eHr.add(aVar3);
        this.eHq = new MessageFragmentPagerAdapter(this.eHh.getActivity().getSupportFragmentManager(), this.eHr);
        this.azN.setAdapter(this.eHq);
        this.azN.setOffscreenPageLimit(this.eHr.size());
        this.eHq.notifyDataSetChanged();
    }

    private void u(Bundle bundle) {
        this.dGW = (TbTabLayout) LayoutInflater.from(this.eHh.getContext()).inflate(f.h.message_center_tab_layout, (ViewGroup) null);
        this.dGW.setupWithViewPager(this.azN);
        int tabCount = this.dGW.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aR = this.dGW.aR(i);
                if (aR != null && !TextUtils.isEmpty(aR.getText())) {
                    if (aR.getText().equals(this.eHh.getResources().getString(f.j.message_center_message_tab))) {
                        aR.aT(1);
                    } else if (aR.getText().equals(this.eHh.getResources().getString(f.j.message_center_chat_tab))) {
                        aR.aT(2);
                    } else if (aR.getText().equals(this.eHh.getResources().getString(f.j.message_center_notification_tab))) {
                        aR.aT(3);
                    }
                }
            }
        }
    }

    private void v(Bundle bundle) {
        this.dPN = (NavigationBar) this.mRootView.findViewById(f.g.navigation_bar);
        this.dPN.showBottomLine();
        View addSystemImageButton = this.dPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eHh != null) {
                    g.this.eHh.aOR();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eHh.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eHs = new ImageView(this.eHh.getContext());
        this.eHs.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.f(this.eHh.getContext(), f.e.ds88), com.baidu.adp.lib.util.l.f(this.eHh.getContext(), f.e.ds88)));
        this.eHs.setScaleType(ImageView.ScaleType.CENTER);
        this.dPN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eHs, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eHh != null) {
                    g.this.eHh.aOS();
                }
            }
        });
        if (this.eHs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eHs.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.f(this.eHh.getContext(), f.e.ds14), marginLayoutParams.bottomMargin);
            this.eHs.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hv().ax("android_message_can_friend_chat") == 1) {
            this.eHs.setVisibility(0);
        } else {
            this.eHs.setVisibility(4);
        }
        if (this.dGW != null) {
            this.dPN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dGW, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dGW.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dGW.setPadding(this.dGW.getPaddingLeft(), this.dGW.getPaddingTop(), this.dGW.getPaddingRight(), this.dGW.getBottom() + com.baidu.adp.lib.util.l.f(this.eHh.getContext(), f.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dGW != null && bVar != null) {
            this.dGW.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dGW != null && bVar != null) {
            this.dGW.b(bVar);
        }
    }

    public TbTabLayout aOU() {
        return this.dGW;
    }

    public void oM(int i) {
        TbTabLayout.e oN = oN(i);
        if (oN != null) {
            oN.select();
        }
    }

    public TbTabLayout.e aOV() {
        if (this.dGW == null || this.dGW.getTabCount() <= 0) {
            return null;
        }
        return this.dGW.aR(this.dGW.getSelectedTabPosition());
    }

    public TbTabLayout.e oN(int i) {
        int tabCount;
        if (this.dGW != null && (tabCount = this.dGW.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aR = this.dGW.aR(i2);
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
        return this.dGW != null && (selectedTabPosition = this.dGW.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dGW.getTabCount() + (-1) && (aR = this.dGW.aR(selectedTabPosition)) != null && aR.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e oN = oN(i);
        if (oN != null) {
            oN.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dPN != null) {
            this.dPN.onChangeSkinType(getPageContext(), i);
            this.dPN.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg)).mutate());
        }
        if (this.bvB != null) {
            this.bvB.onChangeSkinType(getPageContext(), i);
        }
        if (this.eHr != null && this.eHr.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eHr.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eHr.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eHs != null) {
            am.c(this.eHs, f.C0146f.selector_topbar_chat_black);
        }
        if (this.dGW != null) {
            this.dGW.setSelectedTabIndicatorColor(am.getColor(f.d.cp_cont_f));
            this.dGW.setTabTextColors(am.getColor(f.d.cp_cont_j), am.getColor(f.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eHr != null && this.eHr.size() > 0 && this.azN != null) {
            MessageFragmentPagerAdapter.a aVar = this.eHr.get(this.azN.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aOW() {
        if (this.eHh != null && this.eHr != null && this.azN != null && this.eHq != null) {
            FragmentManager supportFragmentManager = this.eHh.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eHr.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.azN.getId(), this.eHq.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bvB != null) {
            this.bvB.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eHq != null) {
            this.eHq.setPrimary(z);
        }
        if (this.eHr != null && this.eHr.size() > 0 && this.azN != null) {
            MessageFragmentPagerAdapter.a aVar = this.eHr.get(this.azN.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aR(boolean z) {
        if (this.eHr != null && this.eHr.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eHr.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eHr.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).aR(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
