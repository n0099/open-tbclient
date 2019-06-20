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
    private final TextView hrL;
    private final FragmentTabHost hrM;
    private Fragment hrO;
    private final NoNetworkView hrP;
    private CollectTabActivity hrQ;
    private List mTabDataList;
    private int hrN = -1;
    private boolean hrR = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.wL(i);
            a.this.nn(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bML() {
        return this.hrN;
    }

    public Fragment bMM() {
        return this.hrO;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hrQ = collectTabActivity;
        this.hrM = (FragmentTabHost) this.hrQ.findViewById(R.id.tab_host);
        this.hrM.setup(this.hrQ.getSupportFragmentManager());
        this.hrM.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eSS = (NavigationBar) this.hrQ.findViewById(R.id.navigation_bar);
        this.hrP = (NoNetworkView) this.hrQ.findViewById(R.id.view_no_network);
        this.eSS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSS.setCenterTextTitle(this.hrQ.getPageContext().getString(R.string.my_mark));
        this.eSS.showBottomLine();
        this.hrL = (TextView) this.eSS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hrQ).findViewById(R.id.right_textview);
        this.hrL.setText(R.string.edit);
        this.hrL.setOnClickListener(this.hrQ);
        View bottomLine = this.eSS.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hrQ.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hrQ.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hrQ.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eSS.showBottomLine();
        this.eSS.onChangeSkinType(this.hrQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bMN() {
        return this.hrL;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nn(boolean z) {
        int i = -1;
        if (this.hrO instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hrO;
            if (!collectFragment.aaD()) {
                z = false;
            }
            no(collectFragment.aaD());
            i = collectFragment.getType();
        }
        this.hrR = z;
        this.hrL.setText(this.hrR ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.e(this.hrL, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            al.e(this.hrL, this.hrR ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hrR);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bMO() {
        return this.hrR;
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hrM.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cO(this.hrQ.getPageContext().getPageActivity()));
                }
            }
            this.hrM.hL(0);
            this.hrM.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hrM.getFragmentTabWidget().setVisibility(8);
            }
            wL(0);
        }
    }

    private int getTabCount() {
        return v.Z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        FragmentTabHost.b hN = this.hrM.hN(i);
        this.hrN = hN.mType;
        this.hrO = hN.bPK;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c asK = bVar.asK();
        if (asK != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bPK = asK.cwo;
            bVar2.mType = asK.type;
            fragmentTabIndicator.setText(asK.bVW);
            fragmentTabIndicator.setTextSize(0, this.hrQ.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bPJ = fragmentTabIndicator;
            bVar2.bPL = bVar;
            this.hrM.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hrM.onChangeSkinType(i);
        if (this.hrM.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hrM.getTabWrapper().setVisibility(8);
            } else {
                this.hrM.getTabWrapper().setVisibility(0);
            }
        }
        al.e(this.hrL, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.eSS.onChangeSkinType(this.hrQ.getPageContext(), i);
        this.hrP.onChangeSkinType(this.hrQ.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void no(boolean z) {
        this.hrL.setEnabled(z);
        if (!z) {
            this.hrL.setText(R.string.edit);
            al.e(this.hrL, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
