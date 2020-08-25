package com.bun.miitmdid.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.bun.miitmdid.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes11.dex */
public class a implements b {
    public C0853a nht = new C0853a();

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0853a {
        public com.bun.miitmdid.a.a.a nhu;
        public com.bun.miitmdid.a.a.b nhv;
        public c nhw;

        public C0853a() {
        }
    }

    private a() {
    }

    private static boolean a(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_HUAWEI) != null) {
            aVar.nht.nhu = new com.bun.miitmdid.a.a.a();
        }
        return aVar.nht.nhu != null;
    }

    private static boolean b(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
            aVar.nht.nhw = new c();
        }
        return aVar.nht.nhw != null;
    }

    private static boolean c(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
        if (optJSONObject != null) {
            bVar.a = optJSONObject.optString("appid");
            aVar.nht.nhv = bVar;
        }
        return aVar.nht.nhv != null;
    }

    public static a gh(Context context) {
        boolean z;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        String a = com.bun.miitmdid.utils.c.a(context, "supplierconfig.json");
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        a aVar = new a();
        try {
            jSONObject = (JSONObject) new JSONTokener(a).nextValue();
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("supplier")) == null) {
            return null;
        }
        z = a(aVar, optJSONObject) && b(aVar, optJSONObject) && c(aVar, optJSONObject);
        return z ? aVar : null;
    }

    @Override // com.bun.miitmdid.a.b
    public String a() {
        return (this.nht == null || this.nht.nhv == null || this.nht.nhv.a == null) ? "" : this.nht.nhv.a;
    }
}
