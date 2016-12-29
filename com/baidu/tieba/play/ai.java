package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ ah eJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.eJG = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aWB;
        boolean z;
        String str;
        Context context;
        String str2;
        aWB = this.eJG.aWB();
        if (aWB) {
            context = this.eJG.mContext;
            str2 = this.eJG.eJx;
            ar.G(context, str2);
            return;
        }
        z = this.eJG.eJz;
        if (!z) {
            str = this.eJG.eJx;
            ar.he(str);
        }
    }
}
