package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ s bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(s sVar, int i) {
        super(i);
        this.bqi = sVar;
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
                personalTalkSettingActivity = this.bqi.bqg;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.bqi.bqg;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.bqi.abn = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.bqi.bqg;
            if (personalTalkSettingActivity3 != null) {
                z = this.bqi.abn;
                if (z) {
                    personalTalkSettingActivity5 = this.bqi.bqg;
                    personalTalkSettingActivity5.showToast(com.baidu.tieba.y.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.bqi.bqg;
                    personalTalkSettingActivity4.showToast(com.baidu.tieba.y.remove_succ);
                }
            }
            xVar = this.bqi.bqh;
            if (xVar != null) {
                xVar2 = this.bqi.bqh;
                xVar2.tM();
            }
        }
    }
}
