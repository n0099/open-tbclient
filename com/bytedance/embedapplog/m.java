package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.down.common.intercepter.IIntercepter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m {
    private static final String[] f = {"channel", "package", "app_version"};

    /* renamed from: a  reason: collision with root package name */
    private boolean f6130a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6131b;
    private final cn pgH;
    private final SharedPreferences pgI;
    private final ArrayList<ch> e = new ArrayList<>(32);
    private int h = 0;
    @NonNull
    private JSONObject d = new JSONObject();

    public m(Context context, cn cnVar) {
        this.f6131b = context;
        this.pgH = cnVar;
        this.pgI = cnVar.epH();
        ba.a(this.f6131b);
    }

    @Nullable
    public JSONObject a() {
        if (this.f6130a) {
            return epr();
        }
        return null;
    }

    @Nullable
    public JSONObject b() {
        JSONObject a2 = a();
        if (a2 != null) {
            try {
                String a3 = ba.a(a2.optJSONObject("oaid"));
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = new JSONObject();
                    av.e(jSONObject, a2);
                    jSONObject.put("oaid", a3);
                    return jSONObject;
                }
            } catch (Exception e) {
                au.a(e);
            }
        }
        return a2;
    }

    @Nullable
    public <T> T D(String str, T t) {
        Object obj;
        JSONObject epr = epr();
        if (epr == null || (obj = epr.opt(str)) == null) {
            obj = null;
        }
        return obj == null ? t : (T) obj;
    }

    @NonNull
    private JSONObject epr() {
        return this.d;
    }

    public int c() {
        int optInt = this.f6130a ? epr().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && optInt == -1; i++) {
            e();
            optInt = this.f6130a ? epr().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public String d() {
        String optString = this.f6130a ? epr().optString("app_version", null) : null;
        for (int i = 0; i < 3 && optString == null; i++) {
            e();
            optString = this.f6130a ? epr().optString("app_version", null) : null;
        }
        return optString;
    }

    public boolean e() {
        synchronized (this.e) {
            if (this.e.size() == 0) {
                this.e.add(new ci());
                this.e.add(new ck(this.f6131b));
                this.e.add(new cm(this.f6131b, this.pgH));
                this.e.add(new n(this.f6131b));
                this.e.add(new p(this.f6131b));
                this.e.add(new q(this.f6131b, this.pgH));
                this.e.add(new r(this.f6131b));
                this.e.add(new t(this.f6131b));
                this.e.add(new u(this.f6131b, this.pgH));
                this.e.add(new v());
                this.e.add(new w(this.pgH));
                this.e.add(new x(this.f6131b));
                this.e.add(new y(this.f6131b));
                this.e.add(new z(this.f6131b, this.pgH));
                this.e.add(new cf(this.f6131b, this.pgH));
                this.e.add(new s(this.f6131b, this.pgH));
                this.e.add(new cj(this.f6131b, this.pgH));
            }
        }
        JSONObject epr = epr();
        JSONObject jSONObject = new JSONObject();
        av.e(jSONObject, epr);
        Iterator<ch> it = this.e.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            ch next = it.next();
            if (!next.f6122a || next.c || a(next)) {
                try {
                    next.f6122a = next.a(jSONObject);
                } catch (SecurityException e) {
                    if (!next.f6123b) {
                        i2++;
                        au.b("loadHeader, " + this.h, e);
                        if (!next.f6122a && this.h > 10) {
                            next.f6122a = true;
                        }
                    }
                } catch (JSONException e2) {
                    au.a(e2);
                }
                if (!next.f6122a && !next.f6123b) {
                    i++;
                }
            }
            z = (next.f6122a || next.f6123b) & z;
        }
        if (z) {
            for (String str : f) {
                z &= !TextUtils.isEmpty(jSONObject.optString(str));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException e3) {
                }
            }
        }
        this.d = jSONObject;
        this.f6130a = z;
        if (au.f6085b) {
            au.a("loadHeader, " + this.f6130a + ", " + this.h + ", " + this.d.toString(), null);
        } else {
            au.d("loadHeader, " + this.f6130a + ", " + this.h, null);
        }
        if (i2 > 0 && i2 == i) {
            this.h++;
            if (o() != 0) {
                this.h += 10;
            }
        }
        if (this.f6130a) {
            b.eoV().onIdLoaded(g(), j(), k());
        }
        return this.f6130a;
    }

    private boolean a(ch chVar) {
        boolean z = !this.pgH.r() && chVar.d;
        if (au.f6085b) {
            au.a("needSyncFromSub " + chVar + " " + z, null);
        }
        return z;
    }

    public void a(JSONObject jSONObject) {
        this.pgH.c(jSONObject);
        b(jSONObject);
    }

    private synchronized void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            au.b("null abconfig", null);
        } else {
            String optString = epr().optString("ab_version");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                Set<String> hashSet = new HashSet<>();
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        hashSet.add(str);
                    }
                }
                Iterator<String> keys = jSONObject.keys();
                HashSet hashSet2 = new HashSet();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str2 = next;
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                            } catch (JSONException e) {
                                au.a(e);
                            }
                        }
                    }
                }
                hashSet.retainAll(hashSet2);
                E("ab_version", h(hashSet));
            }
        }
    }

    private String h(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                JSONObject optJSONObject = epr().optJSONObject("custom");
                if (optJSONObject == null) {
                    try {
                        optJSONObject = new JSONObject();
                    } catch (JSONException e) {
                        e = e;
                        jSONObject = optJSONObject;
                        au.a(e);
                        if (E("custom", jSONObject)) {
                        }
                    }
                }
                try {
                    for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey())) {
                            optJSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject = optJSONObject;
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject = optJSONObject;
                    au.a(e);
                    if (E("custom", jSONObject)) {
                    }
                }
            } catch (JSONException e3) {
                e = e3;
            }
        }
        if (E("custom", jSONObject)) {
            this.pgH.b(jSONObject);
        }
    }

    public String f() {
        return epr().optString("user_unique_id", "");
    }

    public String g() {
        return epr().optString("device_id", "");
    }

    public String j() {
        return epr().optString("install_id", "");
    }

    public String k() {
        return epr().optString("ssid", "");
    }

    public String l() {
        return epr().optString("user_unique_id", "");
    }

    private boolean E(String str, Object obj) {
        boolean z = false;
        Object opt = epr().opt(str);
        if ((obj != null && !obj.equals(opt)) || (obj == null && opt != null)) {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    av.e(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.d = jSONObject2;
                } catch (JSONException e) {
                    au.a(e);
                }
            }
            z = true;
        }
        au.a("updateHeader, " + str + ", " + opt + ", " + obj, null);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(String str) {
        boolean z;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i) != '0') {
                z = false;
                break;
            } else {
                i++;
            }
        }
        return !z;
    }

    public int o() {
        String optString = epr().optString("device_id", "");
        epr().optString("install_id", "");
        if (e(optString)) {
            return this.pgI.getInt("version_code", 0) == epr().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long p() {
        return epr().optLong("register_time", 0L);
    }

    public boolean a(JSONObject jSONObject, String str, String str2, String str3) {
        if (au.f6085b) {
            au.a("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean e = e(str);
        boolean e2 = e(str2);
        try {
            boolean e3 = e(str3);
            int i = this.pgI.getInt("version_code", 0);
            int optInt = epr().optInt("version_code", 0);
            SharedPreferences.Editor edit = this.pgI.edit();
            if (i != optInt) {
                edit.putInt("version_code", optInt);
            }
            if (e) {
                long currentTimeMillis = System.currentTimeMillis();
                edit.putLong("register_time", currentTimeMillis);
                E("register_time", Long.valueOf(currentTimeMillis));
            } else if (!e) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IIntercepter.TYPE_RESPONSE, jSONObject);
                b.v("tt_fetch_did_error", jSONObject2);
            }
            boolean z = false;
            String optString = epr().optString("device_id", "");
            if (e && E("device_id", str)) {
                edit.putString("device_id", str);
                z = true;
            }
            String optString2 = epr().optString("install_id", "");
            if (e2 && E("install_id", str2)) {
                edit.putString("install_id", str2);
                z = true;
            }
            String optString3 = epr().optString("ssid", "");
            if (e3 && E("ssid", str3)) {
                edit.putString("ssid", str3);
                z = true;
            }
            b.eoV().onRemoteIdGet(z, optString, str, optString2, str2, optString3, str3);
            edit.apply();
        } catch (JSONException e4) {
            au.a(e4);
        }
        return e && e2;
    }

    public String q() {
        return epr().optString("ab_sdk_version", "");
    }
}
