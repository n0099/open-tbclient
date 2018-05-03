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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar dxv;
    private final TextView eSM;
    private final FragmentTabHost eSN;
    private Fragment eSP;
    private final NoNetworkView eSQ;
    private CollectTabActivity eSR;
    private List mTabDataList;
    private int eSO = -1;
    private boolean eSS = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.pH(i);
            a.this.iO(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aSz() {
        return this.eSO;
    }

    public Fragment aSA() {
        return this.eSP;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.eSR = collectTabActivity;
        this.eSN = (FragmentTabHost) this.eSR.findViewById(d.g.tab_host);
        this.eSN.setup(this.eSR.getSupportFragmentManager());
        this.eSN.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dxv = (NavigationBar) this.eSR.findViewById(d.g.navigation_bar);
        this.eSQ = (NoNetworkView) this.eSR.findViewById(d.g.view_no_network);
        this.dxv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dxv.setCenterTextTitle(this.eSR.getPageContext().getString(d.k.my_mark));
        this.dxv.showBottomLine();
        this.eSM = (TextView) this.dxv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, this.eSR).findViewById(d.g.right_textview);
        this.eSM.setText(d.k.edit);
        this.eSM.setOnClickListener(this.eSR);
        View bottomLine = this.dxv.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.eSR.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.eSR.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.eSR.getResources().getColor(d.C0126d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dxv.showBottomLine();
        this.dxv.onChangeSkinType(this.eSR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aSB() {
        return this.eSM;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iO(boolean z) {
        int i = -1;
        if (this.eSP instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.eSP;
            if (!collectFragment.py()) {
                z = false;
            }
            iP(collectFragment.py());
            i = collectFragment.getType();
        }
        this.eSS = z;
        this.eSM.setText(this.eSS ? d.k.done : d.k.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ak.b(this.eSM, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        } else {
            ak.b(this.eSM, this.eSS ? d.C0126d.cp_link_tip_a : d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.eSS);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aSC() {
        return this.eSS;
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.eSN.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.aT(this.eSR.getPageContext().getPageActivity()));
                }
            }
            this.eSN.cu(0);
            this.eSN.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.eSN.getFragmentTabWidget().setVisibility(8);
            }
            pH(0);
        }
    }

    private int getTabCount() {
        return v.v(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH(int i) {
        FragmentTabHost.b cw = this.eSN.cw(i);
        this.eSO = cw.mType;
        this.eSP = cw.afJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Fy = bVar.Fy();
        if (Fy != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = Fy.aIm;
            bVar2.mType = Fy.type;
            fragmentTabIndicator.setText(Fy.aIn);
            fragmentTabIndicator.setTextSize(0, this.eSR.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0126d.s_actionbar_text_color);
            fragmentTabIndicator.dz(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.afI = fragmentTabIndicator;
            bVar2.afK = bVar;
            this.eSN.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.eSN.onChangeSkinType(i);
        if (this.eSN.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.eSN.getTabWrapper().setVisibility(8);
            } else {
                this.eSN.getTabWrapper().setVisibility(0);
            }
        }
        ak.b(this.eSM, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        this.dxv.onChangeSkinType(this.eSR.getPageContext(), i);
        this.eSQ.onChangeSkinType(this.eSR.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void iP(boolean z) {
        this.eSM.setEnabled(z);
        if (!z) {
            this.eSM.setText(d.k.edit);
            ak.b(this.eSM, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        }
    }
}
