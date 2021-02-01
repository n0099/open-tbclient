package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.ss.android.a.a.a.f {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f7061a;

    public b(Context context) {
        this.f7061a = new WeakReference<>(context);
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
            com.bytedance.sdk.openadsdk.k.a.a().d(a.a(dVar), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.ss.android.a.a.d.d f7062a;

        /* renamed from: b  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.downloadnew.a.b.a f7063b;
        private l c;

        public static a a(com.ss.android.a.a.d.d dVar) {
            return new a(dVar);
        }

        private a(com.ss.android.a.a.d.d dVar) {
            this.f7062a = dVar;
            if (this.f7062a != null && this.f7062a.d() != null) {
                String optString = this.f7062a.d().optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.f7063b = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                        this.f7063b.b(this.f7062a.b());
                        if (this.f7063b != null) {
                            this.c = this.f7063b.f7094a;
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
            return !TextUtils.isEmpty(str) && ("embeded_ad".equals(this.f7062a.a()) || "draw_ad".equals(this.f7062a.a()) || "draw_ad_landingpage".equals(this.f7062a.a()) || "banner_ad".equals(this.f7062a.a()) || "banner_call".equals(this.f7062a.a()) || "banner_ad_landingpage".equals(this.f7062a.a()) || "feed_call".equals(this.f7062a.a()) || "embeded_ad_landingpage".equals(this.f7062a.a()) || "interaction".equals(this.f7062a.a()) || "interaction_call".equals(this.f7062a.a()) || "interaction_landingpage".equals(this.f7062a.a()) || "slide_banner_ad".equals(this.f7062a.a()) || "splash_ad".equals(this.f7062a.a()) || "fullscreen_interstitial_ad".equals(this.f7062a.a()) || "splash_ad_landingpage".equals(this.f7062a.a()) || "rewarded_video".equals(this.f7062a.a()) || "rewarded_video_landingpage".equals(this.f7062a.a()) || "openad_sdk_download_complete_tag".equals(this.f7062a.a()) || "download_notification".equals(this.f7062a.a()) || "landing_h5_download_ad_button".equals(this.f7062a.a()) || "fullscreen_interstitial_ad_landingpage".equals(this.f7062a.a()));
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f7062a != null) {
                    String a2 = this.f7062a.a();
                    u.f("LibEventLogger", "tag " + a2);
                    u.f("LibEventLogger", "label " + this.f7062a.b());
                    if (this.f7063b != null && !TextUtils.isEmpty(this.f7063b.f7095b)) {
                        a2 = this.f7063b.f7095b;
                    }
                    if (!com.bytedance.sdk.openadsdk.downloadnew.a.e.a(a2, this.f7062a.b(), this.c, new HashMap()) && this.f7063b != null && this.c != null && !TextUtils.isEmpty(this.f7062a.a()) && !TextUtils.isEmpty(this.f7062a.b())) {
                        JSONObject e = b.e(this.f7062a);
                        String str = this.f7063b.f7095b;
                        if (a(this.f7062a.a()) && !"click".equals(this.f7062a.b())) {
                            com.bytedance.sdk.openadsdk.c.d.b(a(), this.c, str, this.f7062a.b(), e);
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
        TTDownloadEventLogger l = i.c().l();
        if (l != null && dVar != null) {
            if (!l.shouldFilterOpenSdkLog() || !f(dVar)) {
                if (z) {
                    l.onV3Event(dVar);
                } else {
                    l.onEvent(dVar);
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
