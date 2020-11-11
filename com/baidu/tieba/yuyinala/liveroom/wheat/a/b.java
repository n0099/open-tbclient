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
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a obI;
    private String obJ;
    private d obK;
    private int obL;
    private boolean obM;
    private int obN;
    private long obO;
    private boolean obQ;
    private boolean obR;
    private String obS;
    private String obT;
    private HandlerThread obU;
    private Handler obV;
    private f obW;
    private boolean obY;
    private volatile boolean obZ;
    private boolean oca;
    private boolean ocb;
    private boolean occ;
    private String ocd;
    private String oce;
    private String oci;
    private String ocj;
    private String ock;
    private long obP = 2000;
    private boolean obX = true;
    private Runnable ocf = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a aJ = com.baidu.h.b.a.aJ(b.this.mContext);
            if (aJ == null) {
                b.this.ocd = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) aJ.Yl();
            if (bVar != null && !TextUtils.isEmpty(b.this.oce)) {
                try {
                    cVar = bVar.jh(b.this.oce);
                } catch (Exception e) {
                    e.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    b.this.ocd = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).Yq().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.oce, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gK("audioroom", "HeartBeat:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + j2);
                        if (i != 0) {
                            if (b.this.obY && b.this.obZ && b.this.obV != null) {
                                b.this.obV.removeCallbacks(b.this.ocf);
                                b.this.obV.post(b.this.ocf);
                            }
                            b.this.ocd = "heartbeaterrornum:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
                            return;
                        }
                        b.this.ocd = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.obV != null) {
                    b.this.obV.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.ocd = "heartbeaterror2," + b.this.oce + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
        }
    };
    private Runnable ocg = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.obN != 5) {
                b.this.obN = 5;
                b.this.Mq(5);
            }
        }
    };
    private ILiveMsgReceiveListener och = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
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
                        if (b.this.Vz(b.this.obJ)) {
                            b.this.Mq(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };
    private BIMRtcListener aDj = new BIMRtcListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19
        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
            b.this.gK("AudioRoomManager", "onRtcResult,onRtcResult:action" + i);
            if (i == 89) {
                b.this.yX(false);
                b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.obK != null) {
                            b.this.obK.QD();
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
                    if (b.this.obK != null) {
                        b.this.obK.b(bIMRtcInfo, 3);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCallerGetAnswerSyncByCallee(final int i, final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.obK != null) {
                        b.this.obK.b(bIMRtcInfo, i);
                    }
                }
            });
        }

        @Override // com.baidu.android.imrtc.msg.BIMRtcListener
        public void roomCalleeInviteFromCaller(final BIMRtcInfo bIMRtcInfo) {
            b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19.4
                @Override // java.lang.Runnable
                public void run() {
                    if ((bIMRtcInfo instanceof BIMInviteSyncRtcInfo) && b.this.obK != null) {
                        b.this.obK.a((BIMInviteSyncRtcInfo) bIMRtcInfo);
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
            int i = AnonymousClass17.ocI[roomEventType.ordinal()];
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
        this.oce = str2;
        if (this.obU == null) {
            this.obU = new HandlerThread("AudioRoomManager_Thread");
            this.obU.start();
        }
        if (this.obV == null && this.obU.isAlive()) {
            this.obV = new Handler(this.obU.getLooper());
        }
        this.obW = new f(this.obV);
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMRtcClient.registerRtcListener(context, this.aDj);
        BIMManager.registerStudioUsePaReceiveMsg(context, this.och);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                b.this.gK("AudioRoomManager", "ConnectListener status:" + i);
                if (i == 0) {
                    b.this.obZ = true;
                    if (b.this.obM && b.this.obX) {
                        if (b.this.obR || b.this.obQ) {
                            b.this.obW.join(b.this.mContext, b.this.obJ, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20.1
                                @Override // com.baidu.android.imrtc.utils.IStatusListener
                                public void onResult(int i2, String str3) {
                                    if (i2 == 0) {
                                        b.this.obM = false;
                                        if (b.this.obI != null && b.this.obI.dYw() != 4 && b.this.obI.dYw() != 0) {
                                            b.this.obL = 5;
                                            b.this.obI.dYx();
                                            return;
                                        }
                                        return;
                                    }
                                    if (b.this.obQ) {
                                        b.this.obR = false;
                                    }
                                    b.this.q(2, 8, "on net ok reconnect:" + str3);
                                }
                            });
                        } else {
                            b.this.obM = false;
                            if (b.this.obI != null && b.this.obI.dYw() != 4 && b.this.obI.dYw() != 0) {
                                b.this.obL = 5;
                                b.this.obI.dYx();
                            }
                        }
                    }
                    if (b.this.obY) {
                        b.this.dYE();
                        return;
                    }
                    return;
                }
                b.this.obZ = false;
                if (b.this.obI != null && b.this.obI.dYw() != 4 && b.this.obI.dYw() != 0) {
                    b.this.obM = true;
                }
            }
        };
        gK("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        this.obI = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.obI.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i, String str3) {
                b.this.q(1, b.this.obL, "rtcroom,errorCode:" + i + ",errorMsg:" + str3);
                if (b.this.obQ) {
                    b.this.obR = false;
                }
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onPeerConnectStateUpdate(int i) {
                boolean z = false;
                b.this.gK("AudioRoomManager", "rtcroom,onPeerConnectStateUpdate:" + i);
                if (i == 2001) {
                    if (b.this.obQ) {
                        b.this.obR = true;
                    }
                    if (b.this.obI != null) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a aVar = b.this.obI;
                        if (b.this.ocb || b.this.occ) {
                            z = true;
                        }
                        aVar.yV(z);
                    }
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.obK != null) {
                                if (b.this.obL == 4 || b.this.obL == 3 || b.this.obL == 2 || b.this.obL == 5) {
                                    b.this.dYE();
                                    if (b.this.obV != null) {
                                        b.this.obV.removeCallbacks(b.this.ocg);
                                        b.this.obV.post(b.this.ocg);
                                    }
                                }
                                b.this.obK.Ms(b.this.obL);
                            }
                        }
                    });
                } else if (i == 10000) {
                    b.this.q(1, b.this.obL, i + ",connectionlost");
                    if (b.this.obQ) {
                        b.this.obR = false;
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
                        if (b.this.obQ) {
                            b.this.obR = false;
                        }
                        b.this.q(1, b.this.obL, i + ",rtcloginerror/loginerror");
                        return;
                    case 103:
                        if (b.this.obQ) {
                            b.this.obR = false;
                        }
                        b.this.q(1, b.this.obL, i + ",rtcloginerror/connectionlost");
                        return;
                    case 112:
                        b.this.Cf();
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.obK != null) {
                                    b.this.obK.QD();
                                }
                            }
                        });
                        return;
                    case 113:
                        if (j == b.this.dYI()) {
                            b.this.Mq(2);
                            b.this.occ = true;
                            if (5 != b.this.obN) {
                                b.this.obN = 5;
                                b.this.Mq(5);
                            }
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.obK != null) {
                                    b.this.obK.t(j, true);
                                }
                            }
                        });
                        return;
                    case 114:
                        if (j == b.this.dYI()) {
                            b.this.Mq(3);
                            b.this.occ = false;
                        }
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.obK != null) {
                                    b.this.obK.t(j, false);
                                }
                            }
                        });
                        return;
                    case 115:
                        if (j == b.this.dYI()) {
                            b.this.Vz(b.this.obJ);
                            b.this.Mq(1);
                            b.this.obW.hangout(b.this.mContext, b.this.obJ, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.3
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
                                if (b.this.obK != null) {
                                    b.this.obK.bm(j);
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
                                if (b.this.obK != null) {
                                    b.this.obK.r(i, (int) j, str3);
                                }
                            }
                        });
                        return;
                    case 300:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.obK != null) {
                                    b.this.obK.hj(j);
                                }
                            }
                        });
                        return;
                    case 301:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.obK != null) {
                                    b.this.obK.hk(j);
                                }
                            }
                        });
                        return;
                    case 302:
                        b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.obK != null) {
                                    b.this.obK.j(i, j, str3);
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
                b.this.Mr(4);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onStopSpeak() {
                b.this.Mr(5);
            }
        });
    }

    public void a(d dVar) {
        this.obK = dVar;
    }

    public void Vy(String str) {
        if (this.obI != null) {
            this.obI.n(str, false, true);
        }
    }

    public void dYD() {
        aK(c.dYL().dYQ(), TbadkCoreApplication.getCurrentAccountName(), this.obT);
    }

    public void aK(String str, final String str2, final String str3) {
        Vx("ownerEnterRoom");
        gK("AudioRoomManager", "ownerEnterRoom:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 7, "imrtcroomid==" + str);
            return;
        }
        this.obJ = str;
        this.obQ = true;
        this.obR = false;
        this.obS = str2;
        this.obT = str3;
        a(str, new BIMRtcTokenListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str4, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0 && bIMRTCGetTokeResult != null) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.obL = 1;
                            b.this.oci = bIMRTCGetTokeResult.rtcAppId;
                            b.this.ocj = bIMRTCGetTokeResult.token;
                            b.this.ock = bIMRTCGetTokeResult.roomId;
                            if (b.this.obI != null) {
                                b.this.obI.a(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.dYI(), str2, str3);
                            }
                        }
                    });
                    return;
                }
                b.this.Vx("ownerEnterRoomJoinError:" + str4);
                b.this.q(2, 7, "ownerEnterRoomJoinError:" + str4);
            }
        });
    }

    public void gI(String str, String str2) {
        gK("AudioRoomManager", "commonUserEnterRoom:," + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        this.obQ = false;
        this.obR = false;
        this.obS = "";
        this.obT = "";
        if (this.obI != null) {
            this.obI.Vw(str2);
        }
    }

    public void M(String str, final String str2, final String str3, final String str4) {
        Vx("ownerJoinChat");
        gK("AudioRoomManager", "ownerJoinChat:," + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(2, 6, "imrtcroomid==" + str);
            return;
        }
        this.obJ = str;
        this.obR = true;
        aAm();
        if (this.obQ) {
            if (this.obI != null) {
                this.obI.logoutRoom();
            }
            this.obW.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str5) {
                    if (i != 0) {
                        b.this.gJ("AudioRoomManager", i + "ownerJoinChatImRtcfail");
                    }
                }
            });
        } else if (dYG() && this.obI != null) {
            this.obI.dYx();
            return;
        }
        if (!TextUtils.isEmpty(this.oci) && !TextUtils.isEmpty(this.ocj) && !TextUtils.isEmpty(this.ock)) {
            x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
                @Override // java.lang.Runnable
                public void run() {
                    b.this.obL = 2;
                    if (b.this.obI != null) {
                        b.this.obI.b(b.this.oci, b.this.ocj, b.this.ock, b.this.dYI(), str2, str3, str4);
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
                                b.this.obL = 2;
                                if (b.this.obI != null) {
                                    b.this.obI.b(bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.roomId, b.this.dYI(), str2, str3, str4);
                                }
                            }
                        });
                        return;
                    }
                    b.this.Vx("ownerJoinChatJoinError:" + i + " " + str5);
                    if (b.this.obQ) {
                        b.this.obR = false;
                    }
                    b.this.q(2, 6, "ownerJoinChatJoinError:" + str5);
                }
            });
        }
    }

    public void Vx(String str) {
        if (this.obI != null) {
            this.obI.Vx(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gK("AudioRoomManager", "inviteJoinChat:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + j + Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean dYv() {
        return bf(this.obJ, true);
    }

    public boolean Vz(String str) {
        return bf(str, true);
    }

    public boolean bf(String str, boolean z) {
        gK("AudioRoomManager", "quitChat:" + str);
        this.ocb = false;
        this.occ = false;
        this.oca = false;
        this.obR = false;
        if (this.obI != null && this.obI.dYv()) {
            if (z) {
                dYF();
            }
            if (this.obV != null) {
                this.obV.removeCallbacks(this.ocg);
            }
            this.obW.hangout(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i != 0) {
                        b.this.gK("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
            if (!this.obQ) {
                Mq(6);
            }
            if (this.obQ) {
                aK(str, this.obS, this.obT);
            }
            return true;
        }
        gJ("AudioRoomManager", "quit rtc room fail");
        return false;
    }

    public void VA(String str) {
        gK("AudioRoomManager", "kickOffUser:" + str);
        a(str, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
            public void B(int i, final long j) {
                if (i == 0) {
                    b.this.x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.obI != null) {
                                b.this.obI.ai(j);
                            }
                        }
                    });
                } else {
                    b.this.q(2, 5, "kickOffUsergetIMUKFromBdUfail");
                }
            }
        });
    }

    public void yV(boolean z) {
        gK("AudioRoomManager", "muteMic:" + z);
        this.ocb = z;
        if (z && 5 != this.obN) {
            this.obN = 5;
            Mq(5);
        }
        if (this.obI != null) {
            this.obI.yV(z);
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
                            if (b.this.obI != null) {
                                b.this.obI.r(j, z);
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
        Vx("answerInvite");
        gK("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
        if (this.obQ) {
            this.obR = true;
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
        this.obW.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i2, String str5) {
                if (i2 != 0) {
                    if (b.this.obQ) {
                        b.this.obR = false;
                    }
                    if (i != 1 || z) {
                        b.this.gJ("AudioRoomManager", i2 + "answererror:" + str5 + Constants.ACCEPT_TIME_SEPARATOR_SP + bIMAnswerRtcInfo.toString());
                    } else {
                        b.this.q(2, 3, "reject invite failed");
                    }
                    b.this.Vx("answerInvite:" + i2 + "answererror:" + str5 + Constants.ACCEPT_TIME_SEPARATOR_SP + bIMAnswerRtcInfo.toString());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                if (i == 1) {
                    b.this.obL = z ? 4 : 3;
                    if (b.this.obQ || !b.this.dYG() || b.this.obI == null) {
                        if (b.this.obQ && b.this.obI != null) {
                            b.this.obI.logoutRoom();
                        }
                        if (b.this.obI != null) {
                            b.this.obI.b(rtcAppId, rtcRoomToken, rtcRoomId, b.this.dYI(), str, str2, str3);
                            return;
                        }
                        return;
                    }
                    b.this.obI.dYx();
                }
            }
        });
    }

    public void Cf() {
        gK("AudioRoomManager", "leaveRoom");
        this.obM = false;
        dYF();
        if (this.obV != null) {
            this.obV.removeCallbacksAndMessages(null);
        }
        if (this.obU != null) {
            this.obU.quit();
            this.obV = null;
        }
        if (this.obQ && this.mContext != null) {
            this.obW.hangout(this.mContext, this.obJ, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gK("AudioRoomManager", i + "quitChatImRtcfail");
                    }
                }
            });
        }
        this.obW.release();
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aDj);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.och);
        if (this.obI != null) {
            this.obI.Cf();
            this.obI = null;
        }
    }

    public void aAm() {
        gK("AudioRoomManager", "pausePlayer");
        if (this.obI != null) {
            this.obI.aAm();
        }
    }

    public void Ce() {
        yX(true);
    }

    public void yX(boolean z) {
        gK("AudioRoomManager", "closeRoom:" + z);
        if (this.obI != null) {
            this.obI.dYi();
        }
        if (z) {
            BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
            bIMCloseRoomRtcInfo.setRtcRoomId(this.obJ);
            this.obW.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    if (i != 0) {
                        b.this.gJ("AudioRoomManager", i + "closeIMRtcRoomFail:" + str);
                    }
                }
            });
        }
    }

    public void dYE() {
        gK("AudioRoomManager", "startHeartBeatAction");
        this.obY = true;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.obV != null) {
                    b.this.obV.removeCallbacks(b.this.ocf);
                    b.this.obV.post(b.this.ocf);
                }
            }
        });
    }

    public void dYF() {
        gK("AudioRoomManager", "stopHeartBeatAction");
        this.obY = false;
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.obV != null) {
                    b.this.obV.removeCallbacks(b.this.ocf);
                }
            }
        });
    }

    public boolean dYG() {
        return this.obI != null && this.obI.dYw() == 2;
    }

    public int dYw() {
        if (this.obI != null) {
            return this.obI.dYw();
        }
        return -1;
    }

    public static boolean VB(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.Wa(str), 0L)));
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

    public boolean dYy() {
        if (this.obI != null) {
            return this.obI.dYy();
        }
        return true;
    }

    public void dYH() {
        gK("AudioRoomManager", "reStartPlayer");
        if (this.obI != null) {
            this.obI.ckq();
        }
    }

    public boolean hg(long j) {
        if (this.obI != null) {
            return this.obI.hg(j);
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.obR || (!this.obQ && dYG())) {
            if (this.obI != null) {
                if (z && !this.obI.dYz()) {
                    this.oca = true;
                    this.obI.yV(true);
                } else if (!z && this.oca) {
                    this.obI.yV(false);
                    this.oca = false;
                }
            }
            if (this.obI != null) {
                this.obI.yW(z);
            }
        }
        if (this.obI != null) {
            this.obI.muteOrUnmuteAudio(z);
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
                    jSONObject.put("invite_uk", o.dZA().Xm());
                    jSONObject.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                    jSONObject.put("pushUrl", str5);
                    jSONObject.put("pushSingleUrl", str6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bIMInviteRtcInfo.setRtcExt(jSONObject.toString());
                b.this.obW.invite(b.this.mContext, bIMInviteRtcInfo, iStatusListener);
            }
        });
    }

    private void a(final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        this.obW.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    b.this.obW.generateToken(b.this.mContext, "liveshow_room", str, AccountManager.getUK(b.this.mContext), bIMRtcTokenListener);
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, "joinIMRTCRoom failed：" + str2, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long dYI() {
        return AccountManager.getUK(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq(final int i) {
        gK("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        x(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.obK != null) {
                    b.this.obK.Mt(i);
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
                if (b.this.obK != null) {
                    b.this.obK.onError(i, i2, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr(int i) {
        if (this.obN != i) {
            if (i == 4) {
                if (this.obV != null) {
                    this.obV.removeCallbacks(this.ocg);
                }
                this.obO = System.currentTimeMillis();
                this.obN = i;
                Mq(4);
                return;
            }
            w Xn = c.dYL().Xn();
            if (Xn != null && Xn.aJX > 0.0d) {
                this.obP = (long) (Xn.aJX * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.obO;
            if (currentTimeMillis > this.obP) {
                this.obN = i;
                Mq(5);
            } else if (this.obV != null) {
                this.obV.removeCallbacks(this.ocg);
                this.obV.postDelayed(this.ocg, this.obP - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.obO > 5000) {
            if (this.obV != null) {
                this.obV.removeCallbacks(this.ocg);
            }
            this.obO = System.currentTimeMillis();
            this.obN = i;
            Mq(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
            Log.i(str, str2);
        }
    }

    public boolean dYJ() {
        return this.obR;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.obI != null) {
            this.obI.sendMessageToUser(str, j);
        }
    }

    public String dYK() {
        return this.obI != null ? this.obI.dYA() + "#" + this.ocd + ",isStartHeartBeat:" + this.obY + ",time:" + System.currentTimeMillis() : "";
    }
}
