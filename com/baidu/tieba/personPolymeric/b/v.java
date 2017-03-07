package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eHd = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eHd.eGV = false;
        switch (i) {
            case 0:
                this.eHd.QV();
                break;
            case 1:
                this.eHd.aRm();
                break;
        }
        cVar.dismiss();
    }
}
