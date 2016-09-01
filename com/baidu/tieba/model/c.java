package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dWa;
    private final /* synthetic */ a.InterfaceC0033a dWb;
    private final /* synthetic */ String dWc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0033a interfaceC0033a, String str) {
        this.dWa = aVar;
        this.dWb = interfaceC0033a;
        this.dWc = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dWa.setStoken(str);
        this.dWa.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dWb != null) {
            this.dWb.b(this.dWc, 1, null);
        }
    }
}
