package com.baidu.tieba.more;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
/* loaded from: classes.dex */
class a implements q {
    final /* synthetic */ AboutActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    @Override // com.baidu.tieba.more.q
    public void gS(int i) {
        String str;
        if (i == 0) {
            this.this$0.finish();
        } else if (i != 1) {
            if (i == 2) {
                this.this$0.sendMessage(new CustomMessage(2015000, new GuildActivityConfig(this.this$0.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE)));
            } else if (i == 3) {
                com.baidu.tbadk.core.sharedPref.b.oc().putBoolean(SettingTextFunctionIntroView.bxW, true);
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = this.this$0.getPageContext().getPageActivity();
                String string = this.this$0.getPageContext().getString(com.baidu.tieba.z.setting_funtion_intro);
                str = this.this$0.buR;
                messageManager.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(pageActivity, string, str, true, true, false, false, false)));
            }
        } else {
            this.this$0.checkUpdata();
        }
    }
}
