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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager cso;
    private NoNetworkView dvR;
    private TbTabLayout fSO;
    private List<MessageFragmentPagerAdapter.a> fbB;
    private NavigationBar fbF;
    private MessageCenterFragment gVf;
    private MessageFragmentPagerAdapter gVp;
    private ImageView gVq;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gVf = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dvR.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.cso = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gVf.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gVf.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gVf.getResources().getString(R.string.message_center_notification_tab);
        this.fbB = new ArrayList();
        this.fbB.add(aVar);
        this.fbB.add(aVar2);
        this.fbB.add(aVar3);
        this.gVp = new MessageFragmentPagerAdapter(this.gVf.getActivity().getSupportFragmentManager(), this.fbB);
        this.cso.setAdapter(this.gVp);
        this.cso.setOffscreenPageLimit(this.fbB.size());
        this.gVp.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fSO = (TbTabLayout) LayoutInflater.from(this.gVf.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fSO.setupWithViewPager(this.cso);
        int tabCount = this.fSO.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e am = this.fSO.am(i);
                if (am != null && !TextUtils.isEmpty(am.getText())) {
                    if (am.getText().equals(this.gVf.getResources().getString(R.string.message_center_message_tab))) {
                        am.ao(1);
                    } else if (am.getText().equals(this.gVf.getResources().getString(R.string.message_center_chat_tab))) {
                        am.ao(2);
                    } else if (am.getText().equals(this.gVf.getResources().getString(R.string.message_center_notification_tab))) {
                        am.ao(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.fbF = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.fbF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gVf != null) {
                    g.this.gVf.bFA();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gVf.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gVq = new ImageView(this.gVf.getContext());
        this.gVq.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.gVf.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.getDimens(this.gVf.getContext(), R.dimen.ds88)));
        this.gVq.setScaleType(ImageView.ScaleType.CENTER);
        this.fbF.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gVq, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gVf != null) {
                    g.this.gVf.bFB();
                }
            }
        });
        if (this.gVq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gVq.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.gVf.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gVq.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.ft().af("android_message_can_friend_chat") == 1) {
            this.gVq.setVisibility(0);
        } else {
            this.gVq.setVisibility(4);
        }
        if (this.fSO != null) {
            this.fbF.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fSO, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fSO.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fSO.setPadding(this.fSO.getPaddingLeft(), this.fSO.getPaddingTop(), this.fSO.getPaddingRight(), this.fSO.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.gVf.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fSO != null && bVar != null) {
            this.fSO.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fSO != null && bVar != null) {
            this.fSO.b(bVar);
        }
    }

    public TbTabLayout bFD() {
        return this.fSO;
    }

    public void pw(int i) {
        TbTabLayout.e uP = uP(i);
        if (uP != null) {
            uP.select();
        }
    }

    public TbTabLayout.e bFE() {
        if (this.fSO == null || this.fSO.getTabCount() <= 0) {
            return null;
        }
        return this.fSO.am(this.fSO.getSelectedTabPosition());
    }

    public TbTabLayout.e uP(int i) {
        int tabCount;
        if (this.fSO != null && (tabCount = this.fSO.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e am = this.fSO.am(i2);
                if (am != null && am.getId() != -1 && am.getId() == i) {
                    return am;
                }
            }
            return null;
        }
        return null;
    }

    public boolean px(int i) {
        int selectedTabPosition;
        TbTabLayout.e am;
        return this.fSO != null && (selectedTabPosition = this.fSO.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fSO.getTabCount() + (-1) && (am = this.fSO.am(selectedTabPosition)) != null && am.getId() == i;
    }

    public void k(int i, int i2, boolean z) {
        TbTabLayout.e uP = uP(i);
        if (uP != null) {
            uP.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fbF != null) {
            this.fbF.onChangeSkinType(getPageContext(), i);
            am.setBackgroundColor(this.fbF.getBarBgView(), R.color.cp_bg_line_h, i);
        }
        if (this.dvR != null) {
            this.dvR.onChangeSkinType(getPageContext(), i);
        }
        if (this.fbB != null && this.fbB.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fbB.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.fbB.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gVq != null) {
            SvgManager.amL().a(this.gVq, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.fSO != null) {
            this.fSO.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.fSO.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fbB != null && this.fbB.size() > 0 && this.cso != null) {
            MessageFragmentPagerAdapter.a aVar = this.fbB.get(this.cso.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bez() {
        if (this.gVf != null && this.fbB != null && this.cso != null && this.gVp != null) {
            FragmentManager supportFragmentManager = this.gVf.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fbB.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.cso.getId(), this.gVp.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dvR != null) {
            this.dvR.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gVp != null) {
            this.gVp.setPrimary(z);
        }
        if (this.fbB != null && this.fbB.size() > 0 && this.cso != null) {
            MessageFragmentPagerAdapter.a aVar = this.fbB.get(this.cso.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fbB != null && this.fbB.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fbB.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.fbB.get(i2);
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
