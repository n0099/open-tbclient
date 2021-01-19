package com.bytedance.sdk.openadsdk.core.g;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.an;
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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6553a;

    /* renamed from: b  reason: collision with root package name */
    private String f6554b;
    private Map<l, b> c = Collections.synchronizedMap(new HashMap());
    private Map<String, JSONObject> d = Collections.synchronizedMap(new HashMap());
    private AtomicBoolean e = new AtomicBoolean(false);
    private Set<String> f = Collections.synchronizedSet(new HashSet());
    private Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1003a {
        void a(boolean z);
    }

    public static a a() {
        if (f6553a == null) {
            synchronized (a.class) {
                if (f6553a == null) {
                    f6553a = new a();
                }
            }
        }
        return f6553a;
    }

    private a() {
    }

    public boolean a(l lVar) {
        if (this.e.get()) {
            if (lVar == null || lVar.F() == null || lVar.F().j() == null) {
                return false;
            }
            try {
                String a2 = j.a(lVar.F().j());
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
            com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.1
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

    public void a(final l lVar, final InterfaceC1003a interfaceC1003a) {
        if (lVar == null || lVar.F() == null || TextUtils.isEmpty(lVar.F().j())) {
            com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -701, (String) null);
            a(interfaceC1003a, false);
            return;
        }
        final String j = lVar.F().j();
        if (!this.f.contains(j)) {
            this.c.put(lVar, new b().a(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar);
            final String a2 = j.a(j);
            final File file = new File(c(), a2);
            if (c(file)) {
                com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, -702, (String) null);
                b(file);
                this.c.remove(lVar);
                a(interfaceC1003a, true);
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.utils.l.c(file);
            } catch (Throwable th) {
            }
            this.f.add(j);
            e.a(p.a()).a(j, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.g.a.2
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
                public void a(long j2, long j3) {
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void a(final com.bytedance.sdk.adnet.core.p<File> pVar) {
                    a.this.f.remove(j);
                    final b bVar = (b) a.this.c.remove(lVar);
                    if (bVar != null) {
                        bVar.b(System.currentTimeMillis());
                    }
                    if (pVar != null && pVar.f6045a != null) {
                        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z;
                                long j2;
                                long j3;
                                try {
                                    if (bVar != null) {
                                        bVar.c(System.currentTimeMillis());
                                    }
                                    an.a(((File) pVar.f6045a).getAbsolutePath(), a.this.c());
                                    if (bVar != null) {
                                        bVar.d(System.currentTimeMillis());
                                    }
                                    if (bVar != null) {
                                        j3 = bVar.a();
                                        j2 = bVar.b();
                                    } else {
                                        j2 = 0;
                                        j3 = 0;
                                    }
                                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, j3, j2);
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
                                    ((File) pVar.f6045a).delete();
                                } catch (Throwable th4) {
                                }
                                a.this.a(interfaceC1003a, z);
                            }
                        }, 5);
                        return;
                    }
                    int i = -700;
                    if (pVar != null && pVar.h != 0) {
                        i = Long.valueOf(pVar.h).intValue();
                    }
                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, i, (String) null);
                    a.this.a(interfaceC1003a, false);
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void b(com.bytedance.sdk.adnet.core.p<File> pVar) {
                    a.this.f.remove(j);
                    a.this.c.remove(lVar);
                    int i = -700;
                    String str = null;
                    if (pVar != null) {
                        if (pVar.h != 0) {
                            i = Long.valueOf(pVar.h).intValue();
                        } else if (pVar.pla != null && pVar.pla.networkResponse != null && pVar.pla.networkResponse.f6040a != 0) {
                            i = pVar.pla.networkResponse.f6040a;
                        }
                        if (pVar.pla != null) {
                            str = pVar.pla.getMessage();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.g.b.a(p.a(), lVar, i, str);
                    a.this.a(interfaceC1003a, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC1003a interfaceC1003a, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (interfaceC1003a != null) {
                interfaceC1003a.a(z);
            }
        } else if (interfaceC1003a != null) {
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC1003a != null) {
                        interfaceC1003a.a(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        b(file);
        try {
            i.c().q().a(file);
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
        if (TextUtils.isEmpty(this.f6554b)) {
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
                this.f6554b = file.getAbsolutePath();
            } catch (Throwable th) {
                u.f("PlayableCache", "init root path error: " + th);
            }
        }
        return this.f6554b;
    }

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        long f6564a;

        /* renamed from: b  reason: collision with root package name */
        long f6565b;
        long c;
        long d;

        private b() {
        }

        public long a() {
            return this.f6565b - this.f6564a;
        }

        public long b() {
            return this.d - this.c;
        }

        public b a(long j) {
            this.f6564a = j;
            return this;
        }

        public b b(long j) {
            this.f6565b = j;
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
