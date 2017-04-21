package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eHp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eHp = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eHp.eHh = false;
        switch (i) {
            case 0:
                this.eHp.Sv();
                break;
            case 1:
                this.eHp.aSw();
                break;
        }
        cVar.dismiss();
    }
}
