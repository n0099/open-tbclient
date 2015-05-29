package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage bbW;
    final /* synthetic */ m brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.brX = mVar;
        this.bbW = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.bbW.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.bbW.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.bbW.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.bbW.getData()).startActivity();
        }
    }
}
