package com.baidu.webkit.internal.monitor;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f27439a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f27440b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f27441c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f27442d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f27443e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f27444f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f27445g = -1;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f27446h;

    private void c() {
        this.f27439a = -1L;
        this.f27440b = -1L;
        this.f27441c = -1L;
    }

    private void d() {
        this.f27442d = -1L;
        this.f27443e = -1L;
        this.f27444f = -1L;
        this.f27445g = -1L;
    }

    public final JSONObject a() {
        if (this.f27442d == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f27442d != -1) {
                jSONObject.put("sf1", this.f27442d);
            }
            if (this.f27443e != -1) {
                jSONObject.put("sf2", this.f27443e);
            }
            if (this.f27444f != -1) {
                jSONObject.put("sf3", this.f27444f);
            }
            if (this.f27445g != -1) {
                jSONObject.put("sf4", this.f27445g);
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
        if (this.f27439a == -1 && this.f27440b == -1 && this.f27441c == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f27439a != -1) {
                jSONObject.put(PrefetchEvent.STATE_CLICK, this.f27439a);
            }
            if (this.f27440b != -1) {
                jSONObject.put("evajs", this.f27440b);
            }
            if (this.f27441c != -1) {
                jSONObject.put("loadurl", this.f27441c);
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
