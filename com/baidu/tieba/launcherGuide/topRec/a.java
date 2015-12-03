package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity cjE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.cjE = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.cjE.cjv;
            if (dVar != null) {
                dVar2 = this.cjE.cjv;
                dVar2.a(tRForumListData);
                this.cjE.cjy = tRForumListData;
            }
        } else {
            this.cjE.showToast(str);
        }
        this.cjE.cju.dz(false);
        this.cjE.cju.completePullRefresh();
    }
}
