package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22614a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22615b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f22616c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f22617d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f22617d = aVar;
        this.f22614a = str;
        this.f22615b = str2;
        this.f22616c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f22614a);
            if (a2 == null) {
                this.f22616c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f22612b;
            hashMap.put(this.f22615b, new SoftReference(a2));
            f.a().a(a2, this.f22615b);
            this.f22616c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
