package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final w f5884a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5885b;
    public final String c;

    public k(w wVar, int i, String str) {
        this.f5884a = wVar;
        this.f5885b = i;
        this.c = str;
    }

    public static k g(com.bytedance.sdk.a.b.b bVar) {
        return new k(bVar.enj(), bVar.c(), bVar.d());
    }

    public static k Xz(String str) throws IOException {
        w wVar;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                wVar = w.HTTP_1_0;
            } else if (charAt == 1) {
                wVar = w.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            wVar = w.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            if (str.length() <= i + 3) {
                str2 = "";
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new k(wVar, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5884a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ').append(this.f5885b);
        if (this.c != null) {
            sb.append(' ').append(this.c);
        }
        return sb.toString();
    }
}
