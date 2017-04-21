package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    private final /* synthetic */ int bAC;
    final /* synthetic */ q eHp;
    private final /* synthetic */ com.baidu.tbadk.data.k eHq;
    private final /* synthetic */ List eHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHp = qVar;
        this.eHq = kVar;
        this.eHr = list;
        this.bAC = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eHp.d(this.eHq, this.eHr, this.bAC);
                break;
            case 1:
                TiebaStatic.log(new as("c11616").s("obj_type", 2));
                this.eHp.aSx();
                break;
        }
        cVar.dismiss();
    }
}
