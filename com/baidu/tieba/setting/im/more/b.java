package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity cMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cMS = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arG() {
        this.cMS.arE();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.cMS.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arH() {
        this.cMS.bb("group", this.cMS.getPageContext().getString(i.h.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arI() {
        this.cMS.bb("post", this.cMS.getPageContext().getString(i.h.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arJ() {
        this.cMS.bb("like", this.cMS.getPageContext().getString(i.h.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arK() {
        this.cMS.arF();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.cMS.ab("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cMS.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cMS.cMI;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cMS.cMI;
                if (!voiceCheckResult2.axE()) {
                    this.cMS.arC();
                    this.cMS.arB();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void arL() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cMS.cMI;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cMS.cMI;
            if (!voiceCheckResult2.axE()) {
                return;
            }
            this.cMS.arC();
        }
    }
}
