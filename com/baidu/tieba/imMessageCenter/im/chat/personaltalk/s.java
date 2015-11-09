package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
import protobuf.QueryUserInfos.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ r bKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.bKY = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        DataRes dataRes;
        DataRes dataRes2;
        PersonalTalkSettingActivity personalTalkSettingActivity;
        r.a aVar;
        r.a aVar2;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        r.a aVar3;
        r.a aVar4;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 104102:
                    if (socketResponsedMessage instanceof ResponsedMessage) {
                        personalTalkSettingActivity4 = this.bKY.bKW;
                        personalTalkSettingActivity4.closeLoadingDialog();
                        if (socketResponsedMessage.getError() != 0) {
                            personalTalkSettingActivity5 = this.bKY.bKW;
                            personalTalkSettingActivity5.showToast(socketResponsedMessage.getErrorString());
                        }
                    }
                    if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                        if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                this.bKY.bKT = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                aVar3 = this.bKY.bKX;
                                if (aVar3 != null) {
                                    aVar4 = this.bKY.bKX;
                                    aVar4.vx();
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
                        personalTalkSettingActivity2 = this.bKY.bKW;
                        personalTalkSettingActivity2.hideProgressBar();
                        personalTalkSettingActivity3 = this.bKY.bKW;
                        personalTalkSettingActivity3.showToast(socketResponsedMessage.getErrorString());
                        return;
                    } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                        if (responseQueryUserInfoMessage.getResData() != null) {
                            this.bKY.data = responseQueryUserInfoMessage.getResData();
                            r rVar = this.bKY;
                            dataRes = this.bKY.data;
                            rVar.agO = dataRes.hasConcerned.intValue() == 1;
                            r rVar2 = this.bKY;
                            dataRes2 = this.bKY.data;
                            rVar2.bKT = dataRes2.isBlacklist.intValue() == 1;
                            personalTalkSettingActivity = this.bKY.bKW;
                            personalTalkSettingActivity.hideProgressBar();
                            aVar = this.bKY.bKX;
                            if (aVar != null) {
                                aVar2 = this.bKY.bKX;
                                aVar2.vx();
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
