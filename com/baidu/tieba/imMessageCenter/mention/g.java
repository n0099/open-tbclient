package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dKP;
    private NoNetworkView ePl;
    private NavigationBar gBE;
    private List<MessageFragmentPagerAdapter.a> gBz;
    private TbTabLayout gCH;
    private MessageCenterFragment iAo;
    private MessageFragmentPagerAdapter iAy;
    private ImageView iAz;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.iAo = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.ePl = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.ePl.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dKP = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.iAo.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.iAo.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.iAo.getResources().getString(R.string.message_center_notification_tab);
        this.gBz = new ArrayList();
        this.gBz.add(aVar);
        this.gBz.add(aVar2);
        this.gBz.add(aVar3);
        this.iAy = new MessageFragmentPagerAdapter(this.iAo.getActivity().getSupportFragmentManager(), this.gBz);
        this.dKP.setAdapter(this.iAy);
        this.dKP.setOffscreenPageLimit(this.gBz.size());
        this.iAy.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gCH = (TbTabLayout) LayoutInflater.from(this.iAo.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gCH.setupWithViewPager(this.dKP);
        int tabCount = this.gCH.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aE = this.gCH.aE(i);
                if (aE != null && !TextUtils.isEmpty(aE.getText())) {
                    if (aE.getText().equals(this.iAo.getResources().getString(R.string.message_center_message_tab))) {
                        aE.aG(1);
                    } else if (aE.getText().equals(this.iAo.getResources().getString(R.string.message_center_chat_tab))) {
                        aE.aG(2);
                    } else if (aE.getText().equals(this.iAo.getResources().getString(R.string.message_center_notification_tab))) {
                        aE.aG(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.gBE = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.gBE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iAo != null) {
                    g.this.iAo.cks();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.iAo.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.iAz = new ImageView(this.iAo.getContext());
        this.iAz.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.iAo.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.iAo.getContext(), R.dimen.ds88)));
        this.iAz.setScaleType(ImageView.ScaleType.CENTER);
        this.gBE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iAz, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iAo != null) {
                    g.this.iAo.ckt();
                }
            }
        });
        if (this.iAz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iAz.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.iAo.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.iAz.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.iAz.setVisibility(0);
        } else {
            this.iAz.setVisibility(4);
        }
        if (this.gCH != null) {
            this.gBE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gCH, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gCH.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gCH.setPadding(this.gCH.getPaddingLeft(), this.gCH.getPaddingTop(), this.gCH.getPaddingRight(), this.gCH.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.iAo.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gCH != null && bVar != null) {
            this.gCH.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gCH != null && bVar != null) {
            this.gCH.b(bVar);
        }
    }

    public TbTabLayout ckv() {
        return this.gCH;
    }

    public void xI(int i) {
        TbTabLayout.e xJ = xJ(i);
        if (xJ != null) {
            xJ.select();
        }
    }

    public TbTabLayout.e ckw() {
        if (this.gCH == null || this.gCH.getTabCount() <= 0) {
            return null;
        }
        return this.gCH.aE(this.gCH.getSelectedTabPosition());
    }

    public TbTabLayout.e xJ(int i) {
        int tabCount;
        if (this.gCH != null && (tabCount = this.gCH.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aE = this.gCH.aE(i2);
                if (aE != null && aE.getId() != -1 && aE.getId() == i) {
                    return aE;
                }
            }
            return null;
        }
        return null;
    }

    public boolean xK(int i) {
        int selectedTabPosition;
        TbTabLayout.e aE;
        return this.gCH != null && (selectedTabPosition = this.gCH.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gCH.getTabCount() + (-1) && (aE = this.gCH.aE(selectedTabPosition)) != null && aE.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e xJ = xJ(i);
        if (xJ != null) {
            xJ.j(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.gBE != null) {
            this.gBE.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.gBE.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.ePl != null) {
            this.ePl.onChangeSkinType(getPageContext(), i);
        }
        if (this.gBz != null && this.gBz.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gBz.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.gBz.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.iAz != null) {
            SvgManager.aOU().a(this.iAz, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gCH != null) {
            this.gCH.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gCH.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gBz != null && this.gBz.size() > 0 && this.dKP != null) {
            MessageFragmentPagerAdapter.a aVar = this.gBz.get(this.dKP.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Ry() {
        if (this.iAo != null && this.gBz != null && this.dKP != null && this.iAy != null) {
            FragmentManager supportFragmentManager = this.iAo.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gBz.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dKP.getId(), this.iAy.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.ePl != null) {
            this.ePl.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iAy != null) {
            this.iAy.setPrimary(z);
        }
        if (this.gBz != null && this.gBz.size() > 0 && this.dKP != null) {
            MessageFragmentPagerAdapter.a aVar = this.gBz.get(this.dKP.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gBz != null && this.gBz.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gBz.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.gBz.get(i2);
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
}
