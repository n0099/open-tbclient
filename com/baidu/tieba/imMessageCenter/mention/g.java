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
/* loaded from: classes21.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager eAA;
    private NoNetworkView fHl;
    private TbTabLayout fpk;
    private List<MessageFragmentPagerAdapter.a> hDa;
    private NavigationBar hDf;
    private MessageFragmentPagerAdapter jND;
    private ChatAggregationFragment jNE;
    private ImageView jNF;
    private MessageCenterFragment jNw;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.jNw = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fHl.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.eAA = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.jNE = new ChatAggregationFragment();
        aVar.fragment = this.jNE;
        aVar.title = this.jNw.getResources().getString(R.string.message_center_message_tab);
        this.hDa = new ArrayList();
        this.hDa.add(aVar);
        this.jND = new MessageFragmentPagerAdapter(this.jNw.getActivity().getSupportFragmentManager(), this.hDa);
        this.eAA.setAdapter(this.jND);
        this.eAA.setOffscreenPageLimit(this.hDa.size());
        this.jND.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fpk = (TbTabLayout) LayoutInflater.from(this.jNw.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fpk.setupWithViewPager(this.eAA);
        int tabCount = this.fpk.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fpk.aU(i).aW(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.hDf = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.hDf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jNw != null) {
                    g.this.jNw.cNp();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.jNw.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.jNF = new ImageView(this.jNw.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jNw.getContext(), R.dimen.ds88);
        this.jNF.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.jNF.setScaleType(ImageView.ScaleType.CENTER);
        this.hDf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jNF, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jNw != null) {
                    g.this.jNw.cNq();
                }
            }
        });
        if (this.jNF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jNF.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.jNw.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.jNF.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.jNF.setVisibility(0);
        } else {
            this.jNF.setVisibility(4);
        }
        if (this.fpk != null) {
            this.hDf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fpk, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fpk.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fpk.setPadding(this.fpk.getPaddingLeft(), this.fpk.getPaddingTop(), this.fpk.getPaddingRight(), this.fpk.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.jNw.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fpk != null && bVar != null) {
            this.fpk.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fpk != null && bVar != null) {
            this.fpk.b(bVar);
        }
    }

    public void Cw(int i) {
        TbTabLayout.e Cx = Cx(i);
        if (Cx != null) {
            Cx.select();
        }
    }

    public TbTabLayout.e cNr() {
        if (this.fpk == null || this.fpk.getTabCount() <= 0) {
            return null;
        }
        return this.fpk.aU(this.fpk.getSelectedTabPosition());
    }

    public TbTabLayout.e Cx(int i) {
        int tabCount;
        if (this.fpk != null && (tabCount = this.fpk.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aU = this.fpk.aU(i2);
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
        if (this.hDf != null) {
            this.hDf.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.hDf.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fHl != null) {
            this.fHl.onChangeSkinType(getPageContext(), i);
        }
        if (this.hDa != null && this.hDa.size() > 0) {
            for (int i2 = 0; i2 < this.hDa.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.hDa.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bkl().a(this.jNF, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fpk != null) {
            this.fpk.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fpk.setSelectedTabIndicatorHeight(0);
            this.fpk.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hDa != null && this.hDa.size() > 0 && this.eAA != null) {
            MessageFragmentPagerAdapter.a aVar = this.hDa.get(this.eAA.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void acy() {
        if (this.jNw != null && this.hDa != null && this.eAA != null && this.jND != null) {
            FragmentManager supportFragmentManager = this.jNw.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hDa.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.eAA.getId(), this.jND.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fHl != null) {
            this.fHl.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.jND != null) {
            this.jND.setPrimary(z);
        }
        if (this.hDa != null && this.hDa.size() > 0 && this.eAA != null) {
            MessageFragmentPagerAdapter.a aVar = this.hDa.get(this.eAA.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hDa != null && this.hDa.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hDa.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.hDa.get(i2);
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

    public void cAj() {
        if (this.jNE != null) {
            this.jNE.Pd();
        }
    }
}
