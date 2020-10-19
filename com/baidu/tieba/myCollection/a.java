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
/* loaded from: classes24.dex */
public class a {
    private final NavigationBar hSb;
    private final TextView kHr;
    private final FragmentTabHost kHs;
    private Fragment kHu;
    private final NoNetworkView kHv;
    private CollectTabActivity kHw;
    private List mTabDataList;
    private int kHt = -1;
    private boolean kHx = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Ep(i);
            a.this.sN(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cYV() {
        return this.kHt;
    }

    public Fragment cYW() {
        return this.kHu;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.kHw = collectTabActivity;
        this.kHs = (FragmentTabHost) this.kHw.findViewById(R.id.tab_host);
        this.kHs.setup(this.kHw.getSupportFragmentManager());
        this.kHs.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hSb = (NavigationBar) this.kHw.findViewById(R.id.navigation_bar);
        this.kHv = (NoNetworkView) this.kHw.findViewById(R.id.view_no_network);
        this.hSb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hSb.setCenterTextTitle(this.kHw.getPageContext().getString(R.string.my_mark));
        this.kHr = (TextView) this.hSb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.kHw).findViewById(R.id.right_textview);
        this.kHr.setText(R.string.edit);
        this.kHr.setOnClickListener(this.kHw);
        this.hSb.onChangeSkinType(this.kHw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cYX() {
        return this.kHr;
    }

    @SuppressLint({"ResourceAsColor"})
    public void sN(boolean z) {
        int i = -1;
        if (this.kHu instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.kHu;
            if (!collectFragment.bfk()) {
                z = false;
            }
            sO(collectFragment.bfk());
            i = collectFragment.getType();
        }
        this.kHx = z;
        this.kHr.setText(this.kHx ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.kHr, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.kHr, this.kHx ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.kHx);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cYY() {
        return this.kHx;
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.kHs.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.kHw.getPageContext().getPageActivity()));
                }
            }
            this.kHs.initViewPager(0);
            this.kHs.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.kHs.getFragmentTabWidget().setVisibility(8);
            }
            Ep(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ep(int i) {
        FragmentTabHost.b ou = this.kHs.ou(i);
        this.kHt = ou.mType;
        this.kHu = ou.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.kHw.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.exe = fragmentTabIndicator;
            bVar2.exf = bVar;
            this.kHs.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.kHs.onChangeSkinType(i);
        if (this.kHs.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.kHs.getTabWrapper().setVisibility(8);
            } else {
                this.kHs.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.kHr, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.hSb.onChangeSkinType(this.kHw.getPageContext(), i);
        this.kHv.onChangeSkinType(this.kHw.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void sO(boolean z) {
        this.kHr.setEnabled(z);
        if (!z) {
            this.kHr.setText(R.string.edit);
            ap.setNavbarTitleColor(this.kHr, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
