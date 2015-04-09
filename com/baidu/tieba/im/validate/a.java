package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestAddGroupUserMessage;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.ValidateModel;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ValidateActivity bnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.bnW = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        p pVar;
        ValidateItemData validateItemData;
        com.baidu.tieba.im.g gVar;
        int i;
        int i2;
        p pVar2;
        ValidateItemData validateItemData2;
        ValidateItemData gZ;
        com.baidu.tieba.im.g gVar2;
        p pVar3;
        ValidateItemData gZ2;
        com.baidu.tieba.im.g gVar3;
        p pVar4;
        pVar = this.bnW.bnQ;
        pVar.setLoadProgressBarVisable(false);
        this.bnW.bnT = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.bnW.showToast(y.validate_fail);
                        } else {
                            this.bnW.showToast(errorString);
                        }
                        gZ2 = this.bnW.gZ(requestAddGroupUserMessage.getNotice_id());
                        if (gZ2 != null) {
                            gZ2.setPass(false);
                            gZ2.setShown(true);
                            gVar3 = this.bnW.bnR;
                            ValidateModel.updateValidateData(gVar3, gZ2);
                            pVar4 = this.bnW.bnQ;
                            pVar4.TR().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                gZ = this.bnW.gZ(requestAddGroupUserMessage.getNotice_id());
                if (gZ != null) {
                    gZ.setPass(true);
                    gZ.setShown(true);
                    gVar2 = this.bnW.bnR;
                    ValidateModel.updateValidateData(gVar2, gZ);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.bnW.showToast(y.validate_succ);
                    } else {
                        this.bnW.showToast(socketResponsedMessage.getErrorString());
                    }
                    pVar3 = this.bnW.bnQ;
                    pVar3.TR().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.bnW.bnS;
                    gVar = this.bnW.bnR;
                    ValidateModel.deleteValidateData(validateItemData, gVar);
                    ValidateActivity validateActivity = this.bnW;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.bnW;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    pVar2 = this.bnW.bnQ;
                    h TR = pVar2.TR();
                    List<ValidateItemData> datas = TR.getDatas();
                    validateItemData2 = this.bnW.bnS;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (TR.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(TR.getDatas().get(0).getUserName()) + TbadkApplication.getInst().getApp().getApplicationContext().getString(y.validate_im_apply_prefix1) + TR.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(TR.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    TR.notifyDataSetChanged();
                    if (TR != null && TR.getDatas() != null && TR.getDatas().size() == 0) {
                        this.bnW.finish();
                    }
                }
            }
        }
    }
}
