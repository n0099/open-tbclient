package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.rtc.BaseRtcRoom;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.by;
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
    private static String nUb;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer nUc;
    private String nUd;
    private String nUe;
    private boolean nUf;
    private volatile int nUg;
    private volatile int nUh;
    private HashMap<Integer, Integer> nUi;
    private boolean nUj;
    private boolean nUk;
    private StringBuilder nUl;
    private volatile boolean nUm;
    private volatile boolean nUn;
    private volatile boolean nUo;
    public static boolean nTZ = false;
    private static int nUa = 6;
    private static long nUp = 300;

    static /* synthetic */ int f(a aVar) {
        int i = aVar.nUg;
        aVar.nUg = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(nUb)) {
            nUb = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.nUh = 0;
        this.nUi = new HashMap<>();
        this.nUj = true;
        this.nUl = new StringBuilder();
        Vg("initaudioroom");
    }

    public void Vf(String str) {
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (nTZ) {
            Vg("enterLiveRoom:" + str + ",mstatus:" + this.nUh + ",misConnect:" + this.nUk);
        }
        this.nUn = true;
        if (!z && !this.nUf && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2) {
                this.nUc.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
            }
        } else {
            this.nUf = false;
            this.mPlayUrl = str;
            if (!i.Ns().Nt()) {
                log("playersdk do not init");
                Vg("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    return;
                }
                return;
            }
            this.nUc = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            by byVar = com.baidu.live.z.a.Pq().bmJ.aMy;
            if (byVar != null) {
                j = byVar.aPF;
                f = byVar.aPG;
                j2 = byVar.aPH;
                j3 = byVar.aPI * 1000;
            }
            log("cyplayer:cloudconfig:" + j + Constants.ACCEPT_TIME_SEPARATOR_SP + f + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + j3);
            if (nTZ) {
                Vg("cyplayer:cloudconfig:" + j + Constants.ACCEPT_TIME_SEPARATOR_SP + f + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + j3);
            }
            this.nUc.setOption("opt-open-audio-delay", 0L);
            this.nUc.setOption("realtime-low-latency-threshold", j);
            this.nUc.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.nUc.setOption("start-on-prepared", 1L);
            this.nUc.setOption("max-analyze-duration", String.valueOf(j3));
            this.nUc.setOption("max-probe-size", "204800");
            this.nUc.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.nUc.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.nUc.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    a.this.nUf = true;
                    a.this.nUo = false;
                    a.this.nUn = false;
                    a.this.log("cyplayer:onerror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    a.this.Vg("cyplayer:onerror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(-4, "playererror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    }
                    return false;
                }
            });
            this.nUc.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.nUc.setSpeed(f);
                                } else {
                                    a.this.nUc.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        a.this.nUo = true;
                        a.this.nUn = false;
                    }
                    return false;
                }
            });
            this.nUc.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.nTZ) {
                        a.this.Vg(",cyplayer:onPrepared");
                    }
                    if (a.this.nUm) {
                        a.this.nUc.stop();
                        a.this.nUc.release();
                    }
                }
            });
            this.nUc.prepareAsync();
            this.nUc.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        if (nTZ) {
            Vg("ownerEnterLiveRoom:mstatus:" + this.nUh + ",misConnect:" + this.nUk);
        }
        Vf(str5);
        this.nUe = "";
        this.nUd = "";
        LY(1);
        this.nUk = true;
        loginRtcRoom(str3, j, str4, str, str2, false, false, false);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        if (nTZ) {
            Vg("joinChat:mstatus:" + this.nUh + ",misConnect:" + this.nUk);
        }
        this.nUe = str6;
        this.nUd = str5;
        this.mIsMute = false;
        LY(1);
        this.nUk = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean dVG() {
        if (nTZ) {
            Vg("quitChat");
        }
        if (this.nUc != null) {
            chO();
        }
        this.nUk = false;
        LY(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (nTZ) {
            this.mBaiduRtcRoom.enableStatsToServer(true, "online");
        } else {
            this.mBaiduRtcRoom.enableStatsToServer(false, "offline");
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
                    a.this.nUk = false;
                    if (a.this.canRetry()) {
                        a.this.s(1000L, true);
                        a.f(a.this);
                        return;
                    }
                    a.this.LY(3);
                } else if (i == 101) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.nUk = false;
                    if (a.this.nUh != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(1000L, true);
                            return;
                        }
                        a.this.LY(3);
                    } else {
                        return;
                    }
                } else if (i == 2003) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.nUk = false;
                    if (a.this.nUh != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(1000L, true);
                            return;
                        }
                        a.this.LY(3);
                    } else {
                        return;
                    }
                } else if (i == 117 || i == 118) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.nUk = false;
                    if (a.this.canRetry()) {
                        a.this.s(1000L, true);
                        return;
                    }
                    a.this.LY(3);
                } else if (i == 100) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    if (a.this.nUm) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.nUk = false;
                        if (a.this.nUh == 2) {
                            a.this.LY(2);
                            return;
                        }
                        a.this.LY(2);
                    }
                } else if (i == 103) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.nUk = false;
                    if (a.this.nUh != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.LY(3);
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
                    a.this.nUk = false;
                    if ((!a.this.canRetry() || a.this.nUi.get(Integer.valueOf(i)) != null) && ((Integer) a.this.nUi.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.nUi.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.LY(3);
                        } else {
                            return;
                        }
                    } else {
                        a.this.nUi.put(Integer.valueOf(i), 1);
                        a.this.s(1000L, true);
                        a.f(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    if (a.this.nUc != null) {
                        a.this.nUc.stop();
                    }
                    a.this.nUk = false;
                    if (a.this.nUh == 2) {
                        a.this.LY(2);
                        return;
                    } else {
                        a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                        a.this.LY(2);
                    }
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
                a.this.nUk = false;
                if (i != 436 || !a.this.canRetry()) {
                    if (a.this.mBaiduRtcRoom != null) {
                        a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                        a.this.mBaiduRtcRoom.logoutRtcRoom();
                        a.this.mBaiduRtcRoom.destroy();
                    }
                    a.this.LY(3);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(i, "onErrorInfoUpdate");
                        return;
                    }
                    return;
                }
                a.this.s(IMConnection.RETRY_DELAY_TIMES, true);
            }

            @Override // com.baidu.rtc.BaiduRtcRoom.a
            public void onRoomDataMessage(ByteBuffer byteBuffer) {
            }
        });
        this.mBaiduRtcRoom.a(new g.d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.5
            @Override // com.baidu.rtc.g.d
            public void a(g gVar) {
                BaiduRtcRoom.c[] abc = a.this.mBaiduRtcRoom.abc();
                if (abc != null) {
                    for (BaiduRtcRoom.c cVar : abc) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            a.this.log("volumeLevel:" + cVar.volumeLevel);
                            w UO = c.dVV().UO();
                            if (UO != null) {
                                long unused = a.nUp = UO.aJf;
                            }
                            if (cVar.volumeLevel > a.nUp) {
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
        RtcParameterSettings abt = RtcParameterSettings.abt();
        abt.HasVideo = false;
        abt.HasAudio = true;
        abt.ConnectionTimeoutMs = 5000;
        abt.ReadTimeoutMs = 5000;
        abt.AutoPublish = this.mIsAutoPublish;
        abt.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(abt, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        dVL();
        String str = "loginRtcRoom,appid:" + this.mAppId + ",token:" + this.mToken + ",roomName:" + this.mRoomName + ",uid:" + this.mUid + ",userName:" + this.mUserName + ",appID:" + this.mAppId + ",token:" + this.mToken + ",autoPublish:" + this.mIsAutoPublish + ",autoSubScribe:" + this.mIsAutoSubScribe + ",reLogin:" + z;
        log(str);
        be(str, true);
        if (z) {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, true);
        } else {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, this.mIsAutoPublish, this.mIsAutoSubScribe);
        }
        if (!loginRtcRoomWithRoomName) {
            Vg("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void yN(boolean z) {
        if (nTZ) {
            Vg("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void r(long j, boolean z) {
        if (nTZ) {
            Vg("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.d(j, z);
        }
    }

    public void W(long j) {
        if (nTZ) {
            Vg("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.aO(j);
        }
    }

    public void dVt() {
        if (nTZ) {
            Vg("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void BP() {
        this.nUm = true;
        if (this.nUc != null) {
            this.nUc.stop();
            this.nUc.release();
        }
        this.nUk = false;
        LY(4);
        logoutRoom();
        if (this.nUl != null) {
            this.nUl = null;
        }
    }

    public void axM() {
        this.nUo = false;
        if (this.nUc != null) {
            this.nUc.pause();
        }
    }

    public void chO() {
        be("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.nUn) {
                    if (a.this.nUc != null) {
                        a.this.nUc.release();
                    }
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean gK(long j) {
        if (this.mBaiduRtcRoom != null) {
            BaiduRtcRoom.d[] abd = this.mBaiduRtcRoom.abd();
            StringBuilder sb = new StringBuilder();
            if (abd != null && abd.length > 0) {
                for (BaiduRtcRoom.d dVar : abd) {
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

    public int dVH() {
        return this.nUh;
    }

    public void dVI() {
        gL(0L);
    }

    public void gL(long j) {
        s(j, false);
    }

    public void yO(boolean z) {
        this.mIsMute = z;
    }

    public boolean dVJ() {
        return this.nUo;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.nUc != null) {
            this.nUc.muteOrUnmuteAudio(z);
        }
    }

    public String dVK() {
        if (this.nUl != null) {
            String sb = this.nUl.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.nUf);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (this.nUc != null) {
                    sb2.append(this.nUc.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.nUg);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.nUh);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.mIsMute);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.nUj);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.nUk);
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
        this.nUk = true;
        logoutRoom();
        if (j > 0) {
            d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.nUm) {
                        if (!z) {
                            a.this.LY(1);
                        }
                        a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                    }
                }
            }, j);
        } else if (!this.nUm) {
            if (!z) {
                LY(1);
            }
            loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.nUk && (this.nUh == 1 || this.nUh == 2) && this.nUg < nUa && this.nUj;
    }

    private void dVL() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.nUd)) {
                this.mBaiduRtcRoom.a(this.nUd, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.nUe)) {
                this.mBaiduRtcRoom.a(this.nUe, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LY(int i) {
        be("changeRtcStatus:" + i, true);
        this.nUh = i;
        this.nUg = 0;
        this.nUi.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (nTZ) {
            Log.i("AudioRoom", str);
        }
    }

    public void Vg(String str) {
        if (this.nUl != null) {
            if (!nTZ) {
                try {
                    if (this.nUl.length() > 1900) {
                        this.nUl.delete(0, this.nUl.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.nUl.append("#");
            this.nUl.append(System.currentTimeMillis());
            this.nUl.append(":");
            this.nUl.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(String str, boolean z) {
        if (this.nUl != null) {
            if (!nTZ) {
                try {
                    if (this.nUl.length() > 1900) {
                        this.nUl.delete(0, this.nUl.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Vg(str);
            if (z) {
                this.nUl.append(",common:");
                this.nUl.append(this.nUf);
                this.nUl.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (this.nUc != null) {
                    this.nUl.append(this.nUc.isPlaying());
                } else {
                    this.nUl.append("false");
                }
                this.nUl.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.nUl.append(this.nUg);
                this.nUl.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.nUl.append(this.nUh);
                this.nUl.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.nUl.append(this.mIsMute);
                this.nUl.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.nUl.append(this.nUj);
                this.nUl.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.nUl.append(this.nUk);
            }
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
        }
    }
}
