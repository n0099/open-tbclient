package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.d implements NoNetworkView.a {
    private BdBaseViewPager fmy;
    private TbTabLayout gcC;
    private NoNetworkView gxx;
    private List<MessageFragmentPagerAdapter.a> iDK;
    private NavigationBar iDP;
    private MessageFragmentPagerAdapter kJG;
    private ChatAggregationFragment kJH;
    private ImageView kJI;
    private MessageCenterFragment kJz;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kJz = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gxx.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.fmy = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kJH = new ChatAggregationFragment();
        aVar.fragment = this.kJH;
        aVar.title = this.kJz.getResources().getString(R.string.message_center_message_tab);
        this.iDK = new ArrayList();
        this.iDK.add(aVar);
        this.kJG = new MessageFragmentPagerAdapter(this.kJz.getActivity().getSupportFragmentManager(), this.iDK);
        this.fmy.setAdapter(this.kJG);
        this.fmy.setOffscreenPageLimit(this.iDK.size());
        this.kJG.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.gcC = (TbTabLayout) LayoutInflater.from(this.kJz.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.gcC.setupWithViewPager(this.fmy);
        int tabCount = this.gcC.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.gcC.aZ(i).bb(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iDP = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iDP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kJz != null) {
                    g.this.kJz.cXk();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kJz.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kJI = new ImageView(this.kJz.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kJz.getContext(), R.dimen.ds88);
        this.kJI.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kJI.setScaleType(ImageView.ScaleType.CENTER);
        this.iDP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kJI, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kJz != null) {
                    g.this.kJz.cXl();
                }
            }
        });
        if (this.kJI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kJI.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kJz.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kJI.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kJI.setVisibility(0);
        } else {
            this.kJI.setVisibility(4);
        }
        if (this.gcC != null) {
            this.iDP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.gcC, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gcC.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gcC.setPadding(this.gcC.getPaddingLeft(), this.gcC.getPaddingTop(), this.gcC.getPaddingRight(), this.gcC.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kJz.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.gcC != null && bVar != null) {
            this.gcC.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.gcC != null && bVar != null) {
            this.gcC.b(bVar);
        }
    }

    public void Dh(int i) {
        TbTabLayout.e Di = Di(i);
        if (Di != null) {
            Di.select();
        }
    }

    public TbTabLayout.e cXm() {
        if (this.gcC == null || this.gcC.getTabCount() <= 0) {
            return null;
        }
        return this.gcC.aZ(this.gcC.getSelectedTabPosition());
    }

    public TbTabLayout.e Di(int i) {
        int tabCount;
        if (this.gcC != null && (tabCount = this.gcC.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aZ = this.gcC.aZ(i2);
                if (aZ != null && aZ.getId() != -1 && aZ.getId() == i) {
                    return aZ;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.iDP != null) {
            this.iDP.onChangeSkinType(getPageContext(), i);
            ao.setBackgroundColor(this.iDP.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(getPageContext(), i);
        }
        if (this.iDK != null && this.iDK.size() > 0) {
            for (int i2 = 0; i2 < this.iDK.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iDK.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bsx().a(this.kJI, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.gcC != null) {
            this.gcC.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.gcC.setSelectedTabIndicatorHeight(0);
            this.gcC.setTabTextColors(ao.getColor(R.color.CAM_X0107), ao.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iDK != null && this.iDK.size() > 0 && this.fmy != null) {
            MessageFragmentPagerAdapter.a aVar = this.iDK.get(this.fmy.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajv() {
        if (this.kJz != null && this.iDK != null && this.fmy != null && this.kJG != null) {
            FragmentManager supportFragmentManager = this.kJz.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iDK.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.fmy.getId(), this.kJG.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gxx != null) {
            this.gxx.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kJG != null) {
            this.kJG.setPrimary(z);
        }
        if (this.iDK != null && this.iDK.size() > 0 && this.fmy != null) {
            MessageFragmentPagerAdapter.a aVar = this.iDK.get(this.fmy.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iDK != null && this.iDK.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iDK.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iDK.get(i2);
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

    public void cNH() {
        if (this.kJH != null) {
            this.kJH.SM();
        }
    }
}
