package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.e.b;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.Map;
/* loaded from: classes6.dex */
public class p<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f6047a;
    public boolean d;
    public long e;
    public long f;
    public Map<String, Object> g;
    public long h;
    public final b.a pvo;
    public final VAdError pvp;

    /* loaded from: classes6.dex */
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
        return this.pvp == null;
    }

    private p(T t, b.a aVar) {
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.f6047a = t;
        this.pvo = aVar;
        this.pvp = null;
        if (aVar != null) {
            this.h = aVar.f6063a;
        }
    }

    private p(VAdError vAdError) {
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.f6047a = null;
        this.pvo = null;
        this.pvp = vAdError;
        if (this.h == 0 && vAdError != null && vAdError.networkResponse != null) {
            this.h = vAdError.networkResponse.f6042a;
        }
    }

    public p iu(long j) {
        this.e = j;
        return this;
    }

    public p iv(long j) {
        this.f = j;
        return this;
    }

    public String a(String str, @Nullable String str2) {
        if (this.pvo == null || this.pvo.h == null) {
            return str2;
        }
        String str3 = this.pvo.h.get(str);
        return str3 == null ? str2 : str3;
    }
}
