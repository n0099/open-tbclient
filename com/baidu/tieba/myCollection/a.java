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
    private final NavigationBar ecS;
    private final TextView fye;
    private final FragmentTabHost fyf;
    private Fragment fyh;
    private final NoNetworkView fyi;
    private CollectTabActivity fyj;
    private List mTabDataList;
    private int fyg = -1;
    private boolean fyk = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.sn(i);
            a.this.js(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aXE() {
        return this.fyg;
    }

    public Fragment aXF() {
        return this.fyh;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fyj = collectTabActivity;
        this.fyf = (FragmentTabHost) this.fyj.findViewById(d.g.tab_host);
        this.fyf.setup(this.fyj.getSupportFragmentManager());
        this.fyf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ecS = (NavigationBar) this.fyj.findViewById(d.g.navigation_bar);
        this.fyi = (NoNetworkView) this.fyj.findViewById(d.g.view_no_network);
        this.ecS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecS.setCenterTextTitle(this.fyj.getPageContext().getString(d.j.my_mark));
        this.ecS.showBottomLine();
        this.fye = (TextView) this.ecS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.fyj).findViewById(d.g.right_textview);
        this.fye.setText(d.j.edit);
        this.fye.setOnClickListener(this.fyj);
        View bottomLine = this.ecS.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fyj.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fyj.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.fyj.getResources().getColor(d.C0141d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.ecS.showBottomLine();
        this.ecS.onChangeSkinType(this.fyj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aXG() {
        return this.fye;
    }

    @SuppressLint({"ResourceAsColor"})
    public void js(boolean z) {
        int i = -1;
        if (this.fyh instanceof com.baidu.tbadk.g.b) {
            com.baidu.tbadk.g.b bVar = (com.baidu.tbadk.g.b) this.fyh;
            if (!bVar.wO()) {
                z = false;
            }
            jt(bVar.wO());
            i = bVar.getType();
        }
        this.fyk = z;
        this.fye.setText(this.fyk ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            aj.d(this.fye, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        } else {
            aj.d(this.fye, this.fyk ? d.C0141d.cp_link_tip_a : d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fyk);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aXH() {
        return this.fyk;
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fyf.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bi(this.fyj.getPageContext().getPageActivity()));
                }
            }
            this.fyf.fw(0);
            this.fyf.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fyf.getFragmentTabWidget().setVisibility(8);
            }
            sn(0);
        }
    }

    private int getTabCount() {
        return v.D(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(int i) {
        FragmentTabHost.c fy = this.fyf.fy(i);
        this.fyg = fy.mType;
        this.fyh = fy.aUp;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c MV = bVar.MV();
        if (MV != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.aUp = MV.bxP;
            cVar.mType = MV.type;
            fragmentTabIndicator.setText(MV.bxQ);
            fragmentTabIndicator.setTextSize(0, this.fyj.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0141d.s_actionbar_text_color);
            fragmentTabIndicator.gB(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar.aUo = fragmentTabIndicator;
            cVar.aUq = bVar;
            this.fyf.a(cVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.fyf.onChangeSkinType(i);
        if (this.fyf.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fyf.getTabWrapper().setVisibility(8);
            } else {
                this.fyf.getTabWrapper().setVisibility(0);
            }
        }
        aj.d(this.fye, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        this.ecS.onChangeSkinType(this.fyj.getPageContext(), i);
        this.fyi.onChangeSkinType(this.fyj.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jt(boolean z) {
        this.fye.setEnabled(z);
        if (!z) {
            this.fye.setText(d.j.edit);
            aj.d(this.fye, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        }
    }
}
