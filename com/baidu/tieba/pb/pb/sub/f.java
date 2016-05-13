package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c.b {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ap apVar;
        ap apVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.s sVar = null;
        apVar = this.dqn.dqc;
        if (apVar.aAq() != null) {
            apVar2 = this.dqn.dqc;
            sVar = apVar2.aAq().avR();
        }
        if (sVar != null) {
            if (i == 0) {
                sVar.aT(this.dqn.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.dqn.d(sVar);
            }
        }
    }
}
