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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private final NavigationBar eSR;
    private final TextView hrH;
    private final FragmentTabHost hrI;
    private Fragment hrK;
    private final NoNetworkView hrL;
    private CollectTabActivity hrM;
    private List mTabDataList;
    private int hrJ = -1;
    private boolean hrN = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.wL(i);
            a.this.nm(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bMH() {
        return this.hrJ;
    }

    public Fragment bMI() {
        return this.hrK;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hrM = collectTabActivity;
        this.hrI = (FragmentTabHost) this.hrM.findViewById(R.id.tab_host);
        this.hrI.setup(this.hrM.getSupportFragmentManager());
        this.hrI.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eSR = (NavigationBar) this.hrM.findViewById(R.id.navigation_bar);
        this.hrL = (NoNetworkView) this.hrM.findViewById(R.id.view_no_network);
        this.eSR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSR.setCenterTextTitle(this.hrM.getPageContext().getString(R.string.my_mark));
        this.eSR.showBottomLine();
        this.hrH = (TextView) this.eSR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hrM).findViewById(R.id.right_textview);
        this.hrH.setText(R.string.edit);
        this.hrH.setOnClickListener(this.hrM);
        View bottomLine = this.eSR.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hrM.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hrM.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hrM.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eSR.showBottomLine();
        this.eSR.onChangeSkinType(this.hrM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bMJ() {
        return this.hrH;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nm(boolean z) {
        int i = -1;
        if (this.hrK instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hrK;
            if (!collectFragment.aaD()) {
                z = false;
            }
            nn(collectFragment.aaD());
            i = collectFragment.getType();
        }
        this.hrN = z;
        this.hrH.setText(this.hrN ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.e(this.hrH, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            al.e(this.hrH, this.hrN ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hrN);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bMK() {
        return this.hrN;
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hrI.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cO(this.hrM.getPageContext().getPageActivity()));
                }
            }
            this.hrI.hL(0);
            this.hrI.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hrI.getFragmentTabWidget().setVisibility(8);
            }
            wL(0);
        }
    }

    private int getTabCount() {
        return v.Z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        FragmentTabHost.b hN = this.hrI.hN(i);
        this.hrJ = hN.mType;
        this.hrK = hN.bPJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c asK = bVar.asK();
        if (asK != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bPJ = asK.cwn;
            bVar2.mType = asK.type;
            fragmentTabIndicator.setText(asK.bVV);
            fragmentTabIndicator.setTextSize(0, this.hrM.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bPI = fragmentTabIndicator;
            bVar2.bPK = bVar;
            this.hrI.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hrI.onChangeSkinType(i);
        if (this.hrI.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hrI.getTabWrapper().setVisibility(8);
            } else {
                this.hrI.getTabWrapper().setVisibility(0);
            }
        }
        al.e(this.hrH, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.eSR.onChangeSkinType(this.hrM.getPageContext(), i);
        this.hrL.onChangeSkinType(this.hrM.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nn(boolean z) {
        this.hrH.setEnabled(z);
        if (!z) {
            this.hrH.setText(R.string.edit);
            al.e(this.hrH, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
