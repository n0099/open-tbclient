package com.bytedance.sdk.a.b;

import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.bytedance.sdk.a.b.v;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes4.dex */
public final class ab {

    /* renamed from: b  reason: collision with root package name */
    final String f5948b;
    final Object e;
    final s pdD;
    final ac peB;
    final v pjU;
    private volatile g pjV;

    ab(a aVar) {
        this.pdD = aVar.pdD;
        this.f5948b = aVar.f5949b;
        this.pjU = aVar.pjW.enC();
        this.peB = aVar.peB;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s emp() {
        return this.pdD;
    }

    public String b() {
        return this.f5948b;
    }

    public v emV() {
        return this.pjU;
    }

    public String a(String str) {
        return this.pjU.a(str);
    }

    public ac eoc() {
        return this.peB;
    }

    public a eod() {
        return new a(this);
    }

    public g eoe() {
        g gVar = this.pjV;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pjU);
        this.pjV = d;
        return d;
    }

    public boolean g() {
        return this.pdD.c();
    }

    public String toString() {
        return "Request{method=" + this.f5948b + ", url=" + this.pdD + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        String f5949b;
        Object e;
        s pdD;
        ac peB;
        v.a pjW;

        public a() {
            this.f5949b = "GET";
            this.pjW = new v.a();
        }

        a(ab abVar) {
            this.pdD = abVar.pdD;
            this.f5949b = abVar.f5948b;
            this.peB = abVar.peB;
            this.e = abVar.e;
            this.pjW = abVar.pjU.enB();
        }

        public a f(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pdD = sVar;
            return this;
        }

        public a XM(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            s XG = s.XG(str);
            if (XG == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return f(XG);
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

        public a hf(String str, String str2) {
            this.pjW.he(str, str2);
            return this;
        }

        public a hg(String str, String str2) {
            this.pjW.hc(str, str2);
            return this;
        }

        public a XN(String str) {
            this.pjW.XD(str);
            return this;
        }

        public a e(v vVar) {
            this.pjW = vVar.enB();
            return this;
        }

        public a eog() {
            return a("GET", null);
        }

        public a eoh() {
            return a(HttpHead.METHOD_NAME, null);
        }

        public a a(ac acVar) {
            return a("POST", acVar);
        }

        public a b(ac acVar) {
            return a(HttpDelete.METHOD_NAME, acVar);
        }

        public a eoi() {
            return b(com.bytedance.sdk.a.b.a.c.peB);
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
            this.f5949b = str;
            this.peB = acVar;
            return this;
        }

        public ab eoj() {
            if (this.pdD == null) {
                throw new IllegalStateException("url == null");
            }
            return new ab(this);
        }
    }
}
