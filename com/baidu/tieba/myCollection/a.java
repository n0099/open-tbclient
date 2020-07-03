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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private final NavigationBar hdn;
    private final TextView jLD;
    private final FragmentTabHost jLE;
    private Fragment jLG;
    private final NoNetworkView jLH;
    private CollectTabActivity jLI;
    private List mTabDataList;
    private int jLF = -1;
    private boolean jLJ = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Aq(i);
            a.this.qL(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cDh() {
        return this.jLF;
    }

    public Fragment cDi() {
        return this.jLG;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.jLI = collectTabActivity;
        this.jLE = (FragmentTabHost) this.jLI.findViewById(R.id.tab_host);
        this.jLE.setup(this.jLI.getSupportFragmentManager());
        this.jLE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hdn = (NavigationBar) this.jLI.findViewById(R.id.navigation_bar);
        this.jLH = (NoNetworkView) this.jLI.findViewById(R.id.view_no_network);
        this.hdn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hdn.setCenterTextTitle(this.jLI.getPageContext().getString(R.string.my_mark));
        this.jLD = (TextView) this.hdn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.jLI).findViewById(R.id.right_textview);
        this.jLD.setText(R.string.edit);
        this.jLD.setOnClickListener(this.jLI);
        this.hdn.onChangeSkinType(this.jLI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cDj() {
        return this.jLD;
    }

    @SuppressLint({"ResourceAsColor"})
    public void qL(boolean z) {
        int i = -1;
        if (this.jLG instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.jLG;
            if (!collectFragment.aPw()) {
                z = false;
            }
            qM(collectFragment.aPw());
            i = collectFragment.getType();
        }
        this.jLJ = z;
        this.jLD.setText(this.jLJ ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            an.setNavbarTitleColor(this.jLD, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            an.setNavbarTitleColor(this.jLD, this.jLJ ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.jLJ);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cDk() {
        return this.jLJ;
    }

    public void aI(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.jLE.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.jLI.getPageContext().getPageActivity()));
                }
            }
            this.jLE.initViewPager(0);
            this.jLE.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.jLE.getFragmentTabWidget().setVisibility(8);
            }
            Aq(0);
        }
    }

    private int getTabCount() {
        return w.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(int i) {
        FragmentTabHost.b ll = this.jLE.ll(i);
        this.jLF = ll.mType;
        this.jLG = ll.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.jLI.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.dSF = fragmentTabIndicator;
            bVar2.dSG = bVar;
            this.jLE.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.jLE.onChangeSkinType(i);
        if (this.jLE.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.jLE.getTabWrapper().setVisibility(8);
            } else {
                this.jLE.getTabWrapper().setVisibility(0);
            }
        }
        an.setNavbarTitleColor(this.jLD, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.hdn.onChangeSkinType(this.jLI.getPageContext(), i);
        this.jLH.onChangeSkinType(this.jLI.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qM(boolean z) {
        this.jLD.setEnabled(z);
        if (!z) {
            this.jLD.setText(R.string.edit);
            an.setNavbarTitleColor(this.jLD, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
