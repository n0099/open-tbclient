package com.bun.miitmdid.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.bun.miitmdid.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes15.dex */
public class a implements b {
    public C0984a pme = new C0984a();

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C0984a {
        public com.bun.miitmdid.a.a.a pmf;
        public com.bun.miitmdid.a.a.b pmg;
        public c pmh;

        public C0984a() {
        }
    }

    private a() {
    }

    private static boolean a(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_HUAWEI) != null) {
            aVar.pme.pmf = new com.bun.miitmdid.a.a.a();
        }
        return aVar.pme.pmf != null;
    }

    private static boolean b(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
            aVar.pme.pmh = new c();
        }
        return aVar.pme.pmh != null;
    }

    private static boolean c(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
        if (optJSONObject != null) {
            bVar.f5734a = optJSONObject.optString("appid");
            aVar.pme.pmg = bVar;
        }
        return aVar.pme.pmg != null;
    }

    public static a hL(Context context) {
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
        return (this.pme == null || this.pme.pmg == null || this.pme.pmg.f5734a == null) ? "" : this.pme.pmg.f5734a;
    }
}
