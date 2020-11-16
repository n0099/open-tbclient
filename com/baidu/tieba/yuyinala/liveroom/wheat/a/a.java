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
    private static String ocU;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer ocV;
    private String ocW;
    private String ocX;
    private boolean ocY;
    private volatile int ocZ;
    private volatile int oda;
    private HashMap<Integer, Integer> odb;
    private boolean odc;
    private boolean odd;
    private StringBuilder ode;
    private volatile boolean odf;
    private volatile boolean odg;
    private volatile boolean odh;
    public static boolean ocS = false;
    private static int ocT = 6;
    private static long odi = 300;

    static /* synthetic */ int f(a aVar) {
        int i = aVar.ocZ;
        aVar.ocZ = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(ocU)) {
            ocU = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.oda = 0;
        this.odb = new HashMap<>();
        this.odc = true;
        this.ode = new StringBuilder();
        Vi("initaudioroom");
    }

    public void Vh(String str) {
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (ocS) {
            Vi("enterLiveRoom:" + str + ",mstatus:" + this.oda + ",misConnect:" + this.odd);
        }
        this.odg = true;
        if (!z && !this.ocY && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2) {
                this.ocV.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
            }
        } else {
            this.ocY = false;
            this.mPlayUrl = str;
            if (!i.Nj().Nk()) {
                log("playersdk do not init");
                Vi("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    return;
                }
                return;
            }
            this.ocV = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            bz bzVar = com.baidu.live.aa.a.Ph().bms.aLN;
            if (bzVar != null) {
                j = bzVar.aOR;
                f = bzVar.aOS;
                j2 = bzVar.aOT;
                j3 = bzVar.aOU * 1000;
            }
            log("cyplayer:cloudconfig:" + j + Constants.ACCEPT_TIME_SEPARATOR_SP + f + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + j3);
            if (ocS) {
                Vi("cyplayer:cloudconfig:" + j + Constants.ACCEPT_TIME_SEPARATOR_SP + f + Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + Constants.ACCEPT_TIME_SEPARATOR_SP + j3);
            }
            this.ocV.setOption("opt-open-audio-delay", 0L);
            this.ocV.setOption("realtime-low-latency-threshold", j);
            this.ocV.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.ocV.setOption("start-on-prepared", 1L);
            this.ocV.setOption("max-analyze-duration", String.valueOf(j3));
            this.ocV.setOption("max-probe-size", "204800");
            this.ocV.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.ocV.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.ocV.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    a.this.ocY = true;
                    a.this.odh = false;
                    a.this.odg = false;
                    a.this.log("cyplayer:onerror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    a.this.Vi("cyplayer:onerror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(-4, "playererror:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                    }
                    return false;
                }
            });
            this.ocV.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.ocV.setSpeed(f);
                                } else {
                                    a.this.ocV.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        a.this.odh = true;
                        a.this.odg = false;
                    }
                    return false;
                }
            });
            this.ocV.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.ocS) {
                        a.this.Vi(",cyplayer:onPrepared");
                    }
                    if (a.this.odf) {
                        a.this.ocV.stop();
                        a.this.ocV.release();
                    }
                }
            });
            this.ocV.prepareAsync();
            this.ocV.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Vi("ownerEnterLiveRoom:mstatus:" + this.oda + ",misConnect:" + this.odd);
        Vh(str5);
        this.ocX = "";
        this.ocW = "";
        MS(1);
        this.odd = true;
        loginRtcRoom(str3, j, str4, str, str2, false, false, false);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        Vi("joinChat:mstatus:" + this.oda + ",misConnect:" + this.odd);
        this.ocX = str6;
        this.ocW = str5;
        MS(1);
        this.odd = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean dYu() {
        Vi("quitChat");
        if (this.ocV != null) {
            cjJ();
        }
        this.odd = false;
        this.mIsMute = false;
        MS(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (ocS) {
            this.mBaiduRtcRoom.j(true, "online");
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
                    a.this.odd = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                    a.this.MS(3);
                } else if (i == 101) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.odd = false;
                    if (a.this.oda != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.MS(3);
                    } else {
                        return;
                    }
                } else if (i == 2003) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.odd = false;
                    if (a.this.oda != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.MS(3);
                    } else {
                        return;
                    }
                } else if (i == 117 || i == 118) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.odd = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        return;
                    }
                    a.this.MS(3);
                } else if (i == 100) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    if (a.this.odf) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.odd = false;
                        if (a.this.oda == 2) {
                            a.this.MS(2);
                            return;
                        }
                        a.this.MS(2);
                    }
                } else if (i == 103) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    a.this.odd = false;
                    if (a.this.oda != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.MS(3);
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
                    a.this.odd = false;
                    if ((!a.this.canRetry() || a.this.odb.get(Integer.valueOf(i)) != null) && ((Integer) a.this.odb.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.odb.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.MS(3);
                        } else {
                            return;
                        }
                    } else {
                        a.this.odb.put(Integer.valueOf(i), 1);
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.be("RTCRoomEvent:" + i, true);
                    if (a.this.ocV != null) {
                        a.this.ocV.stop();
                    }
                    a.this.odd = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.oda == 2) {
                        a.this.MS(2);
                        return;
                    }
                    a.this.MS(2);
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
                a.this.odd = false;
                if (i != 436 || !a.this.canRetry()) {
                    if (a.this.mBaiduRtcRoom != null) {
                        a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                        a.this.mBaiduRtcRoom.logoutRtcRoom();
                        a.this.mBaiduRtcRoom.destroy();
                    }
                    a.this.MS(3);
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
                BaiduRtcRoom.c[] acT = a.this.mBaiduRtcRoom.acT();
                if (acT != null) {
                    for (BaiduRtcRoom.c cVar : acT) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            w WE = c.dYK().WE();
                            if (WE != null) {
                                long unused = a.odi = WE.aIn;
                            }
                            if (cVar.volumeLevel > a.odi) {
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
        RtcParameterSettings adl = RtcParameterSettings.adl();
        adl.HasVideo = false;
        adl.HasAudio = true;
        adl.ConnectionTimeoutMs = 5000;
        adl.ReadTimeoutMs = 5000;
        adl.AutoPublish = this.mIsAutoPublish;
        adl.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(adl, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        dYA();
        String str = "loginRtcRoom,appid:" + this.mAppId + ",token:" + this.mToken + ",roomName:" + this.mRoomName + ",uid:" + this.mUid + ",userName:" + this.mUserName + ",autoPublish:" + this.mIsAutoPublish + ",autoSubScribe:" + this.mIsAutoSubScribe + ",reLogin:" + z;
        log(str);
        be(str, true);
        if (z) {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.a(this.mRoomName, this.mUid, this.mUserName, true);
        } else {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, this.mIsAutoPublish, this.mIsAutoSubScribe);
        }
        if (!loginRtcRoomWithRoomName) {
            Vi("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void zc(boolean z) {
        if (ocS) {
            Vi("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void r(long j, boolean z) {
        if (ocS) {
            Vi("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.d(j, z);
        }
    }

    public void ai(long j) {
        if (ocS) {
            Vi("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bk(j);
        }
    }

    public void dYh() {
        if (ocS) {
            Vi("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.acS();
        }
    }

    public void Bw() {
        this.odf = true;
        if (this.ocV != null) {
            this.ocV.stop();
            this.ocV.release();
        }
        this.odd = false;
        MS(4);
        logoutRoom();
        if (this.ode != null) {
            this.ode = null;
        }
    }

    public void azE() {
        this.odh = false;
        if (this.ocV != null) {
            this.ocV.pause();
        }
    }

    public void cjJ() {
        be("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.odg) {
                    if (a.this.ocV != null) {
                        a.this.ocV.release();
                    }
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean hj(long j) {
        if (this.mBaiduRtcRoom != null) {
            BaiduRtcRoom.d[] acU = this.mBaiduRtcRoom.acU();
            StringBuilder sb = new StringBuilder();
            if (acU != null && acU.length > 0) {
                for (BaiduRtcRoom.d dVar : acU) {
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

    public int dYv() {
        return this.oda;
    }

    public void dYw() {
        hk(1000L);
    }

    public void hk(long j) {
        s(j, false);
    }

    public boolean dYx() {
        return this.odh;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.ocV != null) {
            this.ocV.muteOrUnmuteAudio(z);
        }
    }

    public void zd(boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.dS(z);
        }
    }

    public boolean dYy() {
        return this.mIsMute;
    }

    public String dYz() {
        if (this.ode != null) {
            String sb = this.ode.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.ocY);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (this.ocV != null) {
                    sb2.append(this.ocV.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.ocZ);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.oda);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.mIsMute);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.odc);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(this.odd);
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
        if (!this.odd) {
            this.odd = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.odf) {
                            a.this.odd = true;
                            if (!z) {
                                a.this.MS(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.odf) {
                if (!z) {
                    MS(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.odd && (this.oda == 1 || this.oda == 2) && this.ocZ < ocT && this.odc && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void dYA() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.ocW)) {
                this.mBaiduRtcRoom.a(this.ocW, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.ocX)) {
                this.mBaiduRtcRoom.a(this.ocX, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS(int i) {
        be("changeRtcStatus:" + i, true);
        this.oda = i;
        this.ocZ = 0;
        this.odb.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (ocS) {
            Log.i("AudioRoom", str);
        }
    }

    public void Vi(String str) {
        if (this.ode != null) {
            if (!ocS) {
                try {
                    if (this.ode.length() > 1900) {
                        this.ode.delete(0, this.ode.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.ode.append("#");
            this.ode.append(System.currentTimeMillis());
            this.ode.append(":");
            this.ode.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(String str, boolean z) {
        if (this.ode != null) {
            if (!ocS) {
                try {
                    if (this.ode.length() > 1900) {
                        this.ode.delete(0, this.ode.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Vi(str);
            if (z) {
                this.ode.append(",common:");
                this.ode.append(this.ocY);
                this.ode.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (this.ocV != null) {
                    this.ode.append(this.ocV.isPlaying());
                } else {
                    this.ode.append("false");
                }
                this.ode.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.ode.append(this.ocZ);
                this.ode.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.ode.append(this.oda);
                this.ode.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.ode.append(this.mIsMute);
                this.ode.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.ode.append(this.odc);
                this.ode.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.ode.append(this.odd);
            }
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
        }
    }
}
