package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private boolean bHC;
    private MarkData bHD;
    private g bHE;
    private com.baidu.tbadk.baseEditMark.b bHF;

    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bHF = bVar;
    }

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bHC = false;
        this.bHD = null;
        this.bHE = null;
        this.bHF = null;
        this.bHD = new MarkData();
    }

    public boolean pq() {
        return this.bHC;
    }

    public MarkData pt() {
        return this.bHD;
    }

    public void a(MarkData markData) {
        this.bHD = markData;
    }

    public void Z(boolean z) {
        this.bHC = z;
    }

    public String pp() {
        if (this.bHD != null) {
            return this.bHD.getPostId();
        }
        return null;
    }

    public void ps() {
        if (this.bHE != null) {
            this.bHE.cancel();
        }
        this.bHE = new g(this, true);
        this.bHE.setPriority(3);
        this.bHE.execute(new Boolean[0]);
    }

    public void pr() {
        if (this.bHE != null) {
            this.bHE.cancel();
        }
        this.bHE = new g(this, false);
        this.bHE.setPriority(3);
        this.bHE.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bHE != null) {
            this.bHE.cancel();
            return false;
        }
        return false;
    }
}
