package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dXU;
    private final /* synthetic */ a.InterfaceC0033a dXV;
    private final /* synthetic */ String dXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0033a interfaceC0033a, String str) {
        this.dXU = aVar;
        this.dXV = interfaceC0033a;
        this.dXW = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dXU.setStoken(str);
        this.dXU.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dXV != null) {
            this.dXV.b(this.dXW, 1, null);
        }
    }
}
