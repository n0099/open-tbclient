package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.setting.model.MoreModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MoreActivity moreActivity, int i, int i2) {
        super(i, i2);
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        MoreModel moreModel;
        if (responsedMessage != null && responsedMessage.getError() == 0) {
            if ((responsedMessage instanceof GetUserInfoHttpResponseMessage) || (responsedMessage instanceof GetUserInfoSocketResponseMessage)) {
                com.baidu.tbadk.getUserInfo.a aVar = null;
                if (responsedMessage instanceof GetUserInfoHttpResponseMessage) {
                    aVar = ((GetUserInfoHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof GetUserInfoSocketResponseMessage) {
                    aVar = ((GetUserInfoSocketResponseMessage) responsedMessage).getData();
                }
                if (aVar != null && aVar.CD() != null) {
                    String portrait = aVar.CD().getPortrait();
                    this.this$0.duw.G(com.baidu.tbadk.core.util.r.dm(portrait), false);
                    moreModel = this.this$0.dux;
                    PersonChangeData personChangeData = moreModel.getPersonChangeData();
                    if (personChangeData != null) {
                        personChangeData.setPhotoChanged(true);
                        personChangeData.setPortrait(portrait);
                    }
                }
            }
        }
    }
}
