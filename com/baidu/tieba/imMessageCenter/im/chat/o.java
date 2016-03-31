package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cbg;
    final /* synthetic */ m csn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.csn = mVar;
        this.cbg = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.cbg.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.cbg.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.cbg.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
