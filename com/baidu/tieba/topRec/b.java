package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ TopRecActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.bPw = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        j jVar;
        jVar = this.bPw.bPo;
        jVar.LoadData();
    }
}
