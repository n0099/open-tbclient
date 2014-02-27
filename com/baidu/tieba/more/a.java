package com.baidu.tieba.more;

import com.baidu.tieba.GuideActivity;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class a implements ab {
    final /* synthetic */ AboutActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.ab
    public final void a(int i) {
        String str;
        if (i == 0) {
            this.a.finish();
        } else if (i == 1) {
            AboutActivity.b(this.a);
        } else if (i == 2) {
            GuideActivity.a(this.a, "from_about_page");
        } else if (i == 3) {
            com.baidu.tieba.sharedPref.b.a().b(SettingTextFunctionIntroView.a, true);
            AboutActivity aboutActivity = this.a;
            String string = this.a.getString(R.string.setting_funtion_intro);
            str = this.a.d;
            TbWebViewActivity.b(aboutActivity, string, str);
        }
    }
}
