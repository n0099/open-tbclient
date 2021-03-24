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
    public C0287a f27055a = new C0287a();

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0287a {

        /* renamed from: a  reason: collision with root package name */
        public com.bun.miitmdid.a.a.a f27056a;

        /* renamed from: b  reason: collision with root package name */
        public com.bun.miitmdid.a.a.b f27057b;

        /* renamed from: c  reason: collision with root package name */
        public c f27058c;

        public C0287a() {
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
            aVar.f27055a.f27056a = new com.bun.miitmdid.a.a.a();
        }
        return aVar.f27055a.f27056a != null;
    }

    public static boolean b(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
            aVar.f27055a.f27058c = new c();
        }
        return aVar.f27055a.f27058c != null;
    }

    public static boolean c(a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
        if (optJSONObject != null) {
            bVar.f27060a = optJSONObject.optString("appid");
            aVar.f27055a.f27057b = bVar;
        }
        return aVar.f27055a.f27057b != null;
    }

    @Override // com.bun.miitmdid.a.b
    public String a() {
        com.bun.miitmdid.a.a.b bVar;
        String str;
        C0287a c0287a = this.f27055a;
        return (c0287a == null || (bVar = c0287a.f27057b) == null || (str = bVar.f27060a) == null) ? "" : str;
    }
}
