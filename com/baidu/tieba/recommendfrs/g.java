package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements r.a {
    final /* synthetic */ e doc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.doc = eVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        n nVar;
        nVar = this.doc.dnZ;
        nVar.update();
    }
}
