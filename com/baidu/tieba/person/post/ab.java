package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.s;
/* loaded from: classes.dex */
class ab implements s.a {
    final /* synthetic */ v dBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.dBQ = vVar;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.dBQ.dBN;
        if (qVar != null) {
            qVar2 = this.dBQ.dBN;
            qVar2.gL(true);
        }
    }
}
