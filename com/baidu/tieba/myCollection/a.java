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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar dNe;
    private final TextView fjj;
    private final FragmentTabHost fjk;
    private Fragment fjm;
    private final NoNetworkView fjn;
    private CollectTabActivity fjo;
    private List mTabDataList;
    private int fjl = -1;
    private boolean fjp = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.pZ(i);
            a.this.je(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aYc() {
        return this.fjl;
    }

    public Fragment aYd() {
        return this.fjm;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fjo = collectTabActivity;
        this.fjk = (FragmentTabHost) this.fjo.findViewById(d.g.tab_host);
        this.fjk.setup(this.fjo.getSupportFragmentManager());
        this.fjk.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dNe = (NavigationBar) this.fjo.findViewById(d.g.navigation_bar);
        this.fjn = (NoNetworkView) this.fjo.findViewById(d.g.view_no_network);
        this.dNe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dNe.setCenterTextTitle(this.fjo.getPageContext().getString(d.k.my_mark));
        this.dNe.showBottomLine();
        this.fjj = (TextView) this.dNe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, this.fjo).findViewById(d.g.right_textview);
        this.fjj.setText(d.k.edit);
        this.fjj.setOnClickListener(this.fjo);
        View bottomLine = this.dNe.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fjo.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fjo.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.fjo.getResources().getColor(d.C0142d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dNe.showBottomLine();
        this.dNe.onChangeSkinType(this.fjo.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aYe() {
        return this.fjj;
    }

    @SuppressLint({"ResourceAsColor"})
    public void je(boolean z) {
        int i = -1;
        if (this.fjm instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fjm;
            if (!collectFragment.sU()) {
                z = false;
            }
            jf(collectFragment.sU());
            i = collectFragment.getType();
        }
        this.fjp = z;
        this.fjj.setText(this.fjp ? d.k.done : d.k.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.b(this.fjj, d.C0142d.navi_op_text, d.C0142d.navi_op_text_skin);
        } else {
            am.b(this.fjj, this.fjp ? d.C0142d.cp_link_tip_a : d.C0142d.navi_op_text, d.C0142d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fjp);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aYf() {
        return this.fjp;
    }

    public void al(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fjk.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bd(this.fjo.getPageContext().getPageActivity()));
                }
            }
            this.fjk.cy(0);
            this.fjk.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fjk.getFragmentTabWidget().setVisibility(8);
            }
            pZ(0);
        }
    }

    private int getTabCount() {
        return w.z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(int i) {
        FragmentTabHost.b cA = this.fjk.cA(i);
        this.fjl = cA.mType;
        this.fjm = cA.aon;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Jt = bVar.Jt();
        if (Jt != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aon = Jt.aRL;
            bVar2.mType = Jt.type;
            fragmentTabIndicator.setText(Jt.aRM);
            fragmentTabIndicator.setTextSize(0, this.fjo.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0142d.s_actionbar_text_color);
            fragmentTabIndicator.dD(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.aom = fragmentTabIndicator;
            bVar2.aoo = bVar;
            this.fjk.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fjk.onChangeSkinType(i);
        if (this.fjk.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fjk.getTabWrapper().setVisibility(8);
            } else {
                this.fjk.getTabWrapper().setVisibility(0);
            }
        }
        am.b(this.fjj, d.C0142d.navi_op_text, d.C0142d.navi_op_text_skin);
        this.dNe.onChangeSkinType(this.fjo.getPageContext(), i);
        this.fjn.onChangeSkinType(this.fjo.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jf(boolean z) {
        this.fjj.setEnabled(z);
        if (!z) {
            this.fjj.setText(d.k.edit);
            am.b(this.fjj, d.C0142d.navi_op_text, d.C0142d.navi_op_text_skin);
        }
    }
}
