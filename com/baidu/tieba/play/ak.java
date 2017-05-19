package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ aj eSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.eSW = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aWC;
        boolean z;
        String str;
        Context context;
        String str2;
        aWC = this.eSW.aWC();
        if (aWC) {
            context = this.eSW.mContext;
            str2 = this.eSW.eSO;
            at.ae(context, str2);
            return;
        }
        z = this.eSW.eSP;
        if (!z) {
            str = this.eSW.eSO;
            at.gW(str);
        }
    }
}
