package com.baidu.tieba.write;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0088a {
    final /* synthetic */ a gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gdz = aVar;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0088a
    public void brw() {
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0088a
    public void ci(List<SimpleForum> list) {
        this.gdz.gds = true;
        this.gdz.gdv = list;
        this.gdz.brs();
    }
}
