package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements View.OnClickListener {
    final /* synthetic */ ed efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.efi = edVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.al alVar;
        com.baidu.tbadk.core.data.al alVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.al alVar3;
        com.baidu.tbadk.core.data.al alVar4;
        com.baidu.tbadk.core.data.al alVar5;
        com.baidu.tbadk.core.data.al alVar6;
        com.baidu.tbadk.core.data.al alVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.al alVar8;
        com.baidu.tbadk.core.data.al alVar9;
        com.baidu.tbadk.core.data.al alVar10;
        com.baidu.tbadk.core.data.al alVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.al alVar12;
        com.baidu.tbadk.core.data.al alVar13;
        tbPageContext = this.efi.DQ;
        if (com.baidu.tbadk.core.util.bn.ab(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.fH()) {
            if (view == this.efi.eeT) {
                alVar10 = this.efi.eff;
                if (alVar10 != null) {
                    alVar11 = this.efi.eff;
                    if (!TextUtils.isEmpty(alVar11.Pj)) {
                        com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
                        tbPageContext4 = this.efi.DQ;
                        alVar12 = this.efi.eff;
                        us.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext4.getPageActivity()), new String[]{alVar12.Pj});
                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11410");
                        alVar13 = this.efi.eff;
                        TiebaStatic.log(ayVar.ab("obj_source", alVar13.Pj));
                    }
                }
            } else if (view == this.efi.eeY) {
                StringBuilder sb = new StringBuilder("link: ");
                alVar5 = this.efi.efg;
                BdLog.e(sb.append(alVar5.Pj).toString());
                alVar6 = this.efi.efg;
                if (alVar6 != null) {
                    alVar7 = this.efi.efg;
                    if (!TextUtils.isEmpty(alVar7.Pj)) {
                        com.baidu.tbadk.core.util.bi us2 = com.baidu.tbadk.core.util.bi.us();
                        tbPageContext3 = this.efi.DQ;
                        alVar8 = this.efi.efg;
                        us2.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext3.getPageActivity()), new String[]{alVar8.Pj});
                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11409");
                        alVar9 = this.efi.efg;
                        TiebaStatic.log(ayVar2.ab("obj_source", alVar9.Pj));
                    }
                }
            } else if (view == this.efi.efb) {
                alVar = this.efi.efh;
                if (alVar != null) {
                    alVar2 = this.efi.efh;
                    if (!TextUtils.isEmpty(alVar2.Pj)) {
                        com.baidu.tbadk.core.util.bi us3 = com.baidu.tbadk.core.util.bi.us();
                        tbPageContext2 = this.efi.DQ;
                        alVar3 = this.efi.efh;
                        us3.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext2.getPageActivity()), new String[]{alVar3.Pj});
                        com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c11408");
                        alVar4 = this.efi.efh;
                        TiebaStatic.log(ayVar3.ab("obj_source", alVar4.Pj));
                    }
                }
            }
        }
    }
}
