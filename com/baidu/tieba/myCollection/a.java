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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private final NavigationBar hiX;
    private final TextView jUd;
    private final FragmentTabHost jUe;
    private Fragment jUg;
    private final NoNetworkView jUh;
    private CollectTabActivity jUi;
    private List mTabDataList;
    private int jUf = -1;
    private boolean jUj = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.AP(i);
            a.this.rq(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cGQ() {
        return this.jUf;
    }

    public Fragment cGR() {
        return this.jUg;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.jUi = collectTabActivity;
        this.jUe = (FragmentTabHost) this.jUi.findViewById(R.id.tab_host);
        this.jUe.setup(this.jUi.getSupportFragmentManager());
        this.jUe.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hiX = (NavigationBar) this.jUi.findViewById(R.id.navigation_bar);
        this.jUh = (NoNetworkView) this.jUi.findViewById(R.id.view_no_network);
        this.hiX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hiX.setCenterTextTitle(this.jUi.getPageContext().getString(R.string.my_mark));
        this.jUd = (TextView) this.hiX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.jUi).findViewById(R.id.right_textview);
        this.jUd.setText(R.string.edit);
        this.jUd.setOnClickListener(this.jUi);
        this.hiX.onChangeSkinType(this.jUi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cGS() {
        return this.jUd;
    }

    @SuppressLint({"ResourceAsColor"})
    public void rq(boolean z) {
        int i = -1;
        if (this.jUg instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.jUg;
            if (!collectFragment.aTr()) {
                z = false;
            }
            rr(collectFragment.aTr());
            i = collectFragment.getType();
        }
        this.jUj = z;
        this.jUd.setText(this.jUj ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ao.setNavbarTitleColor(this.jUd, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ao.setNavbarTitleColor(this.jUd, this.jUj ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.jUj);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cGT() {
        return this.jUj;
    }

    public void aJ(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.jUe.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.jUi.getPageContext().getPageActivity()));
                }
            }
            this.jUe.initViewPager(0);
            this.jUe.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.jUe.getFragmentTabWidget().setVisibility(8);
            }
            AP(0);
        }
    }

    private int getTabCount() {
        return x.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP(int i) {
        FragmentTabHost.b lF = this.jUe.lF(i);
        this.jUf = lF.mType;
        this.jUg = lF.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.jUi.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.dYX = fragmentTabIndicator;
            bVar2.dYY = bVar;
            this.jUe.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.jUe.onChangeSkinType(i);
        if (this.jUe.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.jUe.getTabWrapper().setVisibility(8);
            } else {
                this.jUe.getTabWrapper().setVisibility(0);
            }
        }
        ao.setNavbarTitleColor(this.jUd, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.hiX.onChangeSkinType(this.jUi.getPageContext(), i);
        this.jUh.onChangeSkinType(this.jUi.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void rr(boolean z) {
        this.jUd.setEnabled(z);
        if (!z) {
            this.jUd.setText(R.string.edit);
            ao.setNavbarTitleColor(this.jUd, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
