package com.baidu.tieba.play.cyberPlayer;

import android.content.Intent;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import d.b.i0.i2.p.c;
/* loaded from: classes5.dex */
public class CyberRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        long e2 = c.e();
        if (e2 == 0) {
            c.f();
            return c.e();
        }
        return e2;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getBooleanExtra("pcdn", false)) {
            c.f();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
