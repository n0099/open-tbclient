package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.TopRecModel;
/* loaded from: classes.dex */
class a implements TopRecModel.b {
    final /* synthetic */ TopRecActivity dpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dpT = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.TopRecModel.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dpT.dpK;
            if (dVar != null) {
                dVar2 = this.dpT.dpK;
                dVar2.a(tRForumListData);
                this.dpT.dpN = tRForumListData;
            }
        } else {
            this.dpT.showToast(str);
        }
        this.dpT.dpJ.fX(false);
        this.dpT.dpJ.completePullRefresh();
    }
}
