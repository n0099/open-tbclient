package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager bUS;
    private NoNetworkView dbm;
    private List<MessageFragmentPagerAdapter.a> eDn;
    private NavigationBar eDp;
    private TbTabLayout fwe;
    private MessageCenterFragment gxW;
    private MessageFragmentPagerAdapter gyf;
    private ImageView gyg;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gxW = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            K(bundle);
            L(bundle);
            M(bundle);
            this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.dbm.a(this);
        }
    }

    private void K(Bundle bundle) {
        this.bUS = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gxW.getResources().getString(d.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gxW.getResources().getString(d.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gxW.getResources().getString(d.j.message_center_notification_tab);
        this.eDn = new ArrayList();
        this.eDn.add(aVar);
        this.eDn.add(aVar2);
        this.eDn.add(aVar3);
        this.gyf = new MessageFragmentPagerAdapter(this.gxW.getActivity().getSupportFragmentManager(), this.eDn);
        this.bUS.setAdapter(this.gyf);
        this.bUS.setOffscreenPageLimit(this.eDn.size());
        this.gyf.notifyDataSetChanged();
    }

    private void L(Bundle bundle) {
        this.fwe = (TbTabLayout) LayoutInflater.from(this.gxW.getContext()).inflate(d.h.message_center_tab_layout, (ViewGroup) null);
        this.fwe.setupWithViewPager(this.bUS);
        int tabCount = this.fwe.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bd = this.fwe.bd(i);
                if (bd != null && !TextUtils.isEmpty(bd.getText())) {
                    if (bd.getText().equals(this.gxW.getResources().getString(d.j.message_center_message_tab))) {
                        bd.bf(1);
                    } else if (bd.getText().equals(this.gxW.getResources().getString(d.j.message_center_chat_tab))) {
                        bd.bf(2);
                    } else if (bd.getText().equals(this.gxW.getResources().getString(d.j.message_center_notification_tab))) {
                        bd.bf(3);
                    }
                }
            }
        }
    }

    private void M(Bundle bundle) {
        this.eDp = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        View addSystemImageButton = this.eDp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gxW != null) {
                    g.this.gxW.bxA();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gxW.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gyg = new ImageView(this.gxW.getContext());
        this.gyg.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.gxW.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.h(this.gxW.getContext(), d.e.ds88)));
        this.gyg.setScaleType(ImageView.ScaleType.CENTER);
        this.eDp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gyg, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gxW != null) {
                    g.this.gxW.bxB();
                }
            }
        });
        if (this.gyg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gyg.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.gxW.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.gyg.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.gyg.setVisibility(0);
        } else {
            this.gyg.setVisibility(4);
        }
        if (this.fwe != null) {
            this.eDp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fwe, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fwe.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fwe.setPadding(this.fwe.getPaddingLeft(), this.fwe.getPaddingTop(), this.fwe.getPaddingRight(), this.fwe.getBottom() + com.baidu.adp.lib.util.l.h(this.gxW.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fwe != null && bVar != null) {
            this.fwe.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fwe != null && bVar != null) {
            this.fwe.b(bVar);
        }
    }

    public TbTabLayout bxD() {
        return this.fwe;
    }

    public void pf(int i) {
        TbTabLayout.e uz = uz(i);
        if (uz != null) {
            uz.select();
        }
    }

    public TbTabLayout.e bxE() {
        if (this.fwe == null || this.fwe.getTabCount() <= 0) {
            return null;
        }
        return this.fwe.bd(this.fwe.getSelectedTabPosition());
    }

    public TbTabLayout.e uz(int i) {
        int tabCount;
        if (this.fwe != null && (tabCount = this.fwe.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bd = this.fwe.bd(i2);
                if (bd != null && bd.getId() != -1 && bd.getId() == i) {
                    return bd;
                }
            }
            return null;
        }
        return null;
    }

    public boolean pg(int i) {
        int selectedTabPosition;
        TbTabLayout.e bd;
        return this.fwe != null && (selectedTabPosition = this.fwe.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fwe.getTabCount() + (-1) && (bd = this.fwe.bd(selectedTabPosition)) != null && bd.getId() == i;
    }

    public void h(int i, int i2, boolean z) {
        TbTabLayout.e uz = uz(i);
        if (uz != null) {
            uz.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eDp != null) {
            this.eDp.onChangeSkinType(getPageContext(), i);
            al.f(this.eDp.getBarBgView(), d.C0277d.cp_bg_line_d, i);
        }
        if (this.dbm != null) {
            this.dbm.onChangeSkinType(getPageContext(), i);
        }
        if (this.eDn != null && this.eDn.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eDn.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eDn.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gyg != null) {
            al.c(this.gyg, d.f.selector_topbar_chat_black);
        }
        if (this.fwe != null) {
            this.fwe.setSelectedTabIndicatorColor(al.getColor(d.C0277d.cp_cont_f));
            this.fwe.setTabTextColors(al.getColor(d.C0277d.cp_cont_j), al.getColor(d.C0277d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eDn != null && this.eDn.size() > 0 && this.bUS != null) {
            MessageFragmentPagerAdapter.a aVar = this.eDn.get(this.bUS.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aWK() {
        if (this.gxW != null && this.eDn != null && this.bUS != null && this.gyf != null) {
            FragmentManager supportFragmentManager = this.gxW.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eDn.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.bUS.getId(), this.gyf.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dbm != null) {
            this.dbm.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gyf != null) {
            this.gyf.setPrimary(z);
        }
        if (this.eDn != null && this.eDn.size() > 0 && this.bUS != null) {
            MessageFragmentPagerAdapter.a aVar = this.eDn.get(this.bUS.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.eDn != null && this.eDn.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eDn.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eDn.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).dP(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
