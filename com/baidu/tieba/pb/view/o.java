package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ l eLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.eLV = lVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        t tVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        i = this.eLV.eLQ;
        if (i == 2) {
            tVar = this.eLV.eLL;
            if (!tVar.anx()) {
                handler = this.eLV.mHandler;
                runnable = this.eLV.eLT;
                handler.removeCallbacks(runnable);
                handler2 = this.eLV.mHandler;
                runnable2 = this.eLV.eLT;
                handler2.postDelayed(runnable2, 200L);
            }
        }
    }
}
