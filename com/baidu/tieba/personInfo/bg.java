package com.baidu.tieba.personInfo;

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
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            hVar2 = this.this$0.dPa;
            ((TbPageContext) hVar2).showToast(u.j.frs_header_games_unavailable);
            return;
        }
        TiebaStatic.log("c10038");
        aVar.dismiss();
        hVar = this.this$0.dPa;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) hVar.getPageActivity(), 2, true, 5);
        if (!StringUtils.isNULL("4010001002")) {
            memberPayActivityConfig.setSceneId("4010001002");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
