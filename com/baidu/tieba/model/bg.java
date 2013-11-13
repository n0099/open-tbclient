package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.a.d {
    private MarkData b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1910a = false;
    private bh c = null;
    private bi d = null;

    public bg() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.f1910a;
    }

    public MarkData b() {
        return this.b;
    }

    public void a(bi biVar) {
        this.d = biVar;
    }

    public void a(MarkData markData) {
        this.b = markData;
    }

    public void a(boolean z) {
        this.f1910a = z;
    }

    public String c() {
        if (this.b != null) {
            return this.b.getPostId();
        }
        return null;
    }

    public void d() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new bh(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void e() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new bh(this, false);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.c != null) {
            this.c.cancel();
            return false;
        }
        return false;
    }
}
