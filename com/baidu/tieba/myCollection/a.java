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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private final NavigationBar eDa;
    private final TextView hap;
    private final FragmentTabHost haq;
    private Fragment has;
    private final NoNetworkView hat;
    private CollectTabActivity hau;
    private List mTabDataList;
    private int har = -1;
    private boolean hav = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.vF(i);
            a.this.mx(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bEW() {
        return this.har;
    }

    public Fragment bEX() {
        return this.has;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hau = collectTabActivity;
        this.haq = (FragmentTabHost) this.hau.findViewById(d.g.tab_host);
        this.haq.setup(this.hau.getSupportFragmentManager());
        this.haq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eDa = (NavigationBar) this.hau.findViewById(d.g.navigation_bar);
        this.hat = (NoNetworkView) this.hau.findViewById(d.g.view_no_network);
        this.eDa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDa.setCenterTextTitle(this.hau.getPageContext().getString(d.j.my_mark));
        this.eDa.showBottomLine();
        this.hap = (TextView) this.eDa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.hau).findViewById(d.g.right_textview);
        this.hap.setText(d.j.edit);
        this.hap.setOnClickListener(this.hau);
        View bottomLine = this.eDa.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hau.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hau.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.hau.getResources().getColor(d.C0277d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eDa.showBottomLine();
        this.eDa.onChangeSkinType(this.hau.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bEY() {
        return this.hap;
    }

    @SuppressLint({"ResourceAsColor"})
    public void mx(boolean z) {
        int i = -1;
        if (this.has instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.has;
            if (!collectFragment.VX()) {
                z = false;
            }
            my(collectFragment.VX());
            i = collectFragment.getType();
        }
        this.hav = z;
        this.hap.setText(this.hav ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.c(this.hap, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        } else {
            al.c(this.hap, this.hav ? d.C0277d.cp_link_tip_a : d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hav);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bEZ() {
        return this.hav;
    }

    public void am(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.haq.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.di(this.hau.getPageContext().getPageActivity()));
                }
            }
            this.haq.gX(0);
            this.haq.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.haq.getFragmentTabWidget().setVisibility(8);
            }
            vF(0);
        }
    }

    private int getTabCount() {
        return v.S(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        FragmentTabHost.b gZ = this.haq.gZ(i);
        this.har = gZ.mType;
        this.has = gZ.bHY;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c anH = bVar.anH();
        if (anH != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bHY = anH.cof;
            bVar2.mType = anH.type;
            fragmentTabIndicator.setText(anH.bOg);
            fragmentTabIndicator.setTextSize(0, this.hau.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0277d.s_actionbar_text_color);
            fragmentTabIndicator.ii(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bHX = fragmentTabIndicator;
            bVar2.bHZ = bVar;
            this.haq.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.haq.onChangeSkinType(i);
        if (this.haq.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.haq.getTabWrapper().setVisibility(8);
            } else {
                this.haq.getTabWrapper().setVisibility(0);
            }
        }
        al.c(this.hap, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        this.eDa.onChangeSkinType(this.hau.getPageContext(), i);
        this.hat.onChangeSkinType(this.hau.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void my(boolean z) {
        this.hap.setEnabled(z);
        if (!z) {
            this.hap.setText(d.j.edit);
            al.c(this.hap, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        }
    }
}
