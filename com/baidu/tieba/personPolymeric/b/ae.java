package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements c.b {
    final /* synthetic */ z eVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.eVB = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eVB.eVt = false;
        switch (i) {
            case 0:
                this.eVB.TR();
                break;
            case 1:
                this.eVB.aVq();
                break;
        }
        cVar.dismiss();
    }
}
