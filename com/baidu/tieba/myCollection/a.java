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
    private final NavigationBar ecO;
    private final TextView fya;
    private final FragmentTabHost fyb;
    private Fragment fyd;
    private final NoNetworkView fye;
    private CollectTabActivity fyf;
    private List mTabDataList;
    private int fyc = -1;
    private boolean fyg = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.sm(i);
            a.this.jn(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aXE() {
        return this.fyc;
    }

    public Fragment aXF() {
        return this.fyd;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fyf = collectTabActivity;
        this.fyb = (FragmentTabHost) this.fyf.findViewById(d.g.tab_host);
        this.fyb.setup(this.fyf.getSupportFragmentManager());
        this.fyb.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ecO = (NavigationBar) this.fyf.findViewById(d.g.navigation_bar);
        this.fye = (NoNetworkView) this.fyf.findViewById(d.g.view_no_network);
        this.ecO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecO.setCenterTextTitle(this.fyf.getPageContext().getString(d.j.my_mark));
        this.ecO.showBottomLine();
        this.fya = (TextView) this.ecO.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.fyf).findViewById(d.g.right_textview);
        this.fya.setText(d.j.edit);
        this.fya.setOnClickListener(this.fyf);
        View bottomLine = this.ecO.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fyf.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fyf.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.fyf.getResources().getColor(d.C0140d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.ecO.showBottomLine();
        this.ecO.onChangeSkinType(this.fyf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aXG() {
        return this.fya;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jn(boolean z) {
        int i = -1;
        if (this.fyd instanceof com.baidu.tbadk.g.b) {
            com.baidu.tbadk.g.b bVar = (com.baidu.tbadk.g.b) this.fyd;
            if (!bVar.wO()) {
                z = false;
            }
            jo(bVar.wO());
            i = bVar.getType();
        }
        this.fyg = z;
        this.fya.setText(this.fyg ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            aj.d(this.fya, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        } else {
            aj.d(this.fya, this.fyg ? d.C0140d.cp_link_tip_a : d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fyg);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aXH() {
        return this.fyg;
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fyb.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bi(this.fyf.getPageContext().getPageActivity()));
                }
            }
            this.fyb.fw(0);
            this.fyb.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fyb.getFragmentTabWidget().setVisibility(8);
            }
            sm(0);
        }
    }

    private int getTabCount() {
        return v.D(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(int i) {
        FragmentTabHost.c fy = this.fyb.fy(i);
        this.fyc = fy.mType;
        this.fyd = fy.aUz;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c MV = bVar.MV();
        if (MV != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.aUz = MV.bxZ;
            cVar.mType = MV.type;
            fragmentTabIndicator.setText(MV.bya);
            fragmentTabIndicator.setTextSize(0, this.fyf.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0140d.s_actionbar_text_color);
            fragmentTabIndicator.gB(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar.aUy = fragmentTabIndicator;
            cVar.aUA = bVar;
            this.fyb.a(cVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.fyb.onChangeSkinType(i);
        if (this.fyb.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fyb.getTabWrapper().setVisibility(8);
            } else {
                this.fyb.getTabWrapper().setVisibility(0);
            }
        }
        aj.d(this.fya, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        this.ecO.onChangeSkinType(this.fyf.getPageContext(), i);
        this.fye.onChangeSkinType(this.fyf.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jo(boolean z) {
        this.fya.setEnabled(z);
        if (!z) {
            this.fya.setText(d.j.edit);
            aj.d(this.fya, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        }
    }
}
