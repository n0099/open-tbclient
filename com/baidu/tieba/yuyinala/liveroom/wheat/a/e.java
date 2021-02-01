package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.util.Log;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
/* loaded from: classes11.dex */
public class e implements d {
    private final String TAG = "ARMI";

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void onError(int i, int i2, String str) {
        if (a.oDA) {
            Log.i("ARMI", "errMsg" + str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Mt(int i) {
        if (a.oDA) {
            Log.i("ARMI", "loginType:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Mu(int i) {
        if (a.oDA) {
            Log.i("ARMI", "onSyncSelfStatus type:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void Rl() {
        if (a.oDA) {
            Log.i("ARMI", "onRoomClosed");
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void hO(long j) {
        if (a.oDA) {
            Log.i("ARMI", "onUserJoinRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void hP(long j) {
        if (a.oDA) {
            Log.i("ARMI", "onUserLeaveRTCRoom:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void bQ(long j) {
        if (a.oDA) {
            Log.i("ARMI", "onUserKickOff:" + j);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void u(long j, boolean z) {
        if (a.oDA) {
            Log.i("ARMI", "imUK:" + j + "     isMute:" + z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        if (a.oDA) {
            Log.i("ARMI", "onReciveInvite:" + bIMInviteSyncRtcInfo.getRtcExt() + "    " + bIMInviteSyncRtcInfo.getRtcRoomType());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void b(BIMRtcInfo bIMRtcInfo, int i) {
        if (a.oDA) {
            Log.i("ARMI", "onAnswer:" + i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.d
    public void g(int i, long j, String str) {
        if (a.oDA) {
            Log.i("ARMI", "onReceiveMessage:" + i);
        }
    }
}
