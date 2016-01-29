package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ SecretSettingActivity dIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.dIu = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aGs() {
        this.dIu.aGq();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void onBackPressed() {
        this.dIu.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aGt() {
        this.dIu.bk("group", this.dIu.getPageContext().getString(t.j.privacy_setting_attention_group));
        TiebaStatic.log("c10652");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aGu() {
        this.dIu.bk("post", this.dIu.getPageContext().getString(t.j.privacy_setting_attention_forum));
        TiebaStatic.log("c10651");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aGv() {
        this.dIu.bk("like", this.dIu.getPageContext().getString(t.j.privacy_setting_attention_bar));
        TiebaStatic.log("c10648");
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aGw() {
        this.dIu.aGr();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void a(BdSwitchView.SwitchState switchState) {
        this.dIu.aj("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.dIu.showProgressBar();
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void b(BdSwitchView.SwitchState switchState) {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        if (z) {
            voiceCheckResult = this.dIu.dIl;
            if (voiceCheckResult != null) {
                voiceCheckResult2 = this.dIu.dIl;
                if (!voiceCheckResult2.aMH()) {
                    this.dIu.aGo();
                    this.dIu.aGn();
                    return;
                }
            }
        }
        TbadkCoreApplication.m411getInst().setVoiceLoginOn(z);
    }

    @Override // com.baidu.tieba.setting.im.more.i.a
    public void aGx() {
        VoiceCheckResult voiceCheckResult;
        VoiceCheckResult voiceCheckResult2;
        voiceCheckResult = this.dIu.dIl;
        if (voiceCheckResult != null) {
            voiceCheckResult2 = this.dIu.dIl;
            if (!voiceCheckResult2.aMH()) {
                return;
            }
            this.dIu.aGo();
        }
    }
}
