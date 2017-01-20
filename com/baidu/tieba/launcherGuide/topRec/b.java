package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.aa;
/* loaded from: classes.dex */
class b implements aa.b {
    final /* synthetic */ TopRecActivity dpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dpT = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.aa.b
    public void aM(boolean z) {
        TopRecModel topRecModel;
        topRecModel = this.dpT.dpL;
        topRecModel.LoadData();
    }
}
