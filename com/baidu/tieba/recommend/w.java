package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.d {
    public static String a = "st_type";
    private y b;
    private x d;
    private x e;
    private boolean f;
    private String g = null;
    private com.baidu.tieba.data.p c = new com.baidu.tieba.data.p();

    public w(Context context) {
    }

    public void a(Intent intent) {
        this.g = intent.getStringExtra(a);
    }

    public void a(Bundle bundle) {
        this.g = bundle.getString(a);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return true;
    }

    public void a() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new x(this, 0, "");
        this.d.execute(new String[0]);
    }

    @Override // com.baidu.adp.a.d
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
        this.e = new x(this, 1, "");
        this.e.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.adp.lib.cache.s<String> bf = TiebaApplication.g().bf();
        if (bf != null) {
            bf.a("dailyrecommend", str, 2592000000L);
        }
    }

    public void a(String str) {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new x(this, 2, str);
        this.d.execute(new String[0]);
    }

    public void a(y yVar) {
        this.b = yVar;
    }
}
