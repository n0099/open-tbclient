package com.baidu.tieba.voice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Handler;
import android.os.PowerManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.by;
import com.baidu.tieba.voice.service.MediaService;
import com.slidingmenu.lib.R;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    private static Boolean J;
    private static Integer K;
    private static Integer L;
    private Boolean B;
    private com.baidu.tieba.voice.a.a E;
    ae a;
    Activity d;
    AudioManager g;
    private Handler p;
    private Boolean r;
    private boolean s;
    private ad x;
    private ad y;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static float C = 4.294967E9f;
    private static float D = 0.5f;
    public static int i = 3;
    String b = null;
    private long q = 0;
    private boolean t = false;
    private Runnable u = new t(this);
    private VoiceModel v = null;
    private VoiceModel w = null;
    private ag z = null;
    private ai A = null;
    Runnable c = new u(this);
    SensorManager e = null;
    Sensor f = null;
    private boolean F = true;
    PowerManager.WakeLock h = null;
    private Handler G = new Handler();
    private int H = 1;
    private r I = null;
    private boolean M = false;
    Runnable j = new y(this);
    Runnable k = new z(this);
    private boolean N = true;
    private Runnable O = new aa(this);
    boolean l = false;
    private BroadcastReceiver P = new ab(this);

    /* loaded from: classes.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET
    }

    public static synchronized void a() {
        synchronized (VoiceManager.class) {
            if (!n) {
                o = com.baidu.tieba.sharedPref.b.a().a("voice_use_soft_decoder", ak.b());
            }
        }
    }

    public static boolean b() {
        return o;
    }

    public static void a(boolean z) {
        o = true;
        com.baidu.tieba.sharedPref.b.a().b("voice_use_soft_decoder", o);
    }

    public static VoiceManager c() {
        return new VoiceManager();
    }

    public VoiceManager() {
        a();
        m = b() ? false : true;
    }

    /* loaded from: classes.dex */
    public class VoiceModel implements Serializable {
        public int duration;
        public int duration2;
        public String from;
        public String voiceId;
        public boolean isLocal = false;
        public int elapse = 0;
        public int curr_time = 0;
        public Integer voice_status = 1;

        public String getId() {
            return this.voiceId;
        }

        public void init() {
            this.voice_status = 1;
            this.elapse = 0;
            this.isLocal = false;
        }
    }

    public boolean a(ae aeVar, int i2) {
        if (aeVar == null) {
            return false;
        }
        this.a = aeVar;
        if (!com.baidu.tieba.util.ad.a()) {
            String b = com.baidu.tieba.util.ad.b();
            if (b == null) {
                b = this.d.getString(R.string.voice_error_sdcard);
            }
            this.a.a(0, b);
            return false;
        }
        g();
        this.b = aj.a();
        String a = aj.a(this.b);
        if (this.I == null) {
            this.I = new ah(this, null);
        }
        f.a();
        q();
        boolean a2 = f.a(a, i2, this.I);
        if (a2) {
            this.a.b(true);
            this.H = 2;
            this.q = System.currentTimeMillis();
            p();
            return a2;
        }
        this.H = 1;
        f.a();
        com.baidu.adp.lib.g.e.b("VoiceManager", "onTouch-getBtnMsgsendVoice", "user click too often");
        com.baidu.tieba.util.ac acVar = new com.baidu.tieba.util.ac();
        acVar.a("voiceType", Integer.valueOf(i2));
        by.b("", -1101, "onTouch-getBtnMsgsendVoice: user click too often", acVar.toString());
        this.a.b(false);
        return a2;
    }

    public void d() {
        f.b();
    }

    public void a(String str) {
        f();
        g();
        if (this.a != null) {
            this.a.b(str);
        }
        if (this.p != null) {
            this.p.postDelayed(new s(this, str), 200L);
        }
    }

    public static boolean a(int i2) {
        return i2 == 3;
    }

    public static boolean b(int i2) {
        return i2 == 2;
    }

    public boolean e() {
        return this.v != null && a(this.v.voice_status.intValue());
    }

    public boolean a(VoiceModel voiceModel) {
        return (this.v == null || voiceModel == null || this.v != voiceModel) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VoiceModel voiceModel) {
        x();
        voiceModel.voice_status = 1;
        ad m2 = m();
        if (m2 != null) {
            m2.a(voiceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VoiceModel voiceModel) {
        if (m) {
            if (a(voiceModel.voice_status.intValue())) {
                b(voiceModel);
                MediaService.stopPlay(this.d);
                return;
            }
            b(voiceModel);
            return;
        }
        try {
            if (a(voiceModel.voice_status.intValue())) {
                b(voiceModel);
                a.a();
            } else {
                b(voiceModel);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("VoiceManager", "setMsgWaiting", "error:" + e.getMessage());
            com.baidu.tieba.util.ac acVar = new com.baidu.tieba.util.ac();
            if (voiceModel != null) {
                acVar.a("id", voiceModel.getId());
                acVar.a("from", voiceModel.from);
            }
            by.b("", -1102, "VoiceManager.setPlayWaiting() error : " + e.toString(), acVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VoiceModel voiceModel) {
        try {
            if (this.A == null) {
                this.A = new ai(this, null);
            }
            String b = aj.b(voiceModel.getId());
            if (b == null) {
                b = this.E.a(voiceModel.getId(), voiceModel.from, this.A);
            }
            if (voiceModel.isLocal && b == null) {
                if (this.z == null) {
                    this.z = new ag(this, null);
                }
                this.z.a(5, ak.a(R.string.voice_err_no_file));
                com.baidu.tieba.util.ac acVar = new com.baidu.tieba.util.ac();
                if (voiceModel != null) {
                    acVar.a("id", voiceModel.getId());
                    acVar.a("from", voiceModel.from);
                }
                by.b("", -1103, "VoiceManager.setDownloading() error : record file not exists", acVar.toString());
            } else if (b != null) {
                a(voiceModel, b);
            } else {
                voiceModel.voice_status = 2;
                ad m2 = m();
                if (m2 != null) {
                    m2.a(voiceModel);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.ac acVar2 = new com.baidu.tieba.util.ac();
            if (voiceModel != null) {
                acVar2.a("id", voiceModel.getId());
                acVar2.a("from", voiceModel.from);
            }
            by.b("", -1104, "setMsgDownloading error: " + e.getMessage(), acVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ad m() {
        if (this.y == null) {
            return null;
        }
        ad realView = this.y.getRealView();
        if (realView == null) {
            return this.y;
        }
        return realView;
    }

    private void c(ad adVar) {
        this.y = adVar;
    }

    public void a(ad adVar) {
        if (adVar != null && a(adVar.getVoiceModel())) {
            c(adVar);
        }
    }

    public void b(ad adVar) {
        if (adVar != null) {
            if (this.p != null) {
                this.p.removeCallbacks(this.j);
            }
            this.M = false;
            VoiceModel voiceModel = adVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.r != null && this.r.booleanValue()) {
                    d(this.r.booleanValue());
                    this.r = null;
                }
                this.x = adVar;
                this.w = voiceModel;
                int i2 = 1;
                if (this.w.voice_status != null) {
                    i2 = this.w.voice_status.intValue();
                }
                if (this.v != null) {
                    this.v.curr_time = 0;
                    if (this.v == this.w) {
                        c(adVar);
                        this.v = this.w;
                        switch (i2) {
                            case 1:
                                d(this.v);
                                return;
                            case 2:
                            case 3:
                                c(this.v);
                                return;
                            default:
                                return;
                        }
                    }
                    c(this.v);
                    b(this.v);
                    if (this.p != null) {
                        this.p.removeCallbacks(this.u);
                        this.p.postDelayed(this.u, 300L);
                        return;
                    }
                    return;
                }
                c(adVar);
                this.v = this.w;
                d(this.v);
            }
        }
    }

    private void n() {
        if (this.s) {
            if (TiebaApplication.h().aj()) {
                k();
            } else {
                j();
            }
            this.s = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceModel voiceModel, String str) {
        try {
            if (this.z == null) {
                this.z = new ag(this, null);
            }
            if (!new File(str).exists()) {
                this.z.a(5, ak.a(R.string.voice_err_no_file));
                return;
            }
            v();
            p();
            n();
            if (m) {
                MediaService.preparePlay(this.d, str, voiceModel.duration, voiceModel.curr_time);
                voiceModel.curr_time = 0;
                return;
            }
            boolean a = a.a(str, this.z, voiceModel.curr_time);
            voiceModel.curr_time = 0;
            if (!a) {
                com.baidu.adp.lib.g.e.b("VoiceManager", "setMsgPlaying", "error: AmrAudioPlayer.start");
                com.baidu.tieba.util.ac acVar = new com.baidu.tieba.util.ac();
                acVar.a("file", str);
                if (voiceModel != null) {
                    acVar.a("id", voiceModel.getId());
                    acVar.a("from", voiceModel.from);
                }
                by.b("", -1101, "setMsgPlaying error: AmrAudioPlayer.start", acVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            ad m2 = m();
            if (m2 != null) {
                m2.a(voiceModel);
            }
            t();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("VoiceManager", "setMsgPlaying", "error:" + e.getMessage());
            com.baidu.tieba.util.ac acVar2 = new com.baidu.tieba.util.ac();
            acVar2.a("file", str);
            if (voiceModel != null) {
                acVar2.a("id", voiceModel.getId());
                acVar2.a("from", voiceModel.from);
            }
            by.b("", -1101, "setMsgPlaying error: " + e.getMessage(), acVar2.toString());
        }
    }

    private void o() {
        f();
        g();
        l();
        MediaService.stopMy(this.d);
        b((Context) this.d);
        if (this.E != null) {
            this.E.a();
        }
        if (this.p != null) {
            this.p.removeCallbacks(this.c);
            this.p.removeCallbacks(this.u);
            this.p.removeCallbacks(this.j);
            this.p.removeCallbacks(this.k);
        }
        if (this.v != null) {
            this.v.init();
        }
        if (this.w != null) {
            this.w.init();
        }
        this.d = null;
        this.a = null;
        this.y = null;
        this.x = null;
        this.v = null;
        this.w = null;
        this.p = null;
        this.G = null;
        this.g = null;
    }

    public void f() {
        this.q = 0L;
        f.a();
        if (this.p != null) {
            this.p.postDelayed(this.c, 100L);
        }
        q();
    }

    public void g() {
        if (this.v != null) {
            c(this.v);
        }
        if (!this.M) {
            q();
        }
    }

    private void p() {
        if (this.d != null && this.h == null) {
            this.h = ((PowerManager) this.d.getSystemService("power")).newWakeLock(6, "cn");
            this.h.acquire();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.h != null && this.h.isHeld()) {
            this.h.release();
            this.h = null;
        }
    }

    public void b(boolean z) {
        this.F = z;
    }

    public void a(Activity activity) {
        this.d = activity;
        this.p = new Handler();
        this.g = (AudioManager) activity.getSystemService("audio");
        this.e = (SensorManager) activity.getSystemService("sensor");
        this.f = this.e.getDefaultSensor(8);
        this.E = new com.baidu.tieba.voice.a.a(activity);
        this.v = null;
        this.w = null;
        if (m) {
            MediaService.initBroadcastReceivers(activity, this.P);
            MediaService.startMy(activity, null);
        }
        y();
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity) {
        this.s = true;
        a((Context) activity);
    }

    public void d(Activity activity) {
        a(activity, false);
    }

    public void a(Activity activity, boolean z) {
        if (z) {
            h();
        }
    }

    public void h() {
        b((Context) this.d);
        if (m) {
            if (this.v != null) {
                b(this.v);
                this.v = null;
            }
            MediaService.stopPlay(this.d);
            return;
        }
        g();
    }

    public void e(Activity activity) {
        h();
    }

    public void f(Activity activity) {
        h();
        l();
    }

    public void g(Activity activity) {
        o();
        if (m) {
            MediaService.unregisterReceiver(activity, this.P);
        }
    }

    public boolean i() {
        return this.H == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        if (str != null && i2 >= 1) {
            this.H = 3;
            new Thread(new v(this, str, i2)).start();
        }
    }

    private void r() {
        if (this.g != null) {
            if (J == null) {
                J = Boolean.valueOf(s());
            }
            if (K == null) {
                K = Integer.valueOf(this.g.getMode());
            }
            if (L == null) {
                if (K.intValue() == 3) {
                    L = Integer.valueOf(this.g.getStreamVolume(3));
                } else {
                    L = Integer.valueOf(this.g.getStreamVolume(0));
                }
            }
        }
    }

    private boolean s() {
        if (this.g == null) {
            return false;
        }
        try {
            return this.g.isSpeakerphoneOn();
        } catch (Throwable th) {
            by.b("", -1107, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (this.g != null) {
            try {
                this.g.setSpeakerphoneOn(z);
            } catch (Throwable th) {
                by.b("", -1107, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
            }
        }
    }

    public void j() {
        if (this.g != null && this.H != 2) {
            if (TiebaApplication.h().aj()) {
                d(false);
                return;
            }
            try {
                r();
                d(true);
                i = 3;
                u();
            } catch (Exception e) {
                e.printStackTrace();
                by.b("", -1107, "openSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    public void k() {
        if (this.g != null) {
            r();
            try {
                d(false);
                i = 0;
                u();
            } catch (Exception e) {
                e.printStackTrace();
                by.b("", -1107, "closeSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            if (this.d != null && (this.d instanceof Activity)) {
                this.d.setVolumeControlStream(i);
            }
        } catch (Exception e) {
            by.b("", -1108, "setVolumeControlStream exception: " + e.getMessage(), "");
        }
    }

    private void u() {
        if (this.d != null) {
            if (this.p != null) {
                this.p.removeCallbacks(this.j);
            }
            ad m2 = m();
            if (!this.M && this.v != null && a(this.v.voice_status.intValue()) && m2 != null) {
                this.M = true;
                if (m) {
                    MediaService.stopPlay(this.d);
                } else {
                    g();
                }
            }
        }
    }

    public void l() {
        this.M = false;
        if (this.g != null && ak.c()) {
            try {
                if (J != null && K != null && L != null) {
                    d(J.booleanValue());
                    i = 3;
                    J = null;
                    K = null;
                    L = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                by.b("", -1107, "restoreVoiceMode exception: " + e.getMessage(), "");
            }
        }
    }

    public void c(boolean z) {
        if (this.g != null && ak.c()) {
            if (this.B == null || this.B.booleanValue() != z) {
                this.B = Boolean.valueOf(z);
                if (this.p != null) {
                    this.p.removeCallbacks(this.k);
                    this.p.postDelayed(this.k, 300L);
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (!this.l && this.F) {
                float[] fArr = sensorEvent.values;
                if (sensorEvent.sensor.getType() == 8 && fArr.length > 0) {
                    float f = fArr[0];
                    if (f < D) {
                        c(false);
                    } else if (f > D) {
                        c(true);
                    }
                }
            }
        } finally {
            this.N = false;
        }
    }

    private void v() {
        if (!TiebaApplication.h().aj() && !this.t && this.f != null && ak.c()) {
            if (this.p != null) {
                this.p.removeCallbacks(this.O);
            }
            this.t = true;
            this.N = ak.a();
            this.e.registerListener(this, this.f, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.t) {
            try {
                if (this.e != null) {
                    this.e.unregisterListener(this, this.f);
                    this.e.unregisterListener(this);
                }
            } catch (Exception e) {
                by.b("", -1109, "unRegistSensor exception: " + e.getMessage(), "");
            }
            this.t = false;
        }
    }

    private void x() {
        if (this.p != null) {
            this.p.removeCallbacks(this.O);
            this.p.postDelayed(this.O, 1000L);
        }
    }

    private void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    private void b(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
                d(false);
                this.p.removeCallbacks(this.O);
                w();
            } catch (IllegalArgumentException e) {
            } catch (Exception e2) {
                by.b("", -1110, "unRegistPlugin exception: " + e2.getMessage(), "");
            }
        }
    }

    private void y() {
        if (this.g != null) {
            try {
                this.l = this.g.isWiredHeadsetOn();
                if (this.l) {
                    d(false);
                }
            } catch (Throwable th) {
                ac acVar = new ac(this, null);
                acVar.setSelfExecute(true);
                acVar.execute(new Void[0]);
                by.b("", -1111, "checkHeadsetPlug exception: " + th.getMessage(), "");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            this.l = intent.getIntExtra(SocialConstants.PARAM_STATE, 0) == 1;
            if (this.l) {
                d(false);
            }
        }
    }

    public static String c(int i2) {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (i2 <= 0) {
            return "0\"";
        }
        int i3 = i2 % 60;
        int i4 = i2 / 60;
        if (i4 > 0) {
            stringBuffer.append(i4).append("'");
        }
        if (i3 < 10) {
        }
        stringBuffer.append(i3).append("\"");
        return stringBuffer.toString();
    }
}
