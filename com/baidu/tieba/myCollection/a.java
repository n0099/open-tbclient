package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private final NavigationBar iwh;
    private final TextView lnA;
    private final FragmentTabHost lnB;
    private Fragment lnD;
    private final NoNetworkView lnE;
    private CollectTabActivity lnF;
    private List mTabDataList;
    private int lnC = -1;
    private boolean lnG = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Gi(i);
            a.this.tS(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int djo() {
        return this.lnC;
    }

    public Fragment djp() {
        return this.lnD;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lnF = collectTabActivity;
        this.lnB = (FragmentTabHost) this.lnF.findViewById(R.id.tab_host);
        this.lnB.setup(this.lnF.getSupportFragmentManager());
        this.lnB.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iwh = (NavigationBar) this.lnF.findViewById(R.id.navigation_bar);
        this.lnE = (NoNetworkView) this.lnF.findViewById(R.id.view_no_network);
        this.iwh.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iwh.setCenterTextTitle(this.lnF.getPageContext().getString(R.string.my_mark));
        this.lnA = (TextView) this.iwh.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lnF).findViewById(R.id.right_textview);
        this.lnA.setText(R.string.edit);
        this.lnA.setOnClickListener(this.lnF);
        this.iwh.onChangeSkinType(this.lnF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView djq() {
        return this.lnA;
    }

    @SuppressLint({"ResourceAsColor"})
    public void tS(boolean z) {
        int i = -1;
        if (this.lnD instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lnD;
            if (!collectFragment.blR()) {
                z = false;
            }
            tT(collectFragment.blR());
            i = collectFragment.getType();
        }
        this.lnG = z;
        this.lnA.setText(this.lnG ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.lnA, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.lnA, this.lnG ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lnG);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean djr() {
        return this.lnG;
    }

    public void aX(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lnB.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lnF.getPageContext().getPageActivity()));
                }
            }
            this.lnB.initViewPager(0);
            this.lnB.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lnB.getFragmentTabWidget().setVisibility(8);
            }
            Gi(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi(int i) {
        FragmentTabHost.b pL = this.lnB.pL(i);
        this.lnC = pL.mType;
        this.lnD = pL.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lnF.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eRD = fragmentTabIndicator;
            bVar2.eRE = bVar;
            this.lnB.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lnB.onChangeSkinType(i);
        if (this.lnB.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lnB.getTabWrapper().setVisibility(8);
            } else {
                this.lnB.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.lnA, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iwh.onChangeSkinType(this.lnF.getPageContext(), i);
        this.lnE.onChangeSkinType(this.lnF.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void tT(boolean z) {
        this.lnA.setEnabled(z);
        if (!z) {
            this.lnA.setText(R.string.edit);
            ap.setNavbarTitleColor(this.lnA, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
