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
/* loaded from: classes11.dex */
public class a {
    private final NavigationBar gQE;
    private final TextView jum;
    private final FragmentTabHost jun;
    private Fragment jup;
    private final NoNetworkView juq;
    private CollectTabActivity jur;
    private List mTabDataList;
    private int juo = -1;
    private boolean jus = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.zE(i);
            a.this.qB(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int czk() {
        return this.juo;
    }

    public Fragment czl() {
        return this.jup;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.jur = collectTabActivity;
        this.jun = (FragmentTabHost) this.jur.findViewById(R.id.tab_host);
        this.jun.setup(this.jur.getSupportFragmentManager());
        this.jun.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gQE = (NavigationBar) this.jur.findViewById(R.id.navigation_bar);
        this.juq = (NoNetworkView) this.jur.findViewById(R.id.view_no_network);
        this.gQE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gQE.setCenterTextTitle(this.jur.getPageContext().getString(R.string.my_mark));
        this.jum = (TextView) this.gQE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.jur).findViewById(R.id.right_textview);
        this.jum.setText(R.string.edit);
        this.jum.setOnClickListener(this.jur);
        this.gQE.onChangeSkinType(this.jur.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView czm() {
        return this.jum;
    }

    @SuppressLint({"ResourceAsColor"})
    public void qB(boolean z) {
        int i = -1;
        if (this.jup instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.jup;
            if (!collectFragment.aNM()) {
                z = false;
            }
            qC(collectFragment.aNM());
            i = collectFragment.getType();
        }
        this.jus = z;
        this.jum.setText(this.jus ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.jum, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.jum, this.jus ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.jus);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean czn() {
        return this.jus;
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.jun.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.jur.getPageContext().getPageActivity()));
                }
            }
            this.jun.initViewPager(0);
            this.jun.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.jun.getFragmentTabWidget().setVisibility(8);
            }
            zE(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zE(int i) {
        FragmentTabHost.b kX = this.jun.kX(i);
        this.juo = kX.mType;
        this.jup = kX.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.jur.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.dLP = fragmentTabIndicator;
            bVar2.dLQ = bVar;
            this.jun.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.jun.onChangeSkinType(i);
        if (this.jun.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.jun.getTabWrapper().setVisibility(8);
            } else {
                this.jun.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.jum, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.gQE.onChangeSkinType(this.jur.getPageContext(), i);
        this.juq.onChangeSkinType(this.jur.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qC(boolean z) {
        this.jum.setEnabled(z);
        if (!z) {
            this.jum.setText(R.string.edit);
            am.setNavbarTitleColor(this.jum, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
