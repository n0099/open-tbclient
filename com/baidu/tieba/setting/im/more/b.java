package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity bZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.bZE = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void agq() {
        this.bZE.agp();
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void onBackPressed() {
        this.bZE.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void agr() {
        this.bZE.aT("group", this.bZE.getPageContext().getString(y.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void ags() {
        this.bZE.aT("post", this.bZE.getPageContext().getString(y.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void agt() {
        this.bZE.aT("like", this.bZE.getPageContext().getString(y.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.bZE.S("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.bZE.showProgressBar();
    }
}
