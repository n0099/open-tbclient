package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import com.xiaomi.mipush.sdk.Constants;
import d.c.c.b.d.o;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends com.bytedance.sdk.openadsdk.l.g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f28100d;

    /* renamed from: a  reason: collision with root package name */
    public final c f28103a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28104b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicLong f28099c = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    public static boolean f28101e = true;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f28102f = false;

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    f.f28099c.set(longExtra);
                }
            } else if (intExtra == 2) {
                try {
                    if (f.this.f28103a != null) {
                        f.this.f28103a.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public f(c cVar) {
        super("SdkSettingsHelper");
        this.f28103a = cVar == null ? p.h() : cVar;
        this.f28104b = p.a();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.f28104b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (p.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                p.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean d() {
        return f28102f;
    }

    private boolean i() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.i.d().g());
    }

    @NonNull
    private JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.f28104b);
            if (a2 != null) {
                jSONObject.put("latitude", a2.f30082a);
                jSONObject.put("longitude", a2.f30083b);
            }
        } catch (Exception unused) {
        }
        try {
            int i = 1;
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put("imei", k.d(this.f28104b));
            jSONObject.put("oaid", y.a());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("conn_type", x.b(this.f28104b));
            jSONObject.put(IAdRequestParam.OS, 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", "3.4.5.5");
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.downloadnew.a.a());
            jSONObject.put("package_name", ak.e());
            if (!ak.a()) {
                i = 2;
            }
            jSONObject.put("position", i);
            jSONObject.put("app_version", ak.g());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(Constants.APP_ID, com.bytedance.sdk.openadsdk.core.i.d().g());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", j.a(com.bytedance.sdk.openadsdk.core.i.d().g() != null ? com.bytedance.sdk.openadsdk.core.i.d().g().concat(String.valueOf(currentTimeMillis)).concat("3.4.5.5") : ""));
            u.c("isApplicationForeground", "app_version:" + ak.g() + "，vendor:" + Build.MANUFACTURER);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public void c() {
        try {
            if (i()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f28099c.get() < 600000) {
                return;
            }
            f28099c.set(currentTimeMillis);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a(currentTimeMillis);
            }
            com.bytedance.sdk.openadsdk.l.e.a(this, 10);
        } catch (Throwable th) {
            u.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.f28104b)) {
            try {
                this.f28103a.a();
            } catch (Throwable unused) {
            }
        } else if (i()) {
        } else {
            new d.c.c.b.b.f(1, ak.l("/api/ad/union/sdk/settings/"), a(j()), new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.f.1
                /* JADX WARN: Can't wrap try/catch for region: R(12:4|(11:6|(2:8|9)|14|15|(1:17)(1:32)|18|19|20|(1:22)|24|(2:26|27)(1:29))(11:34|(2:36|(2:38|39))(1:43)|14|15|(0)(0)|18|19|20|(0)|24|(0)(0))|10|14|15|(0)(0)|18|19|20|(0)|24|(0)(0)) */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0064 A[Catch: all -> 0x006d, TryCatch #4 {all -> 0x006d, blocks: (B:22:0x005f, B:26:0x0068, B:25:0x0064), top: B:48:0x005f }] */
                /* JADX WARN: Removed duplicated region for block: B:29:0x007c A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #3 {all -> 0x0087, blocks: (B:27:0x006d, B:29:0x007c), top: B:46:0x006d }] */
                /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
                /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
                @Override // d.c.c.b.d.o.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(o<JSONObject> oVar) {
                    JSONObject jSONObject;
                    String str;
                    JSONObject jSONObject2;
                    if (oVar == null || (jSONObject = oVar.f66584a) == null) {
                        try {
                            f.this.f28103a.a();
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    int optInt = jSONObject.optInt("cypher", -1);
                    JSONObject jSONObject3 = oVar.f66584a;
                    JSONObject jSONObject4 = jSONObject3;
                    Map<String, String> map = null;
                    if (optInt == 1) {
                        str = com.bytedance.sdk.openadsdk.core.a.b(jSONObject3.optString("message"), com.bytedance.sdk.openadsdk.core.b.a());
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject2 = new JSONObject(str);
                            } catch (Throwable th) {
                                u.a("SdkSettingsHelper", "setting data error: ", th);
                            }
                        }
                        if (oVar.f66585b != null) {
                            map = oVar.f66585b.f66615h;
                        }
                        f.this.a(str, map);
                        f.this.f28103a.a(jSONObject4);
                        if (!f.f28102f) {
                            boolean unused3 = f.f28102f = true;
                            b.a().b();
                        }
                        com.bytedance.sdk.openadsdk.h.a.a().b();
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            f.b();
                            return;
                        }
                        return;
                    }
                    if (optInt == 2) {
                        str = ak.k(jSONObject3.optString("message"));
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject2 = new JSONObject(str);
                            } catch (Throwable th2) {
                                u.a("SdkSettingsHelper", "setting data error2: ", th2);
                            }
                        }
                    } else {
                        str = null;
                    }
                    if (oVar.f66585b != null) {
                    }
                    f.this.a(str, map);
                    f.this.f28103a.a(jSONObject4);
                    if (!f.f28102f) {
                    }
                    com.bytedance.sdk.openadsdk.h.a.a().b();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    }
                    jSONObject4 = jSONObject2;
                    if (oVar.f66585b != null) {
                    }
                    f.this.a(str, map);
                    f.this.f28103a.a(jSONObject4);
                    if (!f.f28102f) {
                    }
                    com.bytedance.sdk.openadsdk.h.a.a().b();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    }
                }

                @Override // d.c.c.b.d.o.a
                public void b(o<JSONObject> oVar) {
                    try {
                        f.this.f28103a.a();
                    } catch (Throwable unused2) {
                    }
                }
            }).setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.c().e());
        }
    }

    public static f a(c cVar) {
        if (f28100d == null) {
            synchronized (f.class) {
                if (f28100d == null) {
                    f28100d = new f(cVar);
                }
            }
        }
        return f28100d;
    }

    public static void a() {
        File file;
        try {
            Context a2 = p.a();
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(a2.getDataDir(), "shared_prefs");
            } else {
                file = new File(a2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(ActivityChooserModel.HISTORY_FILE_EXTENSION, "");
                if (Build.VERSION.SDK_INT >= 24) {
                    a2.deleteSharedPreferences(replace);
                    return;
                }
                a2.getSharedPreferences(replace, 0).edit().clear().apply();
                l.c(file2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j) {
        if (j > 0 && p.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                p.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                int intValue = Integer.valueOf(map.get("active-control")).intValue();
                long longValue = Long.valueOf(map.get("ts")).longValue();
                String str2 = map.get("pst");
                String a2 = com.bytedance.sdk.openadsdk.k.g.b.a(str + intValue + longValue);
                if (a2 != null) {
                    if (a2.equalsIgnoreCase(str2)) {
                        i = intValue;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        g.a(i);
    }

    private JSONObject a(JSONObject jSONObject) {
        return f28101e ? ak.a(jSONObject) : jSONObject;
    }
}
