package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.util.Log;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
/* loaded from: classes10.dex */
public class e implements d {
    private final String TAG = "ARMI";

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void onError(int i, int i2, String str) {
        if (a.otP) {
            Log.i("ARMI", "errMsg" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void LX(int i) {
        if (a.otP) {
            Log.i("ARMI", "loginType:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void LY(int i) {
        if (a.otP) {
            Log.i("ARMI", "onSyncSelfStatus type:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void PB() {
        if (a.otP) {
            Log.i("ARMI", "onRoomClosed");
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void hL(long j) {
        if (a.otP) {
            Log.i("ARMI", "onUserJoinRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void hM(long j) {
        if (a.otP) {
            Log.i("ARMI", "onUserLeaveRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void bM(long j) {
        if (a.otP) {
            Log.i("ARMI", "onUserKickOff:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void v(long j, boolean z) {
        if (a.otP) {
            Log.i("ARMI", "imUK:" + j + "     isMute:" + z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        if (a.otP) {
            Log.i("ARMI", "onReciveInvite:" + bIMInviteSyncRtcInfo.getRtcExt() + "    " + bIMInviteSyncRtcInfo.getRtcRoomType());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void b(BIMRtcInfo bIMRtcInfo, int i) {
        if (a.otP) {
            Log.i("ARMI", "onAnswer:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void s(int i, int i2, String str) {
        if (a.otP) {
            Log.i("ARMI", "onSelfPulishStreamStatus:" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void l(int i, long j, String str) {
        if (a.otP) {
            Log.i("ARMI", "onReceiveMessage:" + i);
        }
    }
}
