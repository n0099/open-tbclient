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
    private TbTabLayout fXB;
    private BdBaseViewPager fhx;
    private NoNetworkView grd;
    private List<MessageFragmentPagerAdapter.a> iwc;
    private NavigationBar iwh;
    private MessageCenterFragment kIT;
    private MessageFragmentPagerAdapter kJa;
    private ChatAggregationFragment kJb;
    private ImageView kJc;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kIT = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.grd.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.fhx = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kJb = new ChatAggregationFragment();
        aVar.fragment = this.kJb;
        aVar.title = this.kIT.getResources().getString(R.string.message_center_message_tab);
        this.iwc = new ArrayList();
        this.iwc.add(aVar);
        this.kJa = new MessageFragmentPagerAdapter(this.kIT.getActivity().getSupportFragmentManager(), this.iwc);
        this.fhx.setAdapter(this.kJa);
        this.fhx.setOffscreenPageLimit(this.iwc.size());
        this.kJa.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fXB = (TbTabLayout) LayoutInflater.from(this.kIT.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fXB.setupWithViewPager(this.fhx);
        int tabCount = this.fXB.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fXB.aY(i).ba(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iwh = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iwh.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kIT != null) {
                    g.this.kIT.dbx();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kIT.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kJc = new ImageView(this.kIT.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kIT.getContext(), R.dimen.ds88);
        this.kJc.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kJc.setScaleType(ImageView.ScaleType.CENTER);
        this.iwh.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kJc, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kIT != null) {
                    g.this.kIT.dby();
                }
            }
        });
        if (this.kJc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kJc.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kIT.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kJc.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kJc.setVisibility(0);
        } else {
            this.kJc.setVisibility(4);
        }
        if (this.fXB != null) {
            this.iwh.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fXB, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fXB.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fXB.setPadding(this.fXB.getPaddingLeft(), this.fXB.getPaddingTop(), this.fXB.getPaddingRight(), this.fXB.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kIT.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fXB != null && bVar != null) {
            this.fXB.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fXB != null && bVar != null) {
            this.fXB.b(bVar);
        }
    }

    public void EV(int i) {
        TbTabLayout.e EW = EW(i);
        if (EW != null) {
            EW.select();
        }
    }

    public TbTabLayout.e dbz() {
        if (this.fXB == null || this.fXB.getTabCount() <= 0) {
            return null;
        }
        return this.fXB.aY(this.fXB.getSelectedTabPosition());
    }

    public TbTabLayout.e EW(int i) {
        int tabCount;
        if (this.fXB != null && (tabCount = this.fXB.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aY = this.fXB.aY(i2);
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
        if (this.iwh != null) {
            this.iwh.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.iwh.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.grd != null) {
            this.grd.onChangeSkinType(getPageContext(), i);
        }
        if (this.iwc != null && this.iwc.size() > 0) {
            for (int i2 = 0; i2 < this.iwc.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iwc.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.btW().a(this.kJc, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fXB != null) {
            this.fXB.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fXB.setSelectedTabIndicatorHeight(0);
            this.fXB.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iwc != null && this.iwc.size() > 0 && this.fhx != null) {
            MessageFragmentPagerAdapter.a aVar = this.iwc.get(this.fhx.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ame() {
        if (this.kIT != null && this.iwc != null && this.fhx != null && this.kJa != null) {
            FragmentManager supportFragmentManager = this.kIT.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iwc.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.fhx.getId(), this.kJa.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.grd != null) {
            this.grd.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kJa != null) {
            this.kJa.setPrimary(z);
        }
        if (this.iwc != null && this.iwc.size() > 0 && this.fhx != null) {
            MessageFragmentPagerAdapter.a aVar = this.iwc.get(this.fhx.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iwc != null && this.iwc.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iwc.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iwc.get(i2);
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

    public void cOr() {
        if (this.kJb != null) {
            this.kJb.VC();
        }
    }
}
