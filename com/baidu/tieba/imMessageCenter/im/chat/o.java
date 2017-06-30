package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes2.dex */
class o implements com.baidu.tbadk.util.h<Void> {
    private final /* synthetic */ CustomMessage cZo;
    final /* synthetic */ m dqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.dqW = mVar;
        this.cZo = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    /* renamed from: c */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cZo.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cZo.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cZo.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
