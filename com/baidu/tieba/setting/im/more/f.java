package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ SecretSettingActivity dIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SecretSettingActivity secretSettingActivity, int i) {
        super(i);
        this.dIu = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001325 && (customResponsedMessage.getData() instanceof VoiceCheckResult)) {
            VoiceCheckResult voiceCheckResult = (VoiceCheckResult) customResponsedMessage.getData();
            if (voiceCheckResult.aMG() == VoiceCheckResult.ResultCode.SUCCESS) {
                this.dIu.dIl = voiceCheckResult;
                if (voiceCheckResult.aMH()) {
                    iVar2 = this.dIu.dIi;
                    iVar2.hs(true);
                    return;
                }
                iVar = this.dIu.dIi;
                iVar.hs(false);
            }
        }
    }
}
