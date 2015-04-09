package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage aZp;
    final /* synthetic */ m bpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bpr = mVar;
        this.aZp = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.aZp.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.aZp.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.aZp.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.aZp.getData()).startActivity();
        }
    }
}
