package com.baidu.tieba.recommend;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class o extends com.baidu.adp.a.e {
    public static String a = "st_type";
    private q b;
    private p d;
    private p e;
    private boolean f;
    private String g = null;
    private com.baidu.tieba.data.k c = new com.baidu.tieba.data.k();

    public final void a(Intent intent) {
        this.g = intent.getStringExtra(a);
    }

    public final void a(Bundle bundle) {
        this.g = bundle.getString(a);
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return true;
    }

    public final void a() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new p(this, 0, "");
        this.d.execute(new String[0]);
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        if (this.e != null) {
            this.e.cancel(true);
            this.e = null;
        }
        return true;
    }

    public final void b() {
        if (this.e != null) {
            this.e.cancel(true);
            this.e = null;
        }
        this.e = new p(this, 1, "");
        this.e.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(o oVar, String str) {
        com.baidu.adp.lib.cache.s<String> G = com.baidu.tieba.p.c().G();
        if (G != null) {
            G.a("dailyrecommend", str, 2592000000L);
        }
    }

    public final void a(String str) {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new p(this, 2, str);
        this.d.execute(new String[0]);
    }

    public final void a(q qVar) {
        this.b = qVar;
    }
}
