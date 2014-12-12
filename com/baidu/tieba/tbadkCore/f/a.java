package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int bZE = 10;
    private WriteData bNF;
    private d bZF;
    private b bZG;
    private c bZH;
    private boolean bZI;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bZF = null;
        this.bNF = null;
        this.bZG = null;
        this.bZH = null;
        this.bZI = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.bZF = null;
        this.bNF = null;
        this.bZG = null;
        this.bZH = null;
        this.bZI = false;
    }

    public void ey(boolean z) {
        this.bZI = z;
    }

    public void a(c cVar) {
        this.bZH = cVar;
    }

    public void a(b bVar) {
        this.bZG = bVar;
    }

    public void c(WriteData writeData) {
        this.bNF = writeData;
    }

    public WriteData EV() {
        return this.bNF;
    }

    public boolean aib() {
        if (this.bNF == null) {
            return false;
        }
        if (this.bZF == null) {
            this.bZF = new d(this);
            this.bZF.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bZF != null && !this.bZF.isCancelled()) {
            this.bZF.cancel();
            return false;
        }
        return false;
    }

    public boolean aic() {
        if (this.bNF == null) {
            return true;
        }
        int size = (!this.bNF.getIsBaobao() || this.bNF.getBaobaoImagesInfo() == null) ? 0 : this.bNF.getBaobaoImagesInfo().size() + 0;
        if (this.bNF.getWriteImagesInfo() != null) {
            size += this.bNF.getWriteImagesInfo().size();
        }
        return size <= bZE;
    }
}
