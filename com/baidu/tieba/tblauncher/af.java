package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements ViewPager.OnPageChangeListener {
    final /* synthetic */ y ebe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(y yVar) {
        this.ebe = yVar;
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
        fragmentTabHost = this.ebe.aTI;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.ebe.aOo();
        fragmentTabHost2 = this.ebe.aTI;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.ebe.aTI;
        if (currentTabType != fragmentTabHost3.cz(i).mType) {
            fragmentTabHost9 = this.ebe.aTI;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.ebe.aTI;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.ebe.eaU;
            imageView.setVisibility(8);
            imageView2 = this.ebe.eaZ;
            imageView2.setVisibility(0);
            this.ebe.id(false);
        } else {
            this.ebe.id(true);
        }
        y yVar = this.ebe;
        fragmentTabHost5 = this.ebe.aTI;
        yVar.cEz = fragmentTabHost5.getCurrentTabType();
        this.ebe.aOl();
        if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.ebe.aTI;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.ebe.aTI;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.ebe.aTI;
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
