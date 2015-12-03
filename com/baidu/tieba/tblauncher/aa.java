package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ViewPager.OnPageChangeListener {
    final /* synthetic */ w dDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.dDs = wVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
        if (r0 == 6) goto L36;
     */
    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        int i2;
        NavigationBar navigationBar;
        NavigationBar navigationBar2;
        NavigationBar navigationBar3;
        NavigationBar navigationBar4;
        fragmentTabHost = this.dDs.blo;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        fragmentTabHost2 = this.dDs.blo;
        if (fragmentTabHost2.getCurrentTabType() == 8) {
            TiebaStatic.log(new av("c10605"));
            navigationBar = this.dDs.mNavigationBar;
            if (navigationBar != null) {
                navigationBar4 = this.dDs.mNavigationBar;
                navigationBar4.setVisibility(8);
            }
            navigationBar2 = this.dDs.dDq;
            if (navigationBar2 != null) {
                navigationBar3 = this.dDs.dDq;
                navigationBar3.setVisibility(8);
            }
        } else {
            this.dDs.ex(this.dDs.ahS());
        }
        fragmentTabHost3 = this.dDs.blo;
        if (fragmentTabHost3.getCurrentTabType() != 6) {
            i2 = this.dDs.ctQ;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        fragmentTabHost4 = this.dDs.blo;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.dDs.dDl;
            imageView.setVisibility(8);
            imageView2 = this.dDs.dDo;
            imageView2.setVisibility(0);
        }
        w wVar = this.dDs;
        fragmentTabHost5 = this.dDs.blo;
        wVar.ctQ = fragmentTabHost5.getCurrentTabType();
        this.dDs.aES();
        if (com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.dDs.blo;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.dDs.blo;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.dDs.blo;
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
