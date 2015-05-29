package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ak cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cwo = akVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 == 6) goto L12;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        aj ajVar;
        FragmentTabHost fragmentTabHost;
        aj ajVar2;
        aj ajVar3;
        FragmentTabHost fragmentTabHost2;
        aj ajVar4;
        FragmentTabHost fragmentTabHost3;
        aj ajVar5;
        ImageView imageView;
        aj ajVar6;
        ImageView imageView2;
        aj ajVar7;
        ImageView imageView3;
        aj ajVar8;
        ImageView imageView4;
        aj ajVar9;
        int i;
        ajVar = this.cwo.cwn;
        fragmentTabHost = ajVar.aRO;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            ajVar9 = this.cwo.cwn;
            i = ajVar9.cwa;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        ajVar2 = this.cwo.cwn;
        ajVar3 = this.cwo.cwn;
        fragmentTabHost2 = ajVar3.aRO;
        ajVar2.cwa = fragmentTabHost2.getCurrentTabType();
        ajVar4 = this.cwo.cwn;
        fragmentTabHost3 = ajVar4.aRO;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            ajVar7 = this.cwo.cwn;
            imageView3 = ajVar7.cwd;
            imageView3.setVisibility(0);
            ajVar8 = this.cwo.cwn;
            imageView4 = ajVar8.cwg;
            imageView4.setVisibility(8);
            return;
        }
        ajVar5 = this.cwo.cwn;
        imageView = ajVar5.cwd;
        imageView.setVisibility(8);
        ajVar6 = this.cwo.cwn;
        imageView2 = ajVar6.cwg;
        imageView2.setVisibility(0);
    }
}
