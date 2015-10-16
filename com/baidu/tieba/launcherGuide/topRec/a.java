package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity bSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bSV = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.bSV.bSM;
            if (dVar != null) {
                dVar2 = this.bSV.bSM;
                dVar2.a(tRForumListData);
                this.bSV.bSP = tRForumListData;
            }
        } else {
            this.bSV.showToast(str);
        }
        this.bSV.bSL.db(false);
        this.bSV.bSL.completePullRefresh();
    }
}
