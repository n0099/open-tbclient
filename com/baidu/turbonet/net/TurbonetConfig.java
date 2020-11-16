package com.baidu.turbonet.net;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class TurbonetConfig {
    private String opX;
    private boolean opY = false;
    private JSONObject opW = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface HttpCacheSetting {
    }

    public void zB(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void zC(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public void Wa(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.opX = str;
    }

    public void C(int i, long j) {
        if (i == 3 || i == 2) {
            if (ech() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
            this.opY = true;
        } else if (ech() != null) {
            throw new IllegalArgumentException("Storage path must not be set");
        }
        e(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(i == 0 || i == 2 ? false : true));
        switch (i) {
            case 0:
                e(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISABLED");
                break;
            case 1:
                e(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "MEMORY");
                break;
            case 2:
            case 3:
                e(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISK");
                break;
            default:
                throw new IllegalArgumentException("Unknown cache mode");
        }
        e(SchemeCollecter.CLASSIFY_BASE, "http_cache_size", Long.valueOf(j));
    }

    public void zD(boolean z) {
        e("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void Wb(String str) {
        e("conn", "preconnect_app_hosts", str);
    }

    public void zE(boolean z) {
        e("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
        e("misc", "request_timeout", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject ecg() {
        return this.opW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ech() {
        return this.opX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eci() {
        return this.opY;
    }

    public void e(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.opW.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.opW.put(str, optJSONObject);
        } catch (JSONException e) {
            throw new IllegalStateException("JSON expcetion:", e);
        }
    }
}
