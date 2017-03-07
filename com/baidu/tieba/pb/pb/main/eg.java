package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements View.OnClickListener {
    final /* synthetic */ ef epQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ef efVar) {
        this.epQ = efVar;
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
        tbPageContext = this.epQ.aaI;
        if (com.baidu.tbadk.core.util.bg.aI(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hv()) {
            if (view == this.epQ.epB) {
                asVar10 = this.epQ.epN;
                if (asVar10 != null) {
                    asVar11 = this.epQ.epN;
                    if (!TextUtils.isEmpty(asVar11.WO)) {
                        com.baidu.tbadk.core.util.bb vQ = com.baidu.tbadk.core.util.bb.vQ();
                        tbPageContext4 = this.epQ.aaI;
                        asVar12 = this.epQ.epN;
                        vQ.c((TbPageContext) com.baidu.adp.base.k.aa(tbPageContext4.getPageActivity()), new String[]{asVar12.WO});
                        com.baidu.tbadk.core.util.as asVar14 = new com.baidu.tbadk.core.util.as("c11410");
                        asVar13 = this.epQ.epN;
                        TiebaStatic.log(asVar14.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, asVar13.WO));
                    }
                }
            } else if (view == this.epQ.epG) {
                StringBuilder sb = new StringBuilder("link: ");
                asVar5 = this.epQ.epO;
                BdLog.e(sb.append(asVar5.WO).toString());
                asVar6 = this.epQ.epO;
                if (asVar6 != null) {
                    asVar7 = this.epQ.epO;
                    if (!TextUtils.isEmpty(asVar7.WO)) {
                        com.baidu.tbadk.core.util.bb vQ2 = com.baidu.tbadk.core.util.bb.vQ();
                        tbPageContext3 = this.epQ.aaI;
                        asVar8 = this.epQ.epO;
                        vQ2.c((TbPageContext) com.baidu.adp.base.k.aa(tbPageContext3.getPageActivity()), new String[]{asVar8.WO});
                        com.baidu.tbadk.core.util.as asVar15 = new com.baidu.tbadk.core.util.as("c11409");
                        asVar9 = this.epQ.epO;
                        TiebaStatic.log(asVar15.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, asVar9.WO));
                    }
                }
            } else if (view == this.epQ.epJ) {
                asVar = this.epQ.epP;
                if (asVar != null) {
                    asVar2 = this.epQ.epP;
                    if (!TextUtils.isEmpty(asVar2.WO)) {
                        com.baidu.tbadk.core.util.bb vQ3 = com.baidu.tbadk.core.util.bb.vQ();
                        tbPageContext2 = this.epQ.aaI;
                        asVar3 = this.epQ.epP;
                        vQ3.c((TbPageContext) com.baidu.adp.base.k.aa(tbPageContext2.getPageActivity()), new String[]{asVar3.WO});
                        com.baidu.tbadk.core.util.as asVar16 = new com.baidu.tbadk.core.util.as("c11408");
                        asVar4 = this.epQ.epP;
                        TiebaStatic.log(asVar16.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, asVar4.WO));
                    }
                }
            }
        }
    }
}
