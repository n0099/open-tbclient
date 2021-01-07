package com.bytedance.sdk.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.core.r;
import com.bytedance.sdk.adnet.e.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    @NonNull
    private final o c;
    private Context d;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6293b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, C1009b> f6292a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes4.dex */
    public interface a extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull o oVar) {
        this.d = context;
        this.c = oVar;
    }

    public void a(String str, a aVar) {
        a(str, aVar, true);
    }

    public void a(String str, final a aVar, boolean z) {
        C1009b c1009b;
        if (!TextUtils.isEmpty(str)) {
            if (a(str) && (c1009b = this.f6292a.get(str)) != null) {
                c1009b.a(aVar);
                return;
            }
            final File a2 = aVar.a(str);
            if (a2 != null && aVar != null) {
                this.f6293b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(a2.length(), a2.length());
                        aVar.a(p.a(a2, (b.a) null));
                    }
                });
            } else {
                a(b(str, aVar, z));
            }
        }
    }

    private void a(C1009b c1009b) {
        if (c1009b != null) {
            c1009b.a();
            this.f6292a.put(c1009b.f6295a, c1009b);
        }
    }

    private boolean a(String str) {
        return this.f6292a.containsKey(str);
    }

    private C1009b b(String str, a aVar, boolean z) {
        String absolutePath;
        File file = null;
        if (aVar != null) {
            file = aVar.b(str);
        }
        if (file == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = file.getAbsolutePath();
        }
        return new C1009b(str, absolutePath, aVar, z);
    }

    private String a() {
        File file = new File(com.bytedance.sdk.adnet.a.b(this.d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.adnet.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1009b {

        /* renamed from: a  reason: collision with root package name */
        String f6295a;

        /* renamed from: b  reason: collision with root package name */
        String f6296b;
        List<a> c;
        boolean d;
        c poM;

        C1009b(String str, String str2, a aVar, boolean z) {
            this.f6295a = str;
            this.f6296b = str2;
            this.d = z;
            a(aVar);
        }

        void a(a aVar) {
            if (aVar != null) {
                if (this.c == null) {
                    this.c = Collections.synchronizedList(new ArrayList());
                }
                this.c.add(aVar);
            }
        }

        void a() {
            this.poM = new c(this.f6296b, this.f6295a, new c.a() { // from class: com.bytedance.sdk.adnet.b.b.b.1
                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                    if (C1009b.this.c != null) {
                        for (a aVar : C1009b.this.c) {
                            try {
                                aVar.a(j, j2);
                            } catch (Throwable th) {
                                r.a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void a(p<File> pVar) {
                    if (C1009b.this.c != null) {
                        for (a aVar : C1009b.this.c) {
                            try {
                                aVar.a(pVar);
                            } catch (Throwable th) {
                                r.a(th, "file loader onResponse error", new Object[0]);
                            }
                            try {
                                aVar.a(C1009b.this.f6295a, pVar.f6345a);
                            } catch (Throwable th2) {
                                r.a(th2, "file loader putFile error", new Object[0]);
                            }
                        }
                        C1009b.this.c.clear();
                    }
                    b.this.f6292a.remove(C1009b.this.f6295a);
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void b(p<File> pVar) {
                    if (C1009b.this.c != null) {
                        for (a aVar : C1009b.this.c) {
                            try {
                                aVar.b(pVar);
                            } catch (Throwable th) {
                                r.a(th, "file loader onErrorResponse error", new Object[0]);
                            }
                        }
                        C1009b.this.c.clear();
                    }
                    b.this.f6292a.remove(C1009b.this.f6295a);
                }
            });
            this.poM.setTag("FileLoader#" + this.f6295a);
            b.this.c.j(this.poM);
        }

        public boolean equals(Object obj) {
            return obj instanceof C1009b ? ((C1009b) obj).f6295a.equals(this.f6295a) : super.equals(obj);
        }
    }
}
