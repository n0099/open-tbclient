package com.baidu.tieba.write.album;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends ContentObserver {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(o oVar, Handler handler) {
        super(handler);
        this.this$0 = oVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.this$0.handler;
        runnable = this.this$0.cum;
        handler.removeCallbacks(runnable);
        handler2 = this.this$0.handler;
        runnable2 = this.this$0.cum;
        handler2.postDelayed(runnable2, 2000L);
    }
}
