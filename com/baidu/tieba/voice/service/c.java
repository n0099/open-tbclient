package com.baidu.tieba.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaService f2049a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaService mediaService) {
        this.f2049a = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        g gVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.f2049a.mHandler;
        if (handler == null) {
            return;
        }
        gVar = this.f2049a.mPlayer;
        int e = gVar.e();
        i = this.f2049a.mCurBeginSecond;
        int i4 = e + i;
        i2 = this.f2049a.mElapsedTime;
        if (i4 != i2) {
            this.f2049a.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.f2049a.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.f2049a.sendBroadcast(intent);
        }
        handler2 = this.f2049a.mHandler;
        runnable = this.f2049a.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
