package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbChosenActivity bGl;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.j bGm;
    private final /* synthetic */ long btx;
    private final /* synthetic */ String bty;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.j jVar, long j, String str, String str2) {
        this.bGl = pbChosenActivity;
        this.bGm = jVar;
        this.btx = j;
        this.val$name = str;
        this.bty = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        String str;
        aVar2 = this.bGl.chosenData;
        if (aVar2 != null) {
            aVar3 = this.bGl.chosenData;
            if (aVar3.getForumInfo() != null) {
                this.bGl.HidenSoftKeyPad((InputMethodManager) this.bGl.getSystemService("input_method"), this.bGm.getChatMsgView());
                Activity pageActivity = this.bGl.getPageContext().getPageActivity();
                long j = this.btx;
                String str2 = this.val$name;
                String str3 = this.bty;
                String leaveMsg = this.bGm.getLeaveMsg();
                aVar4 = this.bGl.chosenData;
                aVar5 = this.bGl.chosenData;
                long longValue = aVar5.getForumInfo().ftid.longValue();
                str = this.bGl.shareUrl;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str2, str3, 0, leaveMsg, n.a(aVar4, longValue, str).toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }
}
