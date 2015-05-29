package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private boolean bHB;
    private MarkData bHC;
    private g bHD;
    private com.baidu.tbadk.baseEditMark.b bHE;

    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bHE = bVar;
    }

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bHB = false;
        this.bHC = null;
        this.bHD = null;
        this.bHE = null;
        this.bHC = new MarkData();
    }

    public boolean pq() {
        return this.bHB;
    }

    public MarkData pt() {
        return this.bHC;
    }

    public void a(MarkData markData) {
        this.bHC = markData;
    }

    public void Z(boolean z) {
        this.bHB = z;
    }

    public String pp() {
        if (this.bHC != null) {
            return this.bHC.getPostId();
        }
        return null;
    }

    public void ps() {
        if (this.bHD != null) {
            this.bHD.cancel();
        }
        this.bHD = new g(this, true);
        this.bHD.setPriority(3);
        this.bHD.execute(new Boolean[0]);
    }

    public void pr() {
        if (this.bHD != null) {
            this.bHD.cancel();
        }
        this.bHD = new g(this, false);
        this.bHD.setPriority(3);
        this.bHD.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bHD != null) {
            this.bHD.cancel();
            return false;
        }
        return false;
    }
}
