package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.rtc.RtcRoomListener;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private Context mContext;
    private String mRoomId;
    private long nUA;
    private boolean nUC;
    private boolean nUD;
    private String nUE;
    private String nUF;
    private HandlerThread nUG;
    private Handler nUH;
    private f nUI;
    private boolean nUK;
    private volatile boolean nUL;
    private String nUM;
    private String nUN;
    private String nUR;
    private String nUS;
    private String nUT;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a nUu;
    private String nUv;
    private d nUw;
    private int nUx;
    private boolean nUy;
    private int nUz;
    private long nUB = 2000;
    private boolean nUJ = true;
    private Runnable nUO = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a aJ = com.baidu.h.b.a.aJ(b.this.mContext);
            if (aJ == null) {
                b.this.nUM = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) aJ.VM();
            if (bVar != null && !TextUtils.isEmpty(b.this.nUN)) {
                try {
                    cVar = bVar.iU(b.this.nUN);
                } catch (Exception e) {
                    e.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    b.this.nUM = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).VR().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.nUN, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gK("audioroom", "HeartBeat:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + j2);
                        if (i != 0) {
                            if (b.this.nUK && b.this.nUL && b.this.nUH != null) {
                                b.this.nUH.removeCallbacks(b.this.nUO);
                                b.this.nUH.post(b.this.nUO);
                            }
                            b.this.nUM = "heartbeaterrornum:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
                            return;
                        }
                        b.this.nUM = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.nUH != null) {
                    b.this.nUH.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.nUM = "heartbeaterror2," + b.this.nUN + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
        }
    };
    private Runnable nUP = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.nUz != 5) {
                b.this.nUz = 5;
                b.this.LZ(5);
            }
        }
    };
    private ILiveMsgReceiveListener nUQ = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
        @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
        public void onReceiveMessage(int i, JSONArray jSONArray) {
            b.this.gK("AudioRoomManager", "receiveb2cmsg:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + jSONArray.toString());
            HashMap hashMap = new HashMap();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        if (!(System.currentTimeMillis() - (optJSONObject.optLong("send_time") * 1000) > 600000)) {
                            String optString = optJSONObject.optString("content_type");
                            if (!TextUtils.isEmpty(optString)) {
                                hashMap.put(optString, optJSONObject.toString());
                            }
                        }
                    }
                }
            }
            Iterator it = hashMap.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry != null) {
                    if (TextUtils.equals("audio_link_apply_toast", (CharSequence) entry.getKey())) {
                        b.this.gK("AudioRoomManager", "do send audio_link_apply_toast");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("audio_link_cancel_apply", (CharSequence) entry.getKey())) {
                        b.this.gK("AudioRoomManager", "do send audio_link_cancel_apply");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("live_audio_lower_wheat", (CharSequence) entry.getKey())) {
                        b.this.gK("AudioRoomManager", "do live_audio_lower_wheat");
                        if (b.this.Vi(b.this.nUv)) {
                            b.this.LZ(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };
    private BIMRtcListener aCC = new BIMRtcListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19
        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
            b.this.gK("AudioRoomManager", "onRtcResult,onRtcResult:action" + i);
            if (i == 89) {
                b.this.yP(false);
                b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.nUw != null) {
                            b.this.nUw.dWe();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerInviteTimeoutByCallee(final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nUw != null) {
                        b.this.nUw.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nUw != null) {
                        b.this.nUw.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.nUw != null) {
                        b.this.nUw.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("receive_invite_anchor_5", false);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeAnswerByFromOtherCallee(int i, BIMRtcInfo bIMRtcInfo) {
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            switch (roomEventType) {
                case JOIN_ROOM:
                case EXIT_ROOM:
                default:
                    return;
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            int i = AnonymousClass17.nVr[roomEventType.ordinal()];
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void fetchRoomState(boolean z, BIMRtcInfo bIMRtcInfo) {
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void fetchRoomSignal(boolean z, BIMRtcInfo bIMRtcInfo) {
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void C(int i, long j);
    }

    public b(Context context, String str, String str2) {
        this.mContext = context;
        this.mRoomId = str;
        this.nUN = str2;
        if (this.nUG == null) {
            this.nUG = new HandlerThread("AudioRoomManager_Thread");
            this.nUG.start();
        }
        if (this.nUH == null && this.nUG.isAlive()) {
            this.nUH = new Handler(this.nUG.getLooper());
        }
        this.nUI = new f(this.nUH);
        BIMRtcClient.registerRtcListener(context, this.aCC);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.nUQ);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gK("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.nUL = true;
                    if (b.this.nUy && b.this.nUJ) {
                        if (b.this.nUD || b.this.nUC) {
                            b.this.nUI.join(b.this.mContext, b.this.nUv, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.nUy = false;
                                        if (b.this.nUu != null && b.this.nUu.dVH() != 4 && b.this.nUu.dVH() != 0) {
                                            b.this.nUx = 5;
                                            b.this.nUu.dVI();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.nUC) {
                                        b.this.nUD = false;
                                    }
                                    b.this.q(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.nUy = false;
                            if (b.this.nUu != null && b.this.nUu.dVH() != 4 && b.this.nUu.dVH() != 0) {
                                b.this.nUx = 5;
                                b.this.nUu.dVI();
                            }
                        }
                    }
                    if (b.this.nUK) {
                        b.this.dVO();
                        return;
                    }
                    return;
                }
                b.this.nUL = false;
                if (b.this.nUu != null && b.this.nUu.dVH() != 4 && b.this.nUu.dVH() != 0) {
                    b.this.nUy = true;
                }
            }
        };
        gK("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.nUu = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.nUu.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.q(1, b.this.nUx, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.nUC) {
                    b.this.nUD = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                b.this.gK("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.nUw != null) {
                                if (b.this.nUx == 4 || b.this.nUx == 3 || b.this.nUx == 2 || b.this.nUx == 5) {
                                    b.this.dVO();
                                    if (b.this.nUH != null) {
                                        b.this.nUH.removeCallbacks(b.this.nUP);
                                        b.this.nUH.post(b.this.nUP);
                                    }
                                }
                                b.this.nUw.Mb(b.this.nUx);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.q(1, b.this.nUx, i + ",connectionlost");
                    if (b.this.nUC) {
                        b.this.nUD = false;
                    }
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
                b.this.gK("AudioRoomManager", "rtcroom,onRoomDataMessage");
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomEventUpdate(final int i, final long j, final String str3) {
                if (i != 200) {
                    b.this.gK("AudioRoomManager", "rtcroom,onRoomEventUpdate:" + i + ",data:" + j + ",ext:" + str3);
                }
                switch (i) {
                    case 100:
                    default:
                        return;
                    case 101:
                    case 102:
                        if (b.this.nUC) {
                            b.this.nUD = false;
                        }
                        b.this.q(1, b.this.nUx, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.nUC) {
                            b.this.nUD = false;
                        }
                        b.this.q(1, b.this.nUx, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.BP();
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.dWe();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.dVS()) {
                            b.this.LZ(2);
                            if (b.this.nUu != null) {
                                b.this.nUu.yO(true);
                            }
                            if (5 != b.this.nUz) {
                                b.this.nUz = 5;
                                b.this.LZ(5);
                            }
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.t(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.dVS()) {
                            b.this.LZ(3);
                            if (b.this.nUu != null) {
                                b.this.nUu.yO(false);
                            }
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.t(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.dVS()) {
                            b.this.Vi(b.this.nUv);
                            b.this.LZ(1);
                            b.this.nUI.hangout(b.this.mContext, b.this.nUv, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str4) {
                                    if (i2 != 0) {
                                        b.this.q(2, i2, "kickoffhangouterror:" + str4);
                                    }
                                }
                            });
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.aQ(j);
                                }
                            }
                        });
                        return;
                    case 116:
                    case 117:
                    case 118:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.10
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.r(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.gN(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.gO(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.nUw != null) {
                                    b.this.nUw.e(i, j, str3);
                                }
                            }
                        });
                        return;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStreamInfoUpdate(String[] strArr) {
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStartSpeek() {
                b.this.Ma(4);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStopSpeak() {
                b.this.Ma(5);
            }
        });
    }

    public void a(d dVar) {
        this.nUw = dVar;
    }

    public void Vh(String str) {
        if (this.nUu != null) {
            this.nUu.n(str, false, true);
        }
    }

    public void dVN() {
        aJ(c.dVV().dWb(), TbadkCoreApplication.getCurrentAccountName(), this.nUF);
    }

    public void aJ(String str, final String str2, final String str3) {
        Vg("ownerEnterRoom");
        gK("AudioRoomManager", "ownerEnterRoom:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.nUv = str;
        this.nUC = true;
        this.nUD = false;
        this.nUE = str2;
        this.nUF = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.nUx = 1;
                            b.this.nUR = bIMRTCGetTokeResult.rtcAppId;
                            b.this.nUS = bIMRTCGetTokeResult.token;
                            b.this.nUT = bIMRTCGetTokeResult.roomId;
                            if (b.this.nUu != null) {
                                b.this.nUu.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.dVS(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.Vg("ownerEnterRoomJoinError:" + str4);
                b.this.q(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gI(String str, String str2) {
        gK("AudioRoomManager", "commonUserEnterRoom:," + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        this.nUC = false;
        this.nUD = false;
        this.nUE = "";
        this.nUF = "";
        if (this.nUu != null) {
            this.nUu.Vf(str2);
        }
    }

    public void M(String str, final String str2, final String str3, final String str4) {
        Vg("ownerJoinChat");
        gK("AudioRoomManager", "ownerJoinChat:," + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.nUv = str;
        this.nUD = true;
        axM();
        if (this.nUC) {
            if (this.nUu != null) {
                this.nUu.dVG();
            }
            this.nUI.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gJ("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.nUR) && !TextUtils.isEmpty(this.nUS) && !TextUtils.isEmpty(this.nUT)) {
            x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nUx = 2;
                    if (b.this.nUu != null) {
                        b.this.nUu.b(b.this.nUR, b.this.nUS, b.this.nUT, b.this.dVS(), str2, str3, str4);
                    }
                }
            });
        } else {
            a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                public void onResult(int i, String str5, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                    if (i == 0 && bIMRTCGetTokeResult != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("join_and_get_rtc_token_succ_host_3", true);
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.nUx = 2;
                                if (b.this.nUu != null) {
                                    b.this.nUu.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.dVS(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    b.this.Vg("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.nUC) {
                        b.this.nUD = false;
                    }
                    b.this.q(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Vg(String str) {
        if (this.nUu != null) {
            this.nUu.Vg(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gK("AudioRoomManager", "inviteJoinChat:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean Vi(String str) {
        return bf(str, true);
    }

    public boolean bf(String str, boolean z) {
        gK("AudioRoomManager", "quitChat:" + str);
        this.nUD = false;
        if (this.nUu != null && this.nUu.dVG()) {
            if (z) {
                dVP();
            }
            if (this.nUH != null) {
                this.nUH.removeCallbacks(this.nUP);
            }
            this.nUI.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i != 0) {
                        b.this.gK("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.nUC) {
                LZ(6);
            }
            if (this.nUC) {
                aJ(str, this.nUE, this.nUF);
            }
            return true;
        }
        gJ("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void Vj(String str) {
        gK("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void C(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.nUu != null) {
                                b.this.nUu.W(j);
                            }
                        }
                    });
                } else {
                    b.this.q(2, 5, "kickOffUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void yN(boolean z) {
        gK("AudioRoomManager", "muteMic:" + z);
        if (z && 5 != this.nUz) {
            this.nUz = 5;
            LZ(5);
        }
        if (this.nUu != null) {
            this.nUu.yN(z);
        }
    }

    public void bg(String str, final boolean z) {
        gK("AudioRoomManager", "muteUser:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + z);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void C(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.nUu != null) {
                                b.this.nUu.r(j, z);
                            }
                        }
                    });
                } else {
                    b.this.q(2, 4, "muteUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, final int i, final String str, final String str2, final String str3, final boolean z, String str4) {
        Vg("answerInvite");
        gK("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.nUC) {
            this.nUD = true;
        }
        final BIMAnswerRtcInfo bIMAnswerRtcInfo = new BIMAnswerRtcInfo();
        bIMAnswerRtcInfo.setRtcRoomId(bIMInviteSyncRtcInfo.getRtcRoomId());
        bIMAnswerRtcInfo.setAnswerType(i);
        bIMAnswerRtcInfo.setAnswerMediaType(1);
        bIMAnswerRtcInfo.setAnswerDeviceInfo(bIMInviteSyncRtcInfo.getRtcRoomDes());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("invited_name", str);
            jSONObject.put("invite_uk", str4);
            bIMInviteSyncRtcInfo.getRtcUserId();
            jSONObject.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bIMAnswerRtcInfo.setRtcExt(jSONObject.toString());
        final String rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
        final String rtcRoomToken = bIMInviteSyncRtcInfo.getRtcRoomToken();
        final String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
        this.nUI.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    if (b.this.nUC) {
                        b.this.nUD = false;
                    }
                    if (i != 1 || z) {
                        b.this.gJ("AudioRoomManager", i2 + "answererror:" + str5 + Constants.ACCEPT_TIME_SEPARATOR_SP + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.q(2, 3, "reject invite failed");
                    }
                    b.this.Vg("answerInvite:" + i2 + "answererror:" + str5 + Constants.ACCEPT_TIME_SEPARATOR_SP + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.nUx = z ? 4 : 3;
                    if (b.this.nUu != null) {
                        b.this.nUu.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.dVS(), str, str2, str3);
                    }
                }
            }
        });
    }

    public void BP() {
        gK("AudioRoomManager", "leaveRoom");
        this.nUy = false;
        dVP();
        if (this.nUH != null) {
            this.nUH.removeCallbacksAndMessages(null);
        }
        if (this.nUG != null) {
            this.nUG.quit();
            this.nUH = null;
        }
        if (this.nUC && this.mContext != null) {
            this.nUI.hangout(this.mContext, this.nUv, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gK("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.nUI.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aCC);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.nUQ);
        if (this.nUu != null) {
            this.nUu.BP();
            this.nUu = null;
        }
    }

    public void axM() {
        gK("AudioRoomManager", "pausePlayer");
        if (this.nUu != null) {
            this.nUu.axM();
        }
    }

    public void BO() {
        yP(true);
    }

    public void yP(boolean z) {
        gK("AudioRoomManager", "closeRoom:" + z);
        if (this.nUu != null) {
            this.nUu.dVt();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.nUv);
            this.nUI.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gJ("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void dVO() {
        gK("AudioRoomManager", "startHeartBeatAction");
        this.nUK = true;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.nUH != null) {
                    b.this.nUH.removeCallbacks(b.this.nUO);
                    b.this.nUH.post(b.this.nUO);
                }
            }
        });
    }

    public void dVP() {
        gK("AudioRoomManager", "stopHeartBeatAction");
        this.nUK = false;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.nUH != null) {
                    b.this.nUH.removeCallbacks(b.this.nUO);
                }
            }
        });
    }

    public boolean dVQ() {
        return this.nUu != null && this.nUu.dVH() == 2;
    }

    public int dVH() {
        if (this.nUu != null) {
            return this.nUu.dVH();
        }
        return -1;
    }

    public static boolean Vk(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.d.b.Vx(str), 0L)));
            BIMManager.getUsersProfiles(this.mContext, arrayList, true, new IGetUsersProfileBatchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
                @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
                public void onGetUsersProfileBatchResult(int i, String str2, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                    if (i == 0 && ListUtils.getCount(arrayList3) == 1) {
                        aVar.C(0, arrayList3.get(0).getUk());
                    } else {
                        aVar.C(-1, 0L);
                    }
                }
            });
        }
    }

    public boolean dVJ() {
        if (this.nUu != null) {
            return this.nUu.dVJ();
        }
        return true;
    }

    public void dVR() {
        gK("AudioRoomManager", "reStartPlayer");
        if (this.nUu != null) {
            this.nUu.chO();
        }
    }

    public boolean gK(long j) {
        if (this.nUu != null) {
            return this.nUu.gK(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.nUu != null) {
            this.nUu.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void C(int i, long j2) {
                if (i != 0) {
                    b.this.q(2, z ? 2 : 1, "inviteError:" + z);
                    if (iStatusListener != null) {
                        iStatusListener.onResult(i, "inviteEventgetIMUKFromBdUKError");
                        return;
                    }
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("get_imuk_from_bduk_anchor_3", false);
                BIMInviteRtcInfo bIMInviteRtcInfo = new BIMInviteRtcInfo(b.this.mContext);
                bIMInviteRtcInfo.setRtcRoomId(str);
                bIMInviteRtcInfo.setRtcRoomType(2);
                bIMInviteRtcInfo.setMediaType(1);
                ArrayList arrayList = new ArrayList();
                BIMInviteRtcInfo.BIMInviteUser bIMInviteUser = new BIMInviteRtcInfo.BIMInviteUser();
                bIMInviteUser.appId = j;
                bIMInviteUser.cuid = str4;
                bIMInviteUser.uk = j2;
                bIMInviteUser.appVersion = str3;
                arrayList.add(bIMInviteUser);
                bIMInviteRtcInfo.setBIMInviteUsers(arrayList);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("invite_name", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
                    jSONObject.put("invite_uk", n.dWB().UN());
                    jSONObject.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                    jSONObject.put("pushUrl", str5);
                    jSONObject.put("pushSingleUrl", str6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bIMInviteRtcInfo.setRtcExt(jSONObject.toString());
                b.this.nUI.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
            }
        });
    }

    private void a(final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        this.nUI.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    b.this.nUI.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), bIMRtcTokenListener);
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, "joinIMRTCRoom failed：" + str2, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long dVS() {
        return AccountManager.getUK(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LZ(final int i) {
        gK("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.nUw != null) {
                    b.this.nUw.Mc(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final int i, final int i2, final String str) {
        gK("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.nUw != null) {
                    b.this.nUw.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma(int i) {
        if (this.nUz != i) {
            if (i == 4) {
                if (this.nUH != null) {
                    this.nUH.removeCallbacks(this.nUP);
                }
                this.nUA = System.currentTimeMillis();
                this.nUz = i;
                LZ(4);
                return;
            }
            w UO = c.dVV().UO();
            if (UO != null && UO.aJe > 0.0d) {
                this.nUB = (long) (UO.aJe * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.nUA;
            if (currentTimeMillis > this.nUB) {
                this.nUz = i;
                LZ(5);
            } else if (this.nUH != null) {
                this.nUH.removeCallbacks(this.nUP);
                this.nUH.postDelayed(this.nUP, this.nUB - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.nUA > 5000) {
            if (this.nUH != null) {
                this.nUH.removeCallbacks(this.nUP);
            }
            this.nUA = System.currentTimeMillis();
            this.nUz = i;
            LZ(4);
        }
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ) {
            Log.i(str, str2);
        }
    }

    public boolean dVT() {
        return this.nUD;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.nUu != null) {
            this.nUu.sendMessageToUser(str, j);
        }
    }

    public String dVU() {
        return this.nUu != null ? this.nUu.dVK() + "#" + this.nUM + ",isStartHeartBeat:" + this.nUK + ",time:" + System.currentTimeMillis() : "";
    }
}
