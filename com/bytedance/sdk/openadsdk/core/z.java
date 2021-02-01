package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.b;
/* loaded from: classes6.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6865a = false;

    public static void a(boolean z) {
        f6865a = z;
    }

    public static boolean a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final int i, @Nullable TTNativeAd tTNativeAd, @Nullable TTNativeExpressAd tTNativeExpressAd, final String str, @Nullable com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, final boolean z) {
        String K;
        if (context == null || lVar == null || i == -1) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.d.g V = lVar.V();
        if (V != null) {
            com.bytedance.sdk.openadsdk.utils.u.b("deepLink", "WebHelper 含有deeplink链接尝试deeplink调起 deepLink != null ");
            String a2 = V.a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(V.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (aj.a(context, intent)) {
                    if (p.h().d()) {
                        aj.a(lVar, str);
                    }
                    intent.addFlags(268435456);
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.z.1
                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            if (!p.h().d()) {
                                z.a(context, lVar.K(), lVar, i, str, z);
                                com.bytedance.sdk.openadsdk.utils.u.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                            }
                        }
                    });
                    com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_url_app", null);
                    com.bytedance.sdk.openadsdk.c.k.a().a(lVar, str, false);
                    return true;
                }
            }
            if (V.c() == 2 && lVar.X() != 5 && lVar.X() != 15) {
                if (aVar != null) {
                    boolean z2 = false;
                    if (aVar.j()) {
                        z2 = true;
                    }
                    if (!z2 && aVar.h() && aVar.a(z)) {
                        z2 = true;
                    }
                    if (!z2 && aVar.b(z)) {
                        z2 = true;
                    }
                    if (!z2 && aVar.i()) {
                        z2 = true;
                    }
                    com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", null);
                    return z2;
                }
            } else if (V.c() == 1) {
                a2 = V.b();
            } else {
                a2 = lVar.K();
            }
            com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", null);
            K = a2;
        } else {
            K = lVar.K();
        }
        if (!TextUtils.isEmpty(K) || lVar.s()) {
            if (lVar.H() == 2) {
                if (!com.bytedance.sdk.openadsdk.utils.x.a(K)) {
                    return false;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(Uri.parse(K));
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent2, null);
                } catch (Exception e) {
                    return false;
                }
            } else {
                com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, K, lVar, i, tTNativeAd, tTNativeExpressAd, str, z), null);
                f6865a = false;
            }
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, int i, String str2, boolean z) {
        try {
            return com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, str, lVar, i, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z), null);
        } catch (Throwable th) {
            return false;
        }
    }

    private static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, int i, @Nullable TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z) {
        Intent intent;
        com.bytedance.sdk.openadsdk.multipro.b.a aVar;
        if (lVar.s() && (tTNativeAd != null || tTNativeExpressAd != null)) {
            intent = new Intent(context, TTPlayableWebPageActivity.class);
            intent.putExtra("ad_pending_download", a(lVar, z));
            if (lVar.F() != null && !TextUtils.isEmpty(lVar.F().i())) {
                String i2 = lVar.F().i();
                if (i2.contains("?")) {
                    str = i2 + "&orientation=portrait";
                } else {
                    str = i2 + "?orientation=portrait";
                }
            }
        } else {
            intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTWebPageActivity.class) : (lVar.X() != 5 || f6865a) ? new Intent(context, TTWebPageActivity.class) : new Intent(context, TTVideoWebPageActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", lVar.L());
        intent.putExtra("web_title", lVar.Q());
        intent.putExtra(SapiContext.KEY_SDK_VERSION, 3251);
        intent.putExtra("adid", lVar.T());
        intent.putExtra("log_extra", lVar.W());
        intent.putExtra("icon_url", lVar.I() == null ? null : lVar.I().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.utils.k.d(lVar.am().toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, lVar.am().toString());
        } else {
            u.a().g();
            u.a().a(lVar);
        }
        if (lVar.X() == 5) {
            if (tTNativeAd != null) {
                aVar = tTNativeAd instanceof a.InterfaceC1026a ? ((a.InterfaceC1026a) tTNativeAd).a() : null;
                if (aVar != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
                }
            } else {
                aVar = null;
            }
            if (tTNativeExpressAd != null && (aVar = tTNativeExpressAd.getVideoModel()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
            }
            if (aVar != null) {
                intent.putExtra("video_is_auto_play", aVar.d);
                com.bytedance.sdk.openadsdk.utils.u.c("videoDataModel", "videoDataModel=" + aVar.a().toString());
            }
        }
        return intent;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar, boolean z) {
        return z && lVar != null && lVar.H() == 4 && lVar.s();
    }
}
