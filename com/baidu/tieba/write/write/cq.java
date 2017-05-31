package com.baidu.tieba.write.write;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements a.InterfaceC0086a {
    final /* synthetic */ cm gbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cm cmVar) {
        this.gbK = cmVar;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0086a
    public void boz() {
        this.gbK.cT(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0086a
    public void onSuccess(List<SimpleForum> list) {
        this.gbK.cT(list);
    }
}
