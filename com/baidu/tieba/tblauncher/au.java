package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class au implements Runnable {
    final /* synthetic */ at cMR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.cMR = atVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 == 6) goto L26;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ai aiVar;
        FragmentTabHost fragmentTabHost;
        ai aiVar2;
        ai aiVar3;
        FragmentTabHost fragmentTabHost2;
        ai aiVar4;
        FragmentTabHost fragmentTabHost3;
        ai aiVar5;
        ImageView imageView;
        ai aiVar6;
        ImageView imageView2;
        ai aiVar7;
        FragmentTabHost fragmentTabHost4;
        ai aiVar8;
        FragmentTabHost fragmentTabHost5;
        ai aiVar9;
        FragmentTabHost fragmentTabHost6;
        ai aiVar10;
        ImageView imageView3;
        ai aiVar11;
        ImageView imageView4;
        ai aiVar12;
        int i;
        aiVar = this.cMR.cMQ;
        fragmentTabHost = aiVar.bdl;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aiVar12 = this.cMR.cMQ;
            i = aiVar12.cMC;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        aiVar2 = this.cMR.cMQ;
        aiVar3 = this.cMR.cMQ;
        fragmentTabHost2 = aiVar3.bdl;
        aiVar2.cMC = fragmentTabHost2.getCurrentTabType();
        aiVar4 = this.cMR.cMQ;
        fragmentTabHost3 = aiVar4.bdl;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            aiVar10 = this.cMR.cMQ;
            imageView3 = aiVar10.cMG;
            imageView3.setVisibility(0);
            aiVar11 = this.cMR.cMQ;
            imageView4 = aiVar11.cMJ;
            imageView4.setVisibility(8);
        } else {
            aiVar5 = this.cMR.cMQ;
            imageView = aiVar5.cMG;
            imageView.setVisibility(8);
            aiVar6 = this.cMR.cMQ;
            imageView2 = aiVar6.cMJ;
            imageView2.setVisibility(0);
        }
        if (com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("enter_forum_edit_mode", false)) {
            aiVar7 = this.cMR.cMQ;
            fragmentTabHost4 = aiVar7.bdl;
            if (fragmentTabHost4.getCurrentTabType() != 6) {
                aiVar8 = this.cMR.cMQ;
                fragmentTabHost5 = aiVar8.bdl;
                if (fragmentTabHost5.getCurrentTabType() != 3) {
                    aiVar9 = this.cMR.cMQ;
                    fragmentTabHost6 = aiVar9.bdl;
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
