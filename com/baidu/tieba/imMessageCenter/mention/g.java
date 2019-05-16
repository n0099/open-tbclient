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
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager ccQ;
    private NoNetworkView dlW;
    private List<MessageFragmentPagerAdapter.a> eSO;
    private NavigationBar eSR;
    private TbTabLayout fMG;
    private MessageCenterFragment gOW;
    private MessageFragmentPagerAdapter gPf;
    private ImageView gPg;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gOW = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dlW.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.ccQ = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gOW.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gOW.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gOW.getResources().getString(R.string.message_center_notification_tab);
        this.eSO = new ArrayList();
        this.eSO.add(aVar);
        this.eSO.add(aVar2);
        this.eSO.add(aVar3);
        this.gPf = new MessageFragmentPagerAdapter(this.gOW.getActivity().getSupportFragmentManager(), this.eSO);
        this.ccQ.setAdapter(this.gPf);
        this.ccQ.setOffscreenPageLimit(this.eSO.size());
        this.gPf.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fMG = (TbTabLayout) LayoutInflater.from(this.gOW.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fMG.setupWithViewPager(this.ccQ);
        int tabCount = this.fMG.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aV = this.fMG.aV(i);
                if (aV != null && !TextUtils.isEmpty(aV.getText())) {
                    if (aV.getText().equals(this.gOW.getResources().getString(R.string.message_center_message_tab))) {
                        aV.aX(1);
                    } else if (aV.getText().equals(this.gOW.getResources().getString(R.string.message_center_chat_tab))) {
                        aV.aX(2);
                    } else if (aV.getText().equals(this.gOW.getResources().getString(R.string.message_center_notification_tab))) {
                        aV.aX(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.eSR = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.eSR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gOW != null) {
                    g.this.gOW.bFf();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gOW.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gPg = new ImageView(this.gOW.getContext());
        this.gPg.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.g(this.gOW.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.g(this.gOW.getContext(), R.dimen.ds88)));
        this.gPg.setScaleType(ImageView.ScaleType.CENTER);
        this.eSR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gPg, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gOW != null) {
                    g.this.gOW.bFg();
                }
            }
        });
        if (this.gPg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gPg.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.g(this.gOW.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gPg.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hI().ay("android_message_can_friend_chat") == 1) {
            this.gPg.setVisibility(0);
        } else {
            this.gPg.setVisibility(4);
        }
        if (this.fMG != null) {
            this.eSR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fMG, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fMG.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fMG.setPadding(this.fMG.getPaddingLeft(), this.fMG.getPaddingTop(), this.fMG.getPaddingRight(), this.fMG.getBottom() + com.baidu.adp.lib.util.l.g(this.gOW.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fMG != null && bVar != null) {
            this.fMG.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fMG != null && bVar != null) {
            this.fMG.b(bVar);
        }
    }

    public TbTabLayout bFi() {
        return this.fMG;
    }

    public void qf(int i) {
        TbTabLayout.e vC = vC(i);
        if (vC != null) {
            vC.select();
        }
    }

    public TbTabLayout.e bFj() {
        if (this.fMG == null || this.fMG.getTabCount() <= 0) {
            return null;
        }
        return this.fMG.aV(this.fMG.getSelectedTabPosition());
    }

    public TbTabLayout.e vC(int i) {
        int tabCount;
        if (this.fMG != null && (tabCount = this.fMG.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aV = this.fMG.aV(i2);
                if (aV != null && aV.getId() != -1 && aV.getId() == i) {
                    return aV;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qg(int i) {
        int selectedTabPosition;
        TbTabLayout.e aV;
        return this.fMG != null && (selectedTabPosition = this.fMG.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fMG.getTabCount() + (-1) && (aV = this.fMG.aV(selectedTabPosition)) != null && aV.getId() == i;
    }

    public void j(int i, int i2, boolean z) {
        TbTabLayout.e vC = vC(i);
        if (vC != null) {
            vC.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eSR != null) {
            this.eSR.onChangeSkinType(getPageContext(), i);
            al.h(this.eSR.getBarBgView(), R.color.cp_bg_line_d, i);
        }
        if (this.dlW != null) {
            this.dlW.onChangeSkinType(getPageContext(), i);
        }
        if (this.eSO != null && this.eSO.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eSO.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eSO.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gPg != null) {
            al.c(this.gPg, (int) R.drawable.selector_topbar_chat_black);
        }
        if (this.fMG != null) {
            this.fMG.setSelectedTabIndicatorColor(al.getColor(R.color.cp_cont_f));
            this.fMG.setTabTextColors(al.getColor(R.color.cp_cont_j), al.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eSO != null && this.eSO.size() > 0 && this.ccQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.eSO.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bdV() {
        if (this.gOW != null && this.eSO != null && this.ccQ != null && this.gPf != null) {
            FragmentManager supportFragmentManager = this.gOW.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eSO.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ccQ.getId(), this.gPf.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dlW != null) {
            this.dlW.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gPf != null) {
            this.gPf.setPrimary(z);
        }
        if (this.eSO != null && this.eSO.size() > 0 && this.ccQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.eSO.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.eSO != null && this.eSO.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eSO.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eSO.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).el(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
