package com.bytedance.sdk.adnet.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.p;
import java.io.UnsupportedEncodingException;
/* loaded from: classes4.dex */
public class j extends Request<String> {
    private final Object c;
    @Nullable
    @GuardedBy("mLock")
    private p.a<String> d;

    public j(int i, String str, @Nullable p.a<String> aVar) {
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
    public void a(p<String> pVar) {
        p.a<String> aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public p<String> a(l lVar) {
        String str;
        try {
            str = new String(lVar.f6341b, com.bytedance.sdk.adnet.d.c.a(lVar.c));
        } catch (UnsupportedEncodingException e) {
            str = new String(lVar.f6341b);
        }
        return p.a(str, com.bytedance.sdk.adnet.d.c.c(lVar));
    }
}
