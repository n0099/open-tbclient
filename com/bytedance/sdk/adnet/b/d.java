package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f4023a = Executors.newCachedThreadPool();
    private int c = 50;
    private final Map<String, a> e = Collections.synchronizedMap(new HashMap());
    private final Map<String, a> f = Collections.synchronizedMap(new HashMap());
    private final Handler g = new Handler(Looper.getMainLooper());
    private final n pxg;
    private final b pxh;

    /* loaded from: classes6.dex */
    public interface b {
        Bitmap a(String str);

        String a(String str, int i, int i2, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap);
    }

    /* renamed from: com.bytedance.sdk.adnet.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1007d extends o.a<Bitmap> {
        void a();

        void a(c cVar, boolean z);

        void b();
    }

    public d(n nVar, b bVar) {
        this.pxg = nVar;
        this.pxh = bVar == null ? new com.bytedance.sdk.adnet.b.a() : bVar;
    }

    public void a(String str, InterfaceC1007d interfaceC1007d) {
        a(str, interfaceC1007d, 0, 0);
    }

    public void a(String str, InterfaceC1007d interfaceC1007d, int i, int i2) {
        a(str, interfaceC1007d, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC1007d interfaceC1007d, final int i, final int i2, final ImageView.ScaleType scaleType) {
        this.f4023a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(str, interfaceC1007d, i, i2, scaleType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, final InterfaceC1007d interfaceC1007d, int i, int i2, ImageView.ScaleType scaleType) {
        this.g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                interfaceC1007d.a();
            }
        });
        String a2 = a(str, i, i2, scaleType);
        Bitmap a3 = this.pxh.a(a2);
        if (a3 != null) {
            final c cVar = new c(a3, str, null, null);
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.3
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC1007d.a(cVar, true);
                    interfaceC1007d.b();
                }
            });
            return;
        }
        c cVar2 = new c(null, str, a2, interfaceC1007d);
        a aVar = this.e.get(a2);
        if (aVar == null) {
            aVar = this.f.get(a2);
        }
        if (aVar != null) {
            aVar.a(cVar2);
            return;
        }
        Request<Bitmap> b2 = b(str, i, i2, scaleType, a2);
        this.pxg.j(b2);
        this.e.put(a2, new a(b2, cVar2));
    }

    protected Request<Bitmap> b(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new e(str, new o.a<Bitmap>() { // from class: com.bytedance.sdk.adnet.b.d.4
            @Override // com.bytedance.sdk.adnet.core.o.a
            public void a(final o<Bitmap> oVar) {
                d.this.f4023a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.a(str2, oVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.adnet.core.o.a
            public void b(final o<Bitmap> oVar) {
                d.this.f4023a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.b(str2, oVar);
                    }
                });
            }
        }, i, i2, scaleType, Bitmap.Config.ARGB_4444);
    }

    protected void a(String str, o<Bitmap> oVar) {
        this.pxh.a(str, oVar.f4049a);
        a remove = this.e.remove(str);
        if (remove == null) {
            return;
        }
        remove.c = oVar.f4049a;
        remove.a(oVar);
        a(str, remove);
    }

    protected void b(String str, o<Bitmap> oVar) {
        a remove = this.e.remove(str);
        if (remove != null) {
            remove.b(oVar.pxT);
            remove.a(oVar);
            a(str, remove);
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        private Bitmap b;
        private final String d;
        private final String e;
        private final InterfaceC1007d pxr;

        public c(Bitmap bitmap, String str, String str2, InterfaceC1007d interfaceC1007d) {
            this.b = bitmap;
            this.e = str;
            this.d = str2;
            this.pxr = interfaceC1007d;
        }

        public Bitmap a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private o<Bitmap> b;
        private Bitmap c;
        private VAdError d;
        private final List<c> e = Collections.synchronizedList(new ArrayList());
        private final Request<?> pxq;

        public a(Request<?> request, c cVar) {
            this.pxq = request;
            this.e.add(cVar);
        }

        public void b(VAdError vAdError) {
            this.d = vAdError;
        }

        public VAdError eqV() {
            return this.d;
        }

        public o<Bitmap> eqW() {
            return this.b;
        }

        public void a(o<Bitmap> oVar) {
            this.b = oVar;
        }

        public void a(c cVar) {
            this.e.add(cVar);
        }
    }

    private void a(final String str, a aVar) {
        this.f.put(str, aVar);
        this.g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = (a) d.this.f.get(str);
                if (aVar2 != null) {
                    for (c cVar : aVar2.e) {
                        if (cVar.pxr != null) {
                            if (aVar2.eqV() == null) {
                                cVar.b = aVar2.c;
                                cVar.pxr.a(cVar, false);
                            } else {
                                cVar.pxr.b(aVar2.eqW());
                            }
                            cVar.pxr.b();
                        }
                    }
                }
                d.this.f.remove(str);
            }
        }, this.c);
    }

    private String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        String a2 = this.pxh.a(str, i, i2, scaleType);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append("#S").append(scaleType.ordinal()).append(str).toString();
    }
}
