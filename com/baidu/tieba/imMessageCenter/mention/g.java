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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dZk;
    private NoNetworkView fbX;
    private List<MessageFragmentPagerAdapter.a> gQo;
    private NavigationBar gQt;
    private TbTabLayout gRw;
    private MessageCenterFragment iPb;
    private MessageFragmentPagerAdapter iPl;
    private ImageView iPm;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.iPb = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fbX.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.dZk = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.iPb.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.iPb.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.iPb.getResources().getString(R.string.message_center_notification_tab);
        this.gQo = new ArrayList();
        this.gQo.add(aVar);
        this.gQo.add(aVar2);
        this.gQo.add(aVar3);
        this.iPl = new MessageFragmentPagerAdapter(this.iPb.getActivity().getSupportFragmentManager(), this.gQo);
        this.dZk.setAdapter(this.iPl);
        this.dZk.setOffscreenPageLimit(this.gQo.size());
        this.iPl.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.gRw = (TbTabLayout) LayoutInflater.from(this.iPb.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gRw.setupWithViewPager(this.dZk);
        int tabCount = this.gRw.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aF = this.gRw.aF(i);
                if (aF != null && !TextUtils.isEmpty(aF.getText())) {
                    if (aF.getText().equals(this.iPb.getResources().getString(R.string.message_center_message_tab))) {
                        aF.aH(1);
                    } else if (aF.getText().equals(this.iPb.getResources().getString(R.string.message_center_chat_tab))) {
                        aF.aH(2);
                    } else if (aF.getText().equals(this.iPb.getResources().getString(R.string.message_center_notification_tab))) {
                        aF.aH(3);
                    }
                }
            }
        }
    }

    private void am(Bundle bundle) {
        this.gQt = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.gQt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iPb != null) {
                    g.this.iPb.cqP();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.iPb.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.iPm = new ImageView(this.iPb.getContext());
        this.iPm.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.iPb.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.iPb.getContext(), R.dimen.ds88)));
        this.iPm.setScaleType(ImageView.ScaleType.CENTER);
        this.gQt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iPm, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iPb != null) {
                    g.this.iPb.cqQ();
                }
            }
        });
        if (this.iPm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iPm.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.iPb.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.iPm.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.iPm.setVisibility(0);
        } else {
            this.iPm.setVisibility(4);
        }
        if (this.gRw != null) {
            this.gQt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gRw, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gRw.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gRw.setPadding(this.gRw.getPaddingLeft(), this.gRw.getPaddingTop(), this.gRw.getPaddingRight(), this.gRw.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.iPb.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gRw != null && bVar != null) {
            this.gRw.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gRw != null && bVar != null) {
            this.gRw.b(bVar);
        }
    }

    public TbTabLayout cqS() {
        return this.gRw;
    }

    public void yo(int i) {
        TbTabLayout.e yp = yp(i);
        if (yp != null) {
            yp.select();
        }
    }

    public TbTabLayout.e cqT() {
        if (this.gRw == null || this.gRw.getTabCount() <= 0) {
            return null;
        }
        return this.gRw.aF(this.gRw.getSelectedTabPosition());
    }

    public TbTabLayout.e yp(int i) {
        int tabCount;
        if (this.gRw != null && (tabCount = this.gRw.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aF = this.gRw.aF(i2);
                if (aF != null && aF.getId() != -1 && aF.getId() == i) {
                    return aF;
                }
            }
            return null;
        }
        return null;
    }

    public boolean yq(int i) {
        int selectedTabPosition;
        TbTabLayout.e aF;
        return this.gRw != null && (selectedTabPosition = this.gRw.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gRw.getTabCount() + (-1) && (aF = this.gRw.aF(selectedTabPosition)) != null && aF.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e yp = yp(i);
        if (yp != null) {
            yp.j(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.gQt != null) {
            this.gQt.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.gQt.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fbX != null) {
            this.fbX.onChangeSkinType(getPageContext(), i);
        }
        if (this.gQo != null && this.gQo.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gQo.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.gQo.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.iPm != null) {
            SvgManager.aUV().a(this.iPm, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gRw != null) {
            this.gRw.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gRw.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gQo != null && this.gQo.size() > 0 && this.dZk != null) {
            MessageFragmentPagerAdapter.a aVar = this.gQo.get(this.dZk.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void TY() {
        if (this.iPb != null && this.gQo != null && this.dZk != null && this.iPl != null) {
            FragmentManager supportFragmentManager = this.iPb.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gQo.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dZk.getId(), this.iPl.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fbX != null) {
            this.fbX.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iPl != null) {
            this.iPl.setPrimary(z);
        }
        if (this.gQo != null && this.gQo.size() > 0 && this.dZk != null) {
            MessageFragmentPagerAdapter.a aVar = this.gQo.get(this.dZk.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gQo != null && this.gQo.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gQo.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.gQo.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
