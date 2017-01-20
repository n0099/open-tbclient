package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eDB = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eDB.eDt = false;
        switch (i) {
            case 0:
                this.eDB.Qc();
                break;
            case 1:
                this.eDB.aRJ();
                break;
        }
        cVar.dismiss();
    }
}
