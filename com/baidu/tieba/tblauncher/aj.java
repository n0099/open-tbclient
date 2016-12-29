package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ad flb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar) {
        this.flb = adVar;
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
        fragmentTabHost = this.flb.bgm;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.flb.bhU();
        fragmentTabHost2 = this.flb.bgm;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.flb.bgm;
        if (currentTabType != fragmentTabHost3.cB(i).mType) {
            fragmentTabHost9 = this.flb.bgm;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.flb.bgm;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.flb.fkV;
            imageView.setVisibility(8);
            imageView2 = this.flb.aWH;
            imageView2.setVisibility(0);
        }
        ad adVar = this.flb;
        fragmentTabHost5 = this.flb.bgm;
        adVar.dJx = fragmentTabHost5.getCurrentTabType();
        this.flb.bhR();
        if (com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost7 = this.flb.bgm;
            if (fragmentTabHost7.getCurrentTabType() != 3) {
                fragmentTabHost8 = this.flb.bgm;
                if (fragmentTabHost8.getCurrentTabType() == 2) {
                    TiebaStatic.log("c10098");
                }
            } else {
                TiebaStatic.log("c10149");
            }
        }
        fragmentTabHost6 = this.flb.bgm;
        if (fragmentTabHost6.getCurrentTabType() == 3) {
            TiebaStatic.log("c10524");
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
