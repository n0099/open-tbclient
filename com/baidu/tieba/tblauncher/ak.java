package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj crO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.crO = ajVar;
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
        aiVar = this.crO.crN;
        fragmentTabHost = aiVar.aPm;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            aiVar4 = this.crO.crN;
            i = aiVar4.crB;
        }
        TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
        aiVar2 = this.crO.crN;
        aiVar3 = this.crO.crN;
        fragmentTabHost2 = aiVar3.aPm;
        aiVar2.crB = fragmentTabHost2.getCurrentTabType();
    }
}
