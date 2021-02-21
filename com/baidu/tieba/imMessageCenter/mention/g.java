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
    private NoNetworkView gAv;
    private TbTabLayout geW;
    private List<MessageFragmentPagerAdapter.a> iJI;
    private NavigationBar iJN;
    private MessageCenterFragment kRQ;
    private MessageFragmentPagerAdapter kRX;
    private ChatAggregationFragment kRY;
    private ImageView kRZ;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kRQ = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gAv.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.foQ = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kRY = new ChatAggregationFragment();
        aVar.fragment = this.kRY;
        aVar.title = this.kRQ.getResources().getString(R.string.message_center_message_tab);
        this.iJI = new ArrayList();
        this.iJI.add(aVar);
        this.kRX = new MessageFragmentPagerAdapter(this.kRQ.getActivity().getSupportFragmentManager(), this.iJI);
        this.foQ.setAdapter(this.kRX);
        this.foQ.setOffscreenPageLimit(this.iJI.size());
        this.kRX.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.geW = (TbTabLayout) LayoutInflater.from(this.kRQ.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.geW.setupWithViewPager(this.foQ);
        int tabCount = this.geW.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.geW.aZ(i).bb(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iJN = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iJN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kRQ != null) {
                    g.this.kRQ.cZp();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kRQ.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kRZ = new ImageView(this.kRQ.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kRQ.getContext(), R.dimen.ds88);
        this.kRZ.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kRZ.setScaleType(ImageView.ScaleType.CENTER);
        this.iJN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kRZ, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kRQ != null) {
                    g.this.kRQ.cZq();
                }
            }
        });
        if (this.kRZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kRZ.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kRQ.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kRZ.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kRZ.setVisibility(0);
        } else {
            this.kRZ.setVisibility(4);
        }
        if (this.geW != null) {
            this.iJN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.geW, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.geW.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.geW.setPadding(this.geW.getPaddingLeft(), this.geW.getPaddingTop(), this.geW.getPaddingRight(), this.geW.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kRQ.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.geW != null && bVar != null) {
            this.geW.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.geW != null && bVar != null) {
            this.geW.b(bVar);
        }
    }

    public void Dy(int i) {
        TbTabLayout.e Dz = Dz(i);
        if (Dz != null) {
            Dz.select();
        }
    }

    public TbTabLayout.e cZr() {
        if (this.geW == null || this.geW.getTabCount() <= 0) {
            return null;
        }
        return this.geW.aZ(this.geW.getSelectedTabPosition());
    }

    public TbTabLayout.e Dz(int i) {
        int tabCount;
        if (this.geW != null && (tabCount = this.geW.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e aZ = this.geW.aZ(i2);
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
        if (this.iJN != null) {
            this.iJN.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.iJN.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.gAv != null) {
            this.gAv.onChangeSkinType(getPageContext(), i);
        }
        if (this.iJI != null && this.iJI.size() > 0) {
            for (int i2 = 0; i2 < this.iJI.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iJI.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bsR().a(this.kRZ, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.geW != null) {
            this.geW.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.geW.setSelectedTabIndicatorHeight(0);
            this.geW.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iJI != null && this.iJI.size() > 0 && this.foQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.iJI.get(this.foQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajT() {
        if (this.kRQ != null && this.iJI != null && this.foQ != null && this.kRX != null) {
            FragmentManager supportFragmentManager = this.kRQ.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iJI.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.foQ.getId(), this.kRX.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gAv != null) {
            this.gAv.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kRX != null) {
            this.kRX.setPrimary(z);
        }
        if (this.iJI != null && this.iJI.size() > 0 && this.foQ != null) {
            MessageFragmentPagerAdapter.a aVar = this.iJI.get(this.foQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iJI != null && this.iJI.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iJI.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iJI.get(i2);
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

    public void cPL() {
        if (this.kRY != null) {
            this.kRY.Ut();
        }
    }
}
