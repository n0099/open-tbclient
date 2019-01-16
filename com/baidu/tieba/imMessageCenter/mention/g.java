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
    private BdBaseViewPager aMr;
    private NoNetworkView bPl;
    private TbTabLayout ehg;
    private NavigationBar eqJ;
    private MessageCenterFragment fhR;
    private MessageFragmentPagerAdapter fib;
    private List<MessageFragmentPagerAdapter.a> fic;
    private ImageView fie;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.fhR = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            A(bundle);
            B(bundle);
            C(bundle);
            this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bPl.a(this);
        }
    }

    private void A(Bundle bundle) {
        this.aMr = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.fhR.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.fhR.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.fhR.getResources().getString(e.j.message_center_notification_tab);
        this.fic = new ArrayList();
        this.fic.add(aVar);
        this.fic.add(aVar2);
        this.fic.add(aVar3);
        this.fib = new MessageFragmentPagerAdapter(this.fhR.getActivity().getSupportFragmentManager(), this.fic);
        this.aMr.setAdapter(this.fib);
        this.aMr.setOffscreenPageLimit(this.fic.size());
        this.fib.notifyDataSetChanged();
    }

    private void B(Bundle bundle) {
        this.ehg = (TbTabLayout) LayoutInflater.from(this.fhR.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.ehg.setupWithViewPager(this.aMr);
        int tabCount = this.ehg.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bq = this.ehg.bq(i);
                if (bq != null && !TextUtils.isEmpty(bq.getText())) {
                    if (bq.getText().equals(this.fhR.getResources().getString(e.j.message_center_message_tab))) {
                        bq.bs(1);
                    } else if (bq.getText().equals(this.fhR.getResources().getString(e.j.message_center_chat_tab))) {
                        bq.bs(2);
                    } else if (bq.getText().equals(this.fhR.getResources().getString(e.j.message_center_notification_tab))) {
                        bq.bs(3);
                    }
                }
            }
        }
    }

    private void C(Bundle bundle) {
        this.eqJ = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.eqJ.showBottomLine();
        View addSystemImageButton = this.eqJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fhR != null) {
                    g.this.fhR.aWW();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.fhR.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.fie = new ImageView(this.fhR.getContext());
        this.fie.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.fhR.getContext(), e.C0210e.ds88), com.baidu.adp.lib.util.l.h(this.fhR.getContext(), e.C0210e.ds88)));
        this.fie.setScaleType(ImageView.ScaleType.CENTER);
        this.eqJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fie, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fhR != null) {
                    g.this.fhR.aWX();
                }
            }
        });
        if (this.fie.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fie.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.fhR.getContext(), e.C0210e.ds14), marginLayoutParams.bottomMargin);
            this.fie.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.fie.setVisibility(0);
        } else {
            this.fie.setVisibility(4);
        }
        if (this.ehg != null) {
            this.eqJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.ehg, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ehg.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ehg.setPadding(this.ehg.getPaddingLeft(), this.ehg.getPaddingTop(), this.ehg.getPaddingRight(), this.ehg.getBottom() + com.baidu.adp.lib.util.l.h(this.fhR.getContext(), e.C0210e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.ehg != null && bVar != null) {
            this.ehg.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.ehg != null && bVar != null) {
            this.ehg.b(bVar);
        }
    }

    public TbTabLayout aWZ() {
        return this.ehg;
    }

    public void qP(int i) {
        TbTabLayout.e qQ = qQ(i);
        if (qQ != null) {
            qQ.select();
        }
    }

    public TbTabLayout.e aXa() {
        if (this.ehg == null || this.ehg.getTabCount() <= 0) {
            return null;
        }
        return this.ehg.bq(this.ehg.getSelectedTabPosition());
    }

    public TbTabLayout.e qQ(int i) {
        int tabCount;
        if (this.ehg != null && (tabCount = this.ehg.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bq = this.ehg.bq(i2);
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
        return this.ehg != null && (selectedTabPosition = this.ehg.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.ehg.getTabCount() + (-1) && (bq = this.ehg.bq(selectedTabPosition)) != null && bq.getId() == i;
    }

    public void g(int i, int i2, boolean z) {
        TbTabLayout.e qQ = qQ(i);
        if (qQ != null) {
            qQ.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eqJ != null) {
            this.eqJ.onChangeSkinType(getPageContext(), i);
            this.eqJ.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
        if (this.bPl != null) {
            this.bPl.onChangeSkinType(getPageContext(), i);
        }
        if (this.fic != null && this.fic.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fic.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fic.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.fie != null) {
            al.c(this.fie, e.f.selector_topbar_chat_black);
        }
        if (this.ehg != null) {
            this.ehg.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.ehg.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fic != null && this.fic.size() > 0 && this.aMr != null) {
            MessageFragmentPagerAdapter.a aVar = this.fic.get(this.aMr.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aXb() {
        if (this.fhR != null && this.fic != null && this.aMr != null && this.fib != null) {
            FragmentManager supportFragmentManager = this.fhR.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fic.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aMr.getId(), this.fib.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bPl != null) {
            this.bPl.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fib != null) {
            this.fib.setPrimary(z);
        }
        if (this.fic != null && this.fic.size() > 0 && this.aMr != null) {
            MessageFragmentPagerAdapter.a aVar = this.fic.get(this.aMr.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bG(boolean z) {
        if (this.fic != null && this.fic.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fic.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fic.get(i2);
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
