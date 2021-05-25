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
    public String f27986a;

    /* renamed from: b  reason: collision with root package name */
    public String f27987b;

    /* renamed from: c  reason: collision with root package name */
    public String f27988c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f27986a = lVar.am();
        this.f27987b = lVar.ap();
        this.f27988c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f27986a)) {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f27986a);
            }
            if (!TextUtils.isEmpty(this.f27987b)) {
                jSONObject.put("log_extra", this.f27987b);
            }
            if (!TextUtils.isEmpty(this.f27988c)) {
                jSONObject.put("download_url", this.f27988c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
