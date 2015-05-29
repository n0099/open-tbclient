package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ s bsN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(s sVar, int i) {
        super(i);
        this.bsN = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        x xVar;
        x xVar2;
        boolean z;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (!updateAttentionMessage.isSucc()) {
                personalTalkSettingActivity = this.bsN.bsL;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.bsN.bsL;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.bsN.acr = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.bsN.bsL;
            if (personalTalkSettingActivity3 != null) {
                z = this.bsN.acr;
                if (z) {
                    personalTalkSettingActivity5 = this.bsN.bsL;
                    personalTalkSettingActivity5.showToast(com.baidu.tieba.t.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.bsN.bsL;
                    personalTalkSettingActivity4.showToast(com.baidu.tieba.t.remove_succ);
                }
            }
            xVar = this.bsN.bsM;
            if (xVar != null) {
                xVar2 = this.bsN.bsM;
                xVar2.uv();
            }
        }
    }
}
