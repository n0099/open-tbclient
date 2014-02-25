package com.baidu.tieba.model;

import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.a.d {
    private static final String a = String.valueOf(com.baidu.tieba.data.i.a) + "c/s/gettaglist";
    private boolean b;
    private InterestFrsData c;
    private bi d;

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public InterestFrsData b() {
        return this.c;
    }

    public void a(InterestFrsData interestFrsData) {
        this.c = interestFrsData;
    }

    public void a(int i, int i2, int i3, bj bjVar) {
        this.d = new bi(i, i2, i3, bjVar);
        this.d.execute(new Void[0]);
    }

    public void c() {
        if (this.d != null) {
            this.d.cancel();
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
