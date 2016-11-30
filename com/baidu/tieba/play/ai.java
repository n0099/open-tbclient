package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ ah fgo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.fgo = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean bcU;
        boolean z;
        String str;
        Context context;
        String str2;
        bcU = this.fgo.bcU();
        if (bcU) {
            context = this.fgo.mContext;
            str2 = this.fgo.fgf;
            ar.G(context, str2);
            return;
        }
        z = this.fgo.fgh;
        if (!z) {
            str = this.fgo.fgf;
            ar.hj(str);
        }
    }
}
