package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.c {
    private MarkData b;
    private boolean a = false;
    private an c = null;
    private ao d = null;

    public am() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.a;
    }

    public void a(ao aoVar) {
        this.d = aoVar;
    }

    public void a(MarkData markData) {
        this.b = markData;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public String b() {
        if (this.b != null) {
            return this.b.getPostId();
        }
        return null;
    }

    public void c() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new an(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void d() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new an(this, false);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.c != null) {
            this.c.cancel();
            return false;
        }
        return false;
    }
}
