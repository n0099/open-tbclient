package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.z;
/* loaded from: classes.dex */
class b implements z.b {
    final /* synthetic */ TopRecActivity diJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.diJ = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aM(boolean z) {
        h hVar;
        hVar = this.diJ.diB;
        hVar.LoadData();
    }
}
