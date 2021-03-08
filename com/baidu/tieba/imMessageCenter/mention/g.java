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
    private BdBaseViewPager fqq;
    private NoNetworkView gCe;
    private TbTabLayout ggz;
    private List<MessageFragmentPagerAdapter.a> iLr;
    private NavigationBar iLw;
    private MessageCenterFragment kTS;
    private MessageFragmentPagerAdapter kTZ;
    private ChatAggregationFragment kUa;
    private ImageView kUb;
    private View mRootView;

    public g(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.kTS = messageCenterFragment;
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gCe.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.fqq = (BdBaseViewPager) this.mRootView.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        this.kUa = new ChatAggregationFragment();
        aVar.fragment = this.kUa;
        aVar.title = this.kTS.getResources().getString(R.string.message_center_message_tab);
        this.iLr = new ArrayList();
        this.iLr.add(aVar);
        this.kTZ = new MessageFragmentPagerAdapter(this.kTS.getActivity().getSupportFragmentManager(), this.iLr);
        this.fqq.setAdapter(this.kTZ);
        this.fqq.setOffscreenPageLimit(this.iLr.size());
        this.kTZ.notifyDataSetChanged();
    }

    private void al(Bundle bundle) {
        this.ggz = (TbTabLayout) LayoutInflater.from(this.kTS.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.ggz.setupWithViewPager(this.fqq);
        int tabCount = this.ggz.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.ggz.ba(i).bc(1);
            }
        }
    }

    private void am(Bundle bundle) {
        this.iLw = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        View addSystemImageButton = this.iLw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kTS != null) {
                    g.this.kTS.cZw();
                }
            }
        });
        if (addSystemImageButton != null) {
            if (this.kTS.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.kUb = new ImageView(this.kTS.getContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.kTS.getContext(), R.dimen.ds88);
        this.kUb.setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        this.kUb.setScaleType(ImageView.ScaleType.CENTER);
        this.iLw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kUb, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.kTS != null) {
                    g.this.kTS.cZx();
                }
            }
        });
        if (this.kUb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kUb.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.getDimens(this.kTS.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.kUb.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.kUb.setVisibility(0);
        } else {
            this.kUb.setVisibility(4);
        }
        if (this.ggz != null) {
            this.iLw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.ggz, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ggz.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ggz.setPadding(this.ggz.getPaddingLeft(), this.ggz.getPaddingTop(), this.ggz.getPaddingRight(), this.ggz.getPaddingBottom() + com.baidu.adp.lib.util.l.getDimens(this.kTS.getContext(), R.dimen.ds1));
        }
    }

    public void a(TbTabLayout.b bVar) {
        if (this.ggz != null && bVar != null) {
            this.ggz.a(bVar);
        }
    }

    public void b(TbTabLayout.b bVar) {
        if (this.ggz != null && bVar != null) {
            this.ggz.b(bVar);
        }
    }

    public void DB(int i) {
        TbTabLayout.e DC = DC(i);
        if (DC != null) {
            DC.select();
        }
    }

    public TbTabLayout.e cZy() {
        if (this.ggz == null || this.ggz.getTabCount() <= 0) {
            return null;
        }
        return this.ggz.ba(this.ggz.getSelectedTabPosition());
    }

    public TbTabLayout.e DC(int i) {
        int tabCount;
        if (this.ggz != null && (tabCount = this.ggz.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e ba = this.ggz.ba(i2);
                if (ba != null && ba.getId() != -1 && ba.getId() == i) {
                    return ba;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.iLw != null) {
            this.iLw.onChangeSkinType(getPageContext(), i);
            ap.setBackgroundColor(this.iLw.getBarBgView(), R.color.CAM_X0207, i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(getPageContext(), i);
        }
        if (this.iLr != null && this.iLr.size() > 0) {
            for (int i2 = 0; i2 < this.iLr.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.iLr.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.bsU().a(this.kUb, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.ggz != null) {
            this.ggz.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.ggz.setSelectedTabIndicatorHeight(0);
            this.ggz.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iLr != null && this.iLr.size() > 0 && this.fqq != null) {
            MessageFragmentPagerAdapter.a aVar = this.iLr.get(this.fqq.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajW() {
        if (this.kTS != null && this.iLr != null && this.fqq != null && this.kTZ != null) {
            FragmentManager supportFragmentManager = this.kTS.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iLr.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.fqq.getId(), this.kTZ.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gCe != null) {
            this.gCe.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.kTZ != null) {
            this.kTZ.setPrimary(z);
        }
        if (this.iLr != null && this.iLr.size() > 0 && this.fqq != null) {
            MessageFragmentPagerAdapter.a aVar = this.iLr.get(this.fqq.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iLr != null && this.iLr.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iLr.size()) {
                    MessageFragmentPagerAdapter.a aVar = this.iLr.get(i2);
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

    public void cPS() {
        if (this.kUa != null) {
            this.kUa.Uw();
        }
    }
}
