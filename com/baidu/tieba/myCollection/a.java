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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar dPR;
    private CollectTabActivity fjA;
    private final TextView fjv;
    private final FragmentTabHost fjw;
    private Fragment fjy;
    private final NoNetworkView fjz;
    private List mTabDataList;
    private int fjx = -1;
    private boolean fjB = false;
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

    public int aWy() {
        return this.fjx;
    }

    public Fragment aWz() {
        return this.fjy;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fjA = collectTabActivity;
        this.fjw = (FragmentTabHost) this.fjA.findViewById(d.g.tab_host);
        this.fjw.setup(this.fjA.getSupportFragmentManager());
        this.fjw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dPR = (NavigationBar) this.fjA.findViewById(d.g.navigation_bar);
        this.fjz = (NoNetworkView) this.fjA.findViewById(d.g.view_no_network);
        this.dPR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dPR.setCenterTextTitle(this.fjA.getPageContext().getString(d.j.my_mark));
        this.dPR.showBottomLine();
        this.fjv = (TextView) this.dPR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.fjA).findViewById(d.g.right_textview);
        this.fjv.setText(d.j.edit);
        this.fjv.setOnClickListener(this.fjA);
        View bottomLine = this.dPR.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fjA.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fjA.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.fjA.getResources().getColor(d.C0140d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dPR.showBottomLine();
        this.dPR.onChangeSkinType(this.fjA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aWA() {
        return this.fjv;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iQ(boolean z) {
        int i = -1;
        if (this.fjy instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fjy;
            if (!collectFragment.sG()) {
                z = false;
            }
            iR(collectFragment.sG());
            i = collectFragment.getType();
        }
        this.fjB = z;
        this.fjv.setText(this.fjB ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.b(this.fjv, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        } else {
            am.b(this.fjv, this.fjB ? d.C0140d.cp_link_tip_a : d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fjB);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aWB() {
        return this.fjB;
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fjw.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.be(this.fjA.getPageContext().getPageActivity()));
                }
            }
            this.fjw.cA(0);
            this.fjw.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fjw.getFragmentTabWidget().setVisibility(8);
            }
            pW(0);
        }
    }

    private int getTabCount() {
        return w.y(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(int i) {
        FragmentTabHost.b cC = this.fjw.cC(i);
        this.fjx = cC.mType;
        this.fjy = cC.anO;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Jo = bVar.Jo();
        if (Jo != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.anO = Jo.aRL;
            bVar2.mType = Jo.type;
            fragmentTabIndicator.setText(Jo.aRM);
            fragmentTabIndicator.setTextSize(0, this.fjA.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0140d.s_actionbar_text_color);
            fragmentTabIndicator.dG(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.anN = fragmentTabIndicator;
            bVar2.anP = bVar;
            this.fjw.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fjw.onChangeSkinType(i);
        if (this.fjw.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fjw.getTabWrapper().setVisibility(8);
            } else {
                this.fjw.getTabWrapper().setVisibility(0);
            }
        }
        am.b(this.fjv, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        this.dPR.onChangeSkinType(this.fjA.getPageContext(), i);
        this.fjz.onChangeSkinType(this.fjA.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void iR(boolean z) {
        this.fjv.setEnabled(z);
        if (!z) {
            this.fjv.setText(d.j.edit);
            am.b(this.fjv, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        }
    }
}
