package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.rtc.RtcRoomListener;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.alablmsdk.config.a;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMMediaType;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.config.enums.BLMTransportAudioChannel;
import com.baidu.live.alablmsdk.config.enums.RtcForceType;
import com.baidu.live.alablmsdk.module.rtc.BLMJoinRoomStage;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static long oEq = 5;
    private static String oEu = "1127144634";
    private Context mContext;
    private String mRoomId;
    private boolean oEA;
    private int oEB;
    private long oEC;
    private boolean oEE;
    private boolean oEF;
    private HandlerThread oEG;
    private Handler oEH;
    private boolean oEI;
    private volatile boolean oEJ;
    private boolean oEK;
    private boolean oEL;
    private boolean oEM;
    private String oEN;
    private String oEO;
    private long oEP;
    private int oEQ;
    private boolean oER;
    private final f oEW;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oEv;
    private com.baidu.live.alablmsdk.a oEw;
    private String oEx;
    private d oEy;
    private int oEz;
    private long oED = 2000;
    private Runnable oES = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a bA = com.baidu.h.b.a.bA(b.this.mContext);
            if (bA == null) {
                if (b.this.oEv != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.oEO);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.oEv.aR("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.oEN = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) bA.ZU();
            if (bVar != null && !TextUtils.isEmpty(b.this.oEO)) {
                try {
                    cVar = bVar.iT(b.this.oEO);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.oEv != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.oEO);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.oEv.aR("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.oEN = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).ZZ().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.oEO, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gV("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.oEI && b.this.oEJ && b.this.oEH != null) {
                                b.this.oEH.removeCallbacks(b.this.oES);
                                b.this.oEH.post(b.this.oES);
                                if (System.currentTimeMillis() - b.this.oEP > 1000 && b.this.oEv != null) {
                                    b.this.oEP = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.oEO);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.oEv.aR("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.oEN = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.oEN = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.oEH != null) {
                    b.this.oEH.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.oEN = "heartbeaterror2," + b.this.oEO + "," + System.currentTimeMillis();
            if (b.this.oEv != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.oEO);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.oEv.aR("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable oET = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.oEB != 5) {
                b.this.oEB = 5;
                b.this.Mr(5);
            }
        }
    };
    private Runnable oEU = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
        @Override // java.lang.Runnable
        public void run() {
            b.this.ecO();
            if (b.this.oEH != null) {
                b.this.oEH.postDelayed(this, 500L);
            }
        }
    };
    private ILiveMsgReceiveListener oEV = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
        @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
        public void onReceiveMessage(int i, JSONArray jSONArray) {
            b.this.gV("AudioRoomManager", "receiveb2cmsg:" + i + "," + jSONArray.toString());
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
                        b.this.gV("AudioRoomManager", "do send audio_link_apply_toast");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("audio_link_cancel_apply", (CharSequence) entry.getKey())) {
                        b.this.gV("AudioRoomManager", "do send audio_link_cancel_apply");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("live_audio_lower_wheat", (CharSequence) entry.getKey())) {
                        b.this.gV("AudioRoomManager", "do live_audio_lower_wheat");
                        if (b.this.gT(b.this.oEx, "用户被审核下麦")) {
                            b.this.Mr(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void B(int i, long j);
    }

    public b(Context context, String str, String str2, int i, boolean z) {
        this.oER = true;
        this.mContext = context;
        this.mRoomId = str;
        this.oEO = str2;
        if (this.oEw != null && this.oEQ != i) {
            if (!TextUtils.isEmpty(this.oEx)) {
                this.oEw.b(this.oEx, (JSONObject) null, (com.baidu.live.alablmsdk.c.d) null);
            }
            this.oEw.onRelease();
        }
        this.oEQ = i;
        if (this.oEG == null) {
            this.oEG = new HandlerThread("AudioRoomManager_Thread");
            this.oEG.start();
        }
        if (this.oEH == null && this.oEG.isAlive()) {
            this.oEH = new Handler(this.oEG.getLooper());
        }
        this.oEW = new f(this.oEH);
        this.oEW.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.f.a
            public void a(f.b bVar) {
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMManager.registerStudioUsePaReceiveMsg(context, this.oEV);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i2) {
                b.this.gV("AudioRoomManager", "ConnectListener status:" + i2);
                if (i2 == 0) {
                    b.this.oEJ = true;
                    if (b.this.oEI) {
                        b.this.ecI();
                        return;
                    }
                    return;
                }
                b.this.oEJ = false;
            }
        };
        gV("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        if (!z) {
            this.oEw = new com.baidu.live.alablmsdk.a(context);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1VN);
            hashMap.put("rtc_room_source_key", "liveshow_room");
            hashMap.put("rtc_business_source_key", "audio_room");
            hashMap.put("has_audio", true);
            hashMap.put("has_video", false);
            hashMap.put("is_auto_subscribe", true);
            hashMap.put("media_type", BLMMediaType.BLMMEDIATYPE_AUDIO);
            hashMap.put("transport_audio_channel_key", BLMTransportAudioChannel.RTC_AUDIO_STEREO);
            hashMap.put("audio_max_kbps_key", 192);
            hashMap.put("audio_buffer_packets_key", 100);
            hashMap.put("audio_codec_complex_key", 9);
            hashMap.put("audio_playout_delay_key", 50);
            ab Yq = c.ecR().Yq();
            if (Yq != null) {
                this.oER = Yq.aJk;
            }
            if (this.oER) {
                hashMap.put("audio_source_key", 1);
                hashMap.put("enable_ans_key", true);
                hashMap.put("enable_agc_key", true);
                hashMap.put("disable_built_in_aec", true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(15);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            if (i == 0) {
                hashMap.put("rtc_force_type_key", RtcForceType.BAIDU_RTC);
            } else if (i == 1) {
                hashMap.put("rtc_force_type_key", RtcForceType.YY_RTC);
            }
            hashMap.put("rtc_re_try_post_delay_time", 5000);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("yy_rtc_app_id_key", oEu);
            hashMap2.put("yy_rtc_room_mode_key", 0);
            hashMap2.put("yy_rtc_media_mode_key", 2);
            hashMap2.put("yy_rtc_audio_config_key", 7);
            hashMap2.put("yy_rtc_commu_mode_key", 2);
            hashMap2.put("yy_rtc_scenario_mode_key", 2);
            hashMap2.put("yy_rtc_sound_effect_type_key", 4);
            hashMap.put("yy_rtc_private_params_key", hashMap2);
            this.oEw.v(hashMap);
            this.oEw.a(new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.live.alablmsdk.c.b.e
                public void a(String str3, String str4, final com.baidu.live.alablmsdk.c.b.a aVar) {
                    com.baidu.live.yyrtc.a.ZK().a(str3, str4, new com.baidu.live.yyrtc.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26.1
                        @Override // com.baidu.live.yyrtc.b
                        public void ai(String str5, String str6) {
                            if (b.this.oEw != null) {
                                b.this.oEw.ew(str5);
                            }
                            if (aVar != null) {
                                aVar.ai(str5, str6);
                            }
                        }
                    });
                }
            });
            this.oEw.a(new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27
                @Override // com.baidu.live.alablmsdk.c.b
                public void g(int i2, String str3) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i2) {
                    if (cVar != null && cVar.ayk == b.this.ecM()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("sec", i2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        b.this.aR("audio_room_debug", jSONObject.toString(), "leavedForSeconds");
                        if (i2 == 10) {
                            b.this.gV("AudioRoomManager", "leavedForSeconds:" + i2);
                        } else if (i2 >= 15) {
                            if (b.this.oEw != null) {
                                b.this.oEw.b(b.this.oEx, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.1
                                    @Override // com.baidu.live.alablmsdk.c.d
                                    public void f(int i3, int i4, String str3) {
                                        if (i4 == 0) {
                                            b.this.gV("AudioRoomManager", "leavedForSecondsleaveRoomSuccess");
                                        } else {
                                            b.this.gU("AudioRoomManager", "leavedForSecondsleaveRoomerror:" + i4 + str3);
                                        }
                                    }
                                });
                            }
                            b.this.oEA = false;
                            if (b.this.oEE) {
                                b.this.oEF = false;
                            }
                            b.this.q(1, b.this.oEz, "streamleavedForSeconds" + i2);
                        }
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(String str3, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
                    if (b.this.oEW != null && cVar != null) {
                        b.this.oEW.hQ(cVar.ayk);
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void b(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null) {
                                BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = new BIMInviteSyncRtcInfo();
                                bIMInviteSyncRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMInviteSyncRtcInfo.setRtcExt(jSONObject.toString());
                                    b.this.oEy.a(bIMInviteSyncRtcInfo);
                                }
                                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("receive_invite_anchor_5", false);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void c(String str3, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void b(final String str3, com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                b.this.oEy.b(bIMRtcInfo, 3);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void d(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMRtcInfo.setRtcExt(jSONObject.toString());
                                }
                                b.this.oEy.b(bIMRtcInfo, 1);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void e(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMRtcInfo.setRtcExt(jSONObject.toString());
                                }
                                b.this.oEy.b(bIMRtcInfo, 3);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void c(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null && cVar != null) {
                                b.this.oEy.hO(cVar.ayk);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void d(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null && cVar != null) {
                                b.this.oEy.hP(cVar.ayk);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void e(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.ayk == b.this.ecM()) {
                        b.this.gT(b.this.oEx, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                        b.this.Mr(1);
                        b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.11
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oEy != null) {
                                    b.this.oEy.bQ(cVar.ayk);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void f(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.ayk == b.this.ecM()) {
                        b.this.Mr(2);
                        b.this.oEM = false;
                        b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.12
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oEy != null) {
                                    b.this.oEy.u(cVar.ayk, true);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void g(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.ayk == b.this.ecM()) {
                        b.this.Mr(3);
                        b.this.oEM = false;
                        b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oEy != null) {
                                    b.this.oEy.u(cVar.ayk, false);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null && aVar != null) {
                                b.this.oEy.g(0, aVar.ayk, aVar.message);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void ey(String str3) {
                    b.this.yo();
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEy != null) {
                                b.this.oEy.Rl();
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void onLogReport(String str3, JSONObject jSONObject, JSONObject jSONObject2) {
                    if (!TextUtils.isEmpty(str3)) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        try {
                            jSONObject2.put("blm_from", "audio_room");
                        } catch (JSONException e) {
                        }
                        if (str3.equals("1980") && jSONObject2 != null) {
                            String jSONObject3 = jSONObject2.toString();
                            if (b.this.oEv != null) {
                                b.this.oEv.aR("lmsdk", jSONObject3, "debug");
                            }
                        }
                        UbcStatisticManager.getInstance().logLMSdkEvent(str3, jSONObject, jSONObject2);
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public String xn() {
                    if (TextUtils.isEmpty(b.this.mRoomId) || TbadkCoreApplication.getCurrentAccountId() <= 0) {
                        return null;
                    }
                    return "stream_bduid_" + TbadkCoreApplication.getCurrentAccountId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + b.this.mRoomId;
                }
            });
        }
        this.oEv = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oEv.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.28
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i2, String str3) {
                b.this.q(-4, b.this.oEz, "playererror,errorCode:" + i2 + ",errorMsg:" + str3);
            }

            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onEnterRoomResult(boolean z2) {
                if (z2) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect");
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                }
            }
        });
    }

    public void a(d dVar) {
        this.oEy = dVar;
    }

    public void Wj(String str) {
        if (this.oEv != null) {
            this.oEv.n(str, false, true);
        }
    }

    public void ecH() {
        gR(c.ecR().ecW(), TbadkCoreApplication.getCurrentAccountName());
    }

    public void gR(String str, String str2) {
        Wi("ownerEnterRoom");
        gV("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2);
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(1, 1, "imrtcroomid==" + str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imRtcRoomId", str);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "ownerEnterRoom");
        if (this.oEw != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (ecN() == 1) {
                hashMap.put("is_auto_publish", true);
                this.oEw.aY(true);
            } else {
                hashMap.put("is_auto_publish", false);
            }
            this.oEw.w(hashMap);
            this.oEw.a(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar) {
                    if (i != 0) {
                        b.this.gV("AudioRoomManager", "ownerEnterRoomfailed:" + i + (aVar != null ? aVar.msg : "noerror"));
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("status", i);
                            jSONObject2.put("stage", bLMJoinRoomStage);
                            jSONObject2.put(BdStatsConstant.StatsType.ERROR, aVar != null ? aVar.msg : "noerror");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        b.this.aR("audio_room_debug", jSONObject2.toString(), "ownerEnterRoomFailed");
                        b.this.oEA = false;
                        if (b.this.oEw != null) {
                            b.this.oEw.b(b.this.oEx, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2.1
                                @Override // com.baidu.live.alablmsdk.c.d
                                public void f(int i2, int i3, String str3) {
                                    if (i3 == 0) {
                                        b.this.gV("AudioRoomManager", "ownerEnterRoomleaveRoomSuccess");
                                    } else {
                                        b.this.gU("AudioRoomManager", "ownerEnterRoomleaveRoomerror:" + i3 + str3);
                                    }
                                }
                            });
                        }
                        b.this.Wi("ownerEnterRoomJoinError:" + i + (aVar != null ? aVar.msg : "no error"));
                        b.this.q(1, 1, "ownerEnterRoomJoinError:" + i + (aVar != null ? aVar.msg : "no error"));
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("status", i);
                        jSONObject3.put("stage", bLMJoinRoomStage);
                        jSONObject3.put(BdStatsConstant.StatsType.ERROR, aVar.msg);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    b.this.aR("audio_room_debug", jSONObject3.toString(), "ownerEnterRoomSuccess");
                    if (bLMJoinRoomStage == BLMJoinRoomStage.JOIN) {
                        b.this.gV("AudioRoomManager", "ownerEnterRoomSuccess");
                        b.this.Wi("ownerEnterRoomSuccess");
                        b.this.oEA = true;
                    }
                }
            });
        }
        this.oEx = str;
        this.oEE = true;
        this.oEF = false;
    }

    public void gS(String str, String str2) {
        gV("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.oEE = false;
        this.oEF = false;
        if (this.oEv != null) {
            this.oEv.Wh(str2);
        }
    }

    public void J(String str, String str2, final String str3, final String str4) {
        Wi("ownerJoinChat:isOwner" + this.oEE);
        gV("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        this.oEz = this.oEE ? 2 : 3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str2);
            jSONObject.put("joinChatType", this.oEz);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "ownerJoinChat");
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(1, this.oEz, "imrtcroomid==" + str);
        } else if (this.oEw == null) {
            q(1, this.oEz, "mBLMRtcEngine==null");
        } else {
            this.oEx = str;
            aAJ();
            if (this.oEE) {
                if (ecN() == 1) {
                    this.oEw.aY(false);
                    com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
                    aVar.axn = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
                    a.C0161a c0161a = new a.C0161a();
                    c0161a.axs = true;
                    c0161a.axr = str3;
                    c0161a.axx = "pure_audio";
                    a.C0161a c0161a2 = new a.C0161a();
                    c0161a2.axs = false;
                    c0161a2.axr = str4;
                    c0161a2.axx = "pure_audio";
                    aVar.axl = c0161a;
                    aVar.axm = c0161a2;
                    this.oEw.a(aVar);
                    this.oEw.a(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR);
                    Mt(2);
                    return;
                }
                this.oEw.a(new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, int i2, String str5) {
                        if (i2 != 0 || i != 10) {
                            b.this.j(i2, str5, 2);
                            return;
                        }
                        b.this.Mt(2);
                        com.baidu.live.alablmsdk.config.a aVar2 = new com.baidu.live.alablmsdk.config.a();
                        aVar2.axn = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
                        a.C0161a c0161a3 = new a.C0161a();
                        c0161a3.axs = true;
                        c0161a3.axr = str3;
                        c0161a3.axx = "pure_audio";
                        a.C0161a c0161a4 = new a.C0161a();
                        c0161a4.axs = false;
                        c0161a4.axr = str4;
                        c0161a4.axx = "pure_audio";
                        aVar2.axl = c0161a3;
                        aVar2.axm = c0161a4;
                        b.this.oEw.a(aVar2);
                        b.this.oEw.a(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR);
                    }
                });
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("is_auto_publish", true);
            this.oEw.w(hashMap);
            com.baidu.live.alablmsdk.config.a aVar2 = new com.baidu.live.alablmsdk.config.a();
            aVar2.axn = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
            a.C0161a c0161a3 = new a.C0161a();
            c0161a3.axs = true;
            c0161a3.axr = str3;
            c0161a3.axx = "pure_audio";
            a.C0161a c0161a4 = new a.C0161a();
            c0161a4.axs = false;
            c0161a4.axr = str4;
            c0161a4.axx = "pure_audio";
            aVar2.axl = c0161a3;
            aVar2.axm = c0161a4;
            this.oEw.a(aVar2);
            this.oEw.aY(false);
            this.oEw.a(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar3) {
                    if (i == 0 && bLMJoinRoomStage == BLMJoinRoomStage.PUBLISH) {
                        b.this.Mt(3);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_and_get_rtc_token_succ_host_3", true);
                    } else if (i != 0) {
                        b.this.j(i, (aVar3 != null ? aVar3.msg : "noerror") + ",stage:" + bLMJoinRoomStage, 3);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            ab Yq = c.ecR().Yq();
                            if (Yq != null && Yq.aIU != null) {
                                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                            }
                            jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, bLMJoinRoomStage);
                            jSONObject2.put("error_code", i);
                            jSONObject2.put("error_msg", "主持上麦失败失败：" + bLMJoinRoomStage + (aVar3 != null ? aVar3.msg : "no error"));
                        } catch (JSONException e2) {
                            BdLog.e(e2);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject2));
                        b.this.Wi("hostJoinChatJoinError:" + i + "errorMsg:" + bLMJoinRoomStage + (aVar3 != null ? aVar3.msg : "no error"));
                    }
                }
            });
        }
    }

    public void Wi(String str) {
        if (this.oEv != null) {
            this.oEv.Wi(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gV("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean Wk(String str) {
        return c(this.oEx, true, str);
    }

    public boolean gT(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gV("AudioRoomManager", "quitChat:" + str);
        this.oEL = false;
        this.oEM = false;
        this.oEK = false;
        this.oEF = false;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("quitChatext", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "quitChat");
        if (z) {
            ecJ();
        }
        if (this.oEH != null) {
            this.oEH.removeCallbacks(this.oET);
            this.oEH.removeCallbacks(this.oEU);
        }
        if (this.oEw != null) {
            if (this.oEE) {
                if (ecN() == 1) {
                    this.oEw.aY(true);
                    this.oEw.b(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR);
                } else {
                    this.oEw.b(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR);
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oEw != null) {
                                b.this.oEw.xk();
                            }
                        }
                    }, 500L);
                }
            } else {
                Mr(6);
                this.oEw.b(this.oEx, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, int i2, String str3) {
                        if (i2 == 0) {
                            b.this.gV("AudioRoomManager", "quitChatleaveRoomSuccess");
                        } else {
                            b.this.gU("AudioRoomManager", "quitChatleaveRoomerror:" + i2 + str3);
                        }
                    }
                });
                this.oEA = false;
            }
        }
        return true;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.a.b$7  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements a {
        final /* synthetic */ long oFc;
        final /* synthetic */ String oFd;
        final /* synthetic */ String oFe;
        final /* synthetic */ String val$cuid;

        AnonymousClass7(long j, String str, String str2, String str3) {
            this.oFc = j;
            this.oFd = str;
            this.val$cuid = str2;
            this.oFe = str3;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
        public void B(int i, final long j) {
            if (i == 0) {
                b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList();
                        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.ayk = j;
                        cVar.appId = AnonymousClass7.this.oFc;
                        cVar.appVersion = AnonymousClass7.this.oFd;
                        cVar.cuid = AnonymousClass7.this.val$cuid;
                        cVar.ayq = AnonymousClass7.this.oFe;
                        arrayList.add(cVar);
                        if (b.this.oEw != null) {
                            b.this.oEw.a(b.this.oEx, (JSONObject) null, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7.1.1
                                @Override // com.baidu.live.alablmsdk.c.d
                                public void f(int i2, int i3, String str) {
                                    if (i3 == 0) {
                                        b.this.gV("AudioRoomManager", "kickoffsuccess");
                                    } else {
                                        b.this.gV("AudioRoomManager", "kickofffailed" + i3 + str);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                b.this.q(2, 5, "kickOffUsergetIMUKFromBdUfail");
            }
        }
    }

    public void a(String str, long j, String str2, String str3) {
        gV("AudioRoomManager", "kickOffUser:" + str);
        a(str, new AnonymousClass7(j, str2, str3, str));
    }

    public void Aa(boolean z) {
        gV("AudioRoomManager", "muteMic:" + z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "muteMic");
        this.oEL = z;
        if (z && 5 != this.oEB) {
            this.oEB = 5;
            Mr(5);
        }
        if (this.oEw != null) {
            this.oEw.aY(z);
        }
    }

    public void bg(String str, boolean z) {
        gV("AudioRoomManager", "muteUser:" + str + "," + z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bdUK", str);
            jSONObject.put("isMute", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "muteotherUser");
        a(str, new AnonymousClass8(z));
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.a.b$8  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass8 implements a {
        final /* synthetic */ boolean aAt;

        AnonymousClass8(boolean z) {
            this.aAt = z;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
        public void B(int i, final long j) {
            if (i == 0) {
                b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oEw != null) {
                            ArrayList arrayList = new ArrayList();
                            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                            cVar.ayk = j;
                            arrayList.add(cVar);
                            b.this.oEw.a(b.this.oEx, AnonymousClass8.this.aAt, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8.1.1
                                @Override // com.baidu.live.alablmsdk.c.d
                                public void f(int i2, int i3, String str) {
                                    if (i3 == 0) {
                                        b.this.gV("AudioRoomManager", "muteUsersuccess");
                                    } else {
                                        b.this.gV("AudioRoomManager", "muteUserfailed" + i3 + str);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                b.this.q(2, 4, "muteUsergetIMUKFromBdUfail");
            }
        }
    }

    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, final boolean z, String str4) {
        Wi("answerInvite");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("answerType", i);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str);
            jSONObject.put("isApply", z);
            jSONObject.put("invite_uk", str4);
            jSONObject.put("bimRtcInfo", bIMInviteSyncRtcInfo.toRtcInfoString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "answerInvite");
        this.oEz = z ? 5 : 4;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("invited_name", str);
            jSONObject2.put("invite_uk", str4);
            jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (i != 1) {
            if (bIMInviteSyncRtcInfo != null && this.oEw != null) {
                this.oEx = bIMInviteSyncRtcInfo.getRtcRoomId();
                this.oEw.a(bIMInviteSyncRtcInfo.getRtcRoomId(), jSONObject2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i2, int i3, String str5) {
                        if (i3 == 0) {
                            b.this.gV("AudioRoomManager", "rejectRoomSuccess");
                        } else {
                            b.this.gU("AudioRoomManager", "rejectRoomerror:" + i3 + str5);
                        }
                    }
                });
            }
        } else if (bIMInviteSyncRtcInfo == null || this.oEw == null) {
            gV("AudioRoomManager", "answerInvite error bimRtcInfo null");
            q(1, this.oEz, "answerInvite error bimRtcInfo or mBLMRtcEngine null");
        } else {
            gV("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
            this.oEx = bIMInviteSyncRtcInfo.getRtcRoomId();
            if (this.oEE) {
                this.oEF = true;
                J(this.oEx, str, str2, str3);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("is_auto_publish", true);
            this.oEw.w(hashMap);
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.axn = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
            a.C0161a c0161a = new a.C0161a();
            c0161a.axs = true;
            c0161a.axr = str2;
            c0161a.axx = "pure_audio";
            a.C0161a c0161a2 = new a.C0161a();
            c0161a2.axs = false;
            c0161a2.axr = str3;
            c0161a2.axx = "pure_audio";
            aVar.axl = c0161a;
            aVar.axm = c0161a2;
            this.oEw.a(aVar);
            this.oEw.aY(false);
            this.oEw.a(bIMInviteSyncRtcInfo.getRtcRoomId(), jSONObject2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i2, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar2) {
                    if (i2 == 0 && bLMJoinRoomStage == BLMJoinRoomStage.PUBLISH) {
                        b.this.Mt(z ? 5 : 4);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                    } else if (i2 != 0) {
                        b.this.j(i2, (aVar2 != null ? aVar2.msg : "noerror") + ",stage:" + bLMJoinRoomStage, z ? 5 : 4);
                    }
                }
            });
        }
    }

    public void yo() {
        gV("AudioRoomManager", "leaveRoom");
        aR("audio_room_debug", "", "leaveRoom");
        ecJ();
        if (this.oEH != null) {
            this.oEH.removeCallbacksAndMessages(null);
        }
        if (this.oEG != null) {
            this.oEG.quit();
            this.oEH = null;
        }
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.oEV);
        if (this.oEv != null) {
            this.oEv.yo();
            this.oEv = null;
        }
        if (this.oEw != null) {
            this.oEw.b(this.oEx, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
                @Override // com.baidu.live.alablmsdk.c.d
                public void f(int i, int i2, String str) {
                    if (i2 == 0) {
                        b.this.gV("AudioRoomManager", "leaveRoomleaveRoomSuccess");
                    } else {
                        b.this.gU("AudioRoomManager", "leaveRoomleaveRoomerror:" + i2 + str);
                    }
                }
            });
            this.oEw.onRelease();
            this.oEw = null;
        }
        this.oEA = false;
    }

    public void aAJ() {
        gV("AudioRoomManager", "pausePlayer");
        if (this.oEv != null) {
            this.oEv.aAJ();
        }
    }

    public void yp() {
        gV("AudioRoomManager", "closeRoom:");
        if (this.oEw != null) {
            this.oEw.a(this.oEx, true, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
                @Override // com.baidu.live.alablmsdk.c.d
                public void f(int i, int i2, String str) {
                    if (i2 == 0) {
                        b.this.gV("AudioRoomManager", "closeRoomSuccess");
                    } else {
                        b.this.gU("AudioRoomManager", "closeRoomerror:" + i2 + str);
                    }
                }
            });
        }
    }

    public void ecI() {
        gV("AudioRoomManager", "startHeartBeatAction");
        if (this.oEv != null) {
            this.oEv.aR("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oEI = true;
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEH != null) {
                    b.this.oEH.removeCallbacks(b.this.oES);
                    b.this.oEH.post(b.this.oES);
                }
            }
        });
    }

    public void ecJ() {
        gV("AudioRoomManager", "stopHeartBeatAction");
        if (this.oEv != null) {
            this.oEv.aR("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oEI = false;
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEH != null) {
                    b.this.oEH.removeCallbacks(b.this.oES);
                }
            }
        });
    }

    public boolean ecK() {
        return this.oEA;
    }

    public static boolean Wl(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.WO(str), 0L)));
            BIMManager.getUsersProfiles(this.mContext, arrayList, true, new IGetUsersProfileBatchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.16
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

    public boolean ecD() {
        if (this.oEv != null) {
            return this.oEv.ecD();
        }
        return true;
    }

    public void ecL() {
        gV("AudioRoomManager", "reStartPlayer");
        if (this.oEv != null) {
            this.oEv.cnL();
        }
    }

    public void muteOrUnmuteAudio(boolean z) {
        if ((this.oEF || (!this.oEE && ecK())) && this.oEw != null) {
            if (z && !this.oEL && !this.oEM) {
                this.oEK = true;
                this.oEw.aY(true);
            } else if (!z && this.oEK) {
                this.oEw.aY(false);
                this.oEK = false;
            }
            this.oEw.aZ(z);
        }
        if (this.oEE && this.oEw != null) {
            this.oEw.aZ(z);
        }
        if (this.oEv != null) {
            this.oEv.muteOrUnmuteAudio(z);
        }
    }

    private void b(final String str, final String str2, final String str3, final long j, final String str4, final boolean z, final String str5, final String str6, final IStatusListener iStatusListener) {
        a(str2, new a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17
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
                JSONObject jSONObject = new JSONObject();
                try {
                    ab Yq = c.ecR().Yq();
                    if (Yq != null && Yq.aIU != null) {
                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                    }
                    jSONObject.put("error_code", 0);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "im_rtc_invite").setContentExt(jSONObject));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("get_imuk_from_bduk_anchor_3", false);
                if (b.this.oEw != null) {
                    ArrayList arrayList = new ArrayList();
                    com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                    cVar.ayk = j2;
                    cVar.appId = j;
                    cVar.appVersion = str3;
                    cVar.cuid = str4;
                    cVar.ayq = str2;
                    arrayList.add(cVar);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("invite_name", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
                        jSONObject2.put("invite_uk", q.edM().Yp());
                        jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                        jSONObject2.put("pushUrl", str5);
                        jSONObject2.put("pushSingleUrl", str6);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    b.this.oEw.a(str, arrayList, jSONObject2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17.1
                        @Override // com.baidu.live.alablmsdk.c.d
                        public void f(int i2, int i3, String str7) {
                            if (iStatusListener != null) {
                                iStatusListener.onResult(i3, str7);
                            }
                        }
                    });
                }
                if (b.this.oEW != null) {
                    b.this.oEW.b(new f.b(j, j2, str4, str2));
                }
            }
        });
    }

    public long ecM() {
        return AccountManager.getUK(this.mContext);
    }

    public int ecN() {
        return this.oEQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr(final int i) {
        gV("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEy != null) {
                    b.this.oEy.Mv(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final int i, final int i2, final String str) {
        gV("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i);
            jSONObject.put("subErrorCode", i2);
            jSONObject.put("errMsg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "notifyError");
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEy != null) {
                    b.this.oEy.onError(i, i2, str);
                }
            }
        });
    }

    private void Ms(int i) {
        if (this.oEB != i) {
            if (i == 4) {
                if (this.oEH != null) {
                    this.oEH.removeCallbacks(this.oET);
                }
                this.oEC = System.currentTimeMillis();
                this.oEB = i;
                Mr(4);
                return;
            }
            ab Yq = c.ecR().Yq();
            if (Yq != null && Yq.aJg > 0.0d) {
                this.oED = (long) (Yq.aJg * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oEC;
            if (currentTimeMillis > this.oED) {
                this.oEB = i;
                Mr(5);
            } else if (this.oEH != null) {
                this.oEH.removeCallbacks(this.oET);
                this.oEH.postDelayed(this.oET, this.oED - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oEC > 5000) {
            if (this.oEH != null) {
                this.oEH.removeCallbacks(this.oET);
            }
            this.oEC = System.currentTimeMillis();
            this.oEB = i;
            Mr(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mt(final int i) {
        boolean z = false;
        this.oEA = true;
        if (this.oEE) {
            this.oEF = true;
        }
        if (this.oEw != null) {
            com.baidu.live.alablmsdk.a aVar = this.oEw;
            if (this.oEL || this.oEM) {
                z = true;
            }
            aVar.aY(z);
        }
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEy != null) {
                    b.this.ecI();
                    b.this.ecO();
                    if (b.this.oEH != null) {
                        b.this.oEH.removeCallbacks(b.this.oET);
                        b.this.oEH.post(b.this.oET);
                        b.this.oEH.removeCallbacks(b.this.oEU);
                        b.this.oEH.postDelayed(b.this.oEU, 500L);
                    }
                    b.this.oEy.Mu(i);
                }
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
            jSONObject.put("error_code", 0);
            jSONObject.put("error_msg", "上麦失败成功joinChatType:" + i + ",rtcType:" + this.oEQ);
        } catch (Exception e) {
            BdLog.e(e);
        }
        String str = "";
        switch (i) {
            case 2:
                str = "owner_join_chat_result";
                break;
            case 3:
                str = "owner_join_chat_result";
                break;
            case 4:
                str = "owner_invite_join_chat_result";
                break;
            case 5:
                str = "user_apply_join_chat_result";
                break;
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, str).setContentExt(jSONObject));
        gV("AudioRoomManager", "joinChatSuccess,type:" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str, int i2) {
        this.oEA = false;
        if (this.oEE) {
            this.oEF = false;
        } else {
            if (this.oEw != null) {
                this.oEw.b(this.oEx, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i3, int i4, String str2) {
                        if (i4 == 0) {
                            b.this.gV("AudioRoomManager", "joinChatFailedleaveRoomSuccess");
                        } else {
                            b.this.gU("AudioRoomManager", "joinChatErrorleaveRoomerror:" + i4 + str2);
                        }
                    }
                });
            }
            ecJ();
        }
        if (this.oEH != null) {
            this.oEH.removeCallbacks(this.oEU);
            this.oEH.removeCallbacks(this.oET);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", "上麦失败msg:" + str + ",joinChatType:" + i2 + ",rtctype:" + this.oEQ + "|" + c.ecR().ecT().ecQ());
        } catch (Exception e) {
            BdLog.e(e);
        }
        String str2 = "";
        switch (i2) {
            case 2:
                str2 = "owner_join_chat_result";
                break;
            case 3:
                str2 = "owner_join_chat_result";
                break;
            case 4:
                str2 = "owner_invite_join_chat_result";
                break;
            case 5:
                str2 = "user_apply_join_chat_result";
                break;
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, str2).setContentExt(jSONObject));
        Wi("joinChatErrormsg:" + str + "errorcode:" + i + ",type:" + i2);
        gU("AudioRoomManager", "joinChatErrormsg:" + str + "errorcode:" + i + ",type:" + i2);
        q(1, i2, "joinchaterrorcode:" + i + "errorMsg:" + str + "userType:" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecO() {
        com.baidu.live.alablmsdk.module.rtc.d yk;
        if (this.oEw != null && (yk = this.oEw.xm().yk()) != null) {
            ab Yq = c.ecR().Yq();
            if (Yq != null) {
                if (this.oEQ == 1) {
                    oEq = Yq.aJi;
                } else {
                    oEq = Yq.aJj;
                }
            }
            gV("AudioRoomManager", "currentVolume:" + yk.volume);
            if (yk.volume > oEq) {
                Ms(4);
            } else {
                Ms(5);
            }
        }
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
            Log.i(str, str2);
        }
    }

    public void aR(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            ab Yq = c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject2.put(AlaRecorderLog.KEY_RES_TYPE, str);
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str2);
            }
            jSONObject.put("imuk", ecM());
            jSONObject.put("rtcroomid", this.oEx);
            jSONObject.put("rtctype", this.oEQ);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK, BdNetTypeUtil.isNetWorkAvailable());
            jSONObject.put("imstatus", this.oEJ);
            jSONObject.put("opertaionType", str3);
            jSONObject.put("thread", Thread.currentThread().getName());
            jSONObject.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject2.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_LIVE_DEBUG, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "audio_live_debug").setContentExt(jSONObject2));
    }

    public boolean ecP() {
        return this.oEF;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oEw != null) {
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.ayk = j;
            this.oEw.a(str, cVar);
        }
    }

    public String ecQ() {
        return this.oEv != null ? this.oEv.ecE() + ",rtcroomid:" + this.oEx + ",imuk:" + ecM() + ",rtcType:" + this.oEQ + "netstatus:" + BdNetTypeUtil.isNetWorkAvailable() + "imstatus:" + this.oEJ + "#" + this.oEN + ",isStartHeartBeat:" + this.oEI + ",time:" + System.currentTimeMillis() : "";
    }
}
