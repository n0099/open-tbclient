package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ef implements View.OnClickListener {
    final /* synthetic */ ee ezN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar) {
        this.ezN = eeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.aq aqVar;
        com.baidu.tbadk.core.data.aq aqVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.aq aqVar3;
        com.baidu.tbadk.core.data.aq aqVar4;
        com.baidu.tbadk.core.data.aq aqVar5;
        com.baidu.tbadk.core.data.aq aqVar6;
        com.baidu.tbadk.core.data.aq aqVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.aq aqVar8;
        com.baidu.tbadk.core.data.aq aqVar9;
        com.baidu.tbadk.core.data.aq aqVar10;
        com.baidu.tbadk.core.data.aq aqVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.aq aqVar12;
        com.baidu.tbadk.core.data.aq aqVar13;
        tbPageContext = this.ezN.Gf;
        if (com.baidu.tbadk.core.util.bk.ak(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            if (view == this.ezN.ezy) {
                aqVar10 = this.ezN.ezK;
                if (aqVar10 != null) {
                    aqVar11 = this.ezN.ezK;
                    if (!TextUtils.isEmpty(aqVar11.Sw)) {
                        com.baidu.tbadk.core.util.bf vP = com.baidu.tbadk.core.util.bf.vP();
                        tbPageContext4 = this.ezN.Gf;
                        aqVar12 = this.ezN.ezK;
                        vP.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext4.getPageActivity()), new String[]{aqVar12.Sw});
                        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c11410");
                        aqVar13 = this.ezN.ezK;
                        TiebaStatic.log(avVar.ab("obj_source", aqVar13.Sw));
                    }
                }
            } else if (view == this.ezN.ezD) {
                StringBuilder sb = new StringBuilder("link: ");
                aqVar5 = this.ezN.ezL;
                BdLog.e(sb.append(aqVar5.Sw).toString());
                aqVar6 = this.ezN.ezL;
                if (aqVar6 != null) {
                    aqVar7 = this.ezN.ezL;
                    if (!TextUtils.isEmpty(aqVar7.Sw)) {
                        com.baidu.tbadk.core.util.bf vP2 = com.baidu.tbadk.core.util.bf.vP();
                        tbPageContext3 = this.ezN.Gf;
                        aqVar8 = this.ezN.ezL;
                        vP2.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext3.getPageActivity()), new String[]{aqVar8.Sw});
                        com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c11409");
                        aqVar9 = this.ezN.ezL;
                        TiebaStatic.log(avVar2.ab("obj_source", aqVar9.Sw));
                    }
                }
            } else if (view == this.ezN.ezG) {
                aqVar = this.ezN.ezM;
                if (aqVar != null) {
                    aqVar2 = this.ezN.ezM;
                    if (!TextUtils.isEmpty(aqVar2.Sw)) {
                        com.baidu.tbadk.core.util.bf vP3 = com.baidu.tbadk.core.util.bf.vP();
                        tbPageContext2 = this.ezN.Gf;
                        aqVar3 = this.ezN.ezM;
                        vP3.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{aqVar3.Sw});
                        com.baidu.tbadk.core.util.av avVar3 = new com.baidu.tbadk.core.util.av("c11408");
                        aqVar4 = this.ezN.ezM;
                        TiebaStatic.log(avVar3.ab("obj_source", aqVar4.Sw));
                    }
                }
            }
        }
    }
}
