package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ae fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ae aeVar) {
        this.fGW = aeVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        FragmentTabHost fragmentTabHost3;
        FragmentTabHost fragmentTabHost4;
        FragmentTabHost fragmentTabHost5;
        FragmentTabHost fragmentTabHost6;
        FragmentTabHost fragmentTabHost7;
        ImageView imageView;
        ImageView imageView2;
        FragmentTabHost fragmentTabHost8;
        fragmentTabHost = this.fGW.bgU;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fGW.boa();
        fragmentTabHost2 = this.fGW.bgU;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.fGW.bgU;
        if (currentTabType != fragmentTabHost3.cz(i).mType) {
            fragmentTabHost8 = this.fGW.bgU;
            fragmentTabHost8.setCurrentTab(i);
        }
        fragmentTabHost4 = this.fGW.bgU;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.fGW.fGN;
            imageView.setVisibility(8);
            imageView2 = this.fGW.aXq;
            imageView2.setVisibility(0);
        }
        ae aeVar = this.fGW;
        fragmentTabHost5 = this.fGW.bgU;
        aeVar.eeQ = fragmentTabHost5.getCurrentTabType();
        this.fGW.bnW();
        if (com.baidu.tbadk.core.sharedPref.b.um().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.fGW.bgU;
            if (fragmentTabHost6.getCurrentTabType() != 3) {
                fragmentTabHost7 = this.fGW.bgU;
                if (fragmentTabHost7.getCurrentTabType() == 2) {
                    TiebaStatic.log("c10098");
                    return;
                }
                return;
            }
            TiebaStatic.log("c10149");
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
