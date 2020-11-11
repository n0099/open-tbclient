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
    private TbTabLayout fPJ;
    private BdBaseViewPager faS;
    private NoNetworkView gjn;
    private List<MessageFragmentPagerAdapter.a> iku;
    private NavigationBar ikz;
    private MessageCenterFragment kuP;
    private MessageFragmentPagerAdapter kuW;
    private ChatAggregationFragment kuX;
    private ImageView kuY;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kuP = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gjn.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.faS = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kuX = new ChatAggregationFragment();
        aVar.fragment = this.kuX;
        aVar.title = this.kuP.getResources().getString(R.string.message_center_message_tab);
        this.iku = new ArrayList();
        this.iku.add(aVar);
        this.kuW = new MessageFragmentPagerAdapter(this.kuP.getActivity().getSupportFragmentManager(), this.iku);
        this.faS.setAdapter(this.kuW);
        this.faS.setOffscreenPageLimit(this.iku.size());
        this.kuW.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fPJ = (TbTabLayout) LayoutInflater.from(this.kuP.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fPJ.setupWithViewPager(this.faS);
        int tabCount = this.fPJ.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fPJ.aU(i).aW(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.ikz = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.ikz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kuP != null) {
                    g.this.kuP.cWF();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kuP.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kuY = new ImageView(this.kuP.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kuP.getContext(), R.dimen.ds88);
        this.kuY.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kuY.setScaleType(ImageView.ScaleType.CENTER);
        this.ikz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kuY, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kuP != null) {
                    g.this.kuP.cWG();
                }
            }
        });
        if (this.kuY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kuY.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kuP.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kuY.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kuY.setVisibility(0);
        } else {
            this.kuY.setVisibility(4);
        }
        if (this.fPJ != null) {
            this.ikz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fPJ, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fPJ.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fPJ.setPadding(this.fPJ.getPaddingLeft(), this.fPJ.getPaddingTop(), this.fPJ.getPaddingRight(), this.fPJ.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.kuP.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fPJ != null && bVar != null) {
            this.fPJ.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fPJ != null && bVar != null) {
            this.fPJ.b(bVar);
        }
    }

    public void DI(int i) {
        TbTabLayout.e DJ = DJ(i);
        if (DJ != null) {
            DJ.select();
        }
    }

    public TbTabLayout.e cWH() {
        if (this.fPJ == null || this.fPJ.getTabCount() <= 0) {
            return null;
        }
        return this.fPJ.aU(this.fPJ.getSelectedTabPosition());
    }

    public TbTabLayout.e DJ(int i) {
        int tabCount;
        if (this.fPJ != null && (tabCount = this.fPJ.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aU = this.fPJ.aU(i2);
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
        if (this.ikz != null) {
            this.ikz.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.ikz.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.gjn != null) {
            this.gjn.onChangeSkinType(getPageContext(), i);
        }
        if (this.iku != null && this.iku.size() > 0) {
            for (int i2 = 0; i2 < this.iku.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iku.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.brn().a(this.kuY, R.drawable.ic_icon_pure_chat_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fPJ != null) {
            this.fPJ.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fPJ.setSelectedTabIndicatorHeight(0);
            this.fPJ.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iku != null && this.iku.size() > 0 && this.faS != null) {
            MessageFragmentPagerAdapter.a aVar = this.iku.get(this.faS.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajE() {
        if (this.kuP != null && this.iku != null && this.faS != null && this.kuW != null) {
            FragmentManager supportFragmentManager = this.kuP.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iku.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.faS.getId(), this.kuW.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gjn != null) {
            this.gjn.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kuW != null) {
            this.kuW.setPrimary(z);
        }
        if (this.iku != null && this.iku.size() > 0 && this.faS != null) {
            MessageFragmentPagerAdapter.a aVar = this.iku.get(this.faS.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iku != null && this.iku.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iku.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iku.get(i2);
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

    public void cJx() {
        if (this.kuX != null) {
            this.kuX.TL();
        }
    }
}
