package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ int bys;
    final /* synthetic */ q eHd;
    private final /* synthetic */ com.baidu.tbadk.data.k eHe;
    private final /* synthetic */ List eHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHd = qVar;
        this.eHe = kVar;
        this.eHf = list;
        this.bys = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eHd.eGV = true;
        switch (i) {
            case 0:
                this.eHd.d(this.eHe, this.eHf, this.bys);
                break;
            case 1:
                this.eHd.QV();
                break;
            case 2:
                this.eHd.aRm();
                break;
            case 3:
                TiebaStatic.log(new as("c11616").s("obj_type", 1));
                this.eHd.aRn();
                break;
        }
        cVar.dismiss();
    }
}
