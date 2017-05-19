package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ int bAD;
    final /* synthetic */ q eCE;
    private final /* synthetic */ com.baidu.tbadk.data.j eCF;
    private final /* synthetic */ List eCG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tbadk.data.j jVar, List list, int i) {
        this.eCE = qVar;
        this.eCF = jVar;
        this.eCG = list;
        this.bAD = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eCE.eCw = true;
        switch (i) {
            case 0:
                this.eCE.d(this.eCF, this.eCG, this.bAD);
                break;
            case 1:
                this.eCE.RQ();
                break;
            case 2:
                this.eCE.aPJ();
                break;
            case 3:
                TiebaStatic.log(new as("c11616").s("obj_type", 1));
                this.eCE.aPK();
                break;
        }
        cVar.dismiss();
    }
}
