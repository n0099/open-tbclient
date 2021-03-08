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
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static long oGv = 5;
    private static String oGz = "1127144634";
    private Context mContext;
    private String mRoomId;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oGA;
    private com.baidu.live.alablmsdk.a oGB;
    private String oGC;
    private d oGD;
    private int oGE;
    private boolean oGF;
    private int oGG;
    private long oGH;
    private boolean oGJ;
    private boolean oGK;
    private HandlerThread oGL;
    private Handler oGM;
    private boolean oGN;
    private volatile boolean oGO;
    private boolean oGP;
    private boolean oGQ;
    private boolean oGR;
    private String oGS;
    private String oGT;
    private long oGU;
    private int oGV;
    private boolean oGW;
    private final f oHb;
    private long oGI = 2000;
    private Runnable oGX = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a bz = com.baidu.h.b.a.bz(b.this.mContext);
            if (bz == null) {
                if (b.this.oGA != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.oGT);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.oGA.aR("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.oGS = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) bz.ZX();
            if (bVar != null && !TextUtils.isEmpty(b.this.oGT)) {
                try {
                    cVar = bVar.iZ(b.this.oGT);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.oGA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.oGT);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.oGA.aR("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.oGS = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).aac().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.oGT, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gV("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.oGN && b.this.oGO && b.this.oGM != null) {
                                b.this.oGM.removeCallbacks(b.this.oGX);
                                b.this.oGM.post(b.this.oGX);
                                if (System.currentTimeMillis() - b.this.oGU > 1000 && b.this.oGA != null) {
                                    b.this.oGU = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.oGT);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.oGA.aR("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.oGS = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.oGS = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.oGM != null) {
                    b.this.oGM.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.oGS = "heartbeaterror2," + b.this.oGT + "," + System.currentTimeMillis();
            if (b.this.oGA != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.oGT);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.oGA.aR("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable oGY = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.oGG != 5) {
                b.this.oGG = 5;
                b.this.Mv(5);
            }
        }
    };
    private Runnable oGZ = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
        @Override // java.lang.Runnable
        public void run() {
            b.this.ecW();
            if (b.this.oGM != null) {
                b.this.oGM.postDelayed(this, 500L);
            }
        }
    };
    private ILiveMsgReceiveListener oHa = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
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
                        if (b.this.gT(b.this.oGC, "用户被审核下麦")) {
                            b.this.Mv(7);
                        }
                    }
                }
            }
            hashMap.clear();
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void B(int i, long j);
    }

    public b(Context context, String str, String str2, int i, boolean z) {
        this.oGW = true;
        this.mContext = context;
        this.mRoomId = str;
        this.oGT = str2;
        if (this.oGB != null && this.oGV != i) {
            if (!TextUtils.isEmpty(this.oGC)) {
                this.oGB.b(this.oGC, (JSONObject) null, (com.baidu.live.alablmsdk.c.d) null);
            }
            this.oGB.onRelease();
        }
        this.oGV = i;
        if (this.oGL == null) {
            this.oGL = new HandlerThread("AudioRoomManager_Thread");
            this.oGL.start();
        }
        if (this.oGM == null && this.oGL.isAlive()) {
            this.oGM = new Handler(this.oGL.getLooper());
        }
        this.oHb = new f(this.oGM);
        this.oHb.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.f.a
            public void a(f.b bVar) {
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMManager.registerStudioUsePaReceiveMsg(context, this.oHa);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i2) {
                b.this.gV("AudioRoomManager", "ConnectListener status:" + i2);
                if (i2 == 0) {
                    b.this.oGO = true;
                    if (b.this.oGN) {
                        b.this.ecQ();
                        return;
                    }
                    return;
                }
                b.this.oGO = false;
            }
        };
        gV("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        if (!z) {
            this.oGB = new com.baidu.live.alablmsdk.a(context);
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
            ab Yt = c.ecZ().Yt();
            if (Yt != null) {
                this.oGW = Yt.aKK;
            }
            if (this.oGW) {
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
            hashMap2.put("yy_rtc_app_id_key", oGz);
            hashMap2.put("yy_rtc_room_mode_key", 0);
            hashMap2.put("yy_rtc_media_mode_key", 2);
            hashMap2.put("yy_rtc_audio_config_key", 7);
            hashMap2.put("yy_rtc_commu_mode_key", 2);
            hashMap2.put("yy_rtc_scenario_mode_key", 2);
            hashMap2.put("yy_rtc_sound_effect_type_key", 4);
            hashMap.put("yy_rtc_private_params_key", hashMap2);
            this.oGB.v(hashMap);
            this.oGB.a(new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.live.alablmsdk.c.b.e
                public void a(String str3, String str4, final com.baidu.live.alablmsdk.c.b.a aVar) {
                    com.baidu.live.yyrtc.a.ZN().a(str3, str4, new com.baidu.live.yyrtc.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26.1
                        @Override // com.baidu.live.yyrtc.b
                        public void ai(String str5, String str6) {
                            if (b.this.oGB != null) {
                                b.this.oGB.eD(str5);
                            }
                            if (aVar != null) {
                                aVar.ai(str5, str6);
                            }
                        }
                    });
                }
            });
            this.oGB.a(new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27
                @Override // com.baidu.live.alablmsdk.c.b
                public void g(int i2, String str3) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i2) {
                    if (cVar != null && cVar.azK == b.this.ecU()) {
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
                            if (b.this.oGB != null) {
                                b.this.oGB.b(b.this.oGC, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.1
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
                            b.this.oGF = false;
                            if (b.this.oGJ) {
                                b.this.oGK = false;
                            }
                            b.this.q(1, b.this.oGE, "streamleavedForSeconds" + i2);
                        }
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(String str3, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
                    if (b.this.oHb != null && cVar != null) {
                        b.this.oHb.hQ(cVar.azK);
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void b(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null) {
                                BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = new BIMInviteSyncRtcInfo();
                                bIMInviteSyncRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMInviteSyncRtcInfo.setRtcExt(jSONObject.toString());
                                    b.this.oGD.a(bIMInviteSyncRtcInfo);
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
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                b.this.oGD.b(bIMRtcInfo, 3);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void d(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMRtcInfo.setRtcExt(jSONObject.toString());
                                }
                                b.this.oGD.b(bIMRtcInfo, 1);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void e(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMRtcInfo.setRtcExt(jSONObject.toString());
                                }
                                b.this.oGD.b(bIMRtcInfo, 3);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void c(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null && cVar != null) {
                                b.this.oGD.hO(cVar.azK);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void d(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null && cVar != null) {
                                b.this.oGD.hP(cVar.azK);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void e(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.azK == b.this.ecU()) {
                        b.this.gT(b.this.oGC, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                        b.this.Mv(1);
                        b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.11
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oGD != null) {
                                    b.this.oGD.bQ(cVar.azK);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void f(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.azK == b.this.ecU()) {
                        b.this.Mv(2);
                        b.this.oGR = false;
                        b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.12
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oGD != null) {
                                    b.this.oGD.u(cVar.azK, true);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void g(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.azK == b.this.ecU()) {
                        b.this.Mv(3);
                        b.this.oGR = false;
                        b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oGD != null) {
                                    b.this.oGD.u(cVar.azK, false);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar) {
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null && aVar != null) {
                                b.this.oGD.e(0, aVar.azK, aVar.message);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void eE(String str3) {
                    b.this.yr();
                    b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGD != null) {
                                b.this.oGD.Ro();
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
                            if (b.this.oGA != null) {
                                b.this.oGA.aR("lmsdk", jSONObject3, ETAG.KEY_DEBUG);
                            }
                        }
                        UbcStatisticManager.getInstance().logLMSdkEvent(str3, jSONObject, jSONObject2);
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public String xq() {
                    if (TextUtils.isEmpty(b.this.mRoomId) || TbadkCoreApplication.getCurrentAccountId() <= 0) {
                        return null;
                    }
                    return "stream_bduid_" + TbadkCoreApplication.getCurrentAccountId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + b.this.mRoomId;
                }
            });
        }
        this.oGA = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oGA.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.28
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i2, String str3) {
                b.this.q(-4, b.this.oGE, "playererror,errorCode:" + i2 + ",errorMsg:" + str3);
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
        this.oGD = dVar;
    }

    public void Wq(String str) {
        if (this.oGA != null) {
            this.oGA.n(str, false, true);
        }
    }

    public void ecP() {
        gR(c.ecZ().ede(), TbadkCoreApplication.getCurrentAccountName());
    }

    public void gR(String str, String str2) {
        Wp("ownerEnterRoom");
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
        if (this.oGB != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (ecV() == 1) {
                hashMap.put("is_auto_publish", true);
                this.oGB.aY(true);
            } else {
                hashMap.put("is_auto_publish", false);
            }
            this.oGB.w(hashMap);
            this.oGB.a(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
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
                        b.this.oGF = false;
                        if (b.this.oGB != null) {
                            b.this.oGB.b(b.this.oGC, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2.1
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
                        b.this.Wp("ownerEnterRoomJoinError:" + i + (aVar != null ? aVar.msg : "no error"));
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
                        b.this.Wp("ownerEnterRoomSuccess");
                        b.this.oGF = true;
                    }
                }
            });
        }
        this.oGC = str;
        this.oGJ = true;
        this.oGK = false;
    }

    public void gS(String str, String str2) {
        gV("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.oGJ = false;
        this.oGK = false;
        if (this.oGA != null) {
            this.oGA.Wo(str2);
        }
    }

    public void J(String str, String str2, final String str3, final String str4) {
        Wp("ownerJoinChat:isOwner" + this.oGJ);
        gV("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        this.oGE = this.oGJ ? 2 : 3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str2);
            jSONObject.put("joinChatType", this.oGE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "ownerJoinChat");
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(1, this.oGE, "imrtcroomid==" + str);
        } else if (this.oGB == null) {
            q(1, this.oGE, "mBLMRtcEngine==null");
        } else {
            this.oGC = str;
            aAM();
            if (this.oGJ) {
                if (ecV() == 1) {
                    this.oGB.aY(false);
                    com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
                    aVar.ayN = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
                    a.C0167a c0167a = new a.C0167a();
                    c0167a.ayS = true;
                    c0167a.ayR = str3;
                    c0167a.ayX = "pure_audio";
                    a.C0167a c0167a2 = new a.C0167a();
                    c0167a2.ayS = false;
                    c0167a2.ayR = str4;
                    c0167a2.ayX = "pure_audio";
                    aVar.ayL = c0167a;
                    aVar.ayM = c0167a2;
                    this.oGB.a(aVar);
                    this.oGB.a(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR);
                    Mx(2);
                    return;
                }
                this.oGB.a(new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, int i2, String str5) {
                        if (i2 != 0 || i != 10) {
                            b.this.j(i2, str5, 2);
                            return;
                        }
                        b.this.Mx(2);
                        com.baidu.live.alablmsdk.config.a aVar2 = new com.baidu.live.alablmsdk.config.a();
                        aVar2.ayN = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
                        a.C0167a c0167a3 = new a.C0167a();
                        c0167a3.ayS = true;
                        c0167a3.ayR = str3;
                        c0167a3.ayX = "pure_audio";
                        a.C0167a c0167a4 = new a.C0167a();
                        c0167a4.ayS = false;
                        c0167a4.ayR = str4;
                        c0167a4.ayX = "pure_audio";
                        aVar2.ayL = c0167a3;
                        aVar2.ayM = c0167a4;
                        b.this.oGB.a(aVar2);
                        b.this.oGB.a(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR);
                    }
                });
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("is_auto_publish", true);
            this.oGB.w(hashMap);
            com.baidu.live.alablmsdk.config.a aVar2 = new com.baidu.live.alablmsdk.config.a();
            aVar2.ayN = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
            a.C0167a c0167a3 = new a.C0167a();
            c0167a3.ayS = true;
            c0167a3.ayR = str3;
            c0167a3.ayX = "pure_audio";
            a.C0167a c0167a4 = new a.C0167a();
            c0167a4.ayS = false;
            c0167a4.ayR = str4;
            c0167a4.ayX = "pure_audio";
            aVar2.ayL = c0167a3;
            aVar2.ayM = c0167a4;
            this.oGB.a(aVar2);
            this.oGB.aY(false);
            this.oGB.a(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar3) {
                    if (i == 0 && bLMJoinRoomStage == BLMJoinRoomStage.PUBLISH) {
                        b.this.Mx(3);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_and_get_rtc_token_succ_host_3", true);
                    } else if (i != 0) {
                        b.this.j(i, (aVar3 != null ? aVar3.msg : "noerror") + ",stage:" + bLMJoinRoomStage, 3);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            ab Yt = c.ecZ().Yt();
                            if (Yt != null && Yt.aKu != null) {
                                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
                            }
                            jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, bLMJoinRoomStage);
                            jSONObject2.put("error_code", i);
                            jSONObject2.put("error_msg", "主持上麦失败失败：" + bLMJoinRoomStage + (aVar3 != null ? aVar3.msg : "no error"));
                        } catch (JSONException e2) {
                            BdLog.e(e2);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject2));
                        b.this.Wp("hostJoinChatJoinError:" + i + "errorMsg:" + bLMJoinRoomStage + (aVar3 != null ? aVar3.msg : "no error"));
                    }
                }
            });
        }
    }

    public void Wp(String str) {
        if (this.oGA != null) {
            this.oGA.Wp(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gV("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean Wr(String str) {
        return c(this.oGC, true, str);
    }

    public boolean gT(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gV("AudioRoomManager", "quitChat:" + str);
        this.oGQ = false;
        this.oGR = false;
        this.oGP = false;
        this.oGK = false;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("quitChatext", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "quitChat");
        if (z) {
            ecR();
        }
        if (this.oGM != null) {
            this.oGM.removeCallbacks(this.oGY);
            this.oGM.removeCallbacks(this.oGZ);
        }
        if (this.oGB != null) {
            if (this.oGJ) {
                if (ecV() == 1) {
                    this.oGB.aY(true);
                    this.oGB.b(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR);
                } else {
                    this.oGB.b(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR);
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oGB != null) {
                                b.this.oGB.xn();
                            }
                        }
                    }, 500L);
                }
            } else {
                Mv(6);
                this.oGB.b(this.oGC, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, int i2, String str3) {
                        if (i2 == 0) {
                            b.this.gV("AudioRoomManager", "quitChatleaveRoomSuccess");
                        } else {
                            b.this.gU("AudioRoomManager", "quitChatleaveRoomerror:" + i2 + str3);
                        }
                    }
                });
                this.oGF = false;
            }
        }
        return true;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.a.b$7  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass7 implements a {
        final /* synthetic */ long oHh;
        final /* synthetic */ String oHi;
        final /* synthetic */ String oHj;
        final /* synthetic */ String val$cuid;

        AnonymousClass7(long j, String str, String str2, String str3) {
            this.oHh = j;
            this.oHi = str;
            this.val$cuid = str2;
            this.oHj = str3;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
        public void B(int i, final long j) {
            if (i == 0) {
                b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList();
                        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.azK = j;
                        cVar.appId = AnonymousClass7.this.oHh;
                        cVar.appVersion = AnonymousClass7.this.oHi;
                        cVar.cuid = AnonymousClass7.this.val$cuid;
                        cVar.azQ = AnonymousClass7.this.oHj;
                        arrayList.add(cVar);
                        if (b.this.oGB != null) {
                            b.this.oGB.a(b.this.oGC, (JSONObject) null, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7.1.1
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

    public void zZ(boolean z) {
        gV("AudioRoomManager", "muteMic:" + z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "muteMic");
        this.oGQ = z;
        if (z && 5 != this.oGG) {
            this.oGG = 5;
            Mv(5);
        }
        if (this.oGB != null) {
            this.oGB.aY(z);
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
    /* loaded from: classes10.dex */
    class AnonymousClass8 implements a {
        final /* synthetic */ boolean aBT;

        AnonymousClass8(boolean z) {
            this.aBT = z;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
        public void B(int i, final long j) {
            if (i == 0) {
                b.this.t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oGB != null) {
                            ArrayList arrayList = new ArrayList();
                            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                            cVar.azK = j;
                            arrayList.add(cVar);
                            b.this.oGB.a(b.this.oGC, AnonymousClass8.this.aBT, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8.1.1
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
        Wp("answerInvite");
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
        this.oGE = z ? 5 : 4;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("invited_name", str);
            jSONObject2.put("invite_uk", str4);
            jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (i != 1) {
            if (bIMInviteSyncRtcInfo != null && this.oGB != null) {
                this.oGC = bIMInviteSyncRtcInfo.getRtcRoomId();
                this.oGB.a(bIMInviteSyncRtcInfo.getRtcRoomId(), jSONObject2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
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
        } else if (bIMInviteSyncRtcInfo == null || this.oGB == null) {
            gV("AudioRoomManager", "answerInvite error bimRtcInfo null");
            q(1, this.oGE, "answerInvite error bimRtcInfo or mBLMRtcEngine null");
        } else {
            gV("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
            this.oGC = bIMInviteSyncRtcInfo.getRtcRoomId();
            if (this.oGJ) {
                this.oGK = true;
                J(this.oGC, str, str2, str3);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("is_auto_publish", true);
            this.oGB.w(hashMap);
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.ayN = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
            a.C0167a c0167a = new a.C0167a();
            c0167a.ayS = true;
            c0167a.ayR = str2;
            c0167a.ayX = "pure_audio";
            a.C0167a c0167a2 = new a.C0167a();
            c0167a2.ayS = false;
            c0167a2.ayR = str3;
            c0167a2.ayX = "pure_audio";
            aVar.ayL = c0167a;
            aVar.ayM = c0167a2;
            this.oGB.a(aVar);
            this.oGB.aY(false);
            this.oGB.a(bIMInviteSyncRtcInfo.getRtcRoomId(), jSONObject2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i2, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar2) {
                    if (i2 == 0 && bLMJoinRoomStage == BLMJoinRoomStage.PUBLISH) {
                        b.this.Mx(z ? 5 : 4);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                    } else if (i2 != 0) {
                        b.this.j(i2, (aVar2 != null ? aVar2.msg : "noerror") + ",stage:" + bLMJoinRoomStage, z ? 5 : 4);
                    }
                }
            });
        }
    }

    public void yr() {
        gV("AudioRoomManager", "leaveRoom");
        aR("audio_room_debug", "", "leaveRoom");
        ecR();
        if (this.oGM != null) {
            this.oGM.removeCallbacksAndMessages(null);
        }
        if (this.oGL != null) {
            this.oGL.quit();
            this.oGM = null;
        }
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.oHa);
        if (this.oGA != null) {
            this.oGA.yr();
            this.oGA = null;
        }
        if (this.oGB != null) {
            this.oGB.b(this.oGC, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
                @Override // com.baidu.live.alablmsdk.c.d
                public void f(int i, int i2, String str) {
                    if (i2 == 0) {
                        b.this.gV("AudioRoomManager", "leaveRoomleaveRoomSuccess");
                    } else {
                        b.this.gU("AudioRoomManager", "leaveRoomleaveRoomerror:" + i2 + str);
                    }
                }
            });
            this.oGB.onRelease();
            this.oGB = null;
        }
        this.oGF = false;
    }

    public void aAM() {
        gV("AudioRoomManager", "pausePlayer");
        if (this.oGA != null) {
            this.oGA.aAM();
        }
    }

    public void ys() {
        gV("AudioRoomManager", "closeRoom:");
        if (this.oGB != null) {
            this.oGB.a(this.oGC, true, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
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

    public void ecQ() {
        gV("AudioRoomManager", "startHeartBeatAction");
        if (this.oGA != null) {
            this.oGA.aR("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oGN = true;
        t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oGM != null) {
                    b.this.oGM.removeCallbacks(b.this.oGX);
                    b.this.oGM.post(b.this.oGX);
                }
            }
        });
    }

    public void ecR() {
        gV("AudioRoomManager", "stopHeartBeatAction");
        if (this.oGA != null) {
            this.oGA.aR("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oGN = false;
        t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oGM != null) {
                    b.this.oGM.removeCallbacks(b.this.oGX);
                }
            }
        });
    }

    public boolean ecS() {
        return this.oGF;
    }

    public static boolean Ws(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.WV(str), 0L)));
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

    public boolean ecL() {
        if (this.oGA != null) {
            return this.oGA.ecL();
        }
        return true;
    }

    public void ecT() {
        gV("AudioRoomManager", "reStartPlayer");
        if (this.oGA != null) {
            this.oGA.cnR();
        }
    }

    public void muteOrUnmuteAudio(boolean z) {
        if ((this.oGK || (!this.oGJ && ecS())) && this.oGB != null) {
            if (z && !this.oGQ && !this.oGR) {
                this.oGP = true;
                this.oGB.aY(true);
            } else if (!z && this.oGP) {
                this.oGB.aY(false);
                this.oGP = false;
            }
            this.oGB.aZ(z);
        }
        if (this.oGJ && this.oGB != null) {
            this.oGB.aZ(z);
        }
        if (this.oGA != null) {
            this.oGA.muteOrUnmuteAudio(z);
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
                    ab Yt = c.ecZ().Yt();
                    if (Yt != null && Yt.aKu != null) {
                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
                    }
                    jSONObject.put("error_code", 0);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "im_rtc_invite").setContentExt(jSONObject));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("get_imuk_from_bduk_anchor_3", false);
                if (b.this.oGB != null) {
                    ArrayList arrayList = new ArrayList();
                    com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                    cVar.azK = j2;
                    cVar.appId = j;
                    cVar.appVersion = str3;
                    cVar.cuid = str4;
                    cVar.azQ = str2;
                    arrayList.add(cVar);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("invite_name", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
                        jSONObject2.put("invite_uk", q.edU().Ys());
                        jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                        jSONObject2.put("pushUrl", str5);
                        jSONObject2.put("pushSingleUrl", str6);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    b.this.oGB.a(str, arrayList, jSONObject2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17.1
                        @Override // com.baidu.live.alablmsdk.c.d
                        public void f(int i2, int i3, String str7) {
                            if (iStatusListener != null) {
                                iStatusListener.onResult(i3, str7);
                            }
                        }
                    });
                }
                if (b.this.oHb != null) {
                    b.this.oHb.b(new f.b(j, j2, str4, str2));
                }
            }
        });
    }

    public long ecU() {
        return AccountManager.getUK(this.mContext);
    }

    public int ecV() {
        return this.oGV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mv(final int i) {
        gV("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oGD != null) {
                    b.this.oGD.Mz(i);
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
        t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.19
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oGD != null) {
                    b.this.oGD.onError(i, i2, str);
                }
            }
        });
    }

    private void Mw(int i) {
        if (this.oGG != i) {
            if (i == 4) {
                if (this.oGM != null) {
                    this.oGM.removeCallbacks(this.oGY);
                }
                this.oGH = System.currentTimeMillis();
                this.oGG = i;
                Mv(4);
                return;
            }
            ab Yt = c.ecZ().Yt();
            if (Yt != null && Yt.aKG > 0.0d) {
                this.oGI = (long) (Yt.aKG * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oGH;
            if (currentTimeMillis > this.oGI) {
                this.oGG = i;
                Mv(5);
            } else if (this.oGM != null) {
                this.oGM.removeCallbacks(this.oGY);
                this.oGM.postDelayed(this.oGY, this.oGI - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oGH > 5000) {
            if (this.oGM != null) {
                this.oGM.removeCallbacks(this.oGY);
            }
            this.oGH = System.currentTimeMillis();
            this.oGG = i;
            Mv(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx(final int i) {
        boolean z = false;
        this.oGF = true;
        if (this.oGJ) {
            this.oGK = true;
        }
        if (this.oGB != null) {
            com.baidu.live.alablmsdk.a aVar = this.oGB;
            if (this.oGQ || this.oGR) {
                z = true;
            }
            aVar.aY(z);
        }
        t(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oGD != null) {
                    b.this.ecQ();
                    b.this.ecW();
                    if (b.this.oGM != null) {
                        b.this.oGM.removeCallbacks(b.this.oGY);
                        b.this.oGM.post(b.this.oGY);
                        b.this.oGM.removeCallbacks(b.this.oGZ);
                        b.this.oGM.postDelayed(b.this.oGZ, 500L);
                    }
                    b.this.oGD.My(i);
                }
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yt = c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
            }
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
            jSONObject.put("error_code", 0);
            jSONObject.put("error_msg", "上麦失败成功joinChatType:" + i + ",rtcType:" + this.oGV);
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
        this.oGF = false;
        if (this.oGJ) {
            this.oGK = false;
        } else {
            if (this.oGB != null) {
                this.oGB.b(this.oGC, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
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
            ecR();
        }
        if (this.oGM != null) {
            this.oGM.removeCallbacks(this.oGZ);
            this.oGM.removeCallbacks(this.oGY);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yt = c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
            }
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", "上麦失败msg:" + str + ",joinChatType:" + i2 + ",rtctype:" + this.oGV + "|" + c.ecZ().edb().ecY());
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
        Wp("joinChatErrormsg:" + str + "errorcode:" + i + ",type:" + i2);
        gU("AudioRoomManager", "joinChatErrormsg:" + str + "errorcode:" + i + ",type:" + i2);
        q(1, i2, "joinchaterrorcode:" + i + "errorMsg:" + str + "userType:" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecW() {
        com.baidu.live.alablmsdk.module.rtc.d yn;
        if (this.oGB != null && (yn = this.oGB.xp().yn()) != null) {
            ab Yt = c.ecZ().Yt();
            if (Yt != null) {
                if (this.oGV == 1) {
                    oGv = Yt.aKI;
                } else {
                    oGv = Yt.aKJ;
                }
            }
            gV("AudioRoomManager", "currentVolume:" + yn.volume);
            if (yn.volume > oGv) {
                Mw(4);
            } else {
                Mw(5);
            }
        }
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Runnable runnable) {
        SafeHandler.getInst().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
            Log.i(str, str2);
        }
    }

    public void aR(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            ab Yt = c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
            }
            jSONObject2.put(AlaRecorderLog.KEY_RES_TYPE, str);
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str2);
            }
            jSONObject.put("imuk", ecU());
            jSONObject.put("rtcroomid", this.oGC);
            jSONObject.put("rtctype", this.oGV);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK, BdNetTypeUtil.isNetWorkAvailable());
            jSONObject.put("imstatus", this.oGO);
            jSONObject.put("opertaionType", str3);
            jSONObject.put("thread", Thread.currentThread().getName());
            jSONObject.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject2.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_LIVE_DEBUG, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "audio_live_debug").setContentExt(jSONObject2));
    }

    public boolean ecX() {
        return this.oGK;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oGB != null) {
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.azK = j;
            this.oGB.a(str, cVar);
        }
    }

    public String ecY() {
        return this.oGA != null ? this.oGA.ecM() + ",rtcroomid:" + this.oGC + ",imuk:" + ecU() + ",rtcType:" + this.oGV + "netstatus:" + BdNetTypeUtil.isNetWorkAvailable() + "imstatus:" + this.oGO + "#" + this.oGS + ",isStartHeartBeat:" + this.oGN + ",time:" + System.currentTimeMillis() : "";
    }
}
