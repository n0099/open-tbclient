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
    private final NavigationBar eDb;
    private final TextView haq;
    private final FragmentTabHost har;
    private Fragment hat;
    private final NoNetworkView hau;
    private CollectTabActivity hav;
    private List mTabDataList;
    private int has = -1;
    private boolean haw = false;
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
        return this.has;
    }

    public Fragment bEX() {
        return this.hat;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hav = collectTabActivity;
        this.har = (FragmentTabHost) this.hav.findViewById(d.g.tab_host);
        this.har.setup(this.hav.getSupportFragmentManager());
        this.har.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eDb = (NavigationBar) this.hav.findViewById(d.g.navigation_bar);
        this.hau = (NoNetworkView) this.hav.findViewById(d.g.view_no_network);
        this.eDb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDb.setCenterTextTitle(this.hav.getPageContext().getString(d.j.my_mark));
        this.eDb.showBottomLine();
        this.haq = (TextView) this.eDb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, this.hav).findViewById(d.g.right_textview);
        this.haq.setText(d.j.edit);
        this.haq.setOnClickListener(this.hav);
        View bottomLine = this.eDb.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hav.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hav.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setBackgroundColor(this.hav.getResources().getColor(d.C0277d.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.eDb.showBottomLine();
        this.eDb.onChangeSkinType(this.hav.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bEY() {
        return this.haq;
    }

    @SuppressLint({"ResourceAsColor"})
    public void mx(boolean z) {
        int i = -1;
        if (this.hat instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hat;
            if (!collectFragment.VX()) {
                z = false;
            }
            my(collectFragment.VX());
            i = collectFragment.getType();
        }
        this.haw = z;
        this.haq.setText(this.haw ? d.j.done : d.j.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            al.c(this.haq, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        } else {
            al.c(this.haq, this.haw ? d.C0277d.cp_link_tip_a : d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.haw);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public boolean bEZ() {
        return this.haw;
    }

    public void am(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.har.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.di(this.hav.getPageContext().getPageActivity()));
                }
            }
            this.har.gX(0);
            this.har.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.har.getFragmentTabWidget().setVisibility(8);
            }
            vF(0);
        }
    }

    private int getTabCount() {
        return v.S(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        FragmentTabHost.b gZ = this.har.gZ(i);
        this.has = gZ.mType;
        this.hat = gZ.bHZ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c anH = bVar.anH();
        if (anH != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.bHZ = anH.cog;
            bVar2.mType = anH.type;
            fragmentTabIndicator.setText(anH.bOh);
            fragmentTabIndicator.setTextSize(0, this.hav.getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setTextColorResId(d.C0277d.s_actionbar_text_color);
            fragmentTabIndicator.ii(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.bHY = fragmentTabIndicator;
            bVar2.bIa = bVar;
            this.har.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.har.onChangeSkinType(i);
        if (this.har.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.har.getTabWrapper().setVisibility(8);
            } else {
                this.har.getTabWrapper().setVisibility(0);
            }
        }
        al.c(this.haq, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        this.eDb.onChangeSkinType(this.hav.getPageContext(), i);
        this.hau.onChangeSkinType(this.hav.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void my(boolean z) {
        this.haq.setEnabled(z);
        if (!z) {
            this.haq.setText(d.j.edit);
            al.c(this.haq, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        }
    }
}
