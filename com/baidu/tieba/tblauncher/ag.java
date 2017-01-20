package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements ViewPager.OnPageChangeListener {
    final /* synthetic */ aa fuh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(aa aaVar) {
        this.fuh = aaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0 == (-1)) goto L28;
     */
    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageSelected(int i) {
        int i2;
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
        int i3;
        i2 = this.fuh.dSu;
        if (i2 != 2) {
            i3 = this.fuh.dSu;
        }
        fragmentTabHost = this.fuh.bto;
        if (fragmentTabHost.getCurrentTabType() != 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP, false));
        }
        fragmentTabHost2 = this.fuh.bto;
        if (fragmentTabHost2.getCurrentTabType() == 2) {
            TiebaStatic.log("kantie_entry");
        }
        this.fuh.bjC();
        fragmentTabHost3 = this.fuh.bto;
        int currentTabType = fragmentTabHost3.getCurrentTabType();
        fragmentTabHost4 = this.fuh.bto;
        if (currentTabType != fragmentTabHost4.cA(i).mType) {
            fragmentTabHost10 = this.fuh.bto;
            fragmentTabHost10.setCurrentTab(i);
        }
        fragmentTabHost5 = this.fuh.bto;
        if (fragmentTabHost5.getCurrentTabType() != 1) {
            imageView = this.fuh.fub;
            imageView.setVisibility(8);
            imageView2 = this.fuh.aSh;
            imageView2.setVisibility(0);
        }
        aa aaVar = this.fuh;
        fragmentTabHost6 = this.fuh.bto;
        aaVar.dSu = fragmentTabHost6.getCurrentTabType();
        this.fuh.bjz();
        if (com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("enter_forum_edit_mode", false)) {
            fragmentTabHost8 = this.fuh.bto;
            if (fragmentTabHost8.getCurrentTabType() != 3) {
                fragmentTabHost9 = this.fuh.bto;
                if (fragmentTabHost9.getCurrentTabType() == 2) {
                    TiebaStatic.log("c10098");
                }
            } else {
                TiebaStatic.log("c10149");
            }
        }
        fragmentTabHost7 = this.fuh.bto;
        if (fragmentTabHost7.getCurrentTabType() == 3) {
            TiebaStatic.log(new ar("view_msg").ab("nobatch", "1"));
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
