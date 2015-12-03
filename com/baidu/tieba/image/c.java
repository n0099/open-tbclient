package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cfw = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.b bVar2;
        bVar = this.cfw.cfq;
        if (bVar != null) {
            iVar = this.cfw.cft;
            iVar.adW();
            bf vD = bf.vD();
            tbPageContext = this.cfw.mContext;
            bVar2 = this.cfw.cfq;
            vD.b(tbPageContext, new String[]{bVar2.Up});
        }
    }
}
