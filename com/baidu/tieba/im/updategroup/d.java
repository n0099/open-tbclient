package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ UpdateGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(UpdateGroupActivity updateGroupActivity, int i) {
        super(i);
        this.a = updateGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        a aVar;
        a aVar2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
            aVar = this.a.c;
            aVar.a(false);
            if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                this.a.showToast(y.group_update_fail);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
            if (responseUpdateGroupMessage.getError() != 0) {
                this.a.a(responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                return;
            }
            this.a.showToast(y.group_update_success);
            Intent intent = this.a.getIntent();
            aVar2 = this.a.c;
            intent.putExtra("group_text", aVar2.k());
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
