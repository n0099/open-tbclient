package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar) {
        this.a = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        au auVar;
        try {
            auVar = this.a.c;
            auVar.a();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
