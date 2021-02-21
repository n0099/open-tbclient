package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
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
/* loaded from: classes8.dex */
public class a {
    private final NavigationBar iJN;
    private final TextView lwE;
    private final FragmentTabHost lwF;
    private Fragment lwH;
    private final NoNetworkView lwI;
    private CollectTabActivity lwJ;
    private List mTabDataList;
    private int lwG = -1;
    private boolean lwK = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.EM(i);
            a.this.uc(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int dhs() {
        return this.lwG;
    }

    public Fragment dht() {
        return this.lwH;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lwJ = collectTabActivity;
        this.lwF = (FragmentTabHost) this.lwJ.findViewById(R.id.tab_host);
        this.lwF.setup(this.lwJ.getSupportFragmentManager());
        this.lwF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iJN = (NavigationBar) this.lwJ.findViewById(R.id.navigation_bar);
        this.lwI = (NoNetworkView) this.lwJ.findViewById(R.id.view_no_network);
        this.iJN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iJN.setCenterTextTitle(this.lwJ.getPageContext().getString(R.string.my_mark));
        this.lwE = (TextView) this.iJN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lwJ).findViewById(R.id.right_textview);
        this.lwE.setText(R.string.edit);
        this.lwE.setOnClickListener(this.lwJ);
        this.iJN.onChangeSkinType(this.lwJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView dhu() {
        return this.lwE;
    }

    @SuppressLint({"ResourceAsColor"})
    public void uc(boolean z) {
        int i = -1;
        if (this.lwH instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lwH;
            if (!collectFragment.bkP()) {
                z = false;
            }
            ud(collectFragment.bkP());
            i = collectFragment.getType();
        }
        this.lwK = z;
        this.lwE.setText(this.lwK ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.lwE, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.lwE, this.lwK ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lwK);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean dhv() {
        return this.lwK;
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lwF.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lwJ.getPageContext().getPageActivity()));
                }
            }
            this.lwF.initViewPager(0);
            this.lwF.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lwF.getFragmentTabWidget().setVisibility(8);
            }
            EM(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM(int i) {
        FragmentTabHost.b ot = this.lwF.ot(i);
        this.lwG = ot.mType;
        this.lwH = ot.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lwJ.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eZk = fragmentTabIndicator;
            bVar2.eZl = bVar;
            this.lwF.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lwF.onChangeSkinType(i);
        if (this.lwF.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lwF.getTabWrapper().setVisibility(8);
            } else {
                this.lwF.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.lwE, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iJN.onChangeSkinType(this.lwJ.getPageContext(), i);
        this.lwI.onChangeSkinType(this.lwJ.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void ud(boolean z) {
        this.lwE.setEnabled(z);
        if (!z) {
            this.lwE.setText(R.string.edit);
            ap.setNavbarTitleColor(this.lwE, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
