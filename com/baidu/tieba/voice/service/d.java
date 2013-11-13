package com.baidu.tieba.voice.service;

import android.content.Intent;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaService f2641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.f2641a = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f2641a.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.f2641a.mElapsedTime;
        if (i != i3) {
            this.f2641a.mElapsedTime = i3 / LocationClientOption.MIN_SCAN_SPAN;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.f2641a.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.f2641a.sendBroadcast(intent);
        }
        handler = this.f2641a.mHandler;
        runnable = this.f2641a.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
