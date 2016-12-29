package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.f<Void> {
    private final /* synthetic */ CustomMessage cHG;
    final /* synthetic */ m cZg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.cZg = mVar;
        this.cHG = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cHG.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cHG.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cHG.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
