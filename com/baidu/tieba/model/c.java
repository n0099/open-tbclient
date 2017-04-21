package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dUg;
    private final /* synthetic */ a.InterfaceC0030a dUh;
    private final /* synthetic */ String dUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0030a interfaceC0030a, String str) {
        this.dUg = aVar;
        this.dUh = interfaceC0030a;
        this.dUi = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dUg.setStoken(str);
        this.dUg.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dUh != null) {
            this.dUh.b(this.dUi, 1, null);
        }
    }
}
