package com.baidu.tieba.square;

import android.content.Context;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.e {
    private long azR;
    private long azS;
    private long azT;
    private long azU;
    private ao bNa;
    private ah bNb;
    private an bNc;

    public am(Context context) {
        super(context);
        this.bNa = null;
        this.bNb = null;
        this.bNc = null;
        this.azR = 0L;
        this.azS = 0L;
        this.azT = 0L;
        this.azU = 0L;
        this.bNb = new ah();
    }

    public long EZ() {
        return this.azU;
    }

    public long Fa() {
        return this.azS;
    }

    public long Fb() {
        return this.azT;
    }

    public long Fc() {
        return this.azR;
    }

    public ah ady() {
        return this.bNb;
    }

    public void a(an anVar) {
        this.bNc = anVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bNa != null) {
            this.bNa.cancel();
            return false;
        }
        return false;
    }

    public boolean adz() {
        return ho(1);
    }

    public boolean adA() {
        return ho(0);
    }

    public boolean ho(int i) {
        if (this.bNa != null) {
            return false;
        }
        this.bNa = new ao(this, i);
        this.bNa.execute(new Object[0]);
        return true;
    }
}
