package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.groupInfo.RequestAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        t tVar;
        ValidateItemData validateItemData;
        com.baidu.tieba.im.a aVar;
        int i;
        int i2;
        t tVar2;
        ValidateItemData validateItemData2;
        ValidateItemData a;
        com.baidu.tieba.im.a aVar2;
        t tVar3;
        ValidateItemData a2;
        com.baidu.tieba.im.a aVar3;
        t tVar4;
        tVar = this.a.b;
        tVar.a(false);
        this.a.i = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.a.showToast(y.validate_fail);
                        } else {
                            this.a.showToast(errorString);
                        }
                        a2 = this.a.a(requestAddGroupUserMessage.getNotice_id());
                        if (a2 != null) {
                            a2.setPass(false);
                            a2.setShown(true);
                            aVar3 = this.a.d;
                            n.a(aVar3, a2);
                            tVar4 = this.a.b;
                            tVar4.d().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                a = this.a.a(requestAddGroupUserMessage.getNotice_id());
                if (a != null) {
                    a.setPass(true);
                    a.setShown(true);
                    aVar2 = this.a.d;
                    n.a(aVar2, a);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.a.showToast(y.validate_succ);
                    } else {
                        this.a.showToast(socketResponsedMessage.getErrorString());
                    }
                    tVar3 = this.a.b;
                    tVar3.d().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.a.f;
                    aVar = this.a.d;
                    n.a(validateItemData, aVar);
                    ValidateActivity validateActivity = this.a;
                    i = validateActivity.l;
                    validateActivity.l = i - 1;
                    ValidateActivity validateActivity2 = this.a;
                    i2 = validateActivity2.j;
                    validateActivity2.j = i2 - 1;
                    tVar2 = this.a.b;
                    h d = tVar2.d();
                    List<ValidateItemData> b = d.b();
                    validateItemData2 = this.a.f;
                    b.remove(validateItemData2);
                    d.notifyDataSetChanged();
                    com.baidu.tieba.im.pushNotify.a.b((com.baidu.tieba.im.a<Void>) null);
                }
            }
        }
    }
}
