package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class cj extends ch {
    private final cn pci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(Context context, cn cnVar) {
        super(true, false);
        this.pci = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        String c = ba.c(this.pci.elM());
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        jSONObject.put("cdid", c);
        return true;
    }
}
