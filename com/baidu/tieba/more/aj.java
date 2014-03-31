package com.baidu.tieba.more;

import android.content.Context;
/* loaded from: classes.dex */
public final class aj extends com.baidu.adp.a.e {
    private Context d;
    private ak a = null;
    private al b = null;
    private am c = null;
    private com.baidu.tbadk.d e = null;

    public aj(Context context) {
        this.d = null;
        this.d = context;
    }

    public final void a() {
        if (this.a == null) {
            this.a = new ak(this, (byte) 0);
            this.a.execute(new String[0]);
        }
    }

    public final void b() {
        if (this.b == null) {
            this.b = new al(this, (byte) 0);
            this.b.execute(new String[0]);
        }
    }

    public final void c() {
        if (this.c == null) {
            this.c = new am(this, (byte) 0);
            this.c.execute(new String[0]);
        }
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(com.baidu.tbadk.d dVar) {
        this.e = dVar;
    }
}
