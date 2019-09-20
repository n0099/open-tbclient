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
    private final NavigationBar eZL;
    private final TextView hAL;
    private final FragmentTabHost hAM;
    private Fragment hAO;
    private final NoNetworkView hAP;
    private CollectTabActivity hAQ;
    private List mTabDataList;
    private int hAN = -1;
    private boolean hAR = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.xt(i);
            a.this.nF(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bQv() {
        return this.hAN;
    }

    public Fragment bQw() {
        return this.hAO;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hAQ = collectTabActivity;
        this.hAM = (FragmentTabHost) this.hAQ.findViewById(R.id.tab_host);
        this.hAM.setup(this.hAQ.getSupportFragmentManager());
        this.hAM.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eZL = (NavigationBar) this.hAQ.findViewById(R.id.navigation_bar);
        this.hAP = (NoNetworkView) this.hAQ.findViewById(R.id.view_no_network);
        this.eZL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eZL.setCenterTextTitle(this.hAQ.getPageContext().getString(R.string.my_mark));
        this.eZL.showBottomLine();
        this.hAL = (TextView) this.eZL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hAQ).findViewById(R.id.right_textview);
        this.hAL.setText(R.string.edit);
        this.hAL.setOnClickListener(this.hAQ);
        View bottomLine = this.eZL.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hAQ.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hAQ.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hAQ.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eZL.showBottomLine();
        this.eZL.onChangeSkinType(this.hAQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bQx() {
        return this.hAL;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nF(boolean z) {
        int i = -1;
        if (this.hAO instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hAO;
            if (!collectFragment.abG()) {
                z = false;
            }
            nG(collectFragment.abG());
            i = collectFragment.getType();
        }
        this.hAR = z;
        this.hAL.setText(this.hAR ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.e(this.hAL, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.e(this.hAL, this.hAR ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hAR);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bQy() {
        return this.hAR;
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hAM.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cP(this.hAQ.getPageContext().getPageActivity()));
                }
            }
            this.hAM.hR(0);
            this.hAM.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hAM.getFragmentTabWidget().setVisibility(8);
            }
            xt(0);
        }
    }

    private int getTabCount() {
        return v.Z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i) {
        FragmentTabHost.b hT = this.hAM.hT(i);
        this.hAN = hT.mType;
        this.hAO = hT.bRr;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c aug = bVar.aug();
        if (aug != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bRr = aug.cyG;
            bVar2.mType = aug.type;
            fragmentTabIndicator.setText(aug.bXX);
            fragmentTabIndicator.setTextSize(0, this.hAQ.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.jg(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bRq = fragmentTabIndicator;
            bVar2.bRs = bVar;
            this.hAM.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hAM.onChangeSkinType(i);
        if (this.hAM.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hAM.getTabWrapper().setVisibility(8);
            } else {
                this.hAM.getTabWrapper().setVisibility(0);
            }
        }
        am.e(this.hAL, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.eZL.onChangeSkinType(this.hAQ.getPageContext(), i);
        this.hAP.onChangeSkinType(this.hAQ.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nG(boolean z) {
        this.hAL.setEnabled(z);
        if (!z) {
            this.hAL.setText(R.string.edit);
            am.e(this.hAL, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
