package com.bytedance.sdk.adnet.b;

import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends g<String> {
    public h(int i, String str, @Nullable JSONObject jSONObject, @Nullable o.a<String> aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    public o<String> a(k kVar) {
        try {
            return o.a(new String(kVar.b, com.bytedance.sdk.adnet.d.b.a(kVar.c, "utf-8")), com.bytedance.sdk.adnet.d.b.c(kVar));
        } catch (UnsupportedEncodingException e) {
            return o.c(new com.bytedance.sdk.adnet.err.e(e));
        }
    }
}
