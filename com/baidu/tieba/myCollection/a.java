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
    private final NavigationBar gBK;
    private final TextView jed;
    private final FragmentTabHost jee;
    private Fragment jeg;
    private final NoNetworkView jeh;
    private CollectTabActivity jei;
    private List mTabDataList;
    private int jef = -1;
    private boolean jej = false;
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

    public int csr() {
        return this.jef;
    }

    public Fragment css() {
        return this.jeg;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.jei = collectTabActivity;
        this.jee = (FragmentTabHost) this.jei.findViewById(R.id.tab_host);
        this.jee.setup(this.jei.getSupportFragmentManager());
        this.jee.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gBK = (NavigationBar) this.jei.findViewById(R.id.navigation_bar);
        this.jeh = (NoNetworkView) this.jei.findViewById(R.id.view_no_network);
        this.gBK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gBK.setCenterTextTitle(this.jei.getPageContext().getString(R.string.my_mark));
        this.jed = (TextView) this.gBK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.jei).findViewById(R.id.right_textview);
        this.jed.setText(R.string.edit);
        this.jed.setOnClickListener(this.jei);
        this.gBK.onChangeSkinType(this.jei.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cst() {
        return this.jed;
    }

    @SuppressLint({"ResourceAsColor"})
    public void qe(boolean z) {
        int i = -1;
        if (this.jeg instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.jeg;
            if (!collectFragment.aHY()) {
                z = false;
            }
            qf(collectFragment.aHY());
            i = collectFragment.getType();
        }
        this.jej = z;
        this.jed.setText(this.jej ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.jed, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.jed, this.jej ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.jej);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean csu() {
        return this.jej;
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.jee.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.jei.getPageContext().getPageActivity()));
                }
            }
            this.jee.initViewPager(0);
            this.jee.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.jee.getFragmentTabWidget().setVisibility(8);
            }
            yU(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yU(int i) {
        FragmentTabHost.b kv = this.jee.kv(i);
        this.jef = kv.mType;
        this.jeg = kv.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.jei.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.dxJ = fragmentTabIndicator;
            bVar2.dxK = bVar;
            this.jee.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.jee.onChangeSkinType(i);
        if (this.jee.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.jee.getTabWrapper().setVisibility(8);
            } else {
                this.jee.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.jed, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.gBK.onChangeSkinType(this.jei.getPageContext(), i);
        this.jeh.onChangeSkinType(this.jei.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qf(boolean z) {
        this.jed.setEnabled(z);
        if (!z) {
            this.jed.setText(R.string.edit);
            am.setNavbarTitleColor(this.jed, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
