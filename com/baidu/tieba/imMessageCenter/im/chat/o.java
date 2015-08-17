package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ m bFM;
    private final /* synthetic */ CustomMessage bpS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bFM = mVar;
        this.bpS = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.bpS.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.bpS.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.bpS.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
