package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.ad;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.d {
    public static String a = com.baidu.tbadk.core.frameworkData.a.ST_TYPE;
    private q b;
    private p d;
    private p e;
    private boolean f;
    private String g = null;
    private com.baidu.tieba.data.k c = new com.baidu.tieba.data.k();

    public o(Context context) {
    }

    public void a(Intent intent) {
        this.g = intent.getStringExtra(a);
    }

    public void a(Bundle bundle) {
        this.g = bundle.getString(a);
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return true;
    }

    public void a() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new p(this, 0, "");
        this.d.execute(new String[0]);
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
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

    public void b() {
        if (this.e != null) {
            this.e.cancel(true);
            this.e = null;
        }
        this.e = new p(this, 1, "");
        this.e.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.adp.lib.cache.s<String> K = ad.c().K();
        if (K != null) {
            K.a("dailyrecommend", str, 2592000000L);
        }
    }

    public void a(String str) {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new p(this, 2, str);
        this.d.execute(new String[0]);
    }

    public void a(q qVar) {
        this.b = qVar;
    }
}
