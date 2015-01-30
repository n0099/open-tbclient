package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj cdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.cdx = ajVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 == 6) goto L8;
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
        int i;
        aiVar = this.cdx.cdw;
        fragmentTabHost = aiVar.aJp;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aiVar4 = this.cdx.cdw;
            i = aiVar4.cdm;
        }
        TbadkCoreApplication.m255getInst().setFriendFeedNew(false);
        aiVar2 = this.cdx.cdw;
        aiVar3 = this.cdx.cdw;
        fragmentTabHost2 = aiVar3.aJp;
        aiVar2.cdm = fragmentTabHost2.getCurrentTabType();
    }
}
