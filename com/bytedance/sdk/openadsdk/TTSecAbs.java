package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class TTSecAbs {
    public String NM_getAppKey() {
        return "df979cdb-05a7-448c-bece-92d5005a1247";
    }

    public Map<String, Object> NM_getCustomInfo() {
        if (i.d().g() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.APP_ID, i.d().g());
            return hashMap;
        }
        return null;
    }

    public String NM_getDeviceId() {
        return k.a(p.a());
    }

    public String NM_getInstallId() {
        return null;
    }

    public abstract String NM_pullSg();

    public abstract String NM_pullVer(String str);

    public abstract void NM_reportNow(String str);

    public abstract void NM_setParams(String str);
}
