package com.baidu.turbonet.net;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class TurbonetConfig {
    private String mKf;
    private boolean mKg = false;
    private JSONObject mKe = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface HttpCacheSetting {
    }

    public void wL(boolean z) {
        f(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void wM(boolean z) {
        f(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public void Qm(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.mKf = str;
    }

    public void A(int i, long j) {
        if (i == 3 || i == 2) {
            if (dzd() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
            this.mKg = true;
        } else if (dzd() != null) {
            throw new IllegalArgumentException("Storage path must not be set");
        }
        f(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(i == 0 || i == 2 ? false : true));
        switch (i) {
            case 0:
                f(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISABLED");
                break;
            case 1:
                f(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "MEMORY");
                break;
            case 2:
            case 3:
                f(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISK");
                break;
            default:
                throw new IllegalArgumentException("Unknown cache mode");
        }
        f(SchemeCollecter.CLASSIFY_BASE, "http_cache_size", Long.valueOf(j));
    }

    public void wN(boolean z) {
        f("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void Qn(String str) {
        f("conn", "preconnect_app_hosts", str);
    }

    public void wO(boolean z) {
        f("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
        f("misc", "request_timeout", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject dzc() {
        return this.mKe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String dzd() {
        return this.mKf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dze() {
        return this.mKg;
    }

    public void f(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.mKe.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.mKe.put(str, optJSONObject);
        } catch (JSONException e) {
            throw new IllegalStateException("JSON expcetion:", e);
        }
    }
}
