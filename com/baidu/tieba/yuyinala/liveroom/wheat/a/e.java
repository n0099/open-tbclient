package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.util.Log;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
/* loaded from: classes4.dex */
public class e implements d {
    private final String TAG = "ARMI";

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void onError(int i, int i2, String str) {
        if (a.obo) {
            Log.i("ARMI", "errMsg" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Ms(int i) {
        if (a.obo) {
            Log.i("ARMI", "loginType:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Mt(int i) {
        if (a.obo) {
            Log.i("ARMI", "onSyncSelfStatus type:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void QD() {
        if (a.obo) {
            Log.i("ARMI", "onRoomClosed");
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void hj(long j) {
        if (a.obo) {
            Log.i("ARMI", "onUserJoinRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void hk(long j) {
        if (a.obo) {
            Log.i("ARMI", "onUserLeaveRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void bm(long j) {
        if (a.obo) {
            Log.i("ARMI", "onUserKickOff:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void t(long j, boolean z) {
        if (a.obo) {
            Log.i("ARMI", "imUK:" + j + "     isMute:" + z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        if (a.obo) {
            Log.i("ARMI", "onReciveInvite:" + bIMInviteSyncRtcInfo.getRtcExt() + "    " + bIMInviteSyncRtcInfo.getRtcRoomType());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void b(BIMRtcInfo bIMRtcInfo, int i) {
        if (a.obo) {
            Log.i("ARMI", "onAnswer:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void r(int i, int i2, String str) {
        if (a.obo) {
            Log.i("ARMI", "onSelfPulishStreamStatus:" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void j(int i, long j, String str) {
        if (a.obo) {
            Log.i("ARMI", "onReceiveMessage:" + i);
        }
    }
}
