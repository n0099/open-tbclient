package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ r djM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.djM = rVar;
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
                personalTalkSettingActivity = this.djM.djK;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.djM.djK;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.djM.isAttention = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.djM.djK;
            if (personalTalkSettingActivity3 != null) {
                z = this.djM.isAttention;
                if (z) {
                    personalTalkSettingActivity5 = this.djM.djK;
                    personalTalkSettingActivity5.showToast(w.l.add_black_success);
                } else {
                    personalTalkSettingActivity4 = this.djM.djK;
                    personalTalkSettingActivity4.showToast(w.l.remove_succ);
                }
            }
            aVar = this.djM.djL;
            if (aVar != null) {
                aVar2 = this.djM.djL;
                aVar2.wy();
            }
        }
    }
}
