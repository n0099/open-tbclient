package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ z bIB;
    private final /* synthetic */ CustomMessage bpS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.bIB = zVar;
        this.bpS = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.bpS.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.bpS.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.bpS.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
