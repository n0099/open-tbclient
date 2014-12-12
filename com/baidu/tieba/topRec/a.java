package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements l {
    final /* synthetic */ TopRecActivity ccL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.ccL = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.l
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        g gVar;
        g gVar2;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.ccL.ccC;
            if (eVar != null) {
                eVar2 = this.ccL.ccC;
                eVar2.a(tRForumListData);
                this.ccL.ccF = tRForumListData;
            }
        } else {
            this.ccL.showToast(str);
        }
        gVar = this.ccL.ccB;
        gVar.cR(false);
        gVar2 = this.ccL.ccB;
        gVar2.jJ();
    }
}
