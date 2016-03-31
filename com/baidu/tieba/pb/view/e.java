package com.baidu.tieba.pb.view;

import android.content.Context;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ PbNewChudianCommonView dqw;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbNewChudianCommonView pbNewChudianCommonView, String str) {
        this.dqw = pbNewChudianCommonView;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        b.a aVar2;
        b.a aVar3;
        aVar.dismiss();
        context = this.dqw.mContext;
        UtilHelper.callPhone(context, this.val$url);
        aVar2 = this.dqw.daU;
        if (aVar2 != null) {
            aVar3 = this.dqw.daU;
            aVar3.y(this.val$url, "BTN_CALL", "CLICK_FEEDBACK");
        }
    }
}
