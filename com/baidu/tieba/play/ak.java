package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ aj eWW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.eWW = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aZd;
        boolean z;
        String str;
        Context context;
        String str2;
        aZd = this.eWW.aZd();
        if (aZd) {
            context = this.eWW.mContext;
            str2 = this.eWW.eWO;
            at.ae(context, str2);
            return;
        }
        z = this.eWW.eWP;
        if (!z) {
            str = this.eWW.eWO;
            at.gY(str);
        }
    }
}
