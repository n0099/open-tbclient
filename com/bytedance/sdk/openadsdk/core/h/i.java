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
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i implements Runnable {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile i d;

    /* renamed from: a  reason: collision with root package name */
    private final e f6589a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6590b;
    private static final AtomicLong c = new AtomicLong(0);
    private static boolean e = true;
    private static volatile boolean f = false;

    public static i a(e eVar) {
        if (d == null) {
            synchronized (i.class) {
                if (d == null) {
                    d = new i(eVar);
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
                com.bytedance.sdk.openadsdk.utils.l.c(file2);
            }
        } catch (Throwable th) {
        }
    }

    private i(e eVar) {
        this.f6589a = eVar == null ? p.h() : eVar;
        this.f6590b = p.a();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.f6590b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        i.c.set(longExtra);
                    }
                } else if (intExtra == 2) {
                    try {
                        if (i.this.f6589a != null) {
                            i.this.f6589a.a();
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
                    com.bytedance.sdk.openadsdk.k.a.a().b(this, 10);
                }
            }
        } catch (Throwable th) {
            u.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean g() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.i.c().e());
    }

    public static boolean d() {
        return f;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.f6590b)) {
            try {
                this.f6589a.a();
            } catch (Throwable th) {
            }
        } else if (!g()) {
            new com.bytedance.sdk.adnet.b.f(1, aj.q("/api/ad/union/sdk/settings/"), a(h()), new p.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.i.1
                @Override // com.bytedance.sdk.adnet.core.p.a
                public void a(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                    JSONObject jSONObject;
                    String str;
                    if (pVar == null || pVar.f6045a == null) {
                        try {
                            i.this.f6589a.a();
                            return;
                        } catch (Throwable th2) {
                            return;
                        }
                    }
                    int optInt = pVar.f6045a.optInt("cypher", -1);
                    JSONObject jSONObject2 = pVar.f6045a;
                    if (optInt == 1) {
                        str = com.bytedance.sdk.openadsdk.core.a.b(pVar.f6045a.optString("message"), com.bytedance.sdk.openadsdk.core.b.a());
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
                        str = aj.k(pVar.f6045a.optString("message"));
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
                        i.this.a(str, pVar.pkY == null ? null : pVar.pkY.h);
                    } catch (Throwable th5) {
                    }
                    try {
                        if (!i.f) {
                            boolean unused = i.f = true;
                        }
                        i.this.f6589a.a(jSONObject);
                    } catch (Throwable th6) {
                    }
                    com.bytedance.sdk.openadsdk.h.a.a().b();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        i.b();
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void b(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                    try {
                        i.this.f6589a.a();
                    } catch (Throwable th2) {
                    }
                }
            }).setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6590b).d());
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
            String a2 = com.bytedance.sdk.openadsdk.j.g.b.a(str + intValue + longValue);
            if (a2 != null) {
                if (a2.equalsIgnoreCase(str2)) {
                    i = intValue;
                    j.a(i);
                }
            }
        }
        i = 1;
        j.a(i);
    }

    @NonNull
    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.f6590b);
            if (a2 != null) {
                jSONObject.put("latitude", a2.f7564a);
                jSONObject.put("longitude", a2.f7565b);
            }
        } catch (Exception e2) {
        }
        try {
            jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.k.d(this.f6590b));
            jSONObject.put("oaid", y.a());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("conn_type", x.b(this.f6590b));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "3.2.5.1");
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.downloadnew.a.a());
            jSONObject.put("package_name", aj.d());
            jSONObject.put("position", aj.c(this.f6590b, aj.d()) ? 1 : 2);
            jSONObject.put("app_version", aj.f());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.i.c().e());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            String str = "";
            if (com.bytedance.sdk.openadsdk.core.i.c().e() != null) {
                str = com.bytedance.sdk.openadsdk.core.i.c().e().concat(String.valueOf(currentTimeMillis)).concat("3.2.5.1");
            }
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
            u.c("isApplicationForeground", "app_version:" + aj.f() + "，vendor:" + Build.MANUFACTURER);
        } catch (Exception e3) {
        }
        return jSONObject;
    }

    private JSONObject a(JSONObject jSONObject) {
        return e ? aj.a(jSONObject) : jSONObject;
    }
}
