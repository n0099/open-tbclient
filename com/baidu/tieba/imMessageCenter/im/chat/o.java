package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.f<Void> {
    private final /* synthetic */ CustomMessage dcK;
    final /* synthetic */ m dul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.dul = mVar;
        this.dcK = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.dcK.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.dcK.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.dcK.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
