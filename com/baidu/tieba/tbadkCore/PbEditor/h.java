package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.tbadkCore.bubble.x {
    final /* synthetic */ b bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.bTq = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.x
    public void hE(int i) {
        com.baidu.tieba.tbadkCore.bubble.h hVar;
        Context context;
        hVar = this.bTq.bTf;
        hVar.hM(i);
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bTq.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(context, true, 23004, "pop_unable")));
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.x
    public void aeM() {
    }
}
