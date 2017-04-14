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
    final /* synthetic */ ed enY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.enY = edVar;
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
        tbPageContext = this.enY.aaX;
        if (com.baidu.tbadk.core.util.bg.aK(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hA()) {
            if (view == this.enY.enJ) {
                arVar10 = this.enY.enV;
                if (arVar10 != null) {
                    arVar11 = this.enY.enV;
                    if (!TextUtils.isEmpty(arVar11.Xd)) {
                        com.baidu.tbadk.core.util.bb wn = com.baidu.tbadk.core.util.bb.wn();
                        tbPageContext4 = this.enY.aaX;
                        arVar12 = this.enY.enV;
                        wn.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext4.getPageActivity()), new String[]{arVar12.Xd});
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11410");
                        arVar13 = this.enY.enV;
                        TiebaStatic.log(asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, arVar13.Xd));
                    }
                }
            } else if (view == this.enY.enO) {
                StringBuilder sb = new StringBuilder("link: ");
                arVar5 = this.enY.enW;
                BdLog.e(sb.append(arVar5.Xd).toString());
                arVar6 = this.enY.enW;
                if (arVar6 != null) {
                    arVar7 = this.enY.enW;
                    if (!TextUtils.isEmpty(arVar7.Xd)) {
                        com.baidu.tbadk.core.util.bb wn2 = com.baidu.tbadk.core.util.bb.wn();
                        tbPageContext3 = this.enY.aaX;
                        arVar8 = this.enY.enW;
                        wn2.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext3.getPageActivity()), new String[]{arVar8.Xd});
                        com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11409");
                        arVar9 = this.enY.enW;
                        TiebaStatic.log(asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, arVar9.Xd));
                    }
                }
            } else if (view == this.enY.enR) {
                arVar = this.enY.enX;
                if (arVar != null) {
                    arVar2 = this.enY.enX;
                    if (!TextUtils.isEmpty(arVar2.Xd)) {
                        com.baidu.tbadk.core.util.bb wn3 = com.baidu.tbadk.core.util.bb.wn();
                        tbPageContext2 = this.enY.aaX;
                        arVar3 = this.enY.enX;
                        wn3.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{arVar3.Xd});
                        com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c11408");
                        arVar4 = this.enY.enX;
                        TiebaStatic.log(asVar3.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, arVar4.Xd));
                    }
                }
            }
        }
    }
}
