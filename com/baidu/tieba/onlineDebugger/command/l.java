package com.baidu.tieba.onlineDebugger.command;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k ebR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ebR = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Character ch;
        Character ch2;
        String str;
        String str2;
        ch = this.ebR.ebQ;
        ch2 = k.ebP;
        if (ch.equals(ch2)) {
            Context applicationContext = TbadkCoreApplication.m9getInst().getApplicationContext();
            str2 = this.ebR.msgContent;
            com.baidu.adp.lib.util.k.m(applicationContext, str2);
            return;
        }
        Context applicationContext2 = TbadkCoreApplication.m9getInst().getApplicationContext();
        str = this.ebR.msgContent;
        com.baidu.adp.lib.util.k.showToast(applicationContext2, str);
    }
}
