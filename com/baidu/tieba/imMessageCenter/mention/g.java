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
    private BdBaseViewPager dku;
    private NoNetworkView elh;
    private List<MessageFragmentPagerAdapter.a> fVH;
    private NavigationBar fVL;
    private TbTabLayout gMB;
    private MessageCenterFragment hOJ;
    private MessageFragmentPagerAdapter hOT;
    private ImageView hOU;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.hOJ = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.elh.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dku = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.hOJ.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.hOJ.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.hOJ.getResources().getString(R.string.message_center_notification_tab);
        this.fVH = new ArrayList();
        this.fVH.add(aVar);
        this.fVH.add(aVar2);
        this.fVH.add(aVar3);
        this.hOT = new MessageFragmentPagerAdapter(this.hOJ.getActivity().getSupportFragmentManager(), this.fVH);
        this.dku.setAdapter(this.hOT);
        this.dku.setOffscreenPageLimit(this.fVH.size());
        this.hOT.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gMB = (TbTabLayout) LayoutInflater.from(this.hOJ.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gMB.setupWithViewPager(this.dku);
        int tabCount = this.gMB.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e as = this.gMB.as(i);
                if (as != null && !TextUtils.isEmpty(as.getText())) {
                    if (as.getText().equals(this.hOJ.getResources().getString(R.string.message_center_message_tab))) {
                        as.au(1);
                    } else if (as.getText().equals(this.hOJ.getResources().getString(R.string.message_center_chat_tab))) {
                        as.au(2);
                    } else if (as.getText().equals(this.hOJ.getResources().getString(R.string.message_center_notification_tab))) {
                        as.au(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.fVL = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fVL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hOJ != null) {
                    g.this.hOJ.bZw();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.hOJ.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.hOU = new ImageView(this.hOJ.getContext());
        this.hOU.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.hOJ.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.hOJ.getContext(), R.dimen.ds88)));
        this.hOU.setScaleType(ImageView.ScaleType.CENTER);
        this.fVL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hOU, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hOJ != null) {
                    g.this.hOJ.bZx();
                }
            }
        });
        if (this.hOU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hOU.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.hOJ.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.hOU.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.hOU.setVisibility(0);
        } else {
            this.hOU.setVisibility(4);
        }
        if (this.gMB != null) {
            this.fVL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gMB, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gMB.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gMB.setPadding(this.gMB.getPaddingLeft(), this.gMB.getPaddingTop(), this.gMB.getPaddingRight(), this.gMB.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.hOJ.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gMB != null && bVar != null) {
            this.gMB.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gMB != null && bVar != null) {
            this.gMB.b(bVar);
        }
    }

    public TbTabLayout bZz() {
        return this.gMB;
    }

    public void rO(int i) {
        TbTabLayout.e xc = xc(i);
        if (xc != null) {
            xc.select();
        }
    }

    public TbTabLayout.e bZA() {
        if (this.gMB == null || this.gMB.getTabCount() <= 0) {
            return null;
        }
        return this.gMB.as(this.gMB.getSelectedTabPosition());
    }

    public TbTabLayout.e xc(int i) {
        int tabCount;
        if (this.gMB != null && (tabCount = this.gMB.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e as = this.gMB.as(i2);
                if (as != null && as.getId() != -1 && as.getId() == i) {
                    return as;
                }
            }
            return null;
        }
        return null;
    }

    public boolean rP(int i) {
        int selectedTabPosition;
        TbTabLayout.e as;
        return this.gMB != null && (selectedTabPosition = this.gMB.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gMB.getTabCount() + (-1) && (as = this.gMB.as(selectedTabPosition)) != null && as.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e xc = xc(i);
        if (xc != null) {
            xc.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fVL != null) {
            this.fVL.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fVL.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.elh != null) {
            this.elh.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVH != null && this.fVH.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fVH.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fVH.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.hOU != null) {
            SvgManager.aGA().a(this.hOU, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gMB != null) {
            this.gMB.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gMB.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fVH != null && this.fVH.size() > 0 && this.dku != null) {
            MessageFragmentPagerAdapter.a aVar = this.fVH.get(this.dku.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JH() {
        if (this.hOJ != null && this.fVH != null && this.dku != null && this.hOT != null) {
            FragmentManager supportFragmentManager = this.hOJ.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fVH.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dku.getId(), this.hOT.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.elh != null) {
            this.elh.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hOT != null) {
            this.hOT.setPrimary(z);
        }
        if (this.fVH != null && this.fVH.size() > 0 && this.dku != null) {
            MessageFragmentPagerAdapter.a aVar = this.fVH.get(this.dku.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fVH != null && this.fVH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fVH.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fVH.get(i2);
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
