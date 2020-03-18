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
    private final NavigationBar fWI;
    private final TextView itU;
    private final FragmentTabHost itV;
    private Fragment itX;
    private final NoNetworkView itY;
    private CollectTabActivity itZ;
    private List mTabDataList;
    private int itW = -1;
    private boolean iua = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.yt(i);
            a.this.pa(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int chM() {
        return this.itW;
    }

    public Fragment chN() {
        return this.itX;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.itZ = collectTabActivity;
        this.itV = (FragmentTabHost) this.itZ.findViewById(R.id.tab_host);
        this.itV.setup(this.itZ.getSupportFragmentManager());
        this.itV.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fWI = (NavigationBar) this.itZ.findViewById(R.id.navigation_bar);
        this.itY = (NoNetworkView) this.itZ.findViewById(R.id.view_no_network);
        this.fWI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fWI.setCenterTextTitle(this.itZ.getPageContext().getString(R.string.my_mark));
        this.itU = (TextView) this.fWI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.itZ).findViewById(R.id.right_textview);
        this.itU.setText(R.string.edit);
        this.itU.setOnClickListener(this.itZ);
        this.fWI.onChangeSkinType(this.itZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView chO() {
        return this.itU;
    }

    @SuppressLint({"ResourceAsColor"})
    public void pa(boolean z) {
        int i = -1;
        if (this.itX instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.itX;
            if (!collectFragment.azN()) {
                z = false;
            }
            pb(collectFragment.azN());
            i = collectFragment.getType();
        }
        this.iua = z;
        this.itU.setText(this.iua ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.itU, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.itU, this.iua ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.iua);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean chP() {
        return this.iua;
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.itV.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.itZ.getPageContext().getPageActivity()));
                }
            }
            this.itV.initViewPager(0);
            this.itV.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.itV.getFragmentTabWidget().setVisibility(8);
            }
            yt(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(int i) {
        FragmentTabHost.b ko = this.itV.ko(i);
        this.itW = ko.mType;
        this.itX = ko.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.itZ.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cYv = fragmentTabIndicator;
            bVar2.cYw = bVar;
            this.itV.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.itV.onChangeSkinType(i);
        if (this.itV.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.itV.getTabWrapper().setVisibility(8);
            } else {
                this.itV.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.itU, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fWI.onChangeSkinType(this.itZ.getPageContext(), i);
        this.itY.onChangeSkinType(this.itZ.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void pb(boolean z) {
        this.itU.setEnabled(z);
        if (!z) {
            this.itU.setText(R.string.edit);
            am.setNavbarTitleColor(this.itU, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
