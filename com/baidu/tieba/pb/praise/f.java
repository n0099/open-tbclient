package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class f {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private List<a> h;
    private h i;
    private com.baidu.adp.framework.c.b j;

    public f() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = new ArrayList(100);
        this.i = null;
        this.j = new g(this, 1005000);
        this.a = "";
        this.b = "";
    }

    public f(String str, String str2, String str3, boolean z, h hVar) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = new ArrayList(100);
        this.i = null;
        this.j = new g(this, 1005000);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.i = hVar;
        this.d = z;
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1005000, String.valueOf(n.a) + "c/u/zan/getuserlist");
        bVar.a(PraiseListResponsedMessage.class);
        a.a(bVar);
        a.a(this.j);
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.d;
    }

    public final void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.d);
    }

    public final void b(Bundle bundle, String str) {
        bundle.putString(str, this.a);
    }

    public final void c(Bundle bundle, String str) {
        bundle.putString(str, this.b);
    }

    public final void d(Bundle bundle, String str) {
        bundle.putString(str, this.c);
    }

    public final void e(Bundle bundle, String str) {
        bundle.putInt(str, this.f);
    }

    public final void c() {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        a.b(this.j);
        a.e(1005000);
    }

    public final String d() {
        return this.c;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final a b(int i) {
        if (i < 0 || i >= this.h.size()) {
            return null;
        }
        return this.h.get(i);
    }

    public final void e() {
        HttpMessage httpMessage = new HttpMessage(1005000);
        httpMessage.a("post_id", new StringBuilder(String.valueOf(this.b)).toString());
        httpMessage.a("page_num", new StringBuilder(String.valueOf(this.e)).toString());
        httpMessage.a("res_num", "20");
        httpMessage.b(1005000);
        com.baidu.adp.framework.c.a().a(httpMessage);
    }
}
