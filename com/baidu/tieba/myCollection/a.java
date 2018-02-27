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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar ecC;
    private final TextView fxO;
    private final FragmentTabHost fxP;
    private Fragment fxR;
    private final NoNetworkView fxS;
    private CollectTabActivity fxT;
    private List mTabDataList;
    private int fxQ = -1;
    private boolean fxU = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.sn(i);
            a.this.jn(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aXD() {
        return this.fxQ;
    }

    public Fragment aXE() {
        return this.fxR;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fxT = collectTabActivity;
        this.fxP = (FragmentTabHost) this.fxT.findViewById(d.g.tab_host);
        this.fxP.setup(this.fxT.getSupportFragmentManager());
        this.fxP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ecC = (NavigationBar) this.fxT.findViewById(d.g.navigation_bar);
        this.fxS = (NoNetworkView) this.fxT.findViewById(d.g.view_no_network);
        this.ecC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecC.setCenterTextTitle(this.fxT.getPageContext().getString(d.j.my_mark));
        this.ecC.showBottomLine();
        this.fxO = (TextView) this.ecC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.fxT).findViewById(d.g.right_textview);
        this.fxO.setText(d.j.edit);
        this.fxO.setOnClickListener(this.fxT);
        View bottomLine = this.ecC.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fxT.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fxT.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.fxT.getResources().getColor(d.C0141d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.ecC.showBottomLine();
        this.ecC.onChangeSkinType(this.fxT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aXF() {
        return this.fxO;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jn(boolean z) {
        int i = -1;
        if (this.fxR instanceof com.baidu.tbadk.g.b) {
            com.baidu.tbadk.g.b bVar = (com.baidu.tbadk.g.b) this.fxR;
            if (!bVar.wO()) {
                z = false;
            }
            jo(bVar.wO());
            i = bVar.getType();
        }
        this.fxU = z;
        this.fxO.setText(this.fxU ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            aj.d(this.fxO, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        } else {
            aj.d(this.fxO, this.fxU ? d.C0141d.cp_link_tip_a : d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fxU);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aXG() {
        return this.fxU;
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fxP.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bi(this.fxT.getPageContext().getPageActivity()));
                }
            }
            this.fxP.fw(0);
            this.fxP.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fxP.getFragmentTabWidget().setVisibility(8);
            }
            sn(0);
        }
    }

    private int getTabCount() {
        return v.D(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(int i) {
        FragmentTabHost.c fy = this.fxP.fy(i);
        this.fxQ = fy.mType;
        this.fxR = fy.aUn;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c MU = bVar.MU();
        if (MU != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.aUn = MU.bxM;
            cVar.mType = MU.type;
            fragmentTabIndicator.setText(MU.bxN);
            fragmentTabIndicator.setTextSize(0, this.fxT.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0141d.s_actionbar_text_color);
            fragmentTabIndicator.gB(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar.aUm = fragmentTabIndicator;
            cVar.aUo = bVar;
            this.fxP.a(cVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.fxP.onChangeSkinType(i);
        if (this.fxP.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fxP.getTabWrapper().setVisibility(8);
            } else {
                this.fxP.getTabWrapper().setVisibility(0);
            }
        }
        aj.d(this.fxO, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        this.ecC.onChangeSkinType(this.fxT.getPageContext(), i);
        this.fxS.onChangeSkinType(this.fxT.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jo(boolean z) {
        this.fxO.setEnabled(z);
        if (!z) {
            this.fxO.setText(d.j.edit);
            aj.d(this.fxO, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        }
    }
}
