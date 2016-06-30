package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ab abVar) {
        this.fbT = abVar;
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
        fragmentTabHost = this.fbT.aWJ;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fbT.bee();
        fragmentTabHost2 = this.fbT.aWJ;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.fbT.aWJ;
        if (currentTabType != fragmentTabHost3.cl(i).mType) {
            fragmentTabHost9 = this.fbT.aWJ;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.fbT.aWJ;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.fbT.fbK;
            imageView.setVisibility(8);
            imageView2 = this.fbT.cpW;
            imageView2.setVisibility(0);
        }
        ab abVar = this.fbT;
        fragmentTabHost5 = this.fbT.aWJ;
        abVar.dGO = fragmentTabHost5.getCurrentTabType();
        this.fbT.bea();
        if (com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.fbT.aWJ;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.fbT.aWJ;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.fbT.aWJ;
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
