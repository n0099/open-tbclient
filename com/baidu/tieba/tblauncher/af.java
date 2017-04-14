package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements ViewPager.OnPageChangeListener {
    final /* synthetic */ z fAp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.fAp = zVar;
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
        fragmentTabHost = this.fAp.bAp;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fAp.bkc();
        fragmentTabHost2 = this.fAp.bAp;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.fAp.bAp;
        if (currentTabType != fragmentTabHost3.cz(i).mType) {
            fragmentTabHost9 = this.fAp.bAp;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.fAp.bAp;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.fAp.fAj;
            imageView.setVisibility(8);
            imageView2 = this.fAp.aYG;
            imageView2.setVisibility(0);
        }
        z zVar = this.fAp;
        fragmentTabHost5 = this.fAp.bAp;
        zVar.dSG = fragmentTabHost5.getCurrentTabType();
        this.fAp.bjZ();
        if (com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost7 = this.fAp.bAp;
            if (fragmentTabHost7.getCurrentTabType() != 3) {
                fragmentTabHost8 = this.fAp.bAp;
                if (fragmentTabHost8.getCurrentTabType() == 2) {
                    TiebaStatic.log("c10098");
                }
            } else {
                TiebaStatic.log("c10149");
            }
        }
        fragmentTabHost6 = this.fAp.bAp;
        if (fragmentTabHost6.getCurrentTabType() == 3) {
            TiebaStatic.log(new as("view_msg").aa("nobatch", "1"));
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
