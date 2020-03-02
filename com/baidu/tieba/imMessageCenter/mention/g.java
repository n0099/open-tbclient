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
    private BdBaseViewPager dkv;
    private NoNetworkView eli;
    private List<MessageFragmentPagerAdapter.a> fVJ;
    private NavigationBar fVN;
    private TbTabLayout gMD;
    private MessageCenterFragment hOL;
    private MessageFragmentPagerAdapter hOV;
    private ImageView hOW;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.hOL = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.eli.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dkv = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.hOL.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.hOL.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.hOL.getResources().getString(R.string.message_center_notification_tab);
        this.fVJ = new ArrayList();
        this.fVJ.add(aVar);
        this.fVJ.add(aVar2);
        this.fVJ.add(aVar3);
        this.hOV = new MessageFragmentPagerAdapter(this.hOL.getActivity().getSupportFragmentManager(), this.fVJ);
        this.dkv.setAdapter(this.hOV);
        this.dkv.setOffscreenPageLimit(this.fVJ.size());
        this.hOV.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gMD = (TbTabLayout) LayoutInflater.from(this.hOL.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gMD.setupWithViewPager(this.dkv);
        int tabCount = this.gMD.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e as = this.gMD.as(i);
                if (as != null && !TextUtils.isEmpty(as.getText())) {
                    if (as.getText().equals(this.hOL.getResources().getString(R.string.message_center_message_tab))) {
                        as.au(1);
                    } else if (as.getText().equals(this.hOL.getResources().getString(R.string.message_center_chat_tab))) {
                        as.au(2);
                    } else if (as.getText().equals(this.hOL.getResources().getString(R.string.message_center_notification_tab))) {
                        as.au(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.fVN = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fVN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hOL != null) {
                    g.this.hOL.bZy();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.hOL.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.hOW = new ImageView(this.hOL.getContext());
        this.hOW.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.hOL.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.hOL.getContext(), R.dimen.ds88)));
        this.hOW.setScaleType(ImageView.ScaleType.CENTER);
        this.fVN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hOW, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hOL != null) {
                    g.this.hOL.bZz();
                }
            }
        });
        if (this.hOW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hOW.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.hOL.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.hOW.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.hOW.setVisibility(0);
        } else {
            this.hOW.setVisibility(4);
        }
        if (this.gMD != null) {
            this.fVN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gMD, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gMD.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gMD.setPadding(this.gMD.getPaddingLeft(), this.gMD.getPaddingTop(), this.gMD.getPaddingRight(), this.gMD.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.hOL.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gMD != null && bVar != null) {
            this.gMD.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gMD != null && bVar != null) {
            this.gMD.b(bVar);
        }
    }

    public TbTabLayout bZB() {
        return this.gMD;
    }

    public void rO(int i) {
        TbTabLayout.e xc = xc(i);
        if (xc != null) {
            xc.select();
        }
    }

    public TbTabLayout.e bZC() {
        if (this.gMD == null || this.gMD.getTabCount() <= 0) {
            return null;
        }
        return this.gMD.as(this.gMD.getSelectedTabPosition());
    }

    public TbTabLayout.e xc(int i) {
        int tabCount;
        if (this.gMD != null && (tabCount = this.gMD.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e as = this.gMD.as(i2);
                if (as != null && as.getId() != -1 && as.getId() == i) {
                    return as;
                }
            }
            return null;
        }
        return null;
    }

    public boolean rP(int i) {
        int selectedTabPosition;
        TbTabLayout.e as;
        return this.gMD != null && (selectedTabPosition = this.gMD.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gMD.getTabCount() + (-1) && (as = this.gMD.as(selectedTabPosition)) != null && as.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e xc = xc(i);
        if (xc != null) {
            xc.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fVN != null) {
            this.fVN.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fVN.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.eli != null) {
            this.eli.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVJ != null && this.fVJ.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fVJ.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fVJ.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.hOW != null) {
            SvgManager.aGC().a(this.hOW, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gMD != null) {
            this.gMD.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gMD.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fVJ != null && this.fVJ.size() > 0 && this.dkv != null) {
            MessageFragmentPagerAdapter.a aVar = this.fVJ.get(this.dkv.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JJ() {
        if (this.hOL != null && this.fVJ != null && this.dkv != null && this.hOV != null) {
            FragmentManager supportFragmentManager = this.hOL.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fVJ.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dkv.getId(), this.hOV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.eli != null) {
            this.eli.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hOV != null) {
            this.hOV.setPrimary(z);
        }
        if (this.fVJ != null && this.fVJ.size() > 0 && this.dkv != null) {
            MessageFragmentPagerAdapter.a aVar = this.fVJ.get(this.dkv.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fVJ != null && this.fVJ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fVJ.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fVJ.get(i2);
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
