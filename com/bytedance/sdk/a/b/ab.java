package com.bytedance.sdk.a.b;

import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.bytedance.sdk.a.b.v;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
public final class ab {
    final String b;
    final Object e;
    final s pqB;
    final ac prz;
    final v pwQ;
    private volatile g pwR;

    ab(a aVar) {
        this.pqB = aVar.pqB;
        this.b = aVar.b;
        this.pwQ = aVar.pwS.eqk();
        this.prz = aVar.prz;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s eoY() {
        return this.pqB;
    }

    public String b() {
        return this.b;
    }

    public v epE() {
        return this.pwQ;
    }

    public String a(String str) {
        return this.pwQ.a(str);
    }

    public ac eqK() {
        return this.prz;
    }

    public a eqL() {
        return new a(this);
    }

    public g eqM() {
        g gVar = this.pwR;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pwQ);
        this.pwR = d;
        return d;
    }

    public boolean g() {
        return this.pqB.c();
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.pqB + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    /* loaded from: classes6.dex */
    public static class a {
        String b;
        Object e;
        s pqB;
        ac prz;
        v.a pwS;

        public a() {
            this.b = "GET";
            this.pwS = new v.a();
        }

        a(ab abVar) {
            this.pqB = abVar.pqB;
            this.b = abVar.b;
            this.prz = abVar.prz;
            this.e = abVar.e;
            this.pwS = abVar.pwQ.eqj();
        }

        public a f(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pqB = sVar;
            return this;
        }

        public a Zh(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            s Zb = s.Zb(str);
            if (Zb == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return f(Zb);
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

        public a ho(String str, String str2) {
            this.pwS.hn(str, str2);
            return this;
        }

        public a hp(String str, String str2) {
            this.pwS.hl(str, str2);
            return this;
        }

        public a Zi(String str) {
            this.pwS.YY(str);
            return this;
        }

        public a e(v vVar) {
            this.pwS = vVar.eqj();
            return this;
        }

        public a eqN() {
            return a("GET", null);
        }

        public a eqO() {
            return a(HttpHead.METHOD_NAME, null);
        }

        public a a(ac acVar) {
            return a("POST", acVar);
        }

        public a b(ac acVar) {
            return a(HttpDelete.METHOD_NAME, acVar);
        }

        public a eqP() {
            return b(com.bytedance.sdk.a.b.a.c.prz);
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
            this.b = str;
            this.prz = acVar;
            return this;
        }

        public ab eqQ() {
            if (this.pqB == null) {
                throw new IllegalStateException("url == null");
            }
            return new ab(this);
        }
    }
}
