package com.bytedance.sdk.openadsdk.core.g;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.an;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.w;
import d.c.c.b.b.b;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f28053a;

    /* renamed from: b  reason: collision with root package name */
    public String f28054b;

    /* renamed from: c  reason: collision with root package name */
    public Map<l, b> f28055c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    public Map<String, JSONObject> f28056d = Collections.synchronizedMap(new HashMap());

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f28057e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f28058f = Collections.synchronizedSet(new HashSet());

    /* renamed from: g  reason: collision with root package name */
    public Handler f28059g = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0312a {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f28075a;

        /* renamed from: b  reason: collision with root package name */
        public long f28076b;

        /* renamed from: c  reason: collision with root package name */
        public long f28077c;

        /* renamed from: d  reason: collision with root package name */
        public long f28078d;

        public b() {
        }

        public long a() {
            return this.f28076b - this.f28075a;
        }

        public long b() {
            return this.f28078d - this.f28077c;
        }

        public b c(long j) {
            this.f28077c = j;
            return this;
        }

        public b d(long j) {
            this.f28078d = j;
            return this;
        }

        public b a(long j) {
            this.f28075a = j;
            return this;
        }

        public b b(long j) {
            this.f28076b = j;
            return this;
        }
    }

    private boolean c(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        File externalCacheDir;
        if (TextUtils.isEmpty(this.f28054b)) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && p.a().getExternalCacheDir() != null) {
                    externalCacheDir = p.a().getExternalCacheDir();
                } else {
                    externalCacheDir = p.a().getCacheDir();
                }
                File file = new File(externalCacheDir, "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f28054b = file.getAbsolutePath();
            } catch (Throwable th) {
                u.f("PlayableCache", "init root path error: " + th);
            }
        }
        return this.f28054b;
    }

    public void b() {
        if (this.f28057e.get()) {
            return;
        }
        e.a(new g("PlayableCache") { // from class: com.bytedance.sdk.openadsdk.core.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    String c2 = a.this.c();
                    if (!TextUtils.isEmpty(c2)) {
                        File file = new File(c2);
                        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                            for (File file2 : listFiles) {
                                try {
                                    a.this.a(new File(file2, "tt_open_ad_sdk_check_res.dat"), true);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                a.this.f28057e.set(true);
            }
        }, 5);
    }

    private void b(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(currentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < currentTimeMillis) {
                    u.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static a a() {
        if (f28053a == null) {
            synchronized (a.class) {
                if (f28053a == null) {
                    f28053a = new a();
                }
            }
        }
        return f28053a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        File file = new File(d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public boolean a(l lVar) {
        if (this.f28057e.get() && lVar != null && lVar.X() != null && lVar.X().k() != null) {
            try {
                String a2 = j.a(lVar.X().k());
                if (this.f28056d.get(a2) == null) {
                    return false;
                }
                return c(new File(c(), a2));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] d2;
        if (file != null) {
            try {
                if (file.exists() && file.isFile() && file.canRead() && (d2 = com.bytedance.sdk.openadsdk.utils.l.d(file)) != null && d2.length > 0) {
                    String b2 = com.bytedance.sdk.openadsdk.core.a.b(new String(d2), com.bytedance.sdk.openadsdk.core.b.d());
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    if (z && jSONObject.length() > 0) {
                        this.f28056d.put(file.getParentFile().getName(), jSONObject);
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        try {
        } catch (Throwable th) {
            u.c("PlayableCache", "playable intercept error: ", th);
        }
        if (!this.f28057e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            if (str3.startsWith("http") && str3.contains("?")) {
                str3 = str3.split("\\?")[0];
                if (str3.endsWith("/")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
            }
        } catch (Throwable unused) {
        }
        String a2 = w.a(p.a(), str3);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = j.a(str);
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        File file = new File(c(), a3);
        if (c(file)) {
            String a4 = a(str2);
            if (TextUtils.isEmpty(a4)) {
                return null;
            }
            String replace = str3.replace(a4, "");
            if (TextUtils.isEmpty(replace)) {
                return null;
            }
            File file2 = new File(file, replace);
            if (a(a3, replace, file2)) {
                return new WebResourceResponse(a2, "utf-8", new FileInputStream(file2));
            }
        }
        return null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            if (split[0] != null && split[0].endsWith("/")) {
                str = str.substring(0, split.length - 1);
            }
            if (split[0] != null && split[0].endsWith("index.html")) {
                str = split[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean a(String str, String str2, File file) {
        JSONObject jSONObject;
        String optString;
        return (file == null || !file.exists() || (jSONObject = this.f28056d.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(j.a(file))) ? false : true;
    }

    public void a(final l lVar, final InterfaceC0312a interfaceC0312a) {
        if (lVar != null && lVar.X() != null && !TextUtils.isEmpty(lVar.X().k())) {
            final String k = lVar.X().k();
            if (this.f28058f.contains(k)) {
                return;
            }
            this.f28055c.put(lVar, new b().a(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar);
            final String a2 = j.a(k);
            final File file = new File(c(), a2);
            if (c(file)) {
                com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -702, (String) null);
                b(file);
                this.f28055c.remove(lVar);
                a(interfaceC0312a, true);
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.utils.l.c(file);
            } catch (Throwable unused) {
            }
            this.f28058f.add(k);
            com.bytedance.sdk.openadsdk.i.e.c().a(k, new b.InterfaceC1827b() { // from class: com.bytedance.sdk.openadsdk.core.g.a.2
                @Override // d.c.c.b.b.b.InterfaceC1827b
                public File a(String str) {
                    return null;
                }

                @Override // d.c.c.b.b.c.a
                public void a(long j, long j2) {
                }

                @Override // d.c.c.b.d.o.a
                public void a(final o<File> oVar) {
                    a.this.f28058f.remove(k);
                    final b bVar = (b) a.this.f28055c.remove(lVar);
                    if (bVar != null) {
                        bVar.b(System.currentTimeMillis());
                    }
                    if (oVar != null && oVar.f66679a != null) {
                        e.a(new g("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.g.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long j;
                                long j2;
                                boolean z = true;
                                try {
                                    if (bVar != null) {
                                        bVar.c(System.currentTimeMillis());
                                    }
                                    an.a(((File) oVar.f66679a).getAbsolutePath(), a.this.c());
                                    if (bVar != null) {
                                        bVar.d(System.currentTimeMillis());
                                    }
                                    if (bVar != null) {
                                        long a3 = bVar.a();
                                        j = bVar.b();
                                        j2 = a3;
                                    } else {
                                        j = 0;
                                        j2 = 0;
                                    }
                                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, j2, j);
                                    a.this.a(file);
                                    try {
                                        a.this.a(new File(file, "tt_open_ad_sdk_check_res.dat"), true);
                                    } catch (Throwable unused2) {
                                    }
                                } catch (Throwable th) {
                                    u.c("PlayableCache", "unzip error: ", th);
                                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -704, th.getMessage());
                                    z = false;
                                }
                                try {
                                    ((File) oVar.f66679a).delete();
                                } catch (Throwable unused3) {
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                a.this.a(interfaceC0312a, z);
                            }
                        }, 5);
                        return;
                    }
                    int i = -700;
                    if (oVar != null) {
                        long j = oVar.f66686h;
                        if (j != 0) {
                            i = Long.valueOf(j).intValue();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, i, (String) null);
                    a.this.a(interfaceC0312a, false);
                }

                @Override // d.c.c.b.b.b.InterfaceC1827b
                public void a(String str, File file2) {
                }

                @Override // d.c.c.b.b.b.InterfaceC1827b
                public File b(String str) {
                    String d2 = a.this.d();
                    return new File(d2, a2 + ".zip");
                }

                @Override // d.c.c.b.d.o.a
                public void b(o<File> oVar) {
                    k kVar;
                    int i;
                    a.this.f28058f.remove(k);
                    a.this.f28055c.remove(lVar);
                    int i2 = -700;
                    String str = null;
                    if (oVar != null) {
                        long j = oVar.f66686h;
                        if (j != 0) {
                            i2 = Long.valueOf(j).intValue();
                        } else {
                            VAdError vAdError = oVar.f66681c;
                            if (vAdError != null && (kVar = vAdError.networkResponse) != null && (i = kVar.f66663a) != 0) {
                                i2 = i;
                            }
                        }
                        VAdError vAdError2 = oVar.f66681c;
                        if (vAdError2 != null) {
                            str = vAdError2.getMessage();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, i2, str);
                    a.this.a(interfaceC0312a, false);
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -701, (String) null);
        a(interfaceC0312a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC0312a interfaceC0312a, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (interfaceC0312a != null) {
                interfaceC0312a.a(z);
            }
        } else if (interfaceC0312a != null) {
            this.f28059g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0312a interfaceC0312a2 = interfaceC0312a;
                    if (interfaceC0312a2 != null) {
                        interfaceC0312a2.a(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        b(file);
        try {
            i.d().s().a(file);
        } catch (Throwable unused) {
        }
    }
}
