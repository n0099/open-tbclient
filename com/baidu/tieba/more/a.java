package com.baidu.tieba.more;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
/* loaded from: classes.dex */
class a implements r {
    final /* synthetic */ AboutActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    @Override // com.baidu.tieba.more.r
    public void gF(int i) {
        String str;
        if (i == 0) {
            this.this$0.finish();
        } else if (i != 1) {
            if (i == 2) {
                this.this$0.sendMessage(new CustomMessage(2015000, new GuildActivityConfig(this.this$0).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE)));
            } else if (i == 3) {
                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean(SettingTextFunctionIntroView.bsP, true);
                AboutActivity aboutActivity = this.this$0;
                String string = this.this$0.getString(com.baidu.tieba.y.setting_funtion_intro);
                str = this.this$0.bqh;
                TbWebViewActivity.startActivity(aboutActivity, string, str);
            }
        } else {
            this.this$0.checkUpdata();
        }
    }
}
