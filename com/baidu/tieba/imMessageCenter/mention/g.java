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
/* loaded from: classes7.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dgo;
    private NoNetworkView ehd;
    private List<MessageFragmentPagerAdapter.a> fTo;
    private NavigationBar fTs;
    private TbTabLayout gKC;
    private MessageCenterFragment hML;
    private MessageFragmentPagerAdapter hMV;
    private ImageView hMW;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.hML = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.ehd.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dgo = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.hML.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.hML.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.hML.getResources().getString(R.string.message_center_notification_tab);
        this.fTo = new ArrayList();
        this.fTo.add(aVar);
        this.fTo.add(aVar2);
        this.fTo.add(aVar3);
        this.hMV = new MessageFragmentPagerAdapter(this.hML.getActivity().getSupportFragmentManager(), this.fTo);
        this.dgo.setAdapter(this.hMV);
        this.dgo.setOffscreenPageLimit(this.fTo.size());
        this.hMV.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gKC = (TbTabLayout) LayoutInflater.from(this.hML.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gKC.setupWithViewPager(this.dgo);
        int tabCount = this.gKC.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e ap = this.gKC.ap(i);
                if (ap != null && !TextUtils.isEmpty(ap.getText())) {
                    if (ap.getText().equals(this.hML.getResources().getString(R.string.message_center_message_tab))) {
                        ap.ar(1);
                    } else if (ap.getText().equals(this.hML.getResources().getString(R.string.message_center_chat_tab))) {
                        ap.ar(2);
                    } else if (ap.getText().equals(this.hML.getResources().getString(R.string.message_center_notification_tab))) {
                        ap.ar(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.fTs = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fTs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hML != null) {
                    g.this.hML.bXV();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.hML.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.hMW = new ImageView(this.hML.getContext());
        this.hMW.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.hML.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.hML.getContext(), R.dimen.ds88)));
        this.hMW.setScaleType(ImageView.ScaleType.CENTER);
        this.fTs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hMW, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hML != null) {
                    g.this.hML.bXW();
                }
            }
        });
        if (this.hMW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hMW.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.hML.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.hMW.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.hMW.setVisibility(0);
        } else {
            this.hMW.setVisibility(4);
        }
        if (this.gKC != null) {
            this.fTs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gKC, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gKC.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gKC.setPadding(this.gKC.getPaddingLeft(), this.gKC.getPaddingTop(), this.gKC.getPaddingRight(), this.gKC.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.hML.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gKC != null && bVar != null) {
            this.gKC.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gKC != null && bVar != null) {
            this.gKC.b(bVar);
        }
    }

    public TbTabLayout bXY() {
        return this.gKC;
    }

    public void rH(int i) {
        TbTabLayout.e wW = wW(i);
        if (wW != null) {
            wW.select();
        }
    }

    public TbTabLayout.e bXZ() {
        if (this.gKC == null || this.gKC.getTabCount() <= 0) {
            return null;
        }
        return this.gKC.ap(this.gKC.getSelectedTabPosition());
    }

    public TbTabLayout.e wW(int i) {
        int tabCount;
        if (this.gKC != null && (tabCount = this.gKC.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e ap = this.gKC.ap(i2);
                if (ap != null && ap.getId() != -1 && ap.getId() == i) {
                    return ap;
                }
            }
            return null;
        }
        return null;
    }

    public boolean rI(int i) {
        int selectedTabPosition;
        TbTabLayout.e ap;
        return this.gKC != null && (selectedTabPosition = this.gKC.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gKC.getTabCount() + (-1) && (ap = this.gKC.ap(selectedTabPosition)) != null && ap.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e wW = wW(i);
        if (wW != null) {
            wW.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fTs != null) {
            this.fTs.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fTs.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(getPageContext(), i);
        }
        if (this.fTo != null && this.fTo.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fTo.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fTo.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.hMW != null) {
            SvgManager.aEp().a(this.hMW, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gKC != null) {
            this.gKC.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gKC.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fTo != null && this.fTo.size() > 0 && this.dgo != null) {
            MessageFragmentPagerAdapter.a aVar = this.fTo.get(this.dgo.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Hs() {
        if (this.hML != null && this.fTo != null && this.dgo != null && this.hMV != null) {
            FragmentManager supportFragmentManager = this.hML.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fTo.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dgo.getId(), this.hMV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.ehd != null) {
            this.ehd.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hMV != null) {
            this.hMV.setPrimary(z);
        }
        if (this.fTo != null && this.fTo.size() > 0 && this.dgo != null) {
            MessageFragmentPagerAdapter.a aVar = this.fTo.get(this.dgo.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fTo != null && this.fTo.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fTo.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fTo.get(i2);
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
