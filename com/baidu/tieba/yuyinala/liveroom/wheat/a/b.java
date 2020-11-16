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
import com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickResSyncRtcInfo;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
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
    private f odA;
    private boolean odC;
    private volatile boolean odD;
    private boolean odE;
    private boolean odF;
    private boolean odG;
    private String odH;
    private String odI;
    private String odM;
    private String odN;
    private String odO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a odm;
    private String odn;
    private d odo;
    private int odp;
    private boolean odq;
    private int odr;
    private long ods;
    private boolean odu;
    private boolean odv;
    private String odw;
    private String odx;
    private HandlerThread ody;
    private Handler odz;
    private long odt = 2000;
    private boolean odB = true;
    private Runnable odJ = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a aJ = com.baidu.h.b.a.aJ(b.this.mContext);
            if (aJ == null) {
                b.this.odH = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) aJ.XC();
            if (bVar != null && !TextUtils.isEmpty(b.this.odI)) {
                try {
                    cVar = bVar.jb(b.this.odI);
                } catch (Exception e) {
                    e.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    b.this.odH = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).XH().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.odI, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gK("audioroom", "HeartBeat:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + j2);
                        if (i != 0) {
                            if (b.this.odC && b.this.odD && b.this.odz != null) {
                                b.this.odz.removeCallbacks(b.this.odJ);
                                b.this.odz.post(b.this.odJ);
                            }
                            b.this.odH = "heartbeaterrornum:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
                            return;
                        }
                        b.this.odH = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.odz != null) {
                    b.this.odz.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.odH = "heartbeaterror2," + b.this.odI + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
        }
    };
    private Runnable odK = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.odr != 5) {
                b.this.odr = 5;
                b.this.MT(5);
            }
        }
    };
    private ILiveMsgReceiveListener odL = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
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
                        if (b.this.Vk(b.this.odn)) {
                            b.this.MT(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };
    private BIMRtcListener aBy = new BIMRtcListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19
        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
            b.this.gK("AudioRoomManager", "onRtcResult,onRtcResult:action" + i);
            if (i == 89) {
                b.this.ze(false);
                b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.odo != null) {
                            b.this.odo.PU();
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
                    if (b.this.odo != null) {
                        b.this.odo.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.odo != null) {
                        b.this.odo.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.odo != null) {
                        b.this.odo.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
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
            }
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
            int i = AnonymousClass17.oel[roomEventType.ordinal()];
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

    /* loaded from: classes4.dex */
    public interface a {
        void B(int i, long j);
    }

    public b(Context context, String str, String str2) {
        this.mContext = context;
        this.mRoomId = str;
        this.odI = str2;
        if (this.ody == null) {
            this.ody = new HandlerThread("AudioRoomManager_Thread");
            this.ody.start();
        }
        if (this.odz == null && this.ody.isAlive()) {
            this.odz = new Handler(this.ody.getLooper());
        }
        this.odA = new f(this.odz);
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.aBy);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.odL);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gK("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.odD = true;
                    if (b.this.odq && b.this.odB) {
                        if (b.this.odv || b.this.odu) {
                            b.this.odA.join(b.this.mContext, b.this.odn, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.odq = false;
                                        if (b.this.odm != null && b.this.odm.dYv() != 4 && b.this.odm.dYv() != 0) {
                                            b.this.odp = 5;
                                            b.this.odm.dYw();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.odu) {
                                        b.this.odv = false;
                                    }
                                    b.this.p(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.odq = false;
                            if (b.this.odm != null && b.this.odm.dYv() != 4 && b.this.odm.dYv() != 0) {
                                b.this.odp = 5;
                                b.this.odm.dYw();
                            }
                        }
                    }
                    if (b.this.odC) {
                        b.this.dYD();
                        return;
                    }
                    return;
                }
                b.this.odD = false;
                if (b.this.odm != null && b.this.odm.dYv() != 4 && b.this.odm.dYv() != 0) {
                    b.this.odq = true;
                }
            }
        };
        gK("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.odm = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.odm.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.p(1, b.this.odp, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.odu) {
                    b.this.odv = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gK("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.odu) {
                        b.this.odv = true;
                    }
                    if (b.this.odm != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.odm;
                        if (b.this.odF || b.this.odG) {
                            z = true;
                        }
                        aVar.zc(z);
                    }
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.odo != null) {
                                if (b.this.odp == 4 || b.this.odp == 3 || b.this.odp == 2 || b.this.odp == 5) {
                                    b.this.dYD();
                                    if (b.this.odz != null) {
                                        b.this.odz.removeCallbacks(b.this.odK);
                                        b.this.odz.post(b.this.odK);
                                    }
                                }
                                b.this.odo.MV(b.this.odp);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.p(1, b.this.odp, i + ",connectionlost");
                    if (b.this.odu) {
                        b.this.odv = false;
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
                        if (b.this.odu) {
                            b.this.odv = false;
                        }
                        b.this.p(1, b.this.odp, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.odu) {
                            b.this.odv = false;
                        }
                        b.this.p(1, b.this.odp, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.Bw();
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.PU();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.dYH()) {
                            b.this.MT(2);
                            b.this.odG = true;
                            if (5 != b.this.odr) {
                                b.this.odr = 5;
                                b.this.MT(5);
                            }
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.t(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.dYH()) {
                            b.this.MT(3);
                            b.this.odG = false;
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.t(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.dYH()) {
                            b.this.Vk(b.this.odn);
                            b.this.MT(1);
                            b.this.odA.hangout(b.this.mContext, b.this.odn, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str4) {
                                    if (i2 != 0) {
                                        b.this.p(2, i2, "kickoffhangouterror:" + str4);
                                    }
                                }
                            });
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.bm(j);
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
                                if (b.this.odo != null) {
                                    b.this.odo.q(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.hm(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.hn(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.odo != null) {
                                    b.this.odo.j(i, j, str3);
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
                b.this.MU(4);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStopSpeak() {
                b.this.MU(5);
            }
        });
    }

    public void a(d dVar) {
        this.odo = dVar;
    }

    public void Vj(String str) {
        if (this.odm != null) {
            this.odm.n(str, false, true);
        }
    }

    public void dYC() {
        aK(c.dYK().dYP(), TbadkCoreApplication.getCurrentAccountName(), this.odx);
    }

    public void aK(String str, final String str2, final String str3) {
        Vi("ownerEnterRoom");
        gK("AudioRoomManager", "ownerEnterRoom:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            p(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.odn = str;
        this.odu = true;
        this.odv = false;
        this.odw = str2;
        this.odx = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.odp = 1;
                            b.this.odM = bIMRTCGetTokeResult.rtcAppId;
                            b.this.odN = bIMRTCGetTokeResult.token;
                            b.this.odO = bIMRTCGetTokeResult.roomId;
                            if (b.this.odm != null) {
                                b.this.odm.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.dYH(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.Vi("ownerEnterRoomJoinError:" + str4);
                b.this.p(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gI(String str, String str2) {
        gK("AudioRoomManager", "commonUserEnterRoom:," + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        this.odu = false;
        this.odv = false;
        this.odw = "";
        this.odx = "";
        if (this.odm != null) {
            this.odm.Vh(str2);
        }
    }

    public void M(String str, final String str2, final String str3, final String str4) {
        Vi("ownerJoinChat");
        gK("AudioRoomManager", "ownerJoinChat:," + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            p(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.odn = str;
        this.odv = true;
        azE();
        if (this.odu) {
            if (this.odm != null) {
                this.odm.logoutRoom();
            }
            this.odA.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gJ("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (dYF() && this.odm != null) {
            this.odm.dYw();
            return;
        }
        if (!TextUtils.isEmpty(this.odM) && !TextUtils.isEmpty(this.odN) && !TextUtils.isEmpty(this.odO)) {
            x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
                @Override // java.lang.Runnable
                public void run() {
                    b.this.odp = 2;
                    if (b.this.odm != null) {
                        b.this.odm.b(b.this.odM, b.this.odN, b.this.odO, b.this.dYH(), str2, str3, str4);
                    }
                }
            });
        } else {
            a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                public void onResult(int i, String str5, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                    if (i == 0 && bIMRTCGetTokeResult != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_and_get_rtc_token_succ_host_3", true);
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.odp = 2;
                                if (b.this.odm != null) {
                                    b.this.odm.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.dYH(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    b.this.Vi("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.odu) {
                        b.this.odv = false;
                    }
                    b.this.p(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Vi(String str) {
        if (this.odm != null) {
            this.odm.Vi(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gK("AudioRoomManager", "inviteJoinChat:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean dYu() {
        return bf(this.odn, true);
    }

    public boolean Vk(String str) {
        return bf(str, true);
    }

    public boolean bf(String str, boolean z) {
        gK("AudioRoomManager", "quitChat:" + str);
        this.odF = false;
        this.odG = false;
        this.odE = false;
        this.odv = false;
        if (this.odm != null && this.odm.dYu()) {
            if (z) {
                dYE();
            }
            if (this.odz != null) {
                this.odz.removeCallbacks(this.odK);
            }
            this.odA.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i != 0) {
                        b.this.gK("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.odu) {
                MT(6);
            }
            if (this.odu) {
                aK(str, this.odw, this.odx);
            }
            return true;
        }
        gJ("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void Vl(String str) {
        gK("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.odm != null) {
                                b.this.odm.ai(j);
                            }
                        }
                    });
                } else {
                    b.this.p(2, 5, "kickOffUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void zc(boolean z) {
        gK("AudioRoomManager", "muteMic:" + z);
        this.odF = z;
        if (z && 5 != this.odr) {
            this.odr = 5;
            MT(5);
        }
        if (this.odm != null) {
            this.odm.zc(z);
        }
    }

    public void bg(String str, final boolean z) {
        gK("AudioRoomManager", "muteUser:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + z);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.odm != null) {
                                b.this.odm.r(j, z);
                            }
                        }
                    });
                } else {
                    b.this.p(2, 4, "muteUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, final int i, final String str, final String str2, final String str3, final boolean z, String str4) {
        Vi("answerInvite");
        gK("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.odu) {
            this.odv = true;
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
        this.odA.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    if (b.this.odu) {
                        b.this.odv = false;
                    }
                    if (i != 1 || z) {
                        b.this.gJ("AudioRoomManager", i2 + "answererror:" + str5 + Constants.ACCEPT_TIME_SEPARATOR_SP + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.p(2, 3, "reject invite failed");
                    }
                    b.this.Vi("answerInvite:" + i2 + "answererror:" + str5 + Constants.ACCEPT_TIME_SEPARATOR_SP + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.odp = z ? 4 : 3;
                    if (b.this.odu || !b.this.dYF() || b.this.odm == null) {
                        if (b.this.odu && b.this.odm != null) {
                            b.this.odm.logoutRoom();
                        }
                        if (b.this.odm != null) {
                            b.this.odm.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.dYH(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.odm.dYw();
                }
            }
        });
    }

    public void Bw() {
        gK("AudioRoomManager", "leaveRoom");
        this.odq = false;
        dYE();
        if (this.odz != null) {
            this.odz.removeCallbacksAndMessages(null);
        }
        if (this.ody != null) {
            this.ody.quit();
            this.odz = null;
        }
        if (this.odu && this.mContext != null) {
            this.odA.hangout(this.mContext, this.odn, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gK("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.odA.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aBy);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.odL);
        if (this.odm != null) {
            this.odm.Bw();
            this.odm = null;
        }
    }

    public void azE() {
        gK("AudioRoomManager", "pausePlayer");
        if (this.odm != null) {
            this.odm.azE();
        }
    }

    public void Bv() {
        ze(true);
    }

    public void ze(boolean z) {
        gK("AudioRoomManager", "closeRoom:" + z);
        if (this.odm != null) {
            this.odm.dYh();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.odn);
            this.odA.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gJ("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void dYD() {
        gK("AudioRoomManager", "startHeartBeatAction");
        this.odC = true;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.odz != null) {
                    b.this.odz.removeCallbacks(b.this.odJ);
                    b.this.odz.post(b.this.odJ);
                }
            }
        });
    }

    public void dYE() {
        gK("AudioRoomManager", "stopHeartBeatAction");
        this.odC = false;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.odz != null) {
                    b.this.odz.removeCallbacks(b.this.odJ);
                }
            }
        });
    }

    public boolean dYF() {
        return this.odm != null && this.odm.dYv() == 2;
    }

    public int dYv() {
        if (this.odm != null) {
            return this.odm.dYv();
        }
        return -1;
    }

    public static boolean Vm(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.VL(str), 0L)));
            BIMManager.getUsersProfiles(this.mContext, arrayList, true, new IGetUsersProfileBatchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
                @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
                public void onGetUsersProfileBatchResult(int i, String str2, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                    if (i == 0 && ListUtils.getCount(arrayList3) == 1) {
                        aVar.B(0, arrayList3.get(0).getUk());
                    } else {
                        aVar.B(-1, 0L);
                    }
                }
            });
        }
    }

    public boolean dYx() {
        if (this.odm != null) {
            return this.odm.dYx();
        }
        return true;
    }

    public void dYG() {
        gK("AudioRoomManager", "reStartPlayer");
        if (this.odm != null) {
            this.odm.cjJ();
        }
    }

    public boolean hj(long j) {
        if (this.odm != null) {
            return this.odm.hj(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.odv || (!this.odu && dYF())) {
            if (this.odm != null) {
                if (z && !this.odm.dYy()) {
                    this.odE = true;
                    this.odm.zc(true);
                } else if (!z && this.odE) {
                    this.odm.zc(false);
                    this.odE = false;
                }
            }
            if (this.odm != null) {
                this.odm.zd(z);
            }
        }
        if (this.odm != null) {
            this.odm.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, long j2) {
                if (i != 0) {
                    b.this.p(2, z ? 2 : 1, "inviteError:" + z);
                    if (iStatusListener != null) {
                        iStatusListener.onResult(i, "inviteEventgetIMUKFromBdUKError");
                        return;
                    }
                    return;
                }
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
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("invite_name", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
                    jSONObject.put("invite_uk", o.dZz().WD());
                    jSONObject.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                    jSONObject.put("pushUrl", str5);
                    jSONObject.put("pushSingleUrl", str6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bIMInviteRtcInfo.setRtcExt(jSONObject.toString());
                b.this.odA.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
            }
        });
    }

    private void a(final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        this.odA.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    b.this.odA.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), bIMRtcTokenListener);
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, "joinIMRTCRoom failed：" + str2, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long dYH() {
        return AccountManager.getUK(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MT(final int i) {
        gK("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.odo != null) {
                    b.this.odo.MW(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final int i, final int i2, final String str) {
        gK("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.odo != null) {
                    b.this.odo.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU(int i) {
        if (this.odr != i) {
            if (i == 4) {
                if (this.odz != null) {
                    this.odz.removeCallbacks(this.odK);
                }
                this.ods = System.currentTimeMillis();
                this.odr = i;
                MT(4);
                return;
            }
            w WE = c.dYK().WE();
            if (WE != null && WE.aIm > 0.0d) {
                this.odt = (long) (WE.aIm * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.ods;
            if (currentTimeMillis > this.odt) {
                this.odr = i;
                MT(5);
            } else if (this.odz != null) {
                this.odz.removeCallbacks(this.odK);
                this.odz.postDelayed(this.odK, this.odt - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.ods > 5000) {
            if (this.odz != null) {
                this.odz.removeCallbacks(this.odK);
            }
            this.ods = System.currentTimeMillis();
            this.odr = i;
            MT(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
            Log.i(str, str2);
        }
    }

    public boolean dYI() {
        return this.odv;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.odm != null) {
            this.odm.sendMessageToUser(str, j);
        }
    }

    public String dYJ() {
        return this.odm != null ? this.odm.dYz() + "#" + this.odH + ",isStartHeartBeat:" + this.odC + ",time:" + System.currentTimeMillis() : "";
    }
}
