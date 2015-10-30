package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ az ddz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.ddz = azVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 == 6) goto L26;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ao aoVar;
        FragmentTabHost fragmentTabHost;
        ao aoVar2;
        ao aoVar3;
        FragmentTabHost fragmentTabHost2;
        ao aoVar4;
        FragmentTabHost fragmentTabHost3;
        ao aoVar5;
        ImageView imageView;
        ao aoVar6;
        ImageView imageView2;
        ao aoVar7;
        FragmentTabHost fragmentTabHost4;
        ao aoVar8;
        FragmentTabHost fragmentTabHost5;
        ao aoVar9;
        FragmentTabHost fragmentTabHost6;
        ao aoVar10;
        ImageView imageView3;
        ao aoVar11;
        ImageView imageView4;
        ao aoVar12;
        int i;
        aoVar = this.ddz.ddy;
        fragmentTabHost = aoVar.bee;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aoVar12 = this.ddz.ddy;
            i = aoVar12.cbt;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        aoVar2 = this.ddz.ddy;
        aoVar3 = this.ddz.ddy;
        fragmentTabHost2 = aoVar3.bee;
        aoVar2.cbt = fragmentTabHost2.getCurrentTabType();
        aoVar4 = this.ddz.ddy;
        fragmentTabHost3 = aoVar4.bee;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            aoVar10 = this.ddz.ddy;
            imageView3 = aoVar10.ddp;
            imageView3.setVisibility(0);
            aoVar11 = this.ddz.ddy;
            imageView4 = aoVar11.dds;
            imageView4.setVisibility(8);
        } else {
            aoVar5 = this.ddz.ddy;
            imageView = aoVar5.ddp;
            imageView.setVisibility(8);
            aoVar6 = this.ddz.ddy;
            imageView2 = aoVar6.dds;
            imageView2.setVisibility(0);
        }
        if (com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("enter_forum_edit_mode", false)) {
            aoVar7 = this.ddz.ddy;
            fragmentTabHost4 = aoVar7.bee;
            if (fragmentTabHost4.getCurrentTabType() != 6) {
                aoVar8 = this.ddz.ddy;
                fragmentTabHost5 = aoVar8.bee;
                if (fragmentTabHost5.getCurrentTabType() != 3) {
                    aoVar9 = this.ddz.ddy;
                    fragmentTabHost6 = aoVar9.bee;
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
