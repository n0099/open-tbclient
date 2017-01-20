package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ int brs;
    final /* synthetic */ q eDB;
    private final /* synthetic */ com.baidu.tbadk.data.k eDC;
    private final /* synthetic */ List eDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eDB = qVar;
        this.eDC = kVar;
        this.eDD = list;
        this.brs = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eDB.eDt = true;
        switch (i) {
            case 0:
                this.eDB.d(this.eDC, this.eDD, this.brs);
                break;
            case 1:
                this.eDB.Qc();
                break;
            case 2:
                this.eDB.aRJ();
                break;
            case 3:
                TiebaStatic.log(new ar("c11616").s("obj_type", 1));
                this.eDB.aRK();
                break;
        }
        cVar.dismiss();
    }
}
