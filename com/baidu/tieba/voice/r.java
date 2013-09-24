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
import com.baidu.tieba.voice.service.MediaService;
import com.slidingmenu.lib.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/* loaded from: classes.dex */
public class r extends BroadcastReceiver implements SensorEventListener {
    private static Boolean J;
    private static Integer K;
    private static Integer L;
    private Boolean A;
    private com.baidu.tieba.voice.a.a D;

    /* renamed from: a  reason: collision with root package name */
    ad f2041a;
    Activity d;
    AudioManager g;
    private Handler p;
    private Boolean r;
    private boolean s;
    private ac w;
    private ac x;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static float B = 4.294967E9f;
    private static float C = 0.5f;
    public static int i = 3;
    String b = null;
    private long q = 0;
    private Runnable t = new s(this);
    private ai u = null;
    private ai v = null;
    private af y = null;
    private ah z = null;
    Runnable c = new t(this);
    SensorManager e = null;
    Sensor f = null;
    private boolean E = true;
    PowerManager.WakeLock h = null;
    private Handler F = new Handler();
    private Runnable G = new u(this);
    private int H = 1;
    private q I = null;
    private boolean M = false;
    Runnable j = new v(this);
    Runnable k = new w(this);
    private boolean N = true;
    boolean l = false;
    private BroadcastReceiver O = new x(this);

    public static synchronized void a() {
        synchronized (r.class) {
            if (!n) {
                o = com.baidu.tieba.sharedPref.b.a().a("voice_use_soft_decoder", ak.b());
            }
        }
    }

    public static boolean b() {
        return o;
    }

    public static void a(boolean z) {
        o = z || ak.b();
        com.baidu.tieba.sharedPref.b.a().b("voice_use_soft_decoder", o);
    }

    public static r c() {
        return new r();
    }

    public r() {
        a();
        m = b() ? false : true;
    }

    public boolean a(ad adVar, int i2) {
        if (adVar == null) {
            return false;
        }
        this.f2041a = adVar;
        if (!com.baidu.tieba.util.p.a()) {
            String b = com.baidu.tieba.util.p.b();
            if (b == null) {
                b = this.d.getString(R.string.voice_error_sdcard);
            }
            this.f2041a.a(0, b);
            return false;
        }
        e();
        this.b = aj.a();
        String a2 = aj.a(this.b);
        if (this.I == null) {
            this.I = new ag(this, null);
        }
        e.a();
        o();
        if (this.g != null) {
            this.r = Boolean.valueOf(q());
            this.g.setSpeakerphoneOn(false);
        }
        boolean a3 = e.a(a2, i2, this.I);
        if (a3) {
            this.f2041a.a(true);
            this.H = 2;
            this.q = System.currentTimeMillis();
            n();
            return a3;
        }
        this.H = 1;
        e.a();
        com.baidu.adp.lib.f.d.b("VoiceManager", "onTouch-getBtnMsgsendVoice", "user click too often");
        this.f2041a.a(false);
        return a3;
    }

    public void a(String str) {
        e();
        if (this.f2041a != null) {
            this.f2041a.a(str);
        }
        if (this.p != null) {
            this.p.postDelayed(new y(this, str), 200L);
        }
    }

    public static boolean a(int i2) {
        return i2 == 3;
    }

    public static boolean b(int i2) {
        return i2 == 2;
    }

    public boolean a(ai aiVar) {
        return (this.u == null || aiVar == null || this.u != aiVar) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ai aiVar) {
        aiVar.h = 1;
        ac k = k();
        if (k != null) {
            k.a(aiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ai aiVar) {
        if (m) {
            if (a(aiVar.h.intValue())) {
                b(aiVar);
                MediaService.stopPlay(this.d);
                return;
            }
            b(aiVar);
            return;
        }
        try {
            if (a(aiVar.h.intValue())) {
                b(aiVar);
                a.a();
            } else {
                b(aiVar);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.f.d.b("VoiceManager", "setMsgWaiting", "error:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ai aiVar) {
        try {
            if (this.z == null) {
                this.z = new ah(this, null);
            }
            String b = aj.b(aiVar.a());
            if (b == null) {
                b = this.D.a(aiVar.a(), aiVar.f2028a, this.z);
            }
            if (aiVar.c && b == null) {
                if (this.y == null) {
                    this.y = new af(this, null);
                }
                this.y.a(5, ak.a(R.string.voice_err_no_file));
            } else if (b != null) {
                a(aiVar, b);
            } else {
                aiVar.h = 2;
                ac k = k();
                if (k != null) {
                    k.a(aiVar);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.f.d.b("VoiceManager", "setMsgDownloading", "error:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ac k() {
        if (this.x == null) {
            return null;
        }
        ac realView = this.x.getRealView();
        if (realView == null) {
            return this.x;
        }
        return realView;
    }

    private void c(ac acVar) {
        this.x = acVar;
    }

    public void a(ac acVar) {
        if (acVar != null && a(acVar.getVoiceModel())) {
            c(acVar);
        }
    }

    public void b(ac acVar) {
        if (acVar != null) {
            if (this.p != null) {
                this.p.removeCallbacks(this.j);
            }
            this.M = false;
            ai voiceModel = acVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.r != null && this.r.booleanValue()) {
                    d(this.r.booleanValue());
                    this.r = null;
                }
                this.w = acVar;
                this.v = voiceModel;
                int i2 = 1;
                if (this.v.h != null) {
                    i2 = this.v.h.intValue();
                }
                if (this.u != null) {
                    this.u.g = 0;
                    if (this.u == this.v) {
                        c(acVar);
                        this.u = this.v;
                        switch (i2) {
                            case 1:
                                d(this.u);
                                return;
                            case 2:
                            case 3:
                                c(this.u);
                                return;
                            default:
                                return;
                        }
                    }
                    c(this.u);
                    b(this.u);
                    if (this.p != null) {
                        this.p.removeCallbacks(this.t);
                        this.p.postDelayed(this.t, 300L);
                        return;
                    }
                    return;
                }
                c(acVar);
                this.u = this.v;
                d(this.u);
            }
        }
    }

    private void l() {
        if (this.s) {
            h();
            this.s = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar, String str) {
        try {
            if (this.y == null) {
                this.y = new af(this, null);
            }
            if (!new File(str).exists()) {
                this.y.a(5, ak.a(R.string.voice_err_no_file));
                return;
            }
            n();
            l();
            if (m) {
                MediaService.preparePlay(this.d, str, aiVar.d, aiVar.g);
                aiVar.g = 0;
                return;
            }
            boolean a2 = a.a(str, this.y, aiVar.g);
            aiVar.g = 0;
            if (!a2) {
                com.baidu.adp.lib.f.d.b("VoiceManager", "setMsgPlaying", "error: AmrAudioPlayer.start");
                return;
            }
            aiVar.h = 3;
            ac k = k();
            if (k != null) {
                k.a(aiVar);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.f.d.b("VoiceManager", "setMsgPlaying", "error:" + e.getMessage());
        }
    }

    private void m() {
        d();
        e();
        j();
        MediaService.stopMy(this.d);
        b((Context) this.d);
        if (this.D != null) {
            this.D.a();
        }
        if (this.F != null) {
            this.F.removeCallbacks(this.G);
        }
        if (this.p != null) {
            this.p.removeCallbacks(this.c);
            this.p.removeCallbacks(this.t);
            this.p.removeCallbacks(this.j);
            this.p.removeCallbacks(this.k);
        }
        if (this.u != null) {
            this.u.b();
        }
        if (this.v != null) {
            this.v.b();
        }
        this.d = null;
        this.f2041a = null;
        this.x = null;
        this.w = null;
        this.u = null;
        this.v = null;
        this.p = null;
        this.F = null;
        this.g = null;
    }

    public void d() {
        this.q = 0L;
        e.a();
        if (this.p != null) {
            this.p.postDelayed(this.c, 100L);
        }
        o();
    }

    public void e() {
        if (this.u != null) {
            c(this.u);
        }
        if (!this.M) {
            o();
        }
    }

    private void n() {
        if (this.d != null && this.h == null) {
            this.h = ((PowerManager) this.d.getSystemService("power")).newWakeLock(6, "cn");
            this.h.acquire();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.h != null && this.h.isHeld()) {
            this.h.release();
            this.h = null;
        }
    }

    public void b(boolean z) {
        this.E = z;
    }

    public void a(Activity activity) {
        this.d = activity;
        this.p = new Handler();
        this.g = (AudioManager) activity.getSystemService("audio");
        this.e = (SensorManager) activity.getSystemService("sensor");
        this.f = this.e.getDefaultSensor(8);
        this.D = new com.baidu.tieba.voice.a.a(activity);
        this.u = null;
        this.v = null;
        if (m) {
            MediaService.initBroadcastReceivers(activity, this.O);
            MediaService.startMy(activity, null);
        }
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
            f();
        }
    }

    public void f() {
        b((Context) this.d);
        if (m) {
            if (this.u != null) {
                b(this.u);
                this.u = null;
            }
            MediaService.stopPlay(this.d);
            return;
        }
        e();
    }

    public void e(Activity activity) {
        f();
    }

    public void f(Activity activity) {
        f();
        j();
    }

    public void g(Activity activity) {
        m();
        if (m) {
            MediaService.unregisterReceiver(activity, this.O);
        }
    }

    public boolean g() {
        return this.H == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        if (str != null && i2 >= 1) {
            this.H = 3;
            new Thread(new z(this, str, i2)).start();
        }
    }

    private void p() {
        if (this.g != null) {
            if (J == null) {
                J = Boolean.valueOf(q());
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

    private boolean q() {
        if (this.g == null) {
            return false;
        }
        try {
            return this.g.isSpeakerphoneOn();
        } catch (Throwable th) {
            return false;
        }
    }

    private void d(boolean z) {
        if (this.g != null) {
            try {
                this.g.setSpeakerphoneOn(z);
            } catch (Throwable th) {
            }
        }
    }

    public void h() {
        if (this.g != null && this.H != 2) {
            try {
                p();
                d(true);
                i = 3;
                r();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void i() {
        if (this.g != null) {
            p();
            try {
                d(false);
                i = 0;
                r();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void r() {
        if (this.d != null) {
            if (this.p != null) {
                this.p.removeCallbacks(this.j);
            }
            ac k = k();
            if (!this.M && this.u != null && a(this.u.h.intValue()) && k != null) {
                this.M = true;
                if (m) {
                    MediaService.stopPlay(this.d);
                } else {
                    e();
                }
            }
        }
    }

    public void j() {
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
            }
        }
    }

    public void c(boolean z) {
        if (this.g != null && ak.c()) {
            if (this.A == null || this.A.booleanValue() != z) {
                this.A = Boolean.valueOf(z);
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
            if (!this.l && !this.N && this.E) {
                float[] fArr = sensorEvent.values;
                if (sensorEvent.sensor.getType() == 8 && fArr.length > 0) {
                    float f = fArr[0];
                    if (f < B) {
                        B = f;
                        C = 0.5f + f;
                    }
                    if (f < C) {
                        c(false);
                    } else if (f > C) {
                        c(true);
                    }
                }
            }
        } finally {
            this.N = false;
        }
    }

    private void s() {
        if (this.f != null && ak.c()) {
            this.N = ak.a();
            this.e.registerListener(this, this.f, 3);
        }
    }

    private void t() {
        try {
            if (this.e != null) {
                this.e.unregisterListener(this, this.f);
                this.e.unregisterListener(this);
            }
        } catch (Exception e) {
        }
    }

    private void a(Context context) {
        u();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
        s();
    }

    private void b(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
                d(false);
                t();
            } catch (Exception e) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1623=4, 1624=4] */
    private void u() {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/sys/class/switch/h2w/state");
            try {
                char[] cArr = new char[1024];
                this.l = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
                if (this.l) {
                    d(false);
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                fileReader2 = fileReader;
                th = th;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            fileReader = null;
        } catch (Exception e8) {
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            this.l = intent.getIntExtra("state", 0) == 1;
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
        stringBuffer.append(i3).append("\"");
        return stringBuffer.toString();
    }
}
