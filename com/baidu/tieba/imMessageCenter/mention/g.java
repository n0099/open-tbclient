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
    private NoNetworkView dlX;
    private List<MessageFragmentPagerAdapter.a> eSP;
    private NavigationBar eSS;
    private TbTabLayout fMH;
    private MessageCenterFragment gOX;
    private MessageFragmentPagerAdapter gPh;
    private ImageView gPi;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gOX = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dlX.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.ccQ = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gOX.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gOX.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gOX.getResources().getString(R.string.message_center_notification_tab);
        this.eSP = new ArrayList();
        this.eSP.add(aVar);
        this.eSP.add(aVar2);
        this.eSP.add(aVar3);
        this.gPh = new MessageFragmentPagerAdapter(this.gOX.getActivity().getSupportFragmentManager(), this.eSP);
        this.ccQ.setAdapter(this.gPh);
        this.ccQ.setOffscreenPageLimit(this.eSP.size());
        this.gPh.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fMH = (TbTabLayout) LayoutInflater.from(this.gOX.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fMH.setupWithViewPager(this.ccQ);
        int tabCount = this.fMH.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aV = this.fMH.aV(i);
                if (aV != null && !TextUtils.isEmpty(aV.getText())) {
                    if (aV.getText().equals(this.gOX.getResources().getString(R.string.message_center_message_tab))) {
                        aV.aX(1);
                    } else if (aV.getText().equals(this.gOX.getResources().getString(R.string.message_center_chat_tab))) {
                        aV.aX(2);
                    } else if (aV.getText().equals(this.gOX.getResources().getString(R.string.message_center_notification_tab))) {
                        aV.aX(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.eSS = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.eSS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gOX != null) {
                    g.this.gOX.bFi();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gOX.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gPi = new ImageView(this.gOX.getContext());
        this.gPi.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.g(this.gOX.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.g(this.gOX.getContext(), R.dimen.ds88)));
        this.gPi.setScaleType(ImageView.ScaleType.CENTER);
        this.eSS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gPi, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gOX != null) {
                    g.this.gOX.bFj();
                }
            }
        });
        if (this.gPi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gPi.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.g(this.gOX.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gPi.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hI().ay("android_message_can_friend_chat") == 1) {
            this.gPi.setVisibility(0);
        } else {
            this.gPi.setVisibility(4);
        }
        if (this.fMH != null) {
            this.eSS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fMH, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fMH.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fMH.setPadding(this.fMH.getPaddingLeft(), this.fMH.getPaddingTop(), this.fMH.getPaddingRight(), this.fMH.getBottom() + com.baidu.adp.lib.util.l.g(this.gOX.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fMH != null && bVar != null) {
            this.fMH.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fMH != null && bVar != null) {
            this.fMH.b(bVar);
        }
    }

    public TbTabLayout bFl() {
        return this.fMH;
    }

    public void qf(int i) {
        TbTabLayout.e vC = vC(i);
        if (vC != null) {
            vC.select();
        }
    }

    public TbTabLayout.e bFm() {
        if (this.fMH == null || this.fMH.getTabCount() <= 0) {
            return null;
        }
        return this.fMH.aV(this.fMH.getSelectedTabPosition());
    }

    public TbTabLayout.e vC(int i) {
        int tabCount;
        if (this.fMH != null && (tabCount = this.fMH.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aV = this.fMH.aV(i2);
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
        return this.fMH != null && (selectedTabPosition = this.fMH.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fMH.getTabCount() + (-1) && (aV = this.fMH.aV(selectedTabPosition)) != null && aV.getId() == i;
    }

    public void j(int i, int i2, boolean z) {
        TbTabLayout.e vC = vC(i);
        if (vC != null) {
            vC.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eSS != null) {
            this.eSS.onChangeSkinType(getPageContext(), i);
            al.h(this.eSS.getBarBgView(), R.color.cp_bg_line_d, i);
        }
        if (this.dlX != null) {
            this.dlX.onChangeSkinType(getPageContext(), i);
        }
        if (this.eSP != null && this.eSP.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eSP.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eSP.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gPi != null) {
            al.c(this.gPi, (int) R.drawable.selector_topbar_chat_black);
        }
        if (this.fMH != null) {
            this.fMH.setSelectedTabIndicatorColor(al.getColor(R.color.cp_cont_f));
            this.fMH.setTabTextColors(al.getColor(R.color.cp_cont_j), al.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eSP != null && this.eSP.size() > 0 && this.ccQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.eSP.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bdY() {
        if (this.gOX != null && this.eSP != null && this.ccQ != null && this.gPh != null) {
            FragmentManager supportFragmentManager = this.gOX.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eSP.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ccQ.getId(), this.gPh.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dlX != null) {
            this.dlX.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gPh != null) {
            this.gPh.setPrimary(z);
        }
        if (this.eSP != null && this.eSP.size() > 0 && this.ccQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.eSP.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.eSP != null && this.eSP.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eSP.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eSP.get(i2);
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
