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
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager aCR;
    private NoNetworkView bBq;
    private TbTabLayout dOd;
    private NavigationBar dXf;
    private MessageFragmentPagerAdapter eOG;
    private List<MessageFragmentPagerAdapter.a> eOH;
    private ImageView eOI;
    private MessageCenterFragment eOx;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eOx = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            t(bundle);
            u(bundle);
            v(bundle);
            this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bBq.a(this);
        }
    }

    private void t(Bundle bundle) {
        this.aCR = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eOx.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eOx.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eOx.getResources().getString(e.j.message_center_notification_tab);
        this.eOH = new ArrayList();
        this.eOH.add(aVar);
        this.eOH.add(aVar2);
        this.eOH.add(aVar3);
        this.eOG = new MessageFragmentPagerAdapter(this.eOx.getActivity().getSupportFragmentManager(), this.eOH);
        this.aCR.setAdapter(this.eOG);
        this.aCR.setOffscreenPageLimit(this.eOH.size());
        this.eOG.notifyDataSetChanged();
    }

    private void u(Bundle bundle) {
        this.dOd = (TbTabLayout) LayoutInflater.from(this.eOx.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.dOd.setupWithViewPager(this.aCR);
        int tabCount = this.dOd.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bb = this.dOd.bb(i);
                if (bb != null && !TextUtils.isEmpty(bb.getText())) {
                    if (bb.getText().equals(this.eOx.getResources().getString(e.j.message_center_message_tab))) {
                        bb.bd(1);
                    } else if (bb.getText().equals(this.eOx.getResources().getString(e.j.message_center_chat_tab))) {
                        bb.bd(2);
                    } else if (bb.getText().equals(this.eOx.getResources().getString(e.j.message_center_notification_tab))) {
                        bb.bd(3);
                    }
                }
            }
        }
    }

    private void v(Bundle bundle) {
        this.dXf = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.dXf.showBottomLine();
        View addSystemImageButton = this.dXf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eOx != null) {
                    g.this.eOx.aRg();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eOx.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eOI = new ImageView(this.eOx.getContext());
        this.eOI.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.eOx.getContext(), e.C0141e.ds88), com.baidu.adp.lib.util.l.h(this.eOx.getContext(), e.C0141e.ds88)));
        this.eOI.setScaleType(ImageView.ScaleType.CENTER);
        this.dXf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eOI, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eOx != null) {
                    g.this.eOx.aRh();
                }
            }
        });
        if (this.eOI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eOI.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.eOx.getContext(), e.C0141e.ds14), marginLayoutParams.bottomMargin);
            this.eOI.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iB().aO("android_message_can_friend_chat") == 1) {
            this.eOI.setVisibility(0);
        } else {
            this.eOI.setVisibility(4);
        }
        if (this.dOd != null) {
            this.dXf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dOd, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dOd.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dOd.setPadding(this.dOd.getPaddingLeft(), this.dOd.getPaddingTop(), this.dOd.getPaddingRight(), this.dOd.getBottom() + com.baidu.adp.lib.util.l.h(this.eOx.getContext(), e.C0141e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dOd != null && bVar != null) {
            this.dOd.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dOd != null && bVar != null) {
            this.dOd.b(bVar);
        }
    }

    public TbTabLayout aRj() {
        return this.dOd;
    }

    public void pq(int i) {
        TbTabLayout.e pr = pr(i);
        if (pr != null) {
            pr.select();
        }
    }

    public TbTabLayout.e aRk() {
        if (this.dOd == null || this.dOd.getTabCount() <= 0) {
            return null;
        }
        return this.dOd.bb(this.dOd.getSelectedTabPosition());
    }

    public TbTabLayout.e pr(int i) {
        int tabCount;
        if (this.dOd != null && (tabCount = this.dOd.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bb = this.dOd.bb(i2);
                if (bb != null && bb.getId() != -1 && bb.getId() == i) {
                    return bb;
                }
            }
            return null;
        }
        return null;
    }

    public boolean ps(int i) {
        int selectedTabPosition;
        TbTabLayout.e bb;
        return this.dOd != null && (selectedTabPosition = this.dOd.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dOd.getTabCount() + (-1) && (bb = this.dOd.bb(selectedTabPosition)) != null && bb.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e pr = pr(i);
        if (pr != null) {
            pr.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dXf != null) {
            this.dXf.onChangeSkinType(getPageContext(), i);
            this.dXf.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)).mutate());
        }
        if (this.bBq != null) {
            this.bBq.onChangeSkinType(getPageContext(), i);
        }
        if (this.eOH != null && this.eOH.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eOH.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eOH.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eOI != null) {
            al.c(this.eOI, e.f.selector_topbar_chat_black);
        }
        if (this.dOd != null) {
            this.dOd.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.dOd.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eOH != null && this.eOH.size() > 0 && this.aCR != null) {
            MessageFragmentPagerAdapter.a aVar = this.eOH.get(this.aCR.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aRl() {
        if (this.eOx != null && this.eOH != null && this.aCR != null && this.eOG != null) {
            FragmentManager supportFragmentManager = this.eOx.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eOH.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aCR.getId(), this.eOG.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bBq != null) {
            this.bBq.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eOG != null) {
            this.eOG.setPrimary(z);
        }
        if (this.eOH != null && this.eOH.size() > 0 && this.aCR != null) {
            MessageFragmentPagerAdapter.a aVar = this.eOH.get(this.aCR.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bd(boolean z) {
        if (this.eOH != null && this.eOH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eOH.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eOH.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).bd(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
