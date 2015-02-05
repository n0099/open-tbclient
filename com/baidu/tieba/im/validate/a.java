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
    final /* synthetic */ ValidateActivity bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.bpP = validateActivity;
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
        ValidateItemData hr;
        com.baidu.tieba.im.g gVar2;
        m mVar3;
        ValidateItemData hr2;
        com.baidu.tieba.im.g gVar3;
        m mVar4;
        mVar = this.bpP.bpJ;
        mVar.setLoadProgressBarVisable(false);
        this.bpP.bpM = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.bpP.showToast(z.validate_fail);
                        } else {
                            this.bpP.showToast(errorString);
                        }
                        hr2 = this.bpP.hr(requestAddGroupUserMessage.getNotice_id());
                        if (hr2 != null) {
                            hr2.setPass(false);
                            hr2.setShown(true);
                            gVar3 = this.bpP.bpK;
                            ValidateModel.updateValidateData(gVar3, hr2);
                            mVar4 = this.bpP.bpJ;
                            mVar4.TE().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                hr = this.bpP.hr(requestAddGroupUserMessage.getNotice_id());
                if (hr != null) {
                    hr.setPass(true);
                    hr.setShown(true);
                    gVar2 = this.bpP.bpK;
                    ValidateModel.updateValidateData(gVar2, hr);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.bpP.showToast(z.validate_succ);
                    } else {
                        this.bpP.showToast(socketResponsedMessage.getErrorString());
                    }
                    mVar3 = this.bpP.bpJ;
                    mVar3.TE().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.bpP.bpL;
                    gVar = this.bpP.bpK;
                    ValidateModel.deleteValidateData(validateItemData, gVar);
                    ValidateActivity validateActivity = this.bpP;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.bpP;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    mVar2 = this.bpP.bpJ;
                    h TE = mVar2.TE();
                    List<ValidateItemData> datas = TE.getDatas();
                    validateItemData2 = this.bpP.bpL;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (TE.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(TE.getDatas().get(0).getUserName()) + TbadkApplication.getInst().getApp().getApplicationContext().getString(z.validate_im_apply_prefix1) + TE.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(TE.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    TE.notifyDataSetChanged();
                    if (TE != null && TE.getDatas() != null && TE.getDatas().size() == 0) {
                        this.bpP.finish();
                    }
                }
            }
        }
    }
}
