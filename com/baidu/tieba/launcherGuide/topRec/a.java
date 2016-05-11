package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity cEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.cEJ = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.cEJ.cEA;
            if (dVar != null) {
                dVar2 = this.cEJ.cEA;
                dVar2.a(tRForumListData);
                this.cEJ.cED = tRForumListData;
            }
        } else {
            this.cEJ.showToast(str);
        }
        this.cEJ.cEz.eB(false);
        this.cEJ.cEz.jx();
    }
}
