package com.bytedance.sdk.adnet.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.q;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public abstract class g<T> extends Request<T> {
    private static final String c = String.format("application/json; charset=%s", "utf-8");
    private final Object d;
    @Nullable
    @GuardedBy("mLock")
    private o.a<T> e;
    @Nullable
    private final String f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public abstract o<T> a(k kVar);

    public g(int i, String str, @Nullable String str2, @Nullable o.a<T> aVar) {
        super(i, str, aVar);
        this.d = new Object();
        this.e = aVar;
        this.f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.d) {
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<T> oVar) {
        o.a<T> aVar;
        synchronized (this.d) {
            aVar = this.e;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            if (this.f == null) {
                return null;
            }
            return this.f.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            q.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f, "utf-8");
            return null;
        }
    }
}
