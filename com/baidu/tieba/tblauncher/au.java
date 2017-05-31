package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ak fHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ak akVar) {
        this.fHb = akVar;
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
        FragmentTabHost fragmentTabHost9;
        ImageView imageView;
        ImageView imageView2;
        FragmentTabHost fragmentTabHost10;
        fragmentTabHost = this.fHb.aYf;
        if (fragmentTabHost.getCurrentTabType() != 2) {
            fragmentTabHost2 = this.fHb.aYf;
            if (fragmentTabHost2.getCurrentTabType() == 15) {
                TiebaStatic.log("c12124");
            }
        } else {
            TiebaStatic.log("kantie_entry");
        }
        this.fHb.bkb();
        fragmentTabHost3 = this.fHb.aYf;
        int currentTabType = fragmentTabHost3.getCurrentTabType();
        fragmentTabHost4 = this.fHb.aYf;
        if (currentTabType != fragmentTabHost4.cx(i).mType) {
            fragmentTabHost10 = this.fHb.aYf;
            fragmentTabHost10.setCurrentTab(i);
        }
        fragmentTabHost5 = this.fHb.aYf;
        if (fragmentTabHost5.getCurrentTabType() != 1) {
            imageView = this.fHb.bMw;
            imageView.setVisibility(8);
            imageView2 = this.fHb.aWH;
            imageView2.setVisibility(0);
        }
        ak akVar = this.fHb;
        fragmentTabHost6 = this.fHb.aYf;
        akVar.dVd = fragmentTabHost6.getCurrentTabType();
        this.fHb.bjZ();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost8 = this.fHb.aYf;
            if (fragmentTabHost8.getCurrentTabType() != 3) {
                fragmentTabHost9 = this.fHb.aYf;
                if (fragmentTabHost9.getCurrentTabType() == 2) {
                    TiebaStatic.log("c10098");
                }
            } else {
                TiebaStatic.log("c10149");
            }
        }
        fragmentTabHost7 = this.fHb.aYf;
        if (fragmentTabHost7.getCurrentTabType() == 3) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("view_msg").Z("nobatch", "1"));
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
