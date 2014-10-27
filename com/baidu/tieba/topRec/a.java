package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class a implements l {
    final /* synthetic */ TopRecActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bPw = topRecActivity;
    }

    @Override // com.baidu.tieba.topRec.l
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        g gVar;
        g gVar2;
        e eVar;
        e eVar2;
        if (bool.booleanValue() && i == 0) {
            eVar = this.bPw.bPn;
            if (eVar != null) {
                eVar2 = this.bPw.bPn;
                eVar2.a(tRForumListData);
                this.bPw.bPq = tRForumListData;
            }
        } else {
            this.bPw.showToast(str);
        }
        gVar = this.bPw.bPm;
        gVar.da(false);
        gVar2 = this.bPw.bPm;
        gVar2.hN();
    }
}
