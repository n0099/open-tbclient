package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage bbX;
    final /* synthetic */ m brY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.brY = mVar;
        this.bbX = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.bbX.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.bbX.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.bbX.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.bbX.getData()).startActivity();
        }
    }
}
