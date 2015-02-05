package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.cdw = ajVar;
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
        aiVar = this.cdw.cdv;
        fragmentTabHost = aiVar.aJm;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aiVar4 = this.cdw.cdv;
            i = aiVar4.cdl;
        }
        TbadkCoreApplication.m255getInst().setFriendFeedNew(false);
        aiVar2 = this.cdw.cdv;
        aiVar3 = this.cdw.cdv;
        fragmentTabHost2 = aiVar3.aJm;
        aiVar2.cdl = fragmentTabHost2.getCurrentTabType();
    }
}
