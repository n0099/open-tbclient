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
/* loaded from: classes6.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dgc;
    private NoNetworkView egT;
    private List<MessageFragmentPagerAdapter.a> fQf;
    private NavigationBar fQj;
    private TbTabLayout gHn;
    private MessageCenterFragment hJi;
    private MessageFragmentPagerAdapter hJs;
    private ImageView hJt;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.hJi = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.egT.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dgc = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.hJi.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.hJi.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.hJi.getResources().getString(R.string.message_center_notification_tab);
        this.fQf = new ArrayList();
        this.fQf.add(aVar);
        this.fQf.add(aVar2);
        this.fQf.add(aVar3);
        this.hJs = new MessageFragmentPagerAdapter(this.hJi.getActivity().getSupportFragmentManager(), this.fQf);
        this.dgc.setAdapter(this.hJs);
        this.dgc.setOffscreenPageLimit(this.fQf.size());
        this.hJs.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gHn = (TbTabLayout) LayoutInflater.from(this.hJi.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gHn.setupWithViewPager(this.dgc);
        int tabCount = this.gHn.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e ap = this.gHn.ap(i);
                if (ap != null && !TextUtils.isEmpty(ap.getText())) {
                    if (ap.getText().equals(this.hJi.getResources().getString(R.string.message_center_message_tab))) {
                        ap.ar(1);
                    } else if (ap.getText().equals(this.hJi.getResources().getString(R.string.message_center_chat_tab))) {
                        ap.ar(2);
                    } else if (ap.getText().equals(this.hJi.getResources().getString(R.string.message_center_notification_tab))) {
                        ap.ar(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.fQj = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fQj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hJi != null) {
                    g.this.hJi.bWM();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.hJi.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.hJt = new ImageView(this.hJi.getContext());
        this.hJt.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.hJi.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.hJi.getContext(), R.dimen.ds88)));
        this.hJt.setScaleType(ImageView.ScaleType.CENTER);
        this.fQj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hJt, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hJi != null) {
                    g.this.hJi.bWN();
                }
            }
        });
        if (this.hJt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hJt.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.hJi.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.hJt.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.hJt.setVisibility(0);
        } else {
            this.hJt.setVisibility(4);
        }
        if (this.gHn != null) {
            this.fQj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gHn, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gHn.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gHn.setPadding(this.gHn.getPaddingLeft(), this.gHn.getPaddingTop(), this.gHn.getPaddingRight(), this.gHn.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.hJi.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gHn != null && bVar != null) {
            this.gHn.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gHn != null && bVar != null) {
            this.gHn.b(bVar);
        }
    }

    public TbTabLayout bWP() {
        return this.gHn;
    }

    public void rC(int i) {
        TbTabLayout.e wR = wR(i);
        if (wR != null) {
            wR.select();
        }
    }

    public TbTabLayout.e bWQ() {
        if (this.gHn == null || this.gHn.getTabCount() <= 0) {
            return null;
        }
        return this.gHn.ap(this.gHn.getSelectedTabPosition());
    }

    public TbTabLayout.e wR(int i) {
        int tabCount;
        if (this.gHn != null && (tabCount = this.gHn.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e ap = this.gHn.ap(i2);
                if (ap != null && ap.getId() != -1 && ap.getId() == i) {
                    return ap;
                }
            }
            return null;
        }
        return null;
    }

    public boolean rD(int i) {
        int selectedTabPosition;
        TbTabLayout.e ap;
        return this.gHn != null && (selectedTabPosition = this.gHn.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gHn.getTabCount() + (-1) && (ap = this.gHn.ap(selectedTabPosition)) != null && ap.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e wR = wR(i);
        if (wR != null) {
            wR.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fQj != null) {
            this.fQj.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fQj.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.egT != null) {
            this.egT.onChangeSkinType(getPageContext(), i);
        }
        if (this.fQf != null && this.fQf.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fQf.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fQf.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.hJt != null) {
            SvgManager.aDW().a(this.hJt, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gHn != null) {
            this.gHn.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gHn.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fQf != null && this.fQf.size() > 0 && this.dgc != null) {
            MessageFragmentPagerAdapter.a aVar = this.fQf.get(this.dgc.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void GW() {
        if (this.hJi != null && this.fQf != null && this.dgc != null && this.hJs != null) {
            FragmentManager supportFragmentManager = this.hJi.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fQf.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dgc.getId(), this.hJs.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.egT != null) {
            this.egT.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hJs != null) {
            this.hJs.setPrimary(z);
        }
        if (this.fQf != null && this.fQf.size() > 0 && this.dgc != null) {
            MessageFragmentPagerAdapter.a aVar = this.fQf.get(this.dgc.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fQf != null && this.fQf.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fQf.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fQf.get(i2);
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
