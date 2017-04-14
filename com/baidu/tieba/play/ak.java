package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ aj eUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.eUG = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean aYc;
        boolean z;
        String str;
        Context context;
        String str2;
        aYc = this.eUG.aYc();
        if (aYc) {
            context = this.eUG.mContext;
            str2 = this.eUG.eUy;
            at.ae(context, str2);
            return;
        }
        z = this.eUG.eUz;
        if (!z) {
            str = this.eUG.eUy;
            at.gY(str);
        }
    }
}
