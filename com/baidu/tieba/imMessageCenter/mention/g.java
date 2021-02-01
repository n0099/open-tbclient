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
import com.baidu.tbadk.core.util.ap;
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
    private BdBaseViewPager foQ;
    private NoNetworkView gAh;
    private TbTabLayout geR;
    private List<MessageFragmentPagerAdapter.a> iJu;
    private NavigationBar iJz;
    private MessageCenterFragment kRC;
    private MessageFragmentPagerAdapter kRJ;
    private ChatAggregationFragment kRK;
    private ImageView kRL;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kRC = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gAh.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.foQ = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kRK = new ChatAggregationFragment();
        aVar.fragment = this.kRK;
        aVar.title = this.kRC.getResources().getString(R.string.message_center_message_tab);
        this.iJu = new ArrayList();
        this.iJu.add(aVar);
        this.kRJ = new MessageFragmentPagerAdapter(this.kRC.getActivity().getSupportFragmentManager(), this.iJu);
        this.foQ.setAdapter(this.kRJ);
        this.foQ.setOffscreenPageLimit(this.iJu.size());
        this.kRJ.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.geR = (TbTabLayout) LayoutInflater.from(this.kRC.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.geR.setupWithViewPager(this.foQ);
        int tabCount = this.geR.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.geR.aZ(i).bb(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iJz = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iJz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kRC != null) {
                    g.this.kRC.cZi();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kRC.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kRL = new ImageView(this.kRC.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kRC.getContext(), R.dimen.ds88);
        this.kRL.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kRL.setScaleType(ImageView.ScaleType.CENTER);
        this.iJz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kRL, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kRC != null) {
                    g.this.kRC.cZj();
                }
            }
        });
        if (this.kRL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kRL.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kRC.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kRL.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kRL.setVisibility(0);
        } else {
            this.kRL.setVisibility(4);
        }
        if (this.geR != null) {
            this.iJz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.geR, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.geR.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.geR.setPadding(this.geR.getPaddingLeft(), this.geR.getPaddingTop(), this.geR.getPaddingRight(), this.geR.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kRC.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.geR != null && bVar != null) {
            this.geR.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.geR != null && bVar != null) {
            this.geR.b(bVar);
        }
    }

    public void Dy(int i) {
        TbTabLayout.e Dz = Dz(i);
        if (Dz != null) {
            Dz.select();
        }
    }

    public TbTabLayout.e cZk() {
        if (this.geR == null || this.geR.getTabCount() <= 0) {
            return null;
        }
        return this.geR.aZ(this.geR.getSelectedTabPosition());
    }

    public TbTabLayout.e Dz(int i) {
        int tabCount;
        if (this.geR != null && (tabCount = this.geR.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aZ = this.geR.aZ(i2);
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
        if (this.iJz != null) {
            this.iJz.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.iJz.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(getPageContext(), i);
        }
        if (this.iJu != null && this.iJu.size() > 0) {
            for (int i2 = 0; i2 < this.iJu.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iJu.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bsR().a(this.kRL, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.geR != null) {
            this.geR.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.geR.setSelectedTabIndicatorHeight(0);
            this.geR.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iJu != null && this.iJu.size() > 0 && this.foQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.iJu.get(this.foQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajT() {
        if (this.kRC != null && this.iJu != null && this.foQ != null && this.kRJ != null) {
            FragmentManager supportFragmentManager = this.kRC.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iJu.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.foQ.getId(), this.kRJ.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gAh != null) {
            this.gAh.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kRJ != null) {
            this.kRJ.setPrimary(z);
        }
        if (this.iJu != null && this.iJu.size() > 0 && this.foQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.iJu.get(this.foQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iJu != null && this.iJu.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iJu.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iJu.get(i2);
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

    public void cPE() {
        if (this.kRK != null) {
            this.kRK.Ut();
        }
    }
}
