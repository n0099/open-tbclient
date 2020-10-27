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
    private BdBaseViewPager eVd;
    private TbTabLayout fJT;
    private NoNetworkView gdx;
    private NavigationBar ieC;
    private List<MessageFragmentPagerAdapter.a> iex;
    private MessageCenterFragment koT;
    private MessageFragmentPagerAdapter kpa;
    private ChatAggregationFragment kpb;
    private ImageView kpc;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.koT = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gdx.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.eVd = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kpb = new ChatAggregationFragment();
        aVar.fragment = this.kpb;
        aVar.title = this.koT.getResources().getString(R.string.message_center_message_tab);
        this.iex = new ArrayList();
        this.iex.add(aVar);
        this.kpa = new MessageFragmentPagerAdapter(this.koT.getActivity().getSupportFragmentManager(), this.iex);
        this.eVd.setAdapter(this.kpa);
        this.eVd.setOffscreenPageLimit(this.iex.size());
        this.kpa.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fJT = (TbTabLayout) LayoutInflater.from(this.koT.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fJT.setupWithViewPager(this.eVd);
        int tabCount = this.fJT.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fJT.aU(i).aW(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.ieC = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.ieC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.koT != null) {
                    g.this.koT.cUe();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.koT.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kpc = new ImageView(this.koT.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.koT.getContext(), R.dimen.ds88);
        this.kpc.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kpc.setScaleType(ImageView.ScaleType.CENTER);
        this.ieC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kpc, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.koT != null) {
                    g.this.koT.cUf();
                }
            }
        });
        if (this.kpc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kpc.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.koT.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kpc.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kpc.setVisibility(0);
        } else {
            this.kpc.setVisibility(4);
        }
        if (this.fJT != null) {
            this.ieC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fJT, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fJT.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fJT.setPadding(this.fJT.getPaddingLeft(), this.fJT.getPaddingTop(), this.fJT.getPaddingRight(), this.fJT.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.koT.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fJT != null && bVar != null) {
            this.fJT.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fJT != null && bVar != null) {
            this.fJT.b(bVar);
        }
    }

    public void Dv(int i) {
        TbTabLayout.e Dw = Dw(i);
        if (Dw != null) {
            Dw.select();
        }
    }

    public TbTabLayout.e cUg() {
        if (this.fJT == null || this.fJT.getTabCount() <= 0) {
            return null;
        }
        return this.fJT.aU(this.fJT.getSelectedTabPosition());
    }

    public TbTabLayout.e Dw(int i) {
        int tabCount;
        if (this.fJT != null && (tabCount = this.fJT.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aU = this.fJT.aU(i2);
                if (aU != null && aU.getId() != -1 && aU.getId() == i) {
                    return aU;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.ieC != null) {
            this.ieC.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.ieC.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.gdx != null) {
            this.gdx.onChangeSkinType(getPageContext(), i);
        }
        if (this.iex != null && this.iex.size() > 0) {
            for (int i2 = 0; i2 < this.iex.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iex.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.boN().a(this.kpc, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fJT != null) {
            this.fJT.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fJT.setSelectedTabIndicatorHeight(0);
            this.fJT.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iex != null && this.iex.size() > 0 && this.eVd != null) {
            MessageFragmentPagerAdapter.a aVar = this.iex.get(this.eVd.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ahe() {
        if (this.koT != null && this.iex != null && this.eVd != null && this.kpa != null) {
            FragmentManager supportFragmentManager = this.koT.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iex.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.eVd.getId(), this.kpa.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gdx != null) {
            this.gdx.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kpa != null) {
            this.kpa.setPrimary(z);
        }
        if (this.iex != null && this.iex.size() > 0 && this.eVd != null) {
            MessageFragmentPagerAdapter.a aVar = this.iex.get(this.eVd.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iex != null && this.iex.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iex.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iex.get(i2);
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

    public void cGW() {
        if (this.kpb != null) {
            this.kpb.Rd();
        }
    }
}
