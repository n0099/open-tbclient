package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class m implements x.a {
    final /* synthetic */ i clg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.clg = iVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        f fVar;
        fVar = this.clg.ckX;
        fVar.eI(true);
    }
}
