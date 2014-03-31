package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
/* loaded from: classes.dex */
final class d extends com.baidu.adp.framework.c.g {
    final /* synthetic */ UpdateGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(UpdateGroupActivity updateGroupActivity, int i) {
        super(103102);
        this.a = updateGroupActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        a aVar;
        a aVar2;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || socketResponsedMessage2.g() != 103102) {
            return;
        }
        aVar = this.a.c;
        aVar.a(false);
        if (!(socketResponsedMessage2 instanceof ResponseUpdateGroupMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.group_update_fail);
            return;
        }
        ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage2;
        if (responseUpdateGroupMessage.e() != 0) {
            UpdateGroupActivity.a(this.a, responseUpdateGroupMessage.f(), responseUpdateGroupMessage.e());
            return;
        }
        this.a.showToast(com.baidu.tieba.im.j.group_update_success);
        Intent intent = this.a.getIntent();
        aVar2 = this.a.c;
        intent.putExtra("group_text", aVar2.k());
        this.a.setResult(-1, intent);
        this.a.finish();
    }
}
