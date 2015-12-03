package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity dlj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.dlj = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void axe() {
        this.dlj.axc();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.dlj.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void axf() {
        this.dlj.be("group", this.dlj.getPageContext().getString(n.i.privacy_setting_attention_group));
        TiebaStatic.log("c10652");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void axg() {
        this.dlj.be("post", this.dlj.getPageContext().getString(n.i.privacy_setting_attention_forum));
        TiebaStatic.log("c10651");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void axh() {
        this.dlj.be("like", this.dlj.getPageContext().getString(n.i.privacy_setting_attention_bar));
        TiebaStatic.log("c10648");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void axi() {
        this.dlj.axd();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.dlj.ag("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.dlj.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.dlj.dkZ;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.dlj.dkZ;
                if (!voiceCheckResult2.aDp()) {
                    this.dlj.axa();
                    this.dlj.awZ();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void axj() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.dlj.dkZ;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.dlj.dkZ;
            if (!voiceCheckResult2.aDp()) {
                return;
            }
            this.dlj.axa();
        }
    }
}
