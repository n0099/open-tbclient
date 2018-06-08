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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private final NavigationBar dJM;
    private final TextView ffl;
    private final FragmentTabHost ffm;
    private Fragment ffo;
    private final NoNetworkView ffp;
    private CollectTabActivity ffq;
    private List mTabDataList;
    private int ffn = -1;
    private boolean ffr = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.pS(i);
            a.this.iV(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int aXv() {
        return this.ffn;
    }

    public Fragment aXw() {
        return this.ffo;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.ffq = collectTabActivity;
        this.ffm = (FragmentTabHost) this.ffq.findViewById(d.g.tab_host);
        this.ffm.setup(this.ffq.getSupportFragmentManager());
        this.ffm.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dJM = (NavigationBar) this.ffq.findViewById(d.g.navigation_bar);
        this.ffp = (NoNetworkView) this.ffq.findViewById(d.g.view_no_network);
        this.dJM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJM.setCenterTextTitle(this.ffq.getPageContext().getString(d.k.my_mark));
        this.dJM.showBottomLine();
        this.ffl = (TextView) this.dJM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, this.ffq).findViewById(d.g.right_textview);
        this.ffl.setText(d.k.edit);
        this.ffl.setOnClickListener(this.ffq);
        View bottomLine = this.dJM.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.ffq.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.ffq.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.ffq.getResources().getColor(d.C0141d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.dJM.showBottomLine();
        this.dJM.onChangeSkinType(this.ffq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView aXx() {
        return this.ffl;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iV(boolean z) {
        int i = -1;
        if (this.ffo instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.ffo;
            if (!collectFragment.sS()) {
                z = false;
            }
            iW(collectFragment.sS());
            i = collectFragment.getType();
        }
        this.ffr = z;
        this.ffl.setText(this.ffr ? d.k.done : d.k.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.b(this.ffl, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        } else {
            al.b(this.ffl, this.ffr ? d.C0141d.cp_link_tip_a : d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.ffr);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean aXy() {
        return this.ffr;
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.ffm.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.bd(this.ffq.getPageContext().getPageActivity()));
                }
            }
            this.ffm.cx(0);
            this.ffm.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.ffm.getFragmentTabWidget().setVisibility(8);
            }
            pS(0);
        }
    }

    private int getTabCount() {
        return w.y(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(int i) {
        FragmentTabHost.b cz = this.ffm.cz(i);
        this.ffn = cz.mType;
        this.ffo = cz.anN;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c Jb = bVar.Jb();
        if (Jb != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.anN = Jb.aQP;
            bVar2.mType = Jb.type;
            fragmentTabIndicator.setText(Jb.aQQ);
            fragmentTabIndicator.setTextSize(0, this.ffq.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0141d.s_actionbar_text_color);
            fragmentTabIndicator.dC(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.anM = fragmentTabIndicator;
            bVar2.anO = bVar;
            this.ffm.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.ffm.onChangeSkinType(i);
        if (this.ffm.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.ffm.getTabWrapper().setVisibility(8);
            } else {
                this.ffm.getTabWrapper().setVisibility(0);
            }
        }
        al.b(this.ffl, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        this.dJM.onChangeSkinType(this.ffq.getPageContext(), i);
        this.ffp.onChangeSkinType(this.ffq.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void iW(boolean z) {
        this.ffl.setEnabled(z);
        if (!z) {
            this.ffl.setText(d.k.edit);
            al.b(this.ffl, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        }
    }
}
