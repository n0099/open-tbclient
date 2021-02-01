package com.bytedance.sdk.openadsdk.core.h;

import com.bytedance.sdk.openadsdk.utils.aj;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    String f6582a;

    /* renamed from: b  reason: collision with root package name */
    int f6583b;
    JSONArray c;
    List<String> d = new ArrayList();
    long e;
    volatile boolean f;

    private d() {
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            d dVar = new d();
            dVar.a(jSONObject.optString("host"));
            dVar.a(jSONObject.optInt("ttl", 60));
            dVar.a(jSONObject.optJSONArray("ips"));
            dVar.a(jSONObject.optBoolean(" statsdnstime", false));
            long optLong = jSONObject.optLong(LogBuilder.KEY_START_TIME, 0L);
            if (optLong > 0) {
                dVar.a(optLong);
            } else {
                dVar.a(System.currentTimeMillis());
            }
            return dVar;
        } catch (Exception e) {
            return null;
        }
    }

    public String a() {
        return this.f6582a;
    }

    public void a(String str) {
        this.f6582a = str;
    }

    public int b() {
        return this.f6583b;
    }

    public void a(int i) {
        this.f6583b = i;
    }

    public JSONArray c() {
        return this.c;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.c = jSONArray;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String obj = jSONArray.get(i).toString();
                    if (aj.l(obj)) {
                        this.d.add(obj);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public boolean d() {
        return System.currentTimeMillis() - f() > ((long) (b() * 1000));
    }

    public String e() {
        if (this.d == null || this.d.size() == 0) {
            return null;
        }
        int size = ((int) ((this.d.size() * Math.random()) + 0.5d)) - 1;
        if (size < 0) {
            size = 0;
        }
        return this.d.get(size);
    }

    public long f() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public boolean g() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("host", a());
            jSONObject.put("ttl", b());
            jSONObject.put("ips", c());
            jSONObject.put(LogBuilder.KEY_START_TIME, f());
            jSONObject.put("statsdnstime", g());
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
