package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class g extends com.baidu.adp.base.c implements NoNetworkView.a {
    private TbTabLayout fPs;
    private BdBaseViewPager faa;
    private NoNetworkView giU;
    private List<MessageFragmentPagerAdapter.a> ili;
    private NavigationBar iln;
    private MessageFragmentPagerAdapter kvG;
    private ChatAggregationFragment kvH;
    private ImageView kvI;
    private MessageCenterFragment kvz;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kvz = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.giU.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.faa = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kvH = new ChatAggregationFragment();
        aVar.fragment = this.kvH;
        aVar.title = this.kvz.getResources().getString(R.string.message_center_message_tab);
        this.ili = new ArrayList();
        this.ili.add(aVar);
        this.kvG = new MessageFragmentPagerAdapter(this.kvz.getActivity().getSupportFragmentManager(), this.ili);
        this.faa.setAdapter(this.kvG);
        this.faa.setOffscreenPageLimit(this.ili.size());
        this.kvG.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.fPs = (TbTabLayout) LayoutInflater.from(this.kvz.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.fPs.setupWithViewPager(this.faa);
        int tabCount = this.fPs.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.fPs.aU(i).aW(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iln = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iln.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kvz != null) {
                    g.this.kvz.cWl();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kvz.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kvI = new ImageView(this.kvz.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kvz.getContext(), R.dimen.ds88);
        this.kvI.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kvI.setScaleType(ImageView.ScaleType.CENTER);
        this.iln.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kvI, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kvz != null) {
                    g.this.kvz.cWm();
                }
            }
        });
        if (this.kvI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kvI.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kvz.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kvI.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kvI.setVisibility(0);
        } else {
            this.kvI.setVisibility(4);
        }
        if (this.fPs != null) {
            this.iln.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.fPs, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fPs.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fPs.setPadding(this.fPs.getPaddingLeft(), this.fPs.getPaddingTop(), this.fPs.getPaddingRight(), this.fPs.getBottom() + com.baidu.adp.lib.util.l.getDimens(this.kvz.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.fPs != null && bVar != null) {
            this.fPs.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.fPs != null && bVar != null) {
            this.fPs.b(bVar);
        }
    }

    public void Eg(int i) {
        TbTabLayout.e Eh = Eh(i);
        if (Eh != null) {
            Eh.select();
        }
    }

    public TbTabLayout.e cWn() {
        if (this.fPs == null || this.fPs.getTabCount() <= 0) {
            return null;
        }
        return this.fPs.aU(this.fPs.getSelectedTabPosition());
    }

    public TbTabLayout.e Eh(int i) {
        int tabCount;
        if (this.fPs != null && (tabCount = this.fPs.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aU = this.fPs.aU(i2);
                if (aU != null && aU.getId() != -1 && aU.getId() == i) {
                    return aU;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.iln != null) {
            this.iln.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.iln.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.giU != null) {
            this.giU.onChangeSkinType(getPageContext(), i);
        }
        if (this.ili != null && this.ili.size() > 0) {
            for (int i2 = 0; i2 < this.ili.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.ili.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bqB().a(this.kvI, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.fPs != null) {
            this.fPs.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.fPs.setSelectedTabIndicatorHeight(0);
            this.fPs.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ili != null && this.ili.size() > 0 && this.faa != null) {
            MessageFragmentPagerAdapter.a aVar = this.ili.get(this.faa.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aiW() {
        if (this.kvz != null && this.ili != null && this.faa != null && this.kvG != null) {
            FragmentManager supportFragmentManager = this.kvz.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.ili.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.faa.getId(), this.kvG.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.giU != null) {
            this.giU.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kvG != null) {
            this.kvG.setPrimary(z);
        }
        if (this.ili != null && this.ili.size() > 0 && this.faa != null) {
            MessageFragmentPagerAdapter.a aVar = this.ili.get(this.faa.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.ili != null && this.ili.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ili.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.ili.get(i2);
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

    public void cJc() {
        if (this.kvH != null) {
            this.kvH.Tc();
        }
    }
}
