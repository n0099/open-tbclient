package com.baidu.tieba.square;

import android.content.Context;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.e {
    private long aAa;
    private long aAb;
    private long aAc;
    private long aAd;
    private ao bNp;
    private ah bNq;
    private an bNr;

    public am(Context context) {
        super(context);
        this.bNp = null;
        this.bNq = null;
        this.bNr = null;
        this.aAa = 0L;
        this.aAb = 0L;
        this.aAc = 0L;
        this.aAd = 0L;
        this.bNq = new ah();
    }

    public long Fb() {
        return this.aAd;
    }

    public long Fc() {
        return this.aAb;
    }

    public long Fd() {
        return this.aAc;
    }

    public long Fe() {
        return this.aAa;
    }

    public ah adB() {
        return this.bNq;
    }

    public void a(an anVar) {
        this.bNr = anVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bNp != null) {
            this.bNp.cancel();
            return false;
        }
        return false;
    }

    public boolean adC() {
        return ho(1);
    }

    public boolean adD() {
        return ho(0);
    }

    public boolean ho(int i) {
        if (this.bNp != null) {
            return false;
        }
        this.bNp = new ao(this, i);
        this.bNp.execute(new Object[0]);
        return true;
    }
}
