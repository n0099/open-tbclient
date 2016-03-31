package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.data.MemberCloseAdHttpResponseMessage;
import com.baidu.tbadk.data.MemberCloseAdSocketResponseMessage;
/* loaded from: classes.dex */
class u extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(MoreActivity moreActivity, int i, int i2) {
        super(i, i2);
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null || responsedMessage.getError() != 0) {
            if (responsedMessage.getError() == 1990043) {
                this.this$0.aOe();
            } else if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                this.this$0.showToast(responsedMessage.getErrorString());
            } else {
                this.this$0.aOf();
                return;
            }
            this.this$0.io(false);
        } else if ((responsedMessage instanceof MemberCloseAdHttpResponseMessage) || (responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
            com.baidu.tbadk.data.b bVar = null;
            if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                bVar = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
            } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                bVar = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
            }
            if (bVar != null) {
                this.this$0.oT(bVar.CC());
                return;
            }
            this.this$0.aOf();
        } else {
            this.this$0.aOf();
        }
    }
}
