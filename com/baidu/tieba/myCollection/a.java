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
    private final NavigationBar egt;
    private final TextView fzO;
    private final FragmentTabHost fzP;
    private Fragment fzR;
    private final NoNetworkView fzS;
    private CollectTabActivity fzT;
    private List mTabDataList;
    private int fzQ = -1;
    private boolean fzU = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.rr(i);
            a.this.jQ(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bbs() {
        return this.fzQ;
    }

    public Fragment bbt() {
        return this.fzR;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fzT = collectTabActivity;
        this.fzP = (FragmentTabHost) this.fzT.findViewById(e.g.tab_host);
        this.fzP.setup(this.fzT.getSupportFragmentManager());
        this.fzP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.egt = (NavigationBar) this.fzT.findViewById(e.g.navigation_bar);
        this.fzS = (NoNetworkView) this.fzT.findViewById(e.g.view_no_network);
        this.egt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.egt.setCenterTextTitle(this.fzT.getPageContext().getString(e.j.my_mark));
        this.egt.showBottomLine();
        this.fzO = (TextView) this.egt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fzT).findViewById(e.g.right_textview);
        this.fzO.setText(e.j.edit);
        this.fzO.setOnClickListener(this.fzT);
        View bottomLine = this.egt.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fzT.getResources().getDimension(e.C0200e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fzT.getResources().getDimension(e.C0200e.ds1));
            }
            bottomLine.setBackgroundColor(this.fzT.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.egt.showBottomLine();
        this.egt.onChangeSkinType(this.fzT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bbu() {
        return this.fzO;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jQ(boolean z) {
        int i = -1;
        if (this.fzR instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fzR;
            if (!collectFragment.wc()) {
                z = false;
            }
            jR(collectFragment.wc());
            i = collectFragment.getType();
        }
        this.fzU = z;
        this.fzO.setText(this.fzU ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fzO, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fzO, this.fzU ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fzU);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bbv() {
        return this.fzU;
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fzP.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bO(this.fzT.getPageContext().getPageActivity()));
                }
            }
            this.fzP.di(0);
            this.fzP.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fzP.getFragmentTabWidget().setVisibility(8);
            }
            rr(0);
        }
    }

    private int getTabCount() {
        return v.H(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr(int i) {
        FragmentTabHost.b dk = this.fzP.dk(i);
        this.fzQ = dk.mType;
        this.fzR = dk.avZ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c ML = bVar.ML();
        if (ML != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.avZ = ML.bam;
            bVar2.mType = ML.type;
            fragmentTabIndicator.setText(ML.aBR);
            fragmentTabIndicator.setTextSize(0, this.fzT.getResources().getDimension(e.C0200e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.eo(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.avY = fragmentTabIndicator;
            bVar2.awa = bVar;
            this.fzP.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fzP.onChangeSkinType(i);
        if (this.fzP.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fzP.getTabWrapper().setVisibility(8);
            } else {
                this.fzP.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fzO, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.egt.onChangeSkinType(this.fzT.getPageContext(), i);
        this.fzS.onChangeSkinType(this.fzT.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jR(boolean z) {
        this.fzO.setEnabled(z);
        if (!z) {
            this.fzO.setText(e.j.edit);
            al.b(this.fzO, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
