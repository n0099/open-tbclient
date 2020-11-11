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
    private final NavigationBar ikz;
    private final TextView kZK;
    private final FragmentTabHost kZL;
    private Fragment kZN;
    private final NoNetworkView kZO;
    private CollectTabActivity kZP;
    private List mTabDataList;
    private int kZM = -1;
    private boolean kZQ = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.EV(i);
            a.this.tn(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int deF() {
        return this.kZM;
    }

    public Fragment deG() {
        return this.kZN;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.kZP = collectTabActivity;
        this.kZL = (FragmentTabHost) this.kZP.findViewById(R.id.tab_host);
        this.kZL.setup(this.kZP.getSupportFragmentManager());
        this.kZL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ikz = (NavigationBar) this.kZP.findViewById(R.id.navigation_bar);
        this.kZO = (NoNetworkView) this.kZP.findViewById(R.id.view_no_network);
        this.ikz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ikz.setCenterTextTitle(this.kZP.getPageContext().getString(R.string.my_mark));
        this.kZK = (TextView) this.ikz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.kZP).findViewById(R.id.right_textview);
        this.kZK.setText(R.string.edit);
        this.kZK.setOnClickListener(this.kZP);
        this.ikz.onChangeSkinType(this.kZP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView deH() {
        return this.kZK;
    }

    @SuppressLint({"ResourceAsColor"})
    public void tn(boolean z) {
        int i = -1;
        if (this.kZN instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.kZN;
            if (!collectFragment.bjD()) {
                z = false;
            }
            to(collectFragment.bjD());
            i = collectFragment.getType();
        }
        this.kZQ = z;
        this.kZK.setText(this.kZQ ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.kZK, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.kZK, this.kZQ ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.kZQ);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean deI() {
        return this.kZQ;
    }

    public void aU(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.kZL.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.kZP.getPageContext().getPageActivity()));
                }
            }
            this.kZL.initViewPager(0);
            this.kZL.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.kZL.getFragmentTabWidget().setVisibility(8);
            }
            EV(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EV(int i) {
        FragmentTabHost.b oP = this.kZL.oP(i);
        this.kZM = oP.mType;
        this.kZN = oP.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.kZP.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eLs = fragmentTabIndicator;
            bVar2.eLt = bVar;
            this.kZL.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.kZL.onChangeSkinType(i);
        if (this.kZL.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.kZL.getTabWrapper().setVisibility(8);
            } else {
                this.kZL.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.kZK, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.ikz.onChangeSkinType(this.kZP.getPageContext(), i);
        this.kZO.onChangeSkinType(this.kZP.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void to(boolean z) {
        this.kZK.setEnabled(z);
        if (!z) {
            this.kZK.setText(R.string.edit);
            ap.setNavbarTitleColor(this.kZK, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
