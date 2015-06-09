package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ak cwp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cwp = akVar;
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
        ajVar = this.cwp.cwo;
        fragmentTabHost = ajVar.aRP;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            ajVar9 = this.cwp.cwo;
            i = ajVar9.cwb;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        ajVar2 = this.cwp.cwo;
        ajVar3 = this.cwp.cwo;
        fragmentTabHost2 = ajVar3.aRP;
        ajVar2.cwb = fragmentTabHost2.getCurrentTabType();
        ajVar4 = this.cwp.cwo;
        fragmentTabHost3 = ajVar4.aRP;
        if (fragmentTabHost3.getCurrentTabType() == 1) {
            ajVar7 = this.cwp.cwo;
            imageView3 = ajVar7.cwe;
            imageView3.setVisibility(0);
            ajVar8 = this.cwp.cwo;
            imageView4 = ajVar8.cwh;
            imageView4.setVisibility(8);
            return;
        }
        ajVar5 = this.cwp.cwo;
        imageView = ajVar5.cwe;
        imageView.setVisibility(8);
        ajVar6 = this.cwp.cwo;
        imageView2 = ajVar6.cwh;
        imageView2.setVisibility(0);
    }
}
