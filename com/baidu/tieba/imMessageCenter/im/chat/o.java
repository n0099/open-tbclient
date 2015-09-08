package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ m bGt;
    private final /* synthetic */ CustomMessage bqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bGt = mVar;
        this.bqq = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.bqq.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.bqq.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.bqq.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
