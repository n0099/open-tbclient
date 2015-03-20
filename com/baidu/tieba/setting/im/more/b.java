package com.baidu.tieba.setting.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity bZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.bZp = secretSettingActivity;
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void agb() {
        this.bZp.aga();
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void onBackPressed() {
        this.bZp.finish();
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void agc() {
        this.bZp.aT("group", this.bZp.getPageContext().getString(y.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void agd() {
        this.bZp.aT("post", this.bZp.getPageContext().getString(y.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void age() {
        this.bZp.aT("like", this.bZp.getPageContext().getString(y.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.setting.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.bZp.S("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.bZp.showProgressBar();
    }
}
