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
    private final NavigationBar iwj;
    private final TextView lnC;
    private final FragmentTabHost lnD;
    private Fragment lnF;
    private final NoNetworkView lnG;
    private CollectTabActivity lnH;
    private List mTabDataList;
    private int lnE = -1;
    private boolean lnI = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Gi(i);
            a.this.tS(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int djp() {
        return this.lnE;
    }

    public Fragment djq() {
        return this.lnF;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lnH = collectTabActivity;
        this.lnD = (FragmentTabHost) this.lnH.findViewById(R.id.tab_host);
        this.lnD.setup(this.lnH.getSupportFragmentManager());
        this.lnD.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iwj = (NavigationBar) this.lnH.findViewById(R.id.navigation_bar);
        this.lnG = (NoNetworkView) this.lnH.findViewById(R.id.view_no_network);
        this.iwj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iwj.setCenterTextTitle(this.lnH.getPageContext().getString(R.string.my_mark));
        this.lnC = (TextView) this.iwj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lnH).findViewById(R.id.right_textview);
        this.lnC.setText(R.string.edit);
        this.lnC.setOnClickListener(this.lnH);
        this.iwj.onChangeSkinType(this.lnH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView djr() {
        return this.lnC;
    }

    @SuppressLint({"ResourceAsColor"})
    public void tS(boolean z) {
        int i = -1;
        if (this.lnF instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lnF;
            if (!collectFragment.blR()) {
                z = false;
            }
            tT(collectFragment.blR());
            i = collectFragment.getType();
        }
        this.lnI = z;
        this.lnC.setText(this.lnI ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.lnC, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.lnC, this.lnI ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lnI);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean djs() {
        return this.lnI;
    }

    public void aX(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lnD.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lnH.getPageContext().getPageActivity()));
                }
            }
            this.lnD.initViewPager(0);
            this.lnD.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lnD.getFragmentTabWidget().setVisibility(8);
            }
            Gi(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi(int i) {
        FragmentTabHost.b pL = this.lnD.pL(i);
        this.lnE = pL.mType;
        this.lnF = pL.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lnH.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eRD = fragmentTabIndicator;
            bVar2.eRE = bVar;
            this.lnD.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lnD.onChangeSkinType(i);
        if (this.lnD.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lnD.getTabWrapper().setVisibility(8);
            } else {
                this.lnD.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.lnC, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iwj.onChangeSkinType(this.lnH.getPageContext(), i);
        this.lnG.onChangeSkinType(this.lnH.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void tT(boolean z) {
        this.lnC.setEnabled(z);
        if (!z) {
            this.lnC.setText(R.string.edit);
            ap.setNavbarTitleColor(this.lnC, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
