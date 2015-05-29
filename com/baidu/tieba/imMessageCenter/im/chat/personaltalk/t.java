package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ s bsN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.bsN = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        DataRes dataRes;
        DataRes dataRes2;
        PersonalTalkSettingActivity personalTalkSettingActivity;
        x xVar;
        x xVar2;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        x xVar3;
        x xVar4;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 104102:
                    if (socketResponsedMessage instanceof ResponsedMessage) {
                        personalTalkSettingActivity4 = this.bsN.bsL;
                        personalTalkSettingActivity4.closeLoadingDialog();
                        if (socketResponsedMessage.getError() != 0) {
                            personalTalkSettingActivity5 = this.bsN.bsL;
                            personalTalkSettingActivity5.showToast(socketResponsedMessage.getErrorString());
                        }
                    }
                    if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                        if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                this.bsN.bsI = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                xVar3 = this.bsN.bsM;
                                if (xVar3 != null) {
                                    xVar4 = this.bsN.bsM;
                                    xVar4.uv();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 205003:
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                        personalTalkSettingActivity2 = this.bsN.bsL;
                        personalTalkSettingActivity2.hideProgressBar();
                        personalTalkSettingActivity3 = this.bsN.bsL;
                        personalTalkSettingActivity3.showToast(socketResponsedMessage.getErrorString());
                        return;
                    } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                        if (responseQueryUserInfoMessage.getResData() != null) {
                            this.bsN.data = responseQueryUserInfoMessage.getResData();
                            s sVar = this.bsN;
                            dataRes = this.bsN.data;
                            sVar.acr = dataRes.hasConcerned.intValue() == 1;
                            s sVar2 = this.bsN;
                            dataRes2 = this.bsN.data;
                            sVar2.bsI = dataRes2.isBlacklist.intValue() == 1;
                            personalTalkSettingActivity = this.bsN.bsL;
                            personalTalkSettingActivity.hideProgressBar();
                            xVar = this.bsN.bsM;
                            if (xVar != null) {
                                xVar2 = this.bsN.bsM;
                                xVar2.uv();
                                return;
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
