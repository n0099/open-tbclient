package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.z;
/* loaded from: classes.dex */
class b implements z.b {
    final /* synthetic */ TopRecActivity dFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dFL = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        h hVar;
        hVar = this.dFL.dFD;
        hVar.LoadData();
    }
}
