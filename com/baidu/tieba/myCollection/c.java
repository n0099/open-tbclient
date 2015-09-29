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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private final NoNetworkView aKf;
    private final NavigationBar bdN;
    private final TextView cbg;
    private final FragmentTabHost cbh;
    private Fragment cbj;
    private CollectTabActivity cbk;
    private View mRootView;
    private int cbi = -1;
    private boolean cbl = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int ado() {
        return this.cbi;
    }

    public Fragment adp() {
        return this.cbj;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.cbk = collectTabActivity;
        this.mRootView = this.cbk.findViewById(i.f.tab);
        this.cbh = (FragmentTabHost) this.cbk.findViewById(i.f.tab_host);
        this.cbh.setup(this.cbk.getSupportFragmentManager());
        this.cbh.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bdN = (NavigationBar) this.cbk.findViewById(i.f.navigation_bar);
        this.aKf = (NoNetworkView) this.cbk.findViewById(i.f.view_no_network);
        this.bdN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdN.setTitleText(i.h.my_mark);
        this.cbg = (TextView) this.bdN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, this.cbk).findViewById(i.f.right_textview);
        this.cbg.setText(i.h.edit);
        am.b(this.cbg, i.c.navi_op_text, 1);
        this.cbg.setOnClickListener(this.cbk);
        this.bdN.onChangeSkinType(this.cbk.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView adq() {
        return this.cbg;
    }

    public void dW(boolean z) {
        int i;
        int i2 = -1;
        if (this.cbj instanceof com.baidu.tbadk.b.b) {
            com.baidu.tbadk.b.b bVar = (com.baidu.tbadk.b.b) this.cbj;
            if (!bVar.isEnableEdit()) {
                z = false;
            }
            dX(bVar.isEnableEdit());
            i2 = bVar.getType();
        }
        this.cbl = z;
        this.cbg.setText(this.cbl ? i.h.done : i.h.edit);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            am.b(this.cbg, i.c.navi_op_text, 1);
        } else {
            TextView textView = this.cbg;
            if (this.cbl) {
                i = i.c.cp_link_tip_a;
            } else {
                i = i.c.navi_op_text;
            }
            am.b(textView, i, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.b.b.EDITOR_STATE_EXTRA, this.cbl);
        bundle.putInt(com.baidu.tbadk.b.b.FRAGMENT_TYPE, i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean adr() {
        return this.cbl;
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.cbh.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.getTabIndicator(this.cbk.getPageContext().getPageActivity()));
                }
            }
            this.cbh.ca(0);
            this.cbh.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.cbh.getFragmentTabWidget().setVisibility(8);
            }
            iw(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iw(int i) {
        FragmentTabHost.b cd = this.cbh.cd(i);
        this.cbi = cd.mType;
        this.cbj = cd.YE;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YE = fragmentTabStructure.auY;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.auZ);
            fragmentTabIndicator.setTextSize(0, this.cbk.getResources().getDimension(i.d.fontsize32));
            fragmentTabIndicator.setTextColorResId(i.c.s_actionbar_text_color);
            fragmentTabIndicator.cP(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YD = fragmentTabIndicator;
            bVar2.YF = bVar;
            this.cbh.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        am.j(this.mRootView, i.c.cp_bg_line_d);
        this.cbh.onChangeSkinType(i);
        this.bdN.onChangeSkinType(this.cbk.getPageContext(), i);
        this.aKf.onChangeSkinType(this.cbk.getPageContext(), i);
    }

    public void dX(boolean z) {
        this.cbg.setEnabled(z);
        if (!z) {
            this.cbg.setText(i.h.edit);
            am.b(this.cbg, i.c.navi_op_text, 1);
        }
    }
}
