package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class b implements t.b {
    final /* synthetic */ TopRecActivity cEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.cEJ = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        h hVar;
        hVar = this.cEJ.cEB;
        hVar.LoadData();
    }
}
