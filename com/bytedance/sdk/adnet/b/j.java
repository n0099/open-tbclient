package com.bytedance.sdk.adnet.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.o;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public class j extends Request<String> {
    private final Object c;
    @Nullable
    @GuardedBy("mLock")
    private o.a<String> d;

    public j(int i, String str, @Nullable o.a<String> aVar) {
        super(i, str, aVar);
        this.c = new Object();
        this.d = aVar;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<String> oVar) {
        o.a<String> aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public o<String> a(k kVar) {
        String str;
        try {
            str = new String(kVar.b, com.bytedance.sdk.adnet.d.b.a(kVar.c));
        } catch (UnsupportedEncodingException e) {
            str = new String(kVar.b);
        }
        return o.a(str, com.bytedance.sdk.adnet.d.b.c(kVar));
    }
}
