package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopRecActivity f1863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.f1863a = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.n
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        h hVar;
        h hVar2;
        h hVar3;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.f1863a.b;
            if (eVar != null) {
                eVar2 = this.f1863a.b;
                eVar2.a(tRForumListData);
                this.f1863a.f = tRForumListData;
            }
        } else {
            this.f1863a.a(str);
        }
        hVar = this.f1863a.f1862a;
        hVar.a(false);
        hVar2 = this.f1863a.f1862a;
        hVar2.c();
        hVar3 = this.f1863a.f1862a;
        hVar3.f();
    }
}
