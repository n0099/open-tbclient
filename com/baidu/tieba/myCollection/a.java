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
/* loaded from: classes23.dex */
public class a {
    private final NavigationBar hDf;
    private final TextView ksf;
    private final FragmentTabHost ksg;
    private Fragment ksi;
    private final NoNetworkView ksj;
    private CollectTabActivity ksk;
    private List mTabDataList;
    private int ksh = -1;
    private boolean ksl = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.DJ(i);
            a.this.sg(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cVm() {
        return this.ksh;
    }

    public Fragment cVn() {
        return this.ksi;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.ksk = collectTabActivity;
        this.ksg = (FragmentTabHost) this.ksk.findViewById(R.id.tab_host);
        this.ksg.setup(this.ksk.getSupportFragmentManager());
        this.ksg.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hDf = (NavigationBar) this.ksk.findViewById(R.id.navigation_bar);
        this.ksj = (NoNetworkView) this.ksk.findViewById(R.id.view_no_network);
        this.hDf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hDf.setCenterTextTitle(this.ksk.getPageContext().getString(R.string.my_mark));
        this.ksf = (TextView) this.hDf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ksk).findViewById(R.id.right_textview);
        this.ksf.setText(R.string.edit);
        this.ksf.setOnClickListener(this.ksk);
        this.hDf.onChangeSkinType(this.ksk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cVo() {
        return this.ksf;
    }

    @SuppressLint({"ResourceAsColor"})
    public void sg(boolean z) {
        int i = -1;
        if (this.ksi instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.ksi;
            if (!collectFragment.bcC()) {
                z = false;
            }
            sh(collectFragment.bcC());
            i = collectFragment.getType();
        }
        this.ksl = z;
        this.ksf.setText(this.ksl ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.ksf, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.ksf, this.ksl ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.ksl);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cVp() {
        return this.ksl;
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.ksg.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.ksk.getPageContext().getPageActivity()));
                }
            }
            this.ksg.initViewPager(0);
            this.ksg.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.ksg.getFragmentTabWidget().setVisibility(8);
            }
            DJ(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ(int i) {
        FragmentTabHost.b nX = this.ksg.nX(i);
        this.ksh = nX.mType;
        this.ksi = nX.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.ksk.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.ekW = fragmentTabIndicator;
            bVar2.ekX = bVar;
            this.ksg.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.ksg.onChangeSkinType(i);
        if (this.ksg.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.ksg.getTabWrapper().setVisibility(8);
            } else {
                this.ksg.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.ksf, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.hDf.onChangeSkinType(this.ksk.getPageContext(), i);
        this.ksj.onChangeSkinType(this.ksk.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void sh(boolean z) {
        this.ksf.setEnabled(z);
        if (!z) {
            this.ksf.setText(R.string.edit);
            ap.setNavbarTitleColor(this.ksf, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
