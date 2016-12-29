package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q etH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.etH = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.etH.etz = false;
        switch (i) {
            case 0:
                this.etH.aPK();
                break;
            case 1:
                this.etH.aPL();
                break;
        }
        cVar.dismiss();
    }
}
