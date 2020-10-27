package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.util.Log;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
/* loaded from: classes4.dex */
public class e implements d {
    private final String TAG = "ARMI";

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void onError(int i, int i2, String str) {
        if (a.nTZ) {
            Log.i("ARMI", "errMsg" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Mb(int i) {
        if (a.nTZ) {
            Log.i("ARMI", "loginType:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Mc(int i) {
        if (a.nTZ) {
            Log.i("ARMI", "onSyncSelfStatus type:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void dWe() {
        if (a.nTZ) {
            Log.i("ARMI", "onRoomClosed");
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void gN(long j) {
        if (a.nTZ) {
            Log.i("ARMI", "onUserJoinRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void gO(long j) {
        if (a.nTZ) {
            Log.i("ARMI", "onUserLeaveRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void aQ(long j) {
        if (a.nTZ) {
            Log.i("ARMI", "onUserKickOff:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void t(long j, boolean z) {
        if (a.nTZ) {
            Log.i("ARMI", "imUK:" + j + "     isMute:" + z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        if (a.nTZ) {
            Log.i("ARMI", "onReciveInvite:" + bIMInviteSyncRtcInfo.getRtcExt() + "    " + bIMInviteSyncRtcInfo.getRtcRoomType());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void b(BIMRtcInfo bIMRtcInfo, int i) {
        if (a.nTZ) {
            Log.i("ARMI", "onAnswer:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void r(int i, int i2, String str) {
        if (a.nTZ) {
            Log.i("ARMI", "onSelfPulishStreamStatus:" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void e(int i, long j, String str) {
        if (a.nTZ) {
            Log.i("ARMI", "onReceiveMessage:" + i);
        }
    }
}
