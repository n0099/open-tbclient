package com.baidu.tieba.pb.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ PbNewChudianCommonView cMN;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbNewChudianCommonView pbNewChudianCommonView, String str) {
        this.cMN = pbNewChudianCommonView;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        aVar.dismiss();
        interfaceC0072a = this.cMN.cBf;
        if (interfaceC0072a != null) {
            interfaceC0072a2 = this.cMN.cBf;
            interfaceC0072a2.t(this.val$url, "BTN_CANCEL", "CLICK_FEEDBACK");
        }
    }
}
