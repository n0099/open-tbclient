package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopRecActivity f2545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.f2545a = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        l lVar;
        lVar = this.f2545a.c;
        lVar.LoadData();
    }
}
