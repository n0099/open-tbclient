package com.baidu.tieba.signall;

import android.content.Context;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ s dre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.dre = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        ProgressBar progressBar;
        context = this.dre.mContext;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
        context2 = this.dre.mContext;
        int dip2px2 = com.baidu.adp.lib.util.k.dip2px(context2, 100.0f);
        int i = dip2px2 - (dip2px * 2);
        int i2 = (dip2px2 - i) / 2;
        progressBar = this.dre.mProgress;
        progressBar.getProgressDrawable().setBounds(i2, i2, i2 + i, i + i2);
    }
}
