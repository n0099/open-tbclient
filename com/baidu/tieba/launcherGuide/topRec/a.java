package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity dAh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dAh = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dAh.dzY;
            if (dVar != null) {
                dVar2 = this.dAh.dzY;
                dVar2.a(tRForumListData);
                this.dAh.dAb = tRForumListData;
            }
        } else {
            this.dAh.showToast(str);
        }
        this.dAh.dzX.fQ(false);
        this.dAh.dzX.ku();
    }
}
