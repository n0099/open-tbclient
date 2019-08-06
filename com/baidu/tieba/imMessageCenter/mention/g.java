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
    private BdBaseViewPager cea;
    private NoNetworkView dnM;
    private List<MessageFragmentPagerAdapter.a> eYb;
    private NavigationBar eYf;
    private TbTabLayout fSu;
    private MessageCenterFragment gWb;
    private MessageFragmentPagerAdapter gWl;
    private ImageView gWm;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.gWb = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dnM.a(this);
        }
    }

    private void L(Bundle bundle) {
        this.cea = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        aVar.fragment = new ReplyMessageFragment();
        aVar.title = this.gWb.getResources().getString(R.string.message_center_message_tab);
        MessageFragmentPagerAdapter.a aVar2 = new MessageFragmentPagerAdapter.a();
        aVar2.fragment = new ChatAggregationFragment();
        aVar2.title = this.gWb.getResources().getString(R.string.message_center_chat_tab);
        MessageFragmentPagerAdapter.a aVar3 = new MessageFragmentPagerAdapter.a();
        aVar3.fragment = new OfficialNotificationFragment();
        aVar3.title = this.gWb.getResources().getString(R.string.message_center_notification_tab);
        this.eYb = new ArrayList();
        this.eYb.add(aVar);
        this.eYb.add(aVar2);
        this.eYb.add(aVar3);
        this.gWl = new MessageFragmentPagerAdapter(this.gWb.getActivity().getSupportFragmentManager(), this.eYb);
        this.cea.setAdapter(this.gWl);
        this.cea.setOffscreenPageLimit(this.eYb.size());
        this.gWl.notifyDataSetChanged();
    }

    private void M(Bundle bundle) {
        this.fSu = (TbTabLayout) LayoutInflater.from(this.gWb.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fSu.setupWithViewPager(this.cea);
        int tabCount = this.fSu.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e aV = this.fSu.aV(i);
                if (aV != null && !TextUtils.isEmpty(aV.getText())) {
                    if (aV.getText().equals(this.gWb.getResources().getString(R.string.message_center_message_tab))) {
                        aV.aX(1);
                    } else if (aV.getText().equals(this.gWb.getResources().getString(R.string.message_center_chat_tab))) {
                        aV.aX(2);
                    } else if (aV.getText().equals(this.gWb.getResources().getString(R.string.message_center_notification_tab))) {
                        aV.aX(3);
                    }
                }
            }
        }
    }

    private void N(Bundle bundle) {
        this.eYf = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.eYf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gWb != null) {
                    g.this.gWb.bIe();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.gWb.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.gWm = new ImageView(this.gWb.getContext());
        this.gWm.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.g(this.gWb.getContext(), R.dimen.ds88), com.baidu.adp.lib.util.l.g(this.gWb.getContext(), R.dimen.ds88)));
        this.gWm.setScaleType(ImageView.ScaleType.CENTER);
        this.eYf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gWm, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gWb != null) {
                    g.this.gWb.bIf();
                }
            }
        });
        if (this.gWm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gWm.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.g(this.gWb.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.gWm.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.hS().az("android_message_can_friend_chat") == 1) {
            this.gWm.setVisibility(0);
        } else {
            this.gWm.setVisibility(4);
        }
        if (this.fSu != null) {
            this.eYf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fSu, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fSu.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fSu.setPadding(this.fSu.getPaddingLeft(), this.fSu.getPaddingTop(), this.fSu.getPaddingRight(), this.fSu.getBottom() + com.baidu.adp.lib.util.l.g(this.gWb.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fSu != null && bVar != null) {
            this.fSu.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fSu != null && bVar != null) {
            this.fSu.b(bVar);
        }
    }

    public TbTabLayout bIh() {
        return this.fSu;
    }

    public void qy(int i) {
        TbTabLayout.e wg = wg(i);
        if (wg != null) {
            wg.select();
        }
    }

    public TbTabLayout.e bIi() {
        if (this.fSu == null || this.fSu.getTabCount() <= 0) {
            return null;
        }
        return this.fSu.aV(this.fSu.getSelectedTabPosition());
    }

    public TbTabLayout.e wg(int i) {
        int tabCount;
        if (this.fSu != null && (tabCount = this.fSu.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aV = this.fSu.aV(i2);
                if (aV != null && aV.getId() != -1 && aV.getId() == i) {
                    return aV;
                }
            }
            return null;
        }
        return null;
    }

    public boolean qz(int i) {
        int selectedTabPosition;
        TbTabLayout.e aV;
        return this.fSu != null && (selectedTabPosition = this.fSu.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.fSu.getTabCount() + (-1) && (aV = this.fSu.aV(selectedTabPosition)) != null && aV.getId() == i;
    }

    public void k(int i, int i2, boolean z) {
        TbTabLayout.e wg = wg(i);
        if (wg != null) {
            wg.g(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eYf != null) {
            this.eYf.onChangeSkinType(getPageContext(), i);
            am.h(this.eYf.getBarBgView(), R.color.cp_bg_line_d, i);
        }
        if (this.dnM != null) {
            this.dnM.onChangeSkinType(getPageContext(), i);
        }
        if (this.eYb != null && this.eYb.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eYb.size()) {
                    break;
                }
                MessageFragmentPagerAdapter.a aVar = this.eYb.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        if (this.gWm != null) {
            am.c(this.gWm, (int) R.drawable.selector_topbar_chat_black);
        }
        if (this.fSu != null) {
            this.fSu.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_f));
            this.fSu.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eYb != null && this.eYb.size() > 0 && this.cea != null) {
            MessageFragmentPagerAdapter.a aVar = this.eYb.get(this.cea.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bgd() {
        if (this.gWb != null && this.eYb != null && this.cea != null && this.gWl != null) {
            FragmentManager supportFragmentManager = this.gWb.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eYb.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.cea.getId(), this.gWl.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dnM != null) {
            this.dnM.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gWl != null) {
            this.gWl.setPrimary(z);
        }
        if (this.eYb != null && this.eYb.size() > 0 && this.cea != null) {
            MessageFragmentPagerAdapter.a aVar = this.eYb.get(this.cea.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ep(boolean z) {
        if (this.eYb != null && this.eYb.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eYb.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.eYb.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).ep(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
