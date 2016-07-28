package com.baidu.tieba.pb.pb.sub;

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
public class x implements a.b {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            hVar2 = this.ejr.ebn;
            ((TbPageContext) hVar2).showToast(u.j.frs_header_games_unavailable);
            return;
        }
        TiebaStatic.log("c10025");
        aVar.dismiss();
        hVar = this.ejr.ebn;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) hVar.getPageActivity(), 2, true, 4);
        if (!StringUtils.isNULL("4010001001")) {
            memberPayActivityConfig.setSceneId("4010001001");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
