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
    private final NavigationBar eqK;
    private final TextView fKr;
    private final FragmentTabHost fKs;
    private Fragment fKu;
    private final NoNetworkView fKv;
    private CollectTabActivity fKw;
    private List mTabDataList;
    private int fKt = -1;
    private boolean fKx = false;
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
        return this.fKt;
    }

    public Fragment bex() {
        return this.fKu;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fKw = collectTabActivity;
        this.fKs = (FragmentTabHost) this.fKw.findViewById(e.g.tab_host);
        this.fKs.setup(this.fKw.getSupportFragmentManager());
        this.fKs.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqK = (NavigationBar) this.fKw.findViewById(e.g.navigation_bar);
        this.fKv = (NoNetworkView) this.fKw.findViewById(e.g.view_no_network);
        this.eqK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eqK.setCenterTextTitle(this.fKw.getPageContext().getString(e.j.my_mark));
        this.eqK.showBottomLine();
        this.fKr = (TextView) this.eqK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fKw).findViewById(e.g.right_textview);
        this.fKr.setText(e.j.edit);
        this.fKr.setOnClickListener(this.fKw);
        View bottomLine = this.eqK.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fKw.getResources().getDimension(e.C0210e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fKw.getResources().getDimension(e.C0210e.ds1));
            }
            bottomLine.setBackgroundColor(this.fKw.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eqK.showBottomLine();
        this.eqK.onChangeSkinType(this.fKw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bey() {
        return this.fKr;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jW(boolean z) {
        int i = -1;
        if (this.fKu instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fKu;
            if (!collectFragment.xt()) {
                z = false;
            }
            jX(collectFragment.xt());
            i = collectFragment.getType();
        }
        this.fKx = z;
        this.fKr.setText(this.fKx ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fKr, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fKr, this.fKx ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fKx);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bez() {
        return this.fKx;
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fKs.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bR(this.fKw.getPageContext().getPageActivity()));
                }
            }
            this.fKs.dw(0);
            this.fKs.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fKs.getFragmentTabWidget().setVisibility(8);
            }
            sa(0);
        }
    }

    private int getTabCount() {
        return v.H(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        FragmentTabHost.b dy = this.fKs.dy(i);
        this.fKt = dy.mType;
        this.fKu = dy.aAc;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Oh = bVar.Oh();
        if (Oh != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aAc = Oh.beA;
            bVar2.mType = Oh.type;
            fragmentTabIndicator.setText(Oh.aFV);
            fragmentTabIndicator.setTextSize(0, this.fKw.getResources().getDimension(e.C0210e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.aAb = fragmentTabIndicator;
            bVar2.aAd = bVar;
            this.fKs.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fKs.onChangeSkinType(i);
        if (this.fKs.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fKs.getTabWrapper().setVisibility(8);
            } else {
                this.fKs.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fKr, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.eqK.onChangeSkinType(this.fKw.getPageContext(), i);
        this.fKv.onChangeSkinType(this.fKw.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jX(boolean z) {
        this.fKr.setEnabled(z);
        if (!z) {
            this.fKr.setText(e.j.edit);
            al.b(this.fKr, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
