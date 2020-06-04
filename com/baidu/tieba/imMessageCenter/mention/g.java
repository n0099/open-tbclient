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
    private NoNetworkView fci;
    private NavigationBar gQE;
    private List<MessageFragmentPagerAdapter.a> gQz;
    private TbTabLayout gRH;
    private MessageCenterFragment iPO;
    private MessageFragmentPagerAdapter iPY;
    private ImageView iPZ;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.iPO = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fci.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.dZk = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.iPO.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.iPO.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.iPO.getResources().getString(R.string.message_center_notification_tab);
        this.gQz = new ArrayList();
        this.gQz.add(aVar);
        this.gQz.add(aVar2);
        this.gQz.add(aVar3);
        this.iPY = new MessageFragmentPagerAdapter(this.iPO.getActivity().getSupportFragmentManager(), this.gQz);
        this.dZk.setAdapter(this.iPY);
        this.dZk.setOffscreenPageLimit(this.gQz.size());
        this.iPY.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.gRH = (TbTabLayout) LayoutInflater.from(this.iPO.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gRH.setupWithViewPager(this.dZk);
        int tabCount = this.gRH.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aF = this.gRH.aF(i);
                if (aF != null && !TextUtils.isEmpty(aF.getText())) {
                    if (aF.getText().equals(this.iPO.getResources().getString(R.string.message_center_message_tab))) {
                        aF.aH(1);
                    } else if (aF.getText().equals(this.iPO.getResources().getString(R.string.message_center_chat_tab))) {
                        aF.aH(2);
                    } else if (aF.getText().equals(this.iPO.getResources().getString(R.string.message_center_notification_tab))) {
                        aF.aH(3);
                    }
                }
            }
        }
    }

    private void am(Bundle bundle) {
        this.gQE = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.gQE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iPO != null) {
                    g.this.iPO.cqY();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.iPO.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.iPZ = new ImageView(this.iPO.getContext());
        this.iPZ.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.iPO.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.iPO.getContext(), R.dimen.ds88)));
        this.iPZ.setScaleType(ImageView.ScaleType.CENTER);
        this.gQE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iPZ, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.iPO != null) {
                    g.this.iPO.cqZ();
                }
            }
        });
        if (this.iPZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iPZ.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.iPO.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.iPZ.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.iPZ.setVisibility(0);
        } else {
            this.iPZ.setVisibility(4);
        }
        if (this.gRH != null) {
            this.gQE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gRH, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gRH.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gRH.setPadding(this.gRH.getPaddingLeft(), this.gRH.getPaddingTop(), this.gRH.getPaddingRight(), this.gRH.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.iPO.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gRH != null && bVar != null) {
            this.gRH.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gRH != null && bVar != null) {
            this.gRH.b(bVar);
        }
    }

    public TbTabLayout crb() {
        return this.gRH;
    }

    public void yq(int i) {
        TbTabLayout.e yr = yr(i);
        if (yr != null) {
            yr.select();
        }
    }

    public TbTabLayout.e crc() {
        if (this.gRH == null || this.gRH.getTabCount() <= 0) {
            return null;
        }
        return this.gRH.aF(this.gRH.getSelectedTabPosition());
    }

    public TbTabLayout.e yr(int i) {
        int tabCount;
        if (this.gRH != null && (tabCount = this.gRH.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aF = this.gRH.aF(i2);
                if (aF != null && aF.getId() != -1 && aF.getId() == i) {
                    return aF;
                }
            }
            return null;
        }
        return null;
    }

    public boolean ys(int i) {
        int selectedTabPosition;
        TbTabLayout.e aF;
        return this.gRH != null && (selectedTabPosition = this.gRH.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gRH.getTabCount() + (-1) && (aF = this.gRH.aF(selectedTabPosition)) != null && aF.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e yr = yr(i);
        if (yr != null) {
            yr.j(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.gQE != null) {
            this.gQE.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.gQE.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fci != null) {
            this.fci.onChangeSkinType(getPageContext(), i);
        }
        if (this.gQz != null && this.gQz.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gQz.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.gQz.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.iPZ != null) {
            SvgManager.aUW().a(this.iPZ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gRH != null) {
            this.gRH.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gRH.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gQz != null && this.gQz.size() > 0 && this.dZk != null) {
            MessageFragmentPagerAdapter.a aVar = this.gQz.get(this.dZk.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void TY() {
        if (this.iPO != null && this.gQz != null && this.dZk != null && this.iPY != null) {
            FragmentManager supportFragmentManager = this.iPO.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gQz.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dZk.getId(), this.iPY.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fci != null) {
            this.fci.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iPY != null) {
            this.iPY.setPrimary(z);
        }
        if (this.gQz != null && this.gQz.size() > 0 && this.dZk != null) {
            MessageFragmentPagerAdapter.a aVar = this.gQz.get(this.dZk.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gQz != null && this.gQz.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gQz.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.gQz.get(i2);
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
