package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager eys;
    private NoNetworkView fDV;
    private List<MessageFragmentPagerAdapter.a> hvQ;
    private NavigationBar hvV;
    private TbTabLayout hwR;
    private MessageCenterFragment jEO;
    private MessageFragmentPagerAdapter jEV;
    private ChatAggregationFragment jEW;
    private ImageView jEX;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.jEO = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fDV.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.eys = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.jEW = new ChatAggregationFragment();
        aVar.fragment = this.jEW;
        aVar.title = this.jEO.getResources().getString(R.string.message_center_message_tab);
        this.hvQ = new ArrayList();
        this.hvQ.add(aVar);
        this.jEV = new MessageFragmentPagerAdapter(this.jEO.getActivity().getSupportFragmentManager(), this.hvQ);
        this.eys.setAdapter(this.jEV);
        this.eys.setOffscreenPageLimit(this.hvQ.size());
        this.jEV.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.hwR = (TbTabLayout) LayoutInflater.from(this.jEO.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.hwR.setupWithViewPager(this.eys);
        int tabCount = this.hwR.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.hwR.aQ(i).aS(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.hvV = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.hvV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jEO != null) {
                    g.this.jEO.cJI();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.jEO.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.jEX = new ImageView(this.jEO.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jEO.getContext(), R.dimen.ds88);
        this.jEX.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.jEX.setScaleType(ImageView.ScaleType.CENTER);
        this.hvV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jEX, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jEO != null) {
                    g.this.jEO.cJJ();
                }
            }
        });
        if (this.jEX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jEX.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.jEO.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.jEX.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.jEX.setVisibility(0);
        } else {
            this.jEX.setVisibility(4);
        }
        if (this.hwR != null) {
            this.hvV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.hwR, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hwR.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hwR.setPadding(this.hwR.getPaddingLeft(), this.hwR.getPaddingTop(), this.hwR.getPaddingRight(), this.hwR.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.jEO.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.hwR != null && bVar != null) {
            this.hwR.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.hwR != null && bVar != null) {
            this.hwR.b(bVar);
        }
    }

    public void BV(int i) {
        TbTabLayout.e BW = BW(i);
        if (BW != null) {
            BW.select();
        }
    }

    public TbTabLayout.e cJK() {
        if (this.hwR == null || this.hwR.getTabCount() <= 0) {
            return null;
        }
        return this.hwR.aQ(this.hwR.getSelectedTabPosition());
    }

    public TbTabLayout.e BW(int i) {
        int tabCount;
        if (this.hwR != null && (tabCount = this.hwR.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aQ = this.hwR.aQ(i2);
                if (aQ != null && aQ.getId() != -1 && aQ.getId() == i) {
                    return aQ;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.hvV != null) {
            this.hvV.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.hvV.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvQ != null && this.hvQ.size() > 0) {
            for (int i2 = 0; i2 < this.hvQ.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.hvQ.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bjq().a(this.jEX, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hwR != null) {
            this.hwR.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.hwR.setSelectedTabIndicatorHeight(0);
            this.hwR.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hvQ != null && this.hvQ.size() > 0 && this.eys != null) {
            MessageFragmentPagerAdapter.a aVar = this.hvQ.get(this.eys.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void abP() {
        if (this.jEO != null && this.hvQ != null && this.eys != null && this.jEV != null) {
            FragmentManager supportFragmentManager = this.jEO.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hvQ.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.eys.getId(), this.jEV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fDV != null) {
            this.fDV.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.jEV != null) {
            this.jEV.setPrimary(z);
        }
        if (this.hvQ != null && this.hvQ.size() > 0 && this.eys != null) {
            MessageFragmentPagerAdapter.a aVar = this.hvQ.get(this.eys.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hvQ != null && this.hvQ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hvQ.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.hvQ.get(i2);
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

    public void cwB() {
        if (this.jEW != null) {
            this.jEW.OA();
        }
    }
}
