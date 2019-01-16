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
    private final NavigationBar eqJ;
    private final TextView fKq;
    private final FragmentTabHost fKr;
    private Fragment fKt;
    private final NoNetworkView fKu;
    private CollectTabActivity fKv;
    private List mTabDataList;
    private int fKs = -1;
    private boolean fKw = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.sa(i);
            a.this.jW(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bew() {
        return this.fKs;
    }

    public Fragment bex() {
        return this.fKt;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fKv = collectTabActivity;
        this.fKr = (FragmentTabHost) this.fKv.findViewById(e.g.tab_host);
        this.fKr.setup(this.fKv.getSupportFragmentManager());
        this.fKr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqJ = (NavigationBar) this.fKv.findViewById(e.g.navigation_bar);
        this.fKu = (NoNetworkView) this.fKv.findViewById(e.g.view_no_network);
        this.eqJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eqJ.setCenterTextTitle(this.fKv.getPageContext().getString(e.j.my_mark));
        this.eqJ.showBottomLine();
        this.fKq = (TextView) this.eqJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fKv).findViewById(e.g.right_textview);
        this.fKq.setText(e.j.edit);
        this.fKq.setOnClickListener(this.fKv);
        View bottomLine = this.eqJ.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fKv.getResources().getDimension(e.C0210e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fKv.getResources().getDimension(e.C0210e.ds1));
            }
            bottomLine.setBackgroundColor(this.fKv.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eqJ.showBottomLine();
        this.eqJ.onChangeSkinType(this.fKv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bey() {
        return this.fKq;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jW(boolean z) {
        int i = -1;
        if (this.fKt instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fKt;
            if (!collectFragment.xt()) {
                z = false;
            }
            jX(collectFragment.xt());
            i = collectFragment.getType();
        }
        this.fKw = z;
        this.fKq.setText(this.fKw ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fKq, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fKq, this.fKw ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fKw);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bez() {
        return this.fKw;
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fKr.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bR(this.fKv.getPageContext().getPageActivity()));
                }
            }
            this.fKr.dw(0);
            this.fKr.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fKr.getFragmentTabWidget().setVisibility(8);
            }
            sa(0);
        }
    }

    private int getTabCount() {
        return v.H(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        FragmentTabHost.b dy = this.fKr.dy(i);
        this.fKs = dy.mType;
        this.fKt = dy.aAb;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Oh = bVar.Oh();
        if (Oh != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aAb = Oh.bez;
            bVar2.mType = Oh.type;
            fragmentTabIndicator.setText(Oh.aFU);
            fragmentTabIndicator.setTextSize(0, this.fKv.getResources().getDimension(e.C0210e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.aAa = fragmentTabIndicator;
            bVar2.aAc = bVar;
            this.fKr.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fKr.onChangeSkinType(i);
        if (this.fKr.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fKr.getTabWrapper().setVisibility(8);
            } else {
                this.fKr.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fKq, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.eqJ.onChangeSkinType(this.fKv.getPageContext(), i);
        this.fKu.onChangeSkinType(this.fKv.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jX(boolean z) {
        this.fKq.setEnabled(z);
        if (!z) {
            this.fKq.setText(e.j.edit);
            al.b(this.fKq, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
