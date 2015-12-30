package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cjA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cjA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.b bVar2;
        bVar = this.cjA.cju;
        if (bVar != null) {
            iVar = this.cjA.cjx;
            iVar.afe();
            bf vn = bf.vn();
            tbPageContext = this.cjA.mContext;
            bVar2 = this.cjA.cju;
            vn.a(tbPageContext, new String[]{bVar2.UQ}, true);
        }
    }
}
