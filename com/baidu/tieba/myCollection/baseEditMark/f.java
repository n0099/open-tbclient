package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private boolean bEG;
    private MarkData bEH;
    private g bEI;
    private com.baidu.tbadk.baseEditMark.b bEJ;

    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bEJ = bVar;
    }

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bEG = false;
        this.bEH = null;
        this.bEI = null;
        this.bEJ = null;
        this.bEH = new MarkData();
    }

    public boolean oQ() {
        return this.bEG;
    }

    public MarkData oT() {
        return this.bEH;
    }

    public void a(MarkData markData) {
        this.bEH = markData;
    }

    public void W(boolean z) {
        this.bEG = z;
    }

    public String oP() {
        if (this.bEH != null) {
            return this.bEH.getPostId();
        }
        return null;
    }

    public void oS() {
        if (this.bEI != null) {
            this.bEI.cancel();
        }
        this.bEI = new g(this, true);
        this.bEI.setPriority(3);
        this.bEI.execute(new Boolean[0]);
    }

    public void oR() {
        if (this.bEI != null) {
            this.bEI.cancel();
        }
        this.bEI = new g(this, false);
        this.bEI.setPriority(3);
        this.bEI.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bEI != null) {
            this.bEI.cancel();
            return false;
        }
        return false;
    }
}
