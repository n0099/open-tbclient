package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int cbx = 10;
    private WriteData bPp;
    private c cbA;
    private boolean cbB;
    private d cby;
    private b cbz;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cby = null;
        this.bPp = null;
        this.cbz = null;
        this.cbA = null;
        this.cbB = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.cby = null;
        this.bPp = null;
        this.cbz = null;
        this.cbA = null;
        this.cbB = false;
    }

    public void eF(boolean z) {
        this.cbB = z;
    }

    public void a(c cVar) {
        this.cbA = cVar;
    }

    public void a(b bVar) {
        this.cbz = bVar;
    }

    public void c(WriteData writeData) {
        this.bPp = writeData;
    }

    public WriteData Ft() {
        return this.bPp;
    }

    public boolean aiF() {
        if (this.bPp == null) {
            return false;
        }
        if (this.cby == null) {
            this.cby = new d(this);
            this.cby.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cby != null && !this.cby.isCancelled()) {
            this.cby.cancel();
            return false;
        }
        return false;
    }

    public boolean aiG() {
        if (this.bPp == null) {
            return true;
        }
        int size = (!this.bPp.getIsBaobao() || this.bPp.getBaobaoImagesInfo() == null) ? 0 : this.bPp.getBaobaoImagesInfo().size() + 0;
        if (this.bPp.getWriteImagesInfo() != null) {
            size += this.bPp.getWriteImagesInfo().size();
        }
        return size <= cbx;
    }
}
