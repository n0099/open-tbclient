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
    private final NavigationBar enm;
    private final TextView fGE;
    private final FragmentTabHost fGF;
    private Fragment fGH;
    private final NoNetworkView fGI;
    private CollectTabActivity fGJ;
    private List mTabDataList;
    private int fGG = -1;
    private boolean fGK = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.rL(i);
            a.this.jT(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bdi() {
        return this.fGG;
    }

    public Fragment bdj() {
        return this.fGH;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fGJ = collectTabActivity;
        this.fGF = (FragmentTabHost) this.fGJ.findViewById(e.g.tab_host);
        this.fGF.setup(this.fGJ.getSupportFragmentManager());
        this.fGF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.enm = (NavigationBar) this.fGJ.findViewById(e.g.navigation_bar);
        this.fGI = (NoNetworkView) this.fGJ.findViewById(e.g.view_no_network);
        this.enm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.enm.setCenterTextTitle(this.fGJ.getPageContext().getString(e.j.my_mark));
        this.enm.showBottomLine();
        this.fGE = (TextView) this.enm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fGJ).findViewById(e.g.right_textview);
        this.fGE.setText(e.j.edit);
        this.fGE.setOnClickListener(this.fGJ);
        View bottomLine = this.enm.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fGJ.getResources().getDimension(e.C0210e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fGJ.getResources().getDimension(e.C0210e.ds1));
            }
            bottomLine.setBackgroundColor(this.fGJ.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.enm.showBottomLine();
        this.enm.onChangeSkinType(this.fGJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bdk() {
        return this.fGE;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jT(boolean z) {
        int i = -1;
        if (this.fGH instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fGH;
            if (!collectFragment.xg()) {
                z = false;
            }
            jU(collectFragment.xg());
            i = collectFragment.getType();
        }
        this.fGK = z;
        this.fGE.setText(this.fGK ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fGE, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fGE, this.fGK ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fGK);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bdl() {
        return this.fGK;
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fGF.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bR(this.fGJ.getPageContext().getPageActivity()));
                }
            }
            this.fGF.dw(0);
            this.fGF.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fGF.getFragmentTabWidget().setVisibility(8);
            }
            rL(0);
        }
    }

    private int getTabCount() {
        return v.H(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(int i) {
        FragmentTabHost.b dy = this.fGF.dy(i);
        this.fGG = dy.mType;
        this.fGH = dy.azz;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c NP = bVar.NP();
        if (NP != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.azz = NP.bdK;
            bVar2.mType = NP.type;
            fragmentTabIndicator.setText(NP.aFr);
            fragmentTabIndicator.setTextSize(0, this.fGJ.getResources().getDimension(e.C0210e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.eC(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.azy = fragmentTabIndicator;
            bVar2.azA = bVar;
            this.fGF.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fGF.onChangeSkinType(i);
        if (this.fGF.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fGF.getTabWrapper().setVisibility(8);
            } else {
                this.fGF.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fGE, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.enm.onChangeSkinType(this.fGJ.getPageContext(), i);
        this.fGI.onChangeSkinType(this.fGJ.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jU(boolean z) {
        this.fGE.setEnabled(z);
        if (!z) {
            this.fGE.setText(e.j.edit);
            al.b(this.fGE, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
