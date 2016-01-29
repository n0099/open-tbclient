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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private final NoNetworkView bnd;
    private final NavigationBar bse;
    private Fragment cEA;
    private CollectTabActivity cEB;
    private final TextView cEx;
    private final FragmentTabHost cEy;
    private View mRootView;
    private int cEz = -1;
    private boolean cEC = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new d(this);

    public int amW() {
        return this.cEz;
    }

    public Fragment amX() {
        return this.cEA;
    }

    public c(CollectTabActivity collectTabActivity) {
        this.cEB = collectTabActivity;
        this.mRootView = this.cEB.findViewById(t.g.tab);
        this.cEy = (FragmentTabHost) this.cEB.findViewById(t.g.tab_host);
        this.cEy.setup(this.cEB.getSupportFragmentManager());
        this.cEy.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bse = (NavigationBar) this.cEB.findViewById(t.g.navigation_bar);
        this.bnd = (NoNetworkView) this.cEB.findViewById(t.g.view_no_network);
        this.bse.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bse.setTitleText(t.j.my_mark);
        this.cEx = (TextView) this.bse.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, this.cEB).findViewById(t.g.right_textview);
        this.cEx.setText(t.j.edit);
        ar.b(this.cEx, t.d.navi_op_text, 1);
        this.cEx.setOnClickListener(this.cEB);
        this.bse.onChangeSkinType(this.cEB.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public TextView amY() {
        return this.cEx;
    }

    public void eK(boolean z) {
        int i;
        int i2 = -1;
        if (this.cEA instanceof com.baidu.tbadk.c.b) {
            com.baidu.tbadk.c.b bVar = (com.baidu.tbadk.c.b) this.cEA;
            if (!bVar.qO()) {
                z = false;
            }
            eL(bVar.qO());
            i2 = bVar.getType();
        }
        this.cEC = z;
        this.cEx.setText(this.cEC ? t.j.done : t.j.edit);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            ar.b(this.cEx, t.d.navi_op_text, 1);
        } else {
            TextView textView = this.cEx;
            if (this.cEC) {
                i = t.d.cp_link_tip_a;
            } else {
                i = t.d.navi_op_text;
            }
            ar.b(textView, i, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.cEC);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean amZ() {
        return this.cEC;
    }

    public void R(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.cEy.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, bVar.am(this.cEB.getPageContext().getPageActivity()));
                }
            }
            this.cEy.cu(0);
            this.cEy.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.cEy.getFragmentTabWidget().setVisibility(8);
            }
            ky(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(int i) {
        FragmentTabHost.c cz = this.cEy.cz(i);
        this.cEz = cz.mType;
        this.cEA = cz.aay;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Ey = bVar.Ey();
        if (Ey != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.aay = Ey.ayo;
            cVar.mType = Ey.type;
            fragmentTabIndicator.setText(Ey.ayp);
            fragmentTabIndicator.setTextSize(0, this.cEB.getResources().getDimension(t.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(t.d.s_actionbar_text_color);
            fragmentTabIndicator.dk(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar.aax = fragmentTabIndicator;
            cVar.aaz = bVar;
            this.cEy.a(cVar);
        }
    }

    public void onChangeSkinType(int i) {
        ar.l(this.mRootView, t.d.cp_bg_line_d);
        this.cEy.onChangeSkinType(i);
        this.bse.onChangeSkinType(this.cEB.getPageContext(), i);
        this.bnd.onChangeSkinType(this.cEB.getPageContext(), i);
    }

    public void eL(boolean z) {
        this.cEx.setEnabled(z);
        if (!z) {
            this.cEx.setText(t.j.edit);
            ar.b(this.cEx, t.d.navi_op_text, 1);
        }
    }
}
