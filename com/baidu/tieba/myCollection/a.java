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
    private final NavigationBar fVN;
    private final TextView isi;
    private final FragmentTabHost isj;
    private Fragment isl;
    private final NoNetworkView ism;
    private CollectTabActivity isn;
    private List mTabDataList;
    private int isk = -1;
    private boolean iso = false;
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

    public int chr() {
        return this.isk;
    }

    public Fragment chs() {
        return this.isl;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.isn = collectTabActivity;
        this.isj = (FragmentTabHost) this.isn.findViewById(R.id.tab_host);
        this.isj.setup(this.isn.getSupportFragmentManager());
        this.isj.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fVN = (NavigationBar) this.isn.findViewById(R.id.navigation_bar);
        this.ism = (NoNetworkView) this.isn.findViewById(R.id.view_no_network);
        this.fVN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fVN.setCenterTextTitle(this.isn.getPageContext().getString(R.string.my_mark));
        this.isi = (TextView) this.fVN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.isn).findViewById(R.id.right_textview);
        this.isi.setText(R.string.edit);
        this.isi.setOnClickListener(this.isn);
        this.fVN.onChangeSkinType(this.isn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cht() {
        return this.isi;
    }

    @SuppressLint({"ResourceAsColor"})
    public void oU(boolean z) {
        int i = -1;
        if (this.isl instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.isl;
            if (!collectFragment.azK()) {
                z = false;
            }
            oV(collectFragment.azK());
            i = collectFragment.getType();
        }
        this.iso = z;
        this.isi.setText(this.iso ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.isi, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.isi, this.iso ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.iso);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean chu() {
        return this.iso;
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.isj.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.isn.getPageContext().getPageActivity()));
                }
            }
            this.isj.initViewPager(0);
            this.isj.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.isj.getFragmentTabWidget().setVisibility(8);
            }
            yl(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        FragmentTabHost.b ko = this.isj.ko(i);
        this.isk = ko.mType;
        this.isl = ko.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.isn.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cYh = fragmentTabIndicator;
            bVar2.cYi = bVar;
            this.isj.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.isj.onChangeSkinType(i);
        if (this.isj.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.isj.getTabWrapper().setVisibility(8);
            } else {
                this.isj.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.isi, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fVN.onChangeSkinType(this.isn.getPageContext(), i);
        this.ism.onChangeSkinType(this.isn.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oV(boolean z) {
        this.isi.setEnabled(z);
        if (!z) {
            this.isi.setText(R.string.edit);
            am.setNavbarTitleColor(this.isi, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
