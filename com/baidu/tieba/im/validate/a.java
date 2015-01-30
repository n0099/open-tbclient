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
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ValidateActivity bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.bpQ = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        m mVar;
        ValidateItemData validateItemData;
        com.baidu.tieba.im.g gVar;
        int i;
        int i2;
        m mVar2;
        ValidateItemData validateItemData2;
        ValidateItemData hu;
        com.baidu.tieba.im.g gVar2;
        m mVar3;
        ValidateItemData hu2;
        com.baidu.tieba.im.g gVar3;
        m mVar4;
        mVar = this.bpQ.bpK;
        mVar.setLoadProgressBarVisable(false);
        this.bpQ.bpN = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.bpQ.showToast(z.validate_fail);
                        } else {
                            this.bpQ.showToast(errorString);
                        }
                        hu2 = this.bpQ.hu(requestAddGroupUserMessage.getNotice_id());
                        if (hu2 != null) {
                            hu2.setPass(false);
                            hu2.setShown(true);
                            gVar3 = this.bpQ.bpL;
                            ValidateModel.updateValidateData(gVar3, hu2);
                            mVar4 = this.bpQ.bpK;
                            mVar4.TJ().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                hu = this.bpQ.hu(requestAddGroupUserMessage.getNotice_id());
                if (hu != null) {
                    hu.setPass(true);
                    hu.setShown(true);
                    gVar2 = this.bpQ.bpL;
                    ValidateModel.updateValidateData(gVar2, hu);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.bpQ.showToast(z.validate_succ);
                    } else {
                        this.bpQ.showToast(socketResponsedMessage.getErrorString());
                    }
                    mVar3 = this.bpQ.bpK;
                    mVar3.TJ().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.bpQ.bpM;
                    gVar = this.bpQ.bpL;
                    ValidateModel.deleteValidateData(validateItemData, gVar);
                    ValidateActivity validateActivity = this.bpQ;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.bpQ;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    mVar2 = this.bpQ.bpK;
                    h TJ = mVar2.TJ();
                    List<ValidateItemData> datas = TJ.getDatas();
                    validateItemData2 = this.bpQ.bpM;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (TJ.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(TJ.getDatas().get(0).getUserName()) + TbadkApplication.getInst().getApp().getApplicationContext().getString(z.validate_im_apply_prefix1) + TJ.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(TJ.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    TJ.notifyDataSetChanged();
                    if (TJ != null && TJ.getDatas() != null && TJ.getDatas().size() == 0) {
                        this.bpQ.finish();
                    }
                }
            }
        }
    }
}
