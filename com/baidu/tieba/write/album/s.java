package com.baidu.tieba.write.album;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends ContentObserver {
    final /* synthetic */ p this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(p pVar, Handler handler) {
        super(handler);
        this.this$0 = pVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.this$0.handler;
        runnable = this.this$0.fNC;
        handler.removeCallbacks(runnable);
        handler2 = this.this$0.handler;
        runnable2 = this.this$0.fNC;
        handler2.postDelayed(runnable2, 2000L);
    }
}
