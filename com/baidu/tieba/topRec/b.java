package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopRecActivity f1864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.f1864a = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        l lVar;
        lVar = this.f1864a.c;
        lVar.LoadData();
    }
}
