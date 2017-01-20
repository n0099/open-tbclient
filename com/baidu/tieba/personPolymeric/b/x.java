package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    private final /* synthetic */ int brs;
    final /* synthetic */ q eDB;
    private final /* synthetic */ com.baidu.tbadk.data.k eDC;
    private final /* synthetic */ List eDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eDB = qVar;
        this.eDC = kVar;
        this.eDD = list;
        this.brs = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eDB.d(this.eDC, this.eDD, this.brs);
                break;
            case 1:
                TiebaStatic.log(new ar("c11616").s("obj_type", 2));
                this.eDB.aRK();
                break;
        }
        cVar.dismiss();
    }
}
