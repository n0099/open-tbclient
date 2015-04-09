package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj cse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.cse = ajVar;
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
        aiVar = this.cse.csd;
        fragmentTabHost = aiVar.aPD;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aiVar4 = this.cse.csd;
            i = aiVar4.crR;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        aiVar2 = this.cse.csd;
        aiVar3 = this.cse.csd;
        fragmentTabHost2 = aiVar3.aPD;
        aiVar2.crR = fragmentTabHost2.getCurrentTabType();
    }
}
