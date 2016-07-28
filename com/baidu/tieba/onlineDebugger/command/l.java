package com.baidu.tieba.onlineDebugger.command;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k dUt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dUt = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Character ch;
        Character ch2;
        String str;
        String str2;
        ch = this.dUt.dUs;
        ch2 = k.dUr;
        if (ch.equals(ch2)) {
            Context applicationContext = TbadkCoreApplication.m10getInst().getApplicationContext();
            str2 = this.dUt.msgContent;
            com.baidu.adp.lib.util.k.m(applicationContext, str2);
            return;
        }
        Context applicationContext2 = TbadkCoreApplication.m10getInst().getApplicationContext();
        str = this.dUt.msgContent;
        com.baidu.adp.lib.util.k.showToast(applicationContext2, str);
    }
}
