package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity cDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cDW = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aoG() {
        this.cDW.aoE();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.cDW.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aoH() {
        this.cDW.bc("group", this.cDW.getPageContext().getString(i.h.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aoI() {
        this.cDW.bc("post", this.cDW.getPageContext().getString(i.h.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aoJ() {
        this.cDW.bc("like", this.cDW.getPageContext().getString(i.h.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aoK() {
        this.cDW.aoF();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.cDW.Z("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cDW.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cDW.cDM;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cDW.cDM;
                if (!voiceCheckResult2.aut()) {
                    this.cDW.aoC();
                    this.cDW.aoB();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aoL() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cDW.cDM;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cDW.cDM;
            if (!voiceCheckResult2.aut()) {
                return;
            }
            this.cDW.aoC();
        }
    }
}
