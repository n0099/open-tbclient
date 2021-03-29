package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements d.o.a.a.a.a.f {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f29180a;

    /* loaded from: classes6.dex */
    public static class a extends g {

        /* renamed from: a  reason: collision with root package name */
        public final d.o.a.a.a.d.d f29181a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.downloadnew.a.b.a f29182b;

        /* renamed from: c  reason: collision with root package name */
        public l f29183c;

        public a(d.o.a.a.a.d.d dVar) {
            super("LogTask");
            this.f29181a = dVar;
            if (dVar == null || dVar.d() == null) {
                return;
            }
            String optString = this.f29181a.d().optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                this.f29182b = a2;
                a2.b(this.f29181a.b());
                if (this.f29182b != null) {
                    this.f29183c = this.f29182b.f29214a;
                }
            } catch (Exception unused) {
            }
        }

        public static a a(d.o.a.a.a.d.d dVar) {
            return new a(dVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f29181a == null) {
                    return;
                }
                String a2 = this.f29181a.a();
                u.f("LibEventLogger", "tag " + a2);
                u.f("LibEventLogger", "label " + this.f29181a.b());
                if (this.f29182b != null && !TextUtils.isEmpty(this.f29182b.f29215b)) {
                    a2 = this.f29182b.f29215b;
                }
                if (!com.bytedance.sdk.openadsdk.downloadnew.a.g.a(a2, this.f29181a.b(), this.f29183c, new HashMap()) && this.f29182b != null && this.f29183c != null && !TextUtils.isEmpty(this.f29181a.a()) && !TextUtils.isEmpty(this.f29181a.b())) {
                    JSONObject e2 = b.e(this.f29181a);
                    String str = this.f29182b.f29215b;
                    if (!a(this.f29181a.a()) || PrefetchEvent.STATE_CLICK.equals(this.f29181a.b())) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.c.d.b(a(), this.f29183c, str, this.f29181a.b(), e2);
                }
            } catch (Throwable th) {
                u.a("LibEventLogger", "upload event log error", th);
            }
        }

        private Context a() {
            return p.a();
        }

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && ("embeded_ad".equals(this.f29181a.a()) || "draw_ad".equals(this.f29181a.a()) || "draw_ad_landingpage".equals(this.f29181a.a()) || "banner_ad".equals(this.f29181a.a()) || "banner_call".equals(this.f29181a.a()) || "banner_ad_landingpage".equals(this.f29181a.a()) || "feed_call".equals(this.f29181a.a()) || "embeded_ad_landingpage".equals(this.f29181a.a()) || "interaction".equals(this.f29181a.a()) || "interaction_call".equals(this.f29181a.a()) || "interaction_landingpage".equals(this.f29181a.a()) || "slide_banner_ad".equals(this.f29181a.a()) || "splash_ad".equals(this.f29181a.a()) || "fullscreen_interstitial_ad".equals(this.f29181a.a()) || "splash_ad_landingpage".equals(this.f29181a.a()) || "rewarded_video".equals(this.f29181a.a()) || "rewarded_video_landingpage".equals(this.f29181a.a()) || "openad_sdk_download_complete_tag".equals(this.f29181a.a()) || "download_notification".equals(this.f29181a.a()) || "landing_h5_download_ad_button".equals(this.f29181a.a()) || "fullscreen_interstitial_ad_landingpage".equals(this.f29181a.a()) || "feed_video_middle_page".equals(this.f29181a.a()) || "stream".equals(this.f29181a.a()));
        }
    }

    public b(Context context) {
        this.f29180a = new WeakReference<>(context);
    }

    private void d(d.o.a.a.a.d.d dVar) {
        if (dVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.e.a(a.a(dVar), 5);
    }

    public static JSONObject e(d.o.a.a.a.d.d dVar) {
        JSONObject d2;
        if (dVar == null || (d2 = dVar.d()) == null) {
            return null;
        }
        String optString = d2.optString("ad_extra_data");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            return new JSONObject(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean f(d.o.a.a.a.d.d dVar) {
        dVar.c();
        if (dVar == null) {
            return false;
        }
        String dVar2 = dVar.toString();
        if (TextUtils.isEmpty(dVar2)) {
            return false;
        }
        return dVar2.contains("open_ad_sdk_download_extra");
    }

    @Override // d.o.a.a.a.a.f
    public void a(@NonNull d.o.a.a.a.d.d dVar) {
        u.b("LibEventLogger", "onV3Event: " + String.valueOf(dVar));
        a(dVar, true);
    }

    @Override // d.o.a.a.a.a.f
    public void b(@NonNull d.o.a.a.a.d.d dVar) {
        u.b("LibEventLogger", "onEvent: " + String.valueOf(dVar));
        a(dVar, false);
        d(dVar);
    }

    private void a(d.o.a.a.a.d.d dVar, boolean z) {
        TTDownloadEventLogger o = i.d().o();
        if (o == null || dVar == null) {
            return;
        }
        if (o.shouldFilterOpenSdkLog() && f(dVar)) {
            return;
        }
        if (z) {
            o.onV3Event(dVar);
        } else {
            o.onEvent(dVar);
        }
    }
}
