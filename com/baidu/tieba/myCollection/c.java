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
    private final NoNetworkView aRD;
    private final NavigationBar boZ;
    private final TextView cxQ;
    private final FragmentTabHost cxR;
    private Fragment cxT;
    private CollectTabActivity cxU;
    private View mRootView;
    private int cxS = -1;
    private boolean cxV = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int aiZ() {
        return this.cxS;
    }

    public Fragment aja() {
        return this.cxT;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.cxU = collectTabActivity;
        this.mRootView = this.cxU.findViewById(n.g.tab);
        this.cxR = (FragmentTabHost) this.cxU.findViewById(n.g.tab_host);
        this.cxR.setup(this.cxU.getSupportFragmentManager());
        this.cxR.setOnPageChangeListener(this.mOnPageChangeListener);
        this.boZ = (NavigationBar) this.cxU.findViewById(n.g.navigation_bar);
        this.aRD = (NoNetworkView) this.cxU.findViewById(n.g.view_no_network);
        this.boZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.boZ.setTitleText(n.j.my_mark);
        this.cxQ = (TextView) this.boZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, this.cxU).findViewById(n.g.right_textview);
        this.cxQ.setText(n.j.edit);
        as.b(this.cxQ, n.d.navi_op_text, 1);
        this.cxQ.setOnClickListener(this.cxU);
        this.boZ.onChangeSkinType(this.cxU.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView ajb() {
        return this.cxQ;
    }

    public void ex(boolean z) {
        int i;
        int i2 = -1;
        if (this.cxT instanceof com.baidu.tbadk.c.b) {
            com.baidu.tbadk.c.b bVar = (com.baidu.tbadk.c.b) this.cxT;
            if (!bVar.isEnableEdit()) {
                z = false;
            }
            ey(bVar.isEnableEdit());
            i2 = bVar.getType();
        }
        this.cxV = z;
        this.cxQ.setText(this.cxV ? n.j.done : n.j.edit);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            as.b(this.cxQ, n.d.navi_op_text, 1);
        } else {
            TextView textView = this.cxQ;
            if (this.cxV) {
                i = n.d.cp_link_tip_a;
            } else {
                i = n.d.navi_op_text;
            }
            as.b(textView, i, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.c.b.EDITOR_STATE_EXTRA, this.cxV);
        bundle.putInt(com.baidu.tbadk.c.b.FRAGMENT_TYPE, i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean ajc() {
        return this.cxV;
    }

    public void Q(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.cxR.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.getTabIndicator(this.cxU.getPageContext().getPageActivity()));
                }
            }
            this.cxR.cb(0);
            this.cxR.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.cxR.getFragmentTabWidget().setVisibility(8);
            }
            jY(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(int i) {
        FragmentTabHost.c ce = this.cxR.ce(i);
        this.cxS = ce.mType;
        this.cxT = ce.aaa;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.aaa = fragmentTabStructure.axv;
            cVar.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.axw);
            fragmentTabIndicator.setTextSize(0, this.cxU.getResources().getDimension(n.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(n.d.s_actionbar_text_color);
            fragmentTabIndicator.cR(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar.ZZ = fragmentTabIndicator;
            cVar.aab = bVar;
            this.cxR.a(cVar);
        }
    }

    public void onChangeSkinType(int i) {
        as.j(this.mRootView, n.d.cp_bg_line_d);
        this.cxR.onChangeSkinType(i);
        this.boZ.onChangeSkinType(this.cxU.getPageContext(), i);
        this.aRD.onChangeSkinType(this.cxU.getPageContext(), i);
    }

    public void ey(boolean z) {
        this.cxQ.setEnabled(z);
        if (!z) {
            this.cxQ.setText(n.j.edit);
            as.b(this.cxQ, n.d.navi_op_text, 1);
        }
    }
}
