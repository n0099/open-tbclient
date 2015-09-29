package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity cKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cKX = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aqY() {
        this.cKX.aqW();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.cKX.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aqZ() {
        this.cKX.bc("group", this.cKX.getPageContext().getString(i.h.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void ara() {
        this.cKX.bc("post", this.cKX.getPageContext().getString(i.h.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arb() {
        this.cKX.bc("like", this.cKX.getPageContext().getString(i.h.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arc() {
        this.cKX.aqX();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.cKX.ab("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cKX.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cKX.cKN;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cKX.cKN;
                if (!voiceCheckResult2.awI()) {
                    this.cKX.aqU();
                    this.cKX.aqT();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void ard() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cKX.cKN;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cKX.cKN;
            if (!voiceCheckResult2.awI()) {
                return;
            }
            this.cKX.aqU();
        }
    }
}
