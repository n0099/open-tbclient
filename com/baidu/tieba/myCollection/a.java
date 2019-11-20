package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
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
/* loaded from: classes6.dex */
public class a {
    private final NavigationBar fbF;
    private final TextView hyD;
    private final FragmentTabHost hyE;
    private Fragment hyG;
    private final NoNetworkView hyH;
    private CollectTabActivity hyI;
    private List mTabDataList;
    private int hyF = -1;
    private boolean hyJ = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.vY(i);
            a.this.nq(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bNq() {
        return this.hyF;
    }

    public Fragment bNr() {
        return this.hyG;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hyI = collectTabActivity;
        this.hyE = (FragmentTabHost) this.hyI.findViewById(R.id.tab_host);
        this.hyE.setup(this.hyI.getSupportFragmentManager());
        this.hyE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fbF = (NavigationBar) this.hyI.findViewById(R.id.navigation_bar);
        this.hyH = (NoNetworkView) this.hyI.findViewById(R.id.view_no_network);
        this.fbF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fbF.setCenterTextTitle(this.hyI.getPageContext().getString(R.string.my_mark));
        this.fbF.showBottomLine();
        this.hyD = (TextView) this.fbF.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hyI).findViewById(R.id.right_textview);
        this.hyD.setText(R.string.edit);
        this.hyD.setOnClickListener(this.hyI);
        View bottomLine = this.fbF.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hyI.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hyI.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hyI.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.fbF.showBottomLine();
        this.fbF.onChangeSkinType(this.hyI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bNs() {
        return this.hyD;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nq(boolean z) {
        int i = -1;
        if (this.hyG instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hyG;
            if (!collectFragment.agk()) {
                z = false;
            }
            nr(collectFragment.agk());
            i = collectFragment.getType();
        }
        this.hyJ = z;
        this.hyD.setText(this.hyJ ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.hyD, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.hyD, this.hyJ ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hyJ);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean bNt() {
        return this.hyJ;
    }

    public void au(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hyE.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cB(this.hyI.getPageContext().getPageActivity()));
                }
            }
            this.hyE.initViewPager(0);
            this.hyE.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hyE.getFragmentTabWidget().setVisibility(8);
            }
            vY(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(int i) {
        FragmentTabHost.b il = this.hyE.il(i);
        this.hyF = il.mType;
        this.hyG = il.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c avx = bVar.avx();
        if (avx != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = avx.frag;
            bVar2.mType = avx.type;
            fragmentTabIndicator.setText(avx.textResId);
            fragmentTabIndicator.setTextSize(0, this.hyI.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.chu = fragmentTabIndicator;
            bVar2.chv = bVar;
            this.hyE.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hyE.onChangeSkinType(i);
        if (this.hyE.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hyE.getTabWrapper().setVisibility(8);
            } else {
                this.hyE.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.hyD, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fbF.onChangeSkinType(this.hyI.getPageContext(), i);
        this.hyH.onChangeSkinType(this.hyI.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nr(boolean z) {
        this.hyD.setEnabled(z);
        if (!z) {
            this.hyD.setText(R.string.edit);
            am.setNavbarTitleColor(this.hyD, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
