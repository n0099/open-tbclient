package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ak flZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.flZ = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean bce;
        boolean z;
        String str;
        Context context;
        String str2;
        bce = this.flZ.bce();
        if (bce) {
            context = this.flZ.mContext;
            str2 = this.flZ.flR;
            au.af(context, str2);
            return;
        }
        z = this.flZ.flS;
        if (!z) {
            str = this.flZ.flR;
            au.ho(str);
        }
    }
}
