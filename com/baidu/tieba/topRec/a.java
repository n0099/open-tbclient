package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
final class a implements n {
    final /* synthetic */ TopRecActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.a = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.n
    public final void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        h hVar;
        h hVar2;
        h hVar3;
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
        hVar = this.a.a;
        hVar.a(false);
        hVar2 = this.a.a;
        hVar2.c();
        hVar3 = this.a.a;
        hVar3.e();
    }
}
