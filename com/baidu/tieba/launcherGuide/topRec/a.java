package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity dyQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dyQ = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dyQ.dyH;
            if (dVar != null) {
                dVar2 = this.dyQ.dyH;
                dVar2.a(tRForumListData);
                this.dyQ.dyK = tRForumListData;
            }
        } else {
            this.dyQ.showToast(str);
        }
        this.dyQ.dyG.fN(false);
        this.dyQ.dyG.ku();
    }
}
