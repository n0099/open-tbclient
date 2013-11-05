package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.d {
    private MarkData b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1914a = false;
    private bg c = null;
    private bh d = null;

    public bf() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.f1914a;
    }

    public void a(bh bhVar) {
        this.d = bhVar;
    }

    public void a(MarkData markData) {
        this.b = markData;
    }

    public void a(boolean z) {
        this.f1914a = z;
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
        this.c = new bg(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void d() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new bg(this, false);
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
