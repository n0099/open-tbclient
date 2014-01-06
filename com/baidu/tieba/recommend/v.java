package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.a.d {
    public static String a = "st_type";
    private x b;
    private w d;
    private w e;
    private boolean f;
    private String g = null;
    private com.baidu.tieba.data.o c = new com.baidu.tieba.data.o();

    public v(Context context) {
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
        this.d = new w(this, 0, "");
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
        this.e = new w(this, 1, "");
        this.e.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.adp.lib.cache.s<String> bh = TiebaApplication.g().bh();
        if (bh != null) {
            bh.a("dailyrecommend", str, 2592000000L);
        }
    }

    public void a(String str) {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new w(this, 2, str);
        this.d.execute(new String[0]);
    }

    public void a(x xVar) {
        this.b = xVar;
    }
}
