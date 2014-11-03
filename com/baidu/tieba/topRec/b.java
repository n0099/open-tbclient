package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ TopRecActivity bPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.bPL = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        j jVar;
        jVar = this.bPL.bPD;
        jVar.LoadData();
    }
}
