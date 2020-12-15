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
import com.baidu.live.data.cb;
import com.baidu.live.data.w;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.g;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BaseRtcRoom {
    private static String orW;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer orX;
    private String orY;
    private String orZ;
    private boolean osa;
    private volatile int osb;
    private volatile int osc;
    private HashMap<Integer, Integer> osd;
    private boolean ose;
    private boolean osf;
    private StringBuilder osg;
    private volatile boolean osh;
    private volatile boolean osi;
    private volatile boolean osj;
    public static boolean orU = false;
    private static int orV = 6;
    private static long osk = 300;

    static /* synthetic */ int f(a aVar) {
        int i = aVar.osb;
        aVar.osb = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(orW)) {
            orW = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.osc = 0;
        this.osd = new HashMap<>();
        this.ose = true;
        this.osg = new StringBuilder();
        Wx("initaudioroom");
    }

    public void Ww(String str) {
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (orU) {
            Wx("enterLiveRoom:" + str + ",mstatus:" + this.osc + ",misConnect:" + this.osf);
        }
        this.osi = true;
        if (!z && !this.osa && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2) {
                this.orX.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
            }
        } else {
            this.osa = false;
            this.mPlayUrl = str;
            if (!i.PB().PC()) {
                log("playersdk do not init");
                Wx("playersdk do not init");
                if (this.mRtcRoomListener != null) {
                    this.mRtcRoomListener.onError(-4, "playersdk do not init");
                    return;
                }
                return;
            }
            this.orX = new CyberPlayer();
            long j = 2000;
            final float f = 1.0f;
            final long j2 = 2000;
            long j3 = 500000;
            cb cbVar = com.baidu.live.ae.a.RB().brA.aOJ;
            if (cbVar != null) {
                j = cbVar.aRT;
                f = cbVar.aRU;
                j2 = cbVar.aRV;
                j3 = cbVar.aRW * 1000;
            }
            log("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            if (orU) {
                Wx("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.orX.setOption("opt-open-audio-delay", 0L);
            this.orX.setOption("realtime-low-latency-threshold", j);
            this.orX.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.orX.setOption("start-on-prepared", 1L);
            this.orX.setOption("max-analyze-duration", String.valueOf(j3));
            this.orX.setOption("max-probe-size", "204800");
            this.orX.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.orX.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.orX.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    a.this.osa = true;
                    a.this.osj = false;
                    a.this.osi = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.Wx("cyplayer:onerror:" + i + "," + i2);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(-4, "playererror:" + i + "," + i2);
                    }
                    return false;
                }
            });
            this.orX.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.orX.setSpeed(f);
                                } else {
                                    a.this.orX.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        a.this.osj = true;
                        a.this.osi = false;
                    }
                    return false;
                }
            });
            this.orX.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.orU) {
                        a.this.Wx(",cyplayer:onPrepared");
                    }
                    if (a.this.osh) {
                        a.this.orX.stop();
                        a.this.orX.release();
                    }
                }
            });
            this.orX.prepareAsync();
            this.orX.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Wx("ownerEnterLiveRoom:mstatus:" + this.osc + ",misConnect:" + this.osf);
        Ww(str5);
        this.orZ = "";
        this.orY = "";
        NK(1);
        this.osf = true;
        loginRtcRoom(str3, j, str4, str, str2, false, false, false);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        Wx("joinChat:mstatus:" + this.osc + ",misConnect:" + this.osf);
        this.orZ = str6;
        this.orY = str5;
        NK(1);
        this.osf = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean edZ() {
        Wx("quitChat");
        if (this.orX != null) {
            cnF();
        }
        this.osf = false;
        this.mIsMute = false;
        NK(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (orU) {
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
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osf = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                    a.this.NK(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osf = false;
                    if (a.this.osc != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.NK(3);
                    } else {
                        return;
                    }
                } else if (i == 2003) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osf = false;
                    if (a.this.osc != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.NK(3);
                    } else {
                        return;
                    }
                } else if (i == 117 || i == 118) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osf = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        return;
                    }
                    a.this.NK(3);
                } else if (i == 100) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.osh) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.osf = false;
                        if (a.this.osc == 2) {
                            a.this.NK(2);
                            return;
                        }
                        a.this.NK(2);
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osf = false;
                    if (a.this.osc != 4) {
                        if (a.this.canRetry()) {
                            a.this.s(5000L, true);
                            return;
                        }
                        a.this.NK(3);
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
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osf = false;
                    if ((!a.this.canRetry() || a.this.osd.get(Integer.valueOf(i)) != null) && ((Integer) a.this.osd.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.osd.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.NK(3);
                        } else {
                            return;
                        }
                    } else {
                        a.this.osd.put(Integer.valueOf(i), 1);
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.orX != null) {
                        a.this.orX.stop();
                    }
                    a.this.osf = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.osc == 2) {
                        a.this.NK(2);
                        return;
                    }
                    a.this.NK(2);
                } else if (i == 2002) {
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
                a.this.bf("ErrorRoomEventInfo:" + i, true);
                a.this.osf = false;
                if (i != 436 || !a.this.canRetry()) {
                    if (a.this.mBaiduRtcRoom != null) {
                        a.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) null);
                        a.this.mBaiduRtcRoom.logoutRtcRoom();
                        a.this.mBaiduRtcRoom.destroy();
                    }
                    a.this.NK(3);
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
                BaiduRtcRoom.c[] agc = a.this.mBaiduRtcRoom.agc();
                if (agc != null) {
                    for (BaiduRtcRoom.c cVar : agc) {
                        if (cVar != null && cVar.userId == a.this.mUid) {
                            w Zd = c.eep().Zd();
                            if (Zd != null) {
                                long unused = a.osk = Zd.aKZ;
                            }
                            if (cVar.volumeLevel > a.osk) {
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
        RtcParameterSettings agu = RtcParameterSettings.agu();
        agu.HasVideo = false;
        agu.HasAudio = true;
        agu.ConnectionTimeoutMs = 5000;
        agu.ReadTimeoutMs = 5000;
        agu.AutoPublish = this.mIsAutoPublish;
        agu.AutoSubScribe = this.mIsAutoSubScribe;
        this.mBaiduRtcRoom.a(agu, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
        eef();
        String str = "loginRtcRoom,appid:" + this.mAppId + ",token:" + this.mToken + ",roomName:" + this.mRoomName + ",uid:" + this.mUid + ",userName:" + this.mUserName + ",autoPublish:" + this.mIsAutoPublish + ",autoSubScribe:" + this.mIsAutoSubScribe + ",reLogin:" + z;
        log(str);
        bf(str, true);
        if (z) {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, true);
        } else {
            loginRtcRoomWithRoomName = this.mBaiduRtcRoom.loginRtcRoomWithRoomName(this.mRoomName, this.mUid, this.mUserName, this.mIsAutoPublish, this.mIsAutoSubScribe);
        }
        if (!loginRtcRoomWithRoomName) {
            Wx("firstloginfailed");
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-1, "firstloginfailed");
            }
        }
    }

    public void zG(boolean z) {
        if (orU) {
            Wx("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void r(long j, boolean z) {
        if (orU) {
            Wx("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.d(j, z);
        }
    }

    public void aG(long j) {
        if (orU) {
            Wx("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bJ(j);
        }
    }

    public void edM() {
        if (orU) {
            Wx("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void Df() {
        this.osh = true;
        if (this.orX != null) {
            this.orX.stop();
            this.orX.release();
        }
        this.osf = false;
        NK(4);
        logoutRoom();
        if (this.osg != null) {
            this.osg = null;
        }
    }

    public void aCN() {
        this.osj = false;
        if (this.orX != null) {
            this.orX.pause();
        }
    }

    public void cnF() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.osi) {
                    if (a.this.orX != null) {
                        a.this.orX.release();
                    }
                    a.this.n(a.this.mPlayUrl, true, false);
                }
            }
        });
    }

    public boolean hO(long j) {
        if (this.mBaiduRtcRoom != null) {
            BaiduRtcRoom.d[] agd = this.mBaiduRtcRoom.agd();
            StringBuilder sb = new StringBuilder();
            if (agd != null && agd.length > 0) {
                for (BaiduRtcRoom.d dVar : agd) {
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
        return this.osc;
    }

    public void eeb() {
        hP(1000L);
    }

    public void hP(long j) {
        s(j, false);
    }

    public boolean eec() {
        return this.osj;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.orX != null) {
            this.orX.muteOrUnmuteAudio(z);
        }
    }

    public void zH(boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.ei(z);
        }
    }

    public boolean eed() {
        return this.mIsMute;
    }

    public String eee() {
        if (this.osg != null) {
            String sb = this.osg.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.osa);
                sb2.append(",");
                if (this.orX != null) {
                    sb2.append(this.orX.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(",");
                sb2.append(this.osb);
                sb2.append(",");
                sb2.append(this.osc);
                sb2.append(",");
                sb2.append(this.mIsMute);
                sb2.append(",");
                sb2.append(this.ose);
                sb2.append(",");
                sb2.append(this.osf);
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
        bf("reLoginRtcRoom:" + j + z, true);
        if (!this.osf) {
            this.osf = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.osh) {
                            a.this.osf = true;
                            if (!z) {
                                a.this.NK(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.osh) {
                if (!z) {
                    NK(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.osf && (this.osc == 1 || this.osc == 2) && this.osb < orV && this.ose && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void eef() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.orY)) {
                this.mBaiduRtcRoom.a(this.orY, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.orZ)) {
                this.mBaiduRtcRoom.a(this.orZ, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NK(int i) {
        bf("changeRtcStatus:" + i, true);
        this.osc = i;
        this.osb = 0;
        this.osd.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (orU) {
            Log.i("AudioRoom", str);
        }
    }

    public void Wx(String str) {
        if (this.osg != null) {
            if (!orU) {
                try {
                    if (this.osg.length() > 1900) {
                        this.osg.delete(0, this.osg.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.osg.append("#");
            this.osg.append(System.currentTimeMillis());
            this.osg.append(":");
            this.osg.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.osg != null) {
            if (!orU) {
                try {
                    if (this.osg.length() > 1900) {
                        this.osg.delete(0, this.osg.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Wx(str);
            if (z) {
                this.osg.append(",common:");
                this.osg.append(this.osa);
                this.osg.append(",");
                if (this.orX != null) {
                    this.osg.append(this.orX.isPlaying());
                } else {
                    this.osg.append("false");
                }
                this.osg.append(",");
                this.osg.append(this.osb);
                this.osg.append(",");
                this.osg.append(this.osc);
                this.osg.append(",");
                this.osg.append(this.mIsMute);
                this.osg.append(",");
                this.osg.append(this.ose);
                this.osg.append(",");
                this.osg.append(this.osf);
            }
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
        }
    }
}
