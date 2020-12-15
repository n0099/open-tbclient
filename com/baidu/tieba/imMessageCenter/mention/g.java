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
/* loaded from: classes22.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private TbTabLayout fXD;
    private BdBaseViewPager fhx;
    private NoNetworkView grf;
    private List<MessageFragmentPagerAdapter.a> iwe;
    private NavigationBar iwj;
    private MessageCenterFragment kIV;
    private MessageFragmentPagerAdapter kJc;
    private ChatAggregationFragment kJd;
    private ImageView kJe;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kIV = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.grf.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.fhx = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kJd = new ChatAggregationFragment();
        aVar.fragment = this.kJd;
        aVar.title = this.kIV.getResources().getString(R.string.message_center_message_tab);
        this.iwe = new ArrayList();
        this.iwe.add(aVar);
        this.kJc = new MessageFragmentPagerAdapter(this.kIV.getActivity().getSupportFragmentManager(), this.iwe);
        this.fhx.setAdapter(this.kJc);
        this.fhx.setOffscreenPageLimit(this.iwe.size());
        this.kJc.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fXD = (TbTabLayout) LayoutInflater.from(this.kIV.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fXD.setupWithViewPager(this.fhx);
        int tabCount = this.fXD.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fXD.aY(i).ba(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iwj = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iwj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kIV != null) {
                    g.this.kIV.dby();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kIV.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kJe = new ImageView(this.kIV.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kIV.getContext(), R.dimen.ds88);
        this.kJe.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kJe.setScaleType(ImageView.ScaleType.CENTER);
        this.iwj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kJe, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kIV != null) {
                    g.this.kIV.dbz();
                }
            }
        });
        if (this.kJe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kJe.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kIV.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kJe.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kJe.setVisibility(0);
        } else {
            this.kJe.setVisibility(4);
        }
        if (this.fXD != null) {
            this.iwj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fXD, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fXD.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fXD.setPadding(this.fXD.getPaddingLeft(), this.fXD.getPaddingTop(), this.fXD.getPaddingRight(), this.fXD.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kIV.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fXD != null && bVar != null) {
            this.fXD.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fXD != null && bVar != null) {
            this.fXD.b(bVar);
        }
    }

    public void EV(int i) {
        TbTabLayout.e EW = EW(i);
        if (EW != null) {
            EW.select();
        }
    }

    public TbTabLayout.e dbA() {
        if (this.fXD == null || this.fXD.getTabCount() <= 0) {
            return null;
        }
        return this.fXD.aY(this.fXD.getSelectedTabPosition());
    }

    public TbTabLayout.e EW(int i) {
        int tabCount;
        if (this.fXD != null && (tabCount = this.fXD.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aY = this.fXD.aY(i2);
                if (aY != null && aY.getId() != -1 && aY.getId() == i) {
                    return aY;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.iwj != null) {
            this.iwj.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.iwj.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.grf != null) {
            this.grf.onChangeSkinType(getPageContext(), i);
        }
        if (this.iwe != null && this.iwe.size() > 0) {
            for (int i2 = 0; i2 < this.iwe.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iwe.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.btW().a(this.kJe, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fXD != null) {
            this.fXD.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fXD.setSelectedTabIndicatorHeight(0);
            this.fXD.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iwe != null && this.iwe.size() > 0 && this.fhx != null) {
            MessageFragmentPagerAdapter.a aVar = this.iwe.get(this.fhx.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ame() {
        if (this.kIV != null && this.iwe != null && this.fhx != null && this.kJc != null) {
            FragmentManager supportFragmentManager = this.kIV.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iwe.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.fhx.getId(), this.kJc.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.grf != null) {
            this.grf.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kJc != null) {
            this.kJc.setPrimary(z);
        }
        if (this.iwe != null && this.iwe.size() > 0 && this.fhx != null) {
            MessageFragmentPagerAdapter.a aVar = this.iwe.get(this.fhx.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iwe != null && this.iwe.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iwe.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iwe.get(i2);
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

    public void cOs() {
        if (this.kJd != null) {
            this.kJd.VC();
        }
    }
}
