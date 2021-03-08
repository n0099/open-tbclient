package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class i {
    public static String a(ab abVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(abVar.b());
        sb.append(' ');
        if (b(abVar, type)) {
            sb.append(abVar.eoY());
        } else {
            sb.append(b(abVar.eoY()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(ab abVar, Proxy.Type type) {
        return !abVar.g() && type == Proxy.Type.HTTP;
    }

    public static String b(s sVar) {
        String h = sVar.h();
        String j = sVar.j();
        return j != null ? h + '?' + j : h;
    }
}
