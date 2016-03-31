package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c.b {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ap apVar;
        ap apVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.s sVar = null;
        apVar = this.doF.dou;
        if (apVar.aAg() != null) {
            apVar2 = this.doF.dou;
            sVar = apVar2.aAg().avI();
        }
        if (sVar != null) {
            if (i == 0) {
                sVar.aN(this.doF.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.doF.d(sVar);
            }
        }
    }
}
