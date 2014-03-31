package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
final class b implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ TopRecActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.a = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        l lVar;
        lVar = this.a.c;
        lVar.LoadData();
    }
}
