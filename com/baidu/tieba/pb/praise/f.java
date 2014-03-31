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
    private int c;
    private int d;
    private int e;
    private List<a> f;
    private h g;
    private com.baidu.adp.framework.c.b h;

    public f() {
        this.a = "";
        this.b = "";
        this.c = 1;
        this.d = 0;
        this.e = 0;
        this.f = new ArrayList(100);
        this.g = null;
        this.h = new g(this, 1005000);
        this.a = "";
    }

    public f(String str, String str2, h hVar) {
        this.a = "";
        this.b = "";
        this.c = 1;
        this.d = 0;
        this.e = 0;
        this.f = new ArrayList(100);
        this.g = null;
        this.h = new g(this, 1005000);
        this.a = str;
        this.b = str2;
        this.g = hVar;
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1005000, String.valueOf(n.a) + "c/u/zan/getuserlist");
        bVar.a(PraiseListResponsedMessage.class);
        a.a(bVar);
        a.a(this.h);
    }

    public final void a(Bundle bundle, String str) {
        bundle.putString(str, this.a);
    }

    public final void b(Bundle bundle, String str) {
        bundle.putString(str, this.b);
    }

    public final void c(Bundle bundle, String str) {
        bundle.putInt(str, this.d);
    }

    public final void a() {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        a.b(this.h);
        a.e(1005000);
    }

    public final String b() {
        return this.b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final a b(int i) {
        if (i < 0 || i >= this.f.size()) {
            return null;
        }
        return this.f.get(i);
    }

    public final void c() {
        HttpMessage httpMessage = new HttpMessage(1005000);
        httpMessage.a("post_id", new StringBuilder(String.valueOf(this.a)).toString());
        httpMessage.a("page_num", new StringBuilder(String.valueOf(this.c)).toString());
        httpMessage.a("res_num", "20");
        httpMessage.b(1005000);
        com.baidu.adp.framework.c.a().a(httpMessage);
    }
}
