package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ed implements View.OnClickListener {
    final /* synthetic */ ec dSR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(ec ecVar) {
        this.dSR = ecVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        com.baidu.tbadk.core.data.ah ahVar5;
        com.baidu.tbadk.core.data.ah ahVar6;
        com.baidu.tbadk.core.data.ah ahVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.ah ahVar8;
        com.baidu.tbadk.core.data.ah ahVar9;
        com.baidu.tbadk.core.data.ah ahVar10;
        com.baidu.tbadk.core.data.ah ahVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.ah ahVar12;
        com.baidu.tbadk.core.data.ah ahVar13;
        tbPageContext = this.dSR.Dp;
        if (com.baidu.tbadk.core.util.bn.ab(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.fI()) {
            if (view == this.dSR.dSC) {
                ahVar10 = this.dSR.dSO;
                if (ahVar10 != null) {
                    ahVar11 = this.dSR.dSO;
                    if (!TextUtils.isEmpty(ahVar11.OV)) {
                        com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
                        tbPageContext4 = this.dSR.Dp;
                        ahVar12 = this.dSR.dSO;
                        us.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext4.getPageActivity()), new String[]{ahVar12.OV});
                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11410");
                        ahVar13 = this.dSR.dSO;
                        TiebaStatic.log(ayVar.ab("obj_source", ahVar13.OV));
                    }
                }
            } else if (view == this.dSR.dSH) {
                StringBuilder sb = new StringBuilder("link: ");
                ahVar5 = this.dSR.dSP;
                BdLog.e(sb.append(ahVar5.OV).toString());
                ahVar6 = this.dSR.dSP;
                if (ahVar6 != null) {
                    ahVar7 = this.dSR.dSP;
                    if (!TextUtils.isEmpty(ahVar7.OV)) {
                        com.baidu.tbadk.core.util.bi us2 = com.baidu.tbadk.core.util.bi.us();
                        tbPageContext3 = this.dSR.Dp;
                        ahVar8 = this.dSR.dSP;
                        us2.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext3.getPageActivity()), new String[]{ahVar8.OV});
                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11409");
                        ahVar9 = this.dSR.dSP;
                        TiebaStatic.log(ayVar2.ab("obj_source", ahVar9.OV));
                    }
                }
            } else if (view == this.dSR.dSK) {
                ahVar = this.dSR.dSQ;
                if (ahVar != null) {
                    ahVar2 = this.dSR.dSQ;
                    if (!TextUtils.isEmpty(ahVar2.OV)) {
                        com.baidu.tbadk.core.util.bi us3 = com.baidu.tbadk.core.util.bi.us();
                        tbPageContext2 = this.dSR.Dp;
                        ahVar3 = this.dSR.dSQ;
                        us3.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext2.getPageActivity()), new String[]{ahVar3.OV});
                        com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c11408");
                        ahVar4 = this.dSR.dSQ;
                        TiebaStatic.log(ayVar3.ab("obj_source", ahVar4.OV));
                    }
                }
            }
        }
    }
}
