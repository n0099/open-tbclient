package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.d implements NoNetworkView.a {
    private BdBaseViewPager fri;
    private NoNetworkView gCe;
    private TbTabLayout ghk;
    private List<MessageFragmentPagerAdapter.a> iIr;
    private NavigationBar iIw;
    private MessageCenterFragment kOe;
    private MessageFragmentPagerAdapter kOl;
    private ChatAggregationFragment kOm;
    private ImageView kOn;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kOe = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gCe.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.fri = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kOm = new ChatAggregationFragment();
        aVar.fragment = this.kOm;
        aVar.title = this.kOe.getResources().getString(R.string.message_center_message_tab);
        this.iIr = new ArrayList();
        this.iIr.add(aVar);
        this.kOl = new MessageFragmentPagerAdapter(this.kOe.getActivity().getSupportFragmentManager(), this.iIr);
        this.fri.setAdapter(this.kOl);
        this.fri.setOffscreenPageLimit(this.iIr.size());
        this.kOl.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.ghk = (TbTabLayout) LayoutInflater.from(this.kOe.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.ghk.setupWithViewPager(this.fri);
        int tabCount = this.ghk.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.ghk.aZ(i).bb(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iIw = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iIw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kOe != null) {
                    g.this.kOe.dbb();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kOe.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kOn = new ImageView(this.kOe.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kOe.getContext(), R.dimen.ds88);
        this.kOn.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kOn.setScaleType(ImageView.ScaleType.CENTER);
        this.iIw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kOn, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kOe != null) {
                    g.this.kOe.dbc();
                }
            }
        });
        if (this.kOn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kOn.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kOe.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kOn.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kOn.setVisibility(0);
        } else {
            this.kOn.setVisibility(4);
        }
        if (this.ghk != null) {
            this.iIw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.ghk, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ghk.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ghk.setPadding(this.ghk.getPaddingLeft(), this.ghk.getPaddingTop(), this.ghk.getPaddingRight(), this.ghk.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kOe.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.ghk != null && bVar != null) {
            this.ghk.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.ghk != null && bVar != null) {
            this.ghk.b(bVar);
        }
    }

    public void EN(int i) {
        TbTabLayout.e EO = EO(i);
        if (EO != null) {
            EO.select();
        }
    }

    public TbTabLayout.e dbd() {
        if (this.ghk == null || this.ghk.getTabCount() <= 0) {
            return null;
        }
        return this.ghk.aZ(this.ghk.getSelectedTabPosition());
    }

    public TbTabLayout.e EO(int i) {
        int tabCount;
        if (this.ghk != null && (tabCount = this.ghk.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aZ = this.ghk.aZ(i2);
                if (aZ != null && aZ.getId() != -1 && aZ.getId() == i) {
                    return aZ;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.iIw != null) {
            this.iIw.onChangeSkinType(getPageContext(), i);
            ao.setBackgroundColor(this.iIw.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(getPageContext(), i);
        }
        if (this.iIr != null && this.iIr.size() > 0) {
            for (int i2 = 0; i2 < this.iIr.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iIr.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bwq().a(this.kOn, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.ghk != null) {
            this.ghk.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.ghk.setSelectedTabIndicatorHeight(0);
            this.ghk.setTabTextColors(ao.getColor(R.color.CAM_X0107), ao.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iIr != null && this.iIr.size() > 0 && this.fri != null) {
            MessageFragmentPagerAdapter.a aVar = this.iIr.get(this.fri.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ano() {
        if (this.kOe != null && this.iIr != null && this.fri != null && this.kOl != null) {
            FragmentManager supportFragmentManager = this.kOe.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iIr.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.fri.getId(), this.kOl.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gCe != null) {
            this.gCe.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kOl != null) {
            this.kOl.setPrimary(z);
        }
        if (this.iIr != null && this.iIr.size() > 0 && this.fri != null) {
            MessageFragmentPagerAdapter.a aVar = this.iIr.get(this.fri.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iIr != null && this.iIr.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iIr.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iIr.get(i2);
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

    public void cRy() {
        if (this.kOm != null) {
            this.kOm.WE();
        }
    }
}
