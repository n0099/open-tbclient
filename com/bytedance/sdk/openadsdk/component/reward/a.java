package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6297a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6298b;
    private final h c;
    private Map<l, Long> d = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    interface InterfaceC1003a<T> {
        void a(boolean z, T t);
    }

    public void a(String str) {
        this.c.d(str);
    }

    public void a() {
        File externalCacheDir;
        File[] listFiles;
        File file;
        File[] listFiles2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(this.f6298b.getDataDir(), "shared_prefs");
            } else {
                file = new File(this.f6298b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_full_screen_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles2) {
                    try {
                        String replace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.f6298b.deleteSharedPreferences(replace);
                        } else {
                            this.f6298b.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.openadsdk.utils.l.c(file2);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.f6298b.getExternalCacheDir() != null) {
                externalCacheDir = this.f6298b.getExternalCacheDir();
            } else {
                externalCacheDir = this.f6298b.getCacheDir();
            }
            if (externalCacheDir != null && externalCacheDir.exists() && externalCacheDir.isDirectory() && (listFiles = externalCacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("full_screen_video_cache");
                    }
                    return false;
                }
            })) != null && listFiles.length > 0) {
                for (File file3 : listFiles) {
                    try {
                        com.bytedance.sdk.openadsdk.utils.l.c(file3);
                    } catch (Throwable th3) {
                    }
                }
            }
        } catch (Throwable th4) {
        }
    }

    public void a(AdSlot adSlot, l lVar) {
        a(adSlot);
        if (lVar != null) {
            try {
                this.c.a(adSlot.getCodeId(), lVar.am().toString());
            } catch (Throwable th) {
            }
        }
    }

    @Nullable
    public AdSlot b(String str) {
        return this.c.e(str);
    }

    public void a(AdSlot adSlot) {
        this.c.a(adSlot);
    }

    public void b(AdSlot adSlot) {
        this.c.b(adSlot);
    }

    @Nullable
    public AdSlot b() {
        return this.c.a();
    }

    public static a a(Context context) {
        if (f6297a == null) {
            synchronized (a.class) {
                if (f6297a == null) {
                    f6297a = new a(context);
                }
            }
        }
        return f6297a;
    }

    private a(Context context) {
        this.f6298b = context == null ? p.a() : context.getApplicationContext();
        this.c = new h(this.f6298b, "sp_full_screen_video");
    }

    public String a(l lVar) {
        if (lVar == null || lVar.F() == null || TextUtils.isEmpty(lVar.F().h())) {
            return null;
        }
        return a(lVar.F().h(), lVar.F().k(), String.valueOf(aj.d(lVar.W())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.utils.j.a(str);
        }
        File a2 = a(this.f6298b, a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b()), str2);
        if (a2 != null && a2.exists() && a2.isFile()) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    public l c(String str) {
        l a2;
        long b2 = this.c.b(str);
        boolean c = this.c.c(str);
        if ((System.currentTimeMillis() - b2 < Constants.SYNC_MSG_DELAY_TIME) && !c) {
            try {
                String a3 = this.c.a(str);
                if (!TextUtils.isEmpty(a3) && (a2 = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(a3))) != null) {
                    if (!a2.t()) {
                        if (a2.F() != null) {
                            s F = a2.F();
                            if (!TextUtils.isEmpty(a(F.h(), F.k(), str))) {
                                return a2;
                            }
                        }
                    } else {
                        return a2;
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    private String a(String str, boolean z) {
        if (z) {
            return "full_screen_video_cache_" + str + "/";
        }
        return "/full_screen_video_cache_" + str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, l lVar, long j, @Nullable com.bytedance.sdk.adnet.core.p pVar) {
        Long remove = this.d.remove(lVar);
        long elapsedRealtime = remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue();
        String str = z ? "load_video_success" : "load_video_error";
        String str2 = null;
        if (!z && pVar != null && pVar.pvP != null) {
            str2 = pVar.pvP.getMessage();
        }
        com.bytedance.sdk.openadsdk.c.d.f(this.f6298b, lVar, "fullscreen_interstitial_ad", str, aj.a(z, lVar, elapsedRealtime, j, str2));
    }

    public void a(final l lVar, final InterfaceC1003a<Object> interfaceC1003a) {
        this.d.put(lVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (lVar == null || lVar.F() == null || TextUtils.isEmpty(lVar.F().h())) {
            if (interfaceC1003a != null) {
                interfaceC1003a.a(false, null);
            }
            a(false, lVar, -1L, null);
            return;
        }
        String h = lVar.F().h();
        final String k = lVar.F().k();
        if (TextUtils.isEmpty(k)) {
            k = com.bytedance.sdk.openadsdk.utils.j.a(h);
        }
        int d = aj.d(lVar.W());
        String a2 = a(String.valueOf(d), com.bytedance.sdk.openadsdk.multipro.b.b());
        u.f("FullScreenVideoCache", "ritId:" + d + ",cacheDirPath=" + a2);
        final File a3 = a(this.f6298b, a2, k);
        u.b("splashLoadAd", "FullScreenVideoCache downloadVideo target getPath" + a3.getPath());
        com.bytedance.sdk.openadsdk.i.e.a(this.f6298b).a(h, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.3
            @Override // com.bytedance.sdk.adnet.b.b.a
            public File a(String str) {
                try {
                    File parentFile = a3.getParentFile();
                    if (parentFile != null && parentFile.exists()) {
                        return com.bytedance.sdk.openadsdk.core.i.c().o().a(k, parentFile);
                    }
                } catch (IOException e) {
                    u.f("FullScreenVideoCache", "datastoreGet throw IOException : " + e.toString());
                }
                return null;
            }

            @Override // com.bytedance.sdk.adnet.b.b.a
            public void a(String str, File file) {
                if (file != null) {
                    a.this.a(file);
                }
            }

            @Override // com.bytedance.sdk.adnet.b.b.a
            public File b(String str) {
                return a3;
            }

            @Override // com.bytedance.sdk.adnet.b.c.a
            public void a(long j, long j2) {
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(com.bytedance.sdk.adnet.core.p<File> pVar) {
                if (pVar != null && pVar.f6047a != null) {
                    if (interfaceC1003a != null) {
                        interfaceC1003a.a(true, null);
                    }
                    a.this.a(true, lVar, 0L, pVar);
                    return;
                }
                if (interfaceC1003a != null) {
                    interfaceC1003a.a(false, null);
                }
                a.this.a(false, lVar, pVar == null ? -3L : pVar.h, pVar);
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(com.bytedance.sdk.adnet.core.p<File> pVar) {
                if (interfaceC1003a != null) {
                    interfaceC1003a.a(false, null);
                }
                a.this.a(false, lVar, pVar == null ? -2L : pVar.h, pVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            com.bytedance.sdk.openadsdk.core.i.c().o().a(file);
        } catch (IOException e) {
            u.f("FullScreenVideoCache", "trimFileCache IOException:" + e.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        if (p.h().C() == 1) {
            u.f("splashLoadAd", "FullScreenVideoCache getDiskCacheDir 视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "FullScreenVideoCache getDiskCacheDir 视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }
}
