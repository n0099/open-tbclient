package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.imMessageCenter.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.d<Void> {
    private final /* synthetic */ CustomMessage bQN;
    final /* synthetic */ z ckx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.ckx = zVar;
        this.bQN = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.bQN.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.bQN.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.bQN.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
