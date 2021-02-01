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
    private static long oDQ = 5;
    private static String oDU = "1127144634";
    private Context mContext;
    private String mRoomId;
    private com.baidu.tieba.yuyinala.liveroom.wheat.a.a oDV;
    private com.baidu.live.alablmsdk.a oDW;
    private String oDX;
    private d oDY;
    private int oDZ;
    private boolean oEa;
    private int oEb;
    private long oEc;
    private boolean oEe;
    private boolean oEf;
    private HandlerThread oEg;
    private Handler oEh;
    private boolean oEi;
    private volatile boolean oEj;
    private boolean oEk;
    private boolean oEl;
    private boolean oEm;
    private String oEn;
    private String oEo;
    private long oEp;
    private int oEq;
    private boolean oEr;
    private final f oEw;
    private long oEd = 2000;
    private Runnable oEs = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.h.a.b.c cVar;
            com.baidu.h.b.a bA = com.baidu.h.b.a.bA(b.this.mContext);
            if (bA == null) {
                if (b.this.oDV != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mIMCastId", b.this.oEo);
                        jSONObject.put("step", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.oDV.aR("audio_room_manager", jSONObject.toString(), "heartbeaterror");
                }
                b.this.oEn = "heartbeaterror1，" + System.currentTimeMillis();
                return;
            }
            com.baidu.h.b.a.a.b bVar = (com.baidu.h.b.a.a.b) bA.ZU();
            if (bVar != null && !TextUtils.isEmpty(b.this.oEo)) {
                try {
                    cVar = bVar.iT(b.this.oEo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (b.this.oDV != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mIMCastId", b.this.oEo);
                            jSONObject2.put("step", "3");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        b.this.oDV.aR("audio_room_manager", jSONObject2.toString(), "heartbeaterror");
                    }
                    b.this.oEn = "heartbeaterror3," + System.currentTimeMillis();
                    return;
                }
                ((com.baidu.h.b.a.a) cVar).ZZ().sendQuizOpts(JavaTypesHelper.toLong(b.this.mRoomId, 0L), JavaTypesHelper.toLong(b.this.oEo, 0L), 2001, "", new IMcastSetListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.1.1
                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i, long j, long j2) {
                        b.this.gT("audioroom", "HeartBeat:" + i + "," + j + "," + j2);
                        if (i != 0) {
                            if (b.this.oEi && b.this.oEj && b.this.oEh != null) {
                                b.this.oEh.removeCallbacks(b.this.oEs);
                                b.this.oEh.post(b.this.oEs);
                                if (System.currentTimeMillis() - b.this.oEp > 1000 && b.this.oDV != null) {
                                    b.this.oEp = System.currentTimeMillis();
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("mIMCastId", b.this.oEo);
                                        jSONObject3.put("step", "4");
                                        jSONObject3.put("errorcode", i);
                                        jSONObject3.put("l", j);
                                        jSONObject3.put("l1", j2);
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                    b.this.oDV.aR("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
                                }
                            }
                            b.this.oEn = "heartbeaterrornum:" + i + "," + j + "," + j2 + "," + System.currentTimeMillis();
                            return;
                        }
                        b.this.oEn = "heartbeatok:" + System.currentTimeMillis();
                    }
                });
                if (b.this.oEh != null) {
                    b.this.oEh.postDelayed(this, 5000L);
                    return;
                }
                return;
            }
            b.this.oEn = "heartbeaterror2," + b.this.oEo + "," + System.currentTimeMillis();
            if (b.this.oDV != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("mIMCastId", b.this.oEo);
                    jSONObject3.put("step", "2");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                b.this.oDV.aR("audio_room_manager", jSONObject3.toString(), "heartbeaterror");
            }
        }
    };
    private Runnable oEt = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.12
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.oEb != 5) {
                b.this.oEb = 5;
                b.this.Mq(5);
            }
        }
    };
    private Runnable oEu = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.22
        @Override // java.lang.Runnable
        public void run() {
            b.this.ecG();
            if (b.this.oEh != null) {
                b.this.oEh.postDelayed(this, 500L);
            }
        }
    };
    private ILiveMsgReceiveListener oEv = new ILiveMsgReceiveListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.23
        @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
        public void onReceiveMessage(int i, JSONArray jSONArray) {
            b.this.gT("AudioRoomManager", "receiveb2cmsg:" + i + "," + jSONArray.toString());
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
                        b.this.gT("AudioRoomManager", "do send audio_link_apply_toast");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("audio_link_cancel_apply", (CharSequence) entry.getKey())) {
                        b.this.gT("AudioRoomManager", "do send audio_link_cancel_apply");
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, entry.getValue()));
                    } else if (TextUtils.equals("live_audio_lower_wheat", (CharSequence) entry.getKey())) {
                        b.this.gT("AudioRoomManager", "do live_audio_lower_wheat");
                        if (b.this.gR(b.this.oDX, "用户被审核下麦")) {
                            b.this.Mq(7);
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
        this.oEr = true;
        this.mContext = context;
        this.mRoomId = str;
        this.oEo = str2;
        if (this.oDW != null && this.oEq != i) {
            if (!TextUtils.isEmpty(this.oDX)) {
                this.oDW.b(this.oDX, (JSONObject) null, (com.baidu.live.alablmsdk.c.d) null);
            }
            this.oDW.onRelease();
        }
        this.oEq = i;
        if (this.oEg == null) {
            this.oEg = new HandlerThread("AudioRoomManager_Thread");
            this.oEg.start();
        }
        if (this.oEh == null && this.oEg.isAlive()) {
            this.oEh = new Handler(this.oEg.getLooper());
        }
        this.oEw = new f(this.oEh);
        this.oEw.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.24
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.f.a
            public void a(f.b bVar) {
            }
        });
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
        }
        BIMManager.registerStudioUsePaReceiveMsg(context, this.oEv);
        IConnectListener iConnectListener = new IConnectListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.25
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i2) {
                b.this.gT("AudioRoomManager", "ConnectListener status:" + i2);
                if (i2 == 0) {
                    b.this.oEj = true;
                    if (b.this.oEi) {
                        b.this.ecA();
                        return;
                    }
                    return;
                }
                b.this.oEj = false;
            }
        };
        gT("AudioRoomManager", "add ConnectListener:" + iConnectListener.hashCode());
        BIMManager.registerConnectListenerToList(iConnectListener);
        if (!z) {
            this.oDW = new com.baidu.live.alablmsdk.a(context);
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
            ab Yq = c.ecJ().Yq();
            if (Yq != null) {
                this.oEr = Yq.aJk;
            }
            if (this.oEr) {
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
            hashMap2.put("yy_rtc_app_id_key", oDU);
            hashMap2.put("yy_rtc_room_mode_key", 0);
            hashMap2.put("yy_rtc_media_mode_key", 2);
            hashMap2.put("yy_rtc_audio_config_key", 7);
            hashMap2.put("yy_rtc_commu_mode_key", 2);
            hashMap2.put("yy_rtc_scenario_mode_key", 2);
            hashMap2.put("yy_rtc_sound_effect_type_key", 4);
            hashMap.put("yy_rtc_private_params_key", hashMap2);
            this.oDW.v(hashMap);
            this.oDW.a(new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26
                @Override // com.baidu.live.alablmsdk.c.b.e
                public void a(String str3, String str4, final com.baidu.live.alablmsdk.c.b.a aVar) {
                    com.baidu.live.yyrtc.a.ZK().a(str3, str4, new com.baidu.live.yyrtc.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.26.1
                        @Override // com.baidu.live.yyrtc.b
                        public void ai(String str5, String str6) {
                            if (b.this.oDW != null) {
                                b.this.oDW.ew(str5);
                            }
                            if (aVar != null) {
                                aVar.ai(str5, str6);
                            }
                        }
                    });
                }
            });
            this.oDW.a(new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27
                @Override // com.baidu.live.alablmsdk.c.b
                public void g(int i2, String str3) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i2) {
                    if (cVar != null && cVar.ayk == b.this.ecE()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("sec", i2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        b.this.aR("audio_room_debug", jSONObject.toString(), "leavedForSeconds");
                        if (i2 == 10) {
                            b.this.gT("AudioRoomManager", "leavedForSeconds:" + i2);
                        } else if (i2 >= 15) {
                            if (b.this.oDW != null) {
                                b.this.oDW.b(b.this.oDX, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.1
                                    @Override // com.baidu.live.alablmsdk.c.d
                                    public void f(int i3, int i4, String str3) {
                                        if (i4 == 0) {
                                            b.this.gT("AudioRoomManager", "leavedForSecondsleaveRoomSuccess");
                                        } else {
                                            b.this.gS("AudioRoomManager", "leavedForSecondsleaveRoomerror:" + i4 + str3);
                                        }
                                    }
                                });
                            }
                            b.this.oEa = false;
                            if (b.this.oEe) {
                                b.this.oEf = false;
                            }
                            b.this.q(1, b.this.oDZ, "streamleavedForSeconds" + i2);
                        }
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void a(String str3, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
                    if (b.this.oEw != null && cVar != null) {
                        b.this.oEw.hQ(cVar.ayk);
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void b(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oDY != null) {
                                BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = new BIMInviteSyncRtcInfo();
                                bIMInviteSyncRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMInviteSyncRtcInfo.setRtcExt(jSONObject.toString());
                                    b.this.oDY.a(bIMInviteSyncRtcInfo);
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
                            if (b.this.oDY != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                b.this.oDY.b(bIMRtcInfo, 3);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void d(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oDY != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMRtcInfo.setRtcExt(jSONObject.toString());
                                }
                                b.this.oDY.b(bIMRtcInfo, 1);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void e(final String str3, com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oDY != null) {
                                BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
                                bIMRtcInfo.setRtcRoomId(str3);
                                if (jSONObject != null) {
                                    bIMRtcInfo.setRtcExt(jSONObject.toString());
                                }
                                b.this.oDY.b(bIMRtcInfo, 3);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void c(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oDY != null && cVar != null) {
                                b.this.oDY.hO(cVar.ayk);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void d(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oDY != null && cVar != null) {
                                b.this.oDY.hP(cVar.ayk);
                            }
                        }
                    });
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void e(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.ayk == b.this.ecE()) {
                        b.this.gR(b.this.oDX, "RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED");
                        b.this.Mq(1);
                        b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.11
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oDY != null) {
                                    b.this.oDY.bQ(cVar.ayk);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void f(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.ayk == b.this.ecE()) {
                        b.this.Mq(2);
                        b.this.oEm = false;
                        b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.12
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oDY != null) {
                                    b.this.oDY.u(cVar.ayk, true);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.live.alablmsdk.c.b
                public void g(String str3, final com.baidu.live.alablmsdk.module.c cVar) {
                    if (cVar != null && cVar.ayk == b.this.ecE()) {
                        b.this.Mq(3);
                        b.this.oEm = false;
                        b.this.u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.27.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.oDY != null) {
                                    b.this.oDY.u(cVar.ayk, false);
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
                            if (b.this.oDY != null && aVar != null) {
                                b.this.oDY.g(0, aVar.ayk, aVar.message);
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
                            if (b.this.oDY != null) {
                                b.this.oDY.Rl();
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
                            if (b.this.oDV != null) {
                                b.this.oDV.aR("lmsdk", jSONObject3, "debug");
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
        this.oDV = new com.baidu.tieba.yuyinala.liveroom.wheat.a.a(context);
        this.oDV.setRtcRoomListener(new RtcRoomListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.28
            @Override // com.baidu.ala.rtc.RtcRoomListener
            public void onError(int i2, String str3) {
                b.this.q(-4, b.this.oDZ, "playererror,errorCode:" + i2 + ",errorMsg:" + str3);
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
        this.oDY = dVar;
    }

    public void VX(String str) {
        if (this.oDV != null) {
            this.oDV.n(str, false, true);
        }
    }

    public void ecz() {
        gP(c.ecJ().ecO(), TbadkCoreApplication.getCurrentAccountName());
    }

    public void gP(String str, String str2) {
        VW("ownerEnterRoom");
        gT("AudioRoomManager", "ownerEnterRoom:" + str + "," + str2);
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
        if (this.oDW != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (ecF() == 1) {
                hashMap.put("is_auto_publish", true);
                this.oDW.aY(true);
            } else {
                hashMap.put("is_auto_publish", false);
            }
            this.oDW.w(hashMap);
            this.oDW.a(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar) {
                    if (i != 0) {
                        b.this.gT("AudioRoomManager", "ownerEnterRoomfailed:" + i + (aVar != null ? aVar.msg : "noerror"));
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("status", i);
                            jSONObject2.put("stage", bLMJoinRoomStage);
                            jSONObject2.put(BdStatsConstant.StatsType.ERROR, aVar != null ? aVar.msg : "noerror");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        b.this.aR("audio_room_debug", jSONObject2.toString(), "ownerEnterRoomFailed");
                        b.this.oEa = false;
                        if (b.this.oDW != null) {
                            b.this.oDW.b(b.this.oDX, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.2.1
                                @Override // com.baidu.live.alablmsdk.c.d
                                public void f(int i2, int i3, String str3) {
                                    if (i3 == 0) {
                                        b.this.gT("AudioRoomManager", "ownerEnterRoomleaveRoomSuccess");
                                    } else {
                                        b.this.gS("AudioRoomManager", "ownerEnterRoomleaveRoomerror:" + i3 + str3);
                                    }
                                }
                            });
                        }
                        b.this.VW("ownerEnterRoomJoinError:" + i + (aVar != null ? aVar.msg : "no error"));
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
                        b.this.gT("AudioRoomManager", "ownerEnterRoomSuccess");
                        b.this.VW("ownerEnterRoomSuccess");
                        b.this.oEa = true;
                    }
                }
            });
        }
        this.oDX = str;
        this.oEe = true;
        this.oEf = false;
    }

    public void gQ(String str, String str2) {
        gT("AudioRoomManager", "commonUserEnterRoom:," + str + "," + str2);
        this.oEe = false;
        this.oEf = false;
        if (this.oDV != null) {
            this.oDV.VV(str2);
        }
    }

    public void J(String str, String str2, final String str3, final String str4) {
        VW("ownerJoinChat:isOwner" + this.oEe);
        gT("AudioRoomManager", "ownerJoinChat:," + str2 + "," + str + "," + str3 + "," + str4);
        this.oDZ = this.oEe ? 2 : 3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str2);
            jSONObject.put("joinChatType", this.oDZ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "ownerJoinChat");
        if (TextUtils.equals("0", str) || TextUtils.isEmpty(str)) {
            q(1, this.oDZ, "imrtcroomid==" + str);
        } else if (this.oDW == null) {
            q(1, this.oDZ, "mBLMRtcEngine==null");
        } else {
            this.oDX = str;
            aAJ();
            if (this.oEe) {
                if (ecF() == 1) {
                    this.oDW.aY(false);
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
                    this.oDW.a(aVar);
                    this.oDW.a(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR);
                    Ms(2);
                    return;
                }
                this.oDW.a(new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.3
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, int i2, String str5) {
                        if (i2 != 0 || i != 10) {
                            b.this.j(i2, str5, 2);
                            return;
                        }
                        b.this.Ms(2);
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
                        b.this.oDW.a(aVar2);
                        b.this.oDW.a(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR);
                    }
                });
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("is_auto_publish", true);
            this.oDW.w(hashMap);
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
            this.oDW.a(aVar2);
            this.oDW.aY(false);
            this.oDW.a(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.4
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar3) {
                    if (i == 0 && bLMJoinRoomStage == BLMJoinRoomStage.PUBLISH) {
                        b.this.Ms(3);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_and_get_rtc_token_succ_host_3", true);
                    } else if (i != 0) {
                        b.this.j(i, (aVar3 != null ? aVar3.msg : "noerror") + ",stage:" + bLMJoinRoomStage, 3);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            ab Yq = c.ecJ().Yq();
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
                        b.this.VW("hostJoinChatJoinError:" + i + "errorMsg:" + bLMJoinRoomStage + (aVar3 != null ? aVar3.msg : "no error"));
                    }
                }
            });
        }
    }

    public void VW(String str) {
        if (this.oDV != null) {
            this.oDV.VW(str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, boolean z, String str5, String str6, IStatusListener iStatusListener) {
        gT("AudioRoomManager", "inviteJoinChat:" + str + "," + str2 + "," + str3 + "," + j + "," + str4);
        b(str4, str, str3, j, str2, z, str5, str6, iStatusListener);
    }

    public boolean VY(String str) {
        return c(this.oDX, true, str);
    }

    public boolean gR(String str, String str2) {
        return c(str, true, str2);
    }

    public boolean c(String str, boolean z, String str2) {
        gT("AudioRoomManager", "quitChat:" + str);
        this.oEl = false;
        this.oEm = false;
        this.oEk = false;
        this.oEf = false;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("quitChatext", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "quitChat");
        if (z) {
            ecB();
        }
        if (this.oEh != null) {
            this.oEh.removeCallbacks(this.oEt);
            this.oEh.removeCallbacks(this.oEu);
        }
        if (this.oDW != null) {
            if (this.oEe) {
                if (ecF() == 1) {
                    this.oDW.aY(true);
                    this.oDW.b(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR);
                } else {
                    this.oDW.b(BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR);
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.oDW != null) {
                                b.this.oDW.xk();
                            }
                        }
                    }, 500L);
                }
            } else {
                Mq(6);
                this.oDW.b(this.oDX, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.6
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, int i2, String str3) {
                        if (i2 == 0) {
                            b.this.gT("AudioRoomManager", "quitChatleaveRoomSuccess");
                        } else {
                            b.this.gS("AudioRoomManager", "quitChatleaveRoomerror:" + i2 + str3);
                        }
                    }
                });
                this.oEa = false;
            }
        }
        return true;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.a.b$7  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements a {
        final /* synthetic */ long oEC;
        final /* synthetic */ String oED;
        final /* synthetic */ String oEE;
        final /* synthetic */ String val$cuid;

        AnonymousClass7(long j, String str, String str2, String str3) {
            this.oEC = j;
            this.oED = str;
            this.val$cuid = str2;
            this.oEE = str3;
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
                        cVar.appId = AnonymousClass7.this.oEC;
                        cVar.appVersion = AnonymousClass7.this.oED;
                        cVar.cuid = AnonymousClass7.this.val$cuid;
                        cVar.ayq = AnonymousClass7.this.oEE;
                        arrayList.add(cVar);
                        if (b.this.oDW != null) {
                            b.this.oDW.a(b.this.oDX, (JSONObject) null, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.7.1.1
                                @Override // com.baidu.live.alablmsdk.c.d
                                public void f(int i2, int i3, String str) {
                                    if (i3 == 0) {
                                        b.this.gT("AudioRoomManager", "kickoffsuccess");
                                    } else {
                                        b.this.gT("AudioRoomManager", "kickofffailed" + i3 + str);
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
        gT("AudioRoomManager", "kickOffUser:" + str);
        a(str, new AnonymousClass7(j, str2, str3, str));
    }

    public void Aa(boolean z) {
        gT("AudioRoomManager", "muteMic:" + z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "muteMic");
        this.oEl = z;
        if (z && 5 != this.oEb) {
            this.oEb = 5;
            Mq(5);
        }
        if (this.oDW != null) {
            this.oDW.aY(z);
        }
    }

    public void bg(String str, boolean z) {
        gT("AudioRoomManager", "muteUser:" + str + "," + z);
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
                        if (b.this.oDW != null) {
                            ArrayList arrayList = new ArrayList();
                            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                            cVar.ayk = j;
                            arrayList.add(cVar);
                            b.this.oDW.a(b.this.oDX, AnonymousClass8.this.aAt, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.8.1.1
                                @Override // com.baidu.live.alablmsdk.c.d
                                public void f(int i2, int i3, String str) {
                                    if (i3 == 0) {
                                        b.this.gT("AudioRoomManager", "muteUsersuccess");
                                    } else {
                                        b.this.gT("AudioRoomManager", "muteUserfailed" + i3 + str);
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
        VW("answerInvite");
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
        this.oDZ = z ? 5 : 4;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("invited_name", str);
            jSONObject2.put("invite_uk", str4);
            jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (i != 1) {
            if (bIMInviteSyncRtcInfo != null && this.oDW != null) {
                this.oDX = bIMInviteSyncRtcInfo.getRtcRoomId();
                this.oDW.a(bIMInviteSyncRtcInfo.getRtcRoomId(), jSONObject2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.9
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i2, int i3, String str5) {
                        if (i3 == 0) {
                            b.this.gT("AudioRoomManager", "rejectRoomSuccess");
                        } else {
                            b.this.gS("AudioRoomManager", "rejectRoomerror:" + i3 + str5);
                        }
                    }
                });
            }
        } else if (bIMInviteSyncRtcInfo == null || this.oDW == null) {
            gT("AudioRoomManager", "answerInvite error bimRtcInfo null");
            q(1, this.oDZ, "answerInvite error bimRtcInfo or mBLMRtcEngine null");
        } else {
            gT("AudioRoomManager", "answerInvite:" + bIMInviteSyncRtcInfo.toRtcInfoString());
            this.oDX = bIMInviteSyncRtcInfo.getRtcRoomId();
            if (this.oEe) {
                this.oEf = true;
                J(this.oDX, str, str2, str3);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("is_auto_publish", true);
            this.oDW.w(hashMap);
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
            this.oDW.a(aVar);
            this.oDW.aY(false);
            this.oDW.a(bIMInviteSyncRtcInfo.getRtcRoomId(), jSONObject2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.10
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(int i2, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar2) {
                    if (i2 == 0 && bLMJoinRoomStage == BLMJoinRoomStage.PUBLISH) {
                        b.this.Ms(z ? 5 : 4);
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("answer_invite_anchor_6", false);
                    } else if (i2 != 0) {
                        b.this.j(i2, (aVar2 != null ? aVar2.msg : "noerror") + ",stage:" + bLMJoinRoomStage, z ? 5 : 4);
                    }
                }
            });
        }
    }

    public void yo() {
        gT("AudioRoomManager", "leaveRoom");
        aR("audio_room_debug", "", "leaveRoom");
        ecB();
        if (this.oEh != null) {
            this.oEh.removeCallbacksAndMessages(null);
        }
        if (this.oEg != null) {
            this.oEg.quit();
            this.oEh = null;
        }
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this.oEv);
        if (this.oDV != null) {
            this.oDV.yo();
            this.oDV = null;
        }
        if (this.oDW != null) {
            this.oDW.b(this.oDX, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.11
                @Override // com.baidu.live.alablmsdk.c.d
                public void f(int i, int i2, String str) {
                    if (i2 == 0) {
                        b.this.gT("AudioRoomManager", "leaveRoomleaveRoomSuccess");
                    } else {
                        b.this.gS("AudioRoomManager", "leaveRoomleaveRoomerror:" + i2 + str);
                    }
                }
            });
            this.oDW.onRelease();
            this.oDW = null;
        }
        this.oEa = false;
    }

    public void aAJ() {
        gT("AudioRoomManager", "pausePlayer");
        if (this.oDV != null) {
            this.oDV.aAJ();
        }
    }

    public void yp() {
        gT("AudioRoomManager", "closeRoom:");
        if (this.oDW != null) {
            this.oDW.a(this.oDX, true, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.13
                @Override // com.baidu.live.alablmsdk.c.d
                public void f(int i, int i2, String str) {
                    if (i2 == 0) {
                        b.this.gT("AudioRoomManager", "closeRoomSuccess");
                    } else {
                        b.this.gS("AudioRoomManager", "closeRoomerror:" + i2 + str);
                    }
                }
            });
        }
    }

    public void ecA() {
        gT("AudioRoomManager", "startHeartBeatAction");
        if (this.oDV != null) {
            this.oDV.aR("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oEi = true;
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.14
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEh != null) {
                    b.this.oEh.removeCallbacks(b.this.oEs);
                    b.this.oEh.post(b.this.oEs);
                }
            }
        });
    }

    public void ecB() {
        gT("AudioRoomManager", "stopHeartBeatAction");
        if (this.oDV != null) {
            this.oDV.aR("audio_room_manager", "", "startHeartBeatAction");
        }
        this.oEi = false;
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oEh != null) {
                    b.this.oEh.removeCallbacks(b.this.oEs);
                }
            }
        });
    }

    public boolean ecC() {
        return this.oEa;
    }

    public static boolean VZ(String str) {
        return TextUtils.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY, str);
    }

    public void a(String str, final a aVar) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(JavaTypesHelper.toLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.b.WC(str), 0L)));
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

    public boolean ecv() {
        if (this.oDV != null) {
            return this.oDV.ecv();
        }
        return true;
    }

    public void ecD() {
        gT("AudioRoomManager", "reStartPlayer");
        if (this.oDV != null) {
            this.oDV.cnE();
        }
    }

    public void muteOrUnmuteAudio(boolean z) {
        if ((this.oEf || (!this.oEe && ecC())) && this.oDW != null) {
            if (z && !this.oEl && !this.oEm) {
                this.oEk = true;
                this.oDW.aY(true);
            } else if (!z && this.oEk) {
                this.oDW.aY(false);
                this.oEk = false;
            }
            this.oDW.aZ(z);
        }
        if (this.oEe && this.oDW != null) {
            this.oDW.aZ(z);
        }
        if (this.oDV != null) {
            this.oDV.muteOrUnmuteAudio(z);
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
                    ab Yq = c.ecJ().Yq();
                    if (Yq != null && Yq.aIU != null) {
                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                    }
                    jSONObject.put("error_code", 0);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "im_rtc_invite").setContentExt(jSONObject));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("get_imuk_from_bduk_anchor_3", false);
                if (b.this.oDW != null) {
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
                        jSONObject2.put("invite_uk", q.edE().Yp());
                        jSONObject2.put("type", z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "invite");
                        jSONObject2.put("pushUrl", str5);
                        jSONObject2.put("pushSingleUrl", str6);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    b.this.oDW.a(str, arrayList, jSONObject2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.17.1
                        @Override // com.baidu.live.alablmsdk.c.d
                        public void f(int i2, int i3, String str7) {
                            if (iStatusListener != null) {
                                iStatusListener.onResult(i3, str7);
                            }
                        }
                    });
                }
                if (b.this.oEw != null) {
                    b.this.oEw.b(new f.b(j, j2, str4, str2));
                }
            }
        });
    }

    public long ecE() {
        return AccountManager.getUK(this.mContext);
    }

    public int ecF() {
        return this.oEq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq(final int i) {
        gT("AudioRoomManager", "rtcroom,notifySyncStatus:" + i);
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.18
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oDY != null) {
                    b.this.oDY.Mu(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final int i, final int i2, final String str) {
        gT("AudioRoomManager", "rtcroom,notifyError:" + i + ",subErrorCode:" + i2 + ",errMsg:" + str);
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
                if (b.this.oDY != null) {
                    b.this.oDY.onError(i, i2, str);
                }
            }
        });
    }

    private void Mr(int i) {
        if (this.oEb != i) {
            if (i == 4) {
                if (this.oEh != null) {
                    this.oEh.removeCallbacks(this.oEt);
                }
                this.oEc = System.currentTimeMillis();
                this.oEb = i;
                Mq(4);
                return;
            }
            ab Yq = c.ecJ().Yq();
            if (Yq != null && Yq.aJg > 0.0d) {
                this.oEd = (long) (Yq.aJg * 1000.0d);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.oEc;
            if (currentTimeMillis > this.oEd) {
                this.oEb = i;
                Mq(5);
            } else if (this.oEh != null) {
                this.oEh.removeCallbacks(this.oEt);
                this.oEh.postDelayed(this.oEt, this.oEd - currentTimeMillis);
            }
        } else if (i == 4 && System.currentTimeMillis() - this.oEc > 5000) {
            if (this.oEh != null) {
                this.oEh.removeCallbacks(this.oEt);
            }
            this.oEc = System.currentTimeMillis();
            this.oEb = i;
            Mq(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ms(final int i) {
        boolean z = false;
        this.oEa = true;
        if (this.oEe) {
            this.oEf = true;
        }
        if (this.oDW != null) {
            com.baidu.live.alablmsdk.a aVar = this.oDW;
            if (this.oEl || this.oEm) {
                z = true;
            }
            aVar.aY(z);
        }
        u(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.20
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oDY != null) {
                    b.this.ecA();
                    b.this.ecG();
                    if (b.this.oEh != null) {
                        b.this.oEh.removeCallbacks(b.this.oEt);
                        b.this.oEh.post(b.this.oEt);
                        b.this.oEh.removeCallbacks(b.this.oEu);
                        b.this.oEh.postDelayed(b.this.oEu, 500L);
                    }
                    b.this.oDY.Mt(i);
                }
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = c.ecJ().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
            jSONObject.put("error_code", 0);
            jSONObject.put("error_msg", "上麦失败成功joinChatType:" + i + ",rtcType:" + this.oEq);
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
        gT("AudioRoomManager", "joinChatSuccess,type:" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str, int i2) {
        this.oEa = false;
        if (this.oEe) {
            this.oEf = false;
        } else {
            if (this.oDW != null) {
                this.oDW.b(this.oDX, (JSONObject) null, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.b.21
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i3, int i4, String str2) {
                        if (i4 == 0) {
                            b.this.gT("AudioRoomManager", "joinChatFailedleaveRoomSuccess");
                        } else {
                            b.this.gS("AudioRoomManager", "joinChatErrorleaveRoomerror:" + i4 + str2);
                        }
                    }
                });
            }
            ecB();
        }
        if (this.oEh != null) {
            this.oEh.removeCallbacks(this.oEu);
            this.oEh.removeCallbacks(this.oEt);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = c.ecJ().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", "上麦失败msg:" + str + ",joinChatType:" + i2 + ",rtctype:" + this.oEq + "|" + c.ecJ().ecL().ecI());
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
        VW("joinChatErrormsg:" + str + "errorcode:" + i + ",type:" + i2);
        gS("AudioRoomManager", "joinChatErrormsg:" + str + "errorcode:" + i + ",type:" + i2);
        q(1, i2, "joinchaterrorcode:" + i + "errorMsg:" + str + "userType:" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecG() {
        com.baidu.live.alablmsdk.module.rtc.d yk;
        if (this.oDW != null && (yk = this.oDW.xm().yk()) != null) {
            ab Yq = c.ecJ().Yq();
            if (Yq != null) {
                if (this.oEq == 1) {
                    oDQ = Yq.aJi;
                } else {
                    oDQ = Yq.aJj;
                }
            }
            gT("AudioRoomManager", "currentVolume:" + yk.volume);
            if (yk.volume > oDQ) {
                Mr(4);
            } else {
                Mr(5);
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
    public void gS(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(String str, String str2) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
            Log.i(str, str2);
        }
    }

    public void aR(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            ab Yq = c.ecJ().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject2.put(AlaRecorderLog.KEY_RES_TYPE, str);
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str2);
            }
            jSONObject.put("imuk", ecE());
            jSONObject.put("rtcroomid", this.oDX);
            jSONObject.put("rtctype", this.oEq);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK, BdNetTypeUtil.isNetWorkAvailable());
            jSONObject.put("imstatus", this.oEj);
            jSONObject.put("opertaionType", str3);
            jSONObject.put("thread", Thread.currentThread().getName());
            jSONObject.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject2.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_LIVE_DEBUG, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "audio_live_debug").setContentExt(jSONObject2));
    }

    public boolean ecH() {
        return this.oEf;
    }

    public void sendMessageToUser(String str, long j) {
        if (this.oDW != null) {
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.ayk = j;
            this.oDW.a(str, cVar);
        }
    }

    public String ecI() {
        return this.oDV != null ? this.oDV.ecw() + ",rtcroomid:" + this.oDX + ",imuk:" + ecE() + ",rtcType:" + this.oEq + "netstatus:" + BdNetTypeUtil.isNetWorkAvailable() + "imstatus:" + this.oEj + "#" + this.oEn + ",isStartHeartBeat:" + this.oEi + ",time:" + System.currentTimeMillis() : "";
    }
}
