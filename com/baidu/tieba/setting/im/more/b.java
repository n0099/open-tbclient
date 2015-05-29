package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements l {
    final /* synthetic */ SecretSettingActivity cdW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cdW = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aii() {
        this.cdW.aih();
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void onBackPressed() {
        this.cdW.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aij() {
        this.cdW.aY("group", this.cdW.getPageContext().getString(t.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aik() {
        this.cdW.aY("post", this.cdW.getPageContext().getString(t.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void ail() {
        this.cdW.aY("like", this.cdW.getPageContext().getString(t.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void a(BdSwitchView.SwitchState switchState) {
        this.cdW.T("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cdW.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cdW.cdN;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cdW.cdN;
                if (!voiceCheckResult2.aoL()) {
                    this.cdW.aif();
                    this.cdW.aie();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.l
    public void aim() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cdW.cdN;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cdW.cdN;
            if (!voiceCheckResult2.aoL()) {
                return;
            }
            this.cdW.aif();
        }
    }
}
