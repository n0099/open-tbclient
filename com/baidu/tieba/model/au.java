package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.a.c {
    private MarkData b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1372a = false;
    private av c = null;
    private aw d = null;

    public au() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.f1372a;
    }

    public void a(aw awVar) {
        this.d = awVar;
    }

    public void a(MarkData markData) {
        this.b = markData;
    }

    public void a(boolean z) {
        this.f1372a = z;
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
        this.c = new av(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void d() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new av(this, false);
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
