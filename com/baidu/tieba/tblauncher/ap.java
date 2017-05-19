package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ah fzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ah ahVar) {
        this.fzg = ahVar;
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
        fragmentTabHost = this.fzg.bCH;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fzg.biD();
        fragmentTabHost2 = this.fzg.bCH;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.fzg.bCH;
        if (currentTabType != fragmentTabHost3.cw(i).mType) {
            fragmentTabHost9 = this.fzg.bCH;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.fzg.bCH;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.fzg.bGI;
            imageView.setVisibility(8);
            imageView2 = this.fzg.aZf;
            imageView2.setVisibility(0);
        }
        ah ahVar = this.fzg;
        fragmentTabHost5 = this.fzg.bCH;
        ahVar.dPH = fragmentTabHost5.getCurrentTabType();
        this.fzg.biB();
        if (com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost7 = this.fzg.bCH;
            if (fragmentTabHost7.getCurrentTabType() != 3) {
                fragmentTabHost8 = this.fzg.bCH;
                if (fragmentTabHost8.getCurrentTabType() == 2) {
                    TiebaStatic.log("c10098");
                }
            } else {
                TiebaStatic.log("c10149");
            }
        }
        fragmentTabHost6 = this.fzg.bCH;
        if (fragmentTabHost6.getCurrentTabType() == 3) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("view_msg").aa("nobatch", "1"));
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
