package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager aMs;
    private NoNetworkView bPm;
    private TbTabLayout ehh;
    private NavigationBar eqK;
    private MessageCenterFragment fhS;
    private MessageFragmentPagerAdapter fic;
    private List<MessageFragmentPagerAdapter.a> fie;
    private ImageView fif;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.fhS = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            A(bundle);
            B(bundle);
            C(bundle);
            this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bPm.a(this);
        }
    }

    private void A(Bundle bundle) {
        this.aMs = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.fhS.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.fhS.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.fhS.getResources().getString(e.j.message_center_notification_tab);
        this.fie = new ArrayList();
        this.fie.add(aVar);
        this.fie.add(aVar2);
        this.fie.add(aVar3);
        this.fic = new MessageFragmentPagerAdapter(this.fhS.getActivity().getSupportFragmentManager(), this.fie);
        this.aMs.setAdapter(this.fic);
        this.aMs.setOffscreenPageLimit(this.fie.size());
        this.fic.notifyDataSetChanged();
    }

    private void B(Bundle bundle) {
        this.ehh = (TbTabLayout) LayoutInflater.from(this.fhS.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.ehh.setupWithViewPager(this.aMs);
        int tabCount = this.ehh.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bq = this.ehh.bq(i);
                if (bq != null && !TextUtils.isEmpty(bq.getText())) {
                    if (bq.getText().equals(this.fhS.getResources().getString(e.j.message_center_message_tab))) {
                        bq.bs(1);
                    } else if (bq.getText().equals(this.fhS.getResources().getString(e.j.message_center_chat_tab))) {
                        bq.bs(2);
                    } else if (bq.getText().equals(this.fhS.getResources().getString(e.j.message_center_notification_tab))) {
                        bq.bs(3);
                    }
                }
            }
        }
    }

    private void C(Bundle bundle) {
        this.eqK = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.eqK.showBottomLine();
        View addSystemImageButton = this.eqK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fhS != null) {
                    g.this.fhS.aWW();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.fhS.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.fif = new ImageView(this.fhS.getContext());
        this.fif.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.fhS.getContext(), e.C0210e.ds88), com.baidu.adp.lib.util.l.h(this.fhS.getContext(), e.C0210e.ds88)));
        this.fif.setScaleType(ImageView.ScaleType.CENTER);
        this.eqK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fif, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fhS != null) {
                    g.this.fhS.aWX();
                }
            }
        });
        if (this.fif.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fif.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.fhS.getContext(), e.C0210e.ds14), marginLayoutParams.bottomMargin);
            this.fif.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.fif.setVisibility(0);
        } else {
            this.fif.setVisibility(4);
        }
        if (this.ehh != null) {
            this.eqK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.ehh, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ehh.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ehh.setPadding(this.ehh.getPaddingLeft(), this.ehh.getPaddingTop(), this.ehh.getPaddingRight(), this.ehh.getBottom() + com.baidu.adp.lib.util.l.h(this.fhS.getContext(), e.C0210e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.ehh != null && bVar != null) {
            this.ehh.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.ehh != null && bVar != null) {
            this.ehh.b(bVar);
        }
    }

    public TbTabLayout aWZ() {
        return this.ehh;
    }

    public void qP(int i) {
        TbTabLayout.e qQ = qQ(i);
        if (qQ != null) {
            qQ.select();
        }
    }

    public TbTabLayout.e aXa() {
        if (this.ehh == null || this.ehh.getTabCount() <= 0) {
            return null;
        }
        return this.ehh.bq(this.ehh.getSelectedTabPosition());
    }

    public TbTabLayout.e qQ(int i) {
        int tabCount;
        if (this.ehh != null && (tabCount = this.ehh.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bq = this.ehh.bq(i2);
                if (bq != null && bq.getId() != -1 && bq.getId() == i) {
                    return bq;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qR(int i) {
        int selectedTabPosition;
        TbTabLayout.e bq;
        return this.ehh != null && (selectedTabPosition = this.ehh.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.ehh.getTabCount() + (-1) && (bq = this.ehh.bq(selectedTabPosition)) != null && bq.getId() == i;
    }

    public void g(int i, int i2, boolean z) {
        TbTabLayout.e qQ = qQ(i);
        if (qQ != null) {
            qQ.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eqK != null) {
            this.eqK.onChangeSkinType(getPageContext(), i);
            this.eqK.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
        if (this.bPm != null) {
            this.bPm.onChangeSkinType(getPageContext(), i);
        }
        if (this.fie != null && this.fie.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fie.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fie.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.fif != null) {
            al.c(this.fif, e.f.selector_topbar_chat_black);
        }
        if (this.ehh != null) {
            this.ehh.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.ehh.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fie != null && this.fie.size() > 0 && this.aMs != null) {
            MessageFragmentPagerAdapter.a aVar = this.fie.get(this.aMs.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aXb() {
        if (this.fhS != null && this.fie != null && this.aMs != null && this.fic != null) {
            FragmentManager supportFragmentManager = this.fhS.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fie.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aMs.getId(), this.fic.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bPm != null) {
            this.bPm.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fic != null) {
            this.fic.setPrimary(z);
        }
        if (this.fie != null && this.fie.size() > 0 && this.aMs != null) {
            MessageFragmentPagerAdapter.a aVar = this.fie.get(this.aMs.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bG(boolean z) {
        if (this.fie != null && this.fie.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fie.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fie.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).bG(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
