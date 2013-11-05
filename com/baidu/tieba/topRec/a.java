package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopRecActivity f2385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.f2385a = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.o
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        h hVar;
        h hVar2;
        h hVar3;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.f2385a.b;
            if (eVar != null) {
                eVar2 = this.f2385a.b;
                eVar2.a(tRForumListData);
                this.f2385a.f = tRForumListData;
            }
        } else {
            this.f2385a.a(str);
        }
        hVar = this.f2385a.f2384a;
        hVar.a(false);
        hVar2 = this.f2385a.f2384a;
        hVar2.c();
        hVar3 = this.f2385a.f2384a;
        hVar3.f();
    }
}
