package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements c.b {
    private final /* synthetic */ int bGw;
    final /* synthetic */ y eLx;
    private final /* synthetic */ com.baidu.tbadk.data.k eLy;
    private final /* synthetic */ List eLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eLx = yVar;
        this.eLy = kVar;
        this.eLz = list;
        this.bGw = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eLx.eLp = true;
        switch (i) {
            case 0:
                this.eLx.d(this.eLy, this.eLz, this.bGw);
                break;
            case 1:
                this.eLx.Sc();
                break;
            case 2:
                this.eLx.aRj();
                break;
            case 3:
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11616").r("obj_type", 1));
                this.eLx.aRk();
                break;
        }
        cVar.dismiss();
    }
}
