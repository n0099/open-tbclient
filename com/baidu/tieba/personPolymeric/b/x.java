package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    private final /* synthetic */ int byl;
    final /* synthetic */ q eEZ;
    private final /* synthetic */ com.baidu.tbadk.data.k eFa;
    private final /* synthetic */ List eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eEZ = qVar;
        this.eFa = kVar;
        this.eFb = list;
        this.byl = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eEZ.d(this.eFa, this.eFb, this.byl);
                break;
            case 1:
                TiebaStatic.log(new as("c11616").s("obj_type", 2));
                this.eEZ.aRw();
                break;
        }
        cVar.dismiss();
    }
}
