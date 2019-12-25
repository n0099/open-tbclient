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
/* loaded from: classes8.dex */
public class a {
    private final NavigationBar fQj;
    private final TextView imG;
    private final FragmentTabHost imH;
    private Fragment imJ;
    private final NoNetworkView imK;
    private CollectTabActivity imL;
    private List mTabDataList;
    private int imI = -1;
    private boolean imM = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.xZ(i);
            a.this.oF(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int ceC() {
        return this.imI;
    }

    public Fragment ceD() {
        return this.imJ;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.imL = collectTabActivity;
        this.imH = (FragmentTabHost) this.imL.findViewById(R.id.tab_host);
        this.imH.setup(this.imL.getSupportFragmentManager());
        this.imH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fQj = (NavigationBar) this.imL.findViewById(R.id.navigation_bar);
        this.imK = (NoNetworkView) this.imL.findViewById(R.id.view_no_network);
        this.fQj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fQj.setCenterTextTitle(this.imL.getPageContext().getString(R.string.my_mark));
        this.imG = (TextView) this.fQj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.imL).findViewById(R.id.right_textview);
        this.imG.setText(R.string.edit);
        this.imG.setOnClickListener(this.imL);
        this.fQj.onChangeSkinType(this.imL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView ceE() {
        return this.imG;
    }

    @SuppressLint({"ResourceAsColor"})
    public void oF(boolean z) {
        int i = -1;
        if (this.imJ instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.imJ;
            if (!collectFragment.axb()) {
                z = false;
            }
            oG(collectFragment.axb());
            i = collectFragment.getType();
        }
        this.imM = z;
        this.imG.setText(this.imM ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.imG, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.imG, this.imM ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.imM);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean ceF() {
        return this.imM;
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.imH.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.dW(this.imL.getPageContext().getPageActivity()));
                }
            }
            this.imH.initViewPager(0);
            this.imH.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.imH.getFragmentTabWidget().setVisibility(8);
            }
            xZ(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xZ(int i) {
        FragmentTabHost.b jX = this.imH.jX(i);
        this.imI = jX.mType;
        this.imJ = jX.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c aNf = bVar.aNf();
        if (aNf != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = aNf.frag;
            bVar2.mType = aNf.type;
            fragmentTabIndicator.setText(aNf.textResId);
            fragmentTabIndicator.setTextSize(0, this.imL.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cTU = fragmentTabIndicator;
            bVar2.cTV = bVar;
            this.imH.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.imH.onChangeSkinType(i);
        if (this.imH.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.imH.getTabWrapper().setVisibility(8);
            } else {
                this.imH.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.imG, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fQj.onChangeSkinType(this.imL.getPageContext(), i);
        this.imK.onChangeSkinType(this.imL.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oG(boolean z) {
        this.imG.setEnabled(z);
        if (!z) {
            this.imG.setText(R.string.edit);
            am.setNavbarTitleColor(this.imG, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
