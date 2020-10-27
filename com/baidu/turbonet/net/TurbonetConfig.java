package com.baidu.turbonet.net;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class TurbonetConfig {
    private String ofp;
    private boolean ofq = false;
    private JSONObject ofo = new JSONObject();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface HttpCacheSetting {
    }

    public void zj(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
    }

    public void zk(boolean z) {
        e(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
    }

    public void VM(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.ofp = str;
    }

    public void D(int i, long j) {
        if (i == 3 || i == 2) {
            if (dYA() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
            this.ofq = true;
        } else if (dYA() != null) {
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

    public void zl(boolean z) {
        e("conn", "preconnect_enabled", Boolean.valueOf(z));
    }

    public void VN(String str) {
        e("conn", "preconnect_app_hosts", str);
    }

    public void zm(boolean z) {
        e("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
        e("misc", "request_timeout", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject dYz() {
        return this.ofo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String dYA() {
        return this.ofp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dYB() {
        return this.ofq;
    }

    public void e(String str, String str2, Object obj) {
        try {
            JSONObject optJSONObject = this.ofo.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(str2, obj);
            this.ofo.put(str, optJSONObject);
        } catch (JSONException e) {
            throw new IllegalStateException("JSON expcetion:", e);
        }
    }
}
