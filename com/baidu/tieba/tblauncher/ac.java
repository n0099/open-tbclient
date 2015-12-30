package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements ViewPager.OnPageChangeListener {
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar) {
        this.dKW = wVar;
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
        fragmentTabHost = this.dKW.bpf;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.dKW.aHj();
        fragmentTabHost2 = this.dKW.bpf;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.dKW.bpf;
        if (currentTabType != fragmentTabHost3.ce(i).mType) {
            fragmentTabHost8 = this.dKW.bpf;
            fragmentTabHost8.setCurrentTab(i);
        }
        w wVar = this.dKW;
        fragmentTabHost4 = this.dKW.bpf;
        wVar.cxS = fragmentTabHost4.getCurrentTabType();
        this.dKW.aHg();
        if (com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost5 = this.dKW.bpf;
            if (fragmentTabHost5.getCurrentTabType() != 6) {
                fragmentTabHost6 = this.dKW.bpf;
                if (fragmentTabHost6.getCurrentTabType() != 3) {
                    fragmentTabHost7 = this.dKW.bpf;
                    if (fragmentTabHost7.getCurrentTabType() == 2) {
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
