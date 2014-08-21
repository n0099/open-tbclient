package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;
    private final /* synthetic */ int d;
    private final /* synthetic */ cw e;
    private final /* synthetic */ ShareFromPBMsgData f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity, int i, String str, int i2, cw cwVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.a = pbActivity;
        this.b = i;
        this.c = str;
        this.d = i2;
        this.e = cwVar;
        this.f = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.y(this.a, this.b, this.c, this.d, "from_share", this.e.getLeaveMsg(), this.f.toChatMessageContent())));
        aVar.d();
    }
}
