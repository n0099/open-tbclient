package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity cvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.cvA = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void akz() {
        this.cvA.akx();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.cvA.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void akA() {
        this.cvA.aY("group", this.cvA.getPageContext().getString(i.C0057i.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void akB() {
        this.cvA.aY("post", this.cvA.getPageContext().getString(i.C0057i.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void akC() {
        this.cvA.aY("like", this.cvA.getPageContext().getString(i.C0057i.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void akD() {
        this.cvA.aky();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.cvA.X("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.cvA.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.cvA.cvq;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.cvA.cvq;
                if (!voiceCheckResult2.aqf()) {
                    this.cvA.akv();
                    this.cvA.aku();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void akE() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.cvA.cvq;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.cvA.cvq;
            if (!voiceCheckResult2.aqf()) {
                return;
            }
            this.cvA.akv();
        }
    }
}
