package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity bSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bSK = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.bSK.bSB;
            if (dVar != null) {
                dVar2 = this.bSK.bSB;
                dVar2.a(tRForumListData);
                this.bSK.bSE = tRForumListData;
            }
        } else {
            this.bSK.showToast(str);
        }
        this.bSK.bSA.db(false);
        this.bSK.bSA.completePullRefresh();
    }
}
