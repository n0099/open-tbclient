package com.baidu.tieba.voice.service;

import android.content.Intent;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaService f2050a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.f2050a = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f2050a.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.f2050a.mElapsedTime;
        if (i != i3) {
            this.f2050a.mElapsedTime = i3 / LocationClientOption.MIN_SCAN_SPAN;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.f2050a.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.f2050a.sendBroadcast(intent);
        }
        handler = this.f2050a.mHandler;
        runnable = this.f2050a.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
