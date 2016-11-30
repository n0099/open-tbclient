package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ int dXL;
    final /* synthetic */ q eQi;
    private final /* synthetic */ com.baidu.tbadk.data.l eQj;
    private final /* synthetic */ List eQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tbadk.data.l lVar, List list, int i) {
        this.eQi = qVar;
        this.eQj = lVar;
        this.eQk = list;
        this.dXL = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eQi.eQa = true;
        switch (i) {
            case 0:
                this.eQi.d(this.eQj, this.eQk, this.dXL);
                break;
            case 1:
                this.eQi.aWa();
                break;
            case 2:
                this.eQi.aWb();
                break;
            case 3:
                TiebaStatic.log(new av("c11616").s("obj_type", 1));
                this.eQi.aWc();
                break;
        }
        cVar.dismiss();
    }
}
