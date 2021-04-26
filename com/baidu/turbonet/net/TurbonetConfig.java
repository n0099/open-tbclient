package com.baidu.turbonet.net;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TurbonetConfig {

    /* renamed from: b  reason: collision with root package name */
    public String f23231b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23232c = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f23230a = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface HttpCacheSetting {
    }

    public void a(String str) {
        i("conn", "preconnect_app_hosts", str);
    }

    public void b(boolean z) {
        i("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void c(boolean z) {
        i(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void d(int i2, long j) {
        if (i2 != 3 && i2 != 2) {
            if (l() != null) {
                throw new IllegalArgumentException("Storage path must not be set");
            }
        } else if (l() != null) {
            this.f23232c = true;
        } else {
            throw new IllegalArgumentException("Storage path must be set");
        }
        i(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(!(i2 == 0 || i2 == 2)));
        if (i2 == 0) {
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISABLED");
        } else if (i2 == 1) {
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "MEMORY");
        } else if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Unknown cache mode");
        } else {
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISK");
        }
        i(SchemeCollecter.CLASSIFY_BASE, "http_cache_size", Long.valueOf(j));
    }

    public void e(boolean z) {
        i("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void f(boolean z) {
        i(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public JSONObject g() {
        return this.f23230a;
    }

    public boolean h() {
        return this.f23232c;
    }

    public void i(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.f23230a.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.f23230a.put(str, optJSONObject);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSON expcetion:", e2);
        }
    }

    public void j(int i2) {
        if (i2 >= 0) {
            i("misc", "request_timeout", Integer.valueOf(i2));
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i2)));
    }

    public void k(String str) {
        if (new File(str).isDirectory()) {
            this.f23231b = str;
            return;
        }
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    public String l() {
        return this.f23231b;
    }
}
