package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity dsq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.dsq = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void azl() {
        this.dsq.azj();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.dsq.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void azm() {
        this.dsq.ba("group", this.dsq.getPageContext().getString(n.j.privacy_setting_attention_group));
        TiebaStatic.log("c10652");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void azn() {
        this.dsq.ba("post", this.dsq.getPageContext().getString(n.j.privacy_setting_attention_forum));
        TiebaStatic.log("c10651");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void azo() {
        this.dsq.ba("like", this.dsq.getPageContext().getString(n.j.privacy_setting_attention_bar));
        TiebaStatic.log("c10648");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void azp() {
        this.dsq.azk();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.dsq.ah("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.dsq.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.dsq.dsh;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.dsq.dsh;
                if (!voiceCheckResult2.aFC()) {
                    this.dsq.azh();
                    this.dsq.azg();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void azq() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.dsq.dsh;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.dsq.dsh;
            if (!voiceCheckResult2.aFC()) {
                return;
            }
            this.dsq.azh();
        }
    }
}
