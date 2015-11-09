package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bPj = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.b bVar2;
        bVar = this.bPj.bPd;
        if (bVar != null) {
            iVar = this.bPj.bPg;
            iVar.aaq();
            az uX = az.uX();
            tbPageContext = this.bPj.mContext;
            bVar2 = this.bPj.bPd;
            uX.b(tbPageContext, new String[]{bVar2.TZ});
        }
    }
}
