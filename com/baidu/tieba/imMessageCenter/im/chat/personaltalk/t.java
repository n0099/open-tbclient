package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ r cuf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.cuf = rVar;
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
                personalTalkSettingActivity = this.cuf.cud;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.cuf.cud;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.cuf.agz = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.cuf.cud;
            if (personalTalkSettingActivity3 != null) {
                z = this.cuf.agz;
                if (z) {
                    personalTalkSettingActivity5 = this.cuf.cud;
                    personalTalkSettingActivity5.showToast(t.j.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.cuf.cud;
                    personalTalkSettingActivity4.showToast(t.j.remove_succ);
                }
            }
            aVar = this.cuf.cue;
            if (aVar != null) {
                aVar2 = this.cuf.cue;
                aVar2.uX();
            }
        }
    }
}
