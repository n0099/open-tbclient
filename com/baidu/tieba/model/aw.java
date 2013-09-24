package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.a.c {
    private MarkData b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1409a = false;
    private ax c = null;
    private ay d = null;

    public aw() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.f1409a;
    }

    public void a(ay ayVar) {
        this.d = ayVar;
    }

    public void a(MarkData markData) {
        this.b = markData;
    }

    public void a(boolean z) {
        this.f1409a = z;
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
        this.c = new ax(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void d() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new ax(this, false);
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
