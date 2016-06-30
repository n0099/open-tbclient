package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity dkj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dkj = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dkj.dka;
            if (dVar != null) {
                dVar2 = this.dkj.dka;
                dVar2.a(tRForumListData);
                this.dkj.dkd = tRForumListData;
            }
        } else {
            this.dkj.showToast(str);
        }
        this.dkj.djZ.fp(false);
        this.dkj.djZ.jA();
    }
}
