package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int cbw = 10;
    private WriteData bPo;
    private boolean cbA;
    private d cbx;
    private b cby;
    private c cbz;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cbx = null;
        this.bPo = null;
        this.cby = null;
        this.cbz = null;
        this.cbA = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.cbx = null;
        this.bPo = null;
        this.cby = null;
        this.cbz = null;
        this.cbA = false;
    }

    public void eF(boolean z) {
        this.cbA = z;
    }

    public void a(c cVar) {
        this.cbz = cVar;
    }

    public void a(b bVar) {
        this.cby = bVar;
    }

    public void c(WriteData writeData) {
        this.bPo = writeData;
    }

    public WriteData Fn() {
        return this.bPo;
    }

    public boolean aiA() {
        if (this.bPo == null) {
            return false;
        }
        if (this.cbx == null) {
            this.cbx = new d(this);
            this.cbx.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cbx != null && !this.cbx.isCancelled()) {
            this.cbx.cancel();
            return false;
        }
        return false;
    }

    public boolean aiB() {
        if (this.bPo == null) {
            return true;
        }
        int size = (!this.bPo.getIsBaobao() || this.bPo.getBaobaoImagesInfo() == null) ? 0 : this.bPo.getBaobaoImagesInfo().size() + 0;
        if (this.bPo.getWriteImagesInfo() != null) {
            size += this.bPo.getWriteImagesInfo().size();
        }
        return size <= cbw;
    }
}
