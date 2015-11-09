package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.bTq = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.bTq.bTh;
            if (dVar != null) {
                dVar2 = this.bTq.bTh;
                dVar2.a(tRForumListData);
                this.bTq.bTk = tRForumListData;
            }
        } else {
            this.bTq.showToast(str);
        }
        this.bTq.bTg.dd(false);
        this.bTq.bTg.completePullRefresh();
    }
}
