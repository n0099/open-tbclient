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
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oyO;
    private String oyP;
    private d oyQ;
    private int oyR;
    private boolean oyS;
    private int oyT;
    private long oyU;
    private boolean oyW;
    private boolean oyX;
    private String oyY;
    private String oyZ;
    private HandlerThread oza;
    private Handler ozb;
    private f ozc;
    private boolean oze;
    private volatile boolean ozf;
    private boolean ozg;
    private boolean ozh;
    private boolean ozi;
    private String ozj;
    private String ozk;
    private long ozl;
    private String ozp;
    private String ozq;
    private String ozr;
    private final g ozs;
    private long oyV = 2000;
    private boolean ozd = true;
    private Runnable ozm = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.j.a.b.c cVar;
            com.baidu.j.b.a by = com.baidu.j.b.a.by(b.this.mContext);
            if (by == null) {
                if (b.this.oyO != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.ozk);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.oyO.aQ("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.ozj = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.j.b.a.a.b bVar = (com.baidu.j.b.a.a.b) by.abT();
            if (bVar != null && !TextUtils.isEmpty(b.this.ozk)) {
                try {
                    cVar = bVar.jy(b.this.ozk);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.oyO != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.ozk);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.oyO.aQ("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.ozj = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.j.b.a.a) cVar).abY().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.ozk, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gN("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.oze && b.this.ozf && b.this.ozb != null) {
                                b.this.ozb.removeCallbacks(b.this.ozm);
                                b.this.ozb.post(b.this.ozm);
                                if (System.currentTimeMillis() - b.this.ozl > 1000 && b.this.oyO != null) {
                                    b.this.ozl = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.ozk);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.oyO.aQ("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.ozj = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.ozj = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.ozb != null) {
                    b.this.ozb.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.ozj = "heartbeaterror2," + b.this.ozk + "," + System.currentTimeMillis();
            if (b.this.oyO != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.ozk);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.oyO.aQ("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable ozn = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.oyT != 5) {
                b.this.oyT = 5;
                b.this.NC(5);
            }
        }
    };
    private ILiveMsgReceiveListener ozo = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
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
                        if (b.this.gL(b.this.oyP, "用户被审核下麦")) {
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
                        if (b.this.oyQ != null) {
                            b.this.oyQ.Tw();
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
                    if (b.this.oyQ != null) {
                        b.this.oyQ.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.oyQ != null) {
                        b.this.oyQ.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.oyQ != null) {
                        b.this.oyQ.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
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
                    if (b.this.ozs != null) {
                        b.this.ozs.hN(((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk());
                        return;
                    }
                    return;
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            int i = AnonymousClass19.ozR[roomEventType.ordinal()];
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
        this.ozk = str2;
        if (this.oza == null) {
            this.oza = new HandlerThread("AudioRoomManager_Thread");
            this.oza.start();
        }
        if (this.ozb == null && this.oza.isAlive()) {
            this.ozb = new Handler(this.oza.getLooper());
        }
        this.ozc = new f(this.ozb);
        this.ozs = new g(this.ozb);
        this.ozs.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.g.a
            public void b(g.b bVar) {
                b.this.a(bVar);
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.aEv);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.ozo);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gN("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.ozf = true;
                    if (b.this.oyS && b.this.ozd) {
                        if (b.this.oyX || b.this.oyW) {
                            b.this.ozc.join(b.this.mContext, b.this.oyP, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.oyS = false;
                                        if (b.this.oyO != null && b.this.oyO.eea() != 4 && b.this.oyO.eea() != 0) {
                                            b.this.oyR = 5;
                                            if (b.this.oyO != null) {
                                                b.this.oyO.aQ("audio_room_manager", "", "reLoginRtcRoom1");
                                            }
                                            b.this.oyO.eeb();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.oyW) {
                                        b.this.oyX = false;
                                    }
                                    b.this.r(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.oyS = false;
                            if (b.this.oyO != null && b.this.oyO.eea() != 4 && b.this.oyO.eea() != 0) {
                                b.this.oyR = 5;
                                if (b.this.oyO != null) {
                                    b.this.oyO.aQ("audio_room_manager", "", "reLoginRtcRoom2");
                                }
                                b.this.oyO.eeb();
                            }
                        }
                    }
                    if (b.this.oze) {
                        b.this.eei();
                        return;
                    }
                    return;
                }
                b.this.ozf = false;
                if (b.this.oyO != null && b.this.oyO.eea() != 4 && b.this.oyO.eea() != 0) {
                    b.this.oyS = true;
                }
            }
        };
        gN("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.oyO = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oyO.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.r(1, b.this.oyR, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.oyW) {
                    b.this.oyX = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gN("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.oyW) {
                        b.this.oyX = true;
                    }
                    if (b.this.oyO != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.oyO;
                        if (b.this.ozh || b.this.ozi) {
                            z = true;
                        }
                        aVar.zI(z);
                    }
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oyQ != null) {
                                if (b.this.oyR == 4 || b.this.oyR == 3 || b.this.oyR == 2 || b.this.oyR == 5) {
                                    b.this.eei();
                                    if (b.this.ozb != null) {
                                        b.this.ozb.removeCallbacks(b.this.ozn);
                                        b.this.ozb.post(b.this.ozn);
                                    }
                                }
                                b.this.oyQ.NE(b.this.oyR);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.r(1, b.this.oyR, i + ",connectionlost");
                    if (b.this.oyW) {
                        b.this.oyX = false;
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
                        if (b.this.oyW) {
                            b.this.oyX = false;
                        }
                        b.this.r(1, b.this.oyR, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.oyW) {
                            b.this.oyX = false;
                        }
                        b.this.r(1, b.this.oyR, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.Cw();
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.Tw();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.eem()) {
                            b.this.NC(2);
                            b.this.ozi = true;
                            if (5 != b.this.oyT) {
                                b.this.oyT = 5;
                                b.this.NC(5);
                            }
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.u(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.eem()) {
                            b.this.NC(3);
                            b.this.ozi = false;
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.u(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.eem()) {
                            b.this.gL(b.this.oyP, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                            b.this.NC(1);
                            b.this.ozc.hangout(b.this.mContext, b.this.oyP, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.3
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
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.bM(j);
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
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.s(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.hL(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.hM(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oyQ != null) {
                                    b.this.oyQ.l(i, j, str3);
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
        this.oyQ = dVar;
    }

    public void Wh(String str) {
        if (this.oyO != null) {
            this.oyO.n(str, false, true);
        }
    }

    public void eeh() {
        aR(c.eep().eeu(), TbadkCoreApplication.getCurrentAccountName(), this.oyZ);
    }

    public void aR(String str, final String str2, final String str3) {
        Wg("ownerEnterRoom");
        gN("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2 + "," + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.oyP = str;
        this.oyW = true;
        this.oyX = false;
        this.oyY = str2;
        this.oyZ = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oyR = 1;
                            b.this.ozp = bIMRTCGetTokeResult.rtcAppId;
                            b.this.ozq = bIMRTCGetTokeResult.token;
                            b.this.ozr = bIMRTCGetTokeResult.roomId;
                            if (b.this.oyO != null) {
                                b.this.oyO.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eem(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.Wg("ownerEnterRoomJoinError:" + str4);
                b.this.r(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gK(String str, String str2) {
        gN("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.oyW = false;
        this.oyX = false;
        this.oyY = "";
        this.oyZ = "";
        if (this.oyO != null) {
            this.oyO.We(str2);
        }
    }

    public void L(String str, final String str2, final String str3, final String str4) {
        Wg("ownerJoinChat");
        gN("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.oyP = str;
        this.oyX = true;
        aEf();
        if (this.oyW) {
            if (this.oyO != null) {
                this.oyO.logoutRoom();
            }
            this.ozc.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (eek() && this.oyO != null) {
            if (this.oyO != null) {
                this.oyO.aQ("audio_room_manager", "", "reLoginRtcRoom3");
            }
            this.oyO.eeb();
            return;
        }
        if (!TextUtils.isEmpty(this.ozp) && !TextUtils.isEmpty(this.ozq) && !TextUtils.isEmpty(this.ozr)) {
            w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oyR = 2;
                    if (b.this.oyO != null) {
                        b.this.oyO.b(b.this.ozp, b.this.ozq, b.this.ozr, b.this.eem(), str2, str3, str4);
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
                                b.this.oyR = 2;
                                if (b.this.oyO != null) {
                                    b.this.oyO.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eem(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aat = c.eep().aat();
                        if (aat != null && aat.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject.put("error_code", i);
                        jSONObject.put("error_msg", "获取RtcToken失败：" + str5);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject));
                    b.this.Wg("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.oyW) {
                        b.this.oyX = false;
                    }
                    b.this.r(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Wg(String str) {
        if (this.oyO != null) {
            this.oyO.Wg(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gN("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean Wf(String str) {
        return c(this.oyP, true, str);
    }

    public boolean gL(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gN("AudioRoomManager", "quitChat:" + str);
        this.ozh = false;
        this.ozi = false;
        this.ozg = false;
        this.oyX = false;
        if (this.oyO != null && this.oyO.Wf(str2)) {
            if (z) {
                eej();
            }
            if (this.ozb != null) {
                this.ozb.removeCallbacks(this.ozn);
            }
            this.ozc.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str3) {
                    if (i != 0) {
                        b.this.gN("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.oyW) {
                NC(6);
            }
            if (this.oyW) {
                aR(str, this.oyY, this.oyZ);
            }
            return true;
        }
        gM("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void Wi(String str) {
        gN("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, final long j) {
                if (i == 0) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oyO != null) {
                                b.this.oyO.aF(j);
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
        this.ozh = z;
        if (z && 5 != this.oyT) {
            this.oyT = 5;
            NC(5);
        }
        if (this.oyO != null) {
            this.oyO.zI(z);
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
                            if (b.this.oyO != null) {
                                b.this.oyO.s(j, z);
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
        Wg("answerInvite");
        gN("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.oyW) {
            this.oyX = true;
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
        this.ozc.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        x aat = c.eep().aat();
                        if (aat != null && aat.aLl != null) {
                            jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                        }
                        jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject2.put("error_code", i2);
                        jSONObject2.put("error_msg", "同步信令应答失败：" + str5 + "|" + c.eep().eer().eeo());
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, z ? "user_apply_join_chat_result" : "owner_invite_join_chat_result").setContentExt(jSONObject2));
                    if (b.this.oyW) {
                        b.this.oyX = false;
                    }
                    if (i != 1 || z) {
                        b.this.gM("AudioRoomManager", i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.r(2, 3, "reject invite failed");
                    }
                    b.this.Wg("answerInvite:" + i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.oyR = z ? 4 : 3;
                    if (b.this.oyW || !b.this.eek() || b.this.oyO == null) {
                        if (b.this.oyW && b.this.oyO != null) {
                            b.this.oyO.logoutRoom();
                        }
                        if (b.this.oyO != null) {
                            b.this.oyO.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.eem(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.oyO.aQ("audio_room_manager", "", "reLoginRtcRoom4");
                    b.this.oyO.eeb();
                }
            }
        });
    }

    public void Cw() {
        gN("AudioRoomManager", "leaveRoom");
        this.oyS = false;
        eej();
        if (this.ozb != null) {
            this.ozb.removeCallbacksAndMessages(null);
        }
        if (this.oza != null) {
            this.oza.quit();
            this.ozb = null;
        }
        if (this.oyW && this.mContext != null) {
            this.ozc.hangout(this.mContext, this.oyP, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gN("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.ozc.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aEv);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.ozo);
        if (this.oyO != null) {
            this.oyO.Cw();
            this.oyO = null;
        }
    }

    public void aEf() {
        gN("AudioRoomManager", "pausePlayer");
        if (this.oyO != null) {
            this.oyO.aEf();
        }
    }

    public void Cv() {
        zK(true);
    }

    public void zK(boolean z) {
        gN("AudioRoomManager", "closeRoom:" + z);
        if (this.oyO != null) {
            this.oyO.ede();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.oyP);
            this.ozc.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void eei() {
        gN("AudioRoomManager", "startHeartBeatAction");
        if (this.oyO != null) {
            this.oyO.aQ("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oze = true;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ozb != null) {
                    b.this.ozb.removeCallbacks(b.this.ozm);
                    b.this.ozb.post(b.this.ozm);
                }
            }
        });
    }

    public void eej() {
        gN("AudioRoomManager", "stopHeartBeatAction");
        if (this.oyO != null) {
            this.oyO.aQ("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oze = false;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ozb != null) {
                    b.this.ozb.removeCallbacks(b.this.ozm);
                }
            }
        });
    }

    public boolean eek() {
        return this.oyO != null && this.oyO.eea() == 2;
    }

    public int eea() {
        if (this.oyO != null) {
            return this.oyO.eea();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g.b bVar) {
        BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo();
        bIMCancelRtcInfo.setRtcRoomId(this.oyP);
        ArrayList arrayList = new ArrayList();
        BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
        bIMCancelUser.appId = bVar.appId;
        bIMCancelUser.uk = bVar.imUK;
        bIMCancelUser.cuid = bVar.cuid;
        bIMCancelUser.thirdUserId = bVar.thirdUserId;
        arrayList.add(bIMCancelUser);
        bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
        this.ozc.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                b.this.gN("AudioRoomManager", "cancelCall responseCode :" + i + ", msg :" + str);
            }
        });
    }

    public static boolean Wj(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.WL(str), 0L)));
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

    public boolean eec() {
        if (this.oyO != null) {
            return this.oyO.eec();
        }
        return true;
    }

    public void eel() {
        gN("AudioRoomManager", "reStartPlayer");
        if (this.oyO != null) {
            this.oyO.cqy();
        }
    }

    public boolean hI(long j) {
        if (this.oyO != null) {
            return this.oyO.hI(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.oyX || (!this.oyW && eek())) {
            if (this.oyO != null) {
                if (z && !this.oyO.eed()) {
                    this.ozg = true;
                    this.oyO.zI(true);
                } else if (!z && this.ozg) {
                    this.oyO.zI(false);
                    this.ozg = false;
                }
            }
            if (this.oyO != null) {
                this.oyO.zJ(z);
            }
        }
        if (this.oyO != null) {
            this.oyO.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, final String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, long j2) {
                if (i == 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aat = c.eep().aat();
                        if (aat != null && aat.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
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
                        jSONObject2.put("invite_uk", o.efg().aas());
                        jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                        jSONObject2.put("pushUrl", str5);
                        jSONObject2.put("pushSingleUrl", str6);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    bIMInviteRtcInfo.setRtcExt(jSONObject2.toString());
                    b.this.ozc.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
                    if (b.this.ozs != null) {
                        b.this.ozs.c(new g.b(j, j2, str4, str2));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    x aat2 = c.eep().aat();
                    if (aat2 != null && aat2.aLl != null) {
                        jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat2.aLl.live_id);
                    }
                    jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                    jSONObject3.put("error_code", i);
                    jSONObject3.put("error_msg", "获取bduk失败：" + c.eep().eer().eeo());
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
            x aat = c.eep().aat();
            if (aat != null && aat.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
            }
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "join_im_rtc_room").setContentExt(jSONObject));
        this.ozc.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aat2 = c.eep().aat();
                    if (aat2 != null && aat2.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat2.aLl.live_id);
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
                        x aat3 = c.eep().aat();
                        if (aat3 != null && aat3.aLl != null) {
                            jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat3.aLl.live_id);
                        }
                        jSONObject3.put("error_code", 0);
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "get_token_from_imrtc").setContentExt(jSONObject3));
                    b.this.ozc.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16.1
                        @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                        public void onResult(int i2, String str3, @NonNull BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                x aat4 = c.eep().aat();
                                if (aat4 != null && aat4.aLl != null) {
                                    jSONObject4.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat4.aLl.live_id);
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
    public long eem() {
        return AccountManager.getUK(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC(final int i) {
        gN("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oyQ != null) {
                    b.this.oyQ.NF(i);
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
                if (b.this.oyQ != null) {
                    b.this.oyQ.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND(int i) {
        if (this.oyT != i) {
            if (i == 4) {
                if (this.ozb != null) {
                    this.ozb.removeCallbacks(this.ozn);
                }
                this.oyU = System.currentTimeMillis();
                this.oyT = i;
                NC(4);
                return;
            }
            x aat = c.eep().aat();
            if (aat != null && aat.aLy > 0.0d) {
                this.oyV = (long) (aat.aLy * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oyU;
            if (currentTimeMillis > this.oyV) {
                this.oyT = i;
                NC(5);
            } else if (this.ozb != null) {
                this.ozb.removeCallbacks(this.ozn);
                this.ozb.postDelayed(this.ozn, this.oyV - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oyU > 5000) {
            if (this.ozb != null) {
                this.ozb.removeCallbacks(this.ozn);
            }
            this.oyU = System.currentTimeMillis();
            this.oyT = i;
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
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
            Log.i(str, str2);
        }
    }

    public boolean een() {
        return this.oyX;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oyO != null) {
            this.oyO.sendMessageToUser(str, j);
        }
    }

    public String eeo() {
        return this.oyO != null ? this.oyO.eee() + "#" + this.ozj + ",isStartHeartBeat:" + this.oze + ",time:" + System.currentTimeMillis() : "";
    }
}
