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
/* loaded from: classes18.dex */
public class a {
    private final NavigationBar hvV;
    private final FragmentTabHost kjA;
    private Fragment kjC;
    private final NoNetworkView kjD;
    private CollectTabActivity kjE;
    private final TextView kjz;
    private List mTabDataList;
    private int kjB = -1;
    private boolean kjF = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Di(i);
            a.this.rW(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cRF() {
        return this.kjB;
    }

    public Fragment cRG() {
        return this.kjC;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.kjE = collectTabActivity;
        this.kjA = (FragmentTabHost) this.kjE.findViewById(R.id.tab_host);
        this.kjA.setup(this.kjE.getSupportFragmentManager());
        this.kjA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hvV = (NavigationBar) this.kjE.findViewById(R.id.navigation_bar);
        this.kjD = (NoNetworkView) this.kjE.findViewById(R.id.view_no_network);
        this.hvV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hvV.setCenterTextTitle(this.kjE.getPageContext().getString(R.string.my_mark));
        this.kjz = (TextView) this.hvV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.kjE).findViewById(R.id.right_textview);
        this.kjz.setText(R.string.edit);
        this.kjz.setOnClickListener(this.kjE);
        this.hvV.onChangeSkinType(this.kjE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cRH() {
        return this.kjz;
    }

    @SuppressLint({"ResourceAsColor"})
    public void rW(boolean z) {
        int i = -1;
        if (this.kjC instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.kjC;
            if (!collectFragment.bbI()) {
                z = false;
            }
            rX(collectFragment.bbI());
            i = collectFragment.getType();
        }
        this.kjF = z;
        this.kjz.setText(this.kjF ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.kjz, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.kjz, this.kjF ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.kjF);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cRI() {
        return this.kjF;
    }

    public void aP(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.kjA.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.kjE.getPageContext().getPageActivity()));
                }
            }
            this.kjA.initViewPager(0);
            this.kjA.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.kjA.getFragmentTabWidget().setVisibility(8);
            }
            Di(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di(int i) {
        FragmentTabHost.b nL = this.kjA.nL(i);
        this.kjB = nL.mType;
        this.kjC = nL.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.kjE.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eiD = fragmentTabIndicator;
            bVar2.eiE = bVar;
            this.kjA.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.kjA.onChangeSkinType(i);
        if (this.kjA.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.kjA.getTabWrapper().setVisibility(8);
            } else {
                this.kjA.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.kjz, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.hvV.onChangeSkinType(this.kjE.getPageContext(), i);
        this.kjD.onChangeSkinType(this.kjE.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void rX(boolean z) {
        this.kjz.setEnabled(z);
        if (!z) {
            this.kjz.setText(R.string.edit);
            ap.setNavbarTitleColor(this.kjz, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
