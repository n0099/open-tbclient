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
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ValidateActivity biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.biR = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        r rVar;
        ValidateItemData validateItemData;
        com.baidu.tieba.im.a aVar;
        int i;
        int i2;
        r rVar2;
        ValidateItemData validateItemData2;
        ValidateItemData gI;
        com.baidu.tieba.im.a aVar2;
        r rVar3;
        ValidateItemData gI2;
        com.baidu.tieba.im.a aVar3;
        r rVar4;
        rVar = this.biR.biL;
        rVar.dg(false);
        this.biR.biO = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.biR.showToast(y.validate_fail);
                        } else {
                            this.biR.showToast(errorString);
                        }
                        gI2 = this.biR.gI(requestAddGroupUserMessage.getNotice_id());
                        if (gI2 != null) {
                            gI2.setPass(false);
                            gI2.setShown(true);
                            aVar3 = this.biR.biM;
                            l.a(aVar3, gI2);
                            rVar4 = this.biR.biL;
                            rVar4.RS().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                gI = this.biR.gI(requestAddGroupUserMessage.getNotice_id());
                if (gI != null) {
                    gI.setPass(true);
                    gI.setShown(true);
                    aVar2 = this.biR.biM;
                    l.a(aVar2, gI);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.biR.showToast(y.validate_succ);
                    } else {
                        this.biR.showToast(socketResponsedMessage.getErrorString());
                    }
                    rVar3 = this.biR.biL;
                    rVar3.RS().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.biR.biN;
                    aVar = this.biR.biM;
                    l.a(validateItemData, aVar);
                    ValidateActivity validateActivity = this.biR;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.biR;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    rVar2 = this.biR.biL;
                    g RS = rVar2.RS();
                    List<ValidateItemData> datas = RS.getDatas();
                    validateItemData2 = this.biR.biN;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (RS.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(RS.getDatas().get(0).getUserName()) + TbadkApplication.m251getInst().getApp().getApplicationContext().getString(y.validate_im_apply_prefix1) + RS.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(RS.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    RS.notifyDataSetChanged();
                    if (RS != null && RS.getDatas() != null && RS.getDatas().size() == 0) {
                        this.biR.finish();
                    }
                }
            }
        }
    }
}
