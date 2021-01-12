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
/* loaded from: classes7.dex */
public class a {
    private final NavigationBar iDP;
    private final TextView lom;
    private final FragmentTabHost loo;
    private Fragment loq;
    private final NoNetworkView lor;
    private CollectTabActivity los;
    private List mTabDataList;
    private int lop = -1;
    private boolean lot = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Eu(i);
            a.this.tP(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int dfl() {
        return this.lop;
    }

    public Fragment dfm() {
        return this.loq;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.los = collectTabActivity;
        this.loo = (FragmentTabHost) this.los.findViewById(R.id.tab_host);
        this.loo.setup(this.los.getSupportFragmentManager());
        this.loo.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iDP = (NavigationBar) this.los.findViewById(R.id.navigation_bar);
        this.lor = (NoNetworkView) this.los.findViewById(R.id.view_no_network);
        this.iDP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iDP.setCenterTextTitle(this.los.getPageContext().getString(R.string.my_mark));
        this.lom = (TextView) this.iDP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.los).findViewById(R.id.right_textview);
        this.lom.setText(R.string.edit);
        this.lom.setOnClickListener(this.los);
        this.iDP.onChangeSkinType(this.los.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView dfn() {
        return this.lom;
    }

    @SuppressLint({"ResourceAsColor"})
    public void tP(boolean z) {
        int i = -1;
        if (this.loq instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.loq;
            if (!collectFragment.bkx()) {
                z = false;
            }
            tQ(collectFragment.bkx());
            i = collectFragment.getType();
        }
        this.lot = z;
        this.lom.setText(this.lot ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ao.setNavbarTitleColor(this.lom, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ao.setNavbarTitleColor(this.lom, this.lot ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lot);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean dfo() {
        return this.lot;
    }

    public void aS(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.loo.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.los.getPageContext().getPageActivity()));
                }
            }
            this.loo.initViewPager(0);
            this.loo.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.loo.getFragmentTabWidget().setVisibility(8);
            }
            Eu(0);
        }
    }

    private int getTabCount() {
        return x.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu(int i) {
        FragmentTabHost.b oo = this.loo.oo(i);
        this.lop = oo.mType;
        this.loq = oo.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.los.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eWU = fragmentTabIndicator;
            bVar2.eWV = bVar;
            this.loo.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.loo.onChangeSkinType(i);
        if (this.loo.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.loo.getTabWrapper().setVisibility(8);
            } else {
                this.loo.getTabWrapper().setVisibility(0);
            }
        }
        ao.setNavbarTitleColor(this.lom, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iDP.onChangeSkinType(this.los.getPageContext(), i);
        this.lor.onChangeSkinType(this.los.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void tQ(boolean z) {
        this.lom.setEnabled(z);
        if (!z) {
            this.lom.setText(R.string.edit);
            ao.setNavbarTitleColor(this.lom, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
