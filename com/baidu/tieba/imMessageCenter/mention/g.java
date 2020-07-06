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
import com.baidu.tbadk.core.util.an;
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
    private BdBaseViewPager ehU;
    private NoNetworkView fns;
    private List<MessageFragmentPagerAdapter.a> hdi;
    private NavigationBar hdn;
    private TbTabLayout heq;
    private MessageCenterFragment jgX;
    private MessageFragmentPagerAdapter jhh;
    private ImageView jhi;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.jgX = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fns.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.ehU = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.jgX.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.jgX.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.jgX.getResources().getString(R.string.message_center_notification_tab);
        this.hdi = new ArrayList();
        this.hdi.add(aVar);
        this.hdi.add(aVar2);
        this.hdi.add(aVar3);
        this.jhh = new MessageFragmentPagerAdapter(this.jgX.getActivity().getSupportFragmentManager(), this.hdi);
        this.ehU.setAdapter(this.jhh);
        this.ehU.setOffscreenPageLimit(this.hdi.size());
        this.jhh.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.heq = (TbTabLayout) LayoutInflater.from(this.jgX.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.heq.setupWithViewPager(this.ehU);
        int tabCount = this.heq.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aL = this.heq.aL(i);
                if (aL != null && !TextUtils.isEmpty(aL.getText())) {
                    if (aL.getText().equals(this.jgX.getResources().getString(R.string.message_center_message_tab))) {
                        aL.aN(1);
                    } else if (aL.getText().equals(this.jgX.getResources().getString(R.string.message_center_chat_tab))) {
                        aL.aN(2);
                    } else if (aL.getText().equals(this.jgX.getResources().getString(R.string.message_center_notification_tab))) {
                        aL.aN(3);
                    }
                }
            }
        }
    }

    private void am(Bundle bundle) {
        this.hdn = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.hdn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jgX != null) {
                    g.this.jgX.cuQ();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.jgX.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.jhi = new ImageView(this.jgX.getContext());
        this.jhi.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.jgX.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.jgX.getContext(), R.dimen.ds88)));
        this.jhi.setScaleType(ImageView.ScaleType.CENTER);
        this.hdn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jhi, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.jgX != null) {
                    g.this.jgX.cuR();
                }
            }
        });
        if (this.jhi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jhi.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.jgX.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.jhi.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.jhi.setVisibility(0);
        } else {
            this.jhi.setVisibility(4);
        }
        if (this.heq != null) {
            this.hdn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.heq, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.heq.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.heq.setPadding(this.heq.getPaddingLeft(), this.heq.getPaddingTop(), this.heq.getPaddingRight(), this.heq.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.jgX.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.heq != null && bVar != null) {
            this.heq.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.heq != null && bVar != null) {
            this.heq.b(bVar);
        }
    }

    public TbTabLayout cuT() {
        return this.heq;
    }

    public void za(int i) {
        TbTabLayout.e zb = zb(i);
        if (zb != null) {
            zb.select();
        }
    }

    public TbTabLayout.e cuU() {
        if (this.heq == null || this.heq.getTabCount() <= 0) {
            return null;
        }
        return this.heq.aL(this.heq.getSelectedTabPosition());
    }

    public TbTabLayout.e zb(int i) {
        int tabCount;
        if (this.heq != null && (tabCount = this.heq.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aL = this.heq.aL(i2);
                if (aL != null && aL.getId() != -1 && aL.getId() == i) {
                    return aL;
                }
            }
            return null;
        }
        return null;
    }

    public boolean zc(int i) {
        int selectedTabPosition;
        TbTabLayout.e aL;
        return this.heq != null && (selectedTabPosition = this.heq.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.heq.getTabCount() + (-1) && (aL = this.heq.aL(selectedTabPosition)) != null && aL.getId() == i;
    }

    public void m(int i, int i2, boolean z) {
        TbTabLayout.e zb = zb(i);
        if (zb != null) {
            zb.k(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.hdn != null) {
            this.hdn.onChangeSkinType(getPageContext(), i);
            an.setBackgroundColor(this.hdn.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.fns != null) {
            this.fns.onChangeSkinType(getPageContext(), i);
        }
        if (this.hdi != null && this.hdi.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hdi.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.hdi.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.jhi != null) {
            SvgManager.aWQ().a(this.jhi, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.heq != null) {
            this.heq.setSelectedTabIndicatorColor(an.getColor(R.color.cp_cont_f));
            this.heq.setTabTextColors(an.getColor(R.color.cp_cont_j), an.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hdi != null && this.hdi.size() > 0 && this.ehU != null) {
            MessageFragmentPagerAdapter.a aVar = this.hdi.get(this.ehU.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Ve() {
        if (this.jgX != null && this.hdi != null && this.ehU != null && this.jhh != null) {
            FragmentManager supportFragmentManager = this.jgX.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hdi.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ehU.getId(), this.jhh.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fns != null) {
            this.fns.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.jhh != null) {
            this.jhh.setPrimary(z);
        }
        if (this.hdi != null && this.hdi.size() > 0 && this.ehU != null) {
            MessageFragmentPagerAdapter.a aVar = this.hdi.get(this.ehU.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hdi != null && this.hdi.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hdi.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.hdi.get(i2);
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
