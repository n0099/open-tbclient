package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.f<Void> {
    private final /* synthetic */ CustomMessage cRe;
    final /* synthetic */ m diN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.diN = mVar;
        this.cRe = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cRe.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cRe.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cRe.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
