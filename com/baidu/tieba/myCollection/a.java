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
/* loaded from: classes18.dex */
public class a {
    private final NavigationBar hwb;
    private final TextView kjG;
    private final FragmentTabHost kjH;
    private Fragment kjJ;
    private final NoNetworkView kjK;
    private CollectTabActivity kjL;
    private List mTabDataList;
    private int kjI = -1;
    private boolean kjM = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Di(i);
            a.this.rY(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int cRG() {
        return this.kjI;
    }

    public Fragment cRH() {
        return this.kjJ;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.kjL = collectTabActivity;
        this.kjH = (FragmentTabHost) this.kjL.findViewById(R.id.tab_host);
        this.kjH.setup(this.kjL.getSupportFragmentManager());
        this.kjH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hwb = (NavigationBar) this.kjL.findViewById(R.id.navigation_bar);
        this.kjK = (NoNetworkView) this.kjL.findViewById(R.id.view_no_network);
        this.hwb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hwb.setCenterTextTitle(this.kjL.getPageContext().getString(R.string.my_mark));
        this.kjG = (TextView) this.hwb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.kjL).findViewById(R.id.right_textview);
        this.kjG.setText(R.string.edit);
        this.kjG.setOnClickListener(this.kjL);
        this.hwb.onChangeSkinType(this.kjL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView cRI() {
        return this.kjG;
    }

    @SuppressLint({"ResourceAsColor"})
    public void rY(boolean z) {
        int i = -1;
        if (this.kjJ instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.kjJ;
            if (!collectFragment.bbI()) {
                z = false;
            }
            rZ(collectFragment.bbI());
            i = collectFragment.getType();
        }
        this.kjM = z;
        this.kjG.setText(this.kjM ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.kjG, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.kjG, this.kjM ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.kjM);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean cRJ() {
        return this.kjM;
    }

    public void aP(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.kjH.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.kjL.getPageContext().getPageActivity()));
                }
            }
            this.kjH.initViewPager(0);
            this.kjH.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.kjH.getFragmentTabWidget().setVisibility(8);
            }
            Di(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di(int i) {
        FragmentTabHost.b nL = this.kjH.nL(i);
        this.kjI = nL.mType;
        this.kjJ = nL.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.kjL.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eiH = fragmentTabIndicator;
            bVar2.eiI = bVar;
            this.kjH.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.kjH.onChangeSkinType(i);
        if (this.kjH.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.kjH.getTabWrapper().setVisibility(8);
            } else {
                this.kjH.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.kjG, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.hwb.onChangeSkinType(this.kjL.getPageContext(), i);
        this.kjK.onChangeSkinType(this.kjL.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void rZ(boolean z) {
        this.kjG.setEnabled(z);
        if (!z) {
            this.kjG.setText(R.string.edit);
            ap.setNavbarTitleColor(this.kjG, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
