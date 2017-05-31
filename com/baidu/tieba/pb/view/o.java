package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ l eCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.eCy = lVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        t tVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        i = this.eCy.eCt;
        if (i == 2) {
            tVar = this.eCy.eCo;
            if (!tVar.ajM()) {
                handler = this.eCy.mHandler;
                runnable = this.eCy.eCw;
                handler.removeCallbacks(runnable);
                handler2 = this.eCy.mHandler;
                runnable2 = this.eCy.eCw;
                handler2.postDelayed(runnable2, 200L);
            }
        }
    }
}
