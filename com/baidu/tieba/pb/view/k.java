package com.baidu.tieba.pb.view;

import android.content.Context;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ PbNewChudianCommonView dsA;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbNewChudianCommonView pbNewChudianCommonView, String str) {
        this.dsA = pbNewChudianCommonView;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        b.a aVar2;
        b.a aVar3;
        aVar.dismiss();
        context = this.dsA.mContext;
        UtilHelper.callPhone(context, this.val$url);
        aVar2 = this.dsA.ddo;
        if (aVar2 != null) {
            aVar3 = this.dsA.ddo;
            aVar3.z(this.val$url, "BTN_CALL", "CLICK_FEEDBACK");
        }
    }
}
