package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements View.OnClickListener {
    final /* synthetic */ el elL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(el elVar) {
        this.elL = elVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        com.baidu.tbadk.core.data.as asVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.as asVar8;
        com.baidu.tbadk.core.data.as asVar9;
        com.baidu.tbadk.core.data.as asVar10;
        com.baidu.tbadk.core.data.as asVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.as asVar12;
        com.baidu.tbadk.core.data.as asVar13;
        tbPageContext = this.elL.aat;
        if (com.baidu.tbadk.core.util.bg.aN(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hB()) {
            if (view == this.elL.elw) {
                asVar10 = this.elL.elI;
                if (asVar10 != null) {
                    asVar11 = this.elL.elI;
                    if (!TextUtils.isEmpty(asVar11.Ww)) {
                        com.baidu.tbadk.core.util.bb vB = com.baidu.tbadk.core.util.bb.vB();
                        tbPageContext4 = this.elL.aat;
                        asVar12 = this.elL.elI;
                        vB.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext4.getPageActivity()), new String[]{asVar12.Ww});
                        com.baidu.tbadk.core.util.as asVar14 = new com.baidu.tbadk.core.util.as("c11410");
                        asVar13 = this.elL.elI;
                        TiebaStatic.log(asVar14.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, asVar13.Ww));
                    }
                }
            } else if (view == this.elL.elB) {
                StringBuilder sb = new StringBuilder("link: ");
                asVar5 = this.elL.elJ;
                BdLog.e(sb.append(asVar5.Ww).toString());
                asVar6 = this.elL.elJ;
                if (asVar6 != null) {
                    asVar7 = this.elL.elJ;
                    if (!TextUtils.isEmpty(asVar7.Ww)) {
                        com.baidu.tbadk.core.util.bb vB2 = com.baidu.tbadk.core.util.bb.vB();
                        tbPageContext3 = this.elL.aat;
                        asVar8 = this.elL.elJ;
                        vB2.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext3.getPageActivity()), new String[]{asVar8.Ww});
                        com.baidu.tbadk.core.util.as asVar15 = new com.baidu.tbadk.core.util.as("c11409");
                        asVar9 = this.elL.elJ;
                        TiebaStatic.log(asVar15.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, asVar9.Ww));
                    }
                }
            } else if (view == this.elL.elE) {
                asVar = this.elL.elK;
                if (asVar != null) {
                    asVar2 = this.elL.elK;
                    if (!TextUtils.isEmpty(asVar2.Ww)) {
                        com.baidu.tbadk.core.util.bb vB3 = com.baidu.tbadk.core.util.bb.vB();
                        tbPageContext2 = this.elL.aat;
                        asVar3 = this.elL.elK;
                        vB3.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{asVar3.Ww});
                        com.baidu.tbadk.core.util.as asVar16 = new com.baidu.tbadk.core.util.as("c11408");
                        asVar4 = this.elL.elK;
                        TiebaStatic.log(asVar16.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, asVar4.Ww));
                    }
                }
            }
        }
    }
}
