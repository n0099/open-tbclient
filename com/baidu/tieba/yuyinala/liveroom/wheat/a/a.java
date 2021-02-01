package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.rtc.BaseRtcRoom;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.ab;
import com.baidu.live.data.cl;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.g;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BaseRtcRoom {
    private static String oDC;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer oDD;
    private String oDE;
    private String oDF;
    private boolean oDG;
    private volatile int oDH;
    private volatile int oDI;
    private HashMap<Integer, Integer> oDJ;
    private boolean oDK;
    private boolean oDL;
    private StringBuilder oDM;
    private volatile boolean oDN;
    private volatile boolean oDO;
    private volatile boolean oDP;
    public static boolean oDA = false;
    private static int oDB = 6;
    private static long oDQ = 300;

    static /* synthetic */ int l(a aVar) {
        int i = aVar.oDH;
        aVar.oDH = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(oDC)) {
            oDC = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.oDI = 0;
        this.oDJ = new HashMap<>();
        this.oDK = true;
        this.oDM = new StringBuilder();
        VW("initaudioroom");
    }

    public void VV(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "enterLiveRoom");
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (oDA) {
            VW("enterLiveRoom:" + str + ",mstatus:" + this.oDI + ",misConnect:" + this.oDL);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("forceCreatePlayer", z);
            jSONObject.put("isPreLoad", z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "enterLiveRoom");
        this.oDO = true;
        if (!z && !this.oDG && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2 && this.oDD != null) {
                this.oDD.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
                this.mRtcRoomListener.onEnterRoomResult(false);
            }
        } else {
            this.oDG = false;
            this.mPlayUrl = str;
            if (!i.MT().MU()) {
                log("playersdk do not init");
                VW("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    this.mRtcRoomListener.onEnterRoomResult(false);
                    return;
                }
                return;
            }
            if (this.oDD != null) {
                this.oDD.stop();
                this.oDD.release();
            }
            this.oDD = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            cl clVar = com.baidu.live.ae.a.Qj().buX.aNt;
            if (clVar != null) {
                j = clVar.aRe;
                f = clVar.aRf;
                j2 = clVar.aRg;
                j3 = clVar.aRh * 1000;
            }
            log("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            if (oDA) {
                VW("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.oDD.setOption("opt-open-audio-delay", 0L);
            this.oDD.setOption("realtime-low-latency-threshold", j);
            this.oDD.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.oDD.setOption("start-on-prepared", 1L);
            this.oDD.setOption("max-analyze-duration", String.valueOf(j3));
            this.oDD.setOption("max-probe-size", "204800");
            this.oDD.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.oDD.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.oDD.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    if (a.this.oDO && a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onEnterRoomResult(false);
                    }
                    a.this.oDG = true;
                    a.this.oDP = false;
                    a.this.oDO = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.VW("cyplayer:onerror:" + i + "," + i2);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(-4, "playererror:" + i + "," + i2);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", a.this.mPlayUrl);
                        jSONObject2.put("i", i);
                        jSONObject2.put("i1", i2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    a.this.aR("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnErrorListener");
                    return false;
                }
            });
            this.oDD.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.oDD.setSpeed(f);
                                } else {
                                    a.this.oDD.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        if (a.this.oDO && a.this.mRtcRoomListener != null) {
                            a.this.mRtcRoomListener.onEnterRoomResult(true);
                        }
                        a.this.oDP = true;
                        a.this.oDO = false;
                    }
                    return false;
                }
            });
            this.oDD.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.oDA) {
                        a.this.VW(",cyplayer:onPrepared");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", a.this.mPlayUrl);
                        jSONObject2.put("mIsLeaveRoom", a.this.oDN);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    a.this.aR("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnPreparedListener");
                    if (a.this.oDN) {
                        a.this.oDD.stop();
                        a.this.oDD.release();
                    }
                }
            });
            this.oDD.prepareAsync();
            this.oDD.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        v("login_rtc", 0, "success");
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (oDA) {
            this.mBaiduRtcRoom.enableStatsToServer(true, "online");
        } else {
            this.mBaiduRtcRoom.f(true, false, "online");
        }
        if (this.mBaiduRtcRoom == null) {
            v("login_rtc_result", -2, "create rtcroom fail");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-2, "create rtcroom fail");
                return;
            }
            return;
        }
        this.mBaiduRtcRoom.a(new BaiduRtcRoom.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.4
            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onRoomEventUpdate(int i, long j, String str) {
                a.this.log("rtcroom,onRoomEventUpdate:" + i + ",data:" + j + ",ext:" + str);
                if (i != 200) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("event", i);
                        jSONObject.put("uid", j);
                        jSONObject.put("name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    a.this.aR("audio_room_debug", jSONObject.toString(), "onRoomEventUpdate");
                }
                if (i == 102) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", i, "loginroomfail:RTC_ROOM_EVENT_LOGIN_ERROR");
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_ERROR");
                    a.this.oDL = false;
                    if (a.this.canRetry()) {
                        a.this.t(5000L, true);
                        a.l(a.this);
                        return;
                    }
                    a.this.Mp(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_TIMEOUT");
                    a.this.oDL = false;
                    if (a.this.oDI != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                        } else {
                            a.this.Mp(3);
                        }
                    }
                } else if (i == 2003) {
                    a.this.v("rtc_fail", i, "room event error:RTC_STATE_STREAM_DOWN");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oDL = false;
                    if (a.this.oDI != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                        } else {
                            a.this.Mp(3);
                        }
                    }
                } else if (i == 117 || i == 118) {
                    a.this.v("rtc_rtmp_result", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL:" + str);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oDL = false;
                    if (a.this.canRetry()) {
                        a.this.t(5000L, true);
                    } else {
                        a.this.Mp(3);
                    }
                } else if (i == 116) {
                    a.this.v("rtc_rtmp_result", 0, "success:" + str);
                } else if (i == 100) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", 0, "loginroomsuccess");
                    if (a.this.oDN) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.oDL = false;
                        if (a.this.oDI == 2) {
                            a.this.Mp(2);
                        } else {
                            a.this.Mp(2);
                        }
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_CONNECTION_LOST");
                    a.this.oDL = false;
                    if (a.this.oDI != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                        } else {
                            a.this.Mp(3);
                        }
                    }
                }
            }

            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onPeerConnectStateUpdate(int i) {
                a.this.log("rtcroom,onPeerConnectStateUpdate:" + i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("event", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a.this.aR("audio_room_debug", jSONObject.toString(), "onPeerConnectStateUpdate");
                if (i == 10000) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oDL = false;
                    if ((!a.this.canRetry() || a.this.oDJ.get(Integer.valueOf(i)) != null) && ((Integer) a.this.oDJ.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.oDJ.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.Mp(3);
                            return;
                        }
                        return;
                    }
                    if (a.this.oDI == 1) {
                        a.this.v("rtc_publish_result", i, "onPeerConnectStateUpdate:RTC_ROOM_PEER_CONNECTION_ERROR");
                    }
                    a.this.oDJ.put(Integer.valueOf(i), 1);
                    a.this.t(5000L, true);
                    a.l(a.this);
                } else if (i == 2001) {
                    a.this.v("rtc_publish_result", 0, "success");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.oDD != null) {
                        a.this.oDD.stop();
                    }
                    a.this.oDL = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.oDI == 2) {
                        a.this.Mp(2);
                    } else {
                        a.this.Mp(2);
                    }
                } else if (i == 2002) {
                    a.this.v("rtc_fail", i, "room event error:RTC_STATE_SENDING_MEDIA_FAILED");
                    a.this.bf("ErrorRoomEvent:" + i, true);
                }
            }

            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onErrorInfoUpdate(int i) {
                a.this.log("rtcroom,errorCode:" + i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("event", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a.this.aR("audio_room_debug", jSONObject.toString(), "onErrorInfoUpdate");
                a.this.bf("ErrorRoomEventInfo:" + i, true);
                a.this.v("rtc_fail", i, "onErrorInfoUpdate");
                a.this.oDL = false;
                if (i == 436) {
                    a.this.v("login_rtc_result", i, "RTC_ROOM_USERID_ALREADY_EXIST_ERROR");
                }
                if (a.this.mBaiduRtcRoom != null) {
                    a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                    a.this.mBaiduRtcRoom.logoutRtcRoom();
                    a.this.mBaiduRtcRoom.destroy();
                }
                a.this.Mp(3);
                if (a.this.mRtcRoomListener != null) {
                    a.this.mRtcRoomListener.onError(i, "onErrorInfoUpdate");
                }
            }

            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
            }
        });
        this.mBaiduRtcRoom.a(new g.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.5
            @Override // com.baidu.rtc.g.d
            public void a(g gVar) {
                BaiduRtcRoom.c[] aew = a.this.mBaiduRtcRoom.aew();
                if (aew != null) {
                    for (BaiduRtcRoom.c cVar : aew) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            ab Yq = c.ecJ().Yq();
                            if (Yq != null) {
                                long unused = a.oDQ = Yq.aJh;
                            }
                            if (cVar.volumeLevel > a.oDQ) {
                            }
                        }
                    }
                }
            }
        });
        RtcParameterSettings aeQ = RtcParameterSettings.aeQ();
        aeQ.HasVideo = false;
        aeQ.HasAudio = true;
        aeQ.ConnectionTimeoutMs = 5000;
        aeQ.ReadTimeoutMs = 5000;
        aeQ.AutoPublish = this.mIsAutoPublish;
        aeQ.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(aeQ, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        ecx();
        String str = "loginRtcRoom,appid:" + this.mAppId + ",token:" + this.mToken + ",roomName:" + this.mRoomName + ",uid:" + this.mUid + ",userName:" + this.mUserName + ",autoPublish:" + this.mIsAutoPublish + ",autoSubScribe:" + this.mIsAutoSubScribe + ",reLogin:" + z;
        log(str);
        bf(str, true);
        if (z) {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, true);
        } else {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, this.mIsAutoPublish, this.mIsAutoSubScribe);
        }
        if (this.mIsAutoPublish) {
            v("rtc_start_publish", 0, "success");
        }
        if (!loginRtcRoomWithRoomName) {
            VW("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void yo() {
        aR("audio_room_debug", "", "leaveRoom");
        this.oDN = true;
        if (this.oDD != null) {
            this.oDD.stop();
            this.oDD.release();
        }
        this.oDL = false;
        Mp(4);
        if (this.oDM != null) {
            this.oDM = null;
        }
    }

    public void aAJ() {
        if (this.oDP) {
            aR("audio_room_debug", "", "pausePlayer");
        }
        this.oDP = false;
        if (this.oDD != null) {
            this.oDD.pause();
        }
    }

    public void cnE() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.oDO) {
                    if (a.this.oDD != null) {
                        a.this.oDD.release();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", a.this.mPlayUrl);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    a.this.aR("audio_room_debug", jSONObject.toString(), "restartPlayer");
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean ecv() {
        return this.oDP;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.oDD != null) {
            this.oDD.muteOrUnmuteAudio(z);
        }
    }

    public String ecw() {
        if (this.oDM != null) {
            String sb = this.oDM.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.oDG);
                sb2.append(",");
                if (this.oDD != null) {
                    sb2.append(this.oDD.isPlaying());
                } else {
                    sb2.append("false");
                }
                if (sb == null) {
                    return sb2.toString();
                }
                return sb + sb2.toString();
            }
            return sb;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j, final boolean z) {
        bf("reLoginRtcRoom:" + j + z, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("delayMs", j);
            jSONObject.put("isRetry", z);
            jSONObject.put("mIsConneting", this.oDL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "reLoginRtcRoom");
        if (!this.oDL) {
            this.oDL = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.oDN) {
                            a.this.oDL = true;
                            if (!z) {
                                a.this.Mp(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.oDN) {
                if (!z) {
                    Mp(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.oDL && (this.oDI == 1 || this.oDI == 2) && this.oDH < oDB && this.oDK && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void ecx() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.oDE)) {
                this.mBaiduRtcRoom.a(this.oDE, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.oDF)) {
                this.mBaiduRtcRoom.a(this.oDF, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp(int i) {
        bf("changeRtcStatus:" + i, true);
        this.oDI = i;
        this.oDH = 0;
        this.oDJ.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (oDA) {
            Log.i("AudioRoom", str);
        }
    }

    public void VW(String str) {
        if (this.oDM != null) {
            if (!oDA) {
                try {
                    if (this.oDM.length() > 1900) {
                        this.oDM.delete(0, this.oDM.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.oDM.append("#");
            this.oDM.append(System.currentTimeMillis());
            this.oDM.append(":");
            this.oDM.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.oDM != null) {
            if (!oDA) {
                try {
                    if (this.oDM.length() > 1900) {
                        this.oDM.delete(0, this.oDM.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            VW(str);
            if (z) {
                this.oDM.append(",common:");
                this.oDM.append(this.oDG);
                this.oDM.append(",");
                if (this.oDD != null) {
                    this.oDM.append(this.oDD.isPlaying());
                } else {
                    this.oDM.append("false");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = c.ecJ().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(DpStatConstants.KEY_USER_ID, this.mUid);
            jSONObject2.put("username", this.mUserName);
            jSONObject2.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject2);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_RTC_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, str).setContentExt(jSONObject));
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
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK, BdNetTypeUtil.isNetWorkAvailable());
            jSONObject.put("opertaionType", str3);
            jSONObject.put("thread", Thread.currentThread().getName());
            jSONObject.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject2.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_LIVE_DEBUG, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "audio_live_debug").setContentExt(jSONObject2));
    }
}
