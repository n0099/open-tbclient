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
    final /* synthetic */ r bKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.bKY = rVar;
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
                personalTalkSettingActivity = this.bKY.bKW;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.bKY.bKW;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.bKY.agO = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.bKY.bKW;
            if (personalTalkSettingActivity3 != null) {
                z = this.bKY.agO;
                if (z) {
                    personalTalkSettingActivity5 = this.bKY.bKW;
                    personalTalkSettingActivity5.showToast(i.h.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.bKY.bKW;
                    personalTalkSettingActivity4.showToast(i.h.remove_succ);
                }
            }
            aVar = this.bKY.bKX;
            if (aVar != null) {
                aVar2 = this.bKY.bKX;
                aVar2.vx();
            }
        }
    }
}
