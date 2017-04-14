package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.f<Void> {
    private final /* synthetic */ CustomMessage cPB;
    final /* synthetic */ m dhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.dhm = mVar;
        this.cPB = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: c */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cPB.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cPB.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cPB.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
