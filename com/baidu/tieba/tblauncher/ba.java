package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ az dfI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.dfI = azVar;
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
        aoVar = this.dfI.dfH;
        fragmentTabHost = aoVar.beK;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aoVar12 = this.dfI.dfH;
            i = aoVar12.cbU;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        aoVar2 = this.dfI.dfH;
        aoVar3 = this.dfI.dfH;
        fragmentTabHost2 = aoVar3.beK;
        aoVar2.cbU = fragmentTabHost2.getCurrentTabType();
        aoVar4 = this.dfI.dfH;
        fragmentTabHost3 = aoVar4.beK;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            aoVar10 = this.dfI.dfH;
            imageView3 = aoVar10.dfy;
            imageView3.setVisibility(0);
            aoVar11 = this.dfI.dfH;
            imageView4 = aoVar11.dfB;
            imageView4.setVisibility(8);
        } else {
            aoVar5 = this.dfI.dfH;
            imageView = aoVar5.dfy;
            imageView.setVisibility(8);
            aoVar6 = this.dfI.dfH;
            imageView2 = aoVar6.dfB;
            imageView2.setVisibility(0);
        }
        if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("enter_forum_edit_mode", false)) {
            aoVar7 = this.dfI.dfH;
            fragmentTabHost4 = aoVar7.beK;
            if (fragmentTabHost4.getCurrentTabType() != 6) {
                aoVar8 = this.dfI.dfH;
                fragmentTabHost5 = aoVar8.beK;
                if (fragmentTabHost5.getCurrentTabType() != 3) {
                    aoVar9 = this.dfI.dfH;
                    fragmentTabHost6 = aoVar9.beK;
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
