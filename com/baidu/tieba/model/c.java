package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements h.a {
    private final /* synthetic */ b.a dRF;
    private final /* synthetic */ a.InterfaceC0032a dRG;
    private final /* synthetic */ String dRH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, a.InterfaceC0032a interfaceC0032a, String str) {
        this.dRF = aVar;
        this.dRG = interfaceC0032a;
        this.dRH = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.dRF.setStoken(str);
        this.dRF.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.dRG != null) {
            this.dRG.b(this.dRH, 1, null);
        }
    }
}
