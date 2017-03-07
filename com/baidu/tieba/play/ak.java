package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ aj eWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.eWH = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aXT;
        boolean z;
        String str;
        Context context;
        String str2;
        aXT = this.eWH.aXT();
        if (aXT) {
            context = this.eWH.mContext;
            str2 = this.eWH.eWz;
            at.aa(context, str2);
            return;
        }
        z = this.eWH.eWA;
        if (!z) {
            str = this.eWH.eWz;
            at.gU(str);
        }
    }
}
