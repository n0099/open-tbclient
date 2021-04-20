package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.imsdk.internal.Constants;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.v;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import d.c.c.b.b.b;
import d.c.c.b.d.o;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f27408a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27409b;

    /* renamed from: c  reason: collision with root package name */
    public final i f27410c;

    /* renamed from: d  reason: collision with root package name */
    public Map<l, Long> f27411d = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0302a<T> {
        void a(boolean z, T t);
    }

    public a(Context context) {
        Context a2 = context == null ? p.a() : context.getApplicationContext();
        this.f27409b = a2;
        this.f27410c = new i(a2, "sp_full_screen_video");
    }

    @Nullable
    public AdSlot b(String str) {
        return this.f27410c.e(str);
    }

    public l c(String str) {
        l a2;
        long b2 = this.f27410c.b(str);
        boolean c2 = this.f27410c.c(str);
        if (!(System.currentTimeMillis() - b2 < Constants.SYNC_MSG_DELAY_TIME) || c2) {
            return null;
        }
        try {
            String a3 = this.f27410c.a(str);
            if (TextUtils.isEmpty(a3) || (a2 = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(a3))) == null) {
                return null;
            }
            if (a2.D()) {
                return a2;
            }
            if (a2.X() != null) {
                v X = a2.X();
                if (TextUtils.isEmpty(a(X.i(), X.l(), str))) {
                    return null;
                }
                return a2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(AdSlot adSlot) {
        this.f27410c.b(adSlot);
    }

    public void a(String str) {
        this.f27410c.d(str);
    }

    @Nullable
    public AdSlot b() {
        return this.f27410c.a();
    }

    public void a() {
        File externalCacheDir;
        File[] listFiles;
        File file;
        File[] listFiles2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(this.f27409b.getDataDir(), "shared_prefs");
            } else {
                file = new File(this.f27409b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
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
                        String replace = file2.getName().replace(ActivityChooserModel.HISTORY_FILE_EXTENSION, "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.f27409b.deleteSharedPreferences(replace);
                        } else {
                            this.f27409b.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.openadsdk.utils.l.c(file2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.f27409b.getExternalCacheDir() != null) {
                externalCacheDir = this.f27409b.getExternalCacheDir();
            } else {
                externalCacheDir = this.f27409b.getCacheDir();
            }
            if (externalCacheDir == null || !externalCacheDir.exists() || !externalCacheDir.isDirectory() || (listFiles = externalCacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("full_screen_video_cache");
                    }
                    return false;
                }
            })) == null || listFiles.length <= 0) {
                return;
            }
            for (File file3 : listFiles) {
                try {
                    com.bytedance.sdk.openadsdk.utils.l.c(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void a(AdSlot adSlot, l lVar) {
        a(adSlot);
        if (lVar != null) {
            try {
                this.f27410c.a(adSlot.getCodeId(), lVar.aL().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.f27410c.a(adSlot);
    }

    public static a a(Context context) {
        if (f27408a == null) {
            synchronized (a.class) {
                if (f27408a == null) {
                    f27408a = new a(context);
                }
            }
        }
        return f27408a;
    }

    public String a(l lVar) {
        if (lVar == null || lVar.X() == null || TextUtils.isEmpty(lVar.X().i())) {
            return null;
        }
        return a(lVar.X().i(), lVar.X().l(), String.valueOf(ak.d(lVar.ap())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.utils.j.a(str);
        }
        File a2 = a(this.f27409b, a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b()), str2);
        if (a2 != null && a2.exists() && a2.isFile()) {
            return a2.getAbsolutePath();
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
    public void a(boolean z, l lVar, long j, @Nullable o oVar) {
        VAdError vAdError;
        Long remove = this.f27411d.remove(lVar);
        com.bytedance.sdk.openadsdk.c.d.f(this.f27409b, lVar, "fullscreen_interstitial_ad", z ? "load_video_success" : "load_video_error", ak.a(z, lVar, remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue(), j, (z || oVar == null || (vAdError = oVar.f66586c) == null) ? null : vAdError.getMessage()));
    }

    public void a(final l lVar, final InterfaceC0302a<Object> interfaceC0302a) {
        this.f27411d.put(lVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (lVar != null && lVar.X() != null && !TextUtils.isEmpty(lVar.X().i())) {
            String i = lVar.X().i();
            String l = lVar.X().l();
            if (TextUtils.isEmpty(l)) {
                l = com.bytedance.sdk.openadsdk.utils.j.a(i);
            }
            final String str = l;
            int d2 = ak.d(lVar.ap());
            String a2 = a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b());
            u.f("FullScreenVideoCache", "ritId:" + d2 + ",cacheDirPath=" + a2);
            final File a3 = a(this.f27409b, a2, str);
            StringBuilder sb = new StringBuilder();
            sb.append("FullScreenVideoCache downloadVideo target getPath");
            sb.append(a3.getPath());
            u.b("splashLoadAd", sb.toString());
            com.bytedance.sdk.openadsdk.i.e.c().a(i, new b.InterfaceC1824b() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.3
                @Override // d.c.c.b.b.b.InterfaceC1824b
                public File a(String str2) {
                    try {
                        File parentFile = a3.getParentFile();
                        if (parentFile == null || !parentFile.exists()) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.core.i.d().q().a(str, parentFile);
                    } catch (IOException e2) {
                        u.f("FullScreenVideoCache", "datastoreGet throw IOException : " + e2.toString());
                        return null;
                    }
                }

                @Override // d.c.c.b.b.c.a
                public void a(long j, long j2) {
                }

                @Override // d.c.c.b.b.b.InterfaceC1824b
                public File b(String str2) {
                    return a3;
                }

                @Override // d.c.c.b.d.o.a
                public void b(o<File> oVar) {
                    InterfaceC0302a interfaceC0302a2 = interfaceC0302a;
                    if (interfaceC0302a2 != null) {
                        interfaceC0302a2.a(false, null);
                    }
                    a.this.a(false, lVar, oVar == null ? -2L : oVar.f66591h, oVar);
                }

                @Override // d.c.c.b.b.b.InterfaceC1824b
                public void a(String str2, File file) {
                    if (file != null) {
                        a.this.a(file);
                    }
                }

                @Override // d.c.c.b.d.o.a
                public void a(o<File> oVar) {
                    if (oVar != null && oVar.f66584a != null && a3.exists()) {
                        InterfaceC0302a interfaceC0302a2 = interfaceC0302a;
                        if (interfaceC0302a2 != null) {
                            interfaceC0302a2.a(true, null);
                        }
                        a.this.a(true, lVar, 0L, oVar);
                        return;
                    }
                    InterfaceC0302a interfaceC0302a3 = interfaceC0302a;
                    if (interfaceC0302a3 != null) {
                        interfaceC0302a3.a(false, null);
                    }
                    a.this.a(false, lVar, oVar == null ? -3L : oVar.f66591h, oVar);
                }
            });
            return;
        }
        if (interfaceC0302a != null) {
            interfaceC0302a.a(false, null);
        }
        a(false, lVar, -1L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            com.bytedance.sdk.openadsdk.core.i.d().q().a(file);
        } catch (IOException e2) {
            u.f("FullScreenVideoCache", "trimFileCache IOException:" + e2.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        if (p.h().B() == 1) {
            u.f("splashLoadAd", "FullScreenVideoCache getDiskCacheDir 视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "FullScreenVideoCache getDiskCacheDir 视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }
}
