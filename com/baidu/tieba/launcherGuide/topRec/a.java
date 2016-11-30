package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity dFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dFL = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dFL.dFC;
            if (dVar != null) {
                dVar2 = this.dFL.dFC;
                dVar2.a(tRForumListData);
                this.dFL.dFF = tRForumListData;
            }
        } else {
            this.dFL.showToast(str);
        }
        this.dFL.dFB.gk(false);
        this.dFL.dFB.ku();
    }
}
