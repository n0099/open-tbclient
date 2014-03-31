package com.baidu.tieba.model;
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.a.e {
    private com.baidu.tbadk.core.message.d a;
    private com.baidu.tbadk.core.message.b b;
    private int c = 2;

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public final void a(long j) {
        this.a = new com.baidu.tbadk.core.message.d();
        this.a.e(1);
        this.a.d(10);
        this.a.a(String.valueOf(j));
        super.sendMessage(this.a);
    }

    public final void a(int i) {
        this.b = new com.baidu.tbadk.core.message.b();
        this.b.d(i);
        super.sendMessage(this.b);
    }

    public final void b(long j) {
        this.a = new com.baidu.tbadk.core.message.d();
        this.a.e(0);
        this.a.d(10);
        this.a.a(String.valueOf(j));
        super.sendMessage(this.a);
    }

    public final int a() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }
}
