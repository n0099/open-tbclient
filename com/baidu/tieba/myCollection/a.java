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
    private final NavigationBar gQt;
    private final TextView jtg;
    private final FragmentTabHost jth;
    private Fragment jtj;
    private final NoNetworkView jtk;
    private CollectTabActivity jtl;
    private List mTabDataList;
    private int jti = -1;
    private boolean jtm = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.zC(i);
            a.this.qB(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cyT() {
        return this.jti;
    }

    public Fragment cyU() {
        return this.jtj;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.jtl = collectTabActivity;
        this.jth = (FragmentTabHost) this.jtl.findViewById(R.id.tab_host);
        this.jth.setup(this.jtl.getSupportFragmentManager());
        this.jth.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gQt = (NavigationBar) this.jtl.findViewById(R.id.navigation_bar);
        this.jtk = (NoNetworkView) this.jtl.findViewById(R.id.view_no_network);
        this.gQt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gQt.setCenterTextTitle(this.jtl.getPageContext().getString(R.string.my_mark));
        this.jtg = (TextView) this.gQt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.jtl).findViewById(R.id.right_textview);
        this.jtg.setText(R.string.edit);
        this.jtg.setOnClickListener(this.jtl);
        this.gQt.onChangeSkinType(this.jtl.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cyV() {
        return this.jtg;
    }

    @SuppressLint({"ResourceAsColor"})
    public void qB(boolean z) {
        int i = -1;
        if (this.jtj instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.jtj;
            if (!collectFragment.aNM()) {
                z = false;
            }
            qC(collectFragment.aNM());
            i = collectFragment.getType();
        }
        this.jtm = z;
        this.jtg.setText(this.jtm ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.jtg, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.jtg, this.jtm ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.jtm);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cyW() {
        return this.jtm;
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.jth.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.jtl.getPageContext().getPageActivity()));
                }
            }
            this.jth.initViewPager(0);
            this.jth.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.jth.getFragmentTabWidget().setVisibility(8);
            }
            zC(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zC(int i) {
        FragmentTabHost.b kV = this.jth.kV(i);
        this.jti = kV.mType;
        this.jtj = kV.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.jtl.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.dLP = fragmentTabIndicator;
            bVar2.dLQ = bVar;
            this.jth.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.jth.onChangeSkinType(i);
        if (this.jth.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.jth.getTabWrapper().setVisibility(8);
            } else {
                this.jth.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.jtg, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.gQt.onChangeSkinType(this.jtl.getPageContext(), i);
        this.jtk.onChangeSkinType(this.jtl.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qC(boolean z) {
        this.jtg.setEnabled(z);
        if (!z) {
            this.jtg.setText(R.string.edit);
            am.setNavbarTitleColor(this.jtg, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
