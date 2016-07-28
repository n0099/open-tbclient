package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class b implements t.b {
    final /* synthetic */ TopRecActivity dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dni = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aH(boolean z) {
        h hVar;
        hVar = this.dni.dna;
        hVar.LoadData();
    }
}
