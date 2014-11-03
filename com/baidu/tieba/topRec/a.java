package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements l {
    final /* synthetic */ TopRecActivity bPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bPL = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.l
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        g gVar;
        g gVar2;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.bPL.bPC;
            if (eVar != null) {
                eVar2 = this.bPL.bPC;
                eVar2.a(tRForumListData);
                this.bPL.bPF = tRForumListData;
            }
        } else {
            this.bPL.showToast(str);
        }
        gVar = this.bPL.bPB;
        gVar.da(false);
        gVar2 = this.bPL.bPB;
        gVar2.hN();
    }
}
