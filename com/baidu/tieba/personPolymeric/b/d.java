package com.baidu.tieba.personPolymeric.b;

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
public class d implements a.b {
    final /* synthetic */ a eDg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.eDg = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            tbPageContext2 = this.eDg.FY;
            tbPageContext2.showToast(r.l.frs_header_games_unavailable);
            return;
        }
        TiebaStatic.log("c10038");
        aVar.dismiss();
        tbPageContext = this.eDg.FY;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), 2, true, 5);
        if (!StringUtils.isNULL("4010001002")) {
            memberPayActivityConfig.setSceneId("4010001002");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
