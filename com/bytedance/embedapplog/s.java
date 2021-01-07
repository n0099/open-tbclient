package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class s extends ch {
    private final Context e;
    private final cn pgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pgJ = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        Map<String, String> a2 = ba.a(this.e, this.pgJ.epI());
        if (a2 != null) {
            jSONObject.put("oaid", new JSONObject(a2));
            return true;
        }
        return false;
    }
}
