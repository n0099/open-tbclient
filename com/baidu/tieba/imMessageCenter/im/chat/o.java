package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ m bJy;
    private final /* synthetic */ CustomMessage btr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bJy = mVar;
        this.btr = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.btr.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.btr.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.btr.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
