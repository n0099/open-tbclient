package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    long f3837a = -1;
    long b = -1;
    long c = -1;
    long d = -1;
    long e = -1;
    long f = -1;
    long g = -1;
    JSONObject h;

    private void c() {
        this.f3837a = -1L;
        this.b = -1L;
        this.c = -1L;
    }

    private void d() {
        this.d = -1L;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSONObject b() {
        if (this.f3837a == -1 && this.b == -1 && this.c == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f3837a != -1) {
                jSONObject.put("click", this.f3837a);
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
