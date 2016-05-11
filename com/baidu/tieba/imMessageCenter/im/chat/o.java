package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cbL;
    final /* synthetic */ m ctk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.ctk = mVar;
        this.cbL = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cbL.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cbL.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cbL.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
