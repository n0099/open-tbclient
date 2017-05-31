package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements c.b {
    private final /* synthetic */ int bGw;
    final /* synthetic */ y eLx;
    private final /* synthetic */ com.baidu.tbadk.data.k eLy;
    private final /* synthetic */ List eLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(y yVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eLx = yVar;
        this.eLy = kVar;
        this.eLz = list;
        this.bGw = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eLx.d(this.eLy, this.eLz, this.bGw);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eLy;
                tbPageContext = this.eLx.ajh;
                ai.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                ai.a(this.eLy, this.eLz);
                break;
        }
        cVar.dismiss();
    }
}
