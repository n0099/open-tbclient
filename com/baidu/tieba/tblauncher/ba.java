package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ az dcZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.dcZ = azVar;
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
        aoVar = this.dcZ.dcY;
        fragmentTabHost = aoVar.bdT;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aoVar12 = this.dcZ.dcY;
            i = aoVar12.cbi;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        aoVar2 = this.dcZ.dcY;
        aoVar3 = this.dcZ.dcY;
        fragmentTabHost2 = aoVar3.bdT;
        aoVar2.cbi = fragmentTabHost2.getCurrentTabType();
        aoVar4 = this.dcZ.dcY;
        fragmentTabHost3 = aoVar4.bdT;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            aoVar10 = this.dcZ.dcY;
            imageView3 = aoVar10.dcP;
            imageView3.setVisibility(0);
            aoVar11 = this.dcZ.dcY;
            imageView4 = aoVar11.dcS;
            imageView4.setVisibility(8);
        } else {
            aoVar5 = this.dcZ.dcY;
            imageView = aoVar5.dcP;
            imageView.setVisibility(8);
            aoVar6 = this.dcZ.dcY;
            imageView2 = aoVar6.dcS;
            imageView2.setVisibility(0);
        }
        if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("enter_forum_edit_mode", false)) {
            aoVar7 = this.dcZ.dcY;
            fragmentTabHost4 = aoVar7.bdT;
            if (fragmentTabHost4.getCurrentTabType() != 6) {
                aoVar8 = this.dcZ.dcY;
                fragmentTabHost5 = aoVar8.bdT;
                if (fragmentTabHost5.getCurrentTabType() != 3) {
                    aoVar9 = this.dcZ.dcY;
                    fragmentTabHost6 = aoVar9.bdT;
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
