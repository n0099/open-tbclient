package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ViewPager.OnPageChangeListener {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aa aaVar) {
        this.etY = aaVar;
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
        fragmentTabHost = this.etY.aXu;
        if (fragmentTabHost.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.etY.aVq();
        fragmentTabHost2 = this.etY.aXu;
        int currentTabType = fragmentTabHost2.getCurrentTabType();
        fragmentTabHost3 = this.etY.aXu;
        if (currentTabType != fragmentTabHost3.cC(i).mType) {
            fragmentTabHost9 = this.etY.aXu;
            fragmentTabHost9.setCurrentTab(i);
        }
        fragmentTabHost4 = this.etY.aXu;
        if (fragmentTabHost4.getCurrentTabType() != 1) {
            imageView = this.etY.etO;
            imageView.setVisibility(8);
            imageView2 = this.etY.etT;
            imageView2.setVisibility(0);
            this.etY.iT(false);
        } else {
            this.etY.iT(true);
        }
        aa aaVar = this.etY;
        fragmentTabHost5 = this.etY.aXu;
        aaVar.cXR = fragmentTabHost5.getCurrentTabType();
        this.etY.aVn();
        if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost6 = this.etY.aXu;
            if (fragmentTabHost6.getCurrentTabType() != 6) {
                fragmentTabHost7 = this.etY.aXu;
                if (fragmentTabHost7.getCurrentTabType() != 3) {
                    fragmentTabHost8 = this.etY.aXu;
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
