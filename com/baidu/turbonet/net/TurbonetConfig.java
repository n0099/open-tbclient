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
    public String f22840b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22841c = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f22839a = new JSONObject();

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

    public void d(int i, long j) {
        if (i != 3 && i != 2) {
            if (l() != null) {
                throw new IllegalArgumentException("Storage path must not be set");
            }
        } else if (l() != null) {
            this.f22841c = true;
        } else {
            throw new IllegalArgumentException("Storage path must be set");
        }
        i(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(!(i == 0 || i == 2)));
        if (i == 0) {
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISABLED");
        } else if (i == 1) {
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "MEMORY");
        } else if (i != 2 && i != 3) {
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
        return this.f22839a;
    }

    public boolean h() {
        return this.f22841c;
    }

    public void i(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.f22839a.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.f22839a.put(str, optJSONObject);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSON expcetion:", e2);
        }
    }

    public void j(int i) {
        if (i >= 0) {
            i("misc", "request_timeout", Integer.valueOf(i));
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
    }

    public void k(String str) {
        if (new File(str).isDirectory()) {
            this.f22840b = str;
            return;
        }
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    public String l() {
        return this.f22840b;
    }
}
