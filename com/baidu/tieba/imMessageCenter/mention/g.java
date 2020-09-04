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
    private BdBaseViewPager eyw;
    private NoNetworkView fDZ;
    private List<MessageFragmentPagerAdapter.a> hvW;
    private TbTabLayout hwX;
    private NavigationBar hwb;
    private MessageCenterFragment jEU;
    private MessageFragmentPagerAdapter jFb;
    private ChatAggregationFragment jFc;
    private ImageView jFd;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.jEU = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fDZ.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.eyw = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.jFc = new ChatAggregationFragment();
        aVar.fragment = this.jFc;
        aVar.title = this.jEU.getResources().getString(R.string.message_center_message_tab);
        this.hvW = new ArrayList();
        this.hvW.add(aVar);
        this.jFb = new MessageFragmentPagerAdapter(this.jEU.getActivity().getSupportFragmentManager(), this.hvW);
        this.eyw.setAdapter(this.jFb);
        this.eyw.setOffscreenPageLimit(this.hvW.size());
        this.jFb.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.hwX = (TbTabLayout) LayoutInflater.from(this.jEU.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.hwX.setupWithViewPager(this.eyw);
        int tabCount = this.hwX.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.hwX.aQ(i).aS(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.hwb = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.hwb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jEU != null) {
                    g.this.jEU.cJJ();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.jEU.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.jFd = new ImageView(this.jEU.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jEU.getContext(), R.dimen.ds88);
        this.jFd.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.jFd.setScaleType(ImageView.ScaleType.CENTER);
        this.hwb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jFd, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jEU != null) {
                    g.this.jEU.cJK();
                }
            }
        });
        if (this.jFd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jFd.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.jEU.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.jFd.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.jFd.setVisibility(0);
        } else {
            this.jFd.setVisibility(4);
        }
        if (this.hwX != null) {
            this.hwb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.hwX, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hwX.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hwX.setPadding(this.hwX.getPaddingLeft(), this.hwX.getPaddingTop(), this.hwX.getPaddingRight(), this.hwX.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.jEU.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.hwX != null && bVar != null) {
            this.hwX.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.hwX != null && bVar != null) {
            this.hwX.b(bVar);
        }
    }

    public void BV(int i) {
        TbTabLayout.e BW = BW(i);
        if (BW != null) {
            BW.select();
        }
    }

    public TbTabLayout.e cJL() {
        if (this.hwX == null || this.hwX.getTabCount() <= 0) {
            return null;
        }
        return this.hwX.aQ(this.hwX.getSelectedTabPosition());
    }

    public TbTabLayout.e BW(int i) {
        int tabCount;
        if (this.hwX != null && (tabCount = this.hwX.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aQ = this.hwX.aQ(i2);
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
        if (this.hwb != null) {
            this.hwb.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.hwb.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fDZ != null) {
            this.fDZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvW != null && this.hvW.size() > 0) {
            for (int i2 = 0; i2 < this.hvW.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.hvW.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bjq().a(this.jFd, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hwX != null) {
            this.hwX.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.hwX.setSelectedTabIndicatorHeight(0);
            this.hwX.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hvW != null && this.hvW.size() > 0 && this.eyw != null) {
            MessageFragmentPagerAdapter.a aVar = this.hvW.get(this.eyw.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void abP() {
        if (this.jEU != null && this.hvW != null && this.eyw != null && this.jFb != null) {
            FragmentManager supportFragmentManager = this.jEU.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hvW.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.eyw.getId(), this.jFb.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fDZ != null) {
            this.fDZ.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.jFb != null) {
            this.jFb.setPrimary(z);
        }
        if (this.hvW != null && this.hvW.size() > 0 && this.eyw != null) {
            MessageFragmentPagerAdapter.a aVar = this.hvW.get(this.eyw.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hvW != null && this.hvW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hvW.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.hvW.get(i2);
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

    public void cwC() {
        if (this.jFc != null) {
            this.jFc.OA();
        }
    }
}
