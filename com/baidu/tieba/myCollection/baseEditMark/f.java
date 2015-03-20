package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private boolean bEt;
    private MarkData bEu;
    private g bEv;
    private com.baidu.tbadk.baseEditMark.b bEw;

    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bEw = bVar;
    }

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bEt = false;
        this.bEu = null;
        this.bEv = null;
        this.bEw = null;
        this.bEu = new MarkData();
    }

    public boolean oQ() {
        return this.bEt;
    }

    public MarkData oT() {
        return this.bEu;
    }

    public void a(MarkData markData) {
        this.bEu = markData;
    }

    public void W(boolean z) {
        this.bEt = z;
    }

    public String oP() {
        if (this.bEu != null) {
            return this.bEu.getPostId();
        }
        return null;
    }

    public void oS() {
        if (this.bEv != null) {
            this.bEv.cancel();
        }
        this.bEv = new g(this, true);
        this.bEv.setPriority(3);
        this.bEv.execute(new Boolean[0]);
    }

    public void oR() {
        if (this.bEv != null) {
            this.bEv.cancel();
        }
        this.bEv = new g(this, false);
        this.bEv.setPriority(3);
        this.bEv.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bEv != null) {
            this.bEv.cancel();
            return false;
        }
        return false;
    }
}
