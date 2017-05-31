package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ev implements View.OnClickListener {
    final /* synthetic */ eu ery;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(eu euVar) {
        this.ery = euVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.at atVar;
        com.baidu.tbadk.core.data.at atVar2;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.at atVar3;
        com.baidu.tbadk.core.data.at atVar4;
        com.baidu.tbadk.core.data.at atVar5;
        com.baidu.tbadk.core.data.at atVar6;
        com.baidu.tbadk.core.data.at atVar7;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.at atVar8;
        com.baidu.tbadk.core.data.at atVar9;
        com.baidu.tbadk.core.data.at atVar10;
        com.baidu.tbadk.core.data.at atVar11;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.at atVar12;
        com.baidu.tbadk.core.data.at atVar13;
        tbPageContext = this.ery.aas;
        if (com.baidu.tbadk.core.util.bh.aN(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hB()) {
            if (view == this.ery.erj) {
                atVar10 = this.ery.erv;
                if (atVar10 != null) {
                    atVar11 = this.ery.erv;
                    if (!TextUtils.isEmpty(atVar11.Wr)) {
                        com.baidu.tbadk.core.util.bb vy = com.baidu.tbadk.core.util.bb.vy();
                        tbPageContext4 = this.ery.aas;
                        atVar12 = this.ery.erv;
                        vy.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext4.getPageActivity()), new String[]{atVar12.Wr});
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11410");
                        atVar13 = this.ery.erv;
                        TiebaStatic.log(asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, atVar13.Wr));
                    }
                }
            } else if (view == this.ery.ero) {
                StringBuilder sb = new StringBuilder("link: ");
                atVar5 = this.ery.erw;
                BdLog.e(sb.append(atVar5.Wr).toString());
                atVar6 = this.ery.erw;
                if (atVar6 != null) {
                    atVar7 = this.ery.erw;
                    if (!TextUtils.isEmpty(atVar7.Wr)) {
                        com.baidu.tbadk.core.util.bb vy2 = com.baidu.tbadk.core.util.bb.vy();
                        tbPageContext3 = this.ery.aas;
                        atVar8 = this.ery.erw;
                        vy2.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext3.getPageActivity()), new String[]{atVar8.Wr});
                        com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11409");
                        atVar9 = this.ery.erw;
                        TiebaStatic.log(asVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, atVar9.Wr));
                    }
                }
            } else if (view == this.ery.err) {
                atVar = this.ery.erx;
                if (atVar != null) {
                    atVar2 = this.ery.erx;
                    if (!TextUtils.isEmpty(atVar2.Wr)) {
                        com.baidu.tbadk.core.util.bb vy3 = com.baidu.tbadk.core.util.bb.vy();
                        tbPageContext2 = this.ery.aas;
                        atVar3 = this.ery.erx;
                        vy3.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{atVar3.Wr});
                        com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c11408");
                        atVar4 = this.ery.erx;
                        TiebaStatic.log(asVar3.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, atVar4.Wr));
                    }
                }
            }
        }
    }
}
