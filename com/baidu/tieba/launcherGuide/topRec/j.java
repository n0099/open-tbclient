package com.baidu.tieba.launcherGuide.topRec;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<TopRecActivity> {
    private boolean aDr;
    k byh;
    l byi;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.aDr = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        this.byh = new k(this, null);
        this.byh.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.byh != null) {
            this.byh.cancel();
            return false;
        }
        return false;
    }

    public void a(l lVar) {
        this.byi = lVar;
    }
}
