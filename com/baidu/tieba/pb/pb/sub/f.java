package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c.b {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ao aoVar;
        ao aoVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.r rVar = null;
        aoVar = this.cTK.cTz;
        if (aoVar.asw() != null) {
            aoVar2 = this.cTK.cTz;
            rVar = aoVar2.asw().aoQ();
        }
        if (rVar != null) {
            if (i == 0) {
                rVar.aT(this.cTK.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cTK.d(rVar);
            }
        }
    }
}
