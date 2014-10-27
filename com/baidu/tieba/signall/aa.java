package com.baidu.tieba.signall;

import android.content.Context;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ x bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.bLC = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        ProgressBar progressBar;
        context = this.bLC.mContext;
        int dip2px = com.baidu.adp.lib.util.m.dip2px(context, 6.0f);
        context2 = this.bLC.mContext;
        int dip2px2 = com.baidu.adp.lib.util.m.dip2px(context2, 100.0f);
        int i = dip2px2 - (dip2px * 2);
        int i2 = (dip2px2 - i) / 2;
        progressBar = this.bLC.mProgress;
        progressBar.getProgressDrawable().setBounds(i2, i2, i2 + i, i + i2);
    }
}
