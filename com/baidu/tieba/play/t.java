package com.baidu.tieba.play;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s eZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.eZb = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean baw;
        boolean z;
        String str;
        Context context;
        String str2;
        baw = this.eZb.baw();
        if (baw) {
            context = this.eZb.mContext;
            str2 = this.eZb.eYT;
            y.G(context, str2);
            return;
        }
        z = this.eZb.eYV;
        if (!z) {
            str = this.eZb.eYT;
            y.hi(str);
        }
    }
}
