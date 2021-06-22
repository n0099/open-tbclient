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
    public String f28171a;

    /* renamed from: b  reason: collision with root package name */
    public String f28172b;

    /* renamed from: c  reason: collision with root package name */
    public String f28173c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28171a = lVar.am();
        this.f28172b = lVar.ap();
        this.f28173c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28171a)) {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f28171a);
            }
            if (!TextUtils.isEmpty(this.f28172b)) {
                jSONObject.put("log_extra", this.f28172b);
            }
            if (!TextUtils.isEmpty(this.f28173c)) {
                jSONObject.put("download_url", this.f28173c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
