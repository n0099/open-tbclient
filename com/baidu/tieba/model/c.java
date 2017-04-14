package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dRQ;
    private final /* synthetic */ a.InterfaceC0030a dRR;
    private final /* synthetic */ String dRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0030a interfaceC0030a, String str) {
        this.dRQ = aVar;
        this.dRR = interfaceC0030a;
        this.dRS = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dRQ.setStoken(str);
        this.dRQ.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dRR != null) {
            this.dRR.b(this.dRS, 1, null);
        }
    }
}
