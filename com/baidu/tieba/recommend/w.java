package com.baidu.tieba.recommend;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private y f2292a;
    private com.baidu.tieba.data.o b = new com.baidu.tieba.data.o();
    private x c;
    private x d;
    private boolean e;
    private Context f;

    public w(Context context) {
        this.f = context;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return true;
    }

    public void a() {
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
        this.c = new x(this, 0, "");
        this.c.execute(new String[0]);
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        return true;
    }

    public void b() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
        this.d = new x(this, 1, "");
        this.d.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.adp.lib.cache.s<String> bh = TiebaApplication.g().bh();
        if (bh != null) {
            bh.a("dailyrecommend", str, 2592000000L);
        }
    }

    public void a(String str) {
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
        this.c = new x(this, 2, str);
        this.c.execute(new String[0]);
    }

    public void a(y yVar) {
        this.f2292a = yVar;
    }
}
