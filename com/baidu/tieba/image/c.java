package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bOD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bOD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.b bVar2;
        bVar = this.bOD.bOx;
        if (bVar != null) {
            iVar = this.bOD.bOA;
            iVar.ZZ();
            ay uV = ay.uV();
            tbPageContext = this.bOD.mContext;
            bVar2 = this.bOD.bOx;
            uV.b(tbPageContext, new String[]{bVar2.TX});
        }
    }
}
