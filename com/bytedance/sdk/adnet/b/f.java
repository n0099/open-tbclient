package com.bytedance.sdk.adnet.b;

import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.p;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends g<JSONObject> {
    public f(int i, String str, @Nullable JSONObject jSONObject, @Nullable p.a<JSONObject> aVar) {
        this(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    public f(int i, String str, @Nullable String str2, @Nullable p.a<JSONObject> aVar) {
        super(i, str, str2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    public p<JSONObject> a(l lVar) {
        try {
            return p.a(new JSONObject(new String(lVar.f6341b, com.bytedance.sdk.adnet.d.c.a(lVar.c, "utf-8"))), com.bytedance.sdk.adnet.d.c.c(lVar));
        } catch (UnsupportedEncodingException e) {
            return p.c(new com.bytedance.sdk.adnet.err.e(e));
        } catch (JSONException e2) {
            return p.c(new com.bytedance.sdk.adnet.err.e(e2));
        }
    }
}
