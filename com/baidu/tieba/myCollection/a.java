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
/* loaded from: classes9.dex */
public class a {
    private final NavigationBar fTs;
    private final TextView iql;
    private final FragmentTabHost iqm;
    private Fragment iqo;
    private final NoNetworkView iqp;
    private CollectTabActivity iqq;
    private List mTabDataList;
    private int iqn = -1;
    private boolean iqr = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.ye(i);
            a.this.oR(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cfK() {
        return this.iqn;
    }

    public Fragment cfL() {
        return this.iqo;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.iqq = collectTabActivity;
        this.iqm = (FragmentTabHost) this.iqq.findViewById(R.id.tab_host);
        this.iqm.setup(this.iqq.getSupportFragmentManager());
        this.iqm.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fTs = (NavigationBar) this.iqq.findViewById(R.id.navigation_bar);
        this.iqp = (NoNetworkView) this.iqq.findViewById(R.id.view_no_network);
        this.fTs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fTs.setCenterTextTitle(this.iqq.getPageContext().getString(R.string.my_mark));
        this.iql = (TextView) this.fTs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.iqq).findViewById(R.id.right_textview);
        this.iql.setText(R.string.edit);
        this.iql.setOnClickListener(this.iqq);
        this.fTs.onChangeSkinType(this.iqq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cfM() {
        return this.iql;
    }

    @SuppressLint({"ResourceAsColor"})
    public void oR(boolean z) {
        int i = -1;
        if (this.iqo instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.iqo;
            if (!collectFragment.axu()) {
                z = false;
            }
            oS(collectFragment.axu());
            i = collectFragment.getType();
        }
        this.iqr = z;
        this.iql.setText(this.iqr ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.iql, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.iql, this.iqr ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.iqr);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cfN() {
        return this.iqr;
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.iqm.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.dW(this.iqq.getPageContext().getPageActivity()));
                }
            }
            this.iqm.initViewPager(0);
            this.iqm.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.iqm.getFragmentTabWidget().setVisibility(8);
            }
            ye(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye(int i) {
        FragmentTabHost.b jX = this.iqm.jX(i);
        this.iqn = jX.mType;
        this.iqo = jX.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c aNy = bVar.aNy();
        if (aNy != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = aNy.frag;
            bVar2.mType = aNy.type;
            fragmentTabIndicator.setText(aNy.textResId);
            fragmentTabIndicator.setTextSize(0, this.iqq.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cUe = fragmentTabIndicator;
            bVar2.cUf = bVar;
            this.iqm.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.iqm.onChangeSkinType(i);
        if (this.iqm.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.iqm.getTabWrapper().setVisibility(8);
            } else {
                this.iqm.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.iql, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fTs.onChangeSkinType(this.iqq.getPageContext(), i);
        this.iqp.onChangeSkinType(this.iqq.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oS(boolean z) {
        this.iql.setEnabled(z);
        if (!z) {
            this.iql.setText(R.string.edit);
            am.setNavbarTitleColor(this.iql, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
