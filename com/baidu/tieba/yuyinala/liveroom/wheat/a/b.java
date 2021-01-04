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
/* loaded from: classes11.dex */
public class b {
    private Context mContext;
    private String mRoomId;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oyP;
    private String oyQ;
    private d oyR;
    private int oyS;
    private boolean oyT;
    private int oyU;
    private long oyV;
    private boolean oyX;
    private boolean oyY;
    private String oyZ;
    private String oza;
    private HandlerThread ozb;
    private Handler ozc;
    private f ozd;
    private boolean ozf;
    private volatile boolean ozg;
    private boolean ozh;
    private boolean ozi;
    private boolean ozj;
    private String ozk;
    private String ozl;
    private long ozm;
    private String ozq;
    private String ozr;
    private String ozs;
    private final g ozt;
    private long oyW = 2000;
    private boolean oze = true;
    private Runnable ozn = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.j.a.b.c cVar;
            com.baidu.j.b.a by = com.baidu.j.b.a.by(b.this.mContext);
            if (by == null) {
                if (b.this.oyP != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.ozl);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.oyP.aQ("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.ozk = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.j.b.a.a.b bVar = (com.baidu.j.b.a.a.b) by.abS();
            if (bVar != null && !TextUtils.isEmpty(b.this.ozl)) {
                try {
                    cVar = bVar.jy(b.this.ozl);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.oyP != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.ozl);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.oyP.aQ("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.ozk = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.j.b.a.a) cVar).abX().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.ozl, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gN("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.ozf && b.this.ozg && b.this.ozc != null) {
                                b.this.ozc.removeCallbacks(b.this.ozn);
                                b.this.ozc.post(b.this.ozn);
                                if (System.currentTimeMillis() - b.this.ozm > 1000 && b.this.oyP != null) {
                                    b.this.ozm = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.ozl);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.oyP.aQ("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.ozk = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.ozk = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.ozc != null) {
                    b.this.ozc.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.ozk = "heartbeaterror2," + b.this.ozl + "," + System.currentTimeMillis();
            if (b.this.oyP != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.ozl);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.oyP.aQ("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable ozo = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.oyU != 5) {
                b.this.oyU = 5;
                b.this.NC(5);
            }
        }
    };
    private ILiveMsgReceiveListener ozp = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
        @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
        public void onReceiveMessage(int i, JSONArray jSONArray) {
            b.this.gN("AudioRoomManager", "receiveb2cmsg:" + i + "," + jSONArray.toString());
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
                        b.this.gN("AudioRoomManager", "do send audio_link_apply_toast");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("audio_link_cancel_apply", (CharSequence) entry.getKey())) {
                        b.this.gN("AudioRoomManager", "do send audio_link_cancel_apply");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("live_audio_lower_wheat", (CharSequence) entry.getKey())) {
                        b.this.gN("AudioRoomManager", "do live_audio_lower_wheat");
                        if (b.this.gL(b.this.oyQ, "用户被审核下麦")) {
                            b.this.NC(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };
    private BIMRtcListener aEv = new BIMRtcListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
            b.this.gN("AudioRoomManager", "onRtcResult,onRtcResult:action" + i);
            if (i == 89) {
                b.this.zK(false);
                b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oyR != null) {
                            b.this.oyR.Tw();
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
                    if (b.this.oyR != null) {
                        b.this.oyR.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.oyR != null) {
                        b.this.oyR.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.oyR != null) {
                        b.this.oyR.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
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
                    if (b.this.ozt != null) {
                        b.this.ozt.hN(((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk());
                        return;
                    }
                    return;
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            int i = AnonymousClass19.ozS[roomEventType.ordinal()];
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

    /* loaded from: classes11.dex */
    public interface a {
        void A(int i, long j);
    }

    public b(Context context, String str, String str2) {
        this.mContext = context;
        this.mRoomId = str;
        this.ozl = str2;
        if (this.ozb == null) {
            this.ozb = new HandlerThread("AudioRoomManager_Thread");
            this.ozb.start();
        }
        if (this.ozc == null && this.ozb.isAlive()) {
            this.ozc = new Handler(this.ozb.getLooper());
        }
        this.ozd = new f(this.ozc);
        this.ozt = new g(this.ozc);
        this.ozt.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.g.a
            public void b(g.b bVar) {
                b.this.a(bVar);
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.aEv);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.ozp);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gN("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.ozg = true;
                    if (b.this.oyT && b.this.oze) {
                        if (b.this.oyY || b.this.oyX) {
                            b.this.ozd.join(b.this.mContext, b.this.oyQ, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.oyT = false;
                                        if (b.this.oyP != null && b.this.oyP.edZ() != 4 && b.this.oyP.edZ() != 0) {
                                            b.this.oyS = 5;
                                            if (b.this.oyP != null) {
                                                b.this.oyP.aQ("audio_room_manager", "", "reLoginRtcRoom1");
                                            }
                                            b.this.oyP.eea();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.oyX) {
                                        b.this.oyY = false;
                                    }
                                    b.this.r(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.oyT = false;
                            if (b.this.oyP != null && b.this.oyP.edZ() != 4 && b.this.oyP.edZ() != 0) {
                                b.this.oyS = 5;
                                if (b.this.oyP != null) {
                                    b.this.oyP.aQ("audio_room_manager", "", "reLoginRtcRoom2");
                                }
                                b.this.oyP.eea();
                            }
                        }
                    }
                    if (b.this.ozf) {
                        b.this.eeh();
                        return;
                    }
                    return;
                }
                b.this.ozg = false;
                if (b.this.oyP != null && b.this.oyP.edZ() != 4 && b.this.oyP.edZ() != 0) {
                    b.this.oyT = true;
                }
            }
        };
        gN("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.oyP = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oyP.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.r(1, b.this.oyS, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.oyX) {
                    b.this.oyY = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gN("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.oyX) {
                        b.this.oyY = true;
                    }
                    if (b.this.oyP != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.oyP;
                        if (b.this.ozi || b.this.ozj) {
                            z = true;
                        }
                        aVar.zI(z);
                    }
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oyR != null) {
                                if (b.this.oyS == 4 || b.this.oyS == 3 || b.this.oyS == 2 || b.this.oyS == 5) {
                                    b.this.eeh();
                                    if (b.this.ozc != null) {
                                        b.this.ozc.removeCallbacks(b.this.ozo);
                                        b.this.ozc.post(b.this.ozo);
                                    }
                                }
                                b.this.oyR.NE(b.this.oyS);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.r(1, b.this.oyS, i + ",connectionlost");
                    if (b.this.oyX) {
                        b.this.oyY = false;
                    }
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
                b.this.gN("AudioRoomManager", "rtcroom,onRoomDataMessage");
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomEventUpdate(final int i, final long j, final String str3) {
                if (i != 200) {
                    b.this.gN("AudioRoomManager", "rtcroom,onRoomEventUpdate:" + i + ",data:" + j + ",ext:" + str3);
                }
                switch (i) {
                    case 100:
                    default:
                        return;
                    case 101:
                    case 102:
                        if (b.this.oyX) {
                            b.this.oyY = false;
                        }
                        b.this.r(1, b.this.oyS, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.oyX) {
                            b.this.oyY = false;
                        }
                        b.this.r(1, b.this.oyS, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.Cw();
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyR != null) {
                                    b.this.oyR.Tw();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.eel()) {
                            b.this.NC(2);
                            b.this.ozj = true;
                            if (5 != b.this.oyU) {
                                b.this.oyU = 5;
                                b.this.NC(5);
                            }
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyR != null) {
                                    b.this.oyR.u(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.eel()) {
                            b.this.NC(3);
                            b.this.ozj = false;
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyR != null) {
                                    b.this.oyR.u(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.eel()) {
                            b.this.gL(b.this.oyQ, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                            b.this.NC(1);
                            b.this.ozd.hangout(b.this.mContext, b.this.oyQ, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.3
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
                                if (b.this.oyR != null) {
                                    b.this.oyR.bM(j);
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
                                if (b.this.oyR != null) {
                                    b.this.oyR.s(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyR != null) {
                                    b.this.oyR.hL(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyR != null) {
                                    b.this.oyR.hM(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyR != null) {
                                    b.this.oyR.l(i, j, str3);
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
                b.this.ND(4);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStopSpeak() {
                b.this.ND(5);
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
        this.oyR = dVar;
    }

    public void Wi(String str) {
        if (this.oyP != null) {
            this.oyP.n(str, false, true);
        }
    }

    public void eeg() {
        aR(c.eeo().eet(), TbadkCoreApplication.getCurrentAccountName(), this.oza);
    }

    public void aR(String str, final String str2, final String str3) {
        Wh("ownerEnterRoom");
        gN("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2 + "," + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.oyQ = str;
        this.oyX = true;
        this.oyY = false;
        this.oyZ = str2;
        this.oza = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oyS = 1;
                            b.this.ozq = bIMRTCGetTokeResult.rtcAppId;
                            b.this.ozr = bIMRTCGetTokeResult.token;
                            b.this.ozs = bIMRTCGetTokeResult.roomId;
                            if (b.this.oyP != null) {
                                b.this.oyP.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eel(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.Wh("ownerEnterRoomJoinError:" + str4);
                b.this.r(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gK(String str, String str2) {
        gN("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.oyX = false;
        this.oyY = false;
        this.oyZ = "";
        this.oza = "";
        if (this.oyP != null) {
            this.oyP.Wf(str2);
        }
    }

    public void L(String str, final String str2, final String str3, final String str4) {
        Wh("ownerJoinChat");
        gN("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.oyQ = str;
        this.oyY = true;
        aEe();
        if (this.oyX) {
            if (this.oyP != null) {
                this.oyP.logoutRoom();
            }
            this.ozd.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (eej() && this.oyP != null) {
            if (this.oyP != null) {
                this.oyP.aQ("audio_room_manager", "", "reLoginRtcRoom3");
            }
            this.oyP.eea();
            return;
        }
        if (!TextUtils.isEmpty(this.ozq) && !TextUtils.isEmpty(this.ozr) && !TextUtils.isEmpty(this.ozs)) {
            w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oyS = 2;
                    if (b.this.oyP != null) {
                        b.this.oyP.b(b.this.ozq, b.this.ozr, b.this.ozs, b.this.eel(), str2, str3, str4);
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
                                b.this.oyS = 2;
                                if (b.this.oyP != null) {
                                    b.this.oyP.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eel(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aas = c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject.put("error_code", i);
                        jSONObject.put("error_msg", "获取RtcToken失败：" + str5);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_fail").setContentExt(jSONObject));
                    b.this.Wh("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.oyX) {
                        b.this.oyY = false;
                    }
                    b.this.r(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Wh(String str) {
        if (this.oyP != null) {
            this.oyP.Wh(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gN("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean Wg(String str) {
        return c(this.oyQ, true, str);
    }

    public boolean gL(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gN("AudioRoomManager", "quitChat:" + str);
        this.ozi = false;
        this.ozj = false;
        this.ozh = false;
        this.oyY = false;
        if (this.oyP != null && this.oyP.Wg(str2)) {
            if (z) {
                eei();
            }
            if (this.ozc != null) {
                this.ozc.removeCallbacks(this.ozo);
            }
            this.ozd.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str3) {
                    if (i != 0) {
                        b.this.gN("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.oyX) {
                NC(6);
            }
            if (this.oyX) {
                aR(str, this.oyZ, this.oza);
            }
            return true;
        }
        gM("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void Wj(String str) {
        gN("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, final long j) {
                if (i == 0) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oyP != null) {
                                b.this.oyP.aF(j);
                            }
                        }
                    });
                } else {
                    b.this.r(2, 5, "kickOffUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void zI(boolean z) {
        gN("AudioRoomManager", "muteMic:" + z);
        this.ozi = z;
        if (z && 5 != this.oyU) {
            this.oyU = 5;
            NC(5);
        }
        if (this.oyP != null) {
            this.oyP.zI(z);
        }
    }

    public void bg(String str, final boolean z) {
        gN("AudioRoomManager", "muteUser:" + str + "," + z);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, final long j) {
                if (i == 0) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oyP != null) {
                                b.this.oyP.s(j, z);
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
        Wh("answerInvite");
        gN("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.oyX) {
            this.oyY = true;
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
        this.ozd.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        x aas = c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                        }
                        jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject2.put("error_code", i2);
                        jSONObject2.put("error_msg", "同步信令应答失败：" + str5 + "|" + c.eeo().eeq().een());
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, z ? "user_apply_join_chat_fail" : "owner_invite_join_chat_fail").setContentExt(jSONObject2));
                    if (b.this.oyX) {
                        b.this.oyY = false;
                    }
                    if (i != 1 || z) {
                        b.this.gM("AudioRoomManager", i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.r(2, 3, "reject invite failed");
                    }
                    b.this.Wh("answerInvite:" + i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.oyS = z ? 4 : 3;
                    if (b.this.oyX || !b.this.eej() || b.this.oyP == null) {
                        if (b.this.oyX && b.this.oyP != null) {
                            b.this.oyP.logoutRoom();
                        }
                        if (b.this.oyP != null) {
                            b.this.oyP.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.eel(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.oyP.aQ("audio_room_manager", "", "reLoginRtcRoom4");
                    b.this.oyP.eea();
                }
            }
        });
    }

    public void Cw() {
        gN("AudioRoomManager", "leaveRoom");
        this.oyT = false;
        eei();
        if (this.ozc != null) {
            this.ozc.removeCallbacksAndMessages(null);
        }
        if (this.ozb != null) {
            this.ozb.quit();
            this.ozc = null;
        }
        if (this.oyX && this.mContext != null) {
            this.ozd.hangout(this.mContext, this.oyQ, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gN("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.ozd.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aEv);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.ozp);
        if (this.oyP != null) {
            this.oyP.Cw();
            this.oyP = null;
        }
    }

    public void aEe() {
        gN("AudioRoomManager", "pausePlayer");
        if (this.oyP != null) {
            this.oyP.aEe();
        }
    }

    public void Cv() {
        zK(true);
    }

    public void zK(boolean z) {
        gN("AudioRoomManager", "closeRoom:" + z);
        if (this.oyP != null) {
            this.oyP.edd();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.oyQ);
            this.ozd.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void eeh() {
        gN("AudioRoomManager", "startHeartBeatAction");
        if (this.oyP != null) {
            this.oyP.aQ("audio_room_manager", "", "startHeartBeatAction");
        }
        this.ozf = true;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ozc != null) {
                    b.this.ozc.removeCallbacks(b.this.ozn);
                    b.this.ozc.post(b.this.ozn);
                }
            }
        });
    }

    public void eei() {
        gN("AudioRoomManager", "stopHeartBeatAction");
        if (this.oyP != null) {
            this.oyP.aQ("audio_room_manager", "", "startHeartBeatAction");
        }
        this.ozf = false;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ozc != null) {
                    b.this.ozc.removeCallbacks(b.this.ozn);
                }
            }
        });
    }

    public boolean eej() {
        return this.oyP != null && this.oyP.edZ() == 2;
    }

    public int edZ() {
        if (this.oyP != null) {
            return this.oyP.edZ();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g.b bVar) {
        BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo();
        bIMCancelRtcInfo.setRtcRoomId(this.oyQ);
        ArrayList arrayList = new ArrayList();
        BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
        bIMCancelUser.appId = bVar.appId;
        bIMCancelUser.uk = bVar.imUK;
        bIMCancelUser.cuid = bVar.cuid;
        bIMCancelUser.thirdUserId = bVar.thirdUserId;
        arrayList.add(bIMCancelUser);
        bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
        this.ozd.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                b.this.gN("AudioRoomManager", "cancelCall responseCode :" + i + ", msg :" + str);
            }
        });
    }

    public static boolean Wk(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.WM(str), 0L)));
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

    public boolean eeb() {
        if (this.oyP != null) {
            return this.oyP.eeb();
        }
        return true;
    }

    public void eek() {
        gN("AudioRoomManager", "reStartPlayer");
        if (this.oyP != null) {
            this.oyP.cqx();
        }
    }

    public boolean hI(long j) {
        if (this.oyP != null) {
            return this.oyP.hI(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.oyY || (!this.oyX && eej())) {
            if (this.oyP != null) {
                if (z && !this.oyP.eec()) {
                    this.ozh = true;
                    this.oyP.zI(true);
                } else if (!z && this.ozh) {
                    this.oyP.zI(false);
                    this.ozh = false;
                }
            }
            if (this.oyP != null) {
                this.oyP.zJ(z);
            }
        }
        if (this.oyP != null) {
            this.oyP.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, final String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, long j2) {
                if (i == 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aas = c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
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
                        jSONObject2.put("invite_uk", o.eff().aar());
                        jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                        jSONObject2.put("pushUrl", str5);
                        jSONObject2.put("pushSingleUrl", str6);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    bIMInviteRtcInfo.setRtcExt(jSONObject2.toString());
                    b.this.ozd.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
                    if (b.this.ozt != null) {
                        b.this.ozt.c(new g.b(j, j2, str4, str2));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    x aas2 = c.eeo().aas();
                    if (aas2 != null && aas2.aLl != null) {
                        jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas2.aLl.live_id);
                    }
                    jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                    jSONObject3.put("error_code", i);
                    jSONObject3.put("error_msg", "获取bduk失败：" + c.eeo().eeq().een());
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, z ? "owner_accept_apply_invite" : "owner_invite_join_chat_fail").setContentExt(jSONObject3));
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
            x aas = c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
            }
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "join_im_rtc_room").setContentExt(jSONObject));
        this.ozd.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aas2 = c.eeo().aas();
                    if (aas2 != null && aas2.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas2.aLl.live_id);
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
                        x aas3 = c.eeo().aas();
                        if (aas3 != null && aas3.aLl != null) {
                            jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas3.aLl.live_id);
                        }
                        jSONObject3.put("error_code", 0);
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "get_token_from_imrtc").setContentExt(jSONObject3));
                    b.this.ozd.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16.1
                        @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                        public void onResult(int i2, String str3, @NonNull BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                x aas4 = c.eeo().aas();
                                if (aas4 != null && aas4.aLl != null) {
                                    jSONObject4.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas4.aLl.live_id);
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
    public long eel() {
        return AccountManager.getUK(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC(final int i) {
        gN("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oyR != null) {
                    b.this.oyR.NF(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final int i, final int i2, final String str) {
        gN("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oyR != null) {
                    b.this.oyR.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND(int i) {
        if (this.oyU != i) {
            if (i == 4) {
                if (this.ozc != null) {
                    this.ozc.removeCallbacks(this.ozo);
                }
                this.oyV = System.currentTimeMillis();
                this.oyU = i;
                NC(4);
                return;
            }
            x aas = c.eeo().aas();
            if (aas != null && aas.aLy > 0.0d) {
                this.oyW = (long) (aas.aLy * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oyV;
            if (currentTimeMillis > this.oyW) {
                this.oyU = i;
                NC(5);
            } else if (this.ozc != null) {
                this.ozc.removeCallbacks(this.ozo);
                this.ozc.postDelayed(this.ozo, this.oyW - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oyV > 5000) {
            if (this.ozc != null) {
                this.ozc.removeCallbacks(this.ozo);
            }
            this.oyV = System.currentTimeMillis();
            this.oyU = i;
            NC(4);
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
    public void gM(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
            Log.i(str, str2);
        }
    }

    public boolean eem() {
        return this.oyY;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oyP != null) {
            this.oyP.sendMessageToUser(str, j);
        }
    }

    public String een() {
        return this.oyP != null ? this.oyP.eed() + "#" + this.ozk + ",isStartHeartBeat:" + this.ozf + ",time:" + System.currentTimeMillis() : "";
    }
}
