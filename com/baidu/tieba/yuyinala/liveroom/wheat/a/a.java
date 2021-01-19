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
    private static String otR;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer otS;
    private String otT;
    private String otU;
    private boolean otV;
    private volatile int otW;
    private volatile int otX;
    private HashMap<Integer, Integer> otY;
    private boolean otZ;
    private boolean oua;
    private StringBuilder oub;
    private volatile boolean ouc;
    private volatile boolean oud;
    private volatile boolean oue;
    public static boolean otP = false;
    private static int otQ = 6;
    private static long ouf = 300;

    static /* synthetic */ int l(a aVar) {
        int i = aVar.otW;
        aVar.otW = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(otR)) {
            otR = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.otX = 0;
        this.otY = new HashMap<>();
        this.otZ = true;
        this.oub = new StringBuilder();
        UZ("initaudioroom");
    }

    public void UX(String str) {
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
        if (otP) {
            UZ("enterLiveRoom:" + str + ",mstatus:" + this.otX + ",misConnect:" + this.oua);
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
        this.oud = true;
        if (!z && !this.otV && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2 && this.otS != null) {
                this.otS.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
                this.mRtcRoomListener.onEnterRoomResult(false);
            }
        } else {
            this.otV = false;
            this.mPlayUrl = str;
            if (!i.Lv().Lw()) {
                log("playersdk do not init");
                UZ("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    this.mRtcRoomListener.onEnterRoomResult(false);
                    return;
                }
                return;
            }
            if (this.otS != null) {
                this.otS.stop();
                this.otS.release();
            }
            this.otS = new CyberPlayer();
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
            if (otP) {
                UZ("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.otS.setOption("opt-open-audio-delay", 0L);
            this.otS.setOption("realtime-low-latency-threshold", j);
            this.otS.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.otS.setOption("start-on-prepared", 1L);
            this.otS.setOption("max-analyze-duration", String.valueOf(j3));
            this.otS.setOption("max-probe-size", "204800");
            this.otS.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.otS.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.otS.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    if (a.this.oud && a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onEnterRoomResult(false);
                    }
                    a.this.otV = true;
                    a.this.oue = false;
                    a.this.oud = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.UZ("cyplayer:onerror:" + i + "," + i2);
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
            this.otS.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.otS.setSpeed(f);
                                } else {
                                    a.this.otS.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        if (a.this.oud && a.this.mRtcRoomListener != null) {
                            a.this.mRtcRoomListener.onEnterRoomResult(true);
                        }
                        a.this.oue = true;
                        a.this.oud = false;
                    }
                    return false;
                }
            });
            this.otS.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.otP) {
                        a.this.UZ(",cyplayer:onPrepared");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", a.this.mPlayUrl);
                        jSONObject2.put("mIsLeaveRoom", a.this.ouc);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    a.this.aP("audio_room_debug", jSONObject2.toString(), "CyberPlayerManager.OnPreparedListener");
                    if (a.this.ouc) {
                        a.this.otS.stop();
                        a.this.otS.release();
                    }
                }
            });
            this.otS.prepareAsync();
            this.otS.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        UZ("ownerEnterLiveRoom:mstatus:" + this.otX + ",misConnect:" + this.oua);
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
        UX(str5);
        this.otU = "";
        this.otT = "";
        if (!this.oua) {
            LU(1);
            this.oua = true;
            loginRtcRoom(str3, j, str4, str, str2, false, false, false);
        }
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        if ((this.otX == 1 || this.otX == 2) && TextUtils.equals(str3, this.mRoomName) && j == this.mUid && this.mIsAutoPublish) {
            UZ("joinChat:mstatus:" + this.otX + ",misConnect:" + this.oua + "reloginreturn");
            return;
        }
        UZ("joinChat:mstatus:" + this.otX + ",misConnect:" + this.oua);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", j);
            jSONObject.put("roomName", str3);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "joinChat");
        this.otU = str6;
        this.otT = str5;
        LU(1);
        this.oua = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean UY(String str) {
        aP("audio_room_debug", "", "quitChat");
        UZ("quitChat:" + str);
        if (this.otS != null) {
            cmG();
        }
        this.oua = false;
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
        if (otP) {
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
                    a.this.oua = false;
                    if (a.this.canRetry()) {
                        a.this.u(5000L, true);
                        a.l(a.this);
                        return;
                    }
                    a.this.LU(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_LOGIN_TIMEOUT");
                    a.this.oua = false;
                    if (a.this.otX != 4) {
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
                    a.this.oua = false;
                    if (a.this.otX != 4) {
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
                    a.this.oua = false;
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
                    if (a.this.ouc) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.oua = false;
                        if (a.this.otX == 2) {
                            a.this.LU(2);
                            return;
                        }
                        a.this.LU(2);
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.v("rtc_fail", i, "room event error:RTC_ROOM_EVENT_CONNECTION_LOST");
                    a.this.oua = false;
                    if (a.this.otX != 4) {
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
                    a.this.oua = false;
                    if ((!a.this.canRetry() || a.this.otY.get(Integer.valueOf(i)) != null) && ((Integer) a.this.otY.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.otY.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.LU(3);
                        } else {
                            return;
                        }
                    } else {
                        if (a.this.otX == 1) {
                            a.this.v("rtc_publish_result", i, "onPeerConnectStateUpdate:RTC_ROOM_PEER_CONNECTION_ERROR");
                        }
                        a.this.otY.put(Integer.valueOf(i), 1);
                        a.this.u(5000L, true);
                        a.l(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.v("rtc_publish_result", 0, "success");
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.otS != null) {
                        a.this.otS.stop();
                    }
                    a.this.oua = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.otX == 2) {
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
                a.this.oua = false;
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
                                long unused = a.ouf = WA.aGM;
                            }
                            if (cVar.volumeLevel > a.ouf) {
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
            UZ("firstloginfailed");
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
        if (otP) {
            UZ("muteMic:" + z);
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
        if (otP) {
            UZ("muteUser:" + j + z);
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
        if (otP) {
            UZ("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bK(j);
        }
    }

    public void dZm() {
        aP("audio_room_debug", "", "closeLiveRoom");
        if (otP) {
            UZ("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void yB() {
        aP("audio_room_debug", "", "leaveRoom");
        this.ouc = true;
        if (this.otS != null) {
            this.otS.stop();
            this.otS.release();
        }
        this.oua = false;
        LU(4);
        logoutRoom();
        if (this.oub != null) {
            this.oub = null;
        }
    }

    public void aAl() {
        if (this.oue) {
            aP("audio_room_debug", "", "pausePlayer");
        }
        this.oue = false;
        if (this.otS != null) {
            this.otS.pause();
        }
    }

    public void cmG() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.oud) {
                    if (a.this.otS != null) {
                        a.this.otS.release();
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
        return this.otX;
    }

    public void eaj() {
        hJ(1000L);
    }

    public void hJ(long j) {
        u(j, false);
    }

    public boolean eak() {
        return this.oue;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.otS != null) {
            this.otS.muteOrUnmuteAudio(z);
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
        if (this.oub != null) {
            String sb = this.oub.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.otV);
                sb2.append(",");
                if (this.otS != null) {
                    sb2.append(this.otS.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(",");
                sb2.append(this.otW);
                sb2.append(",");
                sb2.append(this.otX);
                sb2.append(",");
                sb2.append(this.mIsMute);
                sb2.append(",");
                sb2.append(this.otZ);
                sb2.append(",");
                sb2.append(this.oua);
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
            jSONObject.put("mIsConneting", this.oua);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aP("audio_room_debug", jSONObject.toString(), "reLoginRtcRoom");
        if (!this.oua) {
            this.oua = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.ouc) {
                            a.this.oua = true;
                            if (!z) {
                                a.this.LU(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.ouc) {
                if (!z) {
                    LU(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.oua && (this.otX == 1 || this.otX == 2) && this.otW < otQ && this.otZ && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void ean() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.otT)) {
                this.mBaiduRtcRoom.a(this.otT, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.otU)) {
                this.mBaiduRtcRoom.a(this.otU, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LU(int i) {
        bf("changeRtcStatus:" + i, true);
        this.otX = i;
        this.otW = 0;
        this.otY.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (otP) {
            Log.i("AudioRoom", str);
        }
    }

    public void UZ(String str) {
        if (this.oub != null) {
            if (!otP) {
                try {
                    if (this.oub.length() > 1900) {
                        this.oub.delete(0, this.oub.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.oub.append("#");
            this.oub.append(System.currentTimeMillis());
            this.oub.append(":");
            this.oub.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.oub != null) {
            if (!otP) {
                try {
                    if (this.oub.length() > 1900) {
                        this.oub.delete(0, this.oub.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            UZ(str);
            if (z) {
                this.oub.append(",common:");
                this.oub.append(this.otV);
                this.oub.append(",");
                if (this.otS != null) {
                    this.oub.append(this.otS.isPlaying());
                } else {
                    this.oub.append("false");
                }
                this.oub.append(",");
                this.oub.append(this.otW);
                this.oub.append(",");
                this.oub.append(this.otX);
                this.oub.append(",");
                this.oub.append(this.mIsMute);
                this.oub.append(",");
                this.oub.append(this.otZ);
                this.oub.append(",");
                this.oub.append(this.oua);
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
            jSONObject2.put("isrelogin", this.otW);
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
