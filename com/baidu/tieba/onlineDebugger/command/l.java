package com.baidu.tieba.onlineDebugger.command;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k dSY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dSY = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Character ch;
        Character ch2;
        String str;
        String str2;
        ch = this.dSY.dSX;
        ch2 = k.dSW;
        if (ch.equals(ch2)) {
            Context applicationContext = TbadkCoreApplication.m9getInst().getApplicationContext();
            str2 = this.dSY.msgContent;
            com.baidu.adp.lib.util.k.m(applicationContext, str2);
            return;
        }
        Context applicationContext2 = TbadkCoreApplication.m9getInst().getApplicationContext();
        str = this.dSY.msgContent;
        com.baidu.adp.lib.util.k.showToast(applicationContext2, str);
    }
}
