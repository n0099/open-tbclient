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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager aIn;
    private NoNetworkView bKI;
    private TbTabLayout dXf;
    private MessageFragmentPagerAdapter eXH;
    private List<MessageFragmentPagerAdapter.a> eXI;
    private ImageView eXJ;
    private MessageCenterFragment eXy;
    private NavigationBar egt;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eXy = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            x(bundle);
            y(bundle);
            z(bundle);
            this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bKI.a(this);
        }
    }

    private void x(Bundle bundle) {
        this.aIn = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eXy.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eXy.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eXy.getResources().getString(e.j.message_center_notification_tab);
        this.eXI = new ArrayList();
        this.eXI.add(aVar);
        this.eXI.add(aVar2);
        this.eXI.add(aVar3);
        this.eXH = new MessageFragmentPagerAdapter(this.eXy.getActivity().getSupportFragmentManager(), this.eXI);
        this.aIn.setAdapter(this.eXH);
        this.aIn.setOffscreenPageLimit(this.eXI.size());
        this.eXH.notifyDataSetChanged();
    }

    private void y(Bundle bundle) {
        this.dXf = (TbTabLayout) LayoutInflater.from(this.eXy.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.dXf.setupWithViewPager(this.aIn);
        int tabCount = this.dXf.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bq = this.dXf.bq(i);
                if (bq != null && !TextUtils.isEmpty(bq.getText())) {
                    if (bq.getText().equals(this.eXy.getResources().getString(e.j.message_center_message_tab))) {
                        bq.bs(1);
                    } else if (bq.getText().equals(this.eXy.getResources().getString(e.j.message_center_chat_tab))) {
                        bq.bs(2);
                    } else if (bq.getText().equals(this.eXy.getResources().getString(e.j.message_center_notification_tab))) {
                        bq.bs(3);
                    }
                }
            }
        }
    }

    private void z(Bundle bundle) {
        this.egt = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.egt.showBottomLine();
        View addSystemImageButton = this.egt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eXy != null) {
                    g.this.eXy.aTR();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eXy.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eXJ = new ImageView(this.eXy.getContext());
        this.eXJ.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.eXy.getContext(), e.C0200e.ds88), com.baidu.adp.lib.util.l.h(this.eXy.getContext(), e.C0200e.ds88)));
        this.eXJ.setScaleType(ImageView.ScaleType.CENTER);
        this.egt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eXJ, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eXy != null) {
                    g.this.eXy.aTS();
                }
            }
        });
        if (this.eXJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eXJ.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.eXy.getContext(), e.C0200e.ds14), marginLayoutParams.bottomMargin);
            this.eXJ.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.eXJ.setVisibility(0);
        } else {
            this.eXJ.setVisibility(4);
        }
        if (this.dXf != null) {
            this.egt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dXf, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dXf.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dXf.setPadding(this.dXf.getPaddingLeft(), this.dXf.getPaddingTop(), this.dXf.getPaddingRight(), this.dXf.getBottom() + com.baidu.adp.lib.util.l.h(this.eXy.getContext(), e.C0200e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dXf != null && bVar != null) {
            this.dXf.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dXf != null && bVar != null) {
            this.dXf.b(bVar);
        }
    }

    public TbTabLayout aTU() {
        return this.dXf;
    }

    public void qh(int i) {
        TbTabLayout.e qi = qi(i);
        if (qi != null) {
            qi.select();
        }
    }

    public TbTabLayout.e aTV() {
        if (this.dXf == null || this.dXf.getTabCount() <= 0) {
            return null;
        }
        return this.dXf.bq(this.dXf.getSelectedTabPosition());
    }

    public TbTabLayout.e qi(int i) {
        int tabCount;
        if (this.dXf != null && (tabCount = this.dXf.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bq = this.dXf.bq(i2);
                if (bq != null && bq.getId() != -1 && bq.getId() == i) {
                    return bq;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qj(int i) {
        int selectedTabPosition;
        TbTabLayout.e bq;
        return this.dXf != null && (selectedTabPosition = this.dXf.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dXf.getTabCount() + (-1) && (bq = this.dXf.bq(selectedTabPosition)) != null && bq.getId() == i;
    }

    public void g(int i, int i2, boolean z) {
        TbTabLayout.e qi = qi(i);
        if (qi != null) {
            qi.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.egt != null) {
            this.egt.onChangeSkinType(getPageContext(), i);
            this.egt.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dB(e.f.s_navbar_bg)).mutate());
        }
        if (this.bKI != null) {
            this.bKI.onChangeSkinType(getPageContext(), i);
        }
        if (this.eXI != null && this.eXI.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eXI.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eXI.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eXJ != null) {
            al.c(this.eXJ, e.f.selector_topbar_chat_black);
        }
        if (this.dXf != null) {
            this.dXf.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.dXf.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eXI != null && this.eXI.size() > 0 && this.aIn != null) {
            MessageFragmentPagerAdapter.a aVar = this.eXI.get(this.aIn.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aTW() {
        if (this.eXy != null && this.eXI != null && this.aIn != null && this.eXH != null) {
            FragmentManager supportFragmentManager = this.eXy.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eXI.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aIn.getId(), this.eXH.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bKI != null) {
            this.bKI.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eXH != null) {
            this.eXH.setPrimary(z);
        }
        if (this.eXI != null && this.eXI.size() > 0 && this.aIn != null) {
            MessageFragmentPagerAdapter.a aVar = this.eXI.get(this.aIn.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bE(boolean z) {
        if (this.eXI != null && this.eXI.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eXI.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eXI.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).bE(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
