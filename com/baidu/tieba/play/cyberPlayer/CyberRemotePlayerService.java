package com.baidu.tieba.play.cyberPlayer;

import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
/* loaded from: classes.dex */
public class CyberRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        long cRy = c.cRy();
        if (cRy == 0) {
            c.init();
            return c.cRy();
        }
        return cRy;
    }
}
