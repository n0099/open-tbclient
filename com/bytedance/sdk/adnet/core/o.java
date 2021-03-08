package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.e.b;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.Map;
/* loaded from: classes6.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f4049a;
    public boolean d;
    public long e;
    public long f;
    public Map<String, Object> g;
    public long h;
    public final b.a pxS;
    public final VAdError pxT;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public static <T> o<T> a(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public static <T> o<T> c(VAdError vAdError) {
        return new o<>(vAdError);
    }

    @Nullable
    public Object a(String str) {
        if (TextUtils.isEmpty(str) || this.g == null) {
            return null;
        }
        return this.g.get(str);
    }

    public boolean a() {
        return this.pxT == null;
    }

    private o(T t, b.a aVar) {
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.f4049a = t;
        this.pxS = aVar;
        this.pxT = null;
        if (aVar != null) {
            this.h = aVar.f4058a;
        }
    }

    private o(VAdError vAdError) {
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.f4049a = null;
        this.pxS = null;
        this.pxT = vAdError;
        if (this.h == 0 && vAdError != null && vAdError.networkResponse != null) {
            this.h = vAdError.networkResponse.f4046a;
        }
    }

    public o iu(long j) {
        this.e = j;
        return this;
    }

    public o iv(long j) {
        this.f = j;
        return this;
    }

    public String a(String str, @Nullable String str2) {
        if (this.pxS == null || this.pxS.h == null) {
            return str2;
        }
        String str3 = this.pxS.h.get(str);
        return str3 == null ? str2 : str3;
    }
}
