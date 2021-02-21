package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.p;
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
    private final ExecutorService f5999a = Executors.newCachedThreadPool();
    private int c = 50;
    private final Map<String, a> e = Collections.synchronizedMap(new HashMap());
    private final Map<String, a> f = Collections.synchronizedMap(new HashMap());
    private final Handler g = new Handler(Looper.getMainLooper());
    private final o pvb;
    private final b pvc;

    /* loaded from: classes6.dex */
    public interface b {
        Bitmap a(String str);

        String a(String str, int i, int i2, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap);
    }

    /* renamed from: com.bytedance.sdk.adnet.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0999d extends p.a<Bitmap> {
        void a();

        void a(c cVar, boolean z);

        void b();
    }

    public d(o oVar, b bVar) {
        this.pvb = oVar;
        this.pvc = bVar == null ? new com.bytedance.sdk.adnet.b.a() : bVar;
    }

    public void a(String str, InterfaceC0999d interfaceC0999d) {
        a(str, interfaceC0999d, 0, 0);
    }

    public void a(String str, InterfaceC0999d interfaceC0999d, int i, int i2) {
        a(str, interfaceC0999d, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC0999d interfaceC0999d, final int i, final int i2, final ImageView.ScaleType scaleType) {
        this.f5999a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(str, interfaceC0999d, i, i2, scaleType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, final InterfaceC0999d interfaceC0999d, int i, int i2, ImageView.ScaleType scaleType) {
        this.g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                interfaceC0999d.a();
            }
        });
        String a2 = a(str, i, i2, scaleType);
        Bitmap a3 = this.pvc.a(a2);
        if (a3 != null) {
            final c cVar = new c(a3, str, null, null);
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.3
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0999d.a(cVar, true);
                    interfaceC0999d.b();
                }
            });
            return;
        }
        c cVar2 = new c(null, str, a2, interfaceC0999d);
        a aVar = this.e.get(a2);
        if (aVar == null) {
            aVar = this.f.get(a2);
        }
        if (aVar != null) {
            aVar.a(cVar2);
            return;
        }
        Request<Bitmap> b2 = b(str, i, i2, scaleType, a2);
        this.pvb.j(b2);
        this.e.put(a2, new a(b2, cVar2));
    }

    protected Request<Bitmap> b(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new e(str, new p.a<Bitmap>() { // from class: com.bytedance.sdk.adnet.b.d.4
            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(final p<Bitmap> pVar) {
                d.this.f5999a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.a(str2, pVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(final p<Bitmap> pVar) {
                d.this.f5999a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.b(str2, pVar);
                    }
                });
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
    }

    protected void a(String str, p<Bitmap> pVar) {
        this.pvc.a(str, pVar.f6047a);
        a remove = this.e.remove(str);
        if (remove == null) {
            return;
        }
        remove.c = pVar.f6047a;
        remove.a(pVar);
        a(str, remove);
    }

    protected void b(String str, p<Bitmap> pVar) {
        a remove = this.e.remove(str);
        if (remove != null) {
            remove.b(pVar.pvP);
            remove.a(pVar);
            a(str, remove);
        }
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f6004b;
        private final String d;
        private final String e;
        private final InterfaceC0999d pvm;

        public c(Bitmap bitmap, String str, String str2, InterfaceC0999d interfaceC0999d) {
            this.f6004b = bitmap;
            this.e = str;
            this.d = str2;
            this.pvm = interfaceC0999d;
        }

        public Bitmap a() {
            return this.f6004b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        private p<Bitmap> f6003b;
        private Bitmap c;
        private VAdError d;
        private final List<c> e = Collections.synchronizedList(new ArrayList());
        private final Request<?> pvl;

        public a(Request<?> request, c cVar) {
            this.pvl = request;
            this.e.add(cVar);
        }

        public void b(VAdError vAdError) {
            this.d = vAdError;
        }

        public VAdError eqN() {
            return this.d;
        }

        public p<Bitmap> eqO() {
            return this.f6003b;
        }

        public void a(p<Bitmap> pVar) {
            this.f6003b = pVar;
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
                        if (cVar.pvm != null) {
                            if (aVar2.eqN() == null) {
                                cVar.f6004b = aVar2.c;
                                cVar.pvm.a(cVar, false);
                            } else {
                                cVar.pvm.b(aVar2.eqO());
                            }
                            cVar.pvm.b();
                        }
                    }
                }
                d.this.f.remove(str);
            }
        }, this.c);
    }

    private String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        String a2 = this.pvc.a(str, i, i2, scaleType);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append("#S").append(scaleType.ordinal()).append(str).toString();
    }
}
