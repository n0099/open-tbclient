package com.baidu.tieba.pb.chosen;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbChosenActivity bFY;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.j bFZ;
    private final /* synthetic */ String bGa;
    private final /* synthetic */ int bGb;
    private final /* synthetic */ int blo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.j jVar, int i, String str, int i2) {
        this.bFY = pbChosenActivity;
        this.bFZ = jVar;
        this.blo = i;
        this.bGa = str;
        this.bGb = i2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        String str;
        aVar2 = this.bFY.chosenData;
        if (aVar2 != null) {
            aVar3 = this.bFY.chosenData;
            if (aVar3.getForumInfo() != null) {
                this.bFY.HidenSoftKeyPad((InputMethodManager) this.bFY.getSystemService("input_method"), this.bFZ.getChatMsgView());
                String leaveMsg = this.bFZ.getLeaveMsg();
                aVar4 = this.bFY.chosenData;
                aVar5 = this.bFY.chosenData;
                long longValue = aVar5.getForumInfo().ftid.longValue();
                str = this.bFY.shareUrl;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bFY.getPageContext().getPageActivity(), this.blo, this.bGa, this.bGb, "from_share", leaveMsg, n.a(aVar4, longValue, str).toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }
}
