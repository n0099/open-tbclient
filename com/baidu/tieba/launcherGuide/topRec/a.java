package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity diJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.diJ = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.diJ.diA;
            if (dVar != null) {
                dVar2 = this.diJ.diA;
                dVar2.a(tRForumListData);
                this.diJ.diD = tRForumListData;
            }
        } else {
            this.diJ.showToast(str);
        }
        this.diJ.diz.fU(false);
        this.diJ.diz.ku();
    }
}
