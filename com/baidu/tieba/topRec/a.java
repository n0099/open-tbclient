package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements m {
    final /* synthetic */ TopRecActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.a = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.m
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        g gVar;
        g gVar2;
        g gVar3;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.a.b;
            if (eVar != null) {
                eVar2 = this.a.b;
                eVar2.a(tRForumListData);
                this.a.f = tRForumListData;
            }
        } else {
            this.a.showToast(str);
        }
        gVar = this.a.a;
        gVar.a(false);
        gVar2 = this.a.a;
        gVar2.c();
        gVar3 = this.a.a;
        gVar3.f();
    }
}
