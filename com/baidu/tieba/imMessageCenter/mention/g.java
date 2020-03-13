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
    private BdBaseViewPager dkI;
    private NoNetworkView elv;
    private List<MessageFragmentPagerAdapter.a> fVW;
    private NavigationBar fWa;
    private TbTabLayout gMP;
    private MessageCenterFragment hOX;
    private MessageFragmentPagerAdapter hPh;
    private ImageView hPi;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.hOX = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.elv.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dkI = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.hOX.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.hOX.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.hOX.getResources().getString(R.string.message_center_notification_tab);
        this.fVW = new ArrayList();
        this.fVW.add(aVar);
        this.fVW.add(aVar2);
        this.fVW.add(aVar3);
        this.hPh = new MessageFragmentPagerAdapter(this.hOX.getActivity().getSupportFragmentManager(), this.fVW);
        this.dkI.setAdapter(this.hPh);
        this.dkI.setOffscreenPageLimit(this.fVW.size());
        this.hPh.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gMP = (TbTabLayout) LayoutInflater.from(this.hOX.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gMP.setupWithViewPager(this.dkI);
        int tabCount = this.gMP.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e as = this.gMP.as(i);
                if (as != null && !TextUtils.isEmpty(as.getText())) {
                    if (as.getText().equals(this.hOX.getResources().getString(R.string.message_center_message_tab))) {
                        as.au(1);
                    } else if (as.getText().equals(this.hOX.getResources().getString(R.string.message_center_chat_tab))) {
                        as.au(2);
                    } else if (as.getText().equals(this.hOX.getResources().getString(R.string.message_center_notification_tab))) {
                        as.au(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.fWa = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fWa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hOX != null) {
                    g.this.hOX.bZz();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.hOX.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.hPi = new ImageView(this.hOX.getContext());
        this.hPi.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.hOX.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.hOX.getContext(), R.dimen.ds88)));
        this.hPi.setScaleType(ImageView.ScaleType.CENTER);
        this.fWa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hPi, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hOX != null) {
                    g.this.hOX.bZA();
                }
            }
        });
        if (this.hPi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hPi.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.hOX.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.hPi.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.hPi.setVisibility(0);
        } else {
            this.hPi.setVisibility(4);
        }
        if (this.gMP != null) {
            this.fWa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gMP, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gMP.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gMP.setPadding(this.gMP.getPaddingLeft(), this.gMP.getPaddingTop(), this.gMP.getPaddingRight(), this.gMP.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.hOX.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gMP != null && bVar != null) {
            this.gMP.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gMP != null && bVar != null) {
            this.gMP.b(bVar);
        }
    }

    public TbTabLayout bZC() {
        return this.gMP;
    }

    public void rO(int i) {
        TbTabLayout.e xc = xc(i);
        if (xc != null) {
            xc.select();
        }
    }

    public TbTabLayout.e bZD() {
        if (this.gMP == null || this.gMP.getTabCount() <= 0) {
            return null;
        }
        return this.gMP.as(this.gMP.getSelectedTabPosition());
    }

    public TbTabLayout.e xc(int i) {
        int tabCount;
        if (this.gMP != null && (tabCount = this.gMP.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e as = this.gMP.as(i2);
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
        return this.gMP != null && (selectedTabPosition = this.gMP.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gMP.getTabCount() + (-1) && (as = this.gMP.as(selectedTabPosition)) != null && as.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e xc = xc(i);
        if (xc != null) {
            xc.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fWa != null) {
            this.fWa.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fWa.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.elv != null) {
            this.elv.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVW != null && this.fVW.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fVW.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fVW.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.hPi != null) {
            SvgManager.aGC().a(this.hPi, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gMP != null) {
            this.gMP.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gMP.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fVW != null && this.fVW.size() > 0 && this.dkI != null) {
            MessageFragmentPagerAdapter.a aVar = this.fVW.get(this.dkI.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JJ() {
        if (this.hOX != null && this.fVW != null && this.dkI != null && this.hPh != null) {
            FragmentManager supportFragmentManager = this.hOX.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fVW.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dkI.getId(), this.hPh.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.elv != null) {
            this.elv.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hPh != null) {
            this.hPh.setPrimary(z);
        }
        if (this.fVW != null && this.fVW.size() > 0 && this.dkI != null) {
            MessageFragmentPagerAdapter.a aVar = this.fVW.get(this.dkI.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fVW != null && this.fVW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fVW.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fVW.get(i2);
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
