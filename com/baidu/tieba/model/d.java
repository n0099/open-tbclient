package com.baidu.tieba.model;
/* loaded from: classes.dex */
public final class d {
    private e a;
    private com.baidu.adp.a.g b;

    public d(com.baidu.adp.a.g gVar) {
        this.b = gVar;
    }

    public final void a(boolean z, String str, String str2) {
        if (this.a == null) {
            this.a = new e(this, (byte) 0);
            this.a.setPriority(2);
            this.a.a(z);
            this.a.a2(str);
            this.a.b(str2);
            this.a.execute(new Integer[0]);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.cancel();
        }
    }
}
