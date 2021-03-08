package com.bytedance.sdk.adnet.b;

import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g<JSONObject> {
    public f(int i, String str, @Nullable JSONObject jSONObject, @Nullable o.a<JSONObject> aVar) {
        this(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    public f(int i, String str, @Nullable String str2, @Nullable o.a<JSONObject> aVar) {
        super(i, str, str2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    public o<JSONObject> a(k kVar) {
        try {
            return o.a(new JSONObject(new String(kVar.b, com.bytedance.sdk.adnet.d.b.a(kVar.c, "utf-8"))), com.bytedance.sdk.adnet.d.b.c(kVar));
        } catch (UnsupportedEncodingException e) {
            return o.c(new com.bytedance.sdk.adnet.err.e(e));
        } catch (JSONException e2) {
            return o.c(new com.bytedance.sdk.adnet.err.e(e2));
        }
    }
}
