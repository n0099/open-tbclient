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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager cdT;
    private NoNetworkView dnF;
    private List<MessageFragmentPagerAdapter.a> eXP;
    private NavigationBar eXS;
    private TbTabLayout fRG;
    private MessageCenterFragment gVj;
    private MessageFragmentPagerAdapter gVt;
    private ImageView gVu;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gVj = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dnF.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.cdT = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gVj.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gVj.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gVj.getResources().getString(R.string.message_center_notification_tab);
        this.eXP = new ArrayList();
        this.eXP.add(aVar);
        this.eXP.add(aVar2);
        this.eXP.add(aVar3);
        this.gVt = new MessageFragmentPagerAdapter(this.gVj.getActivity().getSupportFragmentManager(), this.eXP);
        this.cdT.setAdapter(this.gVt);
        this.cdT.setOffscreenPageLimit(this.eXP.size());
        this.gVt.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fRG = (TbTabLayout) LayoutInflater.from(this.gVj.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fRG.setupWithViewPager(this.cdT);
        int tabCount = this.fRG.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aV = this.fRG.aV(i);
                if (aV != null && !TextUtils.isEmpty(aV.getText())) {
                    if (aV.getText().equals(this.gVj.getResources().getString(R.string.message_center_message_tab))) {
                        aV.aX(1);
                    } else if (aV.getText().equals(this.gVj.getResources().getString(R.string.message_center_chat_tab))) {
                        aV.aX(2);
                    } else if (aV.getText().equals(this.gVj.getResources().getString(R.string.message_center_notification_tab))) {
                        aV.aX(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.eXS = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.eXS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gVj != null) {
                    g.this.gVj.bHQ();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gVj.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gVu = new ImageView(this.gVj.getContext());
        this.gVu.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.g(this.gVj.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.g(this.gVj.getContext(), R.dimen.ds88)));
        this.gVu.setScaleType(ImageView.ScaleType.CENTER);
        this.eXS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gVu, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gVj != null) {
                    g.this.gVj.bHR();
                }
            }
        });
        if (this.gVu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gVu.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.g(this.gVj.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gVu.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hS().az("android_message_can_friend_chat") == 1) {
            this.gVu.setVisibility(0);
        } else {
            this.gVu.setVisibility(4);
        }
        if (this.fRG != null) {
            this.eXS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fRG, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fRG.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fRG.setPadding(this.fRG.getPaddingLeft(), this.fRG.getPaddingTop(), this.fRG.getPaddingRight(), this.fRG.getBottom() + com.baidu.adp.lib.util.l.g(this.gVj.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fRG != null && bVar != null) {
            this.fRG.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fRG != null && bVar != null) {
            this.fRG.b(bVar);
        }
    }

    public TbTabLayout bHT() {
        return this.fRG;
    }

    public void qx(int i) {
        TbTabLayout.e we = we(i);
        if (we != null) {
            we.select();
        }
    }

    public TbTabLayout.e bHU() {
        if (this.fRG == null || this.fRG.getTabCount() <= 0) {
            return null;
        }
        return this.fRG.aV(this.fRG.getSelectedTabPosition());
    }

    public TbTabLayout.e we(int i) {
        int tabCount;
        if (this.fRG != null && (tabCount = this.fRG.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aV = this.fRG.aV(i2);
                if (aV != null && aV.getId() != -1 && aV.getId() == i) {
                    return aV;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qy(int i) {
        int selectedTabPosition;
        TbTabLayout.e aV;
        return this.fRG != null && (selectedTabPosition = this.fRG.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fRG.getTabCount() + (-1) && (aV = this.fRG.aV(selectedTabPosition)) != null && aV.getId() == i;
    }

    public void k(int i, int i2, boolean z) {
        TbTabLayout.e we = we(i);
        if (we != null) {
            we.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eXS != null) {
            this.eXS.onChangeSkinType(getPageContext(), i);
            am.h(this.eXS.getBarBgView(), R.color.cp_bg_line_d, i);
        }
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(getPageContext(), i);
        }
        if (this.eXP != null && this.eXP.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eXP.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eXP.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gVu != null) {
            am.c(this.gVu, (int) R.drawable.selector_topbar_chat_black);
        }
        if (this.fRG != null) {
            this.fRG.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.fRG.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eXP != null && this.eXP.size() > 0 && this.cdT != null) {
            MessageFragmentPagerAdapter.a aVar = this.eXP.get(this.cdT.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bgb() {
        if (this.gVj != null && this.eXP != null && this.cdT != null && this.gVt != null) {
            FragmentManager supportFragmentManager = this.gVj.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eXP.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.cdT.getId(), this.gVt.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dnF != null) {
            this.dnF.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gVt != null) {
            this.gVt.setPrimary(z);
        }
        if (this.eXP != null && this.eXP.size() > 0 && this.cdT != null) {
            MessageFragmentPagerAdapter.a aVar = this.eXP.get(this.cdT.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ep(boolean z) {
        if (this.eXP != null && this.eXP.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eXP.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eXP.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).ep(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
