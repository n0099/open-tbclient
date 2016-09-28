package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cWY;
    final /* synthetic */ m doD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.doD = mVar;
        this.cWY = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cWY.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cWY.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cWY.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
