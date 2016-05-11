package com.baidu.tieba.onlineDebugger.command;

import android.content.Context;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g dbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dbD = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Character ch;
        Character ch2;
        String str;
        String str2;
        ch = this.dbD.dbC;
        ch2 = g.dbB;
        if (ch.equals(ch2)) {
            Context applicationContext = TbadkCoreApplication.m11getInst().getApplicationContext();
            str2 = this.dbD.msgContent;
            k.l(applicationContext, str2);
            return;
        }
        Context applicationContext2 = TbadkCoreApplication.m11getInst().getApplicationContext();
        str = this.dbD.msgContent;
        k.showToast(applicationContext2, str);
    }
}
