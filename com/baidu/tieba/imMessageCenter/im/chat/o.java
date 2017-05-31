package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes2.dex */
class o implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cRs;
    final /* synthetic */ m dja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.dja = mVar;
        this.cRs = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: c */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cRs.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cRs.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cRs.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
