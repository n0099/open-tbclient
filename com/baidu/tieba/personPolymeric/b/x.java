package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    private final /* synthetic */ int dQq;
    final /* synthetic */ q eHF;
    private final /* synthetic */ com.baidu.tbadk.data.k eHG;
    private final /* synthetic */ List eHH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHF = qVar;
        this.eHG = kVar;
        this.eHH = list;
        this.dQq = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eHF.d(this.eHG, this.eHH, this.dQq);
                break;
            case 1:
                TiebaStatic.log(new ay("c11616").s("obj_type", 2));
                this.eHF.aTy();
                break;
        }
        cVar.dismiss();
    }
}
