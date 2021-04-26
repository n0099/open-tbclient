package com.bun.miitmdid.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.bun.miitmdid.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public C0285a f27560a = new C0285a();

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0285a {

        /* renamed from: a  reason: collision with root package name */
        public com.bun.miitmdid.a.a.a f27561a;

        /* renamed from: b  reason: collision with root package name */
        public com.bun.miitmdid.a.a.b f27562b;

        /* renamed from: c  reason: collision with root package name */
        public c f27563c;

        public C0285a() {
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
            aVar.f27560a.f27561a = new com.bun.miitmdid.a.a.a();
        }
        return aVar.f27560a.f27561a != null;
    }

    public static boolean b(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
            aVar.f27560a.f27563c = new c();
        }
        return aVar.f27560a.f27563c != null;
    }

    public static boolean c(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
        if (optJSONObject != null) {
            bVar.f27565a = optJSONObject.optString("appid");
            aVar.f27560a.f27562b = bVar;
        }
        return aVar.f27560a.f27562b != null;
    }

    @Override // com.bun.miitmdid.a.b
    public String a() {
        com.bun.miitmdid.a.a.b bVar;
        String str;
        C0285a c0285a = this.f27560a;
        return (c0285a == null || (bVar = c0285a.f27562b) == null || (str = bVar.f27565a) == null) ? "" : str;
    }
}
