package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity cER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.cER = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.cER.cEI;
            if (dVar != null) {
                dVar2 = this.cER.cEI;
                dVar2.a(tRForumListData);
                this.cER.cEL = tRForumListData;
            }
        } else {
            this.cER.showToast(str);
        }
        this.cER.cEH.ea(false);
        this.cER.cEH.nj();
    }
}
