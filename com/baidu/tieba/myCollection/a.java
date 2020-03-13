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
    private final NavigationBar fWa;
    private final TextView isu;
    private final FragmentTabHost isv;
    private Fragment isx;
    private final NoNetworkView isy;
    private CollectTabActivity isz;
    private List mTabDataList;
    private int isw = -1;
    private boolean isA = false;
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

    public int chs() {
        return this.isw;
    }

    public Fragment cht() {
        return this.isx;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.isz = collectTabActivity;
        this.isv = (FragmentTabHost) this.isz.findViewById(R.id.tab_host);
        this.isv.setup(this.isz.getSupportFragmentManager());
        this.isv.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fWa = (NavigationBar) this.isz.findViewById(R.id.navigation_bar);
        this.isy = (NoNetworkView) this.isz.findViewById(R.id.view_no_network);
        this.fWa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fWa.setCenterTextTitle(this.isz.getPageContext().getString(R.string.my_mark));
        this.isu = (TextView) this.fWa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.isz).findViewById(R.id.right_textview);
        this.isu.setText(R.string.edit);
        this.isu.setOnClickListener(this.isz);
        this.fWa.onChangeSkinType(this.isz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView chu() {
        return this.isu;
    }

    @SuppressLint({"ResourceAsColor"})
    public void oU(boolean z) {
        int i = -1;
        if (this.isx instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.isx;
            if (!collectFragment.azK()) {
                z = false;
            }
            oV(collectFragment.azK());
            i = collectFragment.getType();
        }
        this.isA = z;
        this.isu.setText(this.isA ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.isu, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.isu, this.isA ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.isA);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean chv() {
        return this.isA;
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.isv.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.isz.getPageContext().getPageActivity()));
                }
            }
            this.isv.initViewPager(0);
            this.isv.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.isv.getFragmentTabWidget().setVisibility(8);
            }
            yl(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        FragmentTabHost.b ko = this.isv.ko(i);
        this.isw = ko.mType;
        this.isx = ko.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.isz.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cYi = fragmentTabIndicator;
            bVar2.cYj = bVar;
            this.isv.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.isv.onChangeSkinType(i);
        if (this.isv.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.isv.getTabWrapper().setVisibility(8);
            } else {
                this.isv.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.isu, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fWa.onChangeSkinType(this.isz.getPageContext(), i);
        this.isy.onChangeSkinType(this.isz.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oV(boolean z) {
        this.isu.setEnabled(z);
        if (!z) {
            this.isu.setText(R.string.edit);
            am.setNavbarTitleColor(this.isu, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
