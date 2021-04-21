package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27958a;

    /* renamed from: b  reason: collision with root package name */
    public String f27959b;

    /* renamed from: c  reason: collision with root package name */
    public String f27960c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f27958a = lVar.am();
        this.f27959b = lVar.ap();
        this.f27960c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f27958a)) {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f27958a);
            }
            if (!TextUtils.isEmpty(this.f27959b)) {
                jSONObject.put("log_extra", this.f27959b);
            }
            if (!TextUtils.isEmpty(this.f27960c)) {
                jSONObject.put("download_url", this.f27960c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
