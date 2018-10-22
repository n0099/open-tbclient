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
    private final NavigationBar eeZ;
    private final TextView fyr;
    private final FragmentTabHost fys;
    private Fragment fyu;
    private final NoNetworkView fyv;
    private CollectTabActivity fyw;
    private List mTabDataList;
    private int fyt = -1;
    private boolean fyx = false;
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
        return this.fyt;
    }

    public Fragment bbU() {
        return this.fyu;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fyw = collectTabActivity;
        this.fys = (FragmentTabHost) this.fyw.findViewById(e.g.tab_host);
        this.fys.setup(this.fyw.getSupportFragmentManager());
        this.fys.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eeZ = (NavigationBar) this.fyw.findViewById(e.g.navigation_bar);
        this.fyv = (NoNetworkView) this.fyw.findViewById(e.g.view_no_network);
        this.eeZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eeZ.setCenterTextTitle(this.fyw.getPageContext().getString(e.j.my_mark));
        this.eeZ.showBottomLine();
        this.fyr = (TextView) this.eeZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fyw).findViewById(e.g.right_textview);
        this.fyr.setText(e.j.edit);
        this.fyr.setOnClickListener(this.fyw);
        View bottomLine = this.eeZ.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fyw.getResources().getDimension(e.C0175e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fyw.getResources().getDimension(e.C0175e.ds1));
            }
            bottomLine.setBackgroundColor(this.fyw.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eeZ.showBottomLine();
        this.eeZ.onChangeSkinType(this.fyw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bbV() {
        return this.fyr;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jG(boolean z) {
        int i = -1;
        if (this.fyu instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fyu;
            if (!collectFragment.vU()) {
                z = false;
            }
            jH(collectFragment.vU());
            i = collectFragment.getType();
        }
        this.fyx = z;
        this.fyr.setText(this.fyx ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fyr, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fyr, this.fyx ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fyx);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bbW() {
        return this.fyx;
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fys.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bR(this.fyw.getPageContext().getPageActivity()));
                }
            }
            this.fys.cU(0);
            this.fys.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fys.getFragmentTabWidget().setVisibility(8);
            }
            qY(0);
        }
    }

    private int getTabCount() {
        return v.I(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(int i) {
        FragmentTabHost.b cW = this.fys.cW(i);
        this.fyt = cW.mType;
        this.fyu = cW.avm;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c MC = bVar.MC();
        if (MC != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.avm = MC.aZz;
            bVar2.mType = MC.type;
            fragmentTabIndicator.setText(MC.aBc);
            fragmentTabIndicator.setTextSize(0, this.fyw.getResources().getDimension(e.C0175e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.ea(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.avl = fragmentTabIndicator;
            bVar2.avn = bVar;
            this.fys.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fys.onChangeSkinType(i);
        if (this.fys.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fys.getTabWrapper().setVisibility(8);
            } else {
                this.fys.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fyr, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.eeZ.onChangeSkinType(this.fyw.getPageContext(), i);
        this.fyv.onChangeSkinType(this.fyw.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jH(boolean z) {
        this.fyr.setEnabled(z);
        if (!z) {
            this.fyr.setText(e.j.edit);
            al.b(this.fyr, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
