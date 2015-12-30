package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.imMessageCenter.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.d<Void> {
    private final /* synthetic */ CustomMessage bMP;
    final /* synthetic */ z cfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.cfX = zVar;
        this.bMP = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.bMP.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.bMP.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.bMP.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
