package com.bun.miitmdid.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.bun.miitmdid.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public C0275a f26837a = new C0275a();

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0275a {

        /* renamed from: a  reason: collision with root package name */
        public com.bun.miitmdid.a.a.a f26838a;

        /* renamed from: b  reason: collision with root package name */
        public com.bun.miitmdid.a.a.b f26839b;

        /* renamed from: c  reason: collision with root package name */
        public c f26840c;

        public C0275a() {
        }
    }

    public static a a(Context context) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        String a2 = com.bun.miitmdid.utils.c.a(context, "supplierconfig.json");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        a aVar = new a();
        JSONTokener jSONTokener = new JSONTokener(a2);
        boolean z = false;
        try {
            jSONObject = (JSONObject) jSONTokener.nextValue();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("supplier")) == null) {
            return null;
        }
        boolean a3 = a(aVar, optJSONObject);
        boolean b2 = b(aVar, optJSONObject);
        boolean c2 = c(aVar, optJSONObject);
        if (a3 && b2 && c2) {
            z = true;
        }
        if (z) {
            return aVar;
        }
        return null;
    }

    public static boolean a(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_HUAWEI) != null) {
            aVar.f26837a.f26838a = new com.bun.miitmdid.a.a.a();
        }
        return aVar.f26837a.f26838a != null;
    }

    public static boolean b(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
            aVar.f26837a.f26840c = new c();
        }
        return aVar.f26837a.f26840c != null;
    }

    public static boolean c(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
        if (optJSONObject != null) {
            bVar.f26842a = optJSONObject.optString("appid");
            aVar.f26837a.f26839b = bVar;
        }
        return aVar.f26837a.f26839b != null;
    }

    @Override // com.bun.miitmdid.a.b
    public String a() {
        com.bun.miitmdid.a.a.b bVar;
        String str;
        C0275a c0275a = this.f26837a;
        return (c0275a == null || (bVar = c0275a.f26839b) == null || (str = bVar.f26842a) == null) ? "" : str;
    }
}
