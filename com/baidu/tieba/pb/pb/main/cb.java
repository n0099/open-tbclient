package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements a.b {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            gVar2 = this.eiV.eik;
            ((TbPageContext) gVar2).showToast(r.l.frs_header_games_unavailable);
            return;
        }
        TiebaStatic.log("c10025");
        aVar.dismiss();
        gVar = this.eiV.eik;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) gVar.getPageActivity(), 2, true, 4);
        if (!StringUtils.isNULL("4010001001")) {
            memberPayActivityConfig.setSceneId("4010001001");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
