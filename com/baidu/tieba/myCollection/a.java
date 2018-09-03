package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar dPN;
    private final TextView fjp;
    private final FragmentTabHost fjq;
    private Fragment fjs;
    private final NoNetworkView fjt;
    private CollectTabActivity fju;
    private List mTabDataList;
    private int fjr = -1;
    private boolean fjv = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.pW(i);
            a.this.iQ(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aWu() {
        return this.fjr;
    }

    public Fragment aWv() {
        return this.fjs;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fju = collectTabActivity;
        this.fjq = (FragmentTabHost) this.fju.findViewById(f.g.tab_host);
        this.fjq.setup(this.fju.getSupportFragmentManager());
        this.fjq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dPN = (NavigationBar) this.fju.findViewById(f.g.navigation_bar);
        this.fjt = (NoNetworkView) this.fju.findViewById(f.g.view_no_network);
        this.dPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dPN.setCenterTextTitle(this.fju.getPageContext().getString(f.j.my_mark));
        this.dPN.showBottomLine();
        this.fjp = (TextView) this.dPN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.navigation_right_button_layout, this.fju).findViewById(f.g.right_textview);
        this.fjp.setText(f.j.edit);
        this.fjp.setOnClickListener(this.fju);
        View bottomLine = this.dPN.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fju.getResources().getDimension(f.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fju.getResources().getDimension(f.e.ds1));
            }
            bottomLine.setBackgroundColor(this.fju.getResources().getColor(f.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dPN.showBottomLine();
        this.dPN.onChangeSkinType(this.fju.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aWw() {
        return this.fjp;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iQ(boolean z) {
        int i = -1;
        if (this.fjs instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fjs;
            if (!collectFragment.sF()) {
                z = false;
            }
            iR(collectFragment.sF());
            i = collectFragment.getType();
        }
        this.fjv = z;
        this.fjp.setText(this.fjv ? f.j.done : f.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.b(this.fjp, f.d.navi_op_text, f.d.navi_op_text_skin);
        } else {
            am.b(this.fjp, this.fjv ? f.d.cp_link_tip_a : f.d.navi_op_text, f.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fjv);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aWx() {
        return this.fjv;
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fjq.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bd(this.fju.getPageContext().getPageActivity()));
                }
            }
            this.fjq.cA(0);
            this.fjq.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fjq.getFragmentTabWidget().setVisibility(8);
            }
            pW(0);
        }
    }

    private int getTabCount() {
        return w.y(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(int i) {
        FragmentTabHost.b cC = this.fjq.cC(i);
        this.fjr = cC.mType;
        this.fjs = cC.anP;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Jo = bVar.Jo();
        if (Jo != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.anP = Jo.aRI;
            bVar2.mType = Jo.type;
            fragmentTabIndicator.setText(Jo.aRJ);
            fragmentTabIndicator.setTextSize(0, this.fju.getResources().getDimension(f.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(f.d.s_actionbar_text_color);
            fragmentTabIndicator.dF(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.anO = fragmentTabIndicator;
            bVar2.anQ = bVar;
            this.fjq.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fjq.onChangeSkinType(i);
        if (this.fjq.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fjq.getTabWrapper().setVisibility(8);
            } else {
                this.fjq.getTabWrapper().setVisibility(0);
            }
        }
        am.b(this.fjp, f.d.navi_op_text, f.d.navi_op_text_skin);
        this.dPN.onChangeSkinType(this.fju.getPageContext(), i);
        this.fjt.onChangeSkinType(this.fju.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void iR(boolean z) {
        this.fjp.setEnabled(z);
        if (!z) {
            this.fjp.setText(f.j.edit);
            am.b(this.fjp, f.d.navi_op_text, f.d.navi_op_text_skin);
        }
    }
}
