package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements c.b {
    private final /* synthetic */ int bGw;
    final /* synthetic */ y eLx;
    private final /* synthetic */ com.baidu.tbadk.data.k eLy;
    private final /* synthetic */ List eLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(y yVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eLx = yVar;
        this.eLy = kVar;
        this.eLz = list;
        this.bGw = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        switch (i) {
            case 0:
                this.eLx.d(this.eLy, this.eLz, this.bGw);
                break;
            case 1:
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11616").r("obj_type", 2));
                this.eLx.aRk();
                break;
        }
        cVar.dismiss();
    }
}
