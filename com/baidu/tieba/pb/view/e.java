package com.baidu.tieba.pb.view;

import android.content.Context;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ PbNewChudianCommonView cVB;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbNewChudianCommonView pbNewChudianCommonView, String str) {
        this.cVB = pbNewChudianCommonView;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        a.InterfaceC0074a interfaceC0074a;
        a.InterfaceC0074a interfaceC0074a2;
        aVar.dismiss();
        context = this.cVB.mContext;
        UtilHelper.callPhone(context, this.val$url);
        interfaceC0074a = this.cVB.cHL;
        if (interfaceC0074a != null) {
            interfaceC0074a2 = this.cVB.cHL;
            interfaceC0074a2.u(this.val$url, "BTN_CALL", "CLICK_FEEDBACK");
        }
    }
}
