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
    final s pou;
    final ac ppu;
    final v puL;
    private volatile g puM;

    ab(a aVar) {
        this.pou = aVar.pou;
        this.f5950b = aVar.f5951b;
        this.puL = aVar.puN.eqd();
        this.ppu = aVar.ppu;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s eoR() {
        return this.pou;
    }

    public String b() {
        return this.f5950b;
    }

    public v epx() {
        return this.puL;
    }

    public String a(String str) {
        return this.puL.a(str);
    }

    public ac eqD() {
        return this.ppu;
    }

    public a eqE() {
        return new a(this);
    }

    public g eqF() {
        g gVar = this.puM;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.puL);
        this.puM = d;
        return d;
    }

    public boolean g() {
        return this.pou.c();
    }

    public String toString() {
        return "Request{method=" + this.f5950b + ", url=" + this.pou + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        String f5951b;
        Object e;
        s pou;
        ac ppu;
        v.a puN;

        public a() {
            this.f5951b = "GET";
            this.puN = new v.a();
        }

        a(ab abVar) {
            this.pou = abVar.pou;
            this.f5951b = abVar.f5950b;
            this.ppu = abVar.ppu;
            this.e = abVar.e;
            this.puN = abVar.puL.eqc();
        }

        public a f(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pou = sVar;
            return this;
        }

        public a Za(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            s YU = s.YU(str);
            if (YU == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return f(YU);
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
            this.puN.hn(str, str2);
            return this;
        }

        public a hp(String str, String str2) {
            this.puN.hl(str, str2);
            return this;
        }

        public a Zb(String str) {
            this.puN.YR(str);
            return this;
        }

        public a e(v vVar) {
            this.puN = vVar.eqc();
            return this;
        }

        public a eqG() {
            return a("GET", null);
        }

        public a eqH() {
            return a(HttpHead.METHOD_NAME, null);
        }

        public a a(ac acVar) {
            return a("POST", acVar);
        }

        public a b(ac acVar) {
            return a(HttpDelete.METHOD_NAME, acVar);
        }

        public a eqI() {
            return b(com.bytedance.sdk.a.b.a.c.ppu);
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
            this.ppu = acVar;
            return this;
        }

        public ab eqJ() {
            if (this.pou == null) {
                throw new IllegalStateException("url == null");
            }
            return new ab(this);
        }
    }
}
