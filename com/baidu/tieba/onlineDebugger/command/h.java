package com.baidu.tieba.onlineDebugger.command;

import android.content.Context;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g cvQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cvQ = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Context applicationContext = TbadkCoreApplication.m411getInst().getApplicationContext();
        str = this.cvQ.msgContent;
        k.showToast(applicationContext, str);
    }
}
