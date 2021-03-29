package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28265a;

    /* renamed from: b  reason: collision with root package name */
    public String f28266b;

    /* renamed from: c  reason: collision with root package name */
    public String f28267c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28265a = lVar.am();
        this.f28266b = lVar.ap();
        this.f28267c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28265a)) {
                jSONObject.put(IXAdRequestInfo.CELL_ID, this.f28265a);
            }
            if (!TextUtils.isEmpty(this.f28266b)) {
                jSONObject.put("log_extra", this.f28266b);
            }
            if (!TextUtils.isEmpty(this.f28267c)) {
                jSONObject.put("download_url", this.f28267c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
