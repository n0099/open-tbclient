package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ SecretSettingActivity cKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SecretSettingActivity secretSettingActivity, int i) {
        super(i);
        this.cKX = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001325 && (customResponsedMessage.getData() instanceof VoiceCheckResult)) {
            VoiceCheckResult voiceCheckResult = (VoiceCheckResult) customResponsedMessage.getData();
            if (voiceCheckResult.awH() == VoiceCheckResult.ResultCode.SUCCESS) {
                this.cKX.cKN = voiceCheckResult;
                if (voiceCheckResult.awI()) {
                    iVar2 = this.cKX.cKK;
                    iVar2.fR(true);
                    return;
                }
                iVar = this.cKX.cKK;
                iVar.fR(false);
            }
        }
    }
}
