package com.baidu.tieba.pb.chosen;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbChosenActivity bGl;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.j bGm;
    private final /* synthetic */ String bGn;
    private final /* synthetic */ int bGo;
    private final /* synthetic */ int blE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.j jVar, int i, String str, int i2) {
        this.bGl = pbChosenActivity;
        this.bGm = jVar;
        this.blE = i;
        this.bGn = str;
        this.bGo = i2;
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
                String leaveMsg = this.bGm.getLeaveMsg();
                aVar4 = this.bGl.chosenData;
                aVar5 = this.bGl.chosenData;
                long longValue = aVar5.getForumInfo().ftid.longValue();
                str = this.bGl.shareUrl;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bGl.getPageContext().getPageActivity(), this.blE, this.bGn, this.bGo, "from_share", leaveMsg, n.a(aVar4, longValue, str).toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }
}
