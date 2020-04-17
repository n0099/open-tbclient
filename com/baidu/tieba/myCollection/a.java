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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private final NavigationBar gBE;
    private final TextView jdZ;
    private final FragmentTabHost jea;
    private Fragment jec;
    private final NoNetworkView jed;
    private CollectTabActivity jee;
    private List mTabDataList;
    private int jeb = -1;
    private boolean jef = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.yU(i);
            a.this.qe(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cst() {
        return this.jeb;
    }

    public Fragment csu() {
        return this.jec;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.jee = collectTabActivity;
        this.jea = (FragmentTabHost) this.jee.findViewById(R.id.tab_host);
        this.jea.setup(this.jee.getSupportFragmentManager());
        this.jea.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gBE = (NavigationBar) this.jee.findViewById(R.id.navigation_bar);
        this.jed = (NoNetworkView) this.jee.findViewById(R.id.view_no_network);
        this.gBE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gBE.setCenterTextTitle(this.jee.getPageContext().getString(R.string.my_mark));
        this.jdZ = (TextView) this.gBE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.jee).findViewById(R.id.right_textview);
        this.jdZ.setText(R.string.edit);
        this.jdZ.setOnClickListener(this.jee);
        this.gBE.onChangeSkinType(this.jee.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView csv() {
        return this.jdZ;
    }

    @SuppressLint({"ResourceAsColor"})
    public void qe(boolean z) {
        int i = -1;
        if (this.jec instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.jec;
            if (!collectFragment.aIa()) {
                z = false;
            }
            qf(collectFragment.aIa());
            i = collectFragment.getType();
        }
        this.jef = z;
        this.jdZ.setText(this.jef ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.jdZ, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.jdZ, this.jef ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.jef);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean csw() {
        return this.jef;
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.jea.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.jee.getPageContext().getPageActivity()));
                }
            }
            this.jea.initViewPager(0);
            this.jea.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.jea.getFragmentTabWidget().setVisibility(8);
            }
            yU(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yU(int i) {
        FragmentTabHost.b kv = this.jea.kv(i);
        this.jeb = kv.mType;
        this.jec = kv.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.jee.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.dxF = fragmentTabIndicator;
            bVar2.dxG = bVar;
            this.jea.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.jea.onChangeSkinType(i);
        if (this.jea.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.jea.getTabWrapper().setVisibility(8);
            } else {
                this.jea.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.jdZ, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.gBE.onChangeSkinType(this.jee.getPageContext(), i);
        this.jed.onChangeSkinType(this.jee.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qf(boolean z) {
        this.jdZ.setEnabled(z);
        if (!z) {
            this.jdZ.setText(R.string.edit);
            am.setNavbarTitleColor(this.jdZ, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
