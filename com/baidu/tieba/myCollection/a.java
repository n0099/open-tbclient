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
    private final NavigationBar eSS;
    private final TextView hrK;
    private final FragmentTabHost hrL;
    private Fragment hrN;
    private final NoNetworkView hrO;
    private CollectTabActivity hrP;
    private List mTabDataList;
    private int hrM = -1;
    private boolean hrQ = false;
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

    public int bMK() {
        return this.hrM;
    }

    public Fragment bML() {
        return this.hrN;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hrP = collectTabActivity;
        this.hrL = (FragmentTabHost) this.hrP.findViewById(R.id.tab_host);
        this.hrL.setup(this.hrP.getSupportFragmentManager());
        this.hrL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eSS = (NavigationBar) this.hrP.findViewById(R.id.navigation_bar);
        this.hrO = (NoNetworkView) this.hrP.findViewById(R.id.view_no_network);
        this.eSS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSS.setCenterTextTitle(this.hrP.getPageContext().getString(R.string.my_mark));
        this.eSS.showBottomLine();
        this.hrK = (TextView) this.eSS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hrP).findViewById(R.id.right_textview);
        this.hrK.setText(R.string.edit);
        this.hrK.setOnClickListener(this.hrP);
        View bottomLine = this.eSS.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hrP.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hrP.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hrP.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eSS.showBottomLine();
        this.eSS.onChangeSkinType(this.hrP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bMM() {
        return this.hrK;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nm(boolean z) {
        int i = -1;
        if (this.hrN instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hrN;
            if (!collectFragment.aaD()) {
                z = false;
            }
            nn(collectFragment.aaD());
            i = collectFragment.getType();
        }
        this.hrQ = z;
        this.hrK.setText(this.hrQ ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.e(this.hrK, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            al.e(this.hrK, this.hrQ ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hrQ);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bMN() {
        return this.hrQ;
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hrL.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cO(this.hrP.getPageContext().getPageActivity()));
                }
            }
            this.hrL.hL(0);
            this.hrL.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hrL.getFragmentTabWidget().setVisibility(8);
            }
            wL(0);
        }
    }

    private int getTabCount() {
        return v.Z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        FragmentTabHost.b hN = this.hrL.hN(i);
        this.hrM = hN.mType;
        this.hrN = hN.bPJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c asK = bVar.asK();
        if (asK != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bPJ = asK.cwn;
            bVar2.mType = asK.type;
            fragmentTabIndicator.setText(asK.bVV);
            fragmentTabIndicator.setTextSize(0, this.hrP.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bPI = fragmentTabIndicator;
            bVar2.bPK = bVar;
            this.hrL.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hrL.onChangeSkinType(i);
        if (this.hrL.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hrL.getTabWrapper().setVisibility(8);
            } else {
                this.hrL.getTabWrapper().setVisibility(0);
            }
        }
        al.e(this.hrK, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.eSS.onChangeSkinType(this.hrP.getPageContext(), i);
        this.hrO.onChangeSkinType(this.hrP.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nn(boolean z) {
        this.hrK.setEnabled(z);
        if (!z) {
            this.hrK.setText(R.string.edit);
            al.e(this.hrK, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
