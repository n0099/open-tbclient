package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.ab;
/* loaded from: classes.dex */
class b implements ab.b {
    final /* synthetic */ TopRecActivity dsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dsm = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aL(boolean z) {
        TopRecModel topRecModel;
        topRecModel = this.dsm.dse;
        topRecModel.LoadData();
    }
}
