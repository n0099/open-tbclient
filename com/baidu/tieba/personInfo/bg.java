package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(h hVar, int i, int i2) {
        super(i, i2);
        this.this$0 = hVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        if (responsedMessage != null && responsedMessage.getError() == 0) {
            z = this.this$0.ciS;
            if (z) {
                this.this$0.eAx = true;
            }
        }
    }
}
