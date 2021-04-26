package com.baidubce;

import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes5.dex */
public enum Protocol {
    HTTP("http", 80),
    HTTPS("https", Constants.SOCKET_PORT_SSL);
    
    public int defaultPort;
    public String protocol;

    Protocol(String str, int i2) {
        this.protocol = str;
        this.defaultPort = i2;
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
