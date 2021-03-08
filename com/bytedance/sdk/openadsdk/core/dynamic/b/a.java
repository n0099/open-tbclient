package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4412a;
    private String b;
    private String c;

    public a(@NonNull l lVar) {
        if (lVar != null) {
            this.f4412a = lVar.ag();
            this.b = lVar.aj();
            this.c = aj.i(lVar);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f4412a)) {
                jSONObject.put(IXAdRequestInfo.CELL_ID, this.f4412a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject.put("log_extra", this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put("download_url", this.c);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
