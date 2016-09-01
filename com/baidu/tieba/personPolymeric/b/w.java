package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ int dQq;
    final /* synthetic */ q eHF;
    private final /* synthetic */ com.baidu.tbadk.data.k eHG;
    private final /* synthetic */ List eHH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHF = qVar;
        this.eHG = kVar;
        this.eHH = list;
        this.dQq = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eHF.eHx = true;
        switch (i) {
            case 0:
                this.eHF.d(this.eHG, this.eHH, this.dQq);
                break;
            case 1:
                this.eHF.aTw();
                break;
            case 2:
                this.eHF.aTx();
                break;
            case 3:
                TiebaStatic.log(new ay("c11616").s("obj_type", 1));
                this.eHF.aTy();
                break;
        }
        cVar.dismiss();
    }
}
