package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cHh;
    final /* synthetic */ m cYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.cYA = mVar;
        this.cHh = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cHh.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cHh.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cHh.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
