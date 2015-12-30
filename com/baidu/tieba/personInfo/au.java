package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(d dVar, int i, int i2) {
        super(i, i2);
        this.cWV = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        if (responsedMessage != null && responsedMessage.getError() == 0) {
            z = this.cWV.mIsHost;
            if (z) {
                this.cWV.cWl = true;
            }
        }
    }
}
