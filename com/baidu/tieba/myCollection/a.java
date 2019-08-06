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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private final NavigationBar eYf;
    private final TextView hyP;
    private final FragmentTabHost hyQ;
    private Fragment hyS;
    private final NoNetworkView hyT;
    private CollectTabActivity hyU;
    private List mTabDataList;
    private int hyR = -1;
    private boolean hyV = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.xq(i);
            a.this.nB(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bPH() {
        return this.hyR;
    }

    public Fragment bPI() {
        return this.hyS;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hyU = collectTabActivity;
        this.hyQ = (FragmentTabHost) this.hyU.findViewById(R.id.tab_host);
        this.hyQ.setup(this.hyU.getSupportFragmentManager());
        this.hyQ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eYf = (NavigationBar) this.hyU.findViewById(R.id.navigation_bar);
        this.hyT = (NoNetworkView) this.hyU.findViewById(R.id.view_no_network);
        this.eYf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eYf.setCenterTextTitle(this.hyU.getPageContext().getString(R.string.my_mark));
        this.eYf.showBottomLine();
        this.hyP = (TextView) this.eYf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hyU).findViewById(R.id.right_textview);
        this.hyP.setText(R.string.edit);
        this.hyP.setOnClickListener(this.hyU);
        View bottomLine = this.eYf.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hyU.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hyU.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hyU.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eYf.showBottomLine();
        this.eYf.onChangeSkinType(this.hyU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bPJ() {
        return this.hyP;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nB(boolean z) {
        int i = -1;
        if (this.hyS instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hyS;
            if (!collectFragment.abC()) {
                z = false;
            }
            nC(collectFragment.abC());
            i = collectFragment.getType();
        }
        this.hyV = z;
        this.hyP.setText(this.hyV ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.e(this.hyP, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.e(this.hyP, this.hyV ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hyV);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bPK() {
        return this.hyV;
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hyQ.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cP(this.hyU.getPageContext().getPageActivity()));
                }
            }
            this.hyQ.hR(0);
            this.hyQ.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hyQ.getFragmentTabWidget().setVisibility(8);
            }
            xq(0);
        }
    }

    private int getTabCount() {
        return v.Z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(int i) {
        FragmentTabHost.b hT = this.hyQ.hT(i);
        this.hyR = hT.mType;
        this.hyS = hT.bQQ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c atU = bVar.atU();
        if (atU != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bQQ = atU.cxK;
            bVar2.mType = atU.type;
            fragmentTabIndicator.setText(atU.bXe);
            fragmentTabIndicator.setTextSize(0, this.hyU.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.jd(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bQP = fragmentTabIndicator;
            bVar2.bQR = bVar;
            this.hyQ.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hyQ.onChangeSkinType(i);
        if (this.hyQ.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hyQ.getTabWrapper().setVisibility(8);
            } else {
                this.hyQ.getTabWrapper().setVisibility(0);
            }
        }
        am.e(this.hyP, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.eYf.onChangeSkinType(this.hyU.getPageContext(), i);
        this.hyT.onChangeSkinType(this.hyU.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nC(boolean z) {
        this.hyP.setEnabled(z);
        if (!z) {
            this.hyP.setText(R.string.edit);
            am.e(this.hyP, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
