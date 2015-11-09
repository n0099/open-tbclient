package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ m bKe;
    private final /* synthetic */ CustomMessage buc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bKe = mVar;
        this.buc = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.buc.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.buc.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.buc.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
