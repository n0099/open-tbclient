package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eJJ = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eJJ.eJB = false;
        switch (i) {
            case 0:
                this.eJJ.aTT();
                break;
            case 1:
                this.eJJ.aTU();
                break;
        }
        cVar.dismiss();
    }
}
