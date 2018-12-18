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
    private BdBaseViewPager aLN;
    private NoNetworkView bOx;
    private TbTabLayout edJ;
    private NavigationBar enm;
    private MessageCenterFragment fen;
    private MessageFragmentPagerAdapter few;
    private List<MessageFragmentPagerAdapter.a> fex;
    private ImageView fey;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.fen = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            A(bundle);
            B(bundle);
            C(bundle);
            this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
            this.bOx.a(this);
        }
    }

    private void A(Bundle bundle) {
        this.aLN = (BdBaseViewPager) this.mRootView.findViewById(e.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.fen.getResources().getString(e.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.fen.getResources().getString(e.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.fen.getResources().getString(e.j.message_center_notification_tab);
        this.fex = new ArrayList();
        this.fex.add(aVar);
        this.fex.add(aVar2);
        this.fex.add(aVar3);
        this.few = new MessageFragmentPagerAdapter(this.fen.getActivity().getSupportFragmentManager(), this.fex);
        this.aLN.setAdapter(this.few);
        this.aLN.setOffscreenPageLimit(this.fex.size());
        this.few.notifyDataSetChanged();
    }

    private void B(Bundle bundle) {
        this.edJ = (TbTabLayout) LayoutInflater.from(this.fen.getContext()).inflate(e.h.message_center_tab_layout, (ViewGroup) null);
        this.edJ.setupWithViewPager(this.aLN);
        int tabCount = this.edJ.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bq = this.edJ.bq(i);
                if (bq != null && !TextUtils.isEmpty(bq.getText())) {
                    if (bq.getText().equals(this.fen.getResources().getString(e.j.message_center_message_tab))) {
                        bq.bs(1);
                    } else if (bq.getText().equals(this.fen.getResources().getString(e.j.message_center_chat_tab))) {
                        bq.bs(2);
                    } else if (bq.getText().equals(this.fen.getResources().getString(e.j.message_center_notification_tab))) {
                        bq.bs(3);
                    }
                }
            }
        }
    }

    private void C(Bundle bundle) {
        this.enm = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.enm.showBottomLine();
        View addSystemImageButton = this.enm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fen != null) {
                    g.this.fen.aVI();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.fen.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.fey = new ImageView(this.fen.getContext());
        this.fey.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.fen.getContext(), e.C0210e.ds88), com.baidu.adp.lib.util.l.h(this.fen.getContext(), e.C0210e.ds88)));
        this.fey.setScaleType(ImageView.ScaleType.CENTER);
        this.enm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fey, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fen != null) {
                    g.this.fen.aVJ();
                }
            }
        });
        if (this.fey.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fey.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.fen.getContext(), e.C0210e.ds14), marginLayoutParams.bottomMargin);
            this.fey.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.fey.setVisibility(0);
        } else {
            this.fey.setVisibility(4);
        }
        if (this.edJ != null) {
            this.enm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.edJ, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.edJ.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.edJ.setPadding(this.edJ.getPaddingLeft(), this.edJ.getPaddingTop(), this.edJ.getPaddingRight(), this.edJ.getBottom() + com.baidu.adp.lib.util.l.h(this.fen.getContext(), e.C0210e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.edJ != null && bVar != null) {
            this.edJ.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.edJ != null && bVar != null) {
            this.edJ.b(bVar);
        }
    }

    public TbTabLayout aVL() {
        return this.edJ;
    }

    public void qB(int i) {
        TbTabLayout.e qC = qC(i);
        if (qC != null) {
            qC.select();
        }
    }

    public TbTabLayout.e aVM() {
        if (this.edJ == null || this.edJ.getTabCount() <= 0) {
            return null;
        }
        return this.edJ.bq(this.edJ.getSelectedTabPosition());
    }

    public TbTabLayout.e qC(int i) {
        int tabCount;
        if (this.edJ != null && (tabCount = this.edJ.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bq = this.edJ.bq(i2);
                if (bq != null && bq.getId() != -1 && bq.getId() == i) {
                    return bq;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qD(int i) {
        int selectedTabPosition;
        TbTabLayout.e bq;
        return this.edJ != null && (selectedTabPosition = this.edJ.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.edJ.getTabCount() + (-1) && (bq = this.edJ.bq(selectedTabPosition)) != null && bq.getId() == i;
    }

    public void g(int i, int i2, boolean z) {
        TbTabLayout.e qC = qC(i);
        if (qC != null) {
            qC.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.enm != null) {
            this.enm.onChangeSkinType(getPageContext(), i);
            this.enm.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
        if (this.bOx != null) {
            this.bOx.onChangeSkinType(getPageContext(), i);
        }
        if (this.fex != null && this.fex.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fex.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fex.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.fey != null) {
            al.c(this.fey, e.f.selector_topbar_chat_black);
        }
        if (this.edJ != null) {
            this.edJ.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.edJ.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fex != null && this.fex.size() > 0 && this.aLN != null) {
            MessageFragmentPagerAdapter.a aVar = this.fex.get(this.aLN.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aVN() {
        if (this.fen != null && this.fex != null && this.aLN != null && this.few != null) {
            FragmentManager supportFragmentManager = this.fen.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fex.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aLN.getId(), this.few.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.bOx != null) {
            this.bOx.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.few != null) {
            this.few.setPrimary(z);
        }
        if (this.fex != null && this.fex.size() > 0 && this.aLN != null) {
            MessageFragmentPagerAdapter.a aVar = this.fex.get(this.aLN.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bF(boolean z) {
        if (this.fex != null && this.fex.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fex.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fex.get(i2);
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
