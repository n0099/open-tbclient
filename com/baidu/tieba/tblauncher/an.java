package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ab foX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ab abVar) {
        this.foX = abVar;
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
        fragmentTabHost = this.foX.aXH;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.foX.bhw();
        fragmentTabHost2 = this.foX.aXH;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.foX.aXH;
        if (currentTabType != fragmentTabHost3.cl(i).mType) {
            fragmentTabHost9 = this.foX.aXH;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.foX.aXH;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.foX.foO;
            imageView.setVisibility(8);
            imageView2 = this.foX.csB;
            imageView2.setVisibility(0);
        }
        ab abVar = this.foX;
        fragmentTabHost5 = this.foX.aXH;
        abVar.dLa = fragmentTabHost5.getCurrentTabType();
        this.foX.bhs();
        if (com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.foX.aXH;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.foX.aXH;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.foX.aXH;
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
