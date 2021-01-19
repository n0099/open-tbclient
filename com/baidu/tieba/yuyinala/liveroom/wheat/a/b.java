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
    private boolean ouA;
    private volatile boolean ouB;
    private boolean ouC;
    private boolean ouD;
    private boolean ouE;
    private String ouF;
    private String ouG;
    private long ouH;
    private String ouL;
    private String ouM;
    private String ouN;
    private final g ouO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a ouj;
    private String ouk;
    private d oul;
    private int oum;
    private boolean oun;
    private int ouo;
    private long oup;
    private boolean our;
    private boolean ous;
    private String ouu;
    private String ouv;
    private HandlerThread ouw;
    private Handler oux;
    private f ouy;
    private long ouq = 2000;
    private boolean ouz = true;
    private Runnable ouI = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a bx = com.baidu.h.b.a.bx(b.this.mContext);
            if (bx == null) {
                if (b.this.ouj != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.ouG);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.ouj.aP("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.ouF = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) bx.Ya();
            if (bVar != null && !TextUtils.isEmpty(b.this.ouG)) {
                try {
                    cVar = bVar.in(b.this.ouG);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.ouj != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.ouG);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.ouj.aP("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.ouF = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).Yf().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.ouG, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gM("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.ouA && b.this.ouB && b.this.oux != null) {
                                b.this.oux.removeCallbacks(b.this.ouI);
                                b.this.oux.post(b.this.ouI);
                                if (System.currentTimeMillis() - b.this.ouH > 1000 && b.this.ouj != null) {
                                    b.this.ouH = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.ouG);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.ouj.aP("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.ouF = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.ouF = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.oux != null) {
                    b.this.oux.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.ouF = "heartbeaterror2," + b.this.ouG + "," + System.currentTimeMillis();
            if (b.this.ouj != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.ouG);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.ouj.aP("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable ouJ = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ouo != 5) {
                b.this.ouo = 5;
                b.this.LV(5);
            }
        }
    };
    private ILiveMsgReceiveListener ouK = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
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
                        if (b.this.gK(b.this.ouk, "用户被审核下麦")) {
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
                        if (b.this.oul != null) {
                            b.this.oul.PB();
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
                    if (b.this.oul != null) {
                        b.this.oul.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.oul != null) {
                        b.this.oul.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.oul != null) {
                        b.this.oul.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
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
                    if (b.this.ouO != null) {
                        b.this.ouO.hN(((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk());
                        return;
                    }
                    return;
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            int i = AnonymousClass19.ovn[roomEventType.ordinal()];
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
        this.ouG = str2;
        if (this.ouw == null) {
            this.ouw = new HandlerThread("AudioRoomManager_Thread");
            this.ouw.start();
        }
        if (this.oux == null && this.ouw.isAlive()) {
            this.oux = new Handler(this.ouw.getLooper());
        }
        this.ouy = new f(this.oux);
        this.ouO = new g(this.oux);
        this.ouO.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.g.a
            public void b(g.b bVar) {
                b.this.a(bVar);
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otP) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.azI);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.ouK);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gM("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.ouB = true;
                    if (b.this.oun && b.this.ouz) {
                        if (b.this.ous || b.this.our) {
                            b.this.ouy.join(b.this.mContext, b.this.ouk, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.oun = false;
                                        if (b.this.ouj != null && b.this.ouj.eai() != 4 && b.this.ouj.eai() != 0) {
                                            b.this.oum = 5;
                                            if (b.this.ouj != null) {
                                                b.this.ouj.aP("audio_room_manager", "", "reLoginRtcRoom1");
                                            }
                                            b.this.ouj.eaj();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.our) {
                                        b.this.ous = false;
                                    }
                                    b.this.r(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.oun = false;
                            if (b.this.ouj != null && b.this.ouj.eai() != 4 && b.this.ouj.eai() != 0) {
                                b.this.oum = 5;
                                if (b.this.ouj != null) {
                                    b.this.ouj.aP("audio_room_manager", "", "reLoginRtcRoom2");
                                }
                                b.this.ouj.eaj();
                            }
                        }
                    }
                    if (b.this.ouA) {
                        b.this.eaq();
                        return;
                    }
                    return;
                }
                b.this.ouB = false;
                if (b.this.ouj != null && b.this.ouj.eai() != 4 && b.this.ouj.eai() != 0) {
                    b.this.oun = true;
                }
            }
        };
        gM("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.ouj = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.ouj.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.r(1, b.this.oum, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.our) {
                    b.this.ous = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gM("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.our) {
                        b.this.ous = true;
                    }
                    if (b.this.ouj != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.ouj;
                        if (b.this.ouD || b.this.ouE) {
                            z = true;
                        }
                        aVar.zE(z);
                    }
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oul != null) {
                                if (b.this.oum == 4 || b.this.oum == 3 || b.this.oum == 2 || b.this.oum == 5) {
                                    b.this.eaq();
                                    if (b.this.oux != null) {
                                        b.this.oux.removeCallbacks(b.this.ouJ);
                                        b.this.oux.post(b.this.ouJ);
                                    }
                                }
                                b.this.oul.LX(b.this.oum);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.r(1, b.this.oum, i + ",connectionlost");
                    if (b.this.our) {
                        b.this.ous = false;
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
                        if (b.this.our) {
                            b.this.ous = false;
                        }
                        b.this.r(1, b.this.oum, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.our) {
                            b.this.ous = false;
                        }
                        b.this.r(1, b.this.oum, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.yB();
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oul != null) {
                                    b.this.oul.PB();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.eau()) {
                            b.this.LV(2);
                            b.this.ouE = true;
                            if (5 != b.this.ouo) {
                                b.this.ouo = 5;
                                b.this.LV(5);
                            }
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oul != null) {
                                    b.this.oul.v(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.eau()) {
                            b.this.LV(3);
                            b.this.ouE = false;
                        }
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oul != null) {
                                    b.this.oul.v(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.eau()) {
                            b.this.gK(b.this.ouk, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                            b.this.LV(1);
                            b.this.ouy.hangout(b.this.mContext, b.this.ouk, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.3
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
                                if (b.this.oul != null) {
                                    b.this.oul.bM(j);
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
                                if (b.this.oul != null) {
                                    b.this.oul.s(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oul != null) {
                                    b.this.oul.hL(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oul != null) {
                                    b.this.oul.hM(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oul != null) {
                                    b.this.oul.l(i, j, str3);
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
        this.oul = dVar;
    }

    public void Va(String str) {
        if (this.ouj != null) {
            this.ouj.n(str, false, true);
        }
    }

    public void eap() {
        aQ(c.eax().eaC(), TbadkCoreApplication.getCurrentAccountName(), this.ouv);
    }

    public void aQ(String str, final String str2, final String str3) {
        UZ("ownerEnterRoom");
        gM("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2 + "," + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.ouk = str;
        this.our = true;
        this.ous = false;
        this.ouu = str2;
        this.ouv = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oum = 1;
                            b.this.ouL = bIMRTCGetTokeResult.rtcAppId;
                            b.this.ouM = bIMRTCGetTokeResult.token;
                            b.this.ouN = bIMRTCGetTokeResult.roomId;
                            if (b.this.ouj != null) {
                                b.this.ouj.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eau(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.UZ("ownerEnterRoomJoinError:" + str4);
                b.this.r(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gJ(String str, String str2) {
        gM("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.our = false;
        this.ous = false;
        this.ouu = "";
        this.ouv = "";
        if (this.ouj != null) {
            this.ouj.UX(str2);
        }
    }

    public void L(String str, final String str2, final String str3, final String str4) {
        UZ("ownerJoinChat");
        gM("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            r(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.ouk = str;
        this.ous = true;
        aAl();
        if (this.our) {
            if (this.ouj != null) {
                this.ouj.logoutRoom();
            }
            this.ouy.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gL("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (eas() && this.ouj != null) {
            if (this.ouj != null) {
                this.ouj.aP("audio_room_manager", "", "reLoginRtcRoom3");
            }
            this.ouj.eaj();
            return;
        }
        if (!TextUtils.isEmpty(this.ouL) && !TextUtils.isEmpty(this.ouM) && !TextUtils.isEmpty(this.ouN)) {
            w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oum = 2;
                    if (b.this.ouj != null) {
                        b.this.ouj.b(b.this.ouL, b.this.ouM, b.this.ouN, b.this.eau(), str2, str3, str4);
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
                                b.this.oum = 2;
                                if (b.this.ouj != null) {
                                    b.this.ouj.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eau(), str2, str3, str4);
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
                    b.this.UZ("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.our) {
                        b.this.ous = false;
                    }
                    b.this.r(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void UZ(String str) {
        if (this.ouj != null) {
            this.ouj.UZ(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gM("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean UY(String str) {
        return c(this.ouk, true, str);
    }

    public boolean gK(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gM("AudioRoomManager", "quitChat:" + str);
        this.ouD = false;
        this.ouE = false;
        this.ouC = false;
        this.ous = false;
        if (this.ouj != null && this.ouj.UY(str2)) {
            if (z) {
                ear();
            }
            if (this.oux != null) {
                this.oux.removeCallbacks(this.ouJ);
            }
            this.ouy.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str3) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.our) {
                LV(6);
            }
            if (this.our) {
                aQ(str, this.ouu, this.ouv);
            }
            return true;
        }
        gL("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void Vb(String str) {
        gM("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void A(int i, final long j) {
                if (i == 0) {
                    b.this.w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.ouj != null) {
                                b.this.ouj.aF(j);
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
        this.ouD = z;
        if (z && 5 != this.ouo) {
            this.ouo = 5;
            LV(5);
        }
        if (this.ouj != null) {
            this.ouj.zE(z);
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
                            if (b.this.ouj != null) {
                                b.this.ouj.t(j, z);
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
        UZ("answerInvite");
        gM("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.our) {
            this.ous = true;
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
        this.ouy.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
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
                    if (b.this.our) {
                        b.this.ous = false;
                    }
                    if (i != 1 || z) {
                        b.this.gL("AudioRoomManager", i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.r(2, 3, "reject invite failed");
                    }
                    b.this.UZ("answerInvite:" + i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.oum = z ? 4 : 3;
                    if (b.this.our || !b.this.eas() || b.this.ouj == null) {
                        if (b.this.our && b.this.ouj != null) {
                            b.this.ouj.logoutRoom();
                        }
                        if (b.this.ouj != null) {
                            b.this.ouj.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.eau(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.ouj.aP("audio_room_manager", "", "reLoginRtcRoom4");
                    b.this.ouj.eaj();
                }
            }
        });
    }

    public void yB() {
        gM("AudioRoomManager", "leaveRoom");
        this.oun = false;
        ear();
        if (this.oux != null) {
            this.oux.removeCallbacksAndMessages(null);
        }
        if (this.ouw != null) {
            this.ouw.quit();
            this.oux = null;
        }
        if (this.our && this.mContext != null) {
            this.ouy.hangout(this.mContext, this.ouk, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gM("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.ouy.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.azI);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.ouK);
        if (this.ouj != null) {
            this.ouj.yB();
            this.ouj = null;
        }
    }

    public void aAl() {
        gM("AudioRoomManager", "pausePlayer");
        if (this.ouj != null) {
            this.ouj.aAl();
        }
    }

    public void yA() {
        zG(true);
    }

    public void zG(boolean z) {
        gM("AudioRoomManager", "closeRoom:" + z);
        if (this.ouj != null) {
            this.ouj.dZm();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.ouk);
            this.ouy.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
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
        if (this.ouj != null) {
            this.ouj.aP("audio_room_manager", "", "startHeartBeatAction");
        }
        this.ouA = true;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oux != null) {
                    b.this.oux.removeCallbacks(b.this.ouI);
                    b.this.oux.post(b.this.ouI);
                }
            }
        });
    }

    public void ear() {
        gM("AudioRoomManager", "stopHeartBeatAction");
        if (this.ouj != null) {
            this.ouj.aP("audio_room_manager", "", "startHeartBeatAction");
        }
        this.ouA = false;
        w(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oux != null) {
                    b.this.oux.removeCallbacks(b.this.ouI);
                }
            }
        });
    }

    public boolean eas() {
        return this.ouj != null && this.ouj.eai() == 2;
    }

    public int eai() {
        if (this.ouj != null) {
            return this.ouj.eai();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g.b bVar) {
        BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo();
        bIMCancelRtcInfo.setRtcRoomId(this.ouk);
        ArrayList arrayList = new ArrayList();
        BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
        bIMCancelUser.appId = bVar.appId;
        bIMCancelUser.uk = bVar.imUK;
        bIMCancelUser.cuid = bVar.cuid;
        bIMCancelUser.thirdUserId = bVar.thirdUserId;
        arrayList.add(bIMCancelUser);
        bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
        this.ouy.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                b.this.gM("AudioRoomManager", "cancelCall responseCode :" + i + ", msg :" + str);
            }
        });
    }

    public static boolean Vc(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.VE(str), 0L)));
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
        if (this.ouj != null) {
            return this.ouj.eak();
        }
        return true;
    }

    public void eat() {
        gM("AudioRoomManager", "reStartPlayer");
        if (this.ouj != null) {
            this.ouj.cmG();
        }
    }

    public boolean hI(long j) {
        if (this.ouj != null) {
            return this.ouj.hI(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.ous || (!this.our && eas())) {
            if (this.ouj != null) {
                if (z && !this.ouj.eal()) {
                    this.ouC = true;
                    this.ouj.zE(true);
                } else if (!z && this.ouC) {
                    this.ouj.zE(false);
                    this.ouC = false;
                }
            }
            if (this.ouj != null) {
                this.ouj.zF(z);
            }
        }
        if (this.ouj != null) {
            this.ouj.muteOrUnmuteAudio(z);
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
                    b.this.ouy.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
                    if (b.this.ouO != null) {
                        b.this.ouO.c(new g.b(j, j2, str4, str2));
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
        this.ouy.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
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
                    b.this.ouy.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16.1
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
                if (b.this.oul != null) {
                    b.this.oul.LY(i);
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
                if (b.this.oul != null) {
                    b.this.oul.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LW(int i) {
        if (this.ouo != i) {
            if (i == 4) {
                if (this.oux != null) {
                    this.oux.removeCallbacks(this.ouJ);
                }
                this.oup = System.currentTimeMillis();
                this.ouo = i;
                LV(4);
                return;
            }
            x WA = c.eax().WA();
            if (WA != null && WA.aGL > 0.0d) {
                this.ouq = (long) (WA.aGL * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oup;
            if (currentTimeMillis > this.ouq) {
                this.ouo = i;
                LV(5);
            } else if (this.oux != null) {
                this.oux.removeCallbacks(this.ouJ);
                this.oux.postDelayed(this.ouJ, this.ouq - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oup > 5000) {
            if (this.oux != null) {
                this.oux.removeCallbacks(this.ouJ);
            }
            this.oup = System.currentTimeMillis();
            this.ouo = i;
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
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otP) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otP) {
            Log.i(str, str2);
        }
    }

    public boolean eav() {
        return this.ous;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.ouj != null) {
            this.ouj.sendMessageToUser(str, j);
        }
    }

    public String eaw() {
        return this.ouj != null ? this.ouj.eam() + "#" + this.ouF + ",isStartHeartBeat:" + this.ouA + ",time:" + System.currentTimeMillis() : "";
    }
}
