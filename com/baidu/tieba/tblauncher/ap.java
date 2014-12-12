package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ap implements Runnable {
    final /* synthetic */ ao ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.ccd = aoVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 == 6) goto L8;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        an anVar;
        FragmentTabHost fragmentTabHost;
        an anVar2;
        an anVar3;
        FragmentTabHost fragmentTabHost2;
        an anVar4;
        int i;
        anVar = this.ccd.ccc;
        fragmentTabHost = anVar.aIf;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            anVar4 = this.ccd.ccc;
            i = anVar4.cbH;
        }
        TbadkCoreApplication.m255getInst().setFriendFeedNew(false);
        anVar2 = this.ccd.ccc;
        anVar3 = this.ccd.ccc;
        fragmentTabHost2 = anVar3.aIf;
        anVar2.cbH = fragmentTabHost2.getCurrentTabType();
    }
}
