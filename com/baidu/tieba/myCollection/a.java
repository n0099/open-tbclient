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
    private final NavigationBar eqd;
    private final NoNetworkView fJA;
    private CollectTabActivity fJB;
    private final TextView fJw;
    private final FragmentTabHost fJx;
    private Fragment fJz;
    private List mTabDataList;
    private int fJy = -1;
    private boolean fJC = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.rY(i);
            a.this.jW(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bdW() {
        return this.fJy;
    }

    public Fragment bdX() {
        return this.fJz;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.fJB = collectTabActivity;
        this.fJx = (FragmentTabHost) this.fJB.findViewById(e.g.tab_host);
        this.fJx.setup(this.fJB.getSupportFragmentManager());
        this.fJx.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqd = (NavigationBar) this.fJB.findViewById(e.g.navigation_bar);
        this.fJA = (NoNetworkView) this.fJB.findViewById(e.g.view_no_network);
        this.eqd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eqd.setCenterTextTitle(this.fJB.getPageContext().getString(e.j.my_mark));
        this.eqd.showBottomLine();
        this.fJw = (TextView) this.eqd.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, this.fJB).findViewById(e.g.right_textview);
        this.fJw.setText(e.j.edit);
        this.fJw.setOnClickListener(this.fJB);
        View bottomLine = this.eqd.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.fJB.getResources().getDimension(e.C0210e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.fJB.getResources().getDimension(e.C0210e.ds1));
            }
            bottomLine.setBackgroundColor(this.fJB.getResources().getColor(e.d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eqd.showBottomLine();
        this.eqd.onChangeSkinType(this.fJB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bdY() {
        return this.fJw;
    }

    @SuppressLint({"ResourceAsColor"})
    public void jW(boolean z) {
        int i = -1;
        if (this.fJz instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.fJz;
            if (!collectFragment.xg()) {
                z = false;
            }
            jX(collectFragment.xg());
            i = collectFragment.getType();
        }
        this.fJC = z;
        this.fJw.setText(this.fJC ? e.j.done : e.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.fJw, e.d.navi_op_text, e.d.navi_op_text_skin);
        } else {
            al.b(this.fJw, this.fJC ? e.d.cp_link_tip_a : e.d.navi_op_text, e.d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.fJC);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bdZ() {
        return this.fJC;
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.fJx.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bR(this.fJB.getPageContext().getPageActivity()));
                }
            }
            this.fJx.dw(0);
            this.fJx.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.fJx.getFragmentTabWidget().setVisibility(8);
            }
            rY(0);
        }
    }

    private int getTabCount() {
        return v.H(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(int i) {
        FragmentTabHost.b dy = this.fJx.dy(i);
        this.fJy = dy.mType;
        this.fJz = dy.azz;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c NQ = bVar.NQ();
        if (NQ != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.azz = NQ.bdN;
            bVar2.mType = NQ.type;
            fragmentTabIndicator.setText(NQ.aFs);
            fragmentTabIndicator.setTextSize(0, this.fJB.getResources().getDimension(e.C0210e.fontsize32));
            fragmentTabIndicator.setTextColorResId(e.d.s_actionbar_text_color);
            fragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.azy = fragmentTabIndicator;
            bVar2.azA = bVar;
            this.fJx.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.fJx.onChangeSkinType(i);
        if (this.fJx.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.fJx.getTabWrapper().setVisibility(8);
            } else {
                this.fJx.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.fJw, e.d.navi_op_text, e.d.navi_op_text_skin);
        this.eqd.onChangeSkinType(this.fJB.getPageContext(), i);
        this.fJA.onChangeSkinType(this.fJB.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void jX(boolean z) {
        this.fJw.setEnabled(z);
        if (!z) {
            this.fJw.setText(e.j.edit);
            al.b(this.fJw, e.d.navi_op_text, e.d.navi_op_text_skin);
        }
    }
}
