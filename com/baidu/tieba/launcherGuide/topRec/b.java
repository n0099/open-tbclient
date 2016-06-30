package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class b implements t.b {
    final /* synthetic */ TopRecActivity dkj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dkj = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        h hVar;
        hVar = this.dkj.dkb;
        hVar.LoadData();
    }
}
