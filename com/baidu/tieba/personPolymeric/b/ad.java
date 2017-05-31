package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ y eLx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar) {
        this.eLx = yVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eLx.eLp = false;
        switch (i) {
            case 0:
                this.eLx.Sc();
                break;
            case 1:
                this.eLx.aRj();
                break;
        }
        cVar.dismiss();
    }
}
