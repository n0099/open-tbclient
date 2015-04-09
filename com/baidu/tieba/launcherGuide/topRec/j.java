package com.baidu.tieba.launcherGuide.topRec;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<TopRecActivity> {
    private boolean aDz;
    k byx;
    l byy;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.aDz = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        this.byx = new k(this, null);
        this.byx.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.byx != null) {
            this.byx.cancel();
            return false;
        }
        return false;
    }

    public void a(l lVar) {
        this.byy = lVar;
    }
}
