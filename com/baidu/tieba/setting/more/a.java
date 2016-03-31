package com.baidu.tieba.setting.more;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDebugerListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements s {
    final /* synthetic */ AboutActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    @Override // com.baidu.tieba.setting.more.s
    public void oN(int i) {
        String str;
        if (i == 0) {
            this.this$0.finish();
        } else if (i != 1) {
            if (i == 2) {
                this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(this.this$0.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
            } else if (i == 3) {
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean(at.eet, true);
                Activity pageActivity = this.this$0.getPageContext().getPageActivity();
                String string = this.this$0.getPageContext().getString(t.j.setting_funtion_intro);
                str = this.this$0.ebC;
                com.baidu.tbadk.browser.f.a(pageActivity, string, str, true, false, false);
            } else if (i == 4) {
                this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_TRAFFICS_STATS, new IntentConfig(this.this$0.getPageContext().getPageActivity())));
            } else if (i == 5) {
                this.this$0.showToast(this.this$0.getResources().getString(t.j.setting_plugin_debug_on));
            } else if (i == 6) {
                this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDebugerListActivityConfig(this.this$0.getPageContext().getPageActivity())));
            }
        } else {
            this.this$0.checkUpdata();
        }
    }
}
