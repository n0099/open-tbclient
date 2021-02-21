package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.o;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.v;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f5880a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long d(com.bytedance.sdk.a.b.b bVar) {
        return b(bVar.epM());
    }

    public static long b(v vVar) {
        return a(vVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static void a(p pVar, s sVar, v vVar) {
        if (pVar != p.ppI) {
            List<o> a2 = o.a(sVar, vVar);
            if (!a2.isEmpty()) {
                pVar.a(sVar, a2);
            }
        }
    }

    public static boolean e(com.bytedance.sdk.a.b.b bVar) {
        if (bVar.epu().b().equals(HttpHead.METHOD_NAME)) {
            return false;
        }
        int c = bVar.c();
        if ((c >= 100 && c < 200) || c == 204 || c == 304) {
            return d(bVar) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(bVar.a("Transfer-Encoding"));
        }
        return true;
    }

    public static int y(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
