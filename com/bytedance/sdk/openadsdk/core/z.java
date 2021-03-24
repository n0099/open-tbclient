package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.g;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29054a = false;

    public static void b(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final Intent intent, final String str) {
        String str2;
        if (lVar == null || context == null || intent == null) {
            return;
        }
        String c2 = lVar.an() != null ? lVar.an().c() : "";
        if (TextUtils.isEmpty(c2)) {
            str2 = "是否立即打开应用";
        } else {
            str2 = "是否立即打开" + c2;
        }
        com.bytedance.sdk.openadsdk.utils.g.a(context, lVar.am(), c2, str2, "立即打开", "退出", new g.a() { // from class: com.bytedance.sdk.openadsdk.core.z.3
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_url_app", null);
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.z.3.1
                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a() {
                        com.bytedance.sdk.openadsdk.c.k a2 = com.bytedance.sdk.openadsdk.c.k.a();
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        a2.a(lVar, str, false);
                        Context a3 = p.a();
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        com.bytedance.sdk.openadsdk.c.d.b(a3, lVar, str, "deeplink_success_realtime");
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a(Throwable th) {
                        Context a2 = p.a();
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        com.bytedance.sdk.openadsdk.c.d.b(a2, lVar, str, "deeplink_fail_realtime");
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
            }
        });
    }

    public static void a(boolean z) {
        f29054a = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final int i, @Nullable TTNativeAd tTNativeAd, @Nullable TTNativeExpressAd tTNativeExpressAd, final String str, @Nullable com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, final boolean z, final Map<String, Object> map, boolean z2, boolean z3) {
        boolean z4;
        String ac;
        String str2;
        boolean z5;
        Map map2;
        Map map3;
        if (context == null || lVar == null || i == -1) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.d.g ao = lVar.ao();
        if (a(str) && !z3 && !z && ao == null && TTMiddlePageActivity.a(context, lVar)) {
            return false;
        }
        if (ao != null) {
            com.bytedance.sdk.openadsdk.utils.u.b("deepLink", "WebHelper 含有deeplink链接尝试deeplink调起 deepLink != null ");
            String a2 = ao.a();
            if (TextUtils.isEmpty(a2)) {
                z4 = true;
            } else {
                Uri parse = Uri.parse(ao.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (ak.c(context)) {
                    if (ak.a(context, intent)) {
                        if (lVar.aC()) {
                            ak.a(lVar, str);
                        }
                        intent.addFlags(268435456);
                        a(context, lVar, intent, System.currentTimeMillis(), str);
                        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.z.1
                            @Override // com.bytedance.sdk.openadsdk.utils.b.a
                            public void a() {
                                com.bytedance.sdk.openadsdk.c.d.b(p.a(), com.bytedance.sdk.openadsdk.core.d.l.this, str, "deeplink_success_realtime");
                            }

                            @Override // com.bytedance.sdk.openadsdk.utils.b.a
                            public void a(Throwable th) {
                                com.bytedance.sdk.openadsdk.core.d.l lVar2 = com.bytedance.sdk.openadsdk.core.d.l.this;
                                if (lVar2 != null && !lVar2.aC()) {
                                    z.a(context, com.bytedance.sdk.openadsdk.core.d.l.this.ac(), com.bytedance.sdk.openadsdk.core.d.l.this, i, str, z, map);
                                    com.bytedance.sdk.openadsdk.utils.u.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                                }
                                com.bytedance.sdk.openadsdk.c.d.b(p.a(), com.bytedance.sdk.openadsdk.core.d.l.this, str, "deeplink_fail_realtime");
                            }
                        });
                        com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_url_app", null);
                        com.bytedance.sdk.openadsdk.c.k.a().a(lVar, str, false);
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, str, "deeplink_fail_realtime");
                    z4 = true;
                } else {
                    intent.addFlags(268435456);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_url_app", null);
                        z5 = lVar.aC() ? ak.a(lVar, str) : false;
                        try {
                            context.startActivity(intent);
                            str2 = "deeplink_fail_realtime";
                            z4 = true;
                            try {
                                a(context, lVar, intent, currentTimeMillis, str);
                                com.bytedance.sdk.openadsdk.c.d.b(context, lVar, str, "deeplink_success_realtime");
                                com.bytedance.sdk.openadsdk.c.k.a().a(lVar, str, false);
                                return true;
                            } catch (Throwable unused) {
                                com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, str, str2);
                                if (z5) {
                                    return false;
                                }
                                if (ao.c() == 2) {
                                }
                                map2 = null;
                                if (ao.c() != z4) {
                                }
                                com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", map2);
                                ac = a2;
                                if (TextUtils.isEmpty(ac)) {
                                }
                                if (lVar.Z() != 2) {
                                }
                                return z4;
                            }
                        } catch (Throwable unused2) {
                            str2 = "deeplink_fail_realtime";
                            z4 = true;
                        }
                    } catch (Throwable unused3) {
                        str2 = "deeplink_fail_realtime";
                        z4 = true;
                        z5 = false;
                    }
                }
                if (ao.c() == 2 || com.bytedance.sdk.openadsdk.core.d.l.c(lVar)) {
                    map2 = null;
                    if (ao.c() != z4) {
                        a2 = ao.b();
                    } else {
                        a2 = lVar.ac();
                    }
                } else if (aVar != null) {
                    boolean j = aVar.j();
                    boolean z6 = (!j && aVar.h() && aVar.a(z)) ? true : j;
                    if (!z6 && aVar.b(z)) {
                        z6 = true;
                    }
                    if (z6 || !aVar.i()) {
                        map3 = null;
                    } else {
                        map3 = null;
                        z6 = true;
                    }
                    com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", map3);
                    return z6;
                } else {
                    map2 = null;
                }
                com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", map2);
            }
            ac = a2;
        } else {
            z4 = true;
            ac = lVar.ac();
        }
        if (TextUtils.isEmpty(ac) || lVar.C()) {
            if (lVar.Z() != 2) {
                if (!com.bytedance.sdk.openadsdk.utils.x.a(ac)) {
                    return false;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(Uri.parse(ac));
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent2, null);
                } catch (Exception unused4) {
                    return false;
                }
            } else {
                com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, ac, lVar, i, tTNativeAd, tTNativeExpressAd, str, z, map, z2, false), null);
                f29054a = false;
            }
            return z4;
        }
        return false;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, int i, String str2, boolean z, Map<String, Object> map) {
        try {
            return com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, str, lVar, i, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z, map, false, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("embeded_ad") || str.equals("embeded_ad_landingpage");
    }

    public static void a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final Intent intent, final long j, final String str) {
        final com.bytedance.sdk.openadsdk.utils.a c2;
        if (lVar == null || intent == null || context == null || !lVar.aD() || (c2 = i.d().c()) == null) {
            return;
        }
        c2.a(new a.InterfaceC0335a() { // from class: com.bytedance.sdk.openadsdk.core.z.2
            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0335a
            public void a() {
                long currentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.utils.u.b("WebHelper", "间隔时间 onActivityResumed intervalTime " + (currentTimeMillis - j));
                if (currentTimeMillis - j <= 3000) {
                    z.b(context, lVar, intent, str);
                }
                com.bytedance.sdk.openadsdk.utils.a aVar = c2;
                if (aVar != null) {
                    aVar.b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0335a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0335a
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0335a
            public void d() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0335a
            public void e() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0335a
            public void f() {
            }
        });
    }

    public static boolean a(TTNativeAd tTNativeAd) {
        if (tTNativeAd != null && (tTNativeAd instanceof a.InterfaceC0328a)) {
            try {
                return ((a.InterfaceC0328a) tTNativeAd).g();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, int i, @Nullable TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z, Map<String, Object> map, boolean z2, boolean z3) {
        Intent intent;
        int i2;
        if (lVar.C() && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.d.n.a(lVar)) && (tTNativeAd != null || tTNativeExpressAd != null)) {
            intent = new Intent(context, TTPlayableWebPageActivity.class);
            intent.putExtra("ad_pending_download", a(lVar, z));
            String a2 = com.bytedance.sdk.openadsdk.core.d.n.a(lVar);
            if (!TextUtils.isEmpty(a2) && a2 != null) {
                if (a2.contains("?")) {
                    str = a2 + "&orientation=portrait";
                } else {
                    str = a2 + "?orientation=portrait";
                }
            }
        } else {
            intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTWebPageActivity.class) : (!com.bytedance.sdk.openadsdk.core.d.l.c(lVar) || f29054a || a(tTNativeAd) || !ak.c(lVar)) ? new Intent(context, TTWebPageActivity.class) : new Intent(context, TTVideoWebPageActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", lVar.ae());
        intent.putExtra("web_title", lVar.aj());
        intent.putExtra("sdk_version", 3455);
        intent.putExtra("adid", lVar.am());
        intent.putExtra("log_extra", lVar.ap());
        intent.putExtra("icon_url", lVar.aa() == null ? null : lVar.aa().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.utils.k.e(lVar.aL().toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, lVar.aL().toString());
        } else {
            u.a().g();
            u.a().a(lVar);
        }
        if (com.bytedance.sdk.openadsdk.core.d.l.c(lVar)) {
            if (tTNativeAd != null) {
                r8 = tTNativeAd instanceof a.InterfaceC0328a ? ((a.InterfaceC0328a) tTNativeAd).e() : null;
                if (r8 != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, r8.a().toString());
                }
            }
            if (tTNativeExpressAd != null && (r8 = tTNativeExpressAd.getVideoModel()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, r8.a().toString());
            }
            if (r8 != null) {
                intent.putExtra("video_is_auto_play", r8.f29881d);
                com.bytedance.sdk.openadsdk.utils.u.c("videoDataModel", "videoDataModel=" + r8.a().toString());
            }
            if (TTVideoWebPageActivity.a(intent) && (r8 != null || z2)) {
                try {
                    if (r8 != null) {
                        i2 = (int) ((((float) r8.f29884g) / ((float) r8.f29882e)) * 100.0f);
                    } else {
                        com.bytedance.sdk.openadsdk.multipro.b.a aVar = new com.bytedance.sdk.openadsdk.multipro.b.a();
                        aVar.f29884g = 100L;
                        aVar.f29878a = true;
                        aVar.f29881d = ak.j(lVar);
                        intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
                        i2 = 100;
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put("play_percent", Integer.valueOf(i2));
                    if (lVar.ad() == 0) {
                        intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                    } else if (lVar.ad() > 0 && i2 > lVar.ad() && ak.j(lVar)) {
                        intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return intent;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar, boolean z) {
        return z && lVar != null && lVar.Z() == 4 && lVar.C();
    }
}
