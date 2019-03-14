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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private final NavigationBar eDp;
    private final TextView haC;
    private final FragmentTabHost haD;
    private Fragment haF;
    private final NoNetworkView haG;
    private CollectTabActivity haH;
    private List mTabDataList;
    private int haE = -1;
    private boolean haI = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.vJ(i);
            a.this.mx(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bEZ() {
        return this.haE;
    }

    public Fragment bFa() {
        return this.haF;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.haH = collectTabActivity;
        this.haD = (FragmentTabHost) this.haH.findViewById(d.g.tab_host);
        this.haD.setup(this.haH.getSupportFragmentManager());
        this.haD.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eDp = (NavigationBar) this.haH.findViewById(d.g.navigation_bar);
        this.haG = (NoNetworkView) this.haH.findViewById(d.g.view_no_network);
        this.eDp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDp.setCenterTextTitle(this.haH.getPageContext().getString(d.j.my_mark));
        this.eDp.showBottomLine();
        this.haC = (TextView) this.eDp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.haH).findViewById(d.g.right_textview);
        this.haC.setText(d.j.edit);
        this.haC.setOnClickListener(this.haH);
        View bottomLine = this.eDp.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.haH.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.haH.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.haH.getResources().getColor(d.C0277d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eDp.showBottomLine();
        this.eDp.onChangeSkinType(this.haH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bFb() {
        return this.haC;
    }

    @SuppressLint({"ResourceAsColor"})
    public void mx(boolean z) {
        int i = -1;
        if (this.haF instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.haF;
            if (!collectFragment.Wa()) {
                z = false;
            }
            my(collectFragment.Wa());
            i = collectFragment.getType();
        }
        this.haI = z;
        this.haC.setText(this.haI ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.c(this.haC, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        } else {
            al.c(this.haC, this.haI ? d.C0277d.cp_link_tip_a : d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.haI);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bFc() {
        return this.haI;
    }

    public void am(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.haD.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.di(this.haH.getPageContext().getPageActivity()));
                }
            }
            this.haD.gY(0);
            this.haD.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.haD.getFragmentTabWidget().setVisibility(8);
            }
            vJ(0);
        }
    }

    private int getTabCount() {
        return v.S(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vJ(int i) {
        FragmentTabHost.b ha = this.haD.ha(i);
        this.haE = ha.mType;
        this.haF = ha.bHW;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c anK = bVar.anK();
        if (anK != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bHW = anK.cod;
            bVar2.mType = anK.type;
            fragmentTabIndicator.setText(anK.bOe);
            fragmentTabIndicator.setTextSize(0, this.haH.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0277d.s_actionbar_text_color);
            fragmentTabIndicator.ij(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bHV = fragmentTabIndicator;
            bVar2.bHX = bVar;
            this.haD.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.haD.onChangeSkinType(i);
        if (this.haD.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.haD.getTabWrapper().setVisibility(8);
            } else {
                this.haD.getTabWrapper().setVisibility(0);
            }
        }
        al.c(this.haC, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        this.eDp.onChangeSkinType(this.haH.getPageContext(), i);
        this.haG.onChangeSkinType(this.haH.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void my(boolean z) {
        this.haC.setEnabled(z);
        if (!z) {
            this.haC.setText(d.j.edit);
            al.c(this.haC, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        }
    }
}
