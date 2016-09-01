package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements View.OnClickListener {
    final /* synthetic */ ed ern;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.ern = edVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.am amVar;
        com.baidu.tbadk.core.data.am amVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.am amVar3;
        com.baidu.tbadk.core.data.am amVar4;
        com.baidu.tbadk.core.data.am amVar5;
        com.baidu.tbadk.core.data.am amVar6;
        com.baidu.tbadk.core.data.am amVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.am amVar8;
        com.baidu.tbadk.core.data.am amVar9;
        com.baidu.tbadk.core.data.am amVar10;
        com.baidu.tbadk.core.data.am amVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.am amVar12;
        com.baidu.tbadk.core.data.am amVar13;
        tbPageContext = this.ern.Gd;
        if (com.baidu.tbadk.core.util.bn.al(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            if (view == this.ern.eqY) {
                amVar10 = this.ern.erk;
                if (amVar10 != null) {
                    amVar11 = this.ern.erk;
                    if (!TextUtils.isEmpty(amVar11.RV)) {
                        com.baidu.tbadk.core.util.bi vx = com.baidu.tbadk.core.util.bi.vx();
                        tbPageContext4 = this.ern.Gd;
                        amVar12 = this.ern.erk;
                        vx.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext4.getPageActivity()), new String[]{amVar12.RV});
                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11410");
                        amVar13 = this.ern.erk;
                        TiebaStatic.log(ayVar.ab("obj_source", amVar13.RV));
                    }
                }
            } else if (view == this.ern.erd) {
                StringBuilder sb = new StringBuilder("link: ");
                amVar5 = this.ern.erl;
                BdLog.e(sb.append(amVar5.RV).toString());
                amVar6 = this.ern.erl;
                if (amVar6 != null) {
                    amVar7 = this.ern.erl;
                    if (!TextUtils.isEmpty(amVar7.RV)) {
                        com.baidu.tbadk.core.util.bi vx2 = com.baidu.tbadk.core.util.bi.vx();
                        tbPageContext3 = this.ern.Gd;
                        amVar8 = this.ern.erl;
                        vx2.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext3.getPageActivity()), new String[]{amVar8.RV});
                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11409");
                        amVar9 = this.ern.erl;
                        TiebaStatic.log(ayVar2.ab("obj_source", amVar9.RV));
                    }
                }
            } else if (view == this.ern.erg) {
                amVar = this.ern.erm;
                if (amVar != null) {
                    amVar2 = this.ern.erm;
                    if (!TextUtils.isEmpty(amVar2.RV)) {
                        com.baidu.tbadk.core.util.bi vx3 = com.baidu.tbadk.core.util.bi.vx();
                        tbPageContext2 = this.ern.Gd;
                        amVar3 = this.ern.erm;
                        vx3.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{amVar3.RV});
                        com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c11408");
                        amVar4 = this.ern.erm;
                        TiebaStatic.log(ayVar3.ab("obj_source", amVar4.RV));
                    }
                }
            }
        }
    }
}
