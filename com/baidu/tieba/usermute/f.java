package com.baidu.tieba.usermute;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.dIS = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            hVar2 = this.dIS.dIK;
            ((TbPageContext) hVar2).showToast(n.i.frs_header_games_unavailable);
            return;
        }
        int i = -1;
        from = this.dIS.dIL;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.dIS.dIL;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10038");
                i = 5;
            }
        } else {
            TiebaStatic.log("c10025");
            i = 4;
        }
        aVar.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        hVar = this.dIS.dIK;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) hVar.getPageActivity(), 2, true, i)));
    }
}
