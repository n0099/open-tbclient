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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager azf;
    private NoNetworkView btu;
    private TbTabLayout dBc;
    private NavigationBar dJM;
    private MessageCenterFragment ezC;
    private MessageFragmentPagerAdapter ezL;
    private List<MessageFragmentPagerAdapter.a> ezM;
    private ImageView ezN;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.ezC = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            t(bundle);
            u(bundle);
            v(bundle);
            this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.btu.a(this);
        }
    }

    private void t(Bundle bundle) {
        this.azf = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.ezC.getResources().getString(d.k.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.ezC.getResources().getString(d.k.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.ezC.getResources().getString(d.k.message_center_notification_tab);
        this.ezM = new ArrayList();
        this.ezM.add(aVar);
        this.ezM.add(aVar2);
        this.ezM.add(aVar3);
        this.ezL = new MessageFragmentPagerAdapter(this.ezC.getActivity().getSupportFragmentManager(), this.ezM);
        this.azf.setAdapter(this.ezL);
        this.azf.setOffscreenPageLimit(this.ezM.size());
        this.ezL.notifyDataSetChanged();
    }

    private void u(Bundle bundle) {
        this.dBc = (TbTabLayout) LayoutInflater.from(this.ezC.getContext()).inflate(d.i.message_center_tab_layout, (ViewGroup) null);
        this.dBc.setupWithViewPager(this.azf);
        int tabCount = this.dBc.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aQ = this.dBc.aQ(i);
                if (aQ != null && !TextUtils.isEmpty(aQ.getText())) {
                    if (aQ.getText().equals(this.ezC.getResources().getString(d.k.message_center_message_tab))) {
                        aQ.aS(1);
                    } else if (aQ.getText().equals(this.ezC.getResources().getString(d.k.message_center_chat_tab))) {
                        aQ.aS(2);
                    } else if (aQ.getText().equals(this.ezC.getResources().getString(d.k.message_center_notification_tab))) {
                        aQ.aS(3);
                    }
                }
            }
        }
    }

    private void v(Bundle bundle) {
        this.dJM = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.dJM.showBottomLine();
        View addSystemImageButton = this.dJM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ezC != null) {
                    g.this.ezC.aNo();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.ezC.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.ezN = new ImageView(this.ezC.getContext());
        this.ezN.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.e(this.ezC.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.e(this.ezC.getContext(), d.e.ds88)));
        this.ezN.setScaleType(ImageView.ScaleType.CENTER);
        this.dJM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ezN, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ezC != null) {
                    g.this.ezC.aNp();
                }
            }
        });
        if (this.ezN.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ezN.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.e(this.ezC.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.ezN.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hv().aw("android_message_can_friend_chat") == 1) {
            this.ezN.setVisibility(0);
        } else {
            this.ezN.setVisibility(4);
        }
        if (this.dBc != null) {
            this.dJM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dBc, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dBc.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dBc.setPadding(this.dBc.getPaddingLeft(), this.dBc.getPaddingTop(), this.dBc.getPaddingRight(), this.dBc.getBottom() + com.baidu.adp.lib.util.l.e(this.ezC.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dBc != null && bVar != null) {
            this.dBc.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dBc != null && bVar != null) {
            this.dBc.b(bVar);
        }
    }

    public TbTabLayout aNr() {
        return this.dBc;
    }

    public void selectTab(int i) {
        TbTabLayout.e or = or(i);
        if (or != null) {
            or.select();
        }
    }

    public TbTabLayout.e aNs() {
        if (this.dBc == null || this.dBc.getTabCount() <= 0) {
            return null;
        }
        return this.dBc.aQ(this.dBc.getSelectedTabPosition());
    }

    public TbTabLayout.e or(int i) {
        int tabCount;
        if (this.dBc != null && (tabCount = this.dBc.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aQ = this.dBc.aQ(i2);
                if (aQ != null && aQ.getId() != -1 && aQ.getId() == i) {
                    return aQ;
                }
            }
            return null;
        }
        return null;
    }

    public boolean os(int i) {
        int selectedTabPosition;
        TbTabLayout.e aQ;
        return this.dBc != null && (selectedTabPosition = this.dBc.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dBc.getTabCount() + (-1) && (aQ = this.dBc.aQ(selectedTabPosition)) != null && aQ.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e or = or(i);
        if (or != null) {
            or.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dJM != null) {
            this.dJM.onChangeSkinType(getPageContext(), i);
            this.dJM.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.cR(d.f.s_navbar_bg)).mutate());
        }
        if (this.btu != null) {
            this.btu.onChangeSkinType(getPageContext(), i);
        }
        if (this.ezM != null && this.ezM.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.ezM.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.ezM.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.ezN != null) {
            al.c(this.ezN, d.f.selector_topbar_chat_black);
        }
        if (this.dBc != null) {
            this.dBc.setSelectedTabIndicatorColor(al.getColor(d.C0141d.cp_cont_f));
            this.dBc.setTabTextColors(al.getColor(d.C0141d.cp_cont_j), al.getColor(d.C0141d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ezM != null && this.ezM.size() > 0 && this.azf != null) {
            MessageFragmentPagerAdapter.a aVar = this.ezM.get(this.azf.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aNt() {
        if (this.ezC != null && this.ezM != null && this.azf != null && this.ezL != null) {
            FragmentManager supportFragmentManager = this.ezC.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.ezM.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.azf.getId(), this.ezL.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.btu != null) {
            this.btu.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.ezL != null) {
            this.ezL.setPrimary(z);
        }
        if (this.ezM != null && this.ezM.size() > 0 && this.azf != null) {
            MessageFragmentPagerAdapter.a aVar = this.ezM.get(this.azf.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
        if (this.ezM != null && this.ezM.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ezM.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.ezM.get(i2);
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
