package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ ax cVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.cVr = axVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 == 6) goto L26;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        am amVar;
        FragmentTabHost fragmentTabHost;
        am amVar2;
        am amVar3;
        FragmentTabHost fragmentTabHost2;
        am amVar4;
        FragmentTabHost fragmentTabHost3;
        am amVar5;
        ImageView imageView;
        am amVar6;
        ImageView imageView2;
        am amVar7;
        FragmentTabHost fragmentTabHost4;
        am amVar8;
        FragmentTabHost fragmentTabHost5;
        am amVar9;
        FragmentTabHost fragmentTabHost6;
        am amVar10;
        ImageView imageView3;
        am amVar11;
        ImageView imageView4;
        am amVar12;
        int i;
        amVar = this.cVr.cVq;
        fragmentTabHost = amVar.bdG;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            amVar12 = this.cVr.cVq;
            i = amVar12.bXw;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        amVar2 = this.cVr.cVq;
        amVar3 = this.cVr.cVq;
        fragmentTabHost2 = amVar3.bdG;
        amVar2.bXw = fragmentTabHost2.getCurrentTabType();
        amVar4 = this.cVr.cVq;
        fragmentTabHost3 = amVar4.bdG;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            amVar10 = this.cVr.cVq;
            imageView3 = amVar10.cVh;
            imageView3.setVisibility(0);
            amVar11 = this.cVr.cVq;
            imageView4 = amVar11.cVk;
            imageView4.setVisibility(8);
        } else {
            amVar5 = this.cVr.cVq;
            imageView = amVar5.cVh;
            imageView.setVisibility(8);
            amVar6 = this.cVr.cVq;
            imageView2 = amVar6.cVk;
            imageView2.setVisibility(0);
        }
        if (com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("enter_forum_edit_mode", false)) {
            amVar7 = this.cVr.cVq;
            fragmentTabHost4 = amVar7.bdG;
            if (fragmentTabHost4.getCurrentTabType() != 6) {
                amVar8 = this.cVr.cVq;
                fragmentTabHost5 = amVar8.bdG;
                if (fragmentTabHost5.getCurrentTabType() != 3) {
                    amVar9 = this.cVr.cVq;
                    fragmentTabHost6 = amVar9.bdG;
                    if (fragmentTabHost6.getCurrentTabType() == 2) {
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
}
