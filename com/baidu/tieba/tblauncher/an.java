package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ab fzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ab abVar) {
        this.fzu = abVar;
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
        fragmentTabHost = this.fzu.bdU;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fzu.blI();
        fragmentTabHost2 = this.fzu.bdU;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.fzu.bdU;
        if (currentTabType != fragmentTabHost3.cy(i).mType) {
            fragmentTabHost9 = this.fzu.bdU;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.fzu.bdU;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.fzu.fzl;
            imageView.setVisibility(8);
            imageView2 = this.fzu.cEn;
            imageView2.setVisibility(0);
        }
        ab abVar = this.fzu;
        fragmentTabHost5 = this.fzu.bdU;
        abVar.dYR = fragmentTabHost5.getCurrentTabType();
        this.fzu.blE();
        if (com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.fzu.bdU;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.fzu.bdU;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.fzu.bdU;
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
