package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.imMessageCenter.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ z bMT;
    private final /* synthetic */ CustomMessage buc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.bMT = zVar;
        this.buc = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.buc.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.buc.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.buc.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
