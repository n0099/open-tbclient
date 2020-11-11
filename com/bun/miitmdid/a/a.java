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
    public C0959a oHS = new C0959a();

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0959a {
        public com.bun.miitmdid.a.a.a oHT;
        public com.bun.miitmdid.a.a.b oHU;
        public c oHV;

        public C0959a() {
        }
    }

    private a() {
    }

    private static boolean a(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_HUAWEI) != null) {
            aVar.oHS.oHT = new com.bun.miitmdid.a.a.a();
        }
        return aVar.oHS.oHT != null;
    }

    private static boolean b(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
            aVar.oHS.oHV = new c();
        }
        return aVar.oHS.oHV != null;
    }

    private static boolean c(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
        if (optJSONObject != null) {
            bVar.f3975a = optJSONObject.optString("appid");
            aVar.oHS.oHU = bVar;
        }
        return aVar.oHS.oHU != null;
    }

    public static a gP(Context context) {
        boolean z;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        String a2 = com.bun.miitmdid.utils.c.a(context, "supplierconfig.json");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        a aVar = new a();
        try {
            jSONObject = (JSONObject) new JSONTokener(a2).nextValue();
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
        return (this.oHS == null || this.oHS.oHU == null || this.oHS.oHU.f3975a == null) ? "" : this.oHS.oHU.f3975a;
    }
}
