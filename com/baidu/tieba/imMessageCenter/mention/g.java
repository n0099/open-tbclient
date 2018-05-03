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
    private TbTabLayout dqH;
    private NavigationBar dxv;
    private MessageCenterFragment enc;
    private MessageFragmentPagerAdapter enl;
    private List<MessageFragmentPagerAdapter.a> enm;
    private ImageView enn;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.enc = messageCenterFragment;
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
        aVar.title = this.enc.getResources().getString(d.k.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.enc.getResources().getString(d.k.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.enc.getResources().getString(d.k.message_center_notification_tab);
        this.enm = new ArrayList();
        this.enm.add(aVar);
        this.enm.add(aVar2);
        this.enm.add(aVar3);
        this.enl = new MessageFragmentPagerAdapter(this.enc.getActivity().getSupportFragmentManager(), this.enm);
        this.aqY.setAdapter(this.enl);
        this.aqY.setOffscreenPageLimit(this.enm.size());
        this.enl.notifyDataSetChanged();
    }

    private void t(Bundle bundle) {
        this.dqH = (TbTabLayout) LayoutInflater.from(this.enc.getContext()).inflate(d.i.message_center_tab_layout, (ViewGroup) null);
        this.dqH.setupWithViewPager(this.aqY);
        int tabCount = this.dqH.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aP = this.dqH.aP(i);
                if (aP != null && !TextUtils.isEmpty(aP.getText())) {
                    if (aP.getText().equals(this.enc.getResources().getString(d.k.message_center_message_tab))) {
                        aP.aR(1);
                    } else if (aP.getText().equals(this.enc.getResources().getString(d.k.message_center_chat_tab))) {
                        aP.aR(2);
                    } else if (aP.getText().equals(this.enc.getResources().getString(d.k.message_center_notification_tab))) {
                        aP.aR(3);
                    }
                }
            }
        }
    }

    private void u(Bundle bundle) {
        this.dxv = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.dxv.showBottomLine();
        View addSystemImageButton = this.dxv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.enc != null) {
                    g.this.enc.aIu();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.enc.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.enn = new ImageView(this.enc.getContext());
        this.enn.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.e(this.enc.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.e(this.enc.getContext(), d.e.ds88)));
        this.enn.setScaleType(ImageView.ScaleType.CENTER);
        this.dxv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.enn, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.enc != null) {
                    g.this.enc.aIv();
                }
            }
        });
        if (this.enn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.enn.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.e(this.enc.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.enn.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.eE().ak("android_message_can_friend_chat") == 1) {
            this.enn.setVisibility(0);
        } else {
            this.enn.setVisibility(4);
        }
        if (this.dqH != null) {
            this.dxv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dqH, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dqH.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dqH.setPadding(this.dqH.getPaddingLeft(), this.dqH.getPaddingTop(), this.dqH.getPaddingRight(), this.dqH.getBottom() + com.baidu.adp.lib.util.l.e(this.enc.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dqH != null && bVar != null) {
            this.dqH.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dqH != null && bVar != null) {
            this.dqH.b(bVar);
        }
    }

    public TbTabLayout aIx() {
        return this.dqH;
    }

    public void selectTab(int i) {
        TbTabLayout.e og = og(i);
        if (og != null) {
            og.select();
        }
    }

    public TbTabLayout.e aIy() {
        if (this.dqH == null || this.dqH.getTabCount() <= 0) {
            return null;
        }
        return this.dqH.aP(this.dqH.getSelectedTabPosition());
    }

    public TbTabLayout.e og(int i) {
        int tabCount;
        if (this.dqH != null && (tabCount = this.dqH.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aP = this.dqH.aP(i2);
                if (aP != null && aP.getId() != -1 && aP.getId() == i) {
                    return aP;
                }
            }
            return null;
        }
        return null;
    }

    public boolean oh(int i) {
        int selectedTabPosition;
        TbTabLayout.e aP;
        return this.dqH != null && (selectedTabPosition = this.dqH.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dqH.getTabCount() + (-1) && (aP = this.dqH.aP(selectedTabPosition)) != null && aP.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e og = og(i);
        if (og != null) {
            og.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dxv != null) {
            this.dxv.onChangeSkinType(getPageContext(), i);
            this.dxv.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cO(d.f.s_navbar_bg)).mutate());
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(getPageContext(), i);
        }
        if (this.enm != null && this.enm.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.enm.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.enm.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.enn != null) {
            ak.c(this.enn, d.f.icon_tobar_friend_add);
        }
        if (this.dqH != null) {
            this.dqH.setSelectedTabIndicatorColor(ak.getColor(d.C0126d.cp_cont_f));
            this.dqH.setTabTextColors(ak.getColor(d.C0126d.cp_cont_j), ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.enm != null && this.enm.size() > 0 && this.aqY != null) {
            MessageFragmentPagerAdapter.a aVar = this.enm.get(this.aqY.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aIz() {
        if (this.enc != null && this.enm != null && this.aqY != null && this.enl != null) {
            FragmentManager supportFragmentManager = this.enc.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.enm.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aqY.getId(), this.enl.getItemId(i)));
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
        if (this.enl != null) {
            this.enl.setPrimary(z);
        }
        if (this.enm != null && this.enm.size() > 0 && this.aqY != null) {
            MessageFragmentPagerAdapter.a aVar = this.enm.get(this.aqY.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.enm != null && this.enm.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.enm.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.enm.get(i2);
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
