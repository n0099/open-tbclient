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
    private final NavigationBar eXS;
    private final TextView hxX;
    private final FragmentTabHost hxY;
    private Fragment hya;
    private final NoNetworkView hyb;
    private CollectTabActivity hyc;
    private List mTabDataList;
    private int hxZ = -1;
    private boolean hyd = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.xo(i);
            a.this.nB(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bPt() {
        return this.hxZ;
    }

    public Fragment bPu() {
        return this.hya;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hyc = collectTabActivity;
        this.hxY = (FragmentTabHost) this.hyc.findViewById(R.id.tab_host);
        this.hxY.setup(this.hyc.getSupportFragmentManager());
        this.hxY.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eXS = (NavigationBar) this.hyc.findViewById(R.id.navigation_bar);
        this.hyb = (NoNetworkView) this.hyc.findViewById(R.id.view_no_network);
        this.eXS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXS.setCenterTextTitle(this.hyc.getPageContext().getString(R.string.my_mark));
        this.eXS.showBottomLine();
        this.hxX = (TextView) this.eXS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hyc).findViewById(R.id.right_textview);
        this.hxX.setText(R.string.edit);
        this.hxX.setOnClickListener(this.hyc);
        View bottomLine = this.eXS.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hyc.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hyc.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hyc.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eXS.showBottomLine();
        this.eXS.onChangeSkinType(this.hyc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bPv() {
        return this.hxX;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nB(boolean z) {
        int i = -1;
        if (this.hya instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hya;
            if (!collectFragment.abC()) {
                z = false;
            }
            nC(collectFragment.abC());
            i = collectFragment.getType();
        }
        this.hyd = z;
        this.hxX.setText(this.hyd ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.e(this.hxX, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.e(this.hxX, this.hyd ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hyd);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bPw() {
        return this.hyd;
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hxY.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cP(this.hyc.getPageContext().getPageActivity()));
                }
            }
            this.hxY.hR(0);
            this.hxY.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hxY.getFragmentTabWidget().setVisibility(8);
            }
            xo(0);
        }
    }

    private int getTabCount() {
        return v.Z(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xo(int i) {
        FragmentTabHost.b hT = this.hxY.hT(i);
        this.hxZ = hT.mType;
        this.hya = hT.bQK;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c atS = bVar.atS();
        if (atS != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bQK = atS.cxD;
            bVar2.mType = atS.type;
            fragmentTabIndicator.setText(atS.bWY);
            fragmentTabIndicator.setTextSize(0, this.hyc.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.jc(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bQJ = fragmentTabIndicator;
            bVar2.bQL = bVar;
            this.hxY.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hxY.onChangeSkinType(i);
        if (this.hxY.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hxY.getTabWrapper().setVisibility(8);
            } else {
                this.hxY.getTabWrapper().setVisibility(0);
            }
        }
        am.e(this.hxX, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.eXS.onChangeSkinType(this.hyc.getPageContext(), i);
        this.hyb.onChangeSkinType(this.hyc.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nC(boolean z) {
        this.hxX.setEnabled(z);
        if (!z) {
            this.hxX.setText(R.string.edit);
            am.e(this.hxX, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
