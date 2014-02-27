package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public final class av extends com.baidu.adp.a.d {
    private MarkData b;
    private boolean a = false;
    private aw c = null;
    private ax d = null;

    public av() {
        this.b = null;
        this.b = new MarkData();
    }

    public final boolean a() {
        return this.a;
    }

    public final MarkData b() {
        return this.b;
    }

    public final void a(ax axVar) {
        this.d = axVar;
    }

    public final void a(MarkData markData) {
        this.b = markData;
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final String c() {
        if (this.b != null) {
            return this.b.getPostId();
        }
        return null;
    }

    public final void d() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new aw(this, true);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    public final void e() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new aw(this, false);
        this.c.setPriority(3);
        this.c.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.c != null) {
            this.c.cancel();
            return false;
        }
        return false;
    }
}
