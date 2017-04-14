package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ q eEZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.eEZ = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eEZ.eER = false;
        switch (i) {
            case 0:
                this.eEZ.Rt();
                break;
            case 1:
                this.eEZ.aRv();
                break;
        }
        cVar.dismiss();
    }
}
