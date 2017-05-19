package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
import protobuf.QueryUserInfos.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ r deF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.deF = rVar;
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
                        personalTalkSettingActivity4 = this.deF.deD;
                        personalTalkSettingActivity4.closeLoadingDialog();
                        if (socketResponsedMessage.getError() != 0) {
                            personalTalkSettingActivity5 = this.deF.deD;
                            personalTalkSettingActivity5.showToast(socketResponsedMessage.getErrorString());
                        }
                    }
                    if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                        if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                this.deF.deA = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                aVar3 = this.deF.deE;
                                if (aVar3 != null) {
                                    aVar4 = this.deF.deE;
                                    aVar4.wh();
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
                        personalTalkSettingActivity2 = this.deF.deD;
                        personalTalkSettingActivity2.hideProgressBar();
                        personalTalkSettingActivity3 = this.deF.deD;
                        personalTalkSettingActivity3.showToast(socketResponsedMessage.getErrorString());
                        return;
                    } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                        if (responseQueryUserInfoMessage.getResData() != null) {
                            this.deF.data = responseQueryUserInfoMessage.getResData();
                            r rVar = this.deF;
                            dataRes = this.deF.data;
                            rVar.isAttention = dataRes.hasConcerned.intValue() == 1;
                            r rVar2 = this.deF;
                            dataRes2 = this.deF.data;
                            rVar2.deA = dataRes2.isBlacklist.intValue() == 1;
                            personalTalkSettingActivity = this.deF.deD;
                            personalTalkSettingActivity.hideProgressBar();
                            aVar = this.deF.deE;
                            if (aVar != null) {
                                aVar2 = this.deF.deE;
                                aVar2.wh();
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
