package com.baidu.tieba.more;

import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.GuideActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ac {
    final /* synthetic */ AboutActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        String str;
        if (i == 0) {
            this.a.finish();
        } else if (i == 1) {
            this.a.a();
        } else if (i == 2) {
            GuideActivity.a(this.a, "from_about_page");
        } else if (i == 3) {
            com.baidu.tieba.sharedPref.b.a().b(SettingTextFunctionIntroView.a, true);
            AboutActivity aboutActivity = this.a;
            String string = this.a.getString(R.string.setting_funtion_intro);
            str = this.a.d;
            CommonWebviewActivity.a(aboutActivity, string, str, true);
        }
    }
}
