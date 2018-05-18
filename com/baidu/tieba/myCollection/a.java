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
    private final NavigationBar dyC;
    private final TextView eTT;
    private final FragmentTabHost eTU;
    private Fragment eTW;
    private final NoNetworkView eTX;
    private CollectTabActivity eTY;
    private List mTabDataList;
    private int eTV = -1;
    private boolean eTZ = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.pG(i);
            a.this.iP(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aSz() {
        return this.eTV;
    }

    public Fragment aSA() {
        return this.eTW;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.eTY = collectTabActivity;
        this.eTU = (FragmentTabHost) this.eTY.findViewById(d.g.tab_host);
        this.eTU.setup(this.eTY.getSupportFragmentManager());
        this.eTU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dyC = (NavigationBar) this.eTY.findViewById(d.g.navigation_bar);
        this.eTX = (NoNetworkView) this.eTY.findViewById(d.g.view_no_network);
        this.dyC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dyC.setCenterTextTitle(this.eTY.getPageContext().getString(d.k.my_mark));
        this.dyC.showBottomLine();
        this.eTT = (TextView) this.dyC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, this.eTY).findViewById(d.g.right_textview);
        this.eTT.setText(d.k.edit);
        this.eTT.setOnClickListener(this.eTY);
        View bottomLine = this.dyC.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.eTY.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.eTY.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.eTY.getResources().getColor(d.C0126d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dyC.showBottomLine();
        this.dyC.onChangeSkinType(this.eTY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aSB() {
        return this.eTT;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iP(boolean z) {
        int i = -1;
        if (this.eTW instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.eTW;
            if (!collectFragment.px()) {
                z = false;
            }
            iQ(collectFragment.px());
            i = collectFragment.getType();
        }
        this.eTZ = z;
        this.eTT.setText(this.eTZ ? d.k.done : d.k.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ak.b(this.eTT, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        } else {
            ak.b(this.eTT, this.eTZ ? d.C0126d.cp_link_tip_a : d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.eTZ);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aSC() {
        return this.eTZ;
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.eTU.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.aT(this.eTY.getPageContext().getPageActivity()));
                }
            }
            this.eTU.cv(0);
            this.eTU.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.eTU.getFragmentTabWidget().setVisibility(8);
            }
            pG(0);
        }
    }

    private int getTabCount() {
        return v.v(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG(int i) {
        FragmentTabHost.b cx = this.eTU.cx(i);
        this.eTV = cx.mType;
        this.eTW = cx.afJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Fw = bVar.Fw();
        if (Fw != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = Fw.aIn;
            bVar2.mType = Fw.type;
            fragmentTabIndicator.setText(Fw.aIo);
            fragmentTabIndicator.setTextSize(0, this.eTY.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0126d.s_actionbar_text_color);
            fragmentTabIndicator.dA(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.afI = fragmentTabIndicator;
            bVar2.afK = bVar;
            this.eTU.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.eTU.onChangeSkinType(i);
        if (this.eTU.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.eTU.getTabWrapper().setVisibility(8);
            } else {
                this.eTU.getTabWrapper().setVisibility(0);
            }
        }
        ak.b(this.eTT, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        this.dyC.onChangeSkinType(this.eTY.getPageContext(), i);
        this.eTX.onChangeSkinType(this.eTY.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void iQ(boolean z) {
        this.eTT.setEnabled(z);
        if (!z) {
            this.eTT.setText(d.k.edit);
            ak.b(this.eTT, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        }
    }
}
