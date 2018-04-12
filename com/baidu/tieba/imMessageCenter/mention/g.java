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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager aqY;
    private NoNetworkView bla;
    private TbTabLayout dqK;
    private NavigationBar dxy;
    private MessageCenterFragment eng;
    private MessageFragmentPagerAdapter eno;
    private List<MessageFragmentPagerAdapter.a> enp;
    private ImageView enq;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eng = messageCenterFragment;
    }

    public void a(View view2, Bundle bundle) {
        if (view2 != null) {
            this.mRootView = view2;
            s(bundle);
            t(bundle);
            u(bundle);
            this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.bla.a(this);
        }
    }

    private void s(Bundle bundle) {
        this.aqY = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eng.getResources().getString(d.k.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eng.getResources().getString(d.k.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eng.getResources().getString(d.k.message_center_notification_tab);
        this.enp = new ArrayList();
        this.enp.add(aVar);
        this.enp.add(aVar2);
        this.enp.add(aVar3);
        this.eno = new MessageFragmentPagerAdapter(this.eng.getActivity().getSupportFragmentManager(), this.enp);
        this.aqY.setAdapter(this.eno);
        this.aqY.setOffscreenPageLimit(this.enp.size());
        this.eno.notifyDataSetChanged();
    }

    private void t(Bundle bundle) {
        this.dqK = (TbTabLayout) LayoutInflater.from(this.eng.getContext()).inflate(d.i.message_center_tab_layout, (ViewGroup) null);
        this.dqK.setupWithViewPager(this.aqY);
        int tabCount = this.dqK.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aP = this.dqK.aP(i);
                if (aP != null && !TextUtils.isEmpty(aP.getText())) {
                    if (aP.getText().equals(this.eng.getResources().getString(d.k.message_center_message_tab))) {
                        aP.aR(1);
                    } else if (aP.getText().equals(this.eng.getResources().getString(d.k.message_center_chat_tab))) {
                        aP.aR(2);
                    } else if (aP.getText().equals(this.eng.getResources().getString(d.k.message_center_notification_tab))) {
                        aP.aR(3);
                    }
                }
            }
        }
    }

    private void u(Bundle bundle) {
        this.dxy = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.dxy.showBottomLine();
        View addSystemImageButton = this.dxy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.eng != null) {
                    g.this.eng.aIu();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eng.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.enq = new ImageView(this.eng.getContext());
        this.enq.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.e(this.eng.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.e(this.eng.getContext(), d.e.ds88)));
        this.enq.setScaleType(ImageView.ScaleType.CENTER);
        this.dxy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.enq, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.eng != null) {
                    g.this.eng.aIv();
                }
            }
        });
        if (this.enq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.enq.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.e(this.eng.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.enq.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.eE().ak("android_message_can_friend_chat") == 1) {
            this.enq.setVisibility(0);
        } else {
            this.enq.setVisibility(4);
        }
        if (this.dqK != null) {
            this.dxy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dqK, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dqK.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dqK.setPadding(this.dqK.getPaddingLeft(), this.dqK.getPaddingTop(), this.dqK.getPaddingRight(), this.dqK.getBottom() + com.baidu.adp.lib.util.l.e(this.eng.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dqK != null && bVar != null) {
            this.dqK.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dqK != null && bVar != null) {
            this.dqK.b(bVar);
        }
    }

    public TbTabLayout aIx() {
        return this.dqK;
    }

    public void selectTab(int i) {
        TbTabLayout.e oh = oh(i);
        if (oh != null) {
            oh.select();
        }
    }

    public TbTabLayout.e aIy() {
        if (this.dqK == null || this.dqK.getTabCount() <= 0) {
            return null;
        }
        return this.dqK.aP(this.dqK.getSelectedTabPosition());
    }

    public TbTabLayout.e oh(int i) {
        int tabCount;
        if (this.dqK != null && (tabCount = this.dqK.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aP = this.dqK.aP(i2);
                if (aP != null && aP.getId() != -1 && aP.getId() == i) {
                    return aP;
                }
            }
            return null;
        }
        return null;
    }

    public boolean oi(int i) {
        int selectedTabPosition;
        TbTabLayout.e aP;
        return this.dqK != null && (selectedTabPosition = this.dqK.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dqK.getTabCount() + (-1) && (aP = this.dqK.aP(selectedTabPosition)) != null && aP.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e oh = oh(i);
        if (oh != null) {
            oh.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dxy != null) {
            this.dxy.onChangeSkinType(getPageContext(), i);
            this.dxy.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)).mutate());
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(getPageContext(), i);
        }
        if (this.enp != null && this.enp.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.enp.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.enp.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.enq != null) {
            ak.c(this.enq, d.f.icon_tobar_friend_add);
        }
        if (this.dqK != null) {
            this.dqK.setSelectedTabIndicatorColor(ak.getColor(d.C0126d.cp_cont_f));
            this.dqK.setTabTextColors(ak.getColor(d.C0126d.cp_cont_j), ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.enp != null && this.enp.size() > 0 && this.aqY != null) {
            MessageFragmentPagerAdapter.a aVar = this.enp.get(this.aqY.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aIz() {
        if (this.eng != null && this.enp != null && this.aqY != null && this.eno != null) {
            FragmentManager supportFragmentManager = this.eng.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.enp.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aqY.getId(), this.eno.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bla != null) {
            this.bla.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eno != null) {
            this.eno.setPrimary(z);
        }
        if (this.enp != null && this.enp.size() > 0 && this.aqY != null) {
            MessageFragmentPagerAdapter.a aVar = this.enp.get(this.aqY.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.enp != null && this.enp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.enp.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.enp.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).aM(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
