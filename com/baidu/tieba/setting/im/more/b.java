package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity eaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.eaO = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aNc() {
        this.eaO.aNa();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.eaO.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aNd() {
        this.eaO.bA("group", this.eaO.getPageContext().getString(t.j.privacy_setting_attention_group));
        TiebaStatic.log("c10652");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aNe() {
        this.eaO.bA("post", this.eaO.getPageContext().getString(t.j.privacy_setting_attention_forum));
        TiebaStatic.log("c10651");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aNf() {
        this.eaO.bA("like", this.eaO.getPageContext().getString(t.j.privacy_setting_attention_bar));
        TiebaStatic.log("c10648");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aNg() {
        this.eaO.aNb();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.eaO.ar("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.eaO.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.eaO.eaF;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.eaO.eaF;
                if (!voiceCheckResult2.aTH()) {
                    this.eaO.aMY();
                    this.eaO.aMX();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aNh() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.eaO.eaF;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.eaO.eaF;
            if (!voiceCheckResult2.aTH()) {
                return;
            }
            this.eaO.aMY();
        }
    }
}
