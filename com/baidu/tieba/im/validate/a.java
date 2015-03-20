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
    final /* synthetic */ ValidateActivity bnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.bnG = validateActivity;
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
        ValidateItemData gW;
        com.baidu.tieba.im.g gVar2;
        p pVar3;
        ValidateItemData gW2;
        com.baidu.tieba.im.g gVar3;
        p pVar4;
        pVar = this.bnG.bnA;
        pVar.setLoadProgressBarVisable(false);
        this.bnG.bnD = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.bnG.showToast(y.validate_fail);
                        } else {
                            this.bnG.showToast(errorString);
                        }
                        gW2 = this.bnG.gW(requestAddGroupUserMessage.getNotice_id());
                        if (gW2 != null) {
                            gW2.setPass(false);
                            gW2.setShown(true);
                            gVar3 = this.bnG.bnB;
                            ValidateModel.updateValidateData(gVar3, gW2);
                            pVar4 = this.bnG.bnA;
                            pVar4.TE().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                gW = this.bnG.gW(requestAddGroupUserMessage.getNotice_id());
                if (gW != null) {
                    gW.setPass(true);
                    gW.setShown(true);
                    gVar2 = this.bnG.bnB;
                    ValidateModel.updateValidateData(gVar2, gW);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.bnG.showToast(y.validate_succ);
                    } else {
                        this.bnG.showToast(socketResponsedMessage.getErrorString());
                    }
                    pVar3 = this.bnG.bnA;
                    pVar3.TE().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.bnG.bnC;
                    gVar = this.bnG.bnB;
                    ValidateModel.deleteValidateData(validateItemData, gVar);
                    ValidateActivity validateActivity = this.bnG;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.bnG;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    pVar2 = this.bnG.bnA;
                    h TE = pVar2.TE();
                    List<ValidateItemData> datas = TE.getDatas();
                    validateItemData2 = this.bnG.bnC;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (TE.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(TE.getDatas().get(0).getUserName()) + TbadkApplication.getInst().getApp().getApplicationContext().getString(y.validate_im_apply_prefix1) + TE.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(TE.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    TE.notifyDataSetChanged();
                    if (TE != null && TE.getDatas() != null && TE.getDatas().size() == 0) {
                        this.bnG.finish();
                    }
                }
            }
        }
    }
}
