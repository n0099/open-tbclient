package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public long a = -1;
    public long b = -1;
    public long c = -1;
    public long d = -1;
    public long e = -1;
    public long f = -1;
    public long g = -1;
    public JSONObject h;

    private void c() {
        this.a = -1L;
        this.b = -1L;
        this.c = -1L;
    }

    private void d() {
        this.d = -1L;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
    }

    public final JSONObject a() {
        if (this.d == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.d != -1) {
                jSONObject.put("sf1", this.d);
            }
            if (this.e != -1) {
                jSONObject.put("sf2", this.e);
            }
            if (this.f != -1) {
                jSONObject.put("sf3", this.f);
            }
            if (this.g != -1) {
                jSONObject.put("sf4", this.g);
            }
            d();
            return jSONObject;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            d();
            return null;
        }
    }

    public final JSONObject b() {
        if (this.a == -1 && this.b == -1 && this.c == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.a != -1) {
                jSONObject.put("click", this.a);
            }
            if (this.b != -1) {
                jSONObject.put("evajs", this.b);
            }
            if (this.c != -1) {
                jSONObject.put("loadurl", this.c);
            }
            c();
            return jSONObject;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            c();
            return null;
        }
    }
}
