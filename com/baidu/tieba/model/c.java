package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a edU;
    private final /* synthetic */ a.InterfaceC0033a edV;
    private final /* synthetic */ String edW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0033a interfaceC0033a, String str) {
        this.edU = aVar;
        this.edV = interfaceC0033a;
        this.edW = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.edU.setStoken(str);
        this.edU.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.edV != null) {
            this.edV.b(this.edW, 1, null);
        }
    }
}
