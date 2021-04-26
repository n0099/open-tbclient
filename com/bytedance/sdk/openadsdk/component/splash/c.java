package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.v;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import d.b.c.b.b.b;
import d.b.c.b.d.o;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static void a(l lVar, int i2) {
        int c2 = x.c(p.a());
        int i3 = 4;
        if (c2 == 2) {
            i3 = 2;
        } else if (c2 == 3) {
            i3 = 3;
        } else if (c2 == 4) {
            i3 = 1;
        } else if (c2 != 5) {
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i2));
        hashMap.put(DpStatConstants.KEY_NETWORK_STATUS, Integer.valueOf(i3));
        com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, "splash_ad", PmsConstant.Statistic.STATISTIC_NETWORK, hashMap);
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        return (pVar.a() == null || !pVar.a().aH() || pVar.b() == null || pVar.b().length == 0) ? false : true;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        if (pVar != null) {
            int c2 = c(pVar.c());
            return c2 <= 0 ? a(pVar.a()) : c2;
        }
        return 0;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        return (aVar == null || aVar.c() == null || aVar.c().isEmpty() || aVar.c().get(0) == null) ? false : true;
    }

    public static void a(AdSlot adSlot, boolean z, long j, long j2) {
        int i2 = z ? 2 : 1;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("available_type", Integer.valueOf(i2));
            jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
            com.bytedance.sdk.openadsdk.h.a.a().n(com.bytedance.sdk.openadsdk.h.a.c.b().a(4).c(adSlot.getCodeId()).b((int) j).b(jSONObject.toString()));
        } catch (Throwable unused) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.h.a.c cVar, String str) {
        com.bytedance.sdk.openadsdk.h.a.a().f(cVar.b(-7).g(h.a(-7)).i(str));
    }

    public static void a(long j, boolean z, boolean z2, l lVar, long j2, o oVar) {
        VAdError vAdError;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
        String message = (z2 || oVar == null || (vAdError = oVar.f65082c) == null) ? null : vAdError.getMessage();
        if (z) {
            Map<String, Object> a2 = ak.a(z2, lVar, elapsedRealtime, j2, message);
            a2.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.c.d.f(p.a(), lVar, "splash_ad", str, a2);
            return;
        }
        Map<String, Object> b2 = ak.b(z2, lVar, elapsedRealtime, j2, message);
        b2.put("splash_show_type", 2);
        com.bytedance.sdk.openadsdk.c.d.e(p.a(), lVar, "splash_ad", str, b2);
    }

    public static void a(final com.bytedance.sdk.openadsdk.core.d.a aVar) {
        if (b(aVar)) {
            final l lVar = aVar.c().get(0);
            int d2 = ak.d(lVar.ap());
            v X = lVar.X();
            if (X != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                String i2 = X.i();
                if (TextUtils.isEmpty(i2)) {
                    a(elapsedRealtime, true, false, lVar, -1L, null);
                    return;
                }
                a(lVar, 1);
                String l = X.l();
                if (TextUtils.isEmpty(l)) {
                    l = j.a(i2);
                }
                final String str = l;
                final File a2 = a(p.a(), a.a(p.a()).a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b()), str);
                if (p.h().e(String.valueOf(d2)) && !x.d(p.a())) {
                    if (str == null || !a2.exists()) {
                        return;
                    }
                    u.b("preLoadVideo", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                    a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                    return;
                }
                com.bytedance.sdk.openadsdk.i.e.c().a(i2, new b.InterfaceC1767b() { // from class: com.bytedance.sdk.openadsdk.component.splash.c.1
                    @Override // d.b.c.b.b.b.InterfaceC1767b
                    public File a(String str2) {
                        try {
                            File parentFile = a2.getParentFile();
                            if (parentFile == null || !parentFile.exists()) {
                                return null;
                            }
                            u.f("splashLoadAd", "SplashUtils preLoadVideo getFile  s " + str2);
                            c.a(a2);
                            return i.d().q().a(str, parentFile);
                        } catch (IOException e2) {
                            u.f("SplashUtils", "datastoreGet throw IOException : " + e2.toString());
                            return null;
                        }
                    }

                    @Override // d.b.c.b.b.c.a
                    public void a(long j, long j2) {
                    }

                    @Override // d.b.c.b.b.b.InterfaceC1767b
                    public File b(String str2) {
                        return a2;
                    }

                    @Override // d.b.c.b.d.o.a
                    public void b(o<File> oVar) {
                        c.a(elapsedRealtime, true, false, lVar, oVar == null ? -2L : oVar.f65087h, oVar);
                    }

                    @Override // d.b.c.b.b.b.InterfaceC1767b
                    public void a(String str2, File file) {
                        if (file != null) {
                            u.f("splashLoadAd", "SplashUtils preLoadVideo putFile  s " + str2 + " file " + file.getPath());
                            c.a(file);
                            a.a(p.a()).a(file);
                        }
                    }

                    @Override // d.b.c.b.d.o.a
                    public void a(o<File> oVar) {
                        if (oVar != null && oVar.f65080a != null) {
                            a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                            a.a(p.a()).a(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                            c.a(elapsedRealtime, true, true, lVar, 0L, oVar);
                            return;
                        }
                        c.a(elapsedRealtime, true, false, lVar, oVar == null ? -3L : oVar.f65087h, oVar);
                    }
                });
            }
        }
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        return (pVar == null || pVar.a() == null) ? false : true;
    }

    public static void a(Context context, AdSlot adSlot) {
        try {
            a.a(context).d(adSlot.getCodeId());
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        try {
            a.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static File a(Context context, String str, String str2) {
        if (p.h().B() == 1) {
            u.f("splashLoadAd", "视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }

    public static int a(l lVar) {
        if (lVar != null) {
            return ak.d(lVar.ap());
        }
        return 0;
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.utils.l.b(file);
        } catch (Throwable unused) {
        }
    }
}
