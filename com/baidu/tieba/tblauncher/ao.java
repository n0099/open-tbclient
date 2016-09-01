package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ac fwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ac acVar) {
        this.fwR = acVar;
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
        FragmentTabHost fragmentTabHost8;
        ImageView imageView;
        ImageView imageView2;
        FragmentTabHost fragmentTabHost9;
        fragmentTabHost = this.fwR.bdA;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fwR.bla();
        fragmentTabHost2 = this.fwR.bdA;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.fwR.bdA;
        if (currentTabType != fragmentTabHost3.cy(i).mType) {
            fragmentTabHost9 = this.fwR.bdA;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.fwR.bdA;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.fwR.fwI;
            imageView.setVisibility(8);
            imageView2 = this.fwR.cDJ;
            imageView2.setVisibility(0);
        }
        ac acVar = this.fwR;
        fragmentTabHost5 = this.fwR.bdA;
        acVar.dWX = fragmentTabHost5.getCurrentTabType();
        this.fwR.bkW();
        if (com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.fwR.bdA;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.fwR.bdA;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.fwR.bdA;
                    if (fragmentTabHost8.getCurrentTabType() == 2) {
                        TiebaStatic.log("c10098");
                        return;
                    }
                    return;
                }
                TiebaStatic.log("c10149");
                return;
            }
            TiebaStatic.log("c10150");
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
