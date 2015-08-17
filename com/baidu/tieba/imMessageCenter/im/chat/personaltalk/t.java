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
    final /* synthetic */ r bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.bGG = rVar;
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
                personalTalkSettingActivity = this.bGG.bGE;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.bGG.bGE;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.bGG.ahB = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.bGG.bGE;
            if (personalTalkSettingActivity3 != null) {
                z = this.bGG.ahB;
                if (z) {
                    personalTalkSettingActivity5 = this.bGG.bGE;
                    personalTalkSettingActivity5.showToast(i.C0057i.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.bGG.bGE;
                    personalTalkSettingActivity4.showToast(i.C0057i.remove_succ);
                }
            }
            aVar = this.bGG.bGF;
            if (aVar != null) {
                aVar2 = this.bGG.bGF;
                aVar2.vz();
            }
        }
    }
}
