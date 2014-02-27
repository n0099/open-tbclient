package com.baidu.tieba.model;

import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public final class bh extends com.baidu.adp.a.d {
    private static final String a = String.valueOf(com.baidu.tieba.data.i.a) + "c/s/gettaglist";
    private boolean b;
    private InterestFrsData c;
    private bi d;

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final InterestFrsData b() {
        return this.c;
    }

    public final void a(InterestFrsData interestFrsData) {
        this.c = interestFrsData;
    }

    public final void a(int i, int i2, int i3, bj bjVar) {
        this.d = new bi(i, 0, 100, bjVar);
        this.d.execute(new Void[0]);
    }

    public final void c() {
        if (this.d != null) {
            this.d.cancel();
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
}
