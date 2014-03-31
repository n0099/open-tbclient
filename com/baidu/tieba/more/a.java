package com.baidu.tieba.more;

import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
final class a implements p {
    final /* synthetic */ AboutActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.p
    public final void a(int i) {
        String str;
        if (i == 0) {
            this.a.finish();
        } else if (i == 1) {
            AboutActivity.b(this.a);
        } else if (i == 2) {
            this.a.sendMessage(new com.baidu.adp.framework.message.a(2015000, new com.baidu.tbadk.core.b.p(this.a).a("from_about_page")));
        } else if (i == 3) {
            com.baidu.tbadk.core.sharedPref.b.a().b(SettingTextFunctionIntroView.f, true);
            AboutActivity aboutActivity = this.a;
            String string = this.a.getString(com.baidu.tieba.a.k.setting_funtion_intro);
            str = this.a.d;
            TbWebViewActivity.b(aboutActivity, string, str);
        }
    }
}
