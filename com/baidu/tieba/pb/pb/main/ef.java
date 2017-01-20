package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ef implements View.OnClickListener {
    final /* synthetic */ ee emQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar) {
        this.emQ = eeVar;
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
        tbPageContext = this.emQ.Fp;
        if (com.baidu.tbadk.core.util.bf.ak(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gB()) {
            if (view == this.emQ.emB) {
                aqVar10 = this.emQ.emN;
                if (aqVar10 != null) {
                    aqVar11 = this.emQ.emN;
                    if (!TextUtils.isEmpty(aqVar11.RA)) {
                        com.baidu.tbadk.core.util.ba vt = com.baidu.tbadk.core.util.ba.vt();
                        tbPageContext4 = this.emQ.Fp;
                        aqVar12 = this.emQ.emN;
                        vt.c((TbPageContext) com.baidu.adp.base.k.C(tbPageContext4.getPageActivity()), new String[]{aqVar12.RA});
                        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11410");
                        aqVar13 = this.emQ.emN;
                        TiebaStatic.log(arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aqVar13.RA));
                    }
                }
            } else if (view == this.emQ.emG) {
                StringBuilder sb = new StringBuilder("link: ");
                aqVar5 = this.emQ.emO;
                BdLog.e(sb.append(aqVar5.RA).toString());
                aqVar6 = this.emQ.emO;
                if (aqVar6 != null) {
                    aqVar7 = this.emQ.emO;
                    if (!TextUtils.isEmpty(aqVar7.RA)) {
                        com.baidu.tbadk.core.util.ba vt2 = com.baidu.tbadk.core.util.ba.vt();
                        tbPageContext3 = this.emQ.Fp;
                        aqVar8 = this.emQ.emO;
                        vt2.c((TbPageContext) com.baidu.adp.base.k.C(tbPageContext3.getPageActivity()), new String[]{aqVar8.RA});
                        com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c11409");
                        aqVar9 = this.emQ.emO;
                        TiebaStatic.log(arVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aqVar9.RA));
                    }
                }
            } else if (view == this.emQ.emJ) {
                aqVar = this.emQ.emP;
                if (aqVar != null) {
                    aqVar2 = this.emQ.emP;
                    if (!TextUtils.isEmpty(aqVar2.RA)) {
                        com.baidu.tbadk.core.util.ba vt3 = com.baidu.tbadk.core.util.ba.vt();
                        tbPageContext2 = this.emQ.Fp;
                        aqVar3 = this.emQ.emP;
                        vt3.c((TbPageContext) com.baidu.adp.base.k.C(tbPageContext2.getPageActivity()), new String[]{aqVar3.RA});
                        com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c11408");
                        aqVar4 = this.emQ.emP;
                        TiebaStatic.log(arVar3.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aqVar4.RA));
                    }
                }
            }
        }
    }
}
