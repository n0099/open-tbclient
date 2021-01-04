package com.bytedance.sdk.a.b.a.c;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes4.dex */
public final class f {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(HttpPut.METHOD_NAME) || str.equals(HttpDelete.METHOD_NAME) || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return str.equals("POST") || str.equals(HttpPut.METHOD_NAME) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean c(String str) {
        return b(str) || str.equals(HttpOptions.METHOD_NAME) || str.equals(HttpDelete.METHOD_NAME) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return !str.equals("PROPFIND");
    }
}
