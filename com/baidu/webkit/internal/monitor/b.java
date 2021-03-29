package com.baidu.webkit.internal.monitor;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f26938a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f26939b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f26940c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f26941d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f26942e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f26943f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f26944g = -1;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f26945h;

    private void c() {
        this.f26938a = -1L;
        this.f26939b = -1L;
        this.f26940c = -1L;
    }

    private void d() {
        this.f26941d = -1L;
        this.f26942e = -1L;
        this.f26943f = -1L;
        this.f26944g = -1L;
    }

    public final JSONObject a() {
        if (this.f26941d == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f26941d != -1) {
                jSONObject.put("sf1", this.f26941d);
            }
            if (this.f26942e != -1) {
                jSONObject.put("sf2", this.f26942e);
            }
            if (this.f26943f != -1) {
                jSONObject.put("sf3", this.f26943f);
            }
            if (this.f26944g != -1) {
                jSONObject.put("sf4", this.f26944g);
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
        if (this.f26938a == -1 && this.f26939b == -1 && this.f26940c == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f26938a != -1) {
                jSONObject.put(PrefetchEvent.STATE_CLICK, this.f26938a);
            }
            if (this.f26939b != -1) {
                jSONObject.put("evajs", this.f26939b);
            }
            if (this.f26940c != -1) {
                jSONObject.put("loadurl", this.f26940c);
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
