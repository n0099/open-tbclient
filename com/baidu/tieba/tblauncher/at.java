package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ab abVar) {
        this.exg = abVar;
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
        fragmentTabHost = this.exg.aTo;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.exg.aVM();
        fragmentTabHost2 = this.exg.aTo;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.exg.aTo;
        if (currentTabType != fragmentTabHost3.cl(i).mType) {
            fragmentTabHost9 = this.exg.aTo;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.exg.aTo;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.exg.ewT;
            imageView.setVisibility(8);
            imageView2 = this.exg.dZe;
            imageView2.setVisibility(0);
            this.exg.jG(false);
        } else {
            this.exg.jG(true);
        }
        ab abVar = this.exg;
        fragmentTabHost5 = this.exg.aTo;
        abVar.dag = fragmentTabHost5.getCurrentTabType();
        this.exg.aVI();
        if (com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.exg.aTo;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.exg.aTo;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.exg.aTo;
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
