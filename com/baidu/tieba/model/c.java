package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dIA;
    private final /* synthetic */ a.InterfaceC0033a dIB;
    private final /* synthetic */ String dIC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0033a interfaceC0033a, String str) {
        this.dIA = aVar;
        this.dIB = interfaceC0033a;
        this.dIC = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dIA.setStoken(str);
        this.dIA.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dIB != null) {
            this.dIB.b(this.dIC, 1, null);
        }
    }
}
