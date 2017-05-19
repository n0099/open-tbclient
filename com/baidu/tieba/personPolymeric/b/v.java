package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eCE = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eCE.eCw = false;
        switch (i) {
            case 0:
                this.eCE.RQ();
                break;
            case 1:
                this.eCE.aPJ();
                break;
        }
        cVar.dismiss();
    }
}
