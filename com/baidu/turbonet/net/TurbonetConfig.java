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
    private String mStoragePath;
    private boolean oTJ = false;
    private JSONObject oTI = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface HttpCacheSetting {
    }

    public void Au(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void Av(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public void Xi(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.mStoragePath = str;
    }

    public void D(int i, long j) {
        if (i == 3 || i == 2) {
            if (egT() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
            this.oTJ = true;
        } else if (egT() != null) {
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

    public void Aw(boolean z) {
        e("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void Xj(String str) {
        e("conn", "preconnect_app_hosts", str);
    }

    public void Ax(boolean z) {
        e("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
        e("misc", "request_timeout", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject egS() {
        return this.oTI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String egT() {
        return this.mStoragePath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean egU() {
        return this.oTJ;
    }

    public void e(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.oTI.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.oTI.put(str, optJSONObject);
        } catch (JSONException e) {
            throw new IllegalStateException("JSON expcetion:", e);
        }
    }
}
