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
    private final NoNetworkView aKq;
    private final NavigationBar bdY;
    private final TextView cbr;
    private final FragmentTabHost cbs;
    private Fragment cbu;
    private CollectTabActivity cbv;
    private View mRootView;
    private int cbt = -1;
    private boolean cbw = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int ado() {
        return this.cbt;
    }

    public Fragment adp() {
        return this.cbu;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.cbv = collectTabActivity;
        this.mRootView = this.cbv.findViewById(i.f.tab);
        this.cbs = (FragmentTabHost) this.cbv.findViewById(i.f.tab_host);
        this.cbs.setup(this.cbv.getSupportFragmentManager());
        this.cbs.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bdY = (NavigationBar) this.cbv.findViewById(i.f.navigation_bar);
        this.aKq = (NoNetworkView) this.cbv.findViewById(i.f.view_no_network);
        this.bdY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdY.setTitleText(i.h.my_mark);
        this.cbr = (TextView) this.bdY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, this.cbv).findViewById(i.f.right_textview);
        this.cbr.setText(i.h.edit);
        an.b(this.cbr, i.c.navi_op_text, 1);
        this.cbr.setOnClickListener(this.cbv);
        this.bdY.onChangeSkinType(this.cbv.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView adq() {
        return this.cbr;
    }

    public void dW(boolean z) {
        int i;
        int i2 = -1;
        if (this.cbu instanceof com.baidu.tbadk.b.b) {
            com.baidu.tbadk.b.b bVar = (com.baidu.tbadk.b.b) this.cbu;
            if (!bVar.isEnableEdit()) {
                z = false;
            }
            dX(bVar.isEnableEdit());
            i2 = bVar.getType();
        }
        this.cbw = z;
        this.cbr.setText(this.cbw ? i.h.done : i.h.edit);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            an.b(this.cbr, i.c.navi_op_text, 1);
        } else {
            TextView textView = this.cbr;
            if (this.cbw) {
                i = i.c.cp_link_tip_a;
            } else {
                i = i.c.navi_op_text;
            }
            an.b(textView, i, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.b.b.EDITOR_STATE_EXTRA, this.cbw);
        bundle.putInt(com.baidu.tbadk.b.b.FRAGMENT_TYPE, i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean adr() {
        return this.cbw;
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.cbs.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.getTabIndicator(this.cbv.getPageContext().getPageActivity()));
                }
            }
            this.cbs.ca(0);
            this.cbs.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.cbs.getFragmentTabWidget().setVisibility(8);
            }
            iw(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iw(int i) {
        FragmentTabHost.b cd = this.cbs.cd(i);
        this.cbt = cd.mType;
        this.cbu = cd.YG;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YG = fragmentTabStructure.auZ;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.ava);
            fragmentTabIndicator.setTextSize(0, this.cbv.getResources().getDimension(i.d.fontsize32));
            fragmentTabIndicator.setTextColorResId(i.c.s_actionbar_text_color);
            fragmentTabIndicator.cP(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YF = fragmentTabIndicator;
            bVar2.YH = bVar;
            this.cbs.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        an.j(this.mRootView, i.c.cp_bg_line_d);
        this.cbs.onChangeSkinType(i);
        this.bdY.onChangeSkinType(this.cbv.getPageContext(), i);
        this.aKq.onChangeSkinType(this.cbv.getPageContext(), i);
    }

    public void dX(boolean z) {
        this.cbr.setEnabled(z);
        if (!z) {
            this.cbr.setText(i.h.edit);
            an.b(this.cbr, i.c.navi_op_text, 1);
        }
    }
}
