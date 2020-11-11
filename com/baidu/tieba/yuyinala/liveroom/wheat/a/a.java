package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.rtc.BaseRtcRoom;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.bz;
import com.baidu.live.data.w;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.g;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BaseRtcRoom {
    private static String obq;
    private boolean mIsMute;
    private String mPlayUrl;
    private StringBuilder obA;
    private volatile boolean obB;
    private volatile boolean obC;
    private volatile boolean obD;
    private CyberPlayer obr;
    private String obs;
    private String obt;
    private boolean obu;
    private volatile int obv;
    private volatile int obw;
    private HashMap<Integer, Integer> obx;
    private boolean oby;
    private boolean obz;
    public static boolean obo = false;
    private static int obp = 6;
    private static long obE = 300;

    static /* synthetic */ int f(a aVar) {
        int i = aVar.obv;
        aVar.obv = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(obq)) {
            obq = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.obw = 0;
        this.obx = new HashMap<>();
        this.oby = true;
        this.obA = new StringBuilder();
        Vx("initaudioroom");
    }

    public void Vw(String str) {
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (obo) {
            Vx("enterLiveRoom:" + str + ",mstatus:" + this.obw + ",misConnect:" + this.obz);
        }
        this.obC = true;
        if (!z && !this.obu && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2) {
                this.obr.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
            }
        } else {
            this.obu = false;
            this.mPlayUrl = str;
            if (!i.NS().NT()) {
                log("playersdk do not init");
                Vx("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    return;
                }
                return;
            }
            this.obr = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            bz bzVar = com.baidu.live.aa.a.PQ().bod.aNy;
            if (bzVar != null) {
                j = bzVar.aQC;
                f = bzVar.aQD;
                j2 = bzVar.aQE;
                j3 = bzVar.aQF * 1000;
            }
            log("cyplayer:cloudconfig:" + j + Constants.ACCEPT_TIME_SEPARATOR_SP + f + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + j3);
            if (obo) {
                Vx("cyplayer:cloudconfig:" + j + Constants.ACCEPT_TIME_SEPARATOR_SP + f + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + j3);
            }
            this.obr.setOption("opt-open-audio-delay", 0L);
            this.obr.setOption("realtime-low-latency-threshold", j);
            this.obr.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.obr.setOption("start-on-prepared", 1L);
            this.obr.setOption("max-analyze-duration", String.valueOf(j3));
            this.obr.setOption("max-probe-size", "204800");
            this.obr.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.obr.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.obr.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    a.this.obu = true;
                    a.this.obD = false;
                    a.this.obC = false;
                    a.this.log("cyplayer:onerror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    a.this.Vx("cyplayer:onerror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(-4, "playererror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    }
                    return false;
                }
            });
            this.obr.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.obr.setSpeed(f);
                                } else {
                                    a.this.obr.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        a.this.obD = true;
                        a.this.obC = false;
                    }
                    return false;
                }
            });
            this.obr.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.obo) {
                        a.this.Vx(",cyplayer:onPrepared");
                    }
                    if (a.this.obB) {
                        a.this.obr.stop();
                        a.this.obr.release();
                    }
                }
            });
            this.obr.prepareAsync();
            this.obr.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Vx("ownerEnterLiveRoom:mstatus:" + this.obw + ",misConnect:" + this.obz);
        Vw(str5);
        this.obt = "";
        this.obs = "";
        Mp(1);
        this.obz = true;
        loginRtcRoom(str3, j, str4, str, str2, false, false, false);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        Vx("joinChat:mstatus:" + this.obw + ",misConnect:" + this.obz);
        this.obt = str6;
        this.obs = str5;
        Mp(1);
        this.obz = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean dYv() {
        Vx("quitChat");
        if (this.obr != null) {
            ckq();
        }
        this.obz = false;
        this.mIsMute = false;
        Mp(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (obo) {
            this.mBaiduRtcRoom.enableStatsToServer(true, "online");
        } else {
            this.mBaiduRtcRoom.c(true, false, "online");
        }
        if (this.mBaiduRtcRoom == null) {
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
                if (i == 102) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.obz = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                    a.this.Mp(3);
                } else if (i == 101) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.obz = false;
                    if (a.this.obw != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.Mp(3);
                    } else {
                        return;
                    }
                } else if (i == 2003) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.obz = false;
                    if (a.this.obw != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.Mp(3);
                    } else {
                        return;
                    }
                } else if (i == 117 || i == 118) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.obz = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        return;
                    }
                    a.this.Mp(3);
                } else if (i == 100) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    if (a.this.obB) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.obz = false;
                        if (a.this.obw == 2) {
                            a.this.Mp(2);
                            return;
                        }
                        a.this.Mp(2);
                    }
                } else if (i == 103) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.obz = false;
                    if (a.this.obw != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.Mp(3);
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
                if (i == 10000) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.obz = false;
                    if ((!a.this.canRetry() || a.this.obx.get(Integer.valueOf(i)) != null) && ((Integer) a.this.obx.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.obx.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.Mp(3);
                        } else {
                            return;
                        }
                    } else {
                        a.this.obx.put(Integer.valueOf(i), 1);
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    if (a.this.obr != null) {
                        a.this.obr.stop();
                    }
                    a.this.obz = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.obw == 2) {
                        a.this.Mp(2);
                        return;
                    }
                    a.this.Mp(2);
                } else if (i == 2002) {
                    a.this.be("ErrorRoomEvent:" + i, true);
                    return;
                }
                if (a.this.mRtcRoomListener != null) {
                    a.this.mRtcRoomListener.onPeerConnectStateUpdate(i);
                }
            }

            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onErrorInfoUpdate(int i) {
                a.this.log("rtcroom,errorCode:" + i);
                a.this.be("ErrorRoomEventInfo:" + i, true);
                a.this.obz = false;
                if (i != 436 || !a.this.canRetry()) {
                    if (a.this.mBaiduRtcRoom != null) {
                        a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                        a.this.mBaiduRtcRoom.logoutRtcRoom();
                        a.this.mBaiduRtcRoom.destroy();
                    }
                    a.this.Mp(3);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(i, "onErrorInfoUpdate");
                        return;
                    }
                    return;
                }
                a.this.s(5000L, true);
            }

            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
            }
        });
        this.mBaiduRtcRoom.a(new g.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.5
            @Override // com.baidu.rtc.g.d
            public void a(g gVar) {
                BaiduRtcRoom.c[] adB = a.this.mBaiduRtcRoom.adB();
                if (adB != null) {
                    for (BaiduRtcRoom.c cVar : adB) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            w Xn = c.dYL().Xn();
                            if (Xn != null) {
                                long unused = a.obE = Xn.aJY;
                            }
                            if (cVar.volumeLevel > a.obE) {
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
        RtcParameterSettings adT = RtcParameterSettings.adT();
        adT.HasVideo = false;
        adT.HasAudio = true;
        adT.ConnectionTimeoutMs = 5000;
        adT.ReadTimeoutMs = 5000;
        adT.AutoPublish = this.mIsAutoPublish;
        adT.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(adT, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        dYB();
        String str = "loginRtcRoom,appid:" + this.mAppId + ",token:" + this.mToken + ",roomName:" + this.mRoomName + ",uid:" + this.mUid + ",userName:" + this.mUserName + ",autoPublish:" + this.mIsAutoPublish + ",autoSubScribe:" + this.mIsAutoSubScribe + ",reLogin:" + z;
        log(str);
        be(str, true);
        if (z) {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, true);
        } else {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, this.mIsAutoPublish, this.mIsAutoSubScribe);
        }
        if (!loginRtcRoomWithRoomName) {
            Vx("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void yV(boolean z) {
        if (obo) {
            Vx("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void r(long j, boolean z) {
        if (obo) {
            Vx("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.d(j, z);
        }
    }

    public void ai(long j) {
        if (obo) {
            Vx("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bk(j);
        }
    }

    public void dYi() {
        if (obo) {
            Vx("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void Cf() {
        this.obB = true;
        if (this.obr != null) {
            this.obr.stop();
            this.obr.release();
        }
        this.obz = false;
        Mp(4);
        logoutRoom();
        if (this.obA != null) {
            this.obA = null;
        }
    }

    public void aAm() {
        this.obD = false;
        if (this.obr != null) {
            this.obr.pause();
        }
    }

    public void ckq() {
        be("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.obC) {
                    if (a.this.obr != null) {
                        a.this.obr.release();
                    }
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean hg(long j) {
        if (this.mBaiduRtcRoom != null) {
            BaiduRtcRoom.d[] adC = this.mBaiduRtcRoom.adC();
            StringBuilder sb = new StringBuilder();
            if (adC != null && adC.length > 0) {
                for (BaiduRtcRoom.d dVar : adC) {
                    sb.append(dVar.userId + Constants.ACCEPT_TIME_SEPARATOR_SP + dVar.userName + "#");
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

    public int dYw() {
        return this.obw;
    }

    public void dYx() {
        hh(1000L);
    }

    public void hh(long j) {
        s(j, false);
    }

    public boolean dYy() {
        return this.obD;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.obr != null) {
            this.obr.muteOrUnmuteAudio(z);
        }
    }

    public void yW(boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.dQ(z);
        }
    }

    public boolean dYz() {
        return this.mIsMute;
    }

    public String dYA() {
        if (this.obA != null) {
            String sb = this.obA.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.obu);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (this.obr != null) {
                    sb2.append(this.obr.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.obv);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.obw);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.mIsMute);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.oby);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.obz);
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
    public void s(long j, final boolean z) {
        be("reLoginRtcRoom:" + j + z, true);
        if (!this.obz) {
            this.obz = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.obB) {
                            a.this.obz = true;
                            if (!z) {
                                a.this.Mp(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.obB) {
                if (!z) {
                    Mp(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.obz && (this.obw == 1 || this.obw == 2) && this.obv < obp && this.oby && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void dYB() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.obs)) {
                this.mBaiduRtcRoom.a(this.obs, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.obt)) {
                this.mBaiduRtcRoom.a(this.obt, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp(int i) {
        be("changeRtcStatus:" + i, true);
        this.obw = i;
        this.obv = 0;
        this.obx.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (obo) {
            Log.i("AudioRoom", str);
        }
    }

    public void Vx(String str) {
        if (this.obA != null) {
            if (!obo) {
                try {
                    if (this.obA.length() > 1900) {
                        this.obA.delete(0, this.obA.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.obA.append("#");
            this.obA.append(System.currentTimeMillis());
            this.obA.append(":");
            this.obA.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(String str, boolean z) {
        if (this.obA != null) {
            if (!obo) {
                try {
                    if (this.obA.length() > 1900) {
                        this.obA.delete(0, this.obA.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Vx(str);
            if (z) {
                this.obA.append(",common:");
                this.obA.append(this.obu);
                this.obA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (this.obr != null) {
                    this.obA.append(this.obr.isPlaying());
                } else {
                    this.obA.append("false");
                }
                this.obA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.obA.append(this.obv);
                this.obA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.obA.append(this.obw);
                this.obA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.obA.append(this.mIsMute);
                this.obA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.obA.append(this.oby);
                this.obA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.obA.append(this.obz);
            }
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
        }
    }
}
