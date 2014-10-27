package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ UpdateGroupActivity biz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(UpdateGroupActivity updateGroupActivity, int i) {
        super(i);
        this.biz = updateGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        a aVar;
        a aVar2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
            aVar = this.biz.bix;
            aVar.setIsLoading(false);
            if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                this.biz.showToast(y.group_update_fail);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
            if (responseUpdateGroupMessage.getError() != 0) {
                this.biz.t(responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                return;
            }
            this.biz.showToast(y.group_update_success);
            Intent intent = this.biz.getIntent();
            aVar2 = this.biz.bix;
            intent.putExtra("group_text", aVar2.getText());
            this.biz.setResult(-1, intent);
            this.biz.finish();
        }
    }
}
