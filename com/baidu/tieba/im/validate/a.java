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
    final /* synthetic */ ValidateActivity bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.bjf = validateActivity;
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
        rVar = this.bjf.biZ;
        rVar.dg(false);
        this.bjf.bjc = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.bjf.showToast(y.validate_fail);
                        } else {
                            this.bjf.showToast(errorString);
                        }
                        gI2 = this.bjf.gI(requestAddGroupUserMessage.getNotice_id());
                        if (gI2 != null) {
                            gI2.setPass(false);
                            gI2.setShown(true);
                            aVar3 = this.bjf.bja;
                            l.a(aVar3, gI2);
                            rVar4 = this.bjf.biZ;
                            rVar4.RV().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                gI = this.bjf.gI(requestAddGroupUserMessage.getNotice_id());
                if (gI != null) {
                    gI.setPass(true);
                    gI.setShown(true);
                    aVar2 = this.bjf.bja;
                    l.a(aVar2, gI);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.bjf.showToast(y.validate_succ);
                    } else {
                        this.bjf.showToast(socketResponsedMessage.getErrorString());
                    }
                    rVar3 = this.bjf.biZ;
                    rVar3.RV().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.bjf.bjb;
                    aVar = this.bjf.bja;
                    l.a(validateItemData, aVar);
                    ValidateActivity validateActivity = this.bjf;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.bjf;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    rVar2 = this.bjf.biZ;
                    g RV = rVar2.RV();
                    List<ValidateItemData> datas = RV.getDatas();
                    validateItemData2 = this.bjf.bjb;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (RV.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(RV.getDatas().get(0).getUserName()) + TbadkApplication.m251getInst().getApp().getApplicationContext().getString(y.validate_im_apply_prefix1) + RV.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(RV.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    RV.notifyDataSetChanged();
                    if (RV != null && RV.getDatas() != null && RV.getDatas().size() == 0) {
                        this.bjf.finish();
                    }
                }
            }
        }
    }
}
