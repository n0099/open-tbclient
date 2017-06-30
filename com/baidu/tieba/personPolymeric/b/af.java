package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements c.b {
    private final /* synthetic */ int bHp;
    final /* synthetic */ z eVB;
    private final /* synthetic */ com.baidu.tbadk.data.k eVC;
    private final /* synthetic */ List eVD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eVB = zVar;
        this.eVC = kVar;
        this.eVD = list;
        this.bHp = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eVB.eVt = true;
        switch (i) {
            case 0:
                this.eVB.d(this.eVC, this.eVD, this.bHp);
                break;
            case 1:
                this.eVB.TR();
                break;
            case 2:
                this.eVB.aVq();
                break;
            case 3:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11616").r("obj_type", 1));
                this.eVB.aVr();
                break;
        }
        cVar.dismiss();
    }
}
