package com.baidu.tieba.image;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cjA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cjA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        com.baidu.tbadk.core.data.b bVar2;
        com.baidu.tbadk.core.data.b bVar3;
        com.baidu.tbadk.core.data.b bVar4;
        com.baidu.tbadk.core.data.b bVar5;
        com.baidu.tbadk.core.data.b bVar6;
        com.baidu.tbadk.core.data.b bVar7;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.b bVar8;
        i iVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.b bVar9;
        i iVar3;
        com.baidu.tbadk.core.data.b bVar10;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.b bVar11;
        bVar = this.cjA.cju;
        if (bVar != null) {
            iVar = this.cjA.cjx;
            iVar.afe();
            bVar2 = this.cjA.cju;
            int i = bVar2.UL;
            if (i == 0) {
                if (!com.baidu.adp.lib.util.i.iQ() || com.baidu.adp.lib.util.i.iR()) {
                    bVar8 = this.cjA.cju;
                    String str = bVar8.UN;
                    if (StringUtils.isNull(str)) {
                        tbPageContext3 = this.cjA.mContext;
                        str = tbPageContext3.getString(n.j.app_name);
                    }
                    iVar2 = this.cjA.cjx;
                    iVar2.afg();
                    tbPageContext2 = this.cjA.mContext;
                    Activity pageActivity = tbPageContext2.getPageActivity();
                    bVar9 = this.cjA.cju;
                    if (ah.a(pageActivity, bVar9, 0, str)) {
                        iVar3 = this.cjA.cjx;
                        bVar10 = this.cjA.cju;
                        iVar3.jy(bVar10.US);
                        return;
                    }
                    return;
                }
                a aVar = this.cjA;
                bVar11 = this.cjA.cju;
                aVar.c(bVar11);
            } else if (i == 2) {
                com.baidu.tbadk.download.b Bb = com.baidu.tbadk.download.b.Bb();
                bVar3 = this.cjA.cju;
                if (Bb.fa(bVar3.US)) {
                    bVar5 = this.cjA.cju;
                    String str2 = bVar5.US;
                    bVar6 = this.cjA.cju;
                    String str3 = bVar6.UR;
                    bVar7 = this.cjA.cju;
                    k kVar = new k(str2, str3, bVar7.UN);
                    tbPageContext = this.cjA.mContext;
                    ah.a(tbPageContext.getPageActivity(), kVar);
                    return;
                }
                bVar4 = this.cjA.cju;
                bVar4.UL = 0;
                this.cjA.aeT();
            }
        }
    }
}
