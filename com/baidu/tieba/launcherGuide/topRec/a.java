package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.TopRecModel;
/* loaded from: classes.dex */
class a implements TopRecModel.b {
    final /* synthetic */ TopRecActivity dsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dsm = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.TopRecModel.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dsm.dsd;
            if (dVar != null) {
                dVar2 = this.dsm.dsd;
                dVar2.a(tRForumListData);
                this.dsm.dsg = tRForumListData;
            }
        } else {
            this.dsm.showToast(str);
        }
        this.dsm.dsc.fN(false);
        this.dsm.dsc.completePullRefresh();
    }
}
