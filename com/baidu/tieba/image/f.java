package com.baidu.tieba.image;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a cjA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cjA = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.b bVar2;
        i iVar2;
        com.baidu.tbadk.core.data.b bVar3;
        TbPageContext tbPageContext2;
        bVar = this.cjA.cju;
        String str = bVar.UN;
        if (StringUtils.isNull(str)) {
            tbPageContext2 = this.cjA.mContext;
            str = tbPageContext2.getString(n.j.app_name);
        }
        iVar = this.cjA.cjx;
        iVar.afg();
        tbPageContext = this.cjA.mContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        bVar2 = this.cjA.cju;
        if (ah.a(pageActivity, bVar2, 0, str)) {
            iVar2 = this.cjA.cjx;
            bVar3 = this.cjA.cju;
            iVar2.jx(bVar3.US);
        }
        aVar.dismiss();
    }
}
