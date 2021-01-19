package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.e.b;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.Map;
/* loaded from: classes4.dex */
public class p<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f6045a;
    public boolean d;
    public long e;
    public long f;
    public Map<String, Object> g;
    public long h;
    public final b.a pkZ;
    public final VAdError pla;

    /* loaded from: classes4.dex */
    public interface a<T> {
        void a(p<T> pVar);

        void b(p<T> pVar);
    }

    public static <T> p<T> a(T t, b.a aVar) {
        return new p<>(t, aVar);
    }

    public static <T> p<T> c(VAdError vAdError) {
        return new p<>(vAdError);
    }

    @Nullable
    public Object a(String str) {
        if (TextUtils.isEmpty(str) || this.g == null) {
            return null;
        }
        return this.g.get(str);
    }

    public boolean a() {
        return this.pla == null;
    }

    private p(T t, b.a aVar) {
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.f6045a = t;
        this.pkZ = aVar;
        this.pla = null;
        if (aVar != null) {
            this.h = aVar.f6061a;
        }
    }

    private p(VAdError vAdError) {
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.f6045a = null;
        this.pkZ = null;
        this.pla = vAdError;
        if (this.h == 0 && vAdError != null && vAdError.networkResponse != null) {
            this.h = vAdError.networkResponse.f6040a;
        }
    }

    public p ir(long j) {
        this.e = j;
        return this;
    }

    public p is(long j) {
        this.f = j;
        return this;
    }

    public String a(String str, @Nullable String str2) {
        if (this.pkZ == null || this.pkZ.h == null) {
            return str2;
        }
        String str3 = this.pkZ.h.get(str);
        return str3 == null ? str2 : str3;
    }
}
