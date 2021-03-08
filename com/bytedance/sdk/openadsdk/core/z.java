package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.sapi2.SapiContext;
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
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.g;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4651a = false;

    public static void a(boolean z) {
        f4651a = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final int i, @Nullable TTNativeAd tTNativeAd, @Nullable TTNativeExpressAd tTNativeExpressAd, final String str, @Nullable com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, final boolean z, final Map<String, Object> map, boolean z2, boolean z3) {
        String W;
        boolean z4;
        if (context == null || lVar == null || i == -1) {
            return false;
        }
        if (a(str) && !z3 && !z && TTMiddlePageActivity.a(context, lVar)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.d.g ai = lVar.ai();
        if (ai != null) {
            com.bytedance.sdk.openadsdk.utils.u.b("deepLink", "WebHelper 含有deeplink链接尝试deeplink调起 deepLink != null ");
            String a2 = ai.a();
            if (TextUtils.isEmpty(a2)) {
                W = a2;
            } else {
                Uri parse = Uri.parse(ai.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (aj.c(context)) {
                    if (aj.a(context, intent)) {
                        if (lVar.av()) {
                            aj.a(lVar, str);
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
                                if (com.bytedance.sdk.openadsdk.core.d.l.this != null && !com.bytedance.sdk.openadsdk.core.d.l.this.av()) {
                                    z.a(context, com.bytedance.sdk.openadsdk.core.d.l.this.W(), com.bytedance.sdk.openadsdk.core.d.l.this, i, str, z, map);
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
                } else {
                    intent.addFlags(268435456);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z5 = false;
                    try {
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_url_app", null);
                        if (!lVar.av()) {
                            z4 = false;
                        } else {
                            z4 = aj.a(lVar, str);
                        }
                        try {
                            context.startActivity(intent);
                            a(context, lVar, intent, currentTimeMillis, str);
                            com.bytedance.sdk.openadsdk.c.d.b(context, lVar, str, "deeplink_success_realtime");
                            com.bytedance.sdk.openadsdk.c.k.a().a(lVar, str, false);
                            return true;
                        } catch (Throwable th) {
                            z5 = z4;
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, str, "deeplink_fail_realtime");
                            if (z5) {
                                return false;
                            }
                            if (ai.c() != 2) {
                            }
                            if (ai.c() != 1) {
                            }
                            com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", null);
                            W = a2;
                            if (TextUtils.isEmpty(W)) {
                            }
                            if (lVar.T() != 2) {
                            }
                            return true;
                        }
                    } catch (Throwable th2) {
                    }
                }
                if (ai.c() != 2 && !com.bytedance.sdk.openadsdk.core.d.l.c(lVar)) {
                    if (aVar != null) {
                        boolean z6 = false;
                        if (aVar.j()) {
                            z6 = true;
                        }
                        if (!z6 && aVar.h() && aVar.a(z)) {
                            z6 = true;
                        }
                        if (!z6 && aVar.b(z)) {
                            z6 = true;
                        }
                        if (!z6 && aVar.i()) {
                            z6 = true;
                        }
                        com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", null);
                        return z6;
                    }
                } else if (ai.c() != 1) {
                    a2 = ai.b();
                } else {
                    a2 = lVar.W();
                }
                com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_fallback_url", null);
                W = a2;
            }
        } else {
            W = lVar.W();
        }
        if (TextUtils.isEmpty(W) || lVar.C()) {
            if (lVar.T() != 2) {
                if (!com.bytedance.sdk.openadsdk.utils.x.a(W)) {
                    return false;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(Uri.parse(W));
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent2, null);
                } catch (Exception e) {
                    return false;
                }
            } else {
                com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, W, lVar, i, tTNativeAd, tTNativeExpressAd, str, z, map, z2, false), null);
                f4651a = false;
            }
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, int i, String str2, boolean z, Map<String, Object> map) {
        try {
            return com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, str, lVar, i, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z, map, false, false), null);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("embeded_ad") || str.equals("embeded_ad_landingpage");
    }

    public static void a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final Intent intent, final long j, final String str) {
        final com.bytedance.sdk.openadsdk.utils.a c;
        if (lVar != null && intent != null && context != null && lVar.aw() && (c = i.d().c()) != null) {
            c.a(new a.InterfaceC1047a() { // from class: com.bytedance.sdk.openadsdk.core.z.2
                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void a() {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.utils.u.b("WebHelper", "间隔时间 onActivityResumed intervalTime " + (currentTimeMillis - j));
                    if (currentTimeMillis - j <= IMConnection.RETRY_DELAY_TIMES) {
                        z.b(context, lVar, intent, str);
                    }
                    if (c != null) {
                        c.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void d() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void e() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void f() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final Intent intent, final String str) {
        String str2;
        if (lVar != null && context != null && intent != null) {
            String str3 = "";
            if (lVar.ah() != null) {
                str3 = lVar.ah().c();
            }
            if (TextUtils.isEmpty(str3)) {
                str2 = "是否立即打开应用";
            } else {
                str2 = "是否立即打开" + str3;
            }
            com.bytedance.sdk.openadsdk.utils.g.a(lVar.ag(), str3, str2, "立即打开", "退出", new g.a() { // from class: com.bytedance.sdk.openadsdk.core.z.3
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    com.bytedance.sdk.openadsdk.c.d.i(context, lVar, str, "open_url_app", null);
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.z.3.1
                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                            com.bytedance.sdk.openadsdk.c.k.a().a(lVar, str, false);
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, str, "deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, str, "deeplink_fail_realtime");
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
    }

    private static boolean a(TTNativeAd tTNativeAd) {
        if (tTNativeAd != null && (tTNativeAd instanceof a.InterfaceC1040a)) {
            try {
                return ((a.InterfaceC1040a) tTNativeAd).g();
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, int i, @Nullable TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z, Map<String, Object> map, boolean z2, boolean z3) {
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
            intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTWebPageActivity.class) : (!com.bytedance.sdk.openadsdk.core.d.l.c(lVar) || f4651a || a(tTNativeAd) || !aj.c(lVar)) ? new Intent(context, TTWebPageActivity.class) : new Intent(context, TTVideoWebPageActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", lVar.Y());
        intent.putExtra("web_title", lVar.ad());
        intent.putExtra(SapiContext.KEY_SDK_VERSION, 3401);
        intent.putExtra("adid", lVar.ag());
        intent.putExtra("log_extra", lVar.aj());
        intent.putExtra("icon_url", lVar.U() == null ? null : lVar.U().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.utils.k.e(lVar.aE().toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, lVar.aE().toString());
        } else {
            u.a().g();
            u.a().a(lVar);
        }
        if (com.bytedance.sdk.openadsdk.core.d.l.c(lVar)) {
            com.bytedance.sdk.openadsdk.multipro.b.a aVar = null;
            if (tTNativeAd != null) {
                if (tTNativeAd instanceof a.InterfaceC1040a) {
                    aVar = ((a.InterfaceC1040a) tTNativeAd).e();
                }
                if (aVar != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
                }
            }
            if (tTNativeExpressAd != null && (aVar = tTNativeExpressAd.getVideoModel()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
            }
            if (aVar != null) {
                intent.putExtra("video_is_auto_play", aVar.d);
                com.bytedance.sdk.openadsdk.utils.u.c("videoDataModel", "videoDataModel=" + aVar.a().toString());
            }
            if (TTVideoWebPageActivity.a(intent) && (aVar != null || z2)) {
                try {
                    if (aVar != null) {
                        i2 = (int) ((((float) aVar.g) / ((float) aVar.e)) * 100.0f);
                    } else {
                        i2 = 100;
                        com.bytedance.sdk.openadsdk.multipro.b.a aVar2 = new com.bytedance.sdk.openadsdk.multipro.b.a();
                        aVar2.g = 100L;
                        aVar2.f4918a = true;
                        aVar2.d = aj.j(lVar);
                        intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar2.a().toString());
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put("play_percent", Integer.valueOf(i2));
                    if (lVar.X() == 0) {
                        intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                    } else if (lVar.X() > 0 && i2 > lVar.X() && aj.j(lVar)) {
                        intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                    }
                } catch (Throwable th) {
                }
            }
        }
        return intent;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar, boolean z) {
        return z && lVar != null && lVar.T() == 4 && lVar.C();
    }
}
