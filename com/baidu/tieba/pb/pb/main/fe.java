package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements View.OnClickListener {
    final /* synthetic */ fd eAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(fd fdVar) {
        this.eAJ = fdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.au auVar;
        com.baidu.tbadk.core.data.au auVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.au auVar3;
        com.baidu.tbadk.core.data.au auVar4;
        com.baidu.tbadk.core.data.au auVar5;
        com.baidu.tbadk.core.data.au auVar6;
        com.baidu.tbadk.core.data.au auVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.au auVar8;
        com.baidu.tbadk.core.data.au auVar9;
        com.baidu.tbadk.core.data.au auVar10;
        com.baidu.tbadk.core.data.au auVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.au auVar12;
        com.baidu.tbadk.core.data.au auVar13;
        tbPageContext = this.eAJ.aat;
        if (com.baidu.tbadk.core.util.bl.aN(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hA()) {
            if (view == this.eAJ.eAu) {
                auVar10 = this.eAJ.eAG;
                if (auVar10 != null) {
                    auVar11 = this.eAJ.eAG;
                    if (!TextUtils.isEmpty(auVar11.Wr)) {
                        com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
                        tbPageContext4 = this.eAJ.aat;
                        auVar12 = this.eAJ.eAG;
                        vP.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext4.getPageActivity()), new String[]{auVar12.Wr});
                        com.baidu.tbadk.core.util.au auVar14 = new com.baidu.tbadk.core.util.au("c11410");
                        auVar13 = this.eAJ.eAG;
                        TiebaStatic.log(auVar14.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, auVar13.Wr));
                    }
                }
            } else if (view == this.eAJ.eAz) {
                StringBuilder sb = new StringBuilder("link: ");
                auVar5 = this.eAJ.eAH;
                BdLog.e(sb.append(auVar5.Wr).toString());
                auVar6 = this.eAJ.eAH;
                if (auVar6 != null) {
                    auVar7 = this.eAJ.eAH;
                    if (!TextUtils.isEmpty(auVar7.Wr)) {
                        com.baidu.tbadk.core.util.be vP2 = com.baidu.tbadk.core.util.be.vP();
                        tbPageContext3 = this.eAJ.aat;
                        auVar8 = this.eAJ.eAH;
                        vP2.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext3.getPageActivity()), new String[]{auVar8.Wr});
                        com.baidu.tbadk.core.util.au auVar15 = new com.baidu.tbadk.core.util.au("c11409");
                        auVar9 = this.eAJ.eAH;
                        TiebaStatic.log(auVar15.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, auVar9.Wr));
                    }
                }
            } else if (view == this.eAJ.eAC) {
                auVar = this.eAJ.eAI;
                if (auVar != null) {
                    auVar2 = this.eAJ.eAI;
                    if (!TextUtils.isEmpty(auVar2.Wr)) {
                        com.baidu.tbadk.core.util.be vP3 = com.baidu.tbadk.core.util.be.vP();
                        tbPageContext2 = this.eAJ.aat;
                        auVar3 = this.eAJ.eAI;
                        vP3.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{auVar3.Wr});
                        com.baidu.tbadk.core.util.au auVar16 = new com.baidu.tbadk.core.util.au("c11408");
                        auVar4 = this.eAJ.eAI;
                        TiebaStatic.log(auVar16.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, auVar4.Wr));
                    }
                }
            }
        }
    }
}
