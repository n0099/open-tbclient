package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ SecretSettingActivity cvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SecretSettingActivity secretSettingActivity, int i) {
        super(i);
        this.cvA = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001325 && (customResponsedMessage.getData() instanceof VoiceCheckResult)) {
            VoiceCheckResult voiceCheckResult = (VoiceCheckResult) customResponsedMessage.getData();
            if (voiceCheckResult.aqe() == VoiceCheckResult.ResultCode.SUCCESS) {
                this.cvA.cvq = voiceCheckResult;
                if (voiceCheckResult.aqf()) {
                    iVar2 = this.cvA.cvn;
                    iVar2.eV(true);
                    return;
                }
                iVar = this.cvA.cvn;
                iVar.eV(false);
            }
        }
    }
}
