package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ aj eTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.eTa = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aYo;
        boolean z;
        String str;
        Context context;
        String str2;
        aYo = this.eTa.aYo();
        if (aYo) {
            context = this.eTa.mContext;
            str2 = this.eTa.eSS;
            at.G(context, str2);
            return;
        }
        z = this.eTa.eST;
        if (!z) {
            str = this.eTa.eSS;
            at.hf(str);
        }
    }
}
