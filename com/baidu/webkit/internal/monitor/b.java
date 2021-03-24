package com.baidu.webkit.internal.monitor;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f26937a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f26938b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f26939c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f26940d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f26941e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f26942f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f26943g = -1;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f26944h;

    private void c() {
        this.f26937a = -1L;
        this.f26938b = -1L;
        this.f26939c = -1L;
    }

    private void d() {
        this.f26940d = -1L;
        this.f26941e = -1L;
        this.f26942f = -1L;
        this.f26943g = -1L;
    }

    public final JSONObject a() {
        if (this.f26940d == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f26940d != -1) {
                jSONObject.put("sf1", this.f26940d);
            }
            if (this.f26941e != -1) {
                jSONObject.put("sf2", this.f26941e);
            }
            if (this.f26942f != -1) {
                jSONObject.put("sf3", this.f26942f);
            }
            if (this.f26943g != -1) {
                jSONObject.put("sf4", this.f26943g);
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
        if (this.f26937a == -1 && this.f26938b == -1 && this.f26939c == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f26937a != -1) {
                jSONObject.put(PrefetchEvent.STATE_CLICK, this.f26937a);
            }
            if (this.f26938b != -1) {
                jSONObject.put("evajs", this.f26938b);
            }
            if (this.f26939c != -1) {
                jSONObject.put("loadurl", this.f26939c);
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
