package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.RequestAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.d {
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
        r rVar;
        ValidateItemData validateItemData;
        com.baidu.tieba.im.a aVar;
        int i;
        int i2;
        r rVar2;
        ValidateItemData validateItemData2;
        ValidateItemData a;
        com.baidu.tieba.im.a aVar2;
        r rVar3;
        ValidateItemData a2;
        com.baidu.tieba.im.a aVar3;
        r rVar4;
        rVar = this.a.b;
        rVar.a(false);
        this.a.g = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.a.showToast(x.validate_fail);
                        } else {
                            this.a.showToast(errorString);
                        }
                        a2 = this.a.a(requestAddGroupUserMessage.getNotice_id());
                        if (a2 != null) {
                            a2.setPass(false);
                            a2.setShown(true);
                            aVar3 = this.a.d;
                            l.a(aVar3, a2);
                            rVar4 = this.a.b;
                            rVar4.c().notifyDataSetChanged();
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
                    l.a(aVar2, a);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.a.showToast(x.validate_succ);
                    } else {
                        this.a.showToast(socketResponsedMessage.getErrorString());
                    }
                    rVar3 = this.a.b;
                    rVar3.c().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.a.f;
                    aVar = this.a.d;
                    l.a(validateItemData, aVar);
                    ValidateActivity validateActivity = this.a;
                    i = validateActivity.j;
                    validateActivity.j = i - 1;
                    ValidateActivity validateActivity2 = this.a;
                    i2 = validateActivity2.h;
                    validateActivity2.h = i2 - 1;
                    rVar2 = this.a.b;
                    g c = rVar2.c();
                    List<ValidateItemData> b = c.b();
                    validateItemData2 = this.a.f;
                    b.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (c.b().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(c.b().get(0).getUserName()) + TbadkApplication.m252getInst().getApp().getApplicationContext().getString(x.validate_im_apply_prefix1) + c.b().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(c.b().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    c.notifyDataSetChanged();
                    if (c != null && c.b() != null && c.b().size() == 0) {
                        this.a.finish();
                    }
                }
            }
        }
    }
}
