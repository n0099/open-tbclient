package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ m bJJ;
    private final /* synthetic */ CustomMessage btC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bJJ = mVar;
        this.btC = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.btC.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.btC.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.btC.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
