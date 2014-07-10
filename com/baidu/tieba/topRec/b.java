package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ TopRecActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.a = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        k kVar;
        kVar = this.a.c;
        kVar.LoadData();
    }
}
