package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class f {
    private IStatusListener aDA;
    private IStatusListener aDB;
    private IStatusListener aDD;
    private IStatusListener aDF;
    private final int aDv = 3;
    private Handler aDw;
    private IStatusListener aDy;
    private IStatusListener aDz;
    private BIMRtcTokenListener otF;

    public f(Handler handler) {
        this.aDw = handler;
    }

    public void generateToken(@NonNull final Context context, final String str, final String str2, final long j, @NonNull final BIMRtcTokenListener bIMRtcTokenListener) {
        if (TextUtils.isEmpty(str2)) {
            bIMRtcTokenListener.onResult(-1, "generateToken roomId is null", new BIMRtcTokenListener.BIMRTCGetTokeResult());
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.otF = new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.1
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
                            BIMRtcClient.generateToken(context, str, str2, j, f.this.otF);
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
        BIMRtcClient.generateToken(context, str, str2, j, this.otF);
    }

    public void join(@NonNull final Context context, @NonNull final String str, final IStatusListener iStatusListener) {
        if (TextUtils.isEmpty(str)) {
            iStatusListener.onResult(-1, "join roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDy = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                f.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.join(context, str, f.this.aDy);
                    }
                });
            }
        };
        BIMRtcClient.join(context, str, this.aDy);
    }

    public void invite(@NonNull final Context context, @NonNull final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        if (bIMInviteRtcInfo == null || TextUtils.isEmpty(bIMInviteRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "invite roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDA = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.invite(context, bIMInviteRtcInfo, f.this.aDA);
                    }
                });
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aDA);
    }

    public void answer(@NonNull final Context context, @NonNull final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        if (bIMAnswerRtcInfo == null || TextUtils.isEmpty(bIMAnswerRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "answer roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDB = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.answer(context, bIMAnswerRtcInfo, f.this.aDB);
                    }
                });
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aDB);
    }

    public void hangout(@NonNull final Context context, @NonNull final String str, final IStatusListener iStatusListener) {
        if (TextUtils.isEmpty(str)) {
            iStatusListener.onResult(-1, "hangout roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDD = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                f.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.hangout(context, str, f.this.aDD);
                    }
                });
            }
        };
        BIMRtcClient.hangout(context, str, this.aDD);
    }

    public void closeRoom(@NonNull final Context context, @NonNull final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        if (bIMCloseRoomRtcInfo == null || TextUtils.isEmpty(bIMCloseRoomRtcInfo.getRtcRoomId())) {
            iStatusListener.onResult(-1, "closeRoom roomId is null");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDF = new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                f.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, f.this.aDF);
                    }
                });
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aDF);
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
        if (this.aDw == null) {
            return false;
        }
        boolean z = true;
        switch (i) {
            case -1:
                this.aDw.post(runnable);
                break;
            case 1004:
                this.aDw.post(runnable);
                break;
            case 1005:
                this.aDw.post(runnable);
                break;
            case 5010:
                this.aDw.post(runnable);
                break;
            case 5011:
                this.aDw.postDelayed(runnable, 1000L);
                break;
            case 5012:
                this.aDw.postDelayed(runnable, 1000L);
                break;
            case 5013:
                this.aDw.postDelayed(runnable, 1000L);
                break;
            case 5014:
                this.aDw.post(runnable);
                break;
            case 5015:
                this.aDw.post(runnable);
                break;
            case 5016:
                this.aDw.post(runnable);
                break;
            case 5017:
                this.aDw.post(runnable);
                break;
            case 5018:
                this.aDw.post(runnable);
                break;
            case 5022:
                this.aDw.post(runnable);
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    public void release() {
        if (this.aDy != null) {
            this.aDy = null;
        }
        if (this.aDA != null) {
            this.aDA = null;
        }
        if (this.aDz != null) {
            this.aDz = null;
        }
        if (this.aDD != null) {
            this.aDD = null;
        }
        if (this.aDF != null) {
            this.aDF = null;
        }
        if (this.aDB != null) {
            this.aDB = null;
        }
    }
}
