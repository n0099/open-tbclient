package com.baidu.turbonet.net;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TurbonetConfig {
    private String nds;
    private boolean ndt = false;
    private JSONObject ndr = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface HttpCacheSetting {
    }

    public void xD(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void xE(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public void Tl(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.nds = str;
    }

    public void A(int i, long j) {
        if (i == 3 || i == 2) {
            if (dKZ() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
            this.ndt = true;
        } else if (dKZ() != null) {
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

    public void xF(boolean z) {
        e("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void Tm(String str) {
        e("conn", "preconnect_app_hosts", str);
    }

    public void xG(boolean z) {
        e("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
        e("misc", "request_timeout", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject dKY() {
        return this.ndr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String dKZ() {
        return this.nds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dLa() {
        return this.ndt;
    }

    public void e(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.ndr.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.ndr.put(str, optJSONObject);
        } catch (JSONException e) {
            throw new IllegalStateException("JSON expcetion:", e);
        }
    }
}
