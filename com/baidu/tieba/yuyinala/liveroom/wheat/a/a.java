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
/* loaded from: classes10.dex */
public class a extends BaseRtcRoom {
    private static String otQ;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer otR;
    private String otS;
    private String otT;
    private boolean otU;
    private volatile int otV;
    private volatile int otW;
    private HashMap<Integer, Integer> otX;
    private boolean otY;
    private boolean otZ;
    private StringBuilder oua;
    private volatile boolean oub;
    private volatile boolean ouc;
    private volatile boolean oud;
    public static boolean otO = false;
    private static int otP = 6;
    private static long oue = 300;

    static /* synthetic */ int l(a aVar) {
        int i = aVar.otV;
        aVar.otV = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(otQ)) {
            otQ = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.otW = 0;
        this.otX = new HashMap<>();
        this.otY = true;
        this.oua = new StringBuilder();
        UY("initaudioroom");
    }

    public void UW(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "enterLiveRoom");
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (otO) {
            UY("enterLiveRoom:" + str + ",mstatus:" + this.otW + ",misConnect:" + this.otZ);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("forceCreatePlayer", z);
            jSONObject.put("isPreLoad", z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "enterLiveRoom");
        this.ouc = true;
        if (!z && !this.otU && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2 && this.otR != null) {
                this.otR.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
                this.mRtcRoomListener.onEnterRoomResult(false);
            }
        } else {
            this.otU = false;
            this.mPlayUrl = str;
            if (!i.Lv().Lw()) {
                log("playersdk do not init");
                UY("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    this.mRtcRoomListener.onEnterRoomResult(false);
                    return;
                }
                return;
            }
            if (this.otR != null) {
                this.otR.stop();
                this.otR.release();
            }
            this.otR = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            ce ceVar = com.baidu.live.af.a.OJ().bru.aKD;
            if (ceVar != null) {
                j = ceVar.aOb;
                f = ceVar.aOc;
                j2 = ceVar.aOd;
                j3 = ceVar.aOe * 1000;
            }
            log("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            if (otO) {
                UY("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.otR.setOption("opt-open-audio-delay", 0L);
            this.otR.setOption("realtime-low-latency-threshold", j);
            this.otR.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.otR.setOption("start-on-prepared", 1L);
            this.otR.setOption("max-analyze-duration", String.valueOf(j3));
            this.otR.setOption("max-probe-size", "204800");
            this.otR.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.otR.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.otR.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    if (a.this.ouc && a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onEnterRoomResult(false);
                    }
                    a.this.otU = true;
                    a.this.oud = false;
                    a.this.ouc = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.UY("cyplayer:onerror:" + i + "," + i2);
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
                    a.this.aP("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnErrorListener");
                    return false;
                }
            });
            this.otR.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.otR.setSpeed(f);
                                } else {
                                    a.this.otR.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        if (a.this.ouc && a.this.mRtcRoomListener != null) {
                            a.this.mRtcRoomListener.onEnterRoomResult(true);
                        }
                        a.this.oud = true;
                        a.this.ouc = false;
                    }
                    return false;
                }
            });
            this.otR.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.otO) {
                        a.this.UY(",cyplayer:onPrepared");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", a.this.mPlayUrl);
                        jSONObject2.put("mIsLeaveRoom", a.this.oub);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    a.this.aP("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnPreparedListener");
                    if (a.this.oub) {
                        a.this.otR.stop();
                        a.this.otR.release();
                    }
                }
            });
            this.otR.prepareAsync();
            this.otR.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        UY("ownerEnterLiveRoom:mstatus:" + this.otW + ",misConnect:" + this.otZ);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", j);
            jSONObject.put("roomName", str3);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str4);
            jSONObject.put("url", str5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "ownerEnterLiveRoom");
        UW(str5);
        this.otT = "";
        this.otS = "";
        if (!this.otZ) {
            LU(1);
            this.otZ = true;
            loginRtcRoom(str3, j, str4, str, str2, false, false, false);
        }
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        if ((this.otW == 1 || this.otW == 2) && TextUtils.equals(str3, this.mRoomName) && j == this.mUid && this.mIsAutoPublish) {
            UY("joinChat:mstatus:" + this.otW + ",misConnect:" + this.otZ + "reloginreturn");
            return;
        }
        UY("joinChat:mstatus:" + this.otW + ",misConnect:" + this.otZ);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", j);
            jSONObject.put("roomName", str3);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "joinChat");
        this.otT = str6;
        this.otS = str5;
        LU(1);
        this.otZ = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean UX(String str) {
        aP("audio_room_debug", "", "quitChat");
        UY("quitChat:" + str);
        if (this.otR != null) {
            cmG();
        }
        this.otZ = false;
        this.mIsMute = false;
        LU(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        v("login_rtc", 0, "success");
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (otO) {
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
                    a.this.aP("audio_room_debug", jSONObject.toString(), "onRoomEventUpdate");
                }
                if (i == 102) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", i, "loginroomfail:RTC_ROOM_EVENT_LOGIN_ERROR");
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_ERROR");
                    a.this.otZ = false;
                    if (a.this.canRetry()) {
                        a.this.u(5000L, true);
                        a.l(a.this);
                        return;
                    }
                    a.this.LU(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_TIMEOUT");
                    a.this.otZ = false;
                    if (a.this.otW != 4) {
                        if (a.this.canRetry()) {
                            a.this.u(5000L, true);
                            return;
                        }
                        a.this.LU(3);
                    } else {
                        return;
                    }
                } else if (i == 2003) {
                    a.this.v("rtc_fail", i, "room event error:RTC_STATE_STREAM_DOWN");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.otZ = false;
                    if (a.this.otW != 4) {
                        if (a.this.canRetry()) {
                            a.this.u(5000L, true);
                            return;
                        }
                        a.this.LU(3);
                    } else {
                        return;
                    }
                } else if (i == 117 || i == 118) {
                    a.this.v("rtc_rtmp_result", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL:" + str);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.otZ = false;
                    if (a.this.canRetry()) {
                        a.this.u(5000L, true);
                        return;
                    }
                    a.this.LU(3);
                } else if (i == 116) {
                    a.this.v("rtc_rtmp_result", 0, "success:" + str);
                } else if (i == 100) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("login_rtc_result", 0, "loginroomsuccess");
                    if (a.this.oub) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.otZ = false;
                        if (a.this.otW == 2) {
                            a.this.LU(2);
                            return;
                        }
                        a.this.LU(2);
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_CONNECTION_LOST");
                    a.this.otZ = false;
                    if (a.this.otW != 4) {
                        if (a.this.canRetry()) {
                            a.this.u(5000L, true);
                            return;
                        }
                        a.this.LU(3);
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
                a.this.aP("audio_room_debug", jSONObject.toString(), "onPeerConnectStateUpdate");
                if (i == 10000) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.otZ = false;
                    if ((!a.this.canRetry() || a.this.otX.get(Integer.valueOf(i)) != null) && ((Integer) a.this.otX.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.otX.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.LU(3);
                        } else {
                            return;
                        }
                    } else {
                        if (a.this.otW == 1) {
                            a.this.v("rtc_publish_result", i, "onPeerConnectStateUpdate:RTC_ROOM_PEER_CONNECTION_ERROR");
                        }
                        a.this.otX.put(Integer.valueOf(i), 1);
                        a.this.u(5000L, true);
                        a.l(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.v("rtc_publish_result", 0, "success");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.otR != null) {
                        a.this.otR.stop();
                    }
                    a.this.otZ = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.otW == 2) {
                        a.this.LU(2);
                        return;
                    }
                    a.this.LU(2);
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
                a.this.aP("audio_room_debug", jSONObject.toString(), "onErrorInfoUpdate");
                a.this.bf("ErrorRoomEventInfo:" + i, true);
                a.this.v("rtc_fail", i, "onErrorInfoUpdate");
                a.this.otZ = false;
                if (i == 436) {
                    a.this.v("login_rtc_result", i, "RTC_ROOM_USERID_ALREADY_EXIST_ERROR");
                }
                if (a.this.mBaiduRtcRoom != null) {
                    a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                    a.this.mBaiduRtcRoom.logoutRtcRoom();
                    a.this.mBaiduRtcRoom.destroy();
                }
                a.this.LU(3);
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
                BaiduRtcRoom.c[] aef = a.this.mBaiduRtcRoom.aef();
                if (aef != null) {
                    for (BaiduRtcRoom.c cVar : aef) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            x WA = c.eax().WA();
                            if (WA != null) {
                                long unused = a.oue = WA.aGM;
                            }
                            if (cVar.volumeLevel > a.oue) {
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
        RtcParameterSettings aex = RtcParameterSettings.aex();
        aex.HasVideo = false;
        aex.HasAudio = true;
        aex.ConnectionTimeoutMs = 5000;
        aex.ReadTimeoutMs = 5000;
        aex.AutoPublish = this.mIsAutoPublish;
        aex.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(aex, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        ean();
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
            UY("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void zE(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "muteMic");
        if (otO) {
            UY("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void t(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMute", z);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "muteUser");
        if (otO) {
            UY("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.f(j, z);
        }
    }

    public void aF(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "kickOffUser");
        if (otO) {
            UY("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bK(j);
        }
    }

    public void dZm() {
        aP("audio_room_debug", "", "closeLiveRoom");
        if (otO) {
            UY("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void yB() {
        aP("audio_room_debug", "", "leaveRoom");
        this.oub = true;
        if (this.otR != null) {
            this.otR.stop();
            this.otR.release();
        }
        this.otZ = false;
        LU(4);
        logoutRoom();
        if (this.oua != null) {
            this.oua = null;
        }
    }

    public void aAl() {
        if (this.oud) {
            aP("audio_room_debug", "", "pausePlayer");
        }
        this.oud = false;
        if (this.otR != null) {
            this.otR.pause();
        }
    }

    public void cmG() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ouc) {
                    if (a.this.otR != null) {
                        a.this.otR.release();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", a.this.mPlayUrl);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    a.this.aP("audio_room_debug", jSONObject.toString(), "restartPlayer");
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean hI(long j) {
        if (this.mBaiduRtcRoom != null) {
            BaiduRtcRoom.d[] aeg = this.mBaiduRtcRoom.aeg();
            StringBuilder sb = new StringBuilder();
            if (aeg != null && aeg.length > 0) {
                for (BaiduRtcRoom.d dVar : aeg) {
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

    public int eai() {
        return this.otW;
    }

    public void eaj() {
        hJ(1000L);
    }

    public void hJ(long j) {
        u(j, false);
    }

    public boolean eak() {
        return this.oud;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.otR != null) {
            this.otR.muteOrUnmuteAudio(z);
        }
    }

    public void zF(boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.en(z);
        }
    }

    public boolean eal() {
        return this.mIsMute;
    }

    public String eam() {
        if (this.oua != null) {
            String sb = this.oua.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.otU);
                sb2.append(",");
                if (this.otR != null) {
                    sb2.append(this.otR.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(",");
                sb2.append(this.otV);
                sb2.append(",");
                sb2.append(this.otW);
                sb2.append(",");
                sb2.append(this.mIsMute);
                sb2.append(",");
                sb2.append(this.otY);
                sb2.append(",");
                sb2.append(this.otZ);
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
    public void u(long j, final boolean z) {
        bf("reLoginRtcRoom:" + j + z, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("delayMs", j);
            jSONObject.put("isRetry", z);
            jSONObject.put("mIsConneting", this.otZ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "reLoginRtcRoom");
        if (!this.otZ) {
            this.otZ = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.oub) {
                            a.this.otZ = true;
                            if (!z) {
                                a.this.LU(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.oub) {
                if (!z) {
                    LU(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.otZ && (this.otW == 1 || this.otW == 2) && this.otV < otP && this.otY && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void ean() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.otS)) {
                this.mBaiduRtcRoom.a(this.otS, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.otT)) {
                this.mBaiduRtcRoom.a(this.otT, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LU(int i) {
        bf("changeRtcStatus:" + i, true);
        this.otW = i;
        this.otV = 0;
        this.otX.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (otO) {
            Log.i("AudioRoom", str);
        }
    }

    public void UY(String str) {
        if (this.oua != null) {
            if (!otO) {
                try {
                    if (this.oua.length() > 1900) {
                        this.oua.delete(0, this.oua.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.oua.append("#");
            this.oua.append(System.currentTimeMillis());
            this.oua.append(":");
            this.oua.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.oua != null) {
            if (!otO) {
                try {
                    if (this.oua.length() > 1900) {
                        this.oua.delete(0, this.oua.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            UY(str);
            if (z) {
                this.oua.append(",common:");
                this.oua.append(this.otU);
                this.oua.append(",");
                if (this.otR != null) {
                    this.oua.append(this.otR.isPlaying());
                } else {
                    this.oua.append("false");
                }
                this.oua.append(",");
                this.oua.append(this.otV);
                this.oua.append(",");
                this.oua.append(this.otW);
                this.oua.append(",");
                this.oua.append(this.mIsMute);
                this.oua.append(",");
                this.oua.append(this.otY);
                this.oua.append(",");
                this.oua.append(this.otZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            x WA = c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
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
            jSONObject2.put("isrelogin", this.otV);
            jSONObject2.put("time", StringHelper.getCurrentTimeZoneSecond() + "," + System.currentTimeMillis());
            jSONObject.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject2);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_RTC_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_RTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    public void aP(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            x WA = c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
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
