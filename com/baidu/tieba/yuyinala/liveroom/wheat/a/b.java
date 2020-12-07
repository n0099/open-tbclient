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
    private f osA;
    private boolean osC;
    private volatile boolean osD;
    private boolean osE;
    private boolean osF;
    private boolean osG;
    private String osH;
    private String osI;
    private String osM;
    private String osN;
    private String osO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a osm;
    private String osn;
    private d oso;
    private int osp;
    private boolean osq;
    private int osr;
    private long oss;
    private boolean osu;
    private boolean osv;
    private String osw;
    private String osx;
    private HandlerThread osy;
    private Handler osz;
    private long ost = 2000;
    private boolean osB = true;
    private Runnable osJ = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.i.a.b.c cVar;
            com.baidu.i.b.a bn = com.baidu.i.b.a.bn(b.this.mContext);
            if (bn == null) {
                b.this.osH = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.i.b.a.a.b bVar = (com.baidu.i.b.a.a.b) bn.aaf();
            if (bVar != null && !TextUtils.isEmpty(b.this.osI)) {
                try {
                    cVar = bVar.jF(b.this.osI);
                } catch (Exception e) {
                    e.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    b.this.osH = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.i.b.a.a) cVar).aak().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.osI, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gP("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.osC && b.this.osD && b.this.osz != null) {
                                b.this.osz.removeCallbacks(b.this.osJ);
                                b.this.osz.post(b.this.osJ);
                            }
                            b.this.osH = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.osH = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.osz != null) {
                    b.this.osz.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.osH = "heartbeaterror2," + b.this.osI + "," + System.currentTimeMillis();
        }
    };
    private Runnable osK = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.osr != 5) {
                b.this.osr = 5;
                b.this.NL(5);
            }
        }
    };
    private ILiveMsgReceiveListener osL = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
        @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
        public void onReceiveMessage(int i, JSONArray jSONArray) {
            b.this.gP("AudioRoomManager", "receiveb2cmsg:" + i + "," + jSONArray.toString());
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
                        b.this.gP("AudioRoomManager", "do send audio_link_apply_toast");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("audio_link_cancel_apply", (CharSequence) entry.getKey())) {
                        b.this.gP("AudioRoomManager", "do send audio_link_cancel_apply");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("live_audio_lower_wheat", (CharSequence) entry.getKey())) {
                        b.this.gP("AudioRoomManager", "do live_audio_lower_wheat");
                        if (b.this.Wz(b.this.osn)) {
                            b.this.NL(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };
    private BIMRtcListener aEe = new BIMRtcListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19
        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
            b.this.gP("AudioRoomManager", "onRtcResult,onRtcResult:action" + i);
            if (i == 89) {
                b.this.zI(false);
                b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oso != null) {
                            b.this.oso.Ss();
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
                    if (b.this.oso != null) {
                        b.this.oso.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.oso != null) {
                        b.this.oso.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.oso != null) {
                        b.this.oso.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("receive_invite_anchor_5", false);
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
            int i = AnonymousClass17.otl[roomEventType.ordinal()];
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
        this.osI = str2;
        if (this.osy == null) {
            this.osy = new HandlerThread("AudioRoomManager_Thread");
            this.osy.start();
        }
        if (this.osz == null && this.osy.isAlive()) {
            this.osz = new Handler(this.osy.getLooper());
        }
        this.osA = new f(this.osz);
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.aEe);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.osL);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gP("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.osD = true;
                    if (b.this.osq && b.this.osB) {
                        if (b.this.osv || b.this.osu) {
                            b.this.osA.join(b.this.mContext, b.this.osn, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.osq = false;
                                        if (b.this.osm != null && b.this.osm.edZ() != 4 && b.this.osm.edZ() != 0) {
                                            b.this.osp = 5;
                                            b.this.osm.eea();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.osu) {
                                        b.this.osv = false;
                                    }
                                    b.this.q(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.osq = false;
                            if (b.this.osm != null && b.this.osm.edZ() != 4 && b.this.osm.edZ() != 0) {
                                b.this.osp = 5;
                                b.this.osm.eea();
                            }
                        }
                    }
                    if (b.this.osC) {
                        b.this.eeh();
                        return;
                    }
                    return;
                }
                b.this.osD = false;
                if (b.this.osm != null && b.this.osm.edZ() != 4 && b.this.osm.edZ() != 0) {
                    b.this.osq = true;
                }
            }
        };
        gP("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.osm = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.osm.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.q(1, b.this.osp, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.osu) {
                    b.this.osv = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gP("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.osu) {
                        b.this.osv = true;
                    }
                    if (b.this.osm != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.osm;
                        if (b.this.osF || b.this.osG) {
                            z = true;
                        }
                        aVar.zG(z);
                    }
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oso != null) {
                                if (b.this.osp == 4 || b.this.osp == 3 || b.this.osp == 2 || b.this.osp == 5) {
                                    b.this.eeh();
                                    if (b.this.osz != null) {
                                        b.this.osz.removeCallbacks(b.this.osK);
                                        b.this.osz.post(b.this.osK);
                                    }
                                }
                                b.this.oso.NN(b.this.osp);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.q(1, b.this.osp, i + ",connectionlost");
                    if (b.this.osu) {
                        b.this.osv = false;
                    }
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
                b.this.gP("AudioRoomManager", "rtcroom,onRoomDataMessage");
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onRoomEventUpdate(final int i, final long j, final String str3) {
                if (i != 200) {
                    b.this.gP("AudioRoomManager", "rtcroom,onRoomEventUpdate:" + i + ",data:" + j + ",ext:" + str3);
                }
                switch (i) {
                    case 100:
                    default:
                        return;
                    case 101:
                    case 102:
                        if (b.this.osu) {
                            b.this.osv = false;
                        }
                        b.this.q(1, b.this.osp, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.osu) {
                            b.this.osv = false;
                        }
                        b.this.q(1, b.this.osp, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.Df();
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oso != null) {
                                    b.this.oso.Ss();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.eel()) {
                            b.this.NL(2);
                            b.this.osG = true;
                            if (5 != b.this.osr) {
                                b.this.osr = 5;
                                b.this.NL(5);
                            }
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oso != null) {
                                    b.this.oso.t(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.eel()) {
                            b.this.NL(3);
                            b.this.osG = false;
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oso != null) {
                                    b.this.oso.t(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.eel()) {
                            b.this.Wz(b.this.osn);
                            b.this.NL(1);
                            b.this.osA.hangout(b.this.mContext, b.this.osn, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
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
                                if (b.this.oso != null) {
                                    b.this.oso.bL(j);
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
                                if (b.this.oso != null) {
                                    b.this.oso.r(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oso != null) {
                                    b.this.oso.hR(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oso != null) {
                                    b.this.oso.hS(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oso != null) {
                                    b.this.oso.j(i, j, str3);
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
                b.this.NM(4);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStopSpeak() {
                b.this.NM(5);
            }
        });
    }

    public void a(d dVar) {
        this.oso = dVar;
    }

    public void Wy(String str) {
        if (this.osm != null) {
            this.osm.n(str, false, true);
        }
    }

    public void eeg() {
        aN(c.eeo().eet(), TbadkCoreApplication.getCurrentAccountName(), this.osx);
    }

    public void aN(String str, final String str2, final String str3) {
        Wx("ownerEnterRoom");
        gP("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2 + "," + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.osn = str;
        this.osu = true;
        this.osv = false;
        this.osw = str2;
        this.osx = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.osp = 1;
                            b.this.osM = bIMRTCGetTokeResult.rtcAppId;
                            b.this.osN = bIMRTCGetTokeResult.token;
                            b.this.osO = bIMRTCGetTokeResult.roomId;
                            if (b.this.osm != null) {
                                b.this.osm.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eel(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.Wx("ownerEnterRoomJoinError:" + str4);
                b.this.q(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gN(String str, String str2) {
        gP("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.osu = false;
        this.osv = false;
        this.osw = "";
        this.osx = "";
        if (this.osm != null) {
            this.osm.Ww(str2);
        }
    }

    public void M(String str, final String str2, final String str3, final String str4) {
        Wx("ownerJoinChat");
        gP("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.osn = str;
        this.osv = true;
        aCN();
        if (this.osu) {
            if (this.osm != null) {
                this.osm.logoutRoom();
            }
            this.osA.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gO("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (eej() && this.osm != null) {
            this.osm.eea();
            return;
        }
        if (!TextUtils.isEmpty(this.osM) && !TextUtils.isEmpty(this.osN) && !TextUtils.isEmpty(this.osO)) {
            x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
                @Override // java.lang.Runnable
                public void run() {
                    b.this.osp = 2;
                    if (b.this.osm != null) {
                        b.this.osm.b(b.this.osM, b.this.osN, b.this.osO, b.this.eel(), str2, str3, str4);
                    }
                }
            });
        } else {
            a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                public void onResult(int i, String str5, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                    if (i == 0 && bIMRTCGetTokeResult != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("join_and_get_rtc_token_succ_host_3", true);
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.osp = 2;
                                if (b.this.osm != null) {
                                    b.this.osm.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eel(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    b.this.Wx("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.osu) {
                        b.this.osv = false;
                    }
                    b.this.q(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Wx(String str) {
        if (this.osm != null) {
            this.osm.Wx(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gP("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean edY() {
        return bg(this.osn, true);
    }

    public boolean Wz(String str) {
        return bg(str, true);
    }

    public boolean bg(String str, boolean z) {
        gP("AudioRoomManager", "quitChat:" + str);
        this.osF = false;
        this.osG = false;
        this.osE = false;
        this.osv = false;
        if (this.osm != null && this.osm.edY()) {
            if (z) {
                eei();
            }
            if (this.osz != null) {
                this.osz.removeCallbacks(this.osK);
            }
            this.osA.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i != 0) {
                        b.this.gP("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.osu) {
                NL(6);
            }
            if (this.osu) {
                aN(str, this.osw, this.osx);
            }
            return true;
        }
        gO("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void WA(String str) {
        gP("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.osm != null) {
                                b.this.osm.aG(j);
                            }
                        }
                    });
                } else {
                    b.this.q(2, 5, "kickOffUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void zG(boolean z) {
        gP("AudioRoomManager", "muteMic:" + z);
        this.osF = z;
        if (z && 5 != this.osr) {
            this.osr = 5;
            NL(5);
        }
        if (this.osm != null) {
            this.osm.zG(z);
        }
    }

    public void bh(String str, final boolean z) {
        gP("AudioRoomManager", "muteUser:" + str + "," + z);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.osm != null) {
                                b.this.osm.r(j, z);
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
        Wx("answerInvite");
        gP("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.osu) {
            this.osv = true;
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
        this.osA.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    if (b.this.osu) {
                        b.this.osv = false;
                    }
                    if (i != 1 || z) {
                        b.this.gO("AudioRoomManager", i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.q(2, 3, "reject invite failed");
                    }
                    b.this.Wx("answerInvite:" + i2 + "answererror:" + str5 + "," + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.osp = z ? 4 : 3;
                    if (b.this.osu || !b.this.eej() || b.this.osm == null) {
                        if (b.this.osu && b.this.osm != null) {
                            b.this.osm.logoutRoom();
                        }
                        if (b.this.osm != null) {
                            b.this.osm.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.eel(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.osm.eea();
                }
            }
        });
    }

    public void Df() {
        gP("AudioRoomManager", "leaveRoom");
        this.osq = false;
        eei();
        if (this.osz != null) {
            this.osz.removeCallbacksAndMessages(null);
        }
        if (this.osy != null) {
            this.osy.quit();
            this.osz = null;
        }
        if (this.osu && this.mContext != null) {
            this.osA.hangout(this.mContext, this.osn, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gP("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.osA.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aEe);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.osL);
        if (this.osm != null) {
            this.osm.Df();
            this.osm = null;
        }
    }

    public void aCN() {
        gP("AudioRoomManager", "pausePlayer");
        if (this.osm != null) {
            this.osm.aCN();
        }
    }

    public void De() {
        zI(true);
    }

    public void zI(boolean z) {
        gP("AudioRoomManager", "closeRoom:" + z);
        if (this.osm != null) {
            this.osm.edL();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.osn);
            this.osA.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gO("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void eeh() {
        gP("AudioRoomManager", "startHeartBeatAction");
        this.osC = true;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.osz != null) {
                    b.this.osz.removeCallbacks(b.this.osJ);
                    b.this.osz.post(b.this.osJ);
                }
            }
        });
    }

    public void eei() {
        gP("AudioRoomManager", "stopHeartBeatAction");
        this.osC = false;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.osz != null) {
                    b.this.osz.removeCallbacks(b.this.osJ);
                }
            }
        });
    }

    public boolean eej() {
        return this.osm != null && this.osm.edZ() == 2;
    }

    public int edZ() {
        if (this.osm != null) {
            return this.osm.edZ();
        }
        return -1;
    }

    public static boolean WB(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.Xa(str), 0L)));
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

    public boolean eeb() {
        if (this.osm != null) {
            return this.osm.eeb();
        }
        return true;
    }

    public void eek() {
        gP("AudioRoomManager", "reStartPlayer");
        if (this.osm != null) {
            this.osm.cnE();
        }
    }

    public boolean hO(long j) {
        if (this.osm != null) {
            return this.osm.hO(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.osv || (!this.osu && eej())) {
            if (this.osm != null) {
                if (z && !this.osm.eec()) {
                    this.osE = true;
                    this.osm.zG(true);
                } else if (!z && this.osE) {
                    this.osm.zG(false);
                    this.osE = false;
                }
            }
            if (this.osm != null) {
                this.osm.zH(z);
            }
        }
        if (this.osm != null) {
            this.osm.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, long j2) {
                if (i != 0) {
                    b.this.q(2, z ? 2 : 1, "inviteError:" + z);
                    if (iStatusListener != null) {
                        iStatusListener.onResult(i, "inviteEventgetIMUKFromBdUKError");
                        return;
                    }
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("get_imuk_from_bduk_anchor_3", false);
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
                    jSONObject.put("invite_uk", o.efd().Zc());
                    jSONObject.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                    jSONObject.put("pushUrl", str5);
                    jSONObject.put("pushSingleUrl", str6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bIMInviteRtcInfo.setRtcExt(jSONObject.toString());
                b.this.osA.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
            }
        });
    }

    private void a(final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        this.osA.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    b.this.osA.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), bIMRtcTokenListener);
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
    public void NL(final int i) {
        gP("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oso != null) {
                    b.this.oso.NO(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final int i, final int i2, final String str) {
        gP("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oso != null) {
                    b.this.oso.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NM(int i) {
        if (this.osr != i) {
            if (i == 4) {
                if (this.osz != null) {
                    this.osz.removeCallbacks(this.osK);
                }
                this.oss = System.currentTimeMillis();
                this.osr = i;
                NL(4);
                return;
            }
            w Zd = c.eeo().Zd();
            if (Zd != null && Zd.aKY > 0.0d) {
                this.ost = (long) (Zd.aKY * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oss;
            if (currentTimeMillis > this.ost) {
                this.osr = i;
                NL(5);
            } else if (this.osz != null) {
                this.osz.removeCallbacks(this.osK);
                this.osz.postDelayed(this.osK, this.ost - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oss > 5000) {
            if (this.osz != null) {
                this.osz.removeCallbacks(this.osK);
            }
            this.oss = System.currentTimeMillis();
            this.osr = i;
            NL(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
            Log.i(str, str2);
        }
    }

    public boolean eem() {
        return this.osv;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.osm != null) {
            this.osm.sendMessageToUser(str, j);
        }
    }

    public String een() {
        return this.osm != null ? this.osm.eed() + "#" + this.osH + ",isStartHeartBeat:" + this.osC + ",time:" + System.currentTimeMillis() : "";
    }
}
