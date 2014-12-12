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
    final /* synthetic */ ValidateActivity bot;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(i);
        this.bot = validateActivity;
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
        ValidateItemData hn;
        com.baidu.tieba.im.g gVar2;
        m mVar3;
        ValidateItemData hn2;
        com.baidu.tieba.im.g gVar3;
        m mVar4;
        mVar = this.bot.bon;
        mVar.setLoadProgressBarVisable(false);
        this.bot.boq = false;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 103111) {
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                if (socketResponsedMessage.getError() != 0) {
                    if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            this.bot.showToast(z.validate_fail);
                        } else {
                            this.bot.showToast(errorString);
                        }
                        hn2 = this.bot.hn(requestAddGroupUserMessage.getNotice_id());
                        if (hn2 != null) {
                            hn2.setPass(false);
                            hn2.setShown(true);
                            gVar3 = this.bot.boo;
                            ValidateModel.updateValidateData(gVar3, hn2);
                            mVar4 = this.bot.bon;
                            mVar4.Tn().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                hn = this.bot.hn(requestAddGroupUserMessage.getNotice_id());
                if (hn != null) {
                    hn.setPass(true);
                    hn.setShown(true);
                    gVar2 = this.bot.boo;
                    ValidateModel.updateValidateData(gVar2, hn);
                    if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                        this.bot.showToast(z.validate_succ);
                    } else {
                        this.bot.showToast(socketResponsedMessage.getErrorString());
                    }
                    mVar3 = this.bot.bon;
                    mVar3.Tn().notifyDataSetChanged();
                }
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    validateItemData = this.bot.bop;
                    gVar = this.bot.boo;
                    ValidateModel.deleteValidateData(validateItemData, gVar);
                    ValidateActivity validateActivity = this.bot;
                    i = validateActivity.offset;
                    validateActivity.offset = i - 1;
                    ValidateActivity validateActivity2 = this.bot;
                    i2 = validateActivity2.totalCount;
                    validateActivity2.totalCount = i2 - 1;
                    mVar2 = this.bot.bon;
                    h Tn = mVar2.Tn();
                    List<ValidateItemData> datas = Tn.getDatas();
                    validateItemData2 = this.bot.bop;
                    datas.remove(validateItemData2);
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    if (Tn.getDatas().size() > 0) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setLast_content(String.valueOf(Tn.getDatas().get(0).getUserName()) + TbadkApplication.getInst().getApp().getApplicationContext().getString(z.validate_im_apply_prefix1) + Tn.getDatas().get(0).getGroupName());
                        imMessageCenterPojo2.setLast_content_time(Tn.getDatas().get(0).getApplyTime());
                        imMessageCenterPojo = imMessageCenterPojo2;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001217, imMessageCenterPojo));
                    Tn.notifyDataSetChanged();
                    if (Tn != null && Tn.getDatas() != null && Tn.getDatas().size() == 0) {
                        this.bot.finish();
                    }
                }
            }
        }
    }
}
