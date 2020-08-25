package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes19.dex */
public final class c implements com.baidu.webkit.logsdk.b {
    private static String[] a;

    static {
        String[] strArr = {"null", "null", "null", "null"};
        a = strArr;
        strArr[0] = new String(Base64.decode(new byte[]{77, 106, 104, 71, 77, 122, 108, 70, 79, 84, 74, 67, 79, 84, 107, 53, 79, 69, 69, 120, 81, 84, 66, 71, 78, 68, 77, 50, 77, 106, 89, 119, 78, 84, 65, 48, 77, 84, 89, 121, 79, 68, 103, 35}));
        a[1] = new String(Base64.decode(new byte[]{78, 106, 85, 52, 82, 68, 103, 49, 77, 69, 85, 120, 77, 68, 107, 122, 78, 48, 86, 68, 81, 122, 103, 120, 77, 122, 99, 119, 77, 122, 89, 48, 78, 85, 89, 122, 77, 106, 81, 51, 77, 68, 82, 70, 79, 81, 35, 35}));
        a[2] = new String(Base64.decode(new byte[]{79, 68, 77, 120, 89, 50, 78, 104, 90, 71, 69, 120, 90, 87, 89, 52, 79, 71, 77, 119, 78, 84, 108, 108, 78, 122, 70, 108, 78, 109, 73, 52, 77, 87, 69, 122, 89, 122, 69, 122, 77, 106, 89, 53, 77, 71, 89, 51, 79, 71, 69, 52, 89, 81, 35, 35}));
        a[3] = new String(Base64.decode(new byte[]{89, 122, 103, 122, 90, 84, 81, 122, 79, 87, 77, 48, 90, 71, 89, 51, 77, 71, 82, 105, 90, 87, 78, 104, 77, 50, 85, 53, 77, 50, 69, 51, 90, 87, 89, 122, 90, 84, 81, 52, 77, 50, 85, 35}));
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String a() {
        return "https://browserkernel.baidu.com/logstat/stat/log";
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String a(int i) {
        return (i < 0 || i >= a.length) ? "" : a[i];
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String a(String str) {
        return str;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String b() {
        return "https://browserkernel.baidu.com/log/config.json";
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String c() {
        return "searchbox";
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String d() {
        return "searchbox";
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String e() {
        try {
            return new String(Base64.encode(WebKitFactory.getCUIDString().getBytes(), false));
        } catch (Throwable th) {
            return WebKitFactory.getCUIDString();
        }
    }
}
