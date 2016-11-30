package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eQi = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eQi.eQa = false;
        switch (i) {
            case 0:
                this.eQi.aWa();
                break;
            case 1:
                this.eQi.aWb();
                break;
        }
        cVar.dismiss();
    }
}
