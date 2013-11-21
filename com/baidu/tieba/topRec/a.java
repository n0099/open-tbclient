package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopRecActivity f2427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.f2427a = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.o
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        h hVar;
        h hVar2;
        h hVar3;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.f2427a.b;
            if (eVar != null) {
                eVar2 = this.f2427a.b;
                eVar2.a(tRForumListData);
                this.f2427a.f = tRForumListData;
            }
        } else {
            this.f2427a.showToast(str);
        }
        hVar = this.f2427a.f2426a;
        hVar.a(false);
        hVar2 = this.f2427a.f2426a;
        hVar2.c();
        hVar3 = this.f2427a.f2426a;
        hVar3.f();
    }
}
