package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements Runnable {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile f d;

    /* renamed from: a  reason: collision with root package name */
    private final c f4455a;
    private final Context b;
    private static final AtomicLong c = new AtomicLong(0);
    private static boolean e = true;
    private static volatile boolean f = false;

    public static f a(c cVar) {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f(cVar);
                }
            }
        }
        return d;
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
                String replace = file2.getName().replace(".xml", "");
                if (Build.VERSION.SDK_INT >= 24) {
                    a2.deleteSharedPreferences(replace);
                    return;
                }
                a2.getSharedPreferences(replace, 0).edit().clear().apply();
                l.c(file2);
            }
        } catch (Throwable th) {
        }
    }

    private f(c cVar) {
        this.f4455a = cVar == null ? p.h() : cVar;
        this.b = p.a();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("b_msg_id", -1);
                if (intExtra == 1) {
                    long longExtra = intent.getLongExtra("b_msg_time", -1L);
                    if (longExtra > 0) {
                        f.c.set(longExtra);
                    }
                } else if (intExtra == 2) {
                    try {
                        if (f.this.f4455a != null) {
                            f.this.f4455a.a();
                        }
                    } catch (Throwable th) {
                    }
                }
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
            } catch (Throwable th) {
            }
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
            } catch (Throwable th) {
            }
        }
    }

    public void c() {
        try {
            if (!g()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.get() >= 600000) {
                    c.set(currentTimeMillis);
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        a(currentTimeMillis);
                    }
                    com.bytedance.sdk.openadsdk.j.e.a(this, 10);
                }
            }
        } catch (Throwable th) {
            u.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean g() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.i.d().f());
    }

    public static boolean d() {
        return f;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.b)) {
            try {
                this.f4455a.a();
            } catch (Throwable th) {
            }
        } else if (!g()) {
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/settings/"), a(h()), new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.f.1
                @Override // com.bytedance.sdk.adnet.core.o.a
                public void a(o<JSONObject> oVar) {
                    JSONObject jSONObject;
                    String str;
                    if (oVar == null || oVar.f4049a == null) {
                        try {
                            f.this.f4455a.a();
                            return;
                        } catch (Throwable th2) {
                            return;
                        }
                    }
                    int optInt = oVar.f4049a.optInt("cypher", -1);
                    JSONObject jSONObject2 = oVar.f4049a;
                    if (optInt == 1) {
                        str = com.bytedance.sdk.openadsdk.core.a.b(oVar.f4049a.optString("message"), com.bytedance.sdk.openadsdk.core.b.a());
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                u.b("SdkSettingsHelper", "setting data : " + str.toString());
                                jSONObject2 = new JSONObject(str);
                            } catch (Throwable th3) {
                                u.a("SdkSettingsHelper", "setting data error: ", th3);
                            }
                        }
                        jSONObject = jSONObject2;
                    } else if (optInt == 2) {
                        str = aj.k(oVar.f4049a.optString("message"));
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                u.b("SdkSettingsHelper", "setting data1 : " + str.toString());
                                jSONObject = new JSONObject(str);
                            } catch (Throwable th4) {
                                u.a("SdkSettingsHelper", "setting data error2: ", th4);
                            }
                        }
                        jSONObject = jSONObject2;
                    } else {
                        jSONObject = jSONObject2;
                        str = null;
                    }
                    try {
                        f.this.a(str, oVar.pxS == null ? null : oVar.pxS.h);
                    } catch (Throwable th5) {
                    }
                    try {
                        if (!f.f) {
                            boolean unused = f.f = true;
                        }
                        f.this.f4455a.a(jSONObject);
                    } catch (Throwable th6) {
                    }
                    com.bytedance.sdk.openadsdk.g.a.a().b();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f.b();
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void b(o<JSONObject> oVar) {
                    try {
                        f.this.f4455a.a();
                    } catch (Throwable th2) {
                    }
                }
            }).setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i;
        try {
        } catch (Throwable th) {
            i = 1;
        }
        if (!TextUtils.isEmpty(str) && map != null) {
            int intValue = Integer.valueOf(map.get("active-control")).intValue();
            long longValue = Long.valueOf(map.get(TimeDisplaySetting.TIME_DISPLAY_SETTING)).longValue();
            String str2 = map.get("pst");
            String a2 = com.bytedance.sdk.openadsdk.i.g.b.a(str + intValue + longValue);
            if (a2 != null) {
                if (a2.equalsIgnoreCase(str2)) {
                    i = intValue;
                    g.a(i);
                }
            }
        }
        i = 1;
        g.a(i);
    }

    @NonNull
    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.b);
            if (a2 != null) {
                jSONObject.put("latitude", a2.f5126a);
                jSONObject.put("longitude", a2.b);
            }
        } catch (Exception e2) {
        }
        try {
            jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put("imei", k.d(this.b));
            jSONObject.put("oaid", y.a());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("conn_type", x.b(this.b));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "3.4.0.1");
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.downloadnew.a.a());
            jSONObject.put("package_name", aj.e());
            jSONObject.put("position", aj.a() ? 1 : 2);
            jSONObject.put("app_version", aj.g());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.i.d().f());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            String str = "";
            if (com.bytedance.sdk.openadsdk.core.i.d().f() != null) {
                str = com.bytedance.sdk.openadsdk.core.i.d().f().concat(String.valueOf(currentTimeMillis)).concat("3.4.0.1");
            }
            jSONObject.put("req_sign", j.a(str));
            u.c("isApplicationForeground", "app_version:" + aj.g() + "，vendor:" + Build.MANUFACTURER);
        } catch (Exception e3) {
        }
        return jSONObject;
    }

    private JSONObject a(JSONObject jSONObject) {
        return e ? aj.a(jSONObject) : jSONObject;
    }
}
