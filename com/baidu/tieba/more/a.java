package com.baidu.tieba.more;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
class a implements r {
    final /* synthetic */ AboutActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.r
    public void a(int i) {
        String str;
        if (i == 0) {
            this.a.finish();
        } else if (i != 1) {
            if (i == 2) {
                this.a.sendMessage(new CustomMessage(2015000, new com.baidu.tbadk.core.atomData.z(this.a).a("from_about_page")));
            } else if (i == 3) {
                com.baidu.tbadk.core.sharedPref.b.a().b(SettingTextFunctionIntroView.f, true);
                AboutActivity aboutActivity = this.a;
                String string = this.a.getString(com.baidu.tieba.x.setting_funtion_intro);
                str = this.a.d;
                TbWebViewActivity.startActivity(aboutActivity, string, str);
            }
        } else {
            this.a.a();
        }
    }
}
