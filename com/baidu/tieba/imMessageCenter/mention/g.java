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
    private BdBaseViewPager ctf;
    private NoNetworkView dwI;
    private TbTabLayout fTF;
    private List<MessageFragmentPagerAdapter.a> fcs;
    private NavigationBar fcw;
    private MessageCenterFragment gVW;
    private MessageFragmentPagerAdapter gWg;
    private ImageView gWh;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gVW = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dwI.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.ctf = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gVW.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gVW.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gVW.getResources().getString(R.string.message_center_notification_tab);
        this.fcs = new ArrayList();
        this.fcs.add(aVar);
        this.fcs.add(aVar2);
        this.fcs.add(aVar3);
        this.gWg = new MessageFragmentPagerAdapter(this.gVW.getActivity().getSupportFragmentManager(), this.fcs);
        this.ctf.setAdapter(this.gWg);
        this.ctf.setOffscreenPageLimit(this.fcs.size());
        this.gWg.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fTF = (TbTabLayout) LayoutInflater.from(this.gVW.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fTF.setupWithViewPager(this.ctf);
        int tabCount = this.fTF.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e am = this.fTF.am(i);
                if (am != null && !TextUtils.isEmpty(am.getText())) {
                    if (am.getText().equals(this.gVW.getResources().getString(R.string.message_center_message_tab))) {
                        am.ao(1);
                    } else if (am.getText().equals(this.gVW.getResources().getString(R.string.message_center_chat_tab))) {
                        am.ao(2);
                    } else if (am.getText().equals(this.gVW.getResources().getString(R.string.message_center_notification_tab))) {
                        am.ao(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.fcw = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fcw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gVW != null) {
                    g.this.gVW.bFC();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gVW.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gWh = new ImageView(this.gVW.getContext());
        this.gWh.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.gVW.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.gVW.getContext(), R.dimen.ds88)));
        this.gWh.setScaleType(ImageView.ScaleType.CENTER);
        this.fcw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gWh, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gVW != null) {
                    g.this.gVW.bFD();
                }
            }
        });
        if (this.gWh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gWh.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.gVW.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gWh.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.ft().af("android_message_can_friend_chat") == 1) {
            this.gWh.setVisibility(0);
        } else {
            this.gWh.setVisibility(4);
        }
        if (this.fTF != null) {
            this.fcw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fTF, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fTF.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fTF.setPadding(this.fTF.getPaddingLeft(), this.fTF.getPaddingTop(), this.fTF.getPaddingRight(), this.fTF.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.gVW.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fTF != null && bVar != null) {
            this.fTF.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fTF != null && bVar != null) {
            this.fTF.b(bVar);
        }
    }

    public TbTabLayout bFF() {
        return this.fTF;
    }

    public void px(int i) {
        TbTabLayout.e uQ = uQ(i);
        if (uQ != null) {
            uQ.select();
        }
    }

    public TbTabLayout.e bFG() {
        if (this.fTF == null || this.fTF.getTabCount() <= 0) {
            return null;
        }
        return this.fTF.am(this.fTF.getSelectedTabPosition());
    }

    public TbTabLayout.e uQ(int i) {
        int tabCount;
        if (this.fTF != null && (tabCount = this.fTF.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e am = this.fTF.am(i2);
                if (am != null && am.getId() != -1 && am.getId() == i) {
                    return am;
                }
            }
            return null;
        }
        return null;
    }

    public boolean py(int i) {
        int selectedTabPosition;
        TbTabLayout.e am;
        return this.fTF != null && (selectedTabPosition = this.fTF.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fTF.getTabCount() + (-1) && (am = this.fTF.am(selectedTabPosition)) != null && am.getId() == i;
    }

    public void k(int i, int i2, boolean z) {
        TbTabLayout.e uQ = uQ(i);
        if (uQ != null) {
            uQ.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fcw != null) {
            this.fcw.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fcw.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.dwI != null) {
            this.dwI.onChangeSkinType(getPageContext(), i);
        }
        if (this.fcs != null && this.fcs.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fcs.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fcs.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gWh != null) {
            SvgManager.amN().a(this.gWh, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.fTF != null) {
            this.fTF.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.fTF.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fcs != null && this.fcs.size() > 0 && this.ctf != null) {
            MessageFragmentPagerAdapter.a aVar = this.fcs.get(this.ctf.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void beB() {
        if (this.gVW != null && this.fcs != null && this.ctf != null && this.gWg != null) {
            FragmentManager supportFragmentManager = this.gVW.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fcs.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ctf.getId(), this.gWg.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dwI != null) {
            this.dwI.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gWg != null) {
            this.gWg.setPrimary(z);
        }
        if (this.fcs != null && this.fcs.size() > 0 && this.ctf != null) {
            MessageFragmentPagerAdapter.a aVar = this.fcs.get(this.ctf.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fcs != null && this.fcs.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fcs.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fcs.get(i2);
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
