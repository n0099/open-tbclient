package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<TopRecActivity> {
    private boolean ayu;
    k cde;
    l cdf;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.ayu = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        this.cde = new k(this, null);
        this.cde.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cde != null) {
            this.cde.cancel();
            return false;
        }
        return false;
    }

    public void a(l lVar) {
        this.cdf = lVar;
    }
}
