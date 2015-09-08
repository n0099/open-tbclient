package com.baidu.tieba.myCollection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private final NoNetworkView aLn;
    private final TextView bXu;
    private final FragmentTabHost bXv;
    private Fragment bXx;
    private CollectTabActivity bXy;
    private final NavigationBar bdE;
    private int bXw = -1;
    private boolean bXz = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int abW() {
        return this.bXw;
    }

    public Fragment abX() {
        return this.bXx;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.bXy = collectTabActivity;
        this.bXv = (FragmentTabHost) this.bXy.findViewById(i.f.tab_host);
        this.bXv.setup(this.bXy.getSupportFragmentManager());
        this.bXv.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bdE = (NavigationBar) this.bXy.findViewById(i.f.navigation_bar);
        this.aLn = (NoNetworkView) this.bXy.findViewById(i.f.view_no_network);
        this.bdE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdE.setTitleText(i.h.my_mark);
        this.bXu = (TextView) this.bdE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, this.bXy).findViewById(i.f.right_textview);
        this.bXu.setText(i.h.edit);
        al.b(this.bXu, i.c.navi_op_text, 1);
        this.bXu.setOnClickListener(this.bXy);
        this.bdE.onChangeSkinType(this.bXy.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView abY() {
        return this.bXu;
    }

    public void dV(boolean z) {
        int i;
        int i2 = -1;
        if (this.bXx instanceof com.baidu.tbadk.b.b) {
            com.baidu.tbadk.b.b bVar = (com.baidu.tbadk.b.b) this.bXx;
            if (!bVar.isEnableEdit()) {
                z = false;
            }
            dW(bVar.isEnableEdit());
            i2 = bVar.getType();
        }
        this.bXz = z;
        this.bXu.setText(this.bXz ? i.h.done : i.h.edit);
        TextView textView = this.bXu;
        if (this.bXz) {
            i = i.c.cp_link_tip_a;
        } else {
            i = i.c.navi_op_text;
        }
        al.b(textView, i, 1);
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.b.b.EDITOR_STATE_EXTRA, this.bXz);
        bundle.putInt(com.baidu.tbadk.b.b.FRAGMENT_TYPE, i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean abZ() {
        return this.bXz;
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.bXv.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.getTabIndicator(this.bXy.getPageContext().getPageActivity()));
                }
            }
            this.bXv.ca(0);
            this.bXv.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.bXv.getFragmentTabWidget().setVisibility(8);
            }
            io(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(int i) {
        FragmentTabHost.b cb = this.bXv.cb(i);
        this.bXw = cb.mType;
        this.bXx = cb.YM;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YM = fragmentTabStructure.awz;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.awA);
            fragmentTabIndicator.setTextSize(0, this.bXy.getResources().getDimension(i.d.fontsize32));
            fragmentTabIndicator.setTextColorResId(i.c.main_bottom_button_color);
            fragmentTabIndicator.cO(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YL = fragmentTabIndicator;
            bVar2.YN = bVar;
            this.bXv.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.bXv.onChangeSkinType(i);
        this.bdE.onChangeSkinType(this.bXy.getPageContext(), i);
        this.aLn.onChangeSkinType(this.bXy.getPageContext(), i);
    }

    public void dW(boolean z) {
        this.bXu.setEnabled(z);
        if (!z) {
            this.bXu.setText(i.h.edit);
            al.b(this.bXu, i.c.navi_op_text, 1);
        }
    }
}
