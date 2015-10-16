package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ r bKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.bKD = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        r.a aVar;
        r.a aVar2;
        boolean z;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (!updateAttentionMessage.isSucc()) {
                personalTalkSettingActivity = this.bKD.bKB;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.bKD.bKB;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.bKD.agI = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.bKD.bKB;
            if (personalTalkSettingActivity3 != null) {
                z = this.bKD.agI;
                if (z) {
                    personalTalkSettingActivity5 = this.bKD.bKB;
                    personalTalkSettingActivity5.showToast(i.h.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.bKD.bKB;
                    personalTalkSettingActivity4.showToast(i.h.remove_succ);
                }
            }
            aVar = this.bKD.bKC;
            if (aVar != null) {
                aVar2 = this.bKD.bKC;
                aVar2.vw();
            }
        }
    }
}
