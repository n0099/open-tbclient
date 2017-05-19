package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes2.dex */
class o implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cLU;
    final /* synthetic */ m ddF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.ddF = mVar;
        this.cLU = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: c */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cLU.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cLU.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cLU.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
