package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ak fbJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.fbJ = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aXT;
        boolean z;
        String str;
        Context context;
        String str2;
        aXT = this.fbJ.aXT();
        if (aXT) {
            context = this.fbJ.mContext;
            str2 = this.fbJ.fbB;
            au.ae(context, str2);
            return;
        }
        z = this.fbJ.fbC;
        if (!z) {
            str = this.fbJ.fbB;
            au.gR(str);
        }
    }
}
