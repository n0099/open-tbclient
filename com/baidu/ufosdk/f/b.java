package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22941a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22942b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f22943c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f22944d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f22944d = aVar;
        this.f22941a = str;
        this.f22942b = str2;
        this.f22943c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f22941a);
            if (a2 == null) {
                this.f22943c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f22939b;
            hashMap.put(this.f22942b, new SoftReference(a2));
            f.a().a(a2, this.f22942b);
            this.f22943c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
