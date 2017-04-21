package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.f<Void> {
    private final /* synthetic */ CustomMessage cRS;
    final /* synthetic */ m djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.djD = mVar;
        this.cRS = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: c */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cRS.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cRS.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cRS.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
