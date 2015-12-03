package com.baidu.tieba.myCollection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private final NoNetworkView aNL;
    private final NavigationBar bli;
    private final TextView ctO;
    private final FragmentTabHost ctP;
    private Fragment ctR;
    private CollectTabActivity ctS;
    private View mRootView;
    private int ctQ = -1;
    private boolean ctT = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int ahP() {
        return this.ctQ;
    }

    public Fragment ahQ() {
        return this.ctR;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.ctS = collectTabActivity;
        this.mRootView = this.ctS.findViewById(n.f.tab);
        this.ctP = (FragmentTabHost) this.ctS.findViewById(n.f.tab_host);
        this.ctP.setup(this.ctS.getSupportFragmentManager());
        this.ctP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bli = (NavigationBar) this.ctS.findViewById(n.f.navigation_bar);
        this.aNL = (NoNetworkView) this.ctS.findViewById(n.f.view_no_network);
        this.bli.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bli.setTitleText(n.i.my_mark);
        this.ctO = (TextView) this.bli.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, this.ctS).findViewById(n.f.right_textview);
        this.ctO.setText(n.i.edit);
        as.b(this.ctO, n.c.navi_op_text, 1);
        this.ctO.setOnClickListener(this.ctS);
        this.bli.onChangeSkinType(this.ctS.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView ahR() {
        return this.ctO;
    }

    public void ex(boolean z) {
        int i;
        int i2 = -1;
        if (this.ctR instanceof com.baidu.tbadk.c.b) {
            com.baidu.tbadk.c.b bVar = (com.baidu.tbadk.c.b) this.ctR;
            if (!bVar.isEnableEdit()) {
                z = false;
            }
            ey(bVar.isEnableEdit());
            i2 = bVar.getType();
        }
        this.ctT = z;
        this.ctO.setText(this.ctT ? n.i.done : n.i.edit);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            as.b(this.ctO, n.c.navi_op_text, 1);
        } else {
            TextView textView = this.ctO;
            if (this.ctT) {
                i = n.c.cp_link_tip_a;
            } else {
                i = n.c.navi_op_text;
            }
            as.b(textView, i, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.c.b.EDITOR_STATE_EXTRA, this.ctT);
        bundle.putInt(com.baidu.tbadk.c.b.FRAGMENT_TYPE, i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean ahS() {
        return this.ctT;
    }

    public void R(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.ctP.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.getTabIndicator(this.ctS.getPageContext().getPageActivity()));
                }
            }
            this.ctP.ci(0);
            this.ctP.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.ctP.getFragmentTabWidget().setVisibility(8);
            }
            jA(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jA(int i) {
        FragmentTabHost.b cl = this.ctP.cl(i);
        this.ctQ = cl.mType;
        this.ctR = cl.Zw;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.Zw = fragmentTabStructure.avR;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.avS);
            fragmentTabIndicator.setTextSize(0, this.ctS.getResources().getDimension(n.d.fontsize32));
            fragmentTabIndicator.setTextColorResId(n.c.s_actionbar_text_color);
            fragmentTabIndicator.cX(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.Zv = fragmentTabIndicator;
            bVar2.Zx = bVar;
            this.ctP.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        as.j(this.mRootView, n.c.cp_bg_line_d);
        this.ctP.onChangeSkinType(i);
        this.bli.onChangeSkinType(this.ctS.getPageContext(), i);
        this.aNL.onChangeSkinType(this.ctS.getPageContext(), i);
    }

    public void ey(boolean z) {
        this.ctO.setEnabled(z);
        if (!z) {
            this.ctO.setText(n.i.edit);
            as.b(this.ctO, n.c.navi_op_text, 1);
        }
    }
}
