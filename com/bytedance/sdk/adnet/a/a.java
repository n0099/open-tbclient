package com.bytedance.sdk.adnet.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.sapi2.utils.SapiUtils;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.d.d;
import com.bytedance.sdk.adnet.d.g;
import com.bytedance.sdk.adnet.d.i;
import com.bytedance.sdk.adnet.d.j;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.bytedance.sdk.adnet.c.a, j.a {
    private static a poG;
    private final boolean c;
    private final Context j;
    private volatile boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private long g = 0;
    private long h = 0;
    private AtomicBoolean i = new AtomicBoolean(false);
    private volatile boolean k = false;
    final j poH = new j(Looper.getMainLooper(), this);

    public static a hX(Context context) {
        a aVar;
        synchronized (a.class) {
            if (poG == null) {
                poG = new a(context.getApplicationContext(), g.b(context));
                com.bytedance.sdk.adnet.a.a(poG);
            }
            aVar = poG;
        }
        return aVar;
    }

    private a(Context context, boolean z) {
        this.j = context;
        this.c = z;
    }

    public void a() {
        a(false);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.sdk.adnet.a.a$1] */
    public synchronized void a(boolean z) {
        if (this.c) {
            d(z);
        } else if (this.g <= 0) {
            try {
                new Thread("LoadDomainConfig4Other-Thread") { // from class: com.bytedance.sdk.adnet.a.a.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        a.this.b();
                    }
                }.start();
            } catch (Throwable th) {
            }
        }
    }

    public static void b(Context context) {
        a aVar = poG;
        if (aVar != null) {
            if (g.b(context)) {
                aVar.a(true);
            } else {
                aVar.a();
            }
        }
    }

    synchronized void b() {
        if (System.currentTimeMillis() - this.g > BdKVCache.MILLS_1Hour) {
            this.g = System.currentTimeMillis();
            try {
                if (f.esk().esl() != null) {
                    f.esk().esl().b();
                }
            } catch (Exception e) {
            }
        }
    }

    private void d(boolean z) {
        if (!this.f) {
            if (this.e) {
                this.e = false;
                this.g = 0L;
                this.h = 0L;
            }
            long j = z ? Constants.SYNC_MSG_DELAY_TIME : 43200000L;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g > j && currentTimeMillis - this.h > 120000) {
                boolean a2 = com.bytedance.sdk.adnet.d.f.a(this.j);
                if (!this.k || a2) {
                    b(a2);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.sdk.adnet.a.a$2] */
    public boolean b(final boolean z) {
        d.b("TNCManager", "doRefresh: updating state " + this.i.get());
        if (!this.i.compareAndSet(false, true)) {
            d.b("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z) {
            this.h = System.currentTimeMillis();
        }
        new Thread("AppConfigThread") { // from class: com.bytedance.sdk.adnet.a.a.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                a.this.c(z);
            }
        }.start();
        return true;
    }

    @Override // com.bytedance.sdk.adnet.d.j.a
    public void a(Message message) {
        switch (message.what) {
            case 101:
                this.f = false;
                this.g = System.currentTimeMillis();
                d.b("TNCManager", "doRefresh, succ");
                if (this.e) {
                    a();
                }
                this.i.set(false);
                return;
            case 102:
                this.f = false;
                if (this.e) {
                    a();
                }
                d.b("TNCManager", "doRefresh, error");
                this.i.set(false);
                return;
            default:
                return;
        }
    }

    public synchronized void c() {
        if (!this.k) {
            this.k = true;
            long j = this.j.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j <= currentTimeMillis) {
                currentTimeMillis = j;
            }
            this.g = currentTimeMillis;
            if (f.esk().esl() != null) {
                f.esk().esl().a();
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.c.a
    public String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    return f.esk().a(str);
                } catch (Throwable th) {
                    return str;
                }
            }
            try {
                if (this.c) {
                    c();
                } else {
                    b();
                }
                str = f.esk().a(str);
                return str;
            } catch (Throwable th2) {
                return str;
            }
        }
        return str;
    }

    void c(boolean z) {
        d.b("TNCManager", "doRefresh, actual request");
        c();
        this.f = true;
        if (!z) {
            this.poH.sendEmptyMessage(102);
            return;
        }
        try {
            e();
        } catch (Exception e) {
            this.i.set(false);
        }
    }

    public String[] esf() {
        String[] f = com.bytedance.sdk.adnet.a.esd().f();
        if (f == null || f.length <= 0) {
            return new String[0];
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(str);
            if (!"success".equals(jSONObject2.getString("message"))) {
                return false;
            }
            jSONObject = jSONObject2;
        } else if (!(obj instanceof JSONObject)) {
            jSONObject = null;
        } else {
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject != null) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("data");
            synchronized (this) {
                SharedPreferences.Editor edit = this.j.getSharedPreferences("ss_app_config", 0).edit();
                edit.putLong("last_refresh_time", System.currentTimeMillis());
                edit.apply();
            }
            if (f.esk().esl() != null) {
                f.esk().esl().a(jSONObject3);
            }
            return true;
        }
        return false;
    }

    private boolean e() {
        String[] esf = esf();
        if (esf != null && esf.length != 0) {
            a(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        String[] esf = esf();
        if (esf == null || esf.length <= i) {
            b(102);
            return;
        }
        String str = esf[i];
        if (TextUtils.isEmpty(str)) {
            b(102);
            return;
        }
        try {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                b(102);
            } else {
                new com.bytedance.sdk.adnet.b.f(0, b2, new JSONObject(), new p.a<JSONObject>() { // from class: com.bytedance.sdk.adnet.a.a.3
                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void a(p<JSONObject> pVar) {
                        JSONObject jSONObject = pVar.f6344a;
                        if (jSONObject == null) {
                            a.this.a(i + 1);
                            return;
                        }
                        String str2 = null;
                        try {
                            str2 = jSONObject.getString("message");
                        } catch (Exception e) {
                        }
                        if (!"success".equals(str2)) {
                            a.this.a(i + 1);
                            return;
                        }
                        try {
                            if (a.this.a(jSONObject)) {
                                a.this.b(101);
                            } else {
                                a.this.a(i + 1);
                            }
                        } catch (Exception e2) {
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void b(p<JSONObject> pVar) {
                        a.this.a(i + 1);
                    }
                }).setRetryPolicy(new com.bytedance.sdk.adnet.core.g().PT(10000).PU(0)).build(com.bytedance.sdk.adnet.a.hW(this.j));
            }
        } catch (Throwable th) {
            d.b("AppConfig", "try app config exception: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.poH != null) {
            this.poH.sendEmptyMessage(i);
        }
    }

    private String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SapiUtils.COOKIE_HTTPS_URL_PREFIX).append(str).append("/get_domains/v4/");
        Address a2 = com.bytedance.sdk.adnet.a.esd().a(this.j);
        i iVar = new i(sb.toString());
        if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
            iVar.d("latitude", a2.getLatitude());
            iVar.d("longitude", a2.getLongitude());
            String locality = a2.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                iVar.a("city", Uri.encode(locality));
            }
        }
        if (this.d) {
            iVar.a("force", 1);
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str2 = Build.CPU_ABI;
            } else {
                str2 = Build.SUPPORTED_ABIS[0];
            }
            iVar.a("abi", str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        iVar.a("aid", com.bytedance.sdk.adnet.a.esd().a());
        iVar.a("device_platform", com.bytedance.sdk.adnet.a.esd().c());
        iVar.a("channel", com.bytedance.sdk.adnet.a.esd().b());
        iVar.a("version_code", com.bytedance.sdk.adnet.a.esd().d());
        iVar.a("device_id", com.bytedance.sdk.adnet.a.esd().e());
        return iVar.toString();
    }
}
