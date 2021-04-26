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
    public String f28812a;

    /* renamed from: b  reason: collision with root package name */
    public String f28813b;

    /* renamed from: c  reason: collision with root package name */
    public String f28814c;

    public a(@NonNull l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28812a = lVar.am();
        this.f28813b = lVar.ap();
        this.f28814c = ak.i(lVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28812a)) {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f28812a);
            }
            if (!TextUtils.isEmpty(this.f28813b)) {
                jSONObject.put("log_extra", this.f28813b);
            }
            if (!TextUtils.isEmpty(this.f28814c)) {
                jSONObject.put("download_url", this.f28814c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
