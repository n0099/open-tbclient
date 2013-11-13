package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateGroupActivity f1797a;

    public d(UpdateGroupActivity updateGroupActivity) {
        this.f1797a = updateGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        a aVar;
        a aVar2;
        if (message != null && message.getCmd() == 103102) {
            aVar = this.f1797a.c;
            aVar.a(false);
            if (!(message instanceof ResponseUpdateGroupMessage)) {
                this.f1797a.showToast(R.string.group_update_fail);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) message;
            if (responseUpdateGroupMessage.hasError()) {
                this.f1797a.a(responseUpdateGroupMessage.getErrMsg(), responseUpdateGroupMessage.getErrNo());
                return;
            }
            this.f1797a.showToast(R.string.group_update_success);
            Intent intent = this.f1797a.getIntent();
            aVar2 = this.f1797a.c;
            intent.putExtra("group_text", aVar2.l());
            this.f1797a.setResult(-1, intent);
            this.f1797a.finish();
        }
    }
}
