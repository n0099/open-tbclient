package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dOE;
    private final /* synthetic */ a.InterfaceC0035a dOF;
    private final /* synthetic */ String dOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0035a interfaceC0035a, String str) {
        this.dOE = aVar;
        this.dOF = interfaceC0035a;
        this.dOG = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dOE.setStoken(str);
        this.dOE.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dOF != null) {
            this.dOF.b(this.dOG, 1, null);
        }
    }
}
