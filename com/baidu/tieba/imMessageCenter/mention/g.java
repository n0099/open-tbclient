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
    private BdBaseViewPager eMH;
    private TbTabLayout fBy;
    private NoNetworkView fTu;
    private List<MessageFragmentPagerAdapter.a> hRW;
    private NavigationBar hSb;
    private MessageFragmentPagerAdapter kcB;
    private ChatAggregationFragment kcC;
    private ImageView kcD;
    private MessageCenterFragment kcu;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kcu = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fTu.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.eMH = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kcC = new ChatAggregationFragment();
        aVar.fragment = this.kcC;
        aVar.title = this.kcu.getResources().getString(R.string.message_center_message_tab);
        this.hRW = new ArrayList();
        this.hRW.add(aVar);
        this.kcB = new MessageFragmentPagerAdapter(this.kcu.getActivity().getSupportFragmentManager(), this.hRW);
        this.eMH.setAdapter(this.kcB);
        this.eMH.setOffscreenPageLimit(this.hRW.size());
        this.kcB.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fBy = (TbTabLayout) LayoutInflater.from(this.kcu.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fBy.setupWithViewPager(this.eMH);
        int tabCount = this.fBy.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fBy.aU(i).aW(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.hSb = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.hSb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kcu != null) {
                    g.this.kcu.cQX();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kcu.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kcD = new ImageView(this.kcu.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kcu.getContext(), R.dimen.ds88);
        this.kcD.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kcD.setScaleType(ImageView.ScaleType.CENTER);
        this.hSb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kcD, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kcu != null) {
                    g.this.kcu.cQY();
                }
            }
        });
        if (this.kcD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kcD.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kcu.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kcD.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kcD.setVisibility(0);
        } else {
            this.kcD.setVisibility(4);
        }
        if (this.fBy != null) {
            this.hSb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fBy, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fBy.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fBy.setPadding(this.fBy.getPaddingLeft(), this.fBy.getPaddingTop(), this.fBy.getPaddingRight(), this.fBy.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.kcu.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fBy != null && bVar != null) {
            this.fBy.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fBy != null && bVar != null) {
            this.fBy.b(bVar);
        }
    }

    public void Dc(int i) {
        TbTabLayout.e Dd = Dd(i);
        if (Dd != null) {
            Dd.select();
        }
    }

    public TbTabLayout.e cQZ() {
        if (this.fBy == null || this.fBy.getTabCount() <= 0) {
            return null;
        }
        return this.fBy.aU(this.fBy.getSelectedTabPosition());
    }

    public TbTabLayout.e Dd(int i) {
        int tabCount;
        if (this.fBy != null && (tabCount = this.fBy.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aU = this.fBy.aU(i2);
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
        if (this.hSb != null) {
            this.hSb.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.hSb.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fTu != null) {
            this.fTu.onChangeSkinType(getPageContext(), i);
        }
        if (this.hRW != null && this.hRW.size() > 0) {
            for (int i2 = 0; i2 < this.hRW.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.hRW.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bmU().a(this.kcD, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fBy != null) {
            this.fBy.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fBy.setSelectedTabIndicatorHeight(0);
            this.fBy.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hRW != null && this.hRW.size() > 0 && this.eMH != null) {
            MessageFragmentPagerAdapter.a aVar = this.hRW.get(this.eMH.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void afk() {
        if (this.kcu != null && this.hRW != null && this.eMH != null && this.kcB != null) {
            FragmentManager supportFragmentManager = this.kcu.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hRW.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.eMH.getId(), this.kcB.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fTu != null) {
            this.fTu.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kcB != null) {
            this.kcB.setPrimary(z);
        }
        if (this.hRW != null && this.hRW.size() > 0 && this.eMH != null) {
            MessageFragmentPagerAdapter.a aVar = this.hRW.get(this.eMH.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hRW != null && this.hRW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hRW.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.hRW.get(i2);
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

    public void cDP() {
        if (this.kcC != null) {
            this.kcC.Qi();
        }
    }
}
