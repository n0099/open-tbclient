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
    private static String oEc;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer oEd;
    private String oEe;
    private String oEf;
    private boolean oEg;
    private volatile int oEh;
    private volatile int oEi;
    private HashMap<Integer, Integer> oEj;
    private boolean oEk;
    private boolean oEl;
    private StringBuilder oEm;
    private volatile boolean oEn;
    private volatile boolean oEo;
    private volatile boolean oEp;
    public static boolean oEa = false;
    private static int oEb = 6;
    private static long oEq = 300;

    static /* synthetic */ int l(a aVar) {
        int i = aVar.oEh;
        aVar.oEh = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(oEc)) {
            oEc = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.oEi = 0;
        this.oEj = new HashMap<>();
        this.oEk = true;
        this.oEm = new StringBuilder();
        Wi("initaudioroom");
    }

    public void Wh(String str) {
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
        if (oEa) {
            Wi("enterLiveRoom:" + str + ",mstatus:" + this.oEi + ",misConnect:" + this.oEl);
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
        this.oEo = true;
        if (!z && !this.oEg && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2 && this.oEd != null) {
                this.oEd.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
                this.mRtcRoomListener.onEnterRoomResult(false);
            }
        } else {
            this.oEg = false;
            this.mPlayUrl = str;
            if (!i.MT().MU()) {
                log("playersdk do not init");
                Wi("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    this.mRtcRoomListener.onEnterRoomResult(false);
                    return;
                }
                return;
            }
            if (this.oEd != null) {
                this.oEd.stop();
                this.oEd.release();
            }
            this.oEd = new CyberPlayer();
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
            if (oEa) {
                Wi("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.oEd.setOption("opt-open-audio-delay", 0L);
            this.oEd.setOption("realtime-low-latency-threshold", j);
            this.oEd.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.oEd.setOption("start-on-prepared", 1L);
            this.oEd.setOption("max-analyze-duration", String.valueOf(j3));
            this.oEd.setOption("max-probe-size", "204800");
            this.oEd.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.oEd.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.oEd.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    if (a.this.oEo && a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onEnterRoomResult(false);
                    }
                    a.this.oEg = true;
                    a.this.oEp = false;
                    a.this.oEo = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.Wi("cyplayer:onerror:" + i + "," + i2);
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
            this.oEd.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.oEd.setSpeed(f);
                                } else {
                                    a.this.oEd.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        if (a.this.oEo && a.this.mRtcRoomListener != null) {
                            a.this.mRtcRoomListener.onEnterRoomResult(true);
                        }
                        a.this.oEp = true;
                        a.this.oEo = false;
                    }
                    return false;
                }
            });
            this.oEd.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.oEa) {
                        a.this.Wi(",cyplayer:onPrepared");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", a.this.mPlayUrl);
                        jSONObject2.put("mIsLeaveRoom", a.this.oEn);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    a.this.aR("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnPreparedListener");
                    if (a.this.oEn) {
                        a.this.oEd.stop();
                        a.this.oEd.release();
                    }
                }
            });
            this.oEd.prepareAsync();
            this.oEd.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        v("login_rtc", 0, "success");
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (oEa) {
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
                    a.this.oEl = false;
                    if (a.this.canRetry()) {
                        a.this.t(5000L, true);
                        a.l(a.this);
                        return;
                    }
                    a.this.Mq(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_TIMEOUT");
                    a.this.oEl = false;
                    if (a.this.oEi != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                        } else {
                            a.this.Mq(3);
                        }
                    }
                } else if (i == 2003) {
                    a.this.v("rtc_fail", i, "room event error:RTC_STATE_STREAM_DOWN");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oEl = false;
                    if (a.this.oEi != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                        } else {
                            a.this.Mq(3);
                        }
                    }
                } else if (i == 117 || i == 118) {
                    a.this.v("rtc_rtmp_result", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL:" + str);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oEl = false;
                    if (a.this.canRetry()) {
                        a.this.t(5000L, true);
                    } else {
                        a.this.Mq(3);
                    }
                } else if (i == 116) {
                    a.this.v("rtc_rtmp_result", 0, "success:" + str);
                } else if (i == 100) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", 0, "loginroomsuccess");
                    if (a.this.oEn) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.oEl = false;
                        if (a.this.oEi == 2) {
                            a.this.Mq(2);
                        } else {
                            a.this.Mq(2);
                        }
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_CONNECTION_LOST");
                    a.this.oEl = false;
                    if (a.this.oEi != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                        } else {
                            a.this.Mq(3);
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
                    a.this.oEl = false;
                    if ((!a.this.canRetry() || a.this.oEj.get(Integer.valueOf(i)) != null) && ((Integer) a.this.oEj.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.oEj.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.Mq(3);
                            return;
                        }
                        return;
                    }
                    if (a.this.oEi == 1) {
                        a.this.v("rtc_publish_result", i, "onPeerConnectStateUpdate:RTC_ROOM_PEER_CONNECTION_ERROR");
                    }
                    a.this.oEj.put(Integer.valueOf(i), 1);
                    a.this.t(5000L, true);
                    a.l(a.this);
                } else if (i == 2001) {
                    a.this.v("rtc_publish_result", 0, "success");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.oEd != null) {
                        a.this.oEd.stop();
                    }
                    a.this.oEl = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.oEi == 2) {
                        a.this.Mq(2);
                    } else {
                        a.this.Mq(2);
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
                a.this.oEl = false;
                if (i == 436) {
                    a.this.v("login_rtc_result", i, "RTC_ROOM_USERID_ALREADY_EXIST_ERROR");
                }
                if (a.this.mBaiduRtcRoom != null) {
                    a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                    a.this.mBaiduRtcRoom.logoutRtcRoom();
                    a.this.mBaiduRtcRoom.destroy();
                }
                a.this.Mq(3);
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
                            ab Yq = c.ecR().Yq();
                            if (Yq != null) {
                                long unused = a.oEq = Yq.aJh;
                            }
                            if (cVar.volumeLevel > a.oEq) {
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
        ecF();
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
            Wi("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void yo() {
        aR("audio_room_debug", "", "leaveRoom");
        this.oEn = true;
        if (this.oEd != null) {
            this.oEd.stop();
            this.oEd.release();
        }
        this.oEl = false;
        Mq(4);
        if (this.oEm != null) {
            this.oEm = null;
        }
    }

    public void aAJ() {
        if (this.oEp) {
            aR("audio_room_debug", "", "pausePlayer");
        }
        this.oEp = false;
        if (this.oEd != null) {
            this.oEd.pause();
        }
    }

    public void cnL() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.oEo) {
                    if (a.this.oEd != null) {
                        a.this.oEd.release();
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

    public boolean ecD() {
        return this.oEp;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.oEd != null) {
            this.oEd.muteOrUnmuteAudio(z);
        }
    }

    public String ecE() {
        if (this.oEm != null) {
            String sb = this.oEm.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.oEg);
                sb2.append(",");
                if (this.oEd != null) {
                    sb2.append(this.oEd.isPlaying());
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
            jSONObject.put("mIsConneting", this.oEl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aR("audio_room_debug", jSONObject.toString(), "reLoginRtcRoom");
        if (!this.oEl) {
            this.oEl = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.oEn) {
                            a.this.oEl = true;
                            if (!z) {
                                a.this.Mq(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.oEn) {
                if (!z) {
                    Mq(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.oEl && (this.oEi == 1 || this.oEi == 2) && this.oEh < oEb && this.oEk && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void ecF() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.oEe)) {
                this.mBaiduRtcRoom.a(this.oEe, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.oEf)) {
                this.mBaiduRtcRoom.a(this.oEf, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq(int i) {
        bf("changeRtcStatus:" + i, true);
        this.oEi = i;
        this.oEh = 0;
        this.oEj.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (oEa) {
            Log.i("AudioRoom", str);
        }
    }

    public void Wi(String str) {
        if (this.oEm != null) {
            if (!oEa) {
                try {
                    if (this.oEm.length() > 1900) {
                        this.oEm.delete(0, this.oEm.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.oEm.append("#");
            this.oEm.append(System.currentTimeMillis());
            this.oEm.append(":");
            this.oEm.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.oEm != null) {
            if (!oEa) {
                try {
                    if (this.oEm.length() > 1900) {
                        this.oEm.delete(0, this.oEm.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Wi(str);
            if (z) {
                this.oEm.append(",common:");
                this.oEm.append(this.oEg);
                this.oEm.append(",");
                if (this.oEd != null) {
                    this.oEm.append(this.oEd.isPlaying());
                } else {
                    this.oEm.append("false");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = c.ecR().Yq();
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
