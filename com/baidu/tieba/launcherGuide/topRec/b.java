package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.s;
/* loaded from: classes.dex */
class b implements s.a {
    final /* synthetic */ TopRecActivity cER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.cER = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        h hVar;
        hVar = this.cER.cEJ;
        hVar.LoadData();
    }
}
