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
    private final NavigationBar fVL;
    private final TextView isg;
    private final FragmentTabHost ish;
    private Fragment isj;
    private final NoNetworkView isk;
    private CollectTabActivity isl;
    private List mTabDataList;
    private int isi = -1;
    private boolean ism = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.yl(i);
            a.this.oU(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int chp() {
        return this.isi;
    }

    public Fragment chq() {
        return this.isj;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.isl = collectTabActivity;
        this.ish = (FragmentTabHost) this.isl.findViewById(R.id.tab_host);
        this.ish.setup(this.isl.getSupportFragmentManager());
        this.ish.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fVL = (NavigationBar) this.isl.findViewById(R.id.navigation_bar);
        this.isk = (NoNetworkView) this.isl.findViewById(R.id.view_no_network);
        this.fVL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fVL.setCenterTextTitle(this.isl.getPageContext().getString(R.string.my_mark));
        this.isg = (TextView) this.fVL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.isl).findViewById(R.id.right_textview);
        this.isg.setText(R.string.edit);
        this.isg.setOnClickListener(this.isl);
        this.fVL.onChangeSkinType(this.isl.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView chr() {
        return this.isg;
    }

    @SuppressLint({"ResourceAsColor"})
    public void oU(boolean z) {
        int i = -1;
        if (this.isj instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.isj;
            if (!collectFragment.azI()) {
                z = false;
            }
            oV(collectFragment.azI());
            i = collectFragment.getType();
        }
        this.ism = z;
        this.isg.setText(this.ism ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.isg, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.isg, this.ism ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.ism);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean chs() {
        return this.ism;
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.ish.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.isl.getPageContext().getPageActivity()));
                }
            }
            this.ish.initViewPager(0);
            this.ish.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.ish.getFragmentTabWidget().setVisibility(8);
            }
            yl(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        FragmentTabHost.b ko = this.ish.ko(i);
        this.isi = ko.mType;
        this.isj = ko.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.isl.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cYg = fragmentTabIndicator;
            bVar2.cYh = bVar;
            this.ish.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.ish.onChangeSkinType(i);
        if (this.ish.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.ish.getTabWrapper().setVisibility(8);
            } else {
                this.ish.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.isg, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fVL.onChangeSkinType(this.isl.getPageContext(), i);
        this.isk.onChangeSkinType(this.isl.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oV(boolean z) {
        this.isg.setEnabled(z);
        if (!z) {
            this.isg.setText(R.string.edit);
            am.setNavbarTitleColor(this.isg, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
