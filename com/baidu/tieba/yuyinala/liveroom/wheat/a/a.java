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
    private static String orU;
    private boolean mIsMute;
    private String mPlayUrl;
    private CyberPlayer orV;
    private String orW;
    private String orX;
    private boolean orY;
    private volatile int orZ;
    private volatile int osa;
    private HashMap<Integer, Integer> osb;
    private boolean osc;
    private boolean osd;
    private StringBuilder ose;
    private volatile boolean osf;
    private volatile boolean osg;
    private volatile boolean osh;
    public static boolean orS = false;
    private static int orT = 6;
    private static long osi = 300;

    static /* synthetic */ int f(a aVar) {
        int i = aVar.orZ;
        aVar.orZ = i + 1;
        return i;
    }

    static {
        if (TextUtils.isEmpty(orU)) {
            orU = UtilHelper.is64Bit() ? "arm64-v8a" : "armeabi";
        }
    }

    public a(Context context) {
        super(context);
        this.osa = 0;
        this.osb = new HashMap<>();
        this.osc = true;
        this.ose = new StringBuilder();
        Wx("initaudioroom");
    }

    public void Ww(String str) {
        n(str, false, false);
    }

    public void n(String str, boolean z, boolean z2) {
        if (orS) {
            Wx("enterLiveRoom:" + str + ",mstatus:" + this.osa + ",misConnect:" + this.osd);
        }
        this.osg = true;
        if (!z && !this.orY && TextUtils.equals(this.mPlayUrl, str)) {
            if (!z2) {
                this.orV.muteOrUnmuteAudio(false);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (this.mRtcRoomListener != null) {
                this.mRtcRoomListener.onError(-4, "player url is null");
            }
        } else {
            this.orY = false;
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
            this.orV = new CyberPlayer();
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
            if (orS) {
                Wx("cyplayer:cloudconfig:" + j + "," + f + "," + j2 + "," + j3);
            }
            this.orV.setOption("opt-open-audio-delay", 0L);
            this.orV.setOption("realtime-low-latency-threshold", j);
            this.orV.setOption("realtime-cache-duration-notify-timeout", 1000L);
            this.orV.setOption("start-on-prepared", 1L);
            this.orV.setOption("max-analyze-duration", String.valueOf(j3));
            this.orV.setOption("max-probe-size", "204800");
            this.orV.setDataSource(str);
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1004");
            this.orV.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.orV.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    a.this.orY = true;
                    a.this.osh = false;
                    a.this.osg = false;
                    a.this.log("cyplayer:onerror:" + i + "," + i2);
                    a.this.Wx("cyplayer:onerror:" + i + "," + i2);
                    if (a.this.mRtcRoomListener != null) {
                        a.this.mRtcRoomListener.onError(-4, "playererror:" + i + "," + i2);
                    }
                    return false;
                }
            });
            this.orV.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.2
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    a.this.log("cyplayer:onInfo:" + i + "," + i2 + "," + (obj == null));
                    if (i == 953) {
                        if (obj instanceof String) {
                            try {
                                long optLong = new JSONObject((String) obj).optLong("audio_duration");
                                if (optLong > j2) {
                                    a.this.orV.setSpeed(f);
                                } else {
                                    a.this.orV.setSpeed(1.0f);
                                }
                                a.this.log("cyplayer:ondelayaudio:" + optLong);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (i == 904 || i == 10002) {
                        a.this.osh = true;
                        a.this.osg = false;
                    }
                    return false;
                }
            });
            this.orV.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    a.this.log("cyplayer:onPrepared");
                    if (a.orS) {
                        a.this.Wx(",cyplayer:onPrepared");
                    }
                    if (a.this.osf) {
                        a.this.orV.stop();
                        a.this.orV.release();
                    }
                }
            });
            this.orV.prepareAsync();
            this.orV.muteOrUnmuteAudio(z2);
            log("cyplayer:start:" + str);
        }
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Wx("ownerEnterLiveRoom:mstatus:" + this.osa + ",misConnect:" + this.osd);
        Ww(str5);
        this.orX = "";
        this.orW = "";
        NK(1);
        this.osd = true;
        loginRtcRoom(str3, j, str4, str, str2, false, false, false);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        Wx("joinChat:mstatus:" + this.osa + ",misConnect:" + this.osd);
        this.orX = str6;
        this.orW = str5;
        NK(1);
        this.osd = true;
        loginRtcRoom(str3, j, str4, str, str2, true, true, false);
    }

    public boolean edY() {
        Wx("quitChat");
        if (this.orV != null) {
            cnE();
        }
        this.osd = false;
        this.mIsMute = false;
        NK(4);
        return logoutRoom();
    }

    @Override // com.baidu.ala.rtc.BaseRtcRoom
    protected void initAndLoginRtcRoom(boolean z) {
        boolean loginRtcRoomWithRoomName;
        BaiduRtcRoom baiduRtcRoom = this.mBaiduRtcRoom;
        this.mBaiduRtcRoom = BaiduRtcRoom.a(this.mContext, this.mAppId, this.mToken, "", true);
        if (orS) {
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
                    a.this.osd = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                    a.this.NK(3);
                } else if (i == 101) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osd = false;
                    if (a.this.osa != 4) {
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
                    a.this.osd = false;
                    if (a.this.osa != 4) {
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
                    a.this.osd = false;
                    if (a.this.canRetry()) {
                        a.this.s(5000L, true);
                        return;
                    }
                    a.this.NK(3);
                } else if (i == 100) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.osf) {
                        a.this.logoutRoom();
                    }
                    if (!a.this.mIsAutoPublish && !a.this.mIsAutoSubScribe) {
                        a.this.osd = false;
                        if (a.this.osa == 2) {
                            a.this.NK(2);
                            return;
                        }
                        a.this.NK(2);
                    }
                } else if (i == 103) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    a.this.osd = false;
                    if (a.this.osa != 4) {
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
                    a.this.osd = false;
                    if ((!a.this.canRetry() || a.this.osb.get(Integer.valueOf(i)) != null) && ((Integer) a.this.osb.get(Integer.valueOf(i))).intValue() != 0) {
                        if (!a.this.canRetry() || ((Integer) a.this.osb.get(Integer.valueOf(i))).intValue() <= 0) {
                            a.this.NK(3);
                        } else {
                            return;
                        }
                    } else {
                        a.this.osb.put(Integer.valueOf(i), 1);
                        a.this.s(5000L, true);
                        a.f(a.this);
                        return;
                    }
                } else if (i == 2001) {
                    a.this.bf("RTCRoomEvent:" + i, true);
                    if (a.this.orV != null) {
                        a.this.orV.stop();
                    }
                    a.this.osd = false;
                    a.this.mBaiduRtcRoom.muteMicphone(a.this.mIsMute);
                    if (a.this.osa == 2) {
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
                a.this.osd = false;
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
                            w Zd = c.eeo().Zd();
                            if (Zd != null) {
                                long unused = a.osi = Zd.aKZ;
                            }
                            if (cVar.volumeLevel > a.osi) {
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
        eee();
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
        if (orS) {
            Wx("muteMic:" + z);
        }
        this.mIsMute = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void r(long j, boolean z) {
        if (orS) {
            Wx("muteUser:" + j + z);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.d(j, z);
        }
    }

    public void aG(long j) {
        if (orS) {
            Wx("kickOffUser:" + j);
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bJ(j);
        }
    }

    public void edL() {
        if (orS) {
            Wx("closeLiveRoom");
        }
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.disbandRoom();
        }
    }

    public void Df() {
        this.osf = true;
        if (this.orV != null) {
            this.orV.stop();
            this.orV.release();
        }
        this.osd = false;
        NK(4);
        logoutRoom();
        if (this.ose != null) {
            this.ose = null;
        }
    }

    public void aCN() {
        this.osh = false;
        if (this.orV != null) {
            this.orV.pause();
        }
    }

    public void cnE() {
        bf("restartPlayer", true);
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.osg) {
                    if (a.this.orV != null) {
                        a.this.orV.release();
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

    public int edZ() {
        return this.osa;
    }

    public void eea() {
        hP(1000L);
    }

    public void hP(long j) {
        s(j, false);
    }

    public boolean eeb() {
        return this.osh;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.orV != null) {
            this.orV.muteOrUnmuteAudio(z);
        }
    }

    public void zH(boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.ei(z);
        }
    }

    public boolean eec() {
        return this.mIsMute;
    }

    public String eed() {
        if (this.ose != null) {
            String sb = this.ose.toString();
            if (sb == null || !sb.contains("common")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",common:");
                sb2.append(this.orY);
                sb2.append(",");
                if (this.orV != null) {
                    sb2.append(this.orV.isPlaying());
                } else {
                    sb2.append("false");
                }
                sb2.append(",");
                sb2.append(this.orZ);
                sb2.append(",");
                sb2.append(this.osa);
                sb2.append(",");
                sb2.append(this.mIsMute);
                sb2.append(",");
                sb2.append(this.osc);
                sb2.append(",");
                sb2.append(this.osd);
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
        if (!this.osd) {
            this.osd = true;
            logoutRoom();
            if (j > 0) {
                d(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.osf) {
                            a.this.osd = true;
                            if (!z) {
                                a.this.NK(1);
                            }
                            a.this.loginRtcRoom(a.this.mRoomName, a.this.mUid, a.this.mUserName, a.this.mAppId, a.this.mToken, a.this.mIsAutoPublish, a.this.mIsAutoSubScribe, true);
                        }
                    }
                }, j);
            } else if (!this.osf) {
                if (!z) {
                    NK(1);
                }
                loginRtcRoom(this.mRoomName, this.mUid, this.mUserName, this.mAppId, this.mToken, this.mIsAutoPublish, this.mIsAutoSubScribe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRetry() {
        return !this.osd && (this.osa == 1 || this.osa == 2) && this.orZ < orT && this.osc && BdNetTypeUtil.isNetWorkAvailable();
    }

    private void eee() {
        if (this.mBaiduRtcRoom != null) {
            if (!TextUtils.isEmpty(this.orW)) {
                this.mBaiduRtcRoom.a(this.orW, true, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            }
            if (!TextUtils.isEmpty(this.orX)) {
                this.mBaiduRtcRoom.a(this.orX, false, true, "pure_audio", BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            }
        }
    }

    private void d(Runnable runnable, long j) {
        SafeHandler.getInst().postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NK(int i) {
        bf("changeRtcStatus:" + i, true);
        this.osa = i;
        this.orZ = 0;
        this.osb.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (orS) {
            Log.i("AudioRoom", str);
        }
    }

    public void Wx(String str) {
        if (this.ose != null) {
            if (!orS) {
                try {
                    if (this.ose.length() > 1900) {
                        this.ose.delete(0, this.ose.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.ose.append("#");
            this.ose.append(System.currentTimeMillis());
            this.ose.append(":");
            this.ose.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, boolean z) {
        if (this.ose != null) {
            if (!orS) {
                try {
                    if (this.ose.length() > 1900) {
                        this.ose.delete(0, this.ose.length() - 1900);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Wx(str);
            if (z) {
                this.ose.append(",common:");
                this.ose.append(this.orY);
                this.ose.append(",");
                if (this.orV != null) {
                    this.ose.append(this.orV.isPlaying());
                } else {
                    this.ose.append("false");
                }
                this.ose.append(",");
                this.ose.append(this.orZ);
                this.ose.append(",");
                this.ose.append(this.osa);
                this.ose.append(",");
                this.ose.append(this.mIsMute);
                this.ose.append(",");
                this.ose.append(this.osc);
                this.ose.append(",");
                this.ose.append(this.osd);
            }
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
        }
    }
}
