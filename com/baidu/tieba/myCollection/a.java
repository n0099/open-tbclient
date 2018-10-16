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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar eeY;
    private final TextView fyq;
    private final FragmentTabHost fyr;
    private Fragment fyt;
    private final NoNetworkView fyu;
    private CollectTabActivity fyv;
    private List mTabDataList;
    private int fys = -1;
    private boolean fyw = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.qY(i);
            a.this.jG(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bbT() {
        return this.fys;
    }

    public Fragment bbU() {
        return this.fyt;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fyv = collectTabActivity;
        this.fyr = (FragmentTabHost) this.fyv.findViewById(e.g.tab_host);
        this.fyr.setup(this.fyv.getSupportFragmentManager());
        this.fyr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eeY = (NavigationBar) this.fyv.findViewById(e.g.navigation_bar);
        this.fyu = (NoNetworkView) this.fyv.findViewById(e.g.view_no_network);
        this.eeY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eeY.setCenterTextTitle(this.fyv.getPageContext().getString(e.j.my_mark));
        this.eeY.showBottomLine();
        this.fyq = (TextView) this.eeY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fyv).findViewById(e.g.right_textview);
        this.fyq.setText(e.j.edit);
        this.fyq.setOnClickListener(this.fyv);
        View bottomLine = this.eeY.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fyv.getResources().getDimension(e.C0175e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fyv.getResources().getDimension(e.C0175e.ds1));
            }
            bottomLine.setBackgroundColor(this.fyv.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eeY.showBottomLine();
        this.eeY.onChangeSkinType(this.fyv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bbV() {
        return this.fyq;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jG(boolean z) {
        int i = -1;
        if (this.fyt instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fyt;
            if (!collectFragment.vU()) {
                z = false;
            }
            jH(collectFragment.vU());
            i = collectFragment.getType();
        }
        this.fyw = z;
        this.fyq.setText(this.fyw ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fyq, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fyq, this.fyw ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fyw);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bbW() {
        return this.fyw;
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fyr.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bR(this.fyv.getPageContext().getPageActivity()));
                }
            }
            this.fyr.cU(0);
            this.fyr.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fyr.getFragmentTabWidget().setVisibility(8);
            }
            qY(0);
        }
    }

    private int getTabCount() {
        return v.I(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(int i) {
        FragmentTabHost.b cW = this.fyr.cW(i);
        this.fys = cW.mType;
        this.fyt = cW.avm;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c MC = bVar.MC();
        if (MC != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.avm = MC.aZz;
            bVar2.mType = MC.type;
            fragmentTabIndicator.setText(MC.aBc);
            fragmentTabIndicator.setTextSize(0, this.fyv.getResources().getDimension(e.C0175e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.ea(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.avl = fragmentTabIndicator;
            bVar2.avn = bVar;
            this.fyr.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fyr.onChangeSkinType(i);
        if (this.fyr.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fyr.getTabWrapper().setVisibility(8);
            } else {
                this.fyr.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fyq, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.eeY.onChangeSkinType(this.fyv.getPageContext(), i);
        this.fyu.onChangeSkinType(this.fyv.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jH(boolean z) {
        this.fyq.setEnabled(z);
        if (!z) {
            this.fyq.setText(e.j.edit);
            al.b(this.fyq, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
