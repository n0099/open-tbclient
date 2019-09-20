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
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager ceT;
    private NoNetworkView dpy;
    private List<MessageFragmentPagerAdapter.a> eZH;
    private NavigationBar eZL;
    private TbTabLayout fUl;
    private MessageCenterFragment gXV;
    private MessageFragmentPagerAdapter gYf;
    private ImageView gYg;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gXV = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dpy.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.ceT = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gXV.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gXV.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gXV.getResources().getString(R.string.message_center_notification_tab);
        this.eZH = new ArrayList();
        this.eZH.add(aVar);
        this.eZH.add(aVar2);
        this.eZH.add(aVar3);
        this.gYf = new MessageFragmentPagerAdapter(this.gXV.getActivity().getSupportFragmentManager(), this.eZH);
        this.ceT.setAdapter(this.gYf);
        this.ceT.setOffscreenPageLimit(this.eZH.size());
        this.gYf.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fUl = (TbTabLayout) LayoutInflater.from(this.gXV.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fUl.setupWithViewPager(this.ceT);
        int tabCount = this.fUl.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aV = this.fUl.aV(i);
                if (aV != null && !TextUtils.isEmpty(aV.getText())) {
                    if (aV.getText().equals(this.gXV.getResources().getString(R.string.message_center_message_tab))) {
                        aV.aX(1);
                    } else if (aV.getText().equals(this.gXV.getResources().getString(R.string.message_center_chat_tab))) {
                        aV.aX(2);
                    } else if (aV.getText().equals(this.gXV.getResources().getString(R.string.message_center_notification_tab))) {
                        aV.aX(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.eZL = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.eZL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gXV != null) {
                    g.this.gXV.bIS();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gXV.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gYg = new ImageView(this.gXV.getContext());
        this.gYg.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.g(this.gXV.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.g(this.gXV.getContext(), R.dimen.ds88)));
        this.gYg.setScaleType(ImageView.ScaleType.CENTER);
        this.eZL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYg, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gXV != null) {
                    g.this.gXV.bIT();
                }
            }
        });
        if (this.gYg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gYg.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.g(this.gXV.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gYg.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hS().az("android_message_can_friend_chat") == 1) {
            this.gYg.setVisibility(0);
        } else {
            this.gYg.setVisibility(4);
        }
        if (this.fUl != null) {
            this.eZL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fUl, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fUl.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fUl.setPadding(this.fUl.getPaddingLeft(), this.fUl.getPaddingTop(), this.fUl.getPaddingRight(), this.fUl.getBottom() + com.baidu.adp.lib.util.l.g(this.gXV.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fUl != null && bVar != null) {
            this.fUl.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fUl != null && bVar != null) {
            this.fUl.b(bVar);
        }
    }

    public TbTabLayout bIV() {
        return this.fUl;
    }

    public void qB(int i) {
        TbTabLayout.e wk = wk(i);
        if (wk != null) {
            wk.select();
        }
    }

    public TbTabLayout.e bIW() {
        if (this.fUl == null || this.fUl.getTabCount() <= 0) {
            return null;
        }
        return this.fUl.aV(this.fUl.getSelectedTabPosition());
    }

    public TbTabLayout.e wk(int i) {
        int tabCount;
        if (this.fUl != null && (tabCount = this.fUl.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aV = this.fUl.aV(i2);
                if (aV != null && aV.getId() != -1 && aV.getId() == i) {
                    return aV;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qC(int i) {
        int selectedTabPosition;
        TbTabLayout.e aV;
        return this.fUl != null && (selectedTabPosition = this.fUl.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fUl.getTabCount() + (-1) && (aV = this.fUl.aV(selectedTabPosition)) != null && aV.getId() == i;
    }

    public void l(int i, int i2, boolean z) {
        TbTabLayout.e wk = wk(i);
        if (wk != null) {
            wk.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eZL != null) {
            this.eZL.onChangeSkinType(getPageContext(), i);
            am.h(this.eZL.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.dpy != null) {
            this.dpy.onChangeSkinType(getPageContext(), i);
        }
        if (this.eZH != null && this.eZH.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eZH.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eZH.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gYg != null) {
            SvgManager.ajv().a(this.gYg, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.fUl != null) {
            this.fUl.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.fUl.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eZH != null && this.eZH.size() > 0 && this.ceT != null) {
            MessageFragmentPagerAdapter.a aVar = this.eZH.get(this.ceT.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bgI() {
        if (this.gXV != null && this.eZH != null && this.ceT != null && this.gYf != null) {
            FragmentManager supportFragmentManager = this.gXV.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eZH.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ceT.getId(), this.gYf.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dpy != null) {
            this.dpy.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gYf != null) {
            this.gYf.setPrimary(z);
        }
        if (this.eZH != null && this.eZH.size() > 0 && this.ceT != null) {
            MessageFragmentPagerAdapter.a aVar = this.eZH.get(this.ceT.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void es(boolean z) {
        if (this.eZH != null && this.eZH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eZH.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eZH.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).es(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
