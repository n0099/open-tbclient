package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity cLw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cLw = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void ara() {
        this.cLw.aqY();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.cLw.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arb() {
        this.cLw.bc("group", this.cLw.getPageContext().getString(i.h.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arc() {
        this.cLw.bc("post", this.cLw.getPageContext().getString(i.h.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void ard() {
        this.cLw.bc("like", this.cLw.getPageContext().getString(i.h.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void are() {
        this.cLw.aqZ();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.cLw.ab("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cLw.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cLw.cLm;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cLw.cLm;
                if (!voiceCheckResult2.awO()) {
                    this.cLw.aqW();
                    this.cLw.aqV();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arf() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cLw.cLm;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cLw.cLm;
            if (!voiceCheckResult2.awO()) {
                return;
            }
            this.cLw.aqW();
        }
    }
}
