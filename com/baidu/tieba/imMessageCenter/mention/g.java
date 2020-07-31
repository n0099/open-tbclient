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
import com.baidu.tbadk.core.util.ao;
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
    private BdBaseViewPager eog;
    private NoNetworkView fsB;
    private List<MessageFragmentPagerAdapter.a> hiS;
    private NavigationBar hiX;
    private TbTabLayout hka;
    private MessageCenterFragment jpO;
    private MessageFragmentPagerAdapter jpV;
    private ChatAggregationFragment jpW;
    private ImageView jpX;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.jpO = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            al(bundle);
            am(bundle);
            an(bundle);
            this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fsB.a(this);
        }
    }

    private void al(Bundle bundle) {
        this.eog = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.jpW = new ChatAggregationFragment();
        aVar.fragment = this.jpW;
        aVar.title = this.jpO.getResources().getString(R.string.message_center_message_tab);
        this.hiS = new ArrayList();
        this.hiS.add(aVar);
        this.jpV = new MessageFragmentPagerAdapter(this.jpO.getActivity().getSupportFragmentManager(), this.hiS);
        this.eog.setAdapter(this.jpV);
        this.eog.setOffscreenPageLimit(this.hiS.size());
        this.jpV.notifyDataSetChanged();
    }

    private void am(Bundle bundle) {
        this.hka = (TbTabLayout) LayoutInflater.from(this.jpO.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.hka.setupWithViewPager(this.eog);
        int tabCount = this.hka.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.hka.aN(i).aP(1);
            }
        }
    }

    private void an(Bundle bundle) {
        this.hiX = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.hiX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jpO != null) {
                    g.this.jpO.cyR();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.jpO.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.jpX = new ImageView(this.jpO.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jpO.getContext(), R.dimen.ds88);
        this.jpX.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.jpX.setScaleType(ImageView.ScaleType.CENTER);
        this.hiX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jpX, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jpO != null) {
                    g.this.jpO.cyS();
                }
            }
        });
        if (this.jpX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jpX.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.jpO.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.jpX.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.jpX.setVisibility(0);
        } else {
            this.jpX.setVisibility(4);
        }
        if (this.hka != null) {
            this.hiX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.hka, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hka.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hka.setPadding(this.hka.getPaddingLeft(), this.hka.getPaddingTop(), this.hka.getPaddingRight(), this.hka.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.jpO.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.hka != null && bVar != null) {
            this.hka.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.hka != null && bVar != null) {
            this.hka.b(bVar);
        }
    }

    public void zC(int i) {
        TbTabLayout.e zD = zD(i);
        if (zD != null) {
            zD.select();
        }
    }

    public TbTabLayout.e cyT() {
        if (this.hka == null || this.hka.getTabCount() <= 0) {
            return null;
        }
        return this.hka.aN(this.hka.getSelectedTabPosition());
    }

    public TbTabLayout.e zD(int i) {
        int tabCount;
        if (this.hka != null && (tabCount = this.hka.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aN = this.hka.aN(i2);
                if (aN != null && aN.getId() != -1 && aN.getId() == i) {
                    return aN;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.hiX != null) {
            this.hiX.onChangeSkinType(getPageContext(), i);
            ao.setBackgroundColor(this.hiX.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fsB != null) {
            this.fsB.onChangeSkinType(getPageContext(), i);
        }
        if (this.hiS != null && this.hiS.size() > 0) {
            for (int i2 = 0; i2 < this.hiS.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.hiS.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.baR().a(this.jpX, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hka != null) {
            this.hka.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.hka.setSelectedTabIndicatorHeight(0);
            this.hka.setTabTextColors(ao.getColor(R.color.cp_cont_j), ao.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hiS != null && this.hiS.size() > 0 && this.eog != null) {
            MessageFragmentPagerAdapter.a aVar = this.hiS.get(this.eog.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void VJ() {
        if (this.jpO != null && this.hiS != null && this.eog != null && this.jpV != null) {
            FragmentManager supportFragmentManager = this.jpO.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hiS.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.eog.getId(), this.jpV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fsB != null) {
            this.fsB.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.jpV != null) {
            this.jpV.setPrimary(z);
        }
        if (this.hiS != null && this.hiS.size() > 0 && this.eog != null) {
            MessageFragmentPagerAdapter.a aVar = this.hiS.get(this.eog.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hiS != null && this.hiS.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hiS.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.hiS.get(i2);
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

    public void clS() {
        if (this.jpW != null) {
            this.jpW.IH();
        }
    }
}
