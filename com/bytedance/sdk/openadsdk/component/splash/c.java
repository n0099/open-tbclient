package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.i.a.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static void a(l lVar, int i) {
        int i2;
        switch (x.c(p.a())) {
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 1;
                break;
            case 5:
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i));
        hashMap.put(DpStatConstants.KEY_NETWORK_STATUS, Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, "splash_ad", HttpConstants.NETWORK_TYPE, hashMap);
    }

    public static void a(AdSlot adSlot, boolean z, long j, long j2) {
        int i = z ? 2 : 1;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("available_type", Integer.valueOf(i));
            jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
            com.bytedance.sdk.openadsdk.h.a.a().n(com.bytedance.sdk.openadsdk.h.a.d.b().a(4).c(adSlot.getCodeId()).b((int) j).b(jSONObject.toString()));
        } catch (Throwable th) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.h.a.d dVar, String str) {
        com.bytedance.sdk.openadsdk.h.a.a().f(dVar.b(-7).g(h.a(-7)).i(str));
    }

    public static void a(long j, boolean z, boolean z2, l lVar, long j2, com.bytedance.sdk.adnet.core.p pVar) {
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            str = z2 ? "load_video_success" : "load_video_error";
        } else {
            str = z2 ? "download_video_image_success" : "download_video_image_fail";
        }
        String str2 = null;
        if (!z2 && pVar != null && pVar.pvp != null) {
            str2 = pVar.pvp.getMessage();
        }
        if (z) {
            Map<String, Object> a2 = aj.a(z2, lVar, elapsedRealtime, j2, str2);
            a2.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.c.d.f(p.a(), lVar, "splash_ad", str, a2);
            return;
        }
        Map<String, Object> b2 = aj.b(z2, lVar, elapsedRealtime, j2, str2);
        b2.put("splash_show_type", 2);
        com.bytedance.sdk.openadsdk.c.d.e(p.a(), lVar, "splash_ad", str, b2);
    }

    public static void a(final com.bytedance.sdk.openadsdk.core.d.a aVar) {
        if (b(aVar)) {
            final l lVar = aVar.c().get(0);
            int d = aj.d(lVar.W());
            s F = lVar.F();
            if (F != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                String h = F.h();
                if (TextUtils.isEmpty(h)) {
                    a(elapsedRealtime, true, false, lVar, -1L, null);
                    return;
                }
                a(lVar, 1);
                String k = F.k();
                if (TextUtils.isEmpty(k)) {
                    k = j.a(h);
                }
                final File a2 = a(p.a(), a.a(p.a()).a(String.valueOf(d), com.bytedance.sdk.openadsdk.multipro.b.b()), k);
                if (p.h().e(String.valueOf(d)) && !x.d(p.a())) {
                    if (k != null && a2.exists()) {
                        u.b("preLoadVideo", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                        a.a(p.a()).b(new o(aVar, lVar, null));
                        return;
                    }
                    return;
                }
                final String str = k;
                com.bytedance.sdk.openadsdk.i.e.a(p.a()).a(h, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.c.1
                    @Override // com.bytedance.sdk.adnet.b.b.a
                    public File a(String str2) {
                        try {
                            File parentFile = a2.getParentFile();
                            if (parentFile != null && parentFile.exists()) {
                                u.f("splashLoadAd", "SplashUtils preLoadVideo getFile  s " + str2);
                                c.a(a2);
                                return i.c().o().a(str, parentFile);
                            }
                        } catch (IOException e) {
                            u.f("SplashUtils", "datastoreGet throw IOException : " + e.toString());
                        }
                        return null;
                    }

                    @Override // com.bytedance.sdk.adnet.b.b.a
                    public void a(String str2, File file) {
                        if (file != null) {
                            u.f("splashLoadAd", "SplashUtils preLoadVideo putFile  s " + str2 + " file " + file.getPath());
                            c.a(file);
                            a.a(p.a()).a(file);
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.b.b.a
                    public File b(String str2) {
                        return a2;
                    }

                    @Override // com.bytedance.sdk.adnet.b.c.a
                    public void a(long j, long j2) {
                    }

                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void a(com.bytedance.sdk.adnet.core.p<File> pVar) {
                        if (pVar != null && pVar.f6047a != null) {
                            a.a(p.a()).b(new o(aVar, lVar, null));
                            a.a(p.a()).a(new o(aVar, lVar, null));
                            c.a(elapsedRealtime, true, true, lVar, 0L, pVar);
                            return;
                        }
                        c.a(elapsedRealtime, true, false, lVar, pVar == null ? -3L : pVar.h, pVar);
                    }

                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void b(com.bytedance.sdk.adnet.core.p<File> pVar) {
                        c.a(elapsedRealtime, true, false, lVar, pVar == null ? -2L : pVar.h, pVar);
                    }
                });
            }
        }
    }

    public static void a(l lVar) {
        if (lVar != null && lVar.B() != null) {
            if (lVar.ai() && lVar.M() != null && !lVar.M().isEmpty()) {
                for (k kVar : lVar.M()) {
                    if (!TextUtils.isEmpty(kVar.a())) {
                        com.bytedance.sdk.openadsdk.i.e.a(p.a()).f().a(kVar.a(), (b.InterfaceC1020b) com.bytedance.sdk.openadsdk.i.a.b.a(), kVar.b(), kVar.c(), true);
                    }
                }
            }
            k I = lVar.I();
            if (I != null && !TextUtils.isEmpty(I.a())) {
                com.bytedance.sdk.openadsdk.i.e.a(p.a()).f().a(I.a(), (b.InterfaceC1020b) com.bytedance.sdk.openadsdk.i.a.b.a(), I.b(), I.c(), true);
            }
        }
    }

    public static boolean a(o oVar) {
        return (oVar == null || oVar.a() == null) ? false : true;
    }

    public static boolean b(o oVar) {
        return (oVar.a() == null || !oVar.a().ai() || oVar.b() == null || oVar.b().length == 0) ? false : true;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        return (aVar == null || aVar.c() == null || aVar.c().isEmpty() || aVar.c().get(0) == null) ? false : true;
    }

    public static void a(Context context, AdSlot adSlot) {
        try {
            a.a(context).d(adSlot.getCodeId());
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        try {
            a.a(context).a();
        } catch (Throwable th) {
        }
    }

    public static File a(Context context, String str, String str2) {
        if (p.h().C() == 1) {
            u.f("splashLoadAd", "视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }

    public static int c(o oVar) {
        if (oVar != null) {
            int c = c(oVar.c());
            if (c <= 0) {
                return b(oVar.a());
            }
            return c;
        }
        return 0;
    }

    public static int b(l lVar) {
        if (lVar != null) {
            return aj.d(lVar.W());
        }
        return 0;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public static void a(File file) {
        if (file != null) {
            try {
                com.bytedance.sdk.openadsdk.utils.l.b(file);
            } catch (Throwable th) {
            }
        }
    }
}
