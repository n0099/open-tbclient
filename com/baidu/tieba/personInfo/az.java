package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(f fVar, int i, int i2) {
        super(i, i2);
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        if (responsedMessage != null && responsedMessage.getError() == 0) {
            z = this.this$0.bIW;
            if (z) {
                this.this$0.dFD = true;
            }
        }
    }
}
