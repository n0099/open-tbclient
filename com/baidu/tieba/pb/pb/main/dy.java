package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy implements View.OnClickListener {
    final /* synthetic */ dx edW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dx dxVar) {
        this.edW = dxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ap apVar;
        com.baidu.tbadk.core.data.ap apVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.ap apVar3;
        com.baidu.tbadk.core.data.ap apVar4;
        com.baidu.tbadk.core.data.ap apVar5;
        com.baidu.tbadk.core.data.ap apVar6;
        com.baidu.tbadk.core.data.ap apVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.ap apVar8;
        com.baidu.tbadk.core.data.ap apVar9;
        com.baidu.tbadk.core.data.ap apVar10;
        com.baidu.tbadk.core.data.ap apVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.ap apVar12;
        com.baidu.tbadk.core.data.ap apVar13;
        tbPageContext = this.edW.Gf;
        if (com.baidu.tbadk.core.util.bh.ai(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            if (view == this.edW.edH) {
                apVar10 = this.edW.edT;
                if (apVar10 != null) {
                    apVar11 = this.edW.edT;
                    if (!TextUtils.isEmpty(apVar11.Sr)) {
                        com.baidu.tbadk.core.util.bc vz = com.baidu.tbadk.core.util.bc.vz();
                        tbPageContext4 = this.edW.Gf;
                        apVar12 = this.edW.edT;
                        vz.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext4.getPageActivity()), new String[]{apVar12.Sr});
                        com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c11410");
                        apVar13 = this.edW.edT;
                        TiebaStatic.log(atVar.ab("obj_source", apVar13.Sr));
                    }
                }
            } else if (view == this.edW.edM) {
                StringBuilder sb = new StringBuilder("link: ");
                apVar5 = this.edW.edU;
                BdLog.e(sb.append(apVar5.Sr).toString());
                apVar6 = this.edW.edU;
                if (apVar6 != null) {
                    apVar7 = this.edW.edU;
                    if (!TextUtils.isEmpty(apVar7.Sr)) {
                        com.baidu.tbadk.core.util.bc vz2 = com.baidu.tbadk.core.util.bc.vz();
                        tbPageContext3 = this.edW.Gf;
                        apVar8 = this.edW.edU;
                        vz2.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext3.getPageActivity()), new String[]{apVar8.Sr});
                        com.baidu.tbadk.core.util.at atVar2 = new com.baidu.tbadk.core.util.at("c11409");
                        apVar9 = this.edW.edU;
                        TiebaStatic.log(atVar2.ab("obj_source", apVar9.Sr));
                    }
                }
            } else if (view == this.edW.edP) {
                apVar = this.edW.edV;
                if (apVar != null) {
                    apVar2 = this.edW.edV;
                    if (!TextUtils.isEmpty(apVar2.Sr)) {
                        com.baidu.tbadk.core.util.bc vz3 = com.baidu.tbadk.core.util.bc.vz();
                        tbPageContext2 = this.edW.Gf;
                        apVar3 = this.edW.edV;
                        vz3.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{apVar3.Sr});
                        com.baidu.tbadk.core.util.at atVar3 = new com.baidu.tbadk.core.util.at("c11408");
                        apVar4 = this.edW.edV;
                        TiebaStatic.log(atVar3.ab("obj_source", apVar4.Sr));
                    }
                }
            }
        }
    }
}
