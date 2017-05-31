package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements h.a {
    private final /* synthetic */ c.a dUb;
    private final /* synthetic */ a.InterfaceC0035a dUc;
    private final /* synthetic */ String dUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c.a aVar, a.InterfaceC0035a interfaceC0035a, String str) {
        this.dUb = aVar;
        this.dUc = interfaceC0035a;
        this.dUd = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dUb.setStoken(str);
        this.dUb.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dUc != null) {
            this.dUc.b(this.dUd, 1, null);
        }
    }
}
