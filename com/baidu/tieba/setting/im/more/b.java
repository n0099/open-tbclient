package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements l {
    final /* synthetic */ SecretSettingActivity cdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cdX = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aij() {
        this.cdX.aii();
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void onBackPressed() {
        this.cdX.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aik() {
        this.cdX.aY("group", this.cdX.getPageContext().getString(t.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void ail() {
        this.cdX.aY("post", this.cdX.getPageContext().getString(t.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aim() {
        this.cdX.aY("like", this.cdX.getPageContext().getString(t.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void a(BdSwitchView.SwitchState switchState) {
        this.cdX.T("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cdX.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cdX.cdO;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cdX.cdO;
                if (!voiceCheckResult2.aoM()) {
                    this.cdX.aig();
                    this.cdX.aif();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void ain() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cdX.cdO;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cdX.cdO;
            if (!voiceCheckResult2.aoM()) {
                return;
            }
            this.cdX.aig();
        }
    }
}
