package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    private final /* synthetic */ int dCo;
    final /* synthetic */ q etH;
    private final /* synthetic */ com.baidu.tbadk.data.l etI;
    private final /* synthetic */ List etJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tbadk.data.l lVar, List list, int i) {
        this.etH = qVar;
        this.etI = lVar;
        this.etJ = list;
        this.dCo = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.etH.d(this.etI, this.etJ, this.dCo);
                break;
            case 1:
                TiebaStatic.log(new at("c11616").s("obj_type", 2));
                this.etH.aPM();
                break;
        }
        cVar.dismiss();
    }
}
