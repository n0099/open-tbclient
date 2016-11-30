package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    private final /* synthetic */ int dXL;
    final /* synthetic */ q eQi;
    private final /* synthetic */ com.baidu.tbadk.data.l eQj;
    private final /* synthetic */ List eQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tbadk.data.l lVar, List list, int i) {
        this.eQi = qVar;
        this.eQj = lVar;
        this.eQk = list;
        this.dXL = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eQi.d(this.eQj, this.eQk, this.dXL);
                break;
            case 1:
                TiebaStatic.log(new av("c11616").s("obj_type", 2));
                this.eQi.aWc();
                break;
        }
        cVar.dismiss();
    }
}
