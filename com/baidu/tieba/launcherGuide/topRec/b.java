package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class b implements t.b {
    final /* synthetic */ TopRecActivity dyQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dyQ = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        h hVar;
        hVar = this.dyQ.dyI;
        hVar.LoadData();
    }
}
