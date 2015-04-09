package com.baidu.tieba.launcherGuide.topRec;
/* loaded from: classes.dex */
class a implements l {
    final /* synthetic */ TopRecActivity bxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bxZ = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.l
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        g gVar;
        g gVar2;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.bxZ.bxQ;
            if (eVar != null) {
                eVar2 = this.bxZ.bxQ;
                eVar2.a(tRForumListData);
                this.bxZ.bxT = tRForumListData;
            }
        } else {
            this.bxZ.showToast(str);
        }
        gVar = this.bxZ.bxP;
        gVar.cI(false);
        gVar2 = this.bxZ.bxP;
        gVar2.mW();
    }
}
