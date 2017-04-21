package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements View.OnClickListener {
    final /* synthetic */ ed eqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.eqq = edVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ar arVar;
        com.baidu.tbadk.core.data.ar arVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.ar arVar3;
        com.baidu.tbadk.core.data.ar arVar4;
        com.baidu.tbadk.core.data.ar arVar5;
        com.baidu.tbadk.core.data.ar arVar6;
        com.baidu.tbadk.core.data.ar arVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.ar arVar8;
        com.baidu.tbadk.core.data.ar arVar9;
        com.baidu.tbadk.core.data.ar arVar10;
        com.baidu.tbadk.core.data.ar arVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.ar arVar12;
        com.baidu.tbadk.core.data.ar arVar13;
        tbPageContext = this.eqq.aaY;
        if (com.baidu.tbadk.core.util.bg.aK(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hB()) {
            if (view == this.eqq.eqb) {
                arVar10 = this.eqq.eqn;
                if (arVar10 != null) {
                    arVar11 = this.eqq.eqn;
                    if (!TextUtils.isEmpty(arVar11.Xe)) {
                        com.baidu.tbadk.core.util.bb wn = com.baidu.tbadk.core.util.bb.wn();
                        tbPageContext4 = this.eqq.aaY;
                        arVar12 = this.eqq.eqn;
                        wn.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext4.getPageActivity()), new String[]{arVar12.Xe});
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11410");
                        arVar13 = this.eqq.eqn;
                        TiebaStatic.log(asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, arVar13.Xe));
                    }
                }
            } else if (view == this.eqq.eqg) {
                StringBuilder sb = new StringBuilder("link: ");
                arVar5 = this.eqq.eqo;
                BdLog.e(sb.append(arVar5.Xe).toString());
                arVar6 = this.eqq.eqo;
                if (arVar6 != null) {
                    arVar7 = this.eqq.eqo;
                    if (!TextUtils.isEmpty(arVar7.Xe)) {
                        com.baidu.tbadk.core.util.bb wn2 = com.baidu.tbadk.core.util.bb.wn();
                        tbPageContext3 = this.eqq.aaY;
                        arVar8 = this.eqq.eqo;
                        wn2.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext3.getPageActivity()), new String[]{arVar8.Xe});
                        com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11409");
                        arVar9 = this.eqq.eqo;
                        TiebaStatic.log(asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, arVar9.Xe));
                    }
                }
            } else if (view == this.eqq.eqj) {
                arVar = this.eqq.eqp;
                if (arVar != null) {
                    arVar2 = this.eqq.eqp;
                    if (!TextUtils.isEmpty(arVar2.Xe)) {
                        com.baidu.tbadk.core.util.bb wn3 = com.baidu.tbadk.core.util.bb.wn();
                        tbPageContext2 = this.eqq.aaY;
                        arVar3 = this.eqq.eqp;
                        wn3.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{arVar3.Xe});
                        com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c11408");
                        arVar4 = this.eqq.eqp;
                        TiebaStatic.log(asVar3.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, arVar4.Xe));
                    }
                }
            }
        }
    }
}
