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
    final s pdE;
    final ac peC;
    final v pjV;
    private volatile g pjW;

    ab(a aVar) {
        this.pdE = aVar.pdE;
        this.f5948b = aVar.f5949b;
        this.pjV = aVar.pjX.enC();
        this.peC = aVar.peC;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s emp() {
        return this.pdE;
    }

    public String b() {
        return this.f5948b;
    }

    public v emV() {
        return this.pjV;
    }

    public String a(String str) {
        return this.pjV.a(str);
    }

    public ac eoc() {
        return this.peC;
    }

    public a eod() {
        return new a(this);
    }

    public g eoe() {
        g gVar = this.pjW;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pjV);
        this.pjW = d;
        return d;
    }

    public boolean g() {
        return this.pdE.c();
    }

    public String toString() {
        return "Request{method=" + this.f5948b + ", url=" + this.pdE + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        String f5949b;
        Object e;
        s pdE;
        ac peC;
        v.a pjX;

        public a() {
            this.f5949b = "GET";
            this.pjX = new v.a();
        }

        a(ab abVar) {
            this.pdE = abVar.pdE;
            this.f5949b = abVar.f5948b;
            this.peC = abVar.peC;
            this.e = abVar.e;
            this.pjX = abVar.pjV.enB();
        }

        public a f(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pdE = sVar;
            return this;
        }

        public a XN(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            s XH = s.XH(str);
            if (XH == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return f(XH);
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
            this.pjX.he(str, str2);
            return this;
        }

        public a hg(String str, String str2) {
            this.pjX.hc(str, str2);
            return this;
        }

        public a XO(String str) {
            this.pjX.XE(str);
            return this;
        }

        public a e(v vVar) {
            this.pjX = vVar.enB();
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
            return b(com.bytedance.sdk.a.b.a.c.peC);
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
            this.peC = acVar;
            return this;
        }

        public ab eoj() {
            if (this.pdE == null) {
                throw new IllegalStateException("url == null");
            }
            return new ab(this);
        }
    }
}
