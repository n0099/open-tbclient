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
    private BdBaseViewPager aHx;
    private NoNetworkView bJX;
    private TbTabLayout dVZ;
    private MessageCenterFragment eWg;
    private MessageFragmentPagerAdapter eWp;
    private List<MessageFragmentPagerAdapter.a> eWq;
    private ImageView eWr;
    private NavigationBar eeZ;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eWg = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            u(bundle);
            v(bundle);
            w(bundle);
            this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bJX.a(this);
        }
    }

    private void u(Bundle bundle) {
        this.aHx = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eWg.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eWg.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eWg.getResources().getString(e.j.message_center_notification_tab);
        this.eWq = new ArrayList();
        this.eWq.add(aVar);
        this.eWq.add(aVar2);
        this.eWq.add(aVar3);
        this.eWp = new MessageFragmentPagerAdapter(this.eWg.getActivity().getSupportFragmentManager(), this.eWq);
        this.aHx.setAdapter(this.eWp);
        this.aHx.setOffscreenPageLimit(this.eWq.size());
        this.eWp.notifyDataSetChanged();
    }

    private void v(Bundle bundle) {
        this.dVZ = (TbTabLayout) LayoutInflater.from(this.eWg.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.dVZ.setupWithViewPager(this.aHx);
        int tabCount = this.dVZ.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bb = this.dVZ.bb(i);
                if (bb != null && !TextUtils.isEmpty(bb.getText())) {
                    if (bb.getText().equals(this.eWg.getResources().getString(e.j.message_center_message_tab))) {
                        bb.bd(1);
                    } else if (bb.getText().equals(this.eWg.getResources().getString(e.j.message_center_chat_tab))) {
                        bb.bd(2);
                    } else if (bb.getText().equals(this.eWg.getResources().getString(e.j.message_center_notification_tab))) {
                        bb.bd(3);
                    }
                }
            }
        }
    }

    private void w(Bundle bundle) {
        this.eeZ = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.eeZ.showBottomLine();
        View addSystemImageButton = this.eeZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eWg != null) {
                    g.this.eWg.aUu();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eWg.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eWr = new ImageView(this.eWg.getContext());
        this.eWr.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.eWg.getContext(), e.C0175e.ds88), com.baidu.adp.lib.util.l.h(this.eWg.getContext(), e.C0175e.ds88)));
        this.eWr.setScaleType(ImageView.ScaleType.CENTER);
        this.eeZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eWr, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eWg != null) {
                    g.this.eWg.aUv();
                }
            }
        });
        if (this.eWr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eWr.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.eWg.getContext(), e.C0175e.ds14), marginLayoutParams.bottomMargin);
            this.eWr.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iR().aO("android_message_can_friend_chat") == 1) {
            this.eWr.setVisibility(0);
        } else {
            this.eWr.setVisibility(4);
        }
        if (this.dVZ != null) {
            this.eeZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dVZ, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dVZ.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dVZ.setPadding(this.dVZ.getPaddingLeft(), this.dVZ.getPaddingTop(), this.dVZ.getPaddingRight(), this.dVZ.getBottom() + com.baidu.adp.lib.util.l.h(this.eWg.getContext(), e.C0175e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dVZ != null && bVar != null) {
            this.dVZ.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dVZ != null && bVar != null) {
            this.dVZ.b(bVar);
        }
    }

    public TbTabLayout aUx() {
        return this.dVZ;
    }

    public void pO(int i) {
        TbTabLayout.e pP = pP(i);
        if (pP != null) {
            pP.select();
        }
    }

    public TbTabLayout.e aUy() {
        if (this.dVZ == null || this.dVZ.getTabCount() <= 0) {
            return null;
        }
        return this.dVZ.bb(this.dVZ.getSelectedTabPosition());
    }

    public TbTabLayout.e pP(int i) {
        int tabCount;
        if (this.dVZ != null && (tabCount = this.dVZ.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bb = this.dVZ.bb(i2);
                if (bb != null && bb.getId() != -1 && bb.getId() == i) {
                    return bb;
                }
            }
            return null;
        }
        return null;
    }

    public boolean pQ(int i) {
        int selectedTabPosition;
        TbTabLayout.e bb;
        return this.dVZ != null && (selectedTabPosition = this.dVZ.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dVZ.getTabCount() + (-1) && (bb = this.dVZ.bb(selectedTabPosition)) != null && bb.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e pP = pP(i);
        if (pP != null) {
            pP.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eeZ != null) {
            this.eeZ.onChangeSkinType(getPageContext(), i);
            this.eeZ.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)).mutate());
        }
        if (this.bJX != null) {
            this.bJX.onChangeSkinType(getPageContext(), i);
        }
        if (this.eWq != null && this.eWq.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eWq.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eWq.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eWr != null) {
            al.c(this.eWr, e.f.selector_topbar_chat_black);
        }
        if (this.dVZ != null) {
            this.dVZ.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.dVZ.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eWq != null && this.eWq.size() > 0 && this.aHx != null) {
            MessageFragmentPagerAdapter.a aVar = this.eWq.get(this.aHx.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aUz() {
        if (this.eWg != null && this.eWq != null && this.aHx != null && this.eWp != null) {
            FragmentManager supportFragmentManager = this.eWg.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eWq.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aHx.getId(), this.eWp.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bJX != null) {
            this.bJX.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eWp != null) {
            this.eWp.setPrimary(z);
        }
        if (this.eWq != null && this.eWq.size() > 0 && this.aHx != null) {
            MessageFragmentPagerAdapter.a aVar = this.eWq.get(this.aHx.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bn(boolean z) {
        if (this.eWq != null && this.eWq.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eWq.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eWq.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).bn(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
