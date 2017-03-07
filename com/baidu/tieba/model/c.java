package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dUx;
    private final /* synthetic */ a.InterfaceC0031a dUy;
    private final /* synthetic */ String dUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0031a interfaceC0031a, String str) {
        this.dUx = aVar;
        this.dUy = interfaceC0031a;
        this.dUz = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dUx.setStoken(str);
        this.dUx.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dUy != null) {
            this.dUy.b(this.dUz, 1, null);
        }
    }
}
