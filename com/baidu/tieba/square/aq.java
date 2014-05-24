package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ak akVar) {
        this.a = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        az azVar;
        try {
            azVar = this.a.c;
            azVar.a();
        } catch (Exception e) {
            BdLog.e("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
