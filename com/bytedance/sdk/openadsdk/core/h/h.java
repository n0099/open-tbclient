package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements Runnable {
    private static final AtomicBoolean c = new AtomicBoolean(false);
    @SuppressLint({"StaticFieldLeak"})
    private static volatile h d;

    /* renamed from: a  reason: collision with root package name */
    private final e f6587a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6588b;

    public static h a(e eVar) {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h(eVar);
                }
            }
        }
        return d;
    }

    private String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("dig.bdurl.net");
        }
        stringBuffer.append("/q?host=");
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("is.snssdk.com").append(",").append("pangolin.snssdk.com");
        }
        stringBuffer.append("&aid=").append("1371");
        return stringBuffer.toString();
    }

    private h(e eVar) {
        this.f6587a = eVar == null ? p.h() : eVar;
        this.f6588b = p.a();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.f6588b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.dnsSettingReceiver"));
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
            if (intent != null && intent.getIntExtra("b_msg_id", -1) == 1) {
                String stringExtra = intent.getStringExtra("b_msg_data");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        if (h.this.f6587a != null) {
                            h.this.f6587a.a(jSONObject);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str) && p.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.dnsSettingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_data", str);
                p.a().sendBroadcast(intent);
            } catch (Throwable th) {
            }
        }
    }

    public void a() {
        try {
            if (!c.getAndSet(true)) {
                com.bytedance.sdk.openadsdk.k.a.a().b(this, 10);
            }
        } catch (Throwable th) {
            u.a("SdkDnsHelper", "load sdk dns settings error: ", th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.f6588b)) {
            try {
                this.f6587a.a();
                c.set(false);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        new com.bytedance.sdk.adnet.b.f(0, a(null, null), (String) null, new p.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.h.1
            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                h.c.set(false);
                if (pVar == null || pVar.f6047a == null) {
                    try {
                        h.this.f6587a.a();
                        return;
                    } catch (Throwable th2) {
                        return;
                    }
                }
                JSONObject jSONObject = pVar.f6047a;
                try {
                    h.this.f6587a.a(jSONObject);
                } catch (Throwable th3) {
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    h.a(jSONObject.toString());
                }
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                h.c.set(false);
                try {
                    h.this.f6587a.a();
                } catch (Throwable th2) {
                }
            }
        }).setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6588b).d());
    }
}
