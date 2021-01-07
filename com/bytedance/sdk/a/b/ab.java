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
    final String f6248b;
    final Object e;
    final s pih;
    final ac pjg;
    final v poA;
    private volatile g poB;

    ab(a aVar) {
        this.pih = aVar.pih;
        this.f6248b = aVar.f6249b;
        this.poA = aVar.poC.ery();
        this.pjg = aVar.pjg;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s eql() {
        return this.pih;
    }

    public String b() {
        return this.f6248b;
    }

    public v eqR() {
        return this.poA;
    }

    public String a(String str) {
        return this.poA.a(str);
    }

    public ac erX() {
        return this.pjg;
    }

    public a erY() {
        return new a(this);
    }

    public g erZ() {
        g gVar = this.poB;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.poA);
        this.poB = d;
        return d;
    }

    public boolean g() {
        return this.pih.c();
    }

    public String toString() {
        return "Request{method=" + this.f6248b + ", url=" + this.pih + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        String f6249b;
        Object e;
        s pih;
        ac pjg;
        v.a poC;

        public a() {
            this.f6249b = "GET";
            this.poC = new v.a();
        }

        a(ab abVar) {
            this.pih = abVar.pih;
            this.f6249b = abVar.f6248b;
            this.pjg = abVar.pjg;
            this.e = abVar.e;
            this.poC = abVar.poA.erx();
        }

        public a f(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pih = sVar;
            return this;
        }

        public a YU(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            s YO = s.YO(str);
            if (YO == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return f(YO);
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

        public a hg(String str, String str2) {
            this.poC.hf(str, str2);
            return this;
        }

        public a hh(String str, String str2) {
            this.poC.hd(str, str2);
            return this;
        }

        public a YV(String str) {
            this.poC.YL(str);
            return this;
        }

        public a e(v vVar) {
            this.poC = vVar.erx();
            return this;
        }

        public a esa() {
            return a("GET", null);
        }

        public a esb() {
            return a(HttpHead.METHOD_NAME, null);
        }

        public a a(ac acVar) {
            return a("POST", acVar);
        }

        public a b(ac acVar) {
            return a(HttpDelete.METHOD_NAME, acVar);
        }

        public a esc() {
            return b(com.bytedance.sdk.a.b.a.c.pjg);
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
            this.f6249b = str;
            this.pjg = acVar;
            return this;
        }

        public ab esd() {
            if (this.pih == null) {
                throw new IllegalStateException("url == null");
            }
            return new ab(this);
        }
    }
}
