package com.baidu.tieba.more;

import android.content.Context;
/* loaded from: classes.dex */
public final class au extends com.baidu.adp.a.d {
    private Context d;
    private av a = null;
    private aw b = null;
    private ax c = null;
    private com.baidu.tieba.i e = null;

    public au(Context context) {
        this.d = null;
        this.d = context;
    }

    public final void a() {
        if (this.a == null) {
            this.a = new av(this, (byte) 0);
            this.a.execute(new String[0]);
        }
    }

    public final void b() {
        if (this.b == null) {
            this.b = new aw(this, (byte) 0);
            this.b.execute(new String[0]);
        }
    }

    public final void c() {
        if (this.c == null) {
            this.c = new ax(this, (byte) 0);
            this.c.execute(new String[0]);
        }
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(com.baidu.tieba.i iVar) {
        this.e = iVar;
    }
}
