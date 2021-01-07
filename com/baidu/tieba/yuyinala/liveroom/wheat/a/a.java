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
import com.baidu.live.data.ce;
import com.baidu.live.data.x;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbEnum;
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
    private static String oyw;
    private boolean mIsMute;
    private String mPlayUrl;
    private boolean oyA;
    private volatile int oyB;
    private volatile int oyC;
    private HashMap<Integer, Integer> oyD;
    private boolean oyE;
    private boolean oyF;
    private StringBuilder oyG;
    private volatile boolean oyH;
    private volatile boolean oyI;
    private volatile boolean oyJ;
    private CyberPlayer oyx;
    private String oyy;
    private String oyz;
    public static boolean oyu = false;
    private static int oyv = 6;
    private static long oyK = 300;

    static /* synthetic */ int l(a aVar) {
        int i = aVar.oyB;
        aVar.oyB = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(oyw)) {
            oyw = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.oyC = 0;
        this.oyD = new HashMap<>();
        this.oyE = true;
        this.oyG = new StringBuilder();
        Wg("initaudioroom");
    }

    public void We(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "enterLiveRoom");
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (oyu) {
            Wg("enterLiveRoom:" + str + ",mstatus:" + this.oyC + ",misConnect:" + this.oyF);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("forceCreatePlayer", z);
            jSONObject.put("isPreLoad", z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "enterLiveRoom");
        this.oyI = true;
        if (!z && !this.oyA && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2 && this.oyx != null) {
                this.oyx.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
                this.mRtcRoomListener.onEnterRoomResult(false);
            }
        } else {
            this.oyA = false;
            this.mPlayUrl = str;
            if (!i.Pq().Pr()) {
                log("playersdk do not init");
                Wg("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    this.mRtcRoomListener.onEnterRoomResult(false);
                    return;
                }
                return;
            }
            if (this.oyx != null) {
                this.oyx.stop();
                this.oyx.release();
            }
            this.oyx = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            ce ceVar = com.baidu.live.af.a.SE().bwi.aPq;
            if (ceVar != null) {
                j = ceVar.aSO;
                f = ceVar.aSP;
                j2 = ceVar.aSQ;
                j3 = ceVar.aSR * 1000;
            }
            log("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            if (oyu) {
                Wg("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.oyx.setOption("opt-open-audio-delay", 0L);
            this.oyx.setOption("realtime-low-latency-threshold", j);
            this.oyx.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.oyx.setOption("start-on-prepared", 1L);
            this.oyx.setOption("max-analyze-duration", String.valueOf(j3));
            this.oyx.setOption("max-probe-size", "204800");
            this.oyx.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.oyx.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.oyx.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    if (a.this.oyI && a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onEnterRoomResult(false);
                    }
                    a.this.oyA = true;
                    a.this.oyJ = false;
                    a.this.oyI = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.Wg("cyplayer:onerror:" + i + "," + i2);
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
                    a.this.aQ("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnErrorListener");
                    return false;
                }
            });
            this.oyx.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.oyx.setSpeed(f);
                                } else {
                                    a.this.oyx.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        if (a.this.oyI && a.this.mRtcRoomListener != null) {
                            a.this.mRtcRoomListener.onEnterRoomResult(true);
                        }
                        a.this.oyJ = true;
                        a.this.oyI = false;
                    }
                    return false;
                }
            });
            this.oyx.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.oyu) {
                        a.this.Wg(",cyplayer:onPrepared");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", a.this.mPlayUrl);
                        jSONObject2.put("mIsLeaveRoom", a.this.oyH);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    a.this.aQ("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnPreparedListener");
                    if (a.this.oyH) {
                        a.this.oyx.stop();
                        a.this.oyx.release();
                    }
                }
            });
            this.oyx.prepareAsync();
            this.oyx.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Wg("ownerEnterLiveRoom:mstatus:" + this.oyC + ",misConnect:" + this.oyF);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", j);
            jSONObject.put("roomName", str3);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str4);
            jSONObject.put("url", str5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "ownerEnterLiveRoom");
        We(str5);
        this.oyz = "";
        this.oyy = "";
        if (!this.oyF) {
            NB(1);
            this.oyF = true;
            loginRtcRoom(str3, j, str4, str, str2, false, false, false);
        }
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        if ((this.oyC == 1 || this.oyC == 2) && TextUtils.equals(str3, this.mRoomName) && j == this.mUid && this.mIsAutoPublish) {
            Wg("joinChat:mstatus:" + this.oyC + ",misConnect:" + this.oyF + "reloginreturn");
            return;
        }
        Wg("joinChat:mstatus:" + this.oyC + ",misConnect:" + this.oyF);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", j);
            jSONObject.put("roomName", str3);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "joinChat");
        this.oyz = str6;
        this.oyy = str5;
        NB(1);
        this.oyF = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean Wf(String str) {
        aQ("audio_room_debug", "", "quitChat");
        Wg("quitChat:" + str);
        if (this.oyx != null) {
            cqy();
        }
        this.oyF = false;
        this.mIsMute = false;
        NB(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        v("login_rtc", 0, "success");
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (oyu) {
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
                    a.this.aQ("audio_room_debug", jSONObject.toString(), "onRoomEventUpdate");
                }
                if (i == 102) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", i, "loginroomfail:RTC_ROOM_EVENT_LOGIN_ERROR");
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_ERROR");
                    a.this.oyF = false;
                    if (a.this.canRetry()) {
                        a.this.t(5000L, true);
                        a.l(a.this);
                        return;
                    }
                    a.this.NB(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_TIMEOUT");
                    a.this.oyF = false;
                    if (a.this.oyC != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                            return;
                        }
                        a.this.NB(3);
                    } else {
                        return;
                    }
                } else if (i == 2003) {
                    a.this.v("rtc_fail", i, "room event error:RTC_STATE_STREAM_DOWN");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oyF = false;
                    if (a.this.oyC != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                            return;
                        }
                        a.this.NB(3);
                    } else {
                        return;
                    }
                } else if (i == 117 || i == 118) {
                    a.this.v("rtc_rtmp_result", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL:" + str);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oyF = false;
                    if (a.this.canRetry()) {
                        a.this.t(5000L, true);
                        return;
                    }
                    a.this.NB(3);
                } else if (i == 116) {
                    a.this.v("rtc_rtmp_result", 0, "success:" + str);
                } else if (i == 100) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", 0, "loginroomsuccess");
                    if (a.this.oyH) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.oyF = false;
                        if (a.this.oyC == 2) {
                            a.this.NB(2);
                            return;
                        }
                        a.this.NB(2);
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_CONNECTION_LOST");
                    a.this.oyF = false;
                    if (a.this.oyC != 4) {
                        if (a.this.canRetry()) {
                            a.this.t(5000L, true);
                            return;
                        }
                        a.this.NB(3);
                    } else {
                        return;
                    }
                }
                if (a.this.mRtcRoomListener != null) {
                    a.this.mRtcRoomListener.onRoomEventUpdate(i, j, str);
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
                a.this.aQ("audio_room_debug", jSONObject.toString(), "onPeerConnectStateUpdate");
                if (i == 10000) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.oyF = false;
                    if ((!a.this.canRetry() || a.this.oyD.get(Integer.valueOf(i)) != null) && ((Integer) a.this.oyD.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.oyD.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.NB(3);
                        } else {
                            return;
                        }
                    } else {
                        if (a.this.oyC == 1) {
                            a.this.v("rtc_publish_result", i, "onPeerConnectStateUpdate:RTC_ROOM_PEER_CONNECTION_ERROR");
                        }
                        a.this.oyD.put(Integer.valueOf(i), 1);
                        a.this.t(5000L, true);
                        a.l(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.v("rtc_publish_result", 0, "success");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.oyx != null) {
                        a.this.oyx.stop();
                    }
                    a.this.oyF = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.oyC == 2) {
                        a.this.NB(2);
                        return;
                    }
                    a.this.NB(2);
                } else if (i == 2002) {
                    a.this.v("rtc_fail", i, "room event error:RTC_STATE_SENDING_MEDIA_FAILED");
                    a.this.bf("ErrorRoomEvent:" + i, true);
                    return;
                }
                if (a.this.mRtcRoomListener != null) {
                    a.this.mRtcRoomListener.onPeerConnectStateUpdate(i);
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
                a.this.aQ("audio_room_debug", jSONObject.toString(), "onErrorInfoUpdate");
                a.this.bf("ErrorRoomEventInfo:" + i, true);
                a.this.v("rtc_fail", i, "onErrorInfoUpdate");
                a.this.oyF = false;
                if (i == 436) {
                    a.this.v("login_rtc_result", i, "RTC_ROOM_USERID_ALREADY_EXIST_ERROR");
                }
                if (a.this.mBaiduRtcRoom != null) {
                    a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                    a.this.mBaiduRtcRoom.logoutRtcRoom();
                    a.this.mBaiduRtcRoom.destroy();
                }
                a.this.NB(3);
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
            public void a(com.baidu.rtc.g gVar) {
                BaiduRtcRoom.c[] ahZ = a.this.mBaiduRtcRoom.ahZ();
                if (ahZ != null) {
                    for (BaiduRtcRoom.c cVar : ahZ) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            x aat = c.eep().aat();
                            if (aat != null) {
                                long unused = a.oyK = aat.aLz;
                            }
                            if (cVar.volumeLevel > a.oyK) {
                                if (a.this.mRtcRoomListener != null) {
                                    a.this.mRtcRoomListener.onStartSpeek();
                                }
                            } else if (a.this.mRtcRoomListener != null) {
                                a.this.mRtcRoomListener.onStopSpeak();
                            }
                        }
                    }
                }
            }
        });
        RtcParameterSettings air = RtcParameterSettings.air();
        air.HasVideo = false;
        air.HasAudio = true;
        air.ConnectionTimeoutMs = 5000;
        air.ReadTimeoutMs = 5000;
        air.AutoPublish = this.mIsAutoPublish;
        air.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(air, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        eef();
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
            Wg("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void zI(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "muteMic");
        if (oyu) {
            Wg("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void s(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "muteUser");
        if (oyu) {
            Wg("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.e(j, z);
        }
    }

    public void aF(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "kickOffUser");
        if (oyu) {
            Wg("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bK(j);
        }
    }

    public void ede() {
        aQ("audio_room_debug", "", "closeLiveRoom");
        if (oyu) {
            Wg("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void Cw() {
        aQ("audio_room_debug", "", "leaveRoom");
        this.oyH = true;
        if (this.oyx != null) {
            this.oyx.stop();
            this.oyx.release();
        }
        this.oyF = false;
        NB(4);
        logoutRoom();
        if (this.oyG != null) {
            this.oyG = null;
        }
    }

    public void aEf() {
        if (this.oyJ) {
            aQ("audio_room_debug", "", "pausePlayer");
        }
        this.oyJ = false;
        if (this.oyx != null) {
            this.oyx.pause();
        }
    }

    public void cqy() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.oyI) {
                    if (a.this.oyx != null) {
                        a.this.oyx.release();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", a.this.mPlayUrl);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    a.this.aQ("audio_room_debug", jSONObject.toString(), "restartPlayer");
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean hI(long j) {
        if (this.mBaiduRtcRoom != null) {
            BaiduRtcRoom.d[] aia = this.mBaiduRtcRoom.aia();
            StringBuilder sb = new StringBuilder();
            if (aia != null && aia.length > 0) {
                for (BaiduRtcRoom.d dVar : aia) {
                    sb.append(dVar.userId + "," + dVar.userName + "#");
                    if (dVar != null && dVar.userId == j) {
                        Log.i("AudioRoomManager", "finduser,roomusers:" + sb.toString());
                        return true;
                    }
                }
            }
            log("nofound,roomusers:" + sb.toString());
            return false;
        }
        return false;
    }

    public int eea() {
        return this.oyC;
    }

    public void eeb() {
        hJ(1000L);
    }

    public void hJ(long j) {
        t(j, false);
    }

    public boolean eec() {
        return this.oyJ;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.oyx != null) {
            this.oyx.muteOrUnmuteAudio(z);
        }
    }

    public void zJ(boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.er(z);
        }
    }

    public boolean eed() {
        return this.mIsMute;
    }

    public String eee() {
        if (this.oyG != null) {
            String sb = this.oyG.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.oyA);
                sb2.append(",");
                if (this.oyx != null) {
                    sb2.append(this.oyx.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(",");
                sb2.append(this.oyB);
                sb2.append(",");
                sb2.append(this.oyC);
                sb2.append(",");
                sb2.append(this.mIsMute);
                sb2.append(",");
                sb2.append(this.oyE);
                sb2.append(",");
                sb2.append(this.oyF);
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
            jSONObject.put("mIsConneting", this.oyF);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aQ("audio_room_debug", jSONObject.toString(), "reLoginRtcRoom");
        if (!this.oyF) {
            this.oyF = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.oyH) {
                            a.this.oyF = true;
                            if (!z) {
                                a.this.NB(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.oyH) {
                if (!z) {
                    NB(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.oyF && (this.oyC == 1 || this.oyC == 2) && this.oyB < oyv && this.oyE && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void eef() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.oyy)) {
                this.mBaiduRtcRoom.a(this.oyy, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.oyz)) {
                this.mBaiduRtcRoom.a(this.oyz, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NB(int i) {
        bf("changeRtcStatus:" + i, true);
        this.oyC = i;
        this.oyB = 0;
        this.oyD.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (oyu) {
            Log.i("AudioRoom", str);
        }
    }

    public void Wg(String str) {
        if (this.oyG != null) {
            if (!oyu) {
                try {
                    if (this.oyG.length() > 1900) {
                        this.oyG.delete(0, this.oyG.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.oyG.append("#");
            this.oyG.append(System.currentTimeMillis());
            this.oyG.append(":");
            this.oyG.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.oyG != null) {
            if (!oyu) {
                try {
                    if (this.oyG.length() > 1900) {
                        this.oyG.delete(0, this.oyG.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Wg(str);
            if (z) {
                this.oyG.append(",common:");
                this.oyG.append(this.oyA);
                this.oyG.append(",");
                if (this.oyx != null) {
                    this.oyG.append(this.oyx.isPlaying());
                } else {
                    this.oyG.append("false");
                }
                this.oyG.append(",");
                this.oyG.append(this.oyB);
                this.oyG.append(",");
                this.oyG.append(this.oyC);
                this.oyG.append(",");
                this.oyG.append(this.mIsMute);
                this.oyG.append(",");
                this.oyG.append(this.oyE);
                this.oyG.append(",");
                this.oyG.append(this.oyF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            x aat = c.eep().aat();
            if (aat != null && aat.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
            }
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", this.mAppId);
            jSONObject2.put("token", this.mToken);
            jSONObject2.put("autopublish", this.mIsAutoPublish);
            jSONObject2.put("roomname", this.mRoomName);
            jSONObject2.put(DpStatConstants.KEY_USER_ID, this.mUid);
            jSONObject2.put("username", this.mUserName);
            jSONObject2.put("isrelogin", this.oyB);
            jSONObject2.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject2);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_RTC_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    public void aQ(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            x aat = c.eep().aat();
            if (aat != null && aat.aLl != null) {
                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
            }
            jSONObject2.put(AlaRecorderLog.KEY_RES_TYPE, str);
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str2);
            }
            jSONObject.put("opertaionType", str3);
            jSONObject.put("thread", Thread.currentThread().getName());
            jSONObject.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject2.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_LIVE_DEBUG, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "audio_live_debug").setContentExt(jSONObject2));
    }

    public void sendMessageToUser(String str, long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
        }
    }
}
