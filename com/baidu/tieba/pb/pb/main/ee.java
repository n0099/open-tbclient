package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements View.OnClickListener {
    final /* synthetic */ ed etw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.etw = edVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ao aoVar;
        com.baidu.tbadk.core.data.ao aoVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.ao aoVar3;
        com.baidu.tbadk.core.data.ao aoVar4;
        com.baidu.tbadk.core.data.ao aoVar5;
        com.baidu.tbadk.core.data.ao aoVar6;
        com.baidu.tbadk.core.data.ao aoVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.ao aoVar8;
        com.baidu.tbadk.core.data.ao aoVar9;
        com.baidu.tbadk.core.data.ao aoVar10;
        com.baidu.tbadk.core.data.ao aoVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.ao aoVar12;
        com.baidu.tbadk.core.data.ao aoVar13;
        tbPageContext = this.etw.Gd;
        if (com.baidu.tbadk.core.util.bm.ak(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            if (view == this.etw.eth) {
                aoVar10 = this.etw.ett;
                if (aoVar10 != null) {
                    aoVar11 = this.etw.ett;
                    if (!TextUtils.isEmpty(aoVar11.Sb)) {
                        com.baidu.tbadk.core.util.bh vL = com.baidu.tbadk.core.util.bh.vL();
                        tbPageContext4 = this.etw.Gd;
                        aoVar12 = this.etw.ett;
                        vL.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext4.getPageActivity()), new String[]{aoVar12.Sb});
                        com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c11410");
                        aoVar13 = this.etw.ett;
                        TiebaStatic.log(axVar.ab("obj_source", aoVar13.Sb));
                    }
                }
            } else if (view == this.etw.etm) {
                StringBuilder sb = new StringBuilder("link: ");
                aoVar5 = this.etw.etu;
                BdLog.e(sb.append(aoVar5.Sb).toString());
                aoVar6 = this.etw.etu;
                if (aoVar6 != null) {
                    aoVar7 = this.etw.etu;
                    if (!TextUtils.isEmpty(aoVar7.Sb)) {
                        com.baidu.tbadk.core.util.bh vL2 = com.baidu.tbadk.core.util.bh.vL();
                        tbPageContext3 = this.etw.Gd;
                        aoVar8 = this.etw.etu;
                        vL2.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext3.getPageActivity()), new String[]{aoVar8.Sb});
                        com.baidu.tbadk.core.util.ax axVar2 = new com.baidu.tbadk.core.util.ax("c11409");
                        aoVar9 = this.etw.etu;
                        TiebaStatic.log(axVar2.ab("obj_source", aoVar9.Sb));
                    }
                }
            } else if (view == this.etw.etp) {
                aoVar = this.etw.etv;
                if (aoVar != null) {
                    aoVar2 = this.etw.etv;
                    if (!TextUtils.isEmpty(aoVar2.Sb)) {
                        com.baidu.tbadk.core.util.bh vL3 = com.baidu.tbadk.core.util.bh.vL();
                        tbPageContext2 = this.etw.Gd;
                        aoVar3 = this.etw.etv;
                        vL3.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{aoVar3.Sb});
                        com.baidu.tbadk.core.util.ax axVar3 = new com.baidu.tbadk.core.util.ax("c11408");
                        aoVar4 = this.etw.etv;
                        TiebaStatic.log(axVar3.ab("obj_source", aoVar4.Sb));
                    }
                }
            }
        }
    }
}
