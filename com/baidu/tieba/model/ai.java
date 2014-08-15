package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.base.e {
    private MarkData b;
    private boolean a = false;
    private aj c = null;
    private ak d = null;

    public ai() {
        this.b = null;
        this.b = new MarkData();
    }

    public boolean a() {
        return this.a;
    }

    public MarkData b() {
        return this.b;
    }

    public void a(ak akVar) {
        this.d = akVar;
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
        this.c = new aj(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public void e() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new aj(this, false);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.c != null) {
            this.c.cancel();
            return false;
        }
        return false;
    }
}
