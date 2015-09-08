package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ z bJi;
    private final /* synthetic */ CustomMessage bqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.bJi = zVar;
        this.bqq = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.bqq.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.bqq.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.bqq.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
