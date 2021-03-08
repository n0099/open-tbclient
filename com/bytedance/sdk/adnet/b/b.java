package com.bytedance.sdk.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.q;
import com.bytedance.sdk.adnet.e.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    @NonNull
    private final n c;
    private Context d;
    private final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, C1006b> f4021a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes6.dex */
    public interface a extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.d = context;
        this.c = nVar;
    }

    public void a(String str, a aVar) {
        a(str, aVar, true);
    }

    public void a(String str, final a aVar, boolean z) {
        C1006b c1006b;
        if (!TextUtils.isEmpty(str)) {
            if (a(str) && (c1006b = this.f4021a.get(str)) != null) {
                c1006b.a(aVar);
                return;
            }
            final File a2 = aVar.a(str);
            if (a2 != null && aVar != null) {
                this.b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(a2.length(), a2.length());
                        aVar.a(o.a(a2, (b.a) null));
                    }
                });
            } else {
                a(b(str, aVar, z));
            }
        }
    }

    private void a(C1006b c1006b) {
        if (c1006b != null) {
            c1006b.a();
            this.f4021a.put(c1006b.f4022a, c1006b);
        }
    }

    private boolean a(String str) {
        return this.f4021a.containsKey(str);
    }

    private C1006b b(String str, a aVar, boolean z) {
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
        return new C1006b(str, absolutePath, aVar, z);
    }

    private String a() {
        File file = new File(com.bytedance.sdk.adnet.a.b(this.d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.adnet.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1006b {

        /* renamed from: a  reason: collision with root package name */
        String f4022a;
        String b;
        List<a> c;
        boolean d;
        c pxc;

        C1006b(String str, String str2, a aVar, boolean z) {
            this.f4022a = str;
            this.b = str2;
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
            this.pxc = new c(this.b, this.f4022a, new c.a() { // from class: com.bytedance.sdk.adnet.b.b.b.1
                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                    if (C1006b.this.c != null) {
                        for (a aVar : C1006b.this.c) {
                            try {
                                aVar.a(j, j2);
                            } catch (Throwable th) {
                                q.a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void a(o<File> oVar) {
                    if (C1006b.this.c != null) {
                        for (a aVar : C1006b.this.c) {
                            try {
                                aVar.a(oVar);
                            } catch (Throwable th) {
                                q.a(th, "file loader onResponse error", new Object[0]);
                            }
                            try {
                                aVar.a(C1006b.this.f4022a, oVar.f4049a);
                            } catch (Throwable th2) {
                                q.a(th2, "file loader putFile error", new Object[0]);
                            }
                        }
                        C1006b.this.c.clear();
                    }
                    b.this.f4021a.remove(C1006b.this.f4022a);
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void b(o<File> oVar) {
                    if (C1006b.this.c != null) {
                        for (a aVar : C1006b.this.c) {
                            try {
                                aVar.b(oVar);
                            } catch (Throwable th) {
                                q.a(th, "file loader onErrorResponse error", new Object[0]);
                            }
                        }
                        C1006b.this.c.clear();
                    }
                    b.this.f4021a.remove(C1006b.this.f4022a);
                }
            });
            this.pxc.setTag("FileLoader#" + this.f4022a);
            b.this.c.j(this.pxc);
        }

        public boolean equals(Object obj) {
            return obj instanceof C1006b ? ((C1006b) obj).f4022a.equals(this.f4022a) : super.equals(obj);
        }
    }
}
