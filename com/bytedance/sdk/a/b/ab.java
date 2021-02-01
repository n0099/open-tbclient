package com.bytedance.sdk.a.b;

import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.bytedance.sdk.a.b.v;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
public final class ab {

    /* renamed from: b  reason: collision with root package name */
    final String f5950b;
    final Object e;
    final s pnR;
    final ac poS;
    final v pul;
    private volatile g pum;

    ab(a aVar) {
        this.pnR = aVar.pnR;
        this.f5950b = aVar.f5951b;
        this.pul = aVar.pun.epV();
        this.poS = aVar.poS;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s eoJ() {
        return this.pnR;
    }

    public String b() {
        return this.f5950b;
    }

    public v epp() {
        return this.pul;
    }

    public String a(String str) {
        return this.pul.a(str);
    }

    public ac eqv() {
        return this.poS;
    }

    public a eqw() {
        return new a(this);
    }

    public g eqx() {
        g gVar = this.pum;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pul);
        this.pum = d;
        return d;
    }

    public boolean g() {
        return this.pnR.c();
    }

    public String toString() {
        return "Request{method=" + this.f5950b + ", url=" + this.pnR + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        String f5951b;
        Object e;
        s pnR;
        ac poS;
        v.a pun;

        public a() {
            this.f5951b = "GET";
            this.pun = new v.a();
        }

        a(ab abVar) {
            this.pnR = abVar.pnR;
            this.f5951b = abVar.f5950b;
            this.poS = abVar.poS;
            this.e = abVar.e;
            this.pun = abVar.pul.epU();
        }

        public a f(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pnR = sVar;
            return this;
        }

        public a YO(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            s YI = s.YI(str);
            if (YI == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return f(YI);
        }

        public a e(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            s d = s.d(url);
            if (d == null) {
                throw new IllegalArgumentException("unexpected url: " + url);
            }
            return f(d);
        }

        public a hm(String str, String str2) {
            this.pun.hl(str, str2);
            return this;
        }

        public a hn(String str, String str2) {
            this.pun.hj(str, str2);
            return this;
        }

        public a YP(String str) {
            this.pun.YF(str);
            return this;
        }

        public a e(v vVar) {
            this.pun = vVar.epU();
            return this;
        }

        public a eqy() {
            return a("GET", null);
        }

        public a eqz() {
            return a(HttpHead.METHOD_NAME, null);
        }

        public a a(ac acVar) {
            return a("POST", acVar);
        }

        public a b(ac acVar) {
            return a(HttpDelete.METHOD_NAME, acVar);
        }

        public a eqA() {
            return b(com.bytedance.sdk.a.b.a.c.poS);
        }

        public a c(ac acVar) {
            return a(HttpPut.METHOD_NAME, acVar);
        }

        public a d(ac acVar) {
            return a("PATCH", acVar);
        }

        public a a(String str, ac acVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (acVar != null && !com.bytedance.sdk.a.b.a.c.f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (acVar == null && com.bytedance.sdk.a.b.a.c.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.f5951b = str;
            this.poS = acVar;
            return this;
        }

        public ab eqB() {
            if (this.pnR == null) {
                throw new IllegalStateException("url == null");
            }
            return new ab(this);
        }
    }
}
