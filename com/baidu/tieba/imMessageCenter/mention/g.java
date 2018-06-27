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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager azX;
    private NoNetworkView buT;
    private TbTabLayout dEo;
    private NavigationBar dNe;
    private MessageFragmentPagerAdapter eDB;
    private List<MessageFragmentPagerAdapter.a> eDC;
    private ImageView eDD;
    private MessageCenterFragment eDs;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eDs = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            t(bundle);
            u(bundle);
            v(bundle);
            this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.buT.a(this);
        }
    }

    private void t(Bundle bundle) {
        this.azX = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eDs.getResources().getString(d.k.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eDs.getResources().getString(d.k.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eDs.getResources().getString(d.k.message_center_notification_tab);
        this.eDC = new ArrayList();
        this.eDC.add(aVar);
        this.eDC.add(aVar2);
        this.eDC.add(aVar3);
        this.eDB = new MessageFragmentPagerAdapter(this.eDs.getActivity().getSupportFragmentManager(), this.eDC);
        this.azX.setAdapter(this.eDB);
        this.azX.setOffscreenPageLimit(this.eDC.size());
        this.eDB.notifyDataSetChanged();
    }

    private void u(Bundle bundle) {
        this.dEo = (TbTabLayout) LayoutInflater.from(this.eDs.getContext()).inflate(d.i.message_center_tab_layout, (ViewGroup) null);
        this.dEo.setupWithViewPager(this.azX);
        int tabCount = this.dEo.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aQ = this.dEo.aQ(i);
                if (aQ != null && !TextUtils.isEmpty(aQ.getText())) {
                    if (aQ.getText().equals(this.eDs.getResources().getString(d.k.message_center_message_tab))) {
                        aQ.aS(1);
                    } else if (aQ.getText().equals(this.eDs.getResources().getString(d.k.message_center_chat_tab))) {
                        aQ.aS(2);
                    } else if (aQ.getText().equals(this.eDs.getResources().getString(d.k.message_center_notification_tab))) {
                        aQ.aS(3);
                    }
                }
            }
        }
    }

    private void v(Bundle bundle) {
        this.dNe = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.dNe.showBottomLine();
        View addSystemImageButton = this.dNe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eDs != null) {
                    g.this.eDs.aNU();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eDs.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eDD = new ImageView(this.eDs.getContext());
        this.eDD.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.e(this.eDs.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.e(this.eDs.getContext(), d.e.ds88)));
        this.eDD.setScaleType(ImageView.ScaleType.CENTER);
        this.dNe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eDD, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eDs != null) {
                    g.this.eDs.aNV();
                }
            }
        });
        if (this.eDD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eDD.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.e(this.eDs.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.eDD.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hv().aw("android_message_can_friend_chat") == 1) {
            this.eDD.setVisibility(0);
        } else {
            this.eDD.setVisibility(4);
        }
        if (this.dEo != null) {
            this.dNe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dEo, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dEo.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dEo.setPadding(this.dEo.getPaddingLeft(), this.dEo.getPaddingTop(), this.dEo.getPaddingRight(), this.dEo.getBottom() + com.baidu.adp.lib.util.l.e(this.eDs.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.dEo != null && bVar != null) {
            this.dEo.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.dEo != null && bVar != null) {
            this.dEo.b(bVar);
        }
    }

    public TbTabLayout aNX() {
        return this.dEo;
    }

    public void selectTab(int i) {
        TbTabLayout.e oy = oy(i);
        if (oy != null) {
            oy.select();
        }
    }

    public TbTabLayout.e aNY() {
        if (this.dEo == null || this.dEo.getTabCount() <= 0) {
            return null;
        }
        return this.dEo.aQ(this.dEo.getSelectedTabPosition());
    }

    public TbTabLayout.e oy(int i) {
        int tabCount;
        if (this.dEo != null && (tabCount = this.dEo.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aQ = this.dEo.aQ(i2);
                if (aQ != null && aQ.getId() != -1 && aQ.getId() == i) {
                    return aQ;
                }
            }
            return null;
        }
        return null;
    }

    public boolean oz(int i) {
        int selectedTabPosition;
        TbTabLayout.e aQ;
        return this.dEo != null && (selectedTabPosition = this.dEo.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dEo.getTabCount() + (-1) && (aQ = this.dEo.aQ(selectedTabPosition)) != null && aQ.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e oy = oy(i);
        if (oy != null) {
            oy.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dNe != null) {
            this.dNe.onChangeSkinType(getPageContext(), i);
            this.dNe.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)).mutate());
        }
        if (this.buT != null) {
            this.buT.onChangeSkinType(getPageContext(), i);
        }
        if (this.eDC != null && this.eDC.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eDC.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eDC.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eDD != null) {
            am.c(this.eDD, d.f.selector_topbar_chat_black);
        }
        if (this.dEo != null) {
            this.dEo.setSelectedTabIndicatorColor(am.getColor(d.C0142d.cp_cont_f));
            this.dEo.setTabTextColors(am.getColor(d.C0142d.cp_cont_j), am.getColor(d.C0142d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eDC != null && this.eDC.size() > 0 && this.azX != null) {
            MessageFragmentPagerAdapter.a aVar = this.eDC.get(this.azX.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aNZ() {
        if (this.eDs != null && this.eDC != null && this.azX != null && this.eDB != null) {
            FragmentManager supportFragmentManager = this.eDs.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eDC.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.azX.getId(), this.eDB.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.buT != null) {
            this.buT.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eDB != null) {
            this.eDB.setPrimary(z);
        }
        if (this.eDC != null && this.eDC.size() > 0 && this.azX != null) {
            MessageFragmentPagerAdapter.a aVar = this.eDC.get(this.azX.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aS(boolean z) {
        if (this.eDC != null && this.eDC.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eDC.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eDC.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).aS(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
