package com.bytedance.sdk.openadsdk.core.g;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.w;
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
import org.apache.http.HttpHost;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4439a;
    private String b;
    private Map<l, b> c = Collections.synchronizedMap(new HashMap());
    private Map<String, JSONObject> d = Collections.synchronizedMap(new HashMap());
    private AtomicBoolean e = new AtomicBoolean(false);
    private Set<String> f = Collections.synchronizedSet(new HashSet());
    private Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1020a {
        void a(boolean z);
    }

    public static a a() {
        if (f4439a == null) {
            synchronized (a.class) {
                if (f4439a == null) {
                    f4439a = new a();
                }
            }
        }
        return f4439a;
    }

    private a() {
    }

    public boolean a(l lVar) {
        if (this.e.get()) {
            if (lVar == null || lVar.R() == null || lVar.R().k() == null) {
                return false;
            }
            try {
                String a2 = j.a(lVar.R().k());
                if (this.d.get(a2) == null) {
                    return false;
                }
                return c(new File(c(), a2));
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    public void b() {
        if (!this.e.get()) {
            e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    try {
                        String c = a.this.c();
                        if (!TextUtils.isEmpty(c)) {
                            File file = new File(c);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    try {
                                        a.this.a(new File(file2, "tt_open_ad_sdk_check_res.dat"), true);
                                    } catch (Throwable th) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                    }
                    a.this.e.set(true);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] d;
        if (file != null) {
            try {
                if (file.exists() && file.isFile() && file.canRead() && (d = com.bytedance.sdk.openadsdk.utils.l.d(file)) != null && d.length > 0) {
                    String b2 = com.bytedance.sdk.openadsdk.core.a.b(new String(d), com.bytedance.sdk.openadsdk.core.b.d());
                    if (!TextUtils.isEmpty(b2)) {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (z && jSONObject.length() > 0) {
                            this.d.put(file.getParentFile().getName(), jSONObject);
                            return jSONObject;
                        }
                        return jSONObject;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        try {
            if (!this.e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                if (str3.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && str3.contains("?")) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith("/")) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
            } catch (Throwable th) {
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
                return null;
            }
            return null;
        } catch (Throwable th2) {
            u.c("PlayableCache", "playable intercept error: ", th2);
            return null;
        }
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
        if (file == null || !file.exists()) {
            return false;
        }
        JSONObject jSONObject = this.d.get(str);
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(str2);
        return optString != null && optString.equalsIgnoreCase(j.a(file));
    }

    public void a(final l lVar, final InterfaceC1020a interfaceC1020a) {
        if (lVar == null || lVar.R() == null || TextUtils.isEmpty(lVar.R().k())) {
            com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -701, (String) null);
            a(interfaceC1020a, false);
            return;
        }
        final String k = lVar.R().k();
        if (!this.f.contains(k)) {
            this.c.put(lVar, new b().a(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar);
            final String a2 = j.a(k);
            final File file = new File(c(), a2);
            if (c(file)) {
                com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -702, (String) null);
                b(file);
                this.c.remove(lVar);
                a(interfaceC1020a, true);
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.utils.l.c(file);
            } catch (Throwable th) {
            }
            this.f.add(k);
            d.a(p.a()).a(k, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.g.a.2
                @Override // com.bytedance.sdk.adnet.b.b.a
                public File a(String str) {
                    return null;
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public void a(String str, File file2) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File b(String str) {
                    return new File(a.this.d(), a2 + ".zip");
                }

                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void a(final o<File> oVar) {
                    a.this.f.remove(k);
                    final b bVar = (b) a.this.c.remove(lVar);
                    if (bVar != null) {
                        bVar.b(System.currentTimeMillis());
                    }
                    if (oVar != null && oVar.f4049a != null) {
                        e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z;
                                long j;
                                long j2;
                                try {
                                    if (bVar != null) {
                                        bVar.c(System.currentTimeMillis());
                                    }
                                    am.a(((File) oVar.f4049a).getAbsolutePath(), a.this.c());
                                    if (bVar != null) {
                                        bVar.d(System.currentTimeMillis());
                                    }
                                    if (bVar != null) {
                                        j2 = bVar.a();
                                        j = bVar.b();
                                    } else {
                                        j = 0;
                                        j2 = 0;
                                    }
                                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, j2, j);
                                    a.this.a(file);
                                    try {
                                        a.this.a(new File(file, "tt_open_ad_sdk_check_res.dat"), true);
                                    } catch (Throwable th2) {
                                    }
                                    z = true;
                                } catch (Throwable th3) {
                                    u.c("PlayableCache", "unzip error: ", th3);
                                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -704, th3.getMessage());
                                    z = false;
                                }
                                try {
                                    ((File) oVar.f4049a).delete();
                                } catch (Throwable th4) {
                                }
                                a.this.a(interfaceC1020a, z);
                            }
                        }, 5);
                        return;
                    }
                    int i = -700;
                    if (oVar != null && oVar.h != 0) {
                        i = Long.valueOf(oVar.h).intValue();
                    }
                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, i, (String) null);
                    a.this.a(interfaceC1020a, false);
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void b(o<File> oVar) {
                    a.this.f.remove(k);
                    a.this.c.remove(lVar);
                    int i = -700;
                    String str = null;
                    if (oVar != null) {
                        if (oVar.h != 0) {
                            i = Long.valueOf(oVar.h).intValue();
                        } else if (oVar.pxT != null && oVar.pxT.networkResponse != null && oVar.pxT.networkResponse.f4046a != 0) {
                            i = oVar.pxT.networkResponse.f4046a;
                        }
                        if (oVar.pxT != null) {
                            str = oVar.pxT.getMessage();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, i, str);
                    a.this.a(interfaceC1020a, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC1020a interfaceC1020a, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (interfaceC1020a != null) {
                interfaceC1020a.a(z);
            }
        } else if (interfaceC1020a != null) {
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC1020a != null) {
                        interfaceC1020a.a(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        b(file);
        try {
            i.d().r().a(file);
        } catch (Throwable th) {
        }
    }

    private void b(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!file.setLastModified(currentTimeMillis)) {
                    file.renameTo(file);
                    if (file.lastModified() < currentTimeMillis) {
                        u.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                    }
                }
            }
        } catch (Throwable th) {
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
    public String c() {
        File file = new File(d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        File externalCacheDir;
        if (TextUtils.isEmpty(this.b)) {
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
                this.b = file.getAbsolutePath();
            } catch (Throwable th) {
                u.f("PlayableCache", "init root path error: " + th);
            }
        }
        return this.b;
    }

    /* loaded from: classes6.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        long f4445a;
        long b;
        long c;
        long d;

        private b() {
        }

        public long a() {
            return this.b - this.f4445a;
        }

        public long b() {
            return this.d - this.c;
        }

        public b a(long j) {
            this.f4445a = j;
            return this;
        }

        public b b(long j) {
            this.b = j;
            return this;
        }

        public b c(long j) {
            this.c = j;
            return this;
        }

        public b d(long j) {
            this.d = j;
            return this;
        }
    }
}
