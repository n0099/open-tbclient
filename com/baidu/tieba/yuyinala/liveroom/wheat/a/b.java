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
    private HandlerThread osA;
    private Handler osB;
    private f osC;
    private boolean osE;
    private volatile boolean osF;
    private boolean osG;
    private boolean osH;
    private boolean osI;
    private String osJ;
    private String osK;
    private String osO;
    private String osP;
    private String osQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oso;
    private String osp;
    private d osq;
    private int osr;
    private boolean oss;
    private int ost;
    private long osu;
    private boolean osw;
    private boolean osx;
    private String osy;
    private String osz;
    private long osv = 2000;
    private boolean osD = true;
    private Runnable osL = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.i.a.b.c cVar;
            com.baidu.i.b.a bn = com.baidu.i.b.a.bn(b.this.mContext);
            if (bn == null) {
                b.this.osJ = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.i.b.a.a.b bVar = (com.baidu.i.b.a.a.b) bn.aaf();
            if (bVar != null && !TextUtils.isEmpty(b.this.osK)) {
                try {
                    cVar = bVar.jF(b.this.osK);
                } catch (Exception e) {
                    e.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    b.this.osJ = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.i.b.a.a) cVar).aak().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.osK, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gP("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.osE && b.this.osF && b.this.osB != null) {
                                b.this.osB.removeCallbacks(b.this.osL);
                                b.this.osB.post(b.this.osL);
                            }
                            b.this.osJ = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.osJ = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.osB != null) {
                    b.this.osB.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.osJ = "heartbeaterror2," + b.this.osK + "," + System.currentTimeMillis();
        }
    };
    private Runnable osM = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ost != 5) {
                b.this.ost = 5;
                b.this.NL(5);
            }
        }
    };
    private ILiveMsgReceiveListener osN = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
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
                        if (b.this.Wz(b.this.osp)) {
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
                        if (b.this.osq != null) {
                            b.this.osq.Ss();
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
                    if (b.this.osq != null) {
                        b.this.osq.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.osq != null) {
                        b.this.osq.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.osq != null) {
                        b.this.osq.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
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
            int i = AnonymousClass17.otn[roomEventType.ordinal()];
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
        this.osK = str2;
        if (this.osA == null) {
            this.osA = new HandlerThread("AudioRoomManager_Thread");
            this.osA.start();
        }
        if (this.osB == null && this.osA.isAlive()) {
            this.osB = new Handler(this.osA.getLooper());
        }
        this.osC = new f(this.osB);
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.aEe);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.osN);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gP("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.osF = true;
                    if (b.this.oss && b.this.osD) {
                        if (b.this.osx || b.this.osw) {
                            b.this.osC.join(b.this.mContext, b.this.osp, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.oss = false;
                                        if (b.this.oso != null && b.this.oso.eea() != 4 && b.this.oso.eea() != 0) {
                                            b.this.osr = 5;
                                            b.this.oso.eeb();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.osw) {
                                        b.this.osx = false;
                                    }
                                    b.this.q(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.oss = false;
                            if (b.this.oso != null && b.this.oso.eea() != 4 && b.this.oso.eea() != 0) {
                                b.this.osr = 5;
                                b.this.oso.eeb();
                            }
                        }
                    }
                    if (b.this.osE) {
                        b.this.eei();
                        return;
                    }
                    return;
                }
                b.this.osF = false;
                if (b.this.oso != null && b.this.oso.eea() != 4 && b.this.oso.eea() != 0) {
                    b.this.oss = true;
                }
            }
        };
        gP("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.oso = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oso.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.q(1, b.this.osr, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.osw) {
                    b.this.osx = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gP("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.osw) {
                        b.this.osx = true;
                    }
                    if (b.this.oso != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.oso;
                        if (b.this.osH || b.this.osI) {
                            z = true;
                        }
                        aVar.zG(z);
                    }
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.osq != null) {
                                if (b.this.osr == 4 || b.this.osr == 3 || b.this.osr == 2 || b.this.osr == 5) {
                                    b.this.eei();
                                    if (b.this.osB != null) {
                                        b.this.osB.removeCallbacks(b.this.osM);
                                        b.this.osB.post(b.this.osM);
                                    }
                                }
                                b.this.osq.NN(b.this.osr);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.q(1, b.this.osr, i + ",connectionlost");
                    if (b.this.osw) {
                        b.this.osx = false;
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
                        if (b.this.osw) {
                            b.this.osx = false;
                        }
                        b.this.q(1, b.this.osr, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.osw) {
                            b.this.osx = false;
                        }
                        b.this.q(1, b.this.osr, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.Df();
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.osq != null) {
                                    b.this.osq.Ss();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.eem()) {
                            b.this.NL(2);
                            b.this.osI = true;
                            if (5 != b.this.ost) {
                                b.this.ost = 5;
                                b.this.NL(5);
                            }
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.osq != null) {
                                    b.this.osq.t(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.eem()) {
                            b.this.NL(3);
                            b.this.osI = false;
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.osq != null) {
                                    b.this.osq.t(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.eem()) {
                            b.this.Wz(b.this.osp);
                            b.this.NL(1);
                            b.this.osC.hangout(b.this.mContext, b.this.osp, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
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
                                if (b.this.osq != null) {
                                    b.this.osq.bL(j);
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
                                if (b.this.osq != null) {
                                    b.this.osq.r(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.osq != null) {
                                    b.this.osq.hR(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.osq != null) {
                                    b.this.osq.hS(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.osq != null) {
                                    b.this.osq.j(i, j, str3);
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
        this.osq = dVar;
    }

    public void Wy(String str) {
        if (this.oso != null) {
            this.oso.n(str, false, true);
        }
    }

    public void eeh() {
        aN(c.eep().eeu(), TbadkCoreApplication.getCurrentAccountName(), this.osz);
    }

    public void aN(String str, final String str2, final String str3) {
        Wx("ownerEnterRoom");
        gP("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2 + "," + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.osp = str;
        this.osw = true;
        this.osx = false;
        this.osy = str2;
        this.osz = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.osr = 1;
                            b.this.osO = bIMRTCGetTokeResult.rtcAppId;
                            b.this.osP = bIMRTCGetTokeResult.token;
                            b.this.osQ = bIMRTCGetTokeResult.roomId;
                            if (b.this.oso != null) {
                                b.this.oso.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eem(), str2, str3);
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
        this.osw = false;
        this.osx = false;
        this.osy = "";
        this.osz = "";
        if (this.oso != null) {
            this.oso.Ww(str2);
        }
    }

    public void M(String str, final String str2, final String str3, final String str4) {
        Wx("ownerJoinChat");
        gP("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.osp = str;
        this.osx = true;
        aCN();
        if (this.osw) {
            if (this.oso != null) {
                this.oso.logoutRoom();
            }
            this.osC.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gO("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (eek() && this.oso != null) {
            this.oso.eeb();
            return;
        }
        if (!TextUtils.isEmpty(this.osO) && !TextUtils.isEmpty(this.osP) && !TextUtils.isEmpty(this.osQ)) {
            x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
                @Override // java.lang.Runnable
                public void run() {
                    b.this.osr = 2;
                    if (b.this.oso != null) {
                        b.this.oso.b(b.this.osO, b.this.osP, b.this.osQ, b.this.eem(), str2, str3, str4);
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
                                b.this.osr = 2;
                                if (b.this.oso != null) {
                                    b.this.oso.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.eem(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    b.this.Wx("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.osw) {
                        b.this.osx = false;
                    }
                    b.this.q(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Wx(String str) {
        if (this.oso != null) {
            this.oso.Wx(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gP("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean edZ() {
        return bg(this.osp, true);
    }

    public boolean Wz(String str) {
        return bg(str, true);
    }

    public boolean bg(String str, boolean z) {
        gP("AudioRoomManager", "quitChat:" + str);
        this.osH = false;
        this.osI = false;
        this.osG = false;
        this.osx = false;
        if (this.oso != null && this.oso.edZ()) {
            if (z) {
                eej();
            }
            if (this.osB != null) {
                this.osB.removeCallbacks(this.osM);
            }
            this.osC.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i != 0) {
                        b.this.gP("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.osw) {
                NL(6);
            }
            if (this.osw) {
                aN(str, this.osy, this.osz);
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
                            if (b.this.oso != null) {
                                b.this.oso.aG(j);
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
        this.osH = z;
        if (z && 5 != this.ost) {
            this.ost = 5;
            NL(5);
        }
        if (this.oso != null) {
            this.oso.zG(z);
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
                            if (b.this.oso != null) {
                                b.this.oso.r(j, z);
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
        if (this.osw) {
            this.osx = true;
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
        this.osC.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    if (b.this.osw) {
                        b.this.osx = false;
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
                    b.this.osr = z ? 4 : 3;
                    if (b.this.osw || !b.this.eek() || b.this.oso == null) {
                        if (b.this.osw && b.this.oso != null) {
                            b.this.oso.logoutRoom();
                        }
                        if (b.this.oso != null) {
                            b.this.oso.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.eem(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.oso.eeb();
                }
            }
        });
    }

    public void Df() {
        gP("AudioRoomManager", "leaveRoom");
        this.oss = false;
        eej();
        if (this.osB != null) {
            this.osB.removeCallbacksAndMessages(null);
        }
        if (this.osA != null) {
            this.osA.quit();
            this.osB = null;
        }
        if (this.osw && this.mContext != null) {
            this.osC.hangout(this.mContext, this.osp, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gP("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.osC.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aEe);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.osN);
        if (this.oso != null) {
            this.oso.Df();
            this.oso = null;
        }
    }

    public void aCN() {
        gP("AudioRoomManager", "pausePlayer");
        if (this.oso != null) {
            this.oso.aCN();
        }
    }

    public void De() {
        zI(true);
    }

    public void zI(boolean z) {
        gP("AudioRoomManager", "closeRoom:" + z);
        if (this.oso != null) {
            this.oso.edM();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.osp);
            this.osC.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gO("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void eei() {
        gP("AudioRoomManager", "startHeartBeatAction");
        this.osE = true;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.osB != null) {
                    b.this.osB.removeCallbacks(b.this.osL);
                    b.this.osB.post(b.this.osL);
                }
            }
        });
    }

    public void eej() {
        gP("AudioRoomManager", "stopHeartBeatAction");
        this.osE = false;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.osB != null) {
                    b.this.osB.removeCallbacks(b.this.osL);
                }
            }
        });
    }

    public boolean eek() {
        return this.oso != null && this.oso.eea() == 2;
    }

    public int eea() {
        if (this.oso != null) {
            return this.oso.eea();
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

    public boolean eec() {
        if (this.oso != null) {
            return this.oso.eec();
        }
        return true;
    }

    public void eel() {
        gP("AudioRoomManager", "reStartPlayer");
        if (this.oso != null) {
            this.oso.cnF();
        }
    }

    public boolean hO(long j) {
        if (this.oso != null) {
            return this.oso.hO(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.osx || (!this.osw && eek())) {
            if (this.oso != null) {
                if (z && !this.oso.eed()) {
                    this.osG = true;
                    this.oso.zG(true);
                } else if (!z && this.osG) {
                    this.oso.zG(false);
                    this.osG = false;
                }
            }
            if (this.oso != null) {
                this.oso.zH(z);
            }
        }
        if (this.oso != null) {
            this.oso.muteOrUnmuteAudio(z);
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
                    jSONObject.put("invite_uk", o.efe().Zc());
                    jSONObject.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                    jSONObject.put("pushUrl", str5);
                    jSONObject.put("pushSingleUrl", str6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bIMInviteRtcInfo.setRtcExt(jSONObject.toString());
                b.this.osC.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
            }
        });
    }

    private void a(final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        this.osC.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    b.this.osC.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), bIMRtcTokenListener);
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
    public void NL(final int i) {
        gP("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.osq != null) {
                    b.this.osq.NO(i);
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
                if (b.this.osq != null) {
                    b.this.osq.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NM(int i) {
        if (this.ost != i) {
            if (i == 4) {
                if (this.osB != null) {
                    this.osB.removeCallbacks(this.osM);
                }
                this.osu = System.currentTimeMillis();
                this.ost = i;
                NL(4);
                return;
            }
            w Zd = c.eep().Zd();
            if (Zd != null && Zd.aKY > 0.0d) {
                this.osv = (long) (Zd.aKY * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.osu;
            if (currentTimeMillis > this.osv) {
                this.ost = i;
                NL(5);
            } else if (this.osB != null) {
                this.osB.removeCallbacks(this.osM);
                this.osB.postDelayed(this.osM, this.osv - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.osu > 5000) {
            if (this.osB != null) {
                this.osB.removeCallbacks(this.osM);
            }
            this.osu = System.currentTimeMillis();
            this.ost = i;
            NL(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
            Log.i(str, str2);
        }
    }

    public boolean een() {
        return this.osx;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oso != null) {
            this.oso.sendMessageToUser(str, j);
        }
    }

    public String eeo() {
        return this.oso != null ? this.oso.eee() + "#" + this.osJ + ",isStartHeartBeat:" + this.osE + ",time:" + System.currentTimeMillis() : "";
    }
}
