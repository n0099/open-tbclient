package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.f<Void> {
    private final /* synthetic */ CustomMessage cON;
    final /* synthetic */ m dgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.dgv = mVar;
        this.cON = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cON.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cON.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cON.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
