package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements c.b {
    private final /* synthetic */ int bHp;
    final /* synthetic */ z eVB;
    private final /* synthetic */ com.baidu.tbadk.data.k eVC;
    private final /* synthetic */ List eVD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eVB = zVar;
        this.eVC = kVar;
        this.eVD = list;
        this.bHp = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eVB.d(this.eVC, this.eVD, this.bHp);
                break;
            case 1:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11616").r("obj_type", 2));
                this.eVB.aVr();
                break;
        }
        cVar.dismiss();
    }
}
