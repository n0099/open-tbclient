package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bOO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.b bVar2;
        bVar = this.bOO.bOI;
        if (bVar != null) {
            iVar = this.bOO.bOL;
            iVar.ZZ();
            az uW = az.uW();
            tbPageContext = this.bOO.mContext;
            bVar2 = this.bOO.bOI;
            uW.b(tbPageContext, new String[]{bVar2.TY});
        }
    }
}
