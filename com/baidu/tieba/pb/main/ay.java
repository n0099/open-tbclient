package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
class ay extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(PbActivity pbActivity, int i, int i2) {
        super(i, i2);
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void a(ResponsedMessage<?> responsedMessage) {
        bl blVar;
        bl blVar2;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
            if (responsedMessage.hasError()) {
                this.a.showToast(responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.a.finish();
                }
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                blVar2 = this.a.x;
                blVar2.a((pbPageSocketResponseMessage) responsedMessage);
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                blVar = this.a.x;
                blVar.a((pbPageHttpResponseMessage) responsedMessage);
            }
        }
    }
}
