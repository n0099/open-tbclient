package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ SecretSettingActivity dlj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SecretSettingActivity secretSettingActivity, int i) {
        super(i);
        this.dlj = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001325 && (customResponsedMessage.getData() instanceof VoiceCheckResult)) {
            VoiceCheckResult voiceCheckResult = (VoiceCheckResult) customResponsedMessage.getData();
            if (voiceCheckResult.aDo() == VoiceCheckResult.ResultCode.SUCCESS) {
                this.dlj.dkZ = voiceCheckResult;
                if (voiceCheckResult.aDp()) {
                    iVar2 = this.dlj.dkW;
                    iVar2.gK(true);
                    return;
                }
                iVar = this.dlj.dkW;
                iVar.gK(false);
            }
        }
    }
}
