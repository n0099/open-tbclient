package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.rtc.RtcRoomListener;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickResSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMSyncRtcInfo;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private Context mContext;
    private String mRoomId;
    private volatile boolean ouA;
    private boolean ouB;
    private boolean ouC;
    private boolean ouD;
    private String ouE;
    private String ouF;
    private long ouG;
    private String ouK;
    private String ouL;
    private String ouM;
    private final g ouN;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oui;
    private String ouj;
    private d ouk;
    private int oul;
    private boolean oum;
    private int oun;
    private long ouo;
    private boolean ouq;
    private boolean our;
    private String ous;
    private String ouu;
    private HandlerThread ouv;
    private Handler ouw;
    private f oux;
    private boolean ouz;
    private long oup = 2000;
    private boolean ouy = true;
    private Runnable ouH = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a bx = com.baidu.h.b.a.bx(b.this.mContext);
            if (bx == null) {
                if (b.this.oui != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.ouF);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.oui.aP("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.ouE = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) bx.Ya();
            if (bVar != null && !TextUtils.isEmpty(b.this.ouF)) {
                try {
                    cVar = bVar.in(b.this.ouF);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.oui != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.ouF);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.oui.aP("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.ouE = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).Yf().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.ouF, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gM("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.ouz && b.this.ouA && b.this.ouw != null) {
                                b.this.ouw.removeCallbacks(b.this.ouH);
                                b.this.ouw.post(b.this.ouH);
                                if (System.currentTimeMillis() - b.this.ouG > 1000 && b.this.oui != null) {
                                    b.this.ouG = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.ouF);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.oui.aP("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.ouE = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.ouE = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.ouw != null) {
                    b.this.ouw.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.ouE = "heartbeaterror2," + b.this.ouF + "," + System.currentTimeMillis();
            if (b.this.oui != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.ouF);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.oui.aP("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable ouI = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.oun != 5) {
                b.this.oun = 5;
                b.this.LV(5);
            }
        }
    };
    private ILiveMsgReceiveListener ouJ = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
        @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
        public void onReceiveMessage(int i, JSONArray jSONArray) {
            b.this.gM("AudioRoomManager", "receiveb2cmsg:" + i + "," + jSONArray.toString());
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
                        b.this.gM("AudioRoomManager", "do send audio_link_apply_toast");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("audio_link_cancel_apply", (CharSequence) entry.getKey())) {
                        b.this.gM("AudioRoomManager", "do send audio_link_cancel_apply");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("live_audio_lower_wheat", (CharSequence) entry.getKey())) {
                        b.this.gM("AudioRoomManager", "do live_audio_lower_wheat");
                        if (b.this.gK(b.this.ouj, "用户被审核下麦")) {
                            b.this.LV(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };
    private BIMRtcListener azI = new BIMRtcListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
            b.this.gM("AudioRoomManager", "onRtcResult,onRtcResult:action" + i);
            if (i == 89) {
                b.this.zG(false);
                b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ouk != null) {
                            b.this.ouk.PB();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerInviteTimeoutByCallee(final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.ouk != null) {
                        b.this.ouk.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.ouk != null) {
                        b.this.ouk.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.ouk != null) {
                        b.this.ouk.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("receive_invite_anchor_5", false);
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
                case CALLEE_RING:
                    if (b.this.ouN != null) {
                        b.this.ouN.hN(((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk());
                        return;
                    }
                    return;
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            int i = AnonymousClass19.ovm[roomEventType.ordinal()];
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void fetchRoomState(boolean z, BIMRtcInfo bIMRtcInfo) {
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void fetchRoomSignal(boolean z, BIMRtcInfo bIMRtcInfo) {
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public int roomKickedUserFromKickerSync(BIMKickReqSyncRtcInfo bIMKickReqSyncRtcInfo) {
            return 0;
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void A(int i, long j);
    }

    public b(Context context, String str, String str2) {
        this.mContext = context;
        this.mRoomId = str;
        this.ouF = str2;
        if (this.ouv == null) {
            this.ouv = new HandlerThread("AudioRoomManager_Thread");
            this.ouv.start();
        }
        if (this.ouw == null && this.ouv.isAlive()) {
            this.ouw = new Handler(this.ouv.getLooper());
        }
        this.oux = new f(this.ouw);
        this.ouN = new g(this.ouw);
        this.ouN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.g.a
            public void b(g.b bVar) {
                b.this.a(bVar);
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.azI);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.ouJ);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gM("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.ouA = true;
                    if (b.this.oum && b.this.ouy) {
                        if (b.this.our || b.this.ouq) {
                            b.this.oux.join(b.this.mContext, b.this.ouj, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.oum = false;
                                        if (b.this.oui != null && b.this.oui.eai() != 4 && b.this.oui.eai() != 0) {
                                            b.this.oul = 5;
                                            if (b.this.oui != null) {
                                                b.this.oui.aP("audio_room_manager", "", "reLoginRtcRoom1");
                                            }
                                            b.this.oui.eaj();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.ouq) {
                                        b.this.our = false;
                                    }
                                    b.this.r(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.oum = false;
                            if (b.this.oui != null && b.this.oui.eai() != 4 && b.this.oui.eai() != 0) {
                                b.this.oul = 5;
                                if (b.this.oui != null) {
                                    b.this.oui.aP("audio_room_manager", "", "reLoginRtcRoom2");
                                }
                                b.this.oui.eaj();
                            }
                        }
                    }
                    if (b.this.ouz) {
                        b.this.eaq();
                        return;
                    }
                    return;
                }
                b.this.ouA = false;
                if (b.this.oui != null && b.this.oui.eai() != 4 && b.this.oui.eai() != 0) {
                    b.this.oum = true;
                }
            }
        };
        gM("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.oui = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oui.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.r(1, b.this.oul, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.ouq) {
                    b.this.our = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gM("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.ouq) {
                        b.this.our = true;
                    }
                    if (b.this.oui != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.oui;
                        if (b.this.ouC || b.this.ouD) {
                            z = true;
                        }
                        aVar.zE(z);
                    }
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.ouk != null) {
                                if (b.this.oul == 4 || b.this.oul == 3 || b.this.oul == 2 || b.this.oul == 5) {
                                    b.this.eaq();
                                    if (b.this.ouw != null) {
                                        b.this.ouw.removeCallbacks(b.this.ouI);
                                        b.this.ouw.post(b.this.ouI);
                                    }
                                }
                                b.this.ouk.LX(b.this.oul);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.r(1, b.this.oul, i + ",connectionlost");
                    if (b.this.ouq) {
                        b.this.our = false;
                    }
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
                b.this.gM("AudioRoomManager", "rtcroom,onRoomDataMessage");
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomEventUpdate(final int i, final long j, final String str3) {
                if (i != 200) {
                    b.this.gM("AudioRoomManager", "rtcroom,onRoomEventUpdate:" + i + ",data:" + j + ",ext:" + str3);
                }
                switch (i) {
                    case 100:
                    default:
                        return;
                    case 101:
                    case 102:
                        if (b.this.ouq) {
                            b.this.our = false;
                        }
                        b.this.r(1, b.this.oul, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.ouq) {
                            b.this.our = false;
                        }
                        b.this.r(1, b.this.oul, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.yB();
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.PB();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.eau()) {
                            b.this.LV(2);
                            b.this.ouD = true;
                            if (5 != b.this.oun) {
                                b.this.oun = 5;
                                b.this.LV(5);
                            }
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.v(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.eau()) {
                            b.this.LV(3);
                            b.this.ouD = false;
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.v(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.eau()) {
                            b.this.gK(b.this.ouj, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                            b.this.LV(1);
                            b.this.oux.hangout(b.this.mContext, b.this.ouj, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.3
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str4) {
                                    if (i2 != 0) {
                                        b.this.r(2, i2, "kickoffhangouterror:" + str4);
                                    }
                                }
                            });
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.bM(j);
                                }
                            }
                        });
                        return;
                    case 116:
                    case 117:
                    case 118:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.10
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.s(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.hL(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.hM(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ouk != null) {
                                    b.this.ouk.l(i, j, str3);
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
                b.this.LW(4);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStopSpeak() {
                b.this.LW(5);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onEnterRoomResult(boolean z) {
                if (z) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect");
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                }
            }
        });
    }

    public void a(d dVar) {
        this.ouk = dVar;
    }

    public void UZ(String str) {
        if (this.oui != null) {
            this.oui.n(str, false, true);
        }
    }

    public void eap() {
        aQ(c.eax().eaC(), TbadkCoreApplication.getCurrentAccountName(), this.ouu);
    }

    public void aQ(String str, final String str2, final String str3) {
        UY("ownerEnterRoom");
        gM("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2 + "," + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.ouj = str;
        this.ouq = true;
        this.our = false;
        this.ous = str2;
        this.ouu = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oul = 1;
                            b.this.ouK = bIMRTCGetTokeResult.rtcAppId;
                            b.this.ouL = bIMRTCGetTokeResult.token;
                            b.this.ouM = bIMRTCGetTokeResult.roomId;
                            if (b.this.oui != null) {
                                b.this.oui.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eau(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.UY("ownerEnterRoomJoinError:" + str4);
                b.this.r(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gJ(String str, String str2) {
        gM("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.ouq = false;
        this.our = false;
        this.ous = "";
        this.ouu = "";
        if (this.oui != null) {
            this.oui.UW(str2);
        }
    }

    public void L(String str, final String str2, final String str3, final String str4) {
        UY("ownerJoinChat");
        gM("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.ouj = str;
        this.our = true;
        aAl();
        if (this.ouq) {
            if (this.oui != null) {
                this.oui.logoutRoom();
            }
            this.oux.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gL("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (eas() && this.oui != null) {
            if (this.oui != null) {
                this.oui.aP("audio_room_manager", "", "reLoginRtcRoom3");
            }
            this.oui.eaj();
            return;
        }
        if (!TextUtils.isEmpty(this.ouK) && !TextUtils.isEmpty(this.ouL) && !TextUtils.isEmpty(this.ouM)) {
            w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oul = 2;
                    if (b.this.oui != null) {
                        b.this.oui.b(b.this.ouK, b.this.ouL, b.this.ouM, b.this.eau(), str2, str3, str4);
                    }
                }
            });
        } else {
            a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                public void onResult(int i, String str5, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                    if (i == 0 && bIMRTCGetTokeResult != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_and_get_rtc_token_succ_host_3", true);
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.oul = 2;
                                if (b.this.oui != null) {
                                    b.this.oui.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eau(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x WA = c.eax().WA();
                        if (WA != null && WA.aGy != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject.put("error_code", i);
                        jSONObject.put("error_msg", "获取RtcToken失败：" + str5);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject));
                    b.this.UY("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.ouq) {
                        b.this.our = false;
                    }
                    b.this.r(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void UY(String str) {
        if (this.oui != null) {
            this.oui.UY(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gM("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean UX(String str) {
        return c(this.ouj, true, str);
    }

    public boolean gK(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gM("AudioRoomManager", "quitChat:" + str);
        this.ouC = false;
        this.ouD = false;
        this.ouB = false;
        this.our = false;
        if (this.oui != null && this.oui.UX(str2)) {
            if (z) {
                ear();
            }
            if (this.ouw != null) {
                this.ouw.removeCallbacks(this.ouI);
            }
            this.oux.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str3) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.ouq) {
                LV(6);
            }
            if (this.ouq) {
                aQ(str, this.ous, this.ouu);
            }
            return true;
        }
        gL("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void Va(String str) {
        gM("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, final long j) {
                if (i == 0) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oui != null) {
                                b.this.oui.aF(j);
                            }
                        }
                    });
                } else {
                    b.this.r(2, 5, "kickOffUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void zE(boolean z) {
        gM("AudioRoomManager", "muteMic:" + z);
        this.ouC = z;
        if (z && 5 != this.oun) {
            this.oun = 5;
            LV(5);
        }
        if (this.oui != null) {
            this.oui.zE(z);
        }
    }

    public void bg(String str, final boolean z) {
        gM("AudioRoomManager", "muteUser:" + str + "," + z);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, final long j) {
                if (i == 0) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oui != null) {
                                b.this.oui.t(j, z);
                            }
                        }
                    });
                } else {
                    b.this.r(2, 4, "muteUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, final int i, final String str, final String str2, final String str3, final boolean z, String str4) {
        UY("answerInvite");
        gM("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.ouq) {
            this.our = true;
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
        this.oux.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        x WA = c.eax().WA();
                        if (WA != null && WA.aGy != null) {
                            jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
                        }
                        jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject2.put("error_code", i2);
                        jSONObject2.put("error_msg", "同步信令应答失败：" + str5 + "|" + c.eax().eaz().eaw());
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, z ? "user_apply_join_chat_result" : "owner_invite_join_chat_result").setContentExt(jSONObject2));
                    if (b.this.ouq) {
                        b.this.our = false;
                    }
                    if (i != 1 || z) {
                        b.this.gL("AudioRoomManager", i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.r(2, 3, "reject invite failed");
                    }
                    b.this.UY("answerInvite:" + i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.oul = z ? 4 : 3;
                    if (b.this.ouq || !b.this.eas() || b.this.oui == null) {
                        if (b.this.ouq && b.this.oui != null) {
                            b.this.oui.logoutRoom();
                        }
                        if (b.this.oui != null) {
                            b.this.oui.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.eau(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.oui.aP("audio_room_manager", "", "reLoginRtcRoom4");
                    b.this.oui.eaj();
                }
            }
        });
    }

    public void yB() {
        gM("AudioRoomManager", "leaveRoom");
        this.oum = false;
        ear();
        if (this.ouw != null) {
            this.ouw.removeCallbacksAndMessages(null);
        }
        if (this.ouv != null) {
            this.ouv.quit();
            this.ouw = null;
        }
        if (this.ouq && this.mContext != null) {
            this.oux.hangout(this.mContext, this.ouj, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.oux.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.azI);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.ouJ);
        if (this.oui != null) {
            this.oui.yB();
            this.oui = null;
        }
    }

    public void aAl() {
        gM("AudioRoomManager", "pausePlayer");
        if (this.oui != null) {
            this.oui.aAl();
        }
    }

    public void yA() {
        zG(true);
    }

    public void zG(boolean z) {
        gM("AudioRoomManager", "closeRoom:" + z);
        if (this.oui != null) {
            this.oui.dZm();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.ouj);
            this.oux.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gL("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void eaq() {
        gM("AudioRoomManager", "startHeartBeatAction");
        if (this.oui != null) {
            this.oui.aP("audio_room_manager", "", "startHeartBeatAction");
        }
        this.ouz = true;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ouw != null) {
                    b.this.ouw.removeCallbacks(b.this.ouH);
                    b.this.ouw.post(b.this.ouH);
                }
            }
        });
    }

    public void ear() {
        gM("AudioRoomManager", "stopHeartBeatAction");
        if (this.oui != null) {
            this.oui.aP("audio_room_manager", "", "startHeartBeatAction");
        }
        this.ouz = false;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ouw != null) {
                    b.this.ouw.removeCallbacks(b.this.ouH);
                }
            }
        });
    }

    public boolean eas() {
        return this.oui != null && this.oui.eai() == 2;
    }

    public int eai() {
        if (this.oui != null) {
            return this.oui.eai();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g.b bVar) {
        BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo();
        bIMCancelRtcInfo.setRtcRoomId(this.ouj);
        ArrayList arrayList = new ArrayList();
        BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
        bIMCancelUser.appId = bVar.appId;
        bIMCancelUser.uk = bVar.imUK;
        bIMCancelUser.cuid = bVar.cuid;
        bIMCancelUser.thirdUserId = bVar.thirdUserId;
        arrayList.add(bIMCancelUser);
        bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
        this.oux.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                b.this.gM("AudioRoomManager", "cancelCall responseCode :" + i + ", msg :" + str);
            }
        });
    }

    public static boolean Vb(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.VD(str), 0L)));
            BIMManager.getUsersProfiles(this.mContext, arrayList, true, new IGetUsersProfileBatchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
                @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
                public void onGetUsersProfileBatchResult(int i, String str2, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                    if (i == 0 && ListUtils.getCount(arrayList3) == 1) {
                        aVar.A(0, arrayList3.get(0).getUk());
                    } else {
                        aVar.A(-1, 0L);
                    }
                }
            });
        }
    }

    public boolean eak() {
        if (this.oui != null) {
            return this.oui.eak();
        }
        return true;
    }

    public void eat() {
        gM("AudioRoomManager", "reStartPlayer");
        if (this.oui != null) {
            this.oui.cmG();
        }
    }

    public boolean hI(long j) {
        if (this.oui != null) {
            return this.oui.hI(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.our || (!this.ouq && eas())) {
            if (this.oui != null) {
                if (z && !this.oui.eal()) {
                    this.ouB = true;
                    this.oui.zE(true);
                } else if (!z && this.ouB) {
                    this.oui.zE(false);
                    this.ouB = false;
                }
            }
            if (this.oui != null) {
                this.oui.zF(z);
            }
        }
        if (this.oui != null) {
            this.oui.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, final String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, long j2) {
                if (i == 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x WA = c.eax().WA();
                        if (WA != null && WA.aGy != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
                        }
                        jSONObject.put("error_code", 0);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "im_rtc_invite").setContentExt(jSONObject));
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("get_imuk_from_bduk_anchor_3", false);
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
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("invite_name", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
                        jSONObject2.put("invite_uk", o.ebo().Wz());
                        jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                        jSONObject2.put("pushUrl", str5);
                        jSONObject2.put("pushSingleUrl", str6);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    bIMInviteRtcInfo.setRtcExt(jSONObject2.toString());
                    b.this.oux.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
                    if (b.this.ouN != null) {
                        b.this.ouN.c(new g.b(j, j2, str4, str2));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    x WA2 = c.eax().WA();
                    if (WA2 != null && WA2.aGy != null) {
                        jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA2.aGy.live_id);
                    }
                    jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                    jSONObject3.put("error_code", i);
                    jSONObject3.put("error_msg", "获取bduk失败：" + c.eax().eaz().eaw());
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, z ? "owner_accept_apply_invite" : "owner_invite_join_chat_result").setContentExt(jSONObject3));
                b.this.r(2, z ? 2 : 1, "inviteError:" + z);
                if (iStatusListener != null) {
                    iStatusListener.onResult(i, "inviteEventgetIMUKFromBdUKError");
                }
            }
        });
    }

    private void a(final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            x WA = c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
            }
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "join_im_rtc_room").setContentExt(jSONObject));
        this.oux.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x WA2 = c.eax().WA();
                    if (WA2 != null && WA2.aGy != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA2.aGy.live_id);
                    }
                    jSONObject2.put("error_code", i);
                    jSONObject2.put("error_msg", str2);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "join_im_rtc_result").setContentExt(jSONObject2));
                if (i == 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        x WA3 = c.eax().WA();
                        if (WA3 != null && WA3.aGy != null) {
                            jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA3.aGy.live_id);
                        }
                        jSONObject3.put("error_code", 0);
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "get_token_from_imrtc").setContentExt(jSONObject3));
                    b.this.oux.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16.1
                        @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                        public void onResult(int i2, String str3, @NonNull BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                x WA4 = c.eax().WA();
                                if (WA4 != null && WA4.aGy != null) {
                                    jSONObject4.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA4.aGy.live_id);
                                }
                                jSONObject4.put("error_code", i2);
                                jSONObject4.put("error_msg", str3);
                            } catch (Exception e4) {
                                BdLog.e(e4);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "get_token_from_rtc_result").setContentExt(jSONObject4));
                            if (bIMRtcTokenListener != null) {
                                bIMRtcTokenListener.onResult(i2, str3, bIMRTCGetTokeResult);
                            }
                        }
                    });
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, "joinIMRTCRoom failed：" + str2, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long eau() {
        return AccountManager.getUK(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LV(final int i) {
        gM("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ouk != null) {
                    b.this.ouk.LY(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final int i, final int i2, final String str) {
        gM("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ouk != null) {
                    b.this.ouk.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LW(int i) {
        if (this.oun != i) {
            if (i == 4) {
                if (this.ouw != null) {
                    this.ouw.removeCallbacks(this.ouI);
                }
                this.ouo = System.currentTimeMillis();
                this.oun = i;
                LV(4);
                return;
            }
            x WA = c.eax().WA();
            if (WA != null && WA.aGL > 0.0d) {
                this.oup = (long) (WA.aGL * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.ouo;
            if (currentTimeMillis > this.oup) {
                this.oun = i;
                LV(5);
            } else if (this.ouw != null) {
                this.ouw.removeCallbacks(this.ouI);
                this.ouw.postDelayed(this.ouI, this.oup - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.ouo > 5000) {
            if (this.ouw != null) {
                this.ouw.removeCallbacks(this.ouI);
            }
            this.ouo = System.currentTimeMillis();
            this.oun = i;
            LV(4);
        }
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
            Log.i(str, str2);
        }
    }

    public boolean eav() {
        return this.our;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oui != null) {
            this.oui.sendMessageToUser(str, j);
        }
    }

    public String eaw() {
        return this.oui != null ? this.oui.eam() + "#" + this.ouE + ",isStartHeartBeat:" + this.ouz + ",time:" + System.currentTimeMillis() : "";
    }
}
