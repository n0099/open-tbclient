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
    private BdBaseViewPager dkV;
    private NoNetworkView elL;
    private List<MessageFragmentPagerAdapter.a> fWE;
    private NavigationBar fWI;
    private TbTabLayout gNU;
    private MessageFragmentPagerAdapter hQH;
    private ImageView hQI;
    private MessageCenterFragment hQx;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.hQx = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.elL.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.dkV = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.hQx.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.hQx.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.hQx.getResources().getString(R.string.message_center_notification_tab);
        this.fWE = new ArrayList();
        this.fWE.add(aVar);
        this.fWE.add(aVar2);
        this.fWE.add(aVar3);
        this.hQH = new MessageFragmentPagerAdapter(this.hQx.getActivity().getSupportFragmentManager(), this.fWE);
        this.dkV.setAdapter(this.hQH);
        this.dkV.setOffscreenPageLimit(this.fWE.size());
        this.hQH.notifyDataSetChanged();
    }

    private void af(Bundle bundle) {
        this.gNU = (TbTabLayout) LayoutInflater.from(this.hQx.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gNU.setupWithViewPager(this.dkV);
        int tabCount = this.gNU.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e as = this.gNU.as(i);
                if (as != null && !TextUtils.isEmpty(as.getText())) {
                    if (as.getText().equals(this.hQx.getResources().getString(R.string.message_center_message_tab))) {
                        as.au(1);
                    } else if (as.getText().equals(this.hQx.getResources().getString(R.string.message_center_chat_tab))) {
                        as.au(2);
                    } else if (as.getText().equals(this.hQx.getResources().getString(R.string.message_center_notification_tab))) {
                        as.au(3);
                    }
                }
            }
        }
    }

    private void ag(Bundle bundle) {
        this.fWI = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fWI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hQx != null) {
                    g.this.hQx.bZR();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.hQx.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.hQI = new ImageView(this.hQx.getContext());
        this.hQI.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.hQx.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.hQx.getContext(), R.dimen.ds88)));
        this.hQI.setScaleType(ImageView.ScaleType.CENTER);
        this.fWI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hQI, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.hQx != null) {
                    g.this.hQx.bZS();
                }
            }
        });
        if (this.hQI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hQI.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.hQx.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.hQI.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.hQI.setVisibility(0);
        } else {
            this.hQI.setVisibility(4);
        }
        if (this.gNU != null) {
            this.fWI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gNU, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gNU.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gNU.setPadding(this.gNU.getPaddingLeft(), this.gNU.getPaddingTop(), this.gNU.getPaddingRight(), this.gNU.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.hQx.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gNU != null && bVar != null) {
            this.gNU.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gNU != null && bVar != null) {
            this.gNU.b(bVar);
        }
    }

    public TbTabLayout bZU() {
        return this.gNU;
    }

    public void rQ(int i) {
        TbTabLayout.e xk = xk(i);
        if (xk != null) {
            xk.select();
        }
    }

    public TbTabLayout.e bZV() {
        if (this.gNU == null || this.gNU.getTabCount() <= 0) {
            return null;
        }
        return this.gNU.as(this.gNU.getSelectedTabPosition());
    }

    public TbTabLayout.e xk(int i) {
        int tabCount;
        if (this.gNU != null && (tabCount = this.gNU.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e as = this.gNU.as(i2);
                if (as != null && as.getId() != -1 && as.getId() == i) {
                    return as;
                }
            }
            return null;
        }
        return null;
    }

    public boolean rR(int i) {
        int selectedTabPosition;
        TbTabLayout.e as;
        return this.gNU != null && (selectedTabPosition = this.gNU.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.gNU.getTabCount() + (-1) && (as = this.gNU.as(selectedTabPosition)) != null && as.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e xk = xk(i);
        if (xk != null) {
            xk.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fWI != null) {
            this.fWI.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fWI.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.elL != null) {
            this.elL.onChangeSkinType(getPageContext(), i);
        }
        if (this.fWE != null && this.fWE.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fWE.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fWE.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.hQI != null) {
            SvgManager.aGG().a(this.hQI, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gNU != null) {
            this.gNU.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.gNU.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fWE != null && this.fWE.size() > 0 && this.dkV != null) {
            MessageFragmentPagerAdapter.a aVar = this.fWE.get(this.dkV.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JM() {
        if (this.hQx != null && this.fWE != null && this.dkV != null && this.hQH != null) {
            FragmentManager supportFragmentManager = this.hQx.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fWE.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dkV.getId(), this.hQH.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.elL != null) {
            this.elL.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hQH != null) {
            this.hQH.setPrimary(z);
        }
        if (this.fWE != null && this.fWE.size() > 0 && this.dkV != null) {
            MessageFragmentPagerAdapter.a aVar = this.fWE.get(this.dkV.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fWE != null && this.fWE.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fWE.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fWE.get(i2);
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
