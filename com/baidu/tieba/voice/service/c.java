package com.baidu.tieba.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
final class c implements Runnable {
    final /* synthetic */ MediaService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaService mediaService) {
        this.a = mediaService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        g gVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.a.mHandler;
        if (handler == null) {
            return;
        }
        gVar = this.a.mPlayer;
        int e = gVar.e();
        i = this.a.mCurBeginSecond;
        int i4 = e + i;
        i2 = this.a.mElapsedTime;
        if (i4 != i2) {
            this.a.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.a.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.a.sendBroadcast(intent);
        }
        handler2 = this.a.mHandler;
        runnable = this.a.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
