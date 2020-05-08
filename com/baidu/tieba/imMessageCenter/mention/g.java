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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dKT;
    private NoNetworkView ePq;
    private List<MessageFragmentPagerAdapter.a> gBF;
    private NavigationBar gBK;
    private TbTabLayout gCN;
    private MessageFragmentPagerAdapter iAE;
    private ImageView iAF;
    private MessageCenterFragment iAu;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.iAu = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.ePq.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dKT = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.iAu.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.iAu.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.iAu.getResources().getString(R.string.message_center_notification_tab);
        this.gBF = new ArrayList();
        this.gBF.add(aVar);
        this.gBF.add(aVar2);
        this.gBF.add(aVar3);
        this.iAE = new MessageFragmentPagerAdapter(this.iAu.getActivity().getSupportFragmentManager(), this.gBF);
        this.dKT.setAdapter(this.iAE);
        this.dKT.setOffscreenPageLimit(this.gBF.size());
        this.iAE.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gCN = (TbTabLayout) LayoutInflater.from(this.iAu.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gCN.setupWithViewPager(this.dKT);
        int tabCount = this.gCN.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aE = this.gCN.aE(i);
                if (aE != null && !TextUtils.isEmpty(aE.getText())) {
                    if (aE.getText().equals(this.iAu.getResources().getString(R.string.message_center_message_tab))) {
                        aE.aG(1);
                    } else if (aE.getText().equals(this.iAu.getResources().getString(R.string.message_center_chat_tab))) {
                        aE.aG(2);
                    } else if (aE.getText().equals(this.iAu.getResources().getString(R.string.message_center_notification_tab))) {
                        aE.aG(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.gBK = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.gBK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iAu != null) {
                    g.this.iAu.ckq();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.iAu.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.iAF = new ImageView(this.iAu.getContext());
        this.iAF.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.iAu.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.iAu.getContext(), R.dimen.ds88)));
        this.iAF.setScaleType(ImageView.ScaleType.CENTER);
        this.gBK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iAF, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iAu != null) {
                    g.this.iAu.ckr();
                }
            }
        });
        if (this.iAF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iAF.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.iAu.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.iAF.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.iAF.setVisibility(0);
        } else {
            this.iAF.setVisibility(4);
        }
        if (this.gCN != null) {
            this.gBK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gCN, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gCN.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gCN.setPadding(this.gCN.getPaddingLeft(), this.gCN.getPaddingTop(), this.gCN.getPaddingRight(), this.gCN.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.iAu.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gCN != null && bVar != null) {
            this.gCN.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gCN != null && bVar != null) {
            this.gCN.b(bVar);
        }
    }

    public TbTabLayout ckt() {
        return this.gCN;
    }

    public void xI(int i) {
        TbTabLayout.e xJ = xJ(i);
        if (xJ != null) {
            xJ.select();
        }
    }

    public TbTabLayout.e cku() {
        if (this.gCN == null || this.gCN.getTabCount() <= 0) {
            return null;
        }
        return this.gCN.aE(this.gCN.getSelectedTabPosition());
    }

    public TbTabLayout.e xJ(int i) {
        int tabCount;
        if (this.gCN != null && (tabCount = this.gCN.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aE = this.gCN.aE(i2);
                if (aE != null && aE.getId() != -1 && aE.getId() == i) {
                    return aE;
                }
            }
            return null;
        }
        return null;
    }

    public boolean xK(int i) {
        int selectedTabPosition;
        TbTabLayout.e aE;
        return this.gCN != null && (selectedTabPosition = this.gCN.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gCN.getTabCount() + (-1) && (aE = this.gCN.aE(selectedTabPosition)) != null && aE.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e xJ = xJ(i);
        if (xJ != null) {
            xJ.j(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.gBK != null) {
            this.gBK.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.gBK.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.ePq != null) {
            this.ePq.onChangeSkinType(getPageContext(), i);
        }
        if (this.gBF != null && this.gBF.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gBF.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.gBF.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.iAF != null) {
            SvgManager.aOR().a(this.iAF, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gCN != null) {
            this.gCN.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gCN.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gBF != null && this.gBF.size() > 0 && this.dKT != null) {
            MessageFragmentPagerAdapter.a aVar = this.gBF.get(this.dKT.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Rx() {
        if (this.iAu != null && this.gBF != null && this.dKT != null && this.iAE != null) {
            FragmentManager supportFragmentManager = this.iAu.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gBF.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dKT.getId(), this.iAE.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.ePq != null) {
            this.ePq.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iAE != null) {
            this.iAE.setPrimary(z);
        }
        if (this.gBF != null && this.gBF.size() > 0 && this.dKT != null) {
            MessageFragmentPagerAdapter.a aVar = this.gBF.get(this.dKT.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gBF != null && this.gBF.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gBF.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.gBF.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
