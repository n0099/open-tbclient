package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28057a;

    /* renamed from: b  reason: collision with root package name */
    public String f28058b;

    /* renamed from: c  reason: collision with root package name */
    public String f28059c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28057a = lVar.am();
        this.f28058b = lVar.ap();
        this.f28059c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28057a)) {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f28057a);
            }
            if (!TextUtils.isEmpty(this.f28058b)) {
                jSONObject.put("log_extra", this.f28058b);
            }
            if (!TextUtils.isEmpty(this.f28059c)) {
                jSONObject.put("download_url", this.f28059c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
