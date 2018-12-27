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
    private BdBaseViewPager aLP;
    private NoNetworkView bOA;
    private TbTabLayout egA;
    private NavigationBar eqd;
    private MessageCenterFragment fhe;
    private MessageFragmentPagerAdapter fhn;
    private List<MessageFragmentPagerAdapter.a> fho;
    private ImageView fhp;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.fhe = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            A(bundle);
            B(bundle);
            C(bundle);
            this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bOA.a(this);
        }
    }

    private void A(Bundle bundle) {
        this.aLP = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.fhe.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.fhe.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.fhe.getResources().getString(e.j.message_center_notification_tab);
        this.fho = new ArrayList();
        this.fho.add(aVar);
        this.fho.add(aVar2);
        this.fho.add(aVar3);
        this.fhn = new MessageFragmentPagerAdapter(this.fhe.getActivity().getSupportFragmentManager(), this.fho);
        this.aLP.setAdapter(this.fhn);
        this.aLP.setOffscreenPageLimit(this.fho.size());
        this.fhn.notifyDataSetChanged();
    }

    private void B(Bundle bundle) {
        this.egA = (TbTabLayout) LayoutInflater.from(this.fhe.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.egA.setupWithViewPager(this.aLP);
        int tabCount = this.egA.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bq = this.egA.bq(i);
                if (bq != null && !TextUtils.isEmpty(bq.getText())) {
                    if (bq.getText().equals(this.fhe.getResources().getString(e.j.message_center_message_tab))) {
                        bq.bs(1);
                    } else if (bq.getText().equals(this.fhe.getResources().getString(e.j.message_center_chat_tab))) {
                        bq.bs(2);
                    } else if (bq.getText().equals(this.fhe.getResources().getString(e.j.message_center_notification_tab))) {
                        bq.bs(3);
                    }
                }
            }
        }
    }

    private void C(Bundle bundle) {
        this.eqd = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.eqd.showBottomLine();
        View addSystemImageButton = this.eqd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fhe != null) {
                    g.this.fhe.aWw();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.fhe.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.fhp = new ImageView(this.fhe.getContext());
        this.fhp.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.fhe.getContext(), e.C0210e.ds88), com.baidu.adp.lib.util.l.h(this.fhe.getContext(), e.C0210e.ds88)));
        this.fhp.setScaleType(ImageView.ScaleType.CENTER);
        this.eqd.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fhp, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fhe != null) {
                    g.this.fhe.aWx();
                }
            }
        });
        if (this.fhp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fhp.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.fhe.getContext(), e.C0210e.ds14), marginLayoutParams.bottomMargin);
            this.fhp.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.fhp.setVisibility(0);
        } else {
            this.fhp.setVisibility(4);
        }
        if (this.egA != null) {
            this.eqd.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.egA, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.egA.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.egA.setPadding(this.egA.getPaddingLeft(), this.egA.getPaddingTop(), this.egA.getPaddingRight(), this.egA.getBottom() + com.baidu.adp.lib.util.l.h(this.fhe.getContext(), e.C0210e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.egA != null && bVar != null) {
            this.egA.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.egA != null && bVar != null) {
            this.egA.b(bVar);
        }
    }

    public TbTabLayout aWz() {
        return this.egA;
    }

    public void qO(int i) {
        TbTabLayout.e qP = qP(i);
        if (qP != null) {
            qP.select();
        }
    }

    public TbTabLayout.e aWA() {
        if (this.egA == null || this.egA.getTabCount() <= 0) {
            return null;
        }
        return this.egA.bq(this.egA.getSelectedTabPosition());
    }

    public TbTabLayout.e qP(int i) {
        int tabCount;
        if (this.egA != null && (tabCount = this.egA.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bq = this.egA.bq(i2);
                if (bq != null && bq.getId() != -1 && bq.getId() == i) {
                    return bq;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qQ(int i) {
        int selectedTabPosition;
        TbTabLayout.e bq;
        return this.egA != null && (selectedTabPosition = this.egA.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.egA.getTabCount() + (-1) && (bq = this.egA.bq(selectedTabPosition)) != null && bq.getId() == i;
    }

    public void g(int i, int i2, boolean z) {
        TbTabLayout.e qP = qP(i);
        if (qP != null) {
            qP.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eqd != null) {
            this.eqd.onChangeSkinType(getPageContext(), i);
            this.eqd.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
        if (this.bOA != null) {
            this.bOA.onChangeSkinType(getPageContext(), i);
        }
        if (this.fho != null && this.fho.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fho.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fho.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.fhp != null) {
            al.c(this.fhp, e.f.selector_topbar_chat_black);
        }
        if (this.egA != null) {
            this.egA.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.egA.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fho != null && this.fho.size() > 0 && this.aLP != null) {
            MessageFragmentPagerAdapter.a aVar = this.fho.get(this.aLP.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aWB() {
        if (this.fhe != null && this.fho != null && this.aLP != null && this.fhn != null) {
            FragmentManager supportFragmentManager = this.fhe.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fho.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aLP.getId(), this.fhn.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bOA != null) {
            this.bOA.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fhn != null) {
            this.fhn.setPrimary(z);
        }
        if (this.fho != null && this.fho.size() > 0 && this.aLP != null) {
            MessageFragmentPagerAdapter.a aVar = this.fho.get(this.aLP.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bF(boolean z) {
        if (this.fho != null && this.fho.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fho.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fho.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).bF(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
