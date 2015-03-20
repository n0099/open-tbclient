package com.baidu.tieba.launcherGuide.topRec;
/* loaded from: classes.dex */
class a implements l {
    final /* synthetic */ TopRecActivity bxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bxJ = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.l
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        g gVar;
        g gVar2;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.bxJ.bxA;
            if (eVar != null) {
                eVar2 = this.bxJ.bxA;
                eVar2.a(tRForumListData);
                this.bxJ.bxD = tRForumListData;
            }
        } else {
            this.bxJ.showToast(str);
        }
        gVar = this.bxJ.bxz;
        gVar.cK(false);
        gVar2 = this.bxJ.bxz;
        gVar2.mW();
    }
}
