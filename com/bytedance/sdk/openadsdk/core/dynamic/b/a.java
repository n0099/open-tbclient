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
    public String f28264a;

    /* renamed from: b  reason: collision with root package name */
    public String f28265b;

    /* renamed from: c  reason: collision with root package name */
    public String f28266c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28264a = lVar.am();
        this.f28265b = lVar.ap();
        this.f28266c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28264a)) {
                jSONObject.put(IXAdRequestInfo.CELL_ID, this.f28264a);
            }
            if (!TextUtils.isEmpty(this.f28265b)) {
                jSONObject.put("log_extra", this.f28265b);
            }
            if (!TextUtils.isEmpty(this.f28266c)) {
                jSONObject.put("download_url", this.f28266c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
