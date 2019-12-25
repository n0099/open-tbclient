package com.baidubce;

import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public enum Protocol {
    HTTP(HttpHost.DEFAULT_SCHEME_NAME, 80),
    HTTPS("https", 443);
    
    private int defaultPort;
    private String protocol;

    Protocol(String str, int i) {
        this.protocol = str;
        this.defaultPort = i;
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
