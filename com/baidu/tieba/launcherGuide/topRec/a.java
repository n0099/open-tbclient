package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tieba.launcherGuide.topRec.h;
/* loaded from: classes.dex */
class a implements h.b {
    final /* synthetic */ TopRecActivity dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TopRecActivity topRecActivity) {
        this.dni = topRecActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.topRec.h.b
    public void a(Boolean bool, TRForumListData tRForumListData, int i, String str) {
        d dVar;
        d dVar2;
        if (bool.booleanValue() && i == 0) {
            dVar = this.dni.dmZ;
            if (dVar != null) {
                dVar2 = this.dni.dmZ;
                dVar2.a(tRForumListData);
                this.dni.dnc = tRForumListData;
            }
        } else {
            this.dni.showToast(str);
        }
        this.dni.dmY.fr(false);
        this.dni.dmY.jz();
    }
}
