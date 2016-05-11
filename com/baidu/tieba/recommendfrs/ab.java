package com.baidu.tieba.recommendfrs;

import com.baidu.tieba.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements a.InterfaceC0052a {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.dYM = rVar;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0052a
    public void O(int i, int i2) {
        this.dYM.bkf = true;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0052a
    public void P(int i, int i2) {
        this.dYM.bkf = false;
    }
}
