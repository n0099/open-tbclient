package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.a.d {
    private MarkData b;
    private boolean a = false;
    private aw c = null;
    private ax d = null;

    public av() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.a;
    }

    public MarkData b() {
        return this.b;
    }

    public void a(ax axVar) {
        this.d = axVar;
    }

    public void a(MarkData markData) {
        this.b = markData;
    }

    public void a(boolean z) {
        this.a = z;
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
        this.c = new aw(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void e() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new aw(this, false);
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
