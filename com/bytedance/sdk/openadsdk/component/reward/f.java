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
/* loaded from: classes6.dex */
public class f {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f27775a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27776b;

    /* renamed from: c  reason: collision with root package name */
    public final i f27777c;

    /* renamed from: d  reason: collision with root package name */
    public Map<l, Long> f27778d = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(boolean z, T t);
    }

    public f(Context context) {
        Context a2 = context == null ? p.a() : context.getApplicationContext();
        this.f27776b = a2;
        this.f27777c = new i(a2, "sp_reward_video");
    }

    @Nullable
    public AdSlot b(String str) {
        return this.f27777c.e(str);
    }

    public l c(String str) {
        l a2;
        long b2 = this.f27777c.b(str);
        boolean c2 = this.f27777c.c(str);
        if (!(System.currentTimeMillis() - b2 < Constants.SYNC_MSG_DELAY_TIME) || c2) {
            return null;
        }
        try {
            String a3 = this.f27777c.a(str);
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
        this.f27777c.b(adSlot);
    }

    public void a(String str) {
        this.f27777c.d(str);
    }

    @Nullable
    public AdSlot b() {
        return this.f27777c.a();
    }

    public void a() {
        File externalCacheDir;
        File[] listFiles;
        File file;
        File[] listFiles2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(this.f27776b.getDataDir(), "shared_prefs");
            } else {
                file = new File(this.f27776b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.f.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_reward_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles2) {
                    try {
                        String replace = file2.getName().replace(ActivityChooserModel.HISTORY_FILE_EXTENSION, "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.f27776b.deleteSharedPreferences(replace);
                        } else {
                            this.f27776b.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.openadsdk.utils.l.c(file2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.f27776b.getExternalCacheDir() != null) {
                externalCacheDir = this.f27776b.getExternalCacheDir();
            } else {
                externalCacheDir = this.f27776b.getCacheDir();
            }
            if (externalCacheDir == null || !externalCacheDir.exists() || !externalCacheDir.isDirectory() || (listFiles = externalCacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.f.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("reward_video_cache");
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
                this.f27777c.a(adSlot.getCodeId(), lVar.aL().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.f27777c.a(adSlot);
    }

    public static f a(Context context) {
        if (f27775a == null) {
            synchronized (f.class) {
                if (f27775a == null) {
                    f27775a = new f(context);
                }
            }
        }
        return f27775a;
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
        File a2 = a(this.f27776b, a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b()), str2);
        if (a2 != null && a2.exists() && a2.isFile()) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    private String a(String str, boolean z) {
        if (z) {
            return "reward_video_cache_" + str + "/";
        }
        return "/reward_video_cache_" + str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, l lVar, long j, @Nullable o oVar) {
        VAdError vAdError;
        Long remove = this.f27778d.remove(lVar);
        com.bytedance.sdk.openadsdk.c.d.f(this.f27776b, lVar, "rewarded_video", z ? "load_video_success" : "load_video_error", ak.a(z, lVar, remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue(), j, (z || oVar == null || (vAdError = oVar.f65741c) == null) ? null : vAdError.getMessage()));
    }

    public void a(final l lVar, final a<Object> aVar) {
        this.f27778d.put(lVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (lVar != null && lVar.X() != null && !TextUtils.isEmpty(lVar.X().i())) {
            String i = lVar.X().i();
            String l = lVar.X().l();
            if (TextUtils.isEmpty(l)) {
                l = com.bytedance.sdk.openadsdk.utils.j.a(i);
            }
            final String str = l;
            int d2 = ak.d(lVar.ap());
            String a2 = a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b());
            u.f("wzj", "ritId:" + d2 + ",cacheDirPath=" + a2);
            final File a3 = a(this.f27776b, a2, str);
            StringBuilder sb = new StringBuilder();
            sb.append("RewardVideoCache downloadVideo target.getPath() ");
            sb.append(a3.getPath());
            u.b("splashLoadAd", sb.toString());
            com.bytedance.sdk.openadsdk.i.e.c().a(i, new b.InterfaceC1796b() { // from class: com.bytedance.sdk.openadsdk.component.reward.f.3
                @Override // d.c.c.b.b.b.InterfaceC1796b
                public File a(String str2) {
                    try {
                        File parentFile = a3.getParentFile();
                        if (parentFile == null || !parentFile.exists()) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.core.i.d().q().a(str, parentFile);
                    } catch (IOException e2) {
                        u.f("RewardVideoCache", "datastoreGet throw IOException : " + e2.toString());
                        return null;
                    }
                }

                @Override // d.c.c.b.b.c.a
                public void a(long j, long j2) {
                }

                @Override // d.c.c.b.b.b.InterfaceC1796b
                public File b(String str2) {
                    return a3;
                }

                @Override // d.c.c.b.d.o.a
                public void b(o<File> oVar) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(false, null);
                    }
                    f.this.a(false, lVar, oVar == null ? -2L : oVar.f65746h, oVar);
                }

                @Override // d.c.c.b.b.b.InterfaceC1796b
                public void a(String str2, File file) {
                    if (file != null) {
                        f.this.a(file);
                    }
                }

                @Override // d.c.c.b.d.o.a
                public void a(o<File> oVar) {
                    if (oVar != null && oVar.f65739a != null && a3.exists()) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(true, null);
                        }
                        f.this.a(true, lVar, 0L, oVar);
                        return;
                    }
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(false, null);
                    }
                    f.this.a(false, lVar, oVar == null ? -3L : oVar.f65746h, oVar);
                }
            });
            return;
        }
        if (aVar != null) {
            aVar.a(false, null);
        }
        a(false, lVar, -1L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            com.bytedance.sdk.openadsdk.core.i.d().q().a(file);
        } catch (IOException e2) {
            u.f("RewardVideoCache", "trimFileCache IOException:" + e2.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        if (p.h().B() == 1) {
            u.f("splashLoadAd", "RewardVideoCache getDiskCacheDir 视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "RewardVideoCache getDiskCacheDir 视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }
}
