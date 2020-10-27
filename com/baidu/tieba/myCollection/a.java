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
    private final NavigationBar ieC;
    private final TextView kTO;
    private final FragmentTabHost kTP;
    private Fragment kTR;
    private final NoNetworkView kTS;
    private CollectTabActivity kTT;
    private List mTabDataList;
    private int kTQ = -1;
    private boolean kTU = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.EI(i);
            a.this.te(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int dcd() {
        return this.kTQ;
    }

    public Fragment dce() {
        return this.kTR;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.kTT = collectTabActivity;
        this.kTP = (FragmentTabHost) this.kTT.findViewById(R.id.tab_host);
        this.kTP.setup(this.kTT.getSupportFragmentManager());
        this.kTP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ieC = (NavigationBar) this.kTT.findViewById(R.id.navigation_bar);
        this.kTS = (NoNetworkView) this.kTT.findViewById(R.id.view_no_network);
        this.ieC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ieC.setCenterTextTitle(this.kTT.getPageContext().getString(R.string.my_mark));
        this.kTO = (TextView) this.ieC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.kTT).findViewById(R.id.right_textview);
        this.kTO.setText(R.string.edit);
        this.kTO.setOnClickListener(this.kTT);
        this.ieC.onChangeSkinType(this.kTT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView dcf() {
        return this.kTO;
    }

    @SuppressLint({"ResourceAsColor"})
    public void te(boolean z) {
        int i = -1;
        if (this.kTR instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.kTR;
            if (!collectFragment.bhd()) {
                z = false;
            }
            tf(collectFragment.bhd());
            i = collectFragment.getType();
        }
        this.kTU = z;
        this.kTO.setText(this.kTU ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.kTO, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.kTO, this.kTU ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.kTU);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean dcg() {
        return this.kTU;
    }

    public void aU(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.kTP.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.kTT.getPageContext().getPageActivity()));
                }
            }
            this.kTP.initViewPager(0);
            this.kTP.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.kTP.getFragmentTabWidget().setVisibility(8);
            }
            EI(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EI(int i) {
        FragmentTabHost.b oF = this.kTP.oF(i);
        this.kTQ = oF.mType;
        this.kTR = oF.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.kTT.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eFD = fragmentTabIndicator;
            bVar2.eFE = bVar;
            this.kTP.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.kTP.onChangeSkinType(i);
        if (this.kTP.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.kTP.getTabWrapper().setVisibility(8);
            } else {
                this.kTP.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.kTO, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.ieC.onChangeSkinType(this.kTT.getPageContext(), i);
        this.kTS.onChangeSkinType(this.kTT.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void tf(boolean z) {
        this.kTO.setEnabled(z);
        if (!z) {
            this.kTO.setText(R.string.edit);
            ap.setNavbarTitleColor(this.kTO, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
