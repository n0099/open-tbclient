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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager bUV;
    private NoNetworkView dbr;
    private List<MessageFragmentPagerAdapter.a> eCZ;
    private NavigationBar eDb;
    private TbTabLayout fvQ;
    private MessageCenterFragment gxK;
    private MessageFragmentPagerAdapter gxT;
    private ImageView gxU;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gxK = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            K(bundle);
            L(bundle);
            M(bundle);
            this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.dbr.a(this);
        }
    }

    private void K(Bundle bundle) {
        this.bUV = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gxK.getResources().getString(d.j.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gxK.getResources().getString(d.j.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gxK.getResources().getString(d.j.message_center_notification_tab);
        this.eCZ = new ArrayList();
        this.eCZ.add(aVar);
        this.eCZ.add(aVar2);
        this.eCZ.add(aVar3);
        this.gxT = new MessageFragmentPagerAdapter(this.gxK.getActivity().getSupportFragmentManager(), this.eCZ);
        this.bUV.setAdapter(this.gxT);
        this.bUV.setOffscreenPageLimit(this.eCZ.size());
        this.gxT.notifyDataSetChanged();
    }

    private void L(Bundle bundle) {
        this.fvQ = (TbTabLayout) LayoutInflater.from(this.gxK.getContext()).inflate(d.h.message_center_tab_layout, (ViewGroup) null);
        this.fvQ.setupWithViewPager(this.bUV);
        int tabCount = this.fvQ.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e bc = this.fvQ.bc(i);
                if (bc != null && !TextUtils.isEmpty(bc.getText())) {
                    if (bc.getText().equals(this.gxK.getResources().getString(d.j.message_center_message_tab))) {
                        bc.be(1);
                    } else if (bc.getText().equals(this.gxK.getResources().getString(d.j.message_center_chat_tab))) {
                        bc.be(2);
                    } else if (bc.getText().equals(this.gxK.getResources().getString(d.j.message_center_notification_tab))) {
                        bc.be(3);
                    }
                }
            }
        }
    }

    private void M(Bundle bundle) {
        this.eDb = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        View addSystemImageButton = this.eDb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gxK != null) {
                    g.this.gxK.bxx();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gxK.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gxU = new ImageView(this.gxK.getContext());
        this.gxU.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.h(this.gxK.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.h(this.gxK.getContext(), d.e.ds88)));
        this.gxU.setScaleType(ImageView.ScaleType.CENTER);
        this.eDb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gxU, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gxK != null) {
                    g.this.gxK.bxy();
                }
            }
        });
        if (this.gxU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gxU.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.h(this.gxK.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.gxU.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            this.gxU.setVisibility(0);
        } else {
            this.gxU.setVisibility(4);
        }
        if (this.fvQ != null) {
            this.eDb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fvQ, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fvQ.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fvQ.setPadding(this.fvQ.getPaddingLeft(), this.fvQ.getPaddingTop(), this.fvQ.getPaddingRight(), this.fvQ.getBottom() + com.baidu.adp.lib.util.l.h(this.gxK.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fvQ != null && bVar != null) {
            this.fvQ.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fvQ != null && bVar != null) {
            this.fvQ.b(bVar);
        }
    }

    public TbTabLayout bxA() {
        return this.fvQ;
    }

    public void pb(int i) {
        TbTabLayout.e uv = uv(i);
        if (uv != null) {
            uv.select();
        }
    }

    public TbTabLayout.e bxB() {
        if (this.fvQ == null || this.fvQ.getTabCount() <= 0) {
            return null;
        }
        return this.fvQ.bc(this.fvQ.getSelectedTabPosition());
    }

    public TbTabLayout.e uv(int i) {
        int tabCount;
        if (this.fvQ != null && (tabCount = this.fvQ.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e bc = this.fvQ.bc(i2);
                if (bc != null && bc.getId() != -1 && bc.getId() == i) {
                    return bc;
                }
            }
            return null;
        }
        return null;
    }

    public boolean pc(int i) {
        int selectedTabPosition;
        TbTabLayout.e bc;
        return this.fvQ != null && (selectedTabPosition = this.fvQ.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fvQ.getTabCount() + (-1) && (bc = this.fvQ.bc(selectedTabPosition)) != null && bc.getId() == i;
    }

    public void h(int i, int i2, boolean z) {
        TbTabLayout.e uv = uv(i);
        if (uv != null) {
            uv.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eDb != null) {
            this.eDb.onChangeSkinType(getPageContext(), i);
            al.f(this.eDb.getBarBgView(), d.C0277d.cp_bg_line_d, i);
        }
        if (this.dbr != null) {
            this.dbr.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCZ != null && this.eCZ.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eCZ.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eCZ.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gxU != null) {
            al.c(this.gxU, d.f.selector_topbar_chat_black);
        }
        if (this.fvQ != null) {
            this.fvQ.setSelectedTabIndicatorColor(al.getColor(d.C0277d.cp_cont_f));
            this.fvQ.setTabTextColors(al.getColor(d.C0277d.cp_cont_j), al.getColor(d.C0277d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eCZ != null && this.eCZ.size() > 0 && this.bUV != null) {
            MessageFragmentPagerAdapter.a aVar = this.eCZ.get(this.bUV.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aWI() {
        if (this.gxK != null && this.eCZ != null && this.bUV != null && this.gxT != null) {
            FragmentManager supportFragmentManager = this.gxK.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eCZ.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.bUV.getId(), this.gxT.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dbr != null) {
            this.dbr.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gxT != null) {
            this.gxT.setPrimary(z);
        }
        if (this.eCZ != null && this.eCZ.size() > 0 && this.bUV != null) {
            MessageFragmentPagerAdapter.a aVar = this.eCZ.get(this.bUV.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.eCZ != null && this.eCZ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eCZ.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eCZ.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).dP(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
