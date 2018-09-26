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
    private final NavigationBar dXf;
    private final TextView fqL;
    private final FragmentTabHost fqM;
    private Fragment fqO;
    private final NoNetworkView fqP;
    private CollectTabActivity fqQ;
    private List mTabDataList;
    private int fqN = -1;
    private boolean fqR = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.qA(i);
            a.this.jo(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aYH() {
        return this.fqN;
    }

    public Fragment aYI() {
        return this.fqO;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fqQ = collectTabActivity;
        this.fqM = (FragmentTabHost) this.fqQ.findViewById(e.g.tab_host);
        this.fqM.setup(this.fqQ.getSupportFragmentManager());
        this.fqM.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dXf = (NavigationBar) this.fqQ.findViewById(e.g.navigation_bar);
        this.fqP = (NoNetworkView) this.fqQ.findViewById(e.g.view_no_network);
        this.dXf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dXf.setCenterTextTitle(this.fqQ.getPageContext().getString(e.j.my_mark));
        this.dXf.showBottomLine();
        this.fqL = (TextView) this.dXf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fqQ).findViewById(e.g.right_textview);
        this.fqL.setText(e.j.edit);
        this.fqL.setOnClickListener(this.fqQ);
        View bottomLine = this.dXf.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fqQ.getResources().getDimension(e.C0141e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fqQ.getResources().getDimension(e.C0141e.ds1));
            }
            bottomLine.setBackgroundColor(this.fqQ.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dXf.showBottomLine();
        this.dXf.onChangeSkinType(this.fqQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aYJ() {
        return this.fqL;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jo(boolean z) {
        int i = -1;
        if (this.fqO instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fqO;
            if (!collectFragment.tL()) {
                z = false;
            }
            jp(collectFragment.tL());
            i = collectFragment.getType();
        }
        this.fqR = z;
        this.fqL.setText(this.fqR ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fqL, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fqL, this.fqR ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fqR);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aYK() {
        return this.fqR;
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fqM.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bJ(this.fqQ.getPageContext().getPageActivity()));
                }
            }
            this.fqM.cK(0);
            this.fqM.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fqM.getFragmentTabWidget().setVisibility(8);
            }
            qA(0);
        }
    }

    private int getTabCount() {
        return v.y(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qA(int i) {
        FragmentTabHost.b cM = this.fqM.cM(i);
        this.fqN = cM.mType;
        this.fqO = cM.aqv;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c KE = bVar.KE();
        if (KE != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aqv = KE.aVa;
            bVar2.mType = KE.type;
            fragmentTabIndicator.setText(KE.awr);
            fragmentTabIndicator.setTextSize(0, this.fqQ.getResources().getDimension(e.C0141e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.dQ(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.aqu = fragmentTabIndicator;
            bVar2.aqw = bVar;
            this.fqM.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fqM.onChangeSkinType(i);
        if (this.fqM.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fqM.getTabWrapper().setVisibility(8);
            } else {
                this.fqM.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fqL, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.dXf.onChangeSkinType(this.fqQ.getPageContext(), i);
        this.fqP.onChangeSkinType(this.fqQ.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jp(boolean z) {
        this.fqL.setEnabled(z);
        if (!z) {
            this.fqL.setText(e.j.edit);
            al.b(this.fqL, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
