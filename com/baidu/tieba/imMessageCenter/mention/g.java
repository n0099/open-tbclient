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
    private BdBaseViewPager bUR;
    private NoNetworkView dbq;
    private List<MessageFragmentPagerAdapter.a> eDr;
    private NavigationBar eDt;
    private TbTabLayout fwf;
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
            this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.dbq.a(this);
        }
    }

    private void K(Bundle bundle) {
        this.bUR = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gxW.getResources().getString(d.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gxW.getResources().getString(d.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gxW.getResources().getString(d.j.message_center_notification_tab);
        this.eDr = new ArrayList();
        this.eDr.add(aVar);
        this.eDr.add(aVar2);
        this.eDr.add(aVar3);
        this.gyf = new MessageFragmentPagerAdapter(this.gxW.getActivity().getSupportFragmentManager(), this.eDr);
        this.bUR.setAdapter(this.gyf);
        this.bUR.setOffscreenPageLimit(this.eDr.size());
        this.gyf.notifyDataSetChanged();
    }

    private void L(Bundle bundle) {
        this.fwf = (TbTabLayout) LayoutInflater.from(this.gxW.getContext()).inflate(d.h.message_center_tab_layout, (ViewGroup) null);
        this.fwf.setupWithViewPager(this.bUR);
        int tabCount = this.fwf.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bd = this.fwf.bd(i);
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
        this.eDt = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        View addSystemImageButton = this.eDt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
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
        this.eDt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gyg, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
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
        if (this.fwf != null) {
            this.eDt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fwf, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fwf.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fwf.setPadding(this.fwf.getPaddingLeft(), this.fwf.getPaddingTop(), this.fwf.getPaddingRight(), this.fwf.getBottom() + com.baidu.adp.lib.util.l.h(this.gxW.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fwf != null && bVar != null) {
            this.fwf.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fwf != null && bVar != null) {
            this.fwf.b(bVar);
        }
    }

    public TbTabLayout bxD() {
        return this.fwf;
    }

    public void pf(int i) {
        TbTabLayout.e uz = uz(i);
        if (uz != null) {
            uz.select();
        }
    }

    public TbTabLayout.e bxE() {
        if (this.fwf == null || this.fwf.getTabCount() <= 0) {
            return null;
        }
        return this.fwf.bd(this.fwf.getSelectedTabPosition());
    }

    public TbTabLayout.e uz(int i) {
        int tabCount;
        if (this.fwf != null && (tabCount = this.fwf.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bd = this.fwf.bd(i2);
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
        return this.fwf != null && (selectedTabPosition = this.fwf.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fwf.getTabCount() + (-1) && (bd = this.fwf.bd(selectedTabPosition)) != null && bd.getId() == i;
    }

    public void h(int i, int i2, boolean z) {
        TbTabLayout.e uz = uz(i);
        if (uz != null) {
            uz.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eDt != null) {
            this.eDt.onChangeSkinType(getPageContext(), i);
            al.f(this.eDt.getBarBgView(), d.C0236d.cp_bg_line_d, i);
        }
        if (this.dbq != null) {
            this.dbq.onChangeSkinType(getPageContext(), i);
        }
        if (this.eDr != null && this.eDr.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eDr.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eDr.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gyg != null) {
            al.c(this.gyg, d.f.selector_topbar_chat_black);
        }
        if (this.fwf != null) {
            this.fwf.setSelectedTabIndicatorColor(al.getColor(d.C0236d.cp_cont_f));
            this.fwf.setTabTextColors(al.getColor(d.C0236d.cp_cont_j), al.getColor(d.C0236d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eDr != null && this.eDr.size() > 0 && this.bUR != null) {
            MessageFragmentPagerAdapter.a aVar = this.eDr.get(this.bUR.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aWK() {
        if (this.gxW != null && this.eDr != null && this.bUR != null && this.gyf != null) {
            FragmentManager supportFragmentManager = this.gxW.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eDr.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.bUR.getId(), this.gyf.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dbq != null) {
            this.dbq.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gyf != null) {
            this.gyf.setPrimary(z);
        }
        if (this.eDr != null && this.eDr.size() > 0 && this.bUR != null) {
            MessageFragmentPagerAdapter.a aVar = this.eDr.get(this.bUR.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.eDr != null && this.eDr.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eDr.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eDr.get(i2);
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
