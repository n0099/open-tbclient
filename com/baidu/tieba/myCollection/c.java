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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private final NoNetworkView aJk;
    private final NavigationBar beE;
    private final TextView cbS;
    private final FragmentTabHost cbT;
    private Fragment cbV;
    private CollectTabActivity cbW;
    private View mRootView;
    private int cbU = -1;
    private boolean cbX = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int adF() {
        return this.cbU;
    }

    public Fragment adG() {
        return this.cbV;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.cbW = collectTabActivity;
        this.mRootView = this.cbW.findViewById(i.f.tab);
        this.cbT = (FragmentTabHost) this.cbW.findViewById(i.f.tab_host);
        this.cbT.setup(this.cbW.getSupportFragmentManager());
        this.cbT.setOnPageChangeListener(this.mOnPageChangeListener);
        this.beE = (NavigationBar) this.cbW.findViewById(i.f.navigation_bar);
        this.aJk = (NoNetworkView) this.cbW.findViewById(i.f.view_no_network);
        this.beE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.beE.setTitleText(i.h.my_mark);
        this.cbS = (TextView) this.beE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, this.cbW).findViewById(i.f.right_textview);
        this.cbS.setText(i.h.edit);
        an.b(this.cbS, i.c.navi_op_text, 1);
        this.cbS.setOnClickListener(this.cbW);
        this.beE.onChangeSkinType(this.cbW.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView adH() {
        return this.cbS;
    }

    public void dY(boolean z) {
        int i;
        int i2 = -1;
        if (this.cbV instanceof com.baidu.tbadk.b.b) {
            com.baidu.tbadk.b.b bVar = (com.baidu.tbadk.b.b) this.cbV;
            if (!bVar.isEnableEdit()) {
                z = false;
            }
            dZ(bVar.isEnableEdit());
            i2 = bVar.getType();
        }
        this.cbX = z;
        this.cbS.setText(this.cbX ? i.h.done : i.h.edit);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            an.b(this.cbS, i.c.navi_op_text, 1);
        } else {
            TextView textView = this.cbS;
            if (this.cbX) {
                i = i.c.cp_link_tip_a;
            } else {
                i = i.c.navi_op_text;
            }
            an.b(textView, i, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.b.b.EDITOR_STATE_EXTRA, this.cbX);
        bundle.putInt(com.baidu.tbadk.b.b.FRAGMENT_TYPE, i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean adI() {
        return this.cbX;
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.cbT.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.getTabIndicator(this.cbW.getPageContext().getPageActivity()));
                }
            }
            this.cbT.ca(0);
            this.cbT.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.cbT.getFragmentTabWidget().setVisibility(8);
            }
            iJ(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(int i) {
        FragmentTabHost.b cd = this.cbT.cd(i);
        this.cbU = cd.mType;
        this.cbV = cd.YK;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YK = fragmentTabStructure.atN;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.atO);
            fragmentTabIndicator.setTextSize(0, this.cbW.getResources().getDimension(i.d.fontsize32));
            fragmentTabIndicator.setTextColorResId(i.c.s_actionbar_text_color);
            fragmentTabIndicator.cP(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YJ = fragmentTabIndicator;
            bVar2.YL = bVar;
            this.cbT.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        an.j(this.mRootView, i.c.cp_bg_line_d);
        this.cbT.onChangeSkinType(i);
        this.beE.onChangeSkinType(this.cbW.getPageContext(), i);
        this.aJk.onChangeSkinType(this.cbW.getPageContext(), i);
    }

    public void dZ(boolean z) {
        this.cbS.setEnabled(z);
        if (!z) {
            this.cbS.setText(i.h.edit);
            an.b(this.cbS, i.c.navi_op_text, 1);
        }
    }
}
