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
    private final NavigationBar dxy;
    private final TextView eSP;
    private final FragmentTabHost eSQ;
    private Fragment eSS;
    private final NoNetworkView eST;
    private CollectTabActivity eSU;
    private List mTabDataList;
    private int eSR = -1;
    private boolean eSV = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.pI(i);
            a.this.iO(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aSz() {
        return this.eSR;
    }

    public Fragment aSA() {
        return this.eSS;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.eSU = collectTabActivity;
        this.eSQ = (FragmentTabHost) this.eSU.findViewById(d.g.tab_host);
        this.eSQ.setup(this.eSU.getSupportFragmentManager());
        this.eSQ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dxy = (NavigationBar) this.eSU.findViewById(d.g.navigation_bar);
        this.eST = (NoNetworkView) this.eSU.findViewById(d.g.view_no_network);
        this.dxy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dxy.setCenterTextTitle(this.eSU.getPageContext().getString(d.k.my_mark));
        this.dxy.showBottomLine();
        this.eSP = (TextView) this.dxy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, this.eSU).findViewById(d.g.right_textview);
        this.eSP.setText(d.k.edit);
        this.eSP.setOnClickListener(this.eSU);
        View bottomLine = this.dxy.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.eSU.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.eSU.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.eSU.getResources().getColor(d.C0126d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dxy.showBottomLine();
        this.dxy.onChangeSkinType(this.eSU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aSB() {
        return this.eSP;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iO(boolean z) {
        int i = -1;
        if (this.eSS instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.eSS;
            if (!collectFragment.py()) {
                z = false;
            }
            iP(collectFragment.py());
            i = collectFragment.getType();
        }
        this.eSV = z;
        this.eSP.setText(this.eSV ? d.k.done : d.k.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ak.b(this.eSP, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        } else {
            ak.b(this.eSP, this.eSV ? d.C0126d.cp_link_tip_a : d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.eSV);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aSC() {
        return this.eSV;
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.eSQ.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.aT(this.eSU.getPageContext().getPageActivity()));
                }
            }
            this.eSQ.cv(0);
            this.eSQ.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.eSQ.getFragmentTabWidget().setVisibility(8);
            }
            pI(0);
        }
    }

    private int getTabCount() {
        return v.v(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(int i) {
        FragmentTabHost.b cx = this.eSQ.cx(i);
        this.eSR = cx.mType;
        this.eSS = cx.afJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Fy = bVar.Fy();
        if (Fy != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = Fy.aIm;
            bVar2.mType = Fy.type;
            fragmentTabIndicator.setText(Fy.aIn);
            fragmentTabIndicator.setTextSize(0, this.eSU.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0126d.s_actionbar_text_color);
            fragmentTabIndicator.dA(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.afI = fragmentTabIndicator;
            bVar2.afK = bVar;
            this.eSQ.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.eSQ.onChangeSkinType(i);
        if (this.eSQ.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.eSQ.getTabWrapper().setVisibility(8);
            } else {
                this.eSQ.getTabWrapper().setVisibility(0);
            }
        }
        ak.b(this.eSP, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        this.dxy.onChangeSkinType(this.eSU.getPageContext(), i);
        this.eST.onChangeSkinType(this.eSU.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void iP(boolean z) {
        this.eSP.setEnabled(z);
        if (!z) {
            this.eSP.setText(d.k.edit);
            ak.b(this.eSP, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        }
    }
}
