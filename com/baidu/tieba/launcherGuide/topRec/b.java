package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.y;
/* loaded from: classes.dex */
class b implements y.b {
    final /* synthetic */ TopRecActivity dAh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.dAh = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.y.b
    public void aI(boolean z) {
        h hVar;
        hVar = this.dAh.dzZ;
        hVar.LoadData();
    }
}
