package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ cw e;
    private final /* synthetic */ ShareFromPBMsgData f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, long j, String str, String str2, cw cwVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.a = pbActivity;
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = cwVar;
        this.f = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bj(this.a, this.b, this.c, this.d, 0, this.e.getLeaveMsg(), this.f.toChatMessageContent())));
        aVar.c();
    }
}
