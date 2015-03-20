package com.baidu.tieba.setting.more;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
/* loaded from: classes.dex */
class a implements q {
    final /* synthetic */ AboutActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    @Override // com.baidu.tieba.setting.more.q
    public void hT(int i) {
        String str;
        if (i == 0) {
            this.this$0.finish();
        } else if (i != 1) {
            if (i == 2) {
                this.this$0.sendMessage(new CustomMessage(2015000, new GuildActivityConfig(this.this$0.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE)));
            } else if (i == 3) {
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean(SettingTextFunctionIntroView.cbU, true);
                Activity pageActivity = this.this$0.getPageContext().getPageActivity();
                String string = this.this$0.getPageContext().getString(com.baidu.tieba.y.setting_funtion_intro);
                str = this.this$0.bZL;
                com.baidu.tbadk.browser.f.a(pageActivity, string, str, true, false, false);
            } else if (i == 4) {
                this.this$0.sendMessage(new CustomMessage(2902050, new com.baidu.tbadk.core.frameworkData.a(this.this$0.getPageContext().getPageActivity())));
            }
        } else {
            this.this$0.checkUpdata();
        }
    }
}
