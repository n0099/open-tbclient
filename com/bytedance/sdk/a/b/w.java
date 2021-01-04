package com.bytedance.sdk.a.b;

import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes4.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(Config.EVENT_NATIVE_VIEW_HIERARCHY);
    
    private final String e;

    w(String str) {
        this.e = str;
    }

    public static w a(String str) throws IOException {
        if (str.equals(HTTP_1_0.e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.e;
    }
}
