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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private final NavigationBar iIw;
    private final TextView lsT;
    private final FragmentTabHost lsU;
    private Fragment lsW;
    private final NoNetworkView lsX;
    private CollectTabActivity lsY;
    private List mTabDataList;
    private int lsV = -1;
    private boolean lsZ = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Ga(i);
            a.this.tT(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int djd() {
        return this.lsV;
    }

    public Fragment dje() {
        return this.lsW;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lsY = collectTabActivity;
        this.lsU = (FragmentTabHost) this.lsY.findViewById(R.id.tab_host);
        this.lsU.setup(this.lsY.getSupportFragmentManager());
        this.lsU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iIw = (NavigationBar) this.lsY.findViewById(R.id.navigation_bar);
        this.lsX = (NoNetworkView) this.lsY.findViewById(R.id.view_no_network);
        this.iIw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iIw.setCenterTextTitle(this.lsY.getPageContext().getString(R.string.my_mark));
        this.lsT = (TextView) this.iIw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lsY).findViewById(R.id.right_textview);
        this.lsT.setText(R.string.edit);
        this.lsT.setOnClickListener(this.lsY);
        this.iIw.onChangeSkinType(this.lsY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView djf() {
        return this.lsT;
    }

    @SuppressLint({"ResourceAsColor"})
    public void tT(boolean z) {
        int i = -1;
        if (this.lsW instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lsW;
            if (!collectFragment.bor()) {
                z = false;
            }
            tU(collectFragment.bor());
            i = collectFragment.getType();
        }
        this.lsZ = z;
        this.lsT.setText(this.lsZ ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ao.setNavbarTitleColor(this.lsT, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ao.setNavbarTitleColor(this.lsT, this.lsZ ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lsZ);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean djg() {
        return this.lsZ;
    }

    public void aX(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lsU.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lsY.getPageContext().getPageActivity()));
                }
            }
            this.lsU.initViewPager(0);
            this.lsU.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lsU.getFragmentTabWidget().setVisibility(8);
            }
            Ga(0);
        }
    }

    private int getTabCount() {
        return x.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(int i) {
        FragmentTabHost.b pV = this.lsU.pV(i);
        this.lsV = pV.mType;
        this.lsW = pV.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lsY.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.fbC = fragmentTabIndicator;
            bVar2.fbD = bVar;
            this.lsU.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lsU.onChangeSkinType(i);
        if (this.lsU.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lsU.getTabWrapper().setVisibility(8);
            } else {
                this.lsU.getTabWrapper().setVisibility(0);
            }
        }
        ao.setNavbarTitleColor(this.lsT, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iIw.onChangeSkinType(this.lsY.getPageContext(), i);
        this.lsX.onChangeSkinType(this.lsY.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void tU(boolean z) {
        this.lsT.setEnabled(z);
        if (!z) {
            this.lsT.setText(R.string.edit);
            ao.setNavbarTitleColor(this.lsT, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
