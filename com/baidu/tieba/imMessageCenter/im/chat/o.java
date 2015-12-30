package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.d<Void> {
    private final /* synthetic */ CustomMessage bMP;
    final /* synthetic */ m cdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.cdj = mVar;
        this.bMP = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.bMP.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.bMP.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.bMP.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
