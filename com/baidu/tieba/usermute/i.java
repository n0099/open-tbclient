package com.baidu.tieba.usermute;

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
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel eED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.eED = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        if (Build.VERSION.SDK_INT < 11) {
            aVar.dismiss();
            hVar2 = this.eED.eEv;
            ((TbPageContext) hVar2).showToast(t.j.frs_header_games_unavailable);
            return;
        }
        int i = -1;
        String str = "";
        from = this.eED.eEw;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.eED.eEw;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10038");
                i = 5;
                str = "4010001002";
            }
        } else {
            TiebaStatic.log("c10025");
            i = 4;
            str = "4010001001";
        }
        aVar.dismiss();
        hVar = this.eED.eEv;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) hVar.getPageActivity(), 2, true, i);
        if (!StringUtils.isNULL(str)) {
            memberPayActivityConfig.setSceneId(str);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
