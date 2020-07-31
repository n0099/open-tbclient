package com.baidu.tieba.play.cyberPlayer;

import android.content.Intent;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
/* loaded from: classes.dex */
public class CyberRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getBooleanExtra("pcdn", false)) {
            c.init();
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        long cZs = c.cZs();
        if (cZs == 0) {
            c.init();
            return c.cZs();
        }
        return cZs;
    }
}
