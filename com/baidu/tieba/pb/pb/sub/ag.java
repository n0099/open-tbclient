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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.b {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            hVar2 = this.eEs.eve;
            ((TbPageContext) hVar2).showToast(r.j.frs_header_games_unavailable);
            return;
        }
        TiebaStatic.log("c10025");
        aVar.dismiss();
        hVar = this.eEs.eve;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) hVar.getPageActivity(), 2, true, 4);
        if (!StringUtils.isNULL("4010001001")) {
            memberPayActivityConfig.setSceneId("4010001001");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
