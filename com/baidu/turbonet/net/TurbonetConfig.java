package com.baidu.turbonet.net;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TurbonetConfig {
    private String lLC;
    private boolean lLD = false;
    private JSONObject lLB = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface HttpCacheSetting {
    }

    public void vk(boolean z) {
        d(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void vl(boolean z) {
        d(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public void Na(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.lLC = str;
    }

    public void z(int i, long j) {
        if (i == 3 || i == 2) {
            if (djC() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
            this.lLD = true;
        } else if (djC() != null) {
            throw new IllegalArgumentException("Storage path must not be set");
        }
        d(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(i == 0 || i == 2 ? false : true));
        switch (i) {
            case 0:
                d(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISABLED");
                break;
            case 1:
                d(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "MEMORY");
                break;
            case 2:
            case 3:
                d(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISK");
                break;
            default:
                throw new IllegalArgumentException("Unknown cache mode");
        }
        d(SchemeCollecter.CLASSIFY_BASE, "http_cache_size", Long.valueOf(j));
    }

    public void vm(boolean z) {
        d("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void Nb(String str) {
        d("conn", "preconnect_app_hosts", str);
    }

    public void vn(boolean z) {
        d("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
        d("misc", "request_timeout", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject djB() {
        return this.lLB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String djC() {
        return this.lLC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean djD() {
        return this.lLD;
    }

    public void d(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.lLB.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.lLB.put(str, optJSONObject);
        } catch (JSONException e) {
            throw new IllegalStateException("JSON expcetion:", e);
        }
    }
}
