package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.ss.android.a.a.a.f {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f4700a;

    public b(Context context) {
        this.f4700a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.f
    public void a(@NonNull com.ss.android.a.a.d.d dVar) {
        u.b("LibEventLogger", "onV3Event: " + String.valueOf(dVar));
        a(dVar, true);
    }

    @Override // com.ss.android.a.a.a.f
    public void b(@NonNull com.ss.android.a.a.d.d dVar) {
        u.b("LibEventLogger", "onEvent: " + String.valueOf(dVar));
        a(dVar, false);
        d(dVar);
    }

    private void d(com.ss.android.a.a.d.d dVar) {
        if (dVar != null) {
            com.bytedance.sdk.openadsdk.j.e.a(a.a(dVar), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.ss.android.a.a.d.d f4701a;
        private com.bytedance.sdk.openadsdk.downloadnew.a.b.a b;
        private l c;

        public static a a(com.ss.android.a.a.d.d dVar) {
            return new a(dVar);
        }

        private a(com.ss.android.a.a.d.d dVar) {
            this.f4701a = dVar;
            if (this.f4701a != null && this.f4701a.d() != null) {
                String optString = this.f4701a.d().optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.b = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                        this.b.b(this.f4701a.b());
                        if (this.b != null) {
                            this.c = this.b.f4715a;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }

        private Context a() {
            return p.a();
        }

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && ("embeded_ad".equals(this.f4701a.a()) || "draw_ad".equals(this.f4701a.a()) || "draw_ad_landingpage".equals(this.f4701a.a()) || "banner_ad".equals(this.f4701a.a()) || "banner_call".equals(this.f4701a.a()) || "banner_ad_landingpage".equals(this.f4701a.a()) || "feed_call".equals(this.f4701a.a()) || "embeded_ad_landingpage".equals(this.f4701a.a()) || "interaction".equals(this.f4701a.a()) || "interaction_call".equals(this.f4701a.a()) || "interaction_landingpage".equals(this.f4701a.a()) || "slide_banner_ad".equals(this.f4701a.a()) || "splash_ad".equals(this.f4701a.a()) || "fullscreen_interstitial_ad".equals(this.f4701a.a()) || "splash_ad_landingpage".equals(this.f4701a.a()) || "rewarded_video".equals(this.f4701a.a()) || "rewarded_video_landingpage".equals(this.f4701a.a()) || "openad_sdk_download_complete_tag".equals(this.f4701a.a()) || "download_notification".equals(this.f4701a.a()) || "landing_h5_download_ad_button".equals(this.f4701a.a()) || "fullscreen_interstitial_ad_landingpage".equals(this.f4701a.a()) || "feed_video_middle_page".equals(this.f4701a.a()) || "stream".equals(this.f4701a.a()));
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f4701a != null) {
                    String a2 = this.f4701a.a();
                    u.f("LibEventLogger", "tag " + a2);
                    u.f("LibEventLogger", "label " + this.f4701a.b());
                    if (this.b != null && !TextUtils.isEmpty(this.b.b)) {
                        a2 = this.b.b;
                    }
                    if (!g.a(a2, this.f4701a.b(), this.c, new HashMap()) && this.b != null && this.c != null && !TextUtils.isEmpty(this.f4701a.a()) && !TextUtils.isEmpty(this.f4701a.b())) {
                        JSONObject e = b.e(this.f4701a);
                        String str = this.b.b;
                        if (a(this.f4701a.a()) && !"click".equals(this.f4701a.b())) {
                            com.bytedance.sdk.openadsdk.c.d.b(a(), this.c, str, this.f4701a.b(), e);
                        }
                    }
                }
            } catch (Throwable th) {
                u.a("LibEventLogger", "upload event log error", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject e(com.ss.android.a.a.d.d dVar) {
        JSONObject d;
        if (dVar != null && (d = dVar.d()) != null) {
            String optString = d.optString("ad_extra_data");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void a(com.ss.android.a.a.d.d dVar, boolean z) {
        TTDownloadEventLogger m = i.d().m();
        if (m != null && dVar != null) {
            if (!m.shouldFilterOpenSdkLog() || !f(dVar)) {
                if (z) {
                    m.onV3Event(dVar);
                } else {
                    m.onEvent(dVar);
                }
            }
        }
    }

    private boolean f(com.ss.android.a.a.d.d dVar) {
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
}
