package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class f {
    private final int aDM = 3;
    private Handler aDN;
    private IStatusListener aDP;
    private IStatusListener aDQ;
    private IStatusListener aDR;
    private IStatusListener aDS;
    private IStatusListener aDU;
    private IStatusListener aDW;
    private BIMRtcTokenListener oAk;

    public f(Handler handler) {
        this.aDN = handler;
    }

    public void generateToken(@NonNull final Context context, final String str, final String str2, final long j, @NonNull final BIMRtcTokenListener bIMRtcTokenListener) {
        if (TextUtils.isEmpty(str2)) {
            bIMRtcTokenListener.onResult(-1, "generateToken roomId is null", new BIMRtcTokenListener.BIMRTCGetTokeResult());
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.oAk = new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str3, @NonNull BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str3, bIMRTCGetTokeResult);
                    }
                } else if (atomicInteger.get() < 3) {
                    if (f.this.b(i, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.generateToken(context, str, str2, j, f.this.oAk);
                        }
                    })) {
                        atomicInteger.incrementAndGet();
                    } else if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str3, bIMRTCGetTokeResult);
                    }
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, str3, bIMRTCGetTokeResult);
                }
            }
        };
        BIMRtcClient.generateToken(context, str, str2, j, this.oAk);
    }

    public void join(@NonNull final Context context, @NonNull final String str, final IStatusListener iStatusListener) {
        if (TextUtils.isEmpty(str)) {
            iStatusListener.onResult(-1, "join roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDP = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                f.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.join(context, str, f.this.aDP);
                    }
                });
            }
        };
        BIMRtcClient.join(context, str, this.aDP);
    }

    public void invite(@NonNull final Context context, @NonNull final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        if (bIMInviteRtcInfo == null || TextUtils.isEmpty(bIMInviteRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "invite roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDR = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.invite(context, bIMInviteRtcInfo, f.this.aDR);
                    }
                });
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aDR);
    }

    public void answer(@NonNull final Context context, @NonNull final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        if (bIMAnswerRtcInfo == null || TextUtils.isEmpty(bIMAnswerRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "answer roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDS = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.answer(context, bIMAnswerRtcInfo, f.this.aDS);
                    }
                });
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aDS);
    }

    public void cancelCall(@NonNull final Context context, @NonNull final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        if (bIMCancelRtcInfo == null || TextUtils.isEmpty(bIMCancelRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "cancelCall roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDQ = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, f.this.aDQ);
                    }
                });
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.aDQ);
    }

    public void hangout(@NonNull final Context context, @NonNull final String str, final IStatusListener iStatusListener) {
        if (TextUtils.isEmpty(str)) {
            iStatusListener.onResult(-1, "hangout roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDU = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                f.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.hangout(context, str, f.this.aDU);
                    }
                });
            }
        };
        BIMRtcClient.hangout(context, str, this.aDU);
    }

    public void closeRoom(@NonNull final Context context, @NonNull final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        if (bIMCloseRoomRtcInfo == null || TextUtils.isEmpty(bIMCloseRoomRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "closeRoom roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDW = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, f.this.aDW);
                    }
                });
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aDW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, AtomicInteger atomicInteger, IStatusListener iStatusListener, Runnable runnable) {
        if (i == 0) {
            if (iStatusListener != null) {
                iStatusListener.onResult(i, str);
            }
        } else if (atomicInteger.get() < 3) {
            if (b(i, runnable)) {
                atomicInteger.incrementAndGet();
            } else if (iStatusListener != null) {
                iStatusListener.onResult(i, str);
            }
        } else if (iStatusListener != null) {
            iStatusListener.onResult(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, Runnable runnable) {
        if (this.aDN == null) {
            return false;
        }
        boolean z = true;
        switch (i) {
            case -1:
                this.aDN.post(runnable);
                break;
            case 1004:
                this.aDN.post(runnable);
                break;
            case 1005:
                this.aDN.post(runnable);
                break;
            case 5010:
                this.aDN.post(runnable);
                break;
            case 5011:
                this.aDN.postDelayed(runnable, 1000L);
                break;
            case 5012:
                this.aDN.postDelayed(runnable, 1000L);
                break;
            case 5013:
                this.aDN.postDelayed(runnable, 1000L);
                break;
            case 5014:
                this.aDN.post(runnable);
                break;
            case 5015:
                this.aDN.post(runnable);
                break;
            case 5016:
                this.aDN.post(runnable);
                break;
            case 5017:
                this.aDN.post(runnable);
                break;
            case 5018:
                this.aDN.post(runnable);
                break;
            case 5020:
                this.aDN.postDelayed(runnable, 1000L);
                break;
            case 5022:
                this.aDN.post(runnable);
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    public void release() {
        if (this.aDP != null) {
            this.aDP = null;
        }
        if (this.aDR != null) {
            this.aDR = null;
        }
        if (this.aDQ != null) {
            this.aDQ = null;
        }
        if (this.aDU != null) {
            this.aDU = null;
        }
        if (this.aDW != null) {
            this.aDW = null;
        }
        if (this.aDS != null) {
            this.aDS = null;
        }
    }
}
