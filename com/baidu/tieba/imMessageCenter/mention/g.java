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
    private NoNetworkView blp;
    private TbTabLayout drP;
    private NavigationBar dyC;
    private MessageCenterFragment eol;
    private MessageFragmentPagerAdapter eou;
    private List<MessageFragmentPagerAdapter.a> eov;
    private ImageView eow;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.eol = messageCenterFragment;
    }

    public void a(View view2, Bundle bundle) {
        if (view2 != null) {
            this.mRootView = view2;
            s(bundle);
            t(bundle);
            u(bundle);
            this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.blp.a(this);
        }
    }

    private void s(Bundle bundle) {
        this.aqY = (BdBaseViewPager) this.mRootView.findViewById(d.g.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.eol.getResources().getString(d.k.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.eol.getResources().getString(d.k.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.eol.getResources().getString(d.k.message_center_notification_tab);
        this.eov = new ArrayList();
        this.eov.add(aVar);
        this.eov.add(aVar2);
        this.eov.add(aVar3);
        this.eou = new MessageFragmentPagerAdapter(this.eol.getActivity().getSupportFragmentManager(), this.eov);
        this.aqY.setAdapter(this.eou);
        this.aqY.setOffscreenPageLimit(this.eov.size());
        this.eou.notifyDataSetChanged();
    }

    private void t(Bundle bundle) {
        this.drP = (TbTabLayout) LayoutInflater.from(this.eol.getContext()).inflate(d.i.message_center_tab_layout, (ViewGroup) null);
        this.drP.setupWithViewPager(this.aqY);
        int tabCount = this.drP.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aP = this.drP.aP(i);
                if (aP != null && !TextUtils.isEmpty(aP.getText())) {
                    if (aP.getText().equals(this.eol.getResources().getString(d.k.message_center_message_tab))) {
                        aP.aR(1);
                    } else if (aP.getText().equals(this.eol.getResources().getString(d.k.message_center_chat_tab))) {
                        aP.aR(2);
                    } else if (aP.getText().equals(this.eol.getResources().getString(d.k.message_center_notification_tab))) {
                        aP.aR(3);
                    }
                }
            }
        }
    }

    private void u(Bundle bundle) {
        this.dyC = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.dyC.showBottomLine();
        View addSystemImageButton = this.dyC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.eol != null) {
                    g.this.eol.aIt();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.eol.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.eow = new ImageView(this.eol.getContext());
        this.eow.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.e(this.eol.getContext(), d.e.ds88), com.baidu.adp.lib.util.l.e(this.eol.getContext(), d.e.ds88)));
        this.eow.setScaleType(ImageView.ScaleType.CENTER);
        this.dyC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eow, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.eol != null) {
                    g.this.eol.aIu();
                }
            }
        });
        if (this.eow.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eow.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.e(this.eol.getContext(), d.e.ds14), marginLayoutParams.bottomMargin);
            this.eow.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.eE().ak("android_message_can_friend_chat") == 1) {
            this.eow.setVisibility(0);
        } else {
            this.eow.setVisibility(4);
        }
        if (this.drP != null) {
            this.dyC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.drP, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.drP.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.drP.setPadding(this.drP.getPaddingLeft(), this.drP.getPaddingTop(), this.drP.getPaddingRight(), this.drP.getBottom() + com.baidu.adp.lib.util.l.e(this.eol.getContext(), d.e.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.drP != null && bVar != null) {
            this.drP.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.drP != null && bVar != null) {
            this.drP.b(bVar);
        }
    }

    public TbTabLayout aIw() {
        return this.drP;
    }

    public void selectTab(int i) {
        TbTabLayout.e of = of(i);
        if (of != null) {
            of.select();
        }
    }

    public TbTabLayout.e aIx() {
        if (this.drP == null || this.drP.getTabCount() <= 0) {
            return null;
        }
        return this.drP.aP(this.drP.getSelectedTabPosition());
    }

    public TbTabLayout.e of(int i) {
        int tabCount;
        if (this.drP != null && (tabCount = this.drP.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aP = this.drP.aP(i2);
                if (aP != null && aP.getId() != -1 && aP.getId() == i) {
                    return aP;
                }
            }
            return null;
        }
        return null;
    }

    public boolean og(int i) {
        int selectedTabPosition;
        TbTabLayout.e aP;
        return this.drP != null && (selectedTabPosition = this.drP.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.drP.getTabCount() + (-1) && (aP = this.drP.aP(selectedTabPosition)) != null && aP.getId() == i;
    }

    public void f(int i, int i2, boolean z) {
        TbTabLayout.e of = of(i);
        if (of != null) {
            of.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.dyC != null) {
            this.dyC.onChangeSkinType(getPageContext(), i);
            this.dyC.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)).mutate());
        }
        if (this.blp != null) {
            this.blp.onChangeSkinType(getPageContext(), i);
        }
        if (this.eov != null && this.eov.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eov.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eov.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.eow != null) {
            ak.c(this.eow, d.f.icon_tobar_friend_add);
        }
        if (this.drP != null) {
            this.drP.setSelectedTabIndicatorColor(ak.getColor(d.C0126d.cp_cont_f));
            this.drP.setTabTextColors(ak.getColor(d.C0126d.cp_cont_j), ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eov != null && this.eov.size() > 0 && this.aqY != null) {
            MessageFragmentPagerAdapter.a aVar = this.eov.get(this.aqY.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aIy() {
        if (this.eol != null && this.eov != null && this.aqY != null && this.eou != null) {
            FragmentManager supportFragmentManager = this.eol.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eov.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.aqY.getId(), this.eou.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.blp != null) {
            this.blp.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eou != null) {
            this.eou.setPrimary(z);
        }
        if (this.eov != null && this.eov.size() > 0 && this.aqY != null) {
            MessageFragmentPagerAdapter.a aVar = this.eov.get(this.aqY.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.eov != null && this.eov.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eov.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eov.get(i2);
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
