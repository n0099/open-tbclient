package com.baidu.tieba.pb.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ PbNewChudianCommonView cVB;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbNewChudianCommonView pbNewChudianCommonView, String str) {
        this.cVB = pbNewChudianCommonView;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        a.InterfaceC0074a interfaceC0074a;
        a.InterfaceC0074a interfaceC0074a2;
        aVar.dismiss();
        interfaceC0074a = this.cVB.cHL;
        if (interfaceC0074a != null) {
            interfaceC0074a2 = this.cVB.cHL;
            interfaceC0074a2.u(this.val$url, "BTN_CANCEL", "CLICK_FEEDBACK");
        }
    }
}
